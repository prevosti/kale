;;
;; (C) Copyright IBM Corp. 2016 All Rights Reserved.
;;

(ns kale.help
  (:require [kale.aliases :refer [commands]]
            [kale.common :refer [my-language fail get-options
                                 get-command-msg]]))

(defn get-msg
  "Return the corresponding help message"
   [msg-key & args]
   (apply get-command-msg :help-messages msg-key args))

(defn help
  "The help action. Defaults to English."
  [state [cmd what-str & args] flags]
  (if-let [what (if (some? what-str)
                  (commands what-str)
                  :help)]
    (do (get-options flags {})
        (get-msg what))
    (fail (get-msg :no-help-msg what-str))))
