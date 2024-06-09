(ns testing)

;Clojure guía 
;Autor: Kevin Castro

;Los temas aquí fueron se toman de Github y de la documentación oficial de Clojure
;Clojure es un lenguage de programación funcional que corre sobre la JVM, es un lenguaje dinámico y tiene una sintaxis sencilla y elegante.

;1. Sintaxis
;La sintaxis de Clojure es muy sencilla y elegante, se basa en listas y vectores, las listas se definen con paréntesis y los vectores con corchetes.

;Listas
(1 2 3 4 5)

;Vectores
[1 2 3 4 5]

;2. Funciones
;Las funciones en Clojure se definen con la palabra reservada defn, seguido del nombre de la función y los parámetros que recibe.
(defn suma [a b]
  (+ a b))

;Para llamar a una función se hace de la siguiente manera
(suma 2 3)

;Las funciones pueden no tener parámetros
(defn hola []
  "Hola mundo")

;O una cantidad variable de parámetros
(defn suma [a b & more]
  (reduce + more))


;Las funciones tambien pueden ser anónimas
((fn [a b] (+ a b)) 2 3)

;Una función anónima es una función que no tiene nombre, se define con la palabra reservada fn, seguido de los parámetros y el cuerpo de la función.

;3. Estructuras de datos
;Clojure tiene varias estructuras de datos, las más comunes son las listas, vectores, mapas y sets.

;Las listas son colecciones de elementos, se definen con paréntesis y pueden contener cualquier tipo de dato.
(1 2 3 4 5)

;Los vectores son colecciones de elementos, se definen con corchetes y pueden contener cualquier tipo de dato.
[1 2 3 4 5]

;La diferencia entre listas y vectores es que los vectores son más eficientes para acceder a un elemento en una posición específica.
;Pero las listas son más eficientes para agregar elementos al principio.

;Los mapas son colecciones de pares clave-valor, se definen con llaves y los pares clave-valor se separan con espacios.
{:nombre "Kevin" :edad 25 :ciudad "Lima"}

;Las llaves se definen con dos puntos y se pueden acceder a los valores de un mapa con la función get.

;(get <mapa> <clave>)

(get {:nombre "Kevin" :edad 25 :ciudad "Lima"} :nombre)

;Los sets son colecciones de elementos únicos, se definen con llaves y los elementos se separan con espacios.
#{1 2 3 4 5}

;4. Condicionales
;Antes de hablar de condicionales, se debe hablar de la verdad y la falsedad en Clojure.
;En Clojure, nil y false son considerados como falsos, y todo lo demás es considerado como verdadero. INCLUYENDO EL NÚMERO 0.

;IF
;If se define con la forma
; (if <condición> <expresión-true> <expresión-false>)
(if true "verdadero" "falso")

;WHEN
; WHEN es lo mismo que IF, pero solo tiene la rama verdadera.
(when true "verdadero")

;CASE
; CASE se define con la forma
; (case <expresión> <valor-1> <expresión-1> <valor-2> <expresión-2> ... <default>)
; Parecido a un switch en otros lenguajes
(case 1 1 "uno" 2 "dos" "otro")

;COND
; COND se define con la forma
; (cond
;   <condición-1> <expresión-1>
;   <condición-2> <expresión-2>
;   ...
;   :else <expresión-default>)
(cond
  (= 1 1) "uno"
  (= 2 2) "dos"
  :else "otro")

;5. Definiciones y asignaciones
;Las definiciones y asignaciones en Clojure se hacen con la palabra reservada def.
(def x 10)

;IMPORTANTE: En Clojure las variables son inmutables, una vez que se les asigna un valor, no se puede cambiar.
; Cuando se necesita cambiar el valor de una variable, se debe usar la función def.

; Definiciones locales (let)
; Para definir variables locales en Clojure se usa la función let.
(let [x 10
      y 20]
  (+ x y))

;6 Predicados
;Los predicados en Clojure son funciones que retornan verdadero o falso.

; = es un predicado que compara si dos valores son iguales.
(= 1 1) ; true
(= 1 2) ; false
(= 1 1 1 1 1 1 1 2 2 2 2) ; false


;Existen muchos otros predicados en Clojure, algunos de los más comunes son:
;nil? - verifica si un valor es nil
;true? - verifica si un valor es true
;false? - verifica si un valor es false
;odd? - verifica si un número es impar
;even? - verifica si un número es par
;pos? - verifica si un número es positivo
;neg? - verifica si un número es negativo
;zero? - verifica si un número es cero
;number? - verifica si un valor es un número

;ect...

;Los predicados se pueden combinar con condicionales para hacer decisiones en un programa.

(def x 10)

(if (pos? x)
  "positivo"
  "negativo")

;7. El API de Secuecias de clojure

;Clojure tiene un API de secuencias muy poderoso, que permite trabajar con listas, vectores, mapas y sets de una manera muy sencilla y elegante.

;La API de secuencias de Clojure se basa en las funciones de alto orden, que son funciones que toman otras funciones como argumentos.

;Las funciones de alto orden más comunes en Clojure son map, filter y reduce.

;MAP
;La función map toma una función y una secuencia, y aplica la función a cada elemento de la secuencia.
;(map <función> <secuencia>)

(map inc [1 2 3 4 5]) 
; Esto imprime (2 3 4 5 6)
; (inc) es una función que incrementa un número en 1

;FILTER
;La función filter toma una función y una secuencia, y retorna una nueva secuencia con los elementos que cumplen la condición de la función.
;(filter <función> <secuencia>)

(filter even? [1 2 3 4 5])
; Esto imprime (2 4)

;REDUCE
;La función reduce toma una función, una secuencia y un valor inicial, y aplica la función a cada elemento de la secuencia, acumulando el resultado en el valor inicial.
;(reduce <función> <valor-inicial> <secuencia>)
(reduce + 0 [1 2 3 4 5])
; El valor inicial se puede omitir, en ese caso se toma el primer elemento de la secuencia como valor inicial.

;Para sus buenas noticias, muchas de las funciones de la API de secuencias de Clojure son funciones de alto orden, lo que significa que se pueden combinar para hacer cosas más complejas.

(map (fn [x] (* x x)) (filter even? [1 2 3 4 5]))
; Esto imprime (4 16)
; ¿Qué hace este código?
; 1. Filtra los números pares de la secuencia [1 2 3 4 5]
; 2. Eleva al cuadrado cada número de la secuencia filtrada
; 3. Retorna la secuencia resultantes