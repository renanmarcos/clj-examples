(ns simple-api.employers-api-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [simple-api.handler :refer :all]))

(deftest app-test
  (testing "GET Employers"
    (let [response (app (mock/request :get "/employers"))]
      (is (= (:status response) 200))
      (is (= (:body response) "[]"))))

  (testing "POST Employers"
    (let [response (app (-> (mock/request :post "/employers")
                            (mock/json-body {:name "Renan" :job "SW"})))]
      (is (= (:status response) 201))
      (is (= (:body response) "{\"id\":1,\"name\":\"Renan\",\"job\":\"SW\"}"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404))
      (is (= (:body response) "Not Found")))))