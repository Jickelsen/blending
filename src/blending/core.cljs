(ns blending.core
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

(defn setup []
  (q/frame-rate 30)
  ;; (q/no-smooth)
  ;; (q/hint :disable-depth-test)
  {})

(defn update-state [state]
  state)

(defn draw-state [state]
  (q/background 240)

  ;; Alpha is ignored when using :p3d
  (q/fill 0 255 0 100)
  (q/ellipse 100 100 100 100)

  ;; blend-color shows up as white regardless of rendering mode
  (q/fill (q/blend-color (q/color 255 0 0 255) (q/color 0 255 0 255) :subtract))
  (q/ellipse 250 250 100 100))

(q/defsketch blending
  :host "blending"
  :size [500 500]
  ; setup function called only once, during sketch initialization.
  :setup setup
  ; update-state is called on each iteration before draw-state.
  :update update-state
  :draw draw-state
  :renderer :p3d
  ; This sketch uses functional-mode middleware.
  ; Check quil wiki for more info about middlewares and particularly
  ; fun-mode.
  :middleware [m/fun-mode])
