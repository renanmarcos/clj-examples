(ns simple_api.employers)

;; Our atom collection
(def employers-collection (atom []))

;; Generate a new id
(defn new-id [] 
    (if (= (count @employers-collection) 0) 1
            (count @employers-collection)))

;; GET /employers
(defn get-employers [] @employers-collection)

;; GET /employers/:id
(defn get-employer [id] 
    (first 
        (filter #(= (:id %) id) @employers-collection)))

;; POST /employers
(defn add-employer [name job]
    (let [response {:name name :job job}]
        (swap! employers-collection conj {:id (new-id) :name name :job job})
        response))

;; PUT /employers/:id - TODO
(defn update-employer [id name job]
    (let [response {:id id :name name :job job}]
        response))

;; DELETE /employers/:id - TODO
(defn delete-employer [id]
    (swap! employers-collection #(remove (fn [x] (= (:id x) id)) @employers-collection)))