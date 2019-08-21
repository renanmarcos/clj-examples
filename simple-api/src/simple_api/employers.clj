(ns simple_api.employers)

(def employers-collection (atom []))

(defn get-employers []
    (str @employers-collection))

(defn get-employer [id]
    (str @employers-collection))

(defn add-employer [name job]
    (str @employers-collection))

(defn update-employer [id name job]
    (str @employers-collection))

(defn delete-employer [id]
    (str @employers-collection))