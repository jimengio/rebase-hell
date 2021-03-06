
(ns app.updater.repo )

(defn set-code [db op-data sid op-id op-time] (assoc-in db [:repo :code] op-data))

(defn set-current [db op-data sid op-id op-time] (assoc-in db [:repo :current] op-data))

(defn set-repo [db op-data sid op-id op-time]
  (update db :repo (fn [repo] (merge repo op-data))))

(defn set-upstream [db op-data sid op-id op-time]
  (-> db
      (assoc-in [:repo :upstream] (:upstream op-data))
      (assoc-in [:repo :host-kind] (:host-kind op-data))))
