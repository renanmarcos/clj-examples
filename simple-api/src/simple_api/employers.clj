(ns simple_api.employers)

;; Our vector of atoms
(def employers-collection (atom []))
(def current-id (atom 0))

;; Generate a new id for our vector
(defn new-id! []
    (swap! current-id inc)
    @current-id)

;; GET /employers
(defn get-employers [] @employers-collection)

;; GET /employers/:id
(defn get-employer [id] 
    (some #(when (= (:id %) id) %) @employers-collection))

;; POST /employers
(defn add-employer! [name job]
    (let [response {:id (new-id!) :name name :job job}]
        (swap! employers-collection conj response)
        response))

;; PUT /employers/:id
(defn update-employer! [id name job]
    (let [response {:id id :name name :job job} 
          index (.indexOf @employers-collection (get-employer id))]
        (swap! employers-collection assoc-in [index :job] job)
        (swap! employers-collection assoc-in [index :name] name)
    response))

;; DELETE /employers/:id
(defn delete-employer! [id]
    (swap! employers-collection 
        (fn [current-atom] 
            (remove #(= (:id %) id) current-atom)))
    nil)