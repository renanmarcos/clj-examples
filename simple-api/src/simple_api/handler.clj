(ns simple-api.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [ring.middleware.json :as json]
            [compojure.route :as route]
            [ring.util.response :refer [response]]
            [simple_api.employers :refer :all]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]))

(defroutes app-routes
  (GET "/employers" []
    (response (get-employers)))
  (GET "/employers/:id" [id]
      (response (get-employer (Integer/parseInt id))))
  (POST "/employers" {:keys [params]}
  (let [{:keys [name job]} params]
    (response (add-employer name job))))
  (PUT "/employers/:id" [id name job]
      (response (update-employer (Integer/parseInt id) name job)))
  (DELETE "/employers/:id" [id]
      (response (delete-employer (Integer/parseInt id))))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (json/wrap-json-params)
      (json/wrap-json-response)))
