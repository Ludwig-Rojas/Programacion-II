"""
3. (Álgebra: Ecuaciones Cuadráticas) Diseñe la clase EcuacionLineal para la
ecuación cuadrática ax^2 + bx + c = 0. La clase contiene:

   a) Los atributos privados a, b y c, que representan a los 3 coeficientes.
   b) Un constructor para los argumentos para a, b y c.
   c) Un método getDiscriminante() que devuelve el discriminante b^2 - 4ac.
   d) Dos métodos getRaiz1() y getRaiz2() que retornan las dos raíces de la
      ecuación.

      r1 = (-b + sqrt(b^2 - 4ac)) / 2a      y      r2 = (-b - sqrt(b^2 - 4ac)) / 2a

Estos métodos solo son útiles si el discriminante es positivo. Si el discriminante
es negativo, devuelva 0.
Dibuje el diagrama UML de la clase e impleméntela. Escriba un programa de prueba
(Test) que solicite al usuario introducir los valores de a, b y c, y muestre el
resultado según el discriminante. Si el discriminante es positivo, muestre las dos
raíces. Si el discriminante es 0, muestre la única raíz. De lo contrario, muestre
"La ecuación no tiene raíces reales".

Ejemplo de entrada
Ingrese a, b, c: 1.0 3 1
Ingrese a, b, c: 1 2.0 1
Ingrese a, b, c: 1 2 3

Ejemplo de salida
La ecuacion tiene dos raices -0.381966 y -2.61803
La ecuacion tiene una raiz -1
La ecuacion no tiene raices reales
"""

import math


class EcuacionLineal:

    def __init__(self, a, b, c):
        self.__a = float(a)
        self.__b = float(b)
        self.__c = float(c)

    def getDiscriminante(self):
        return self.__b**2 - 4 * self.__a * self.__c

    def getRaiz1(self):
        disc = self.getDiscriminante()
        if disc < 0:
            return 0
        return (-self.__b + math.sqrt(disc)) / (2 * self.__a)

    def getRaiz2(self):
        disc = self.getDiscriminante()
        if disc < 0:
            return 0
        return (-self.__b - math.sqrt(disc)) / (2 * self.__a)


if __name__ == "__main__":
    datos = input("Ingrese a, b, c: ").split()
    a, b, c = (float(x) for x in datos)

    ecuacion = EcuacionLineal(a, b, c)
    discriminante = ecuacion.getDiscriminante()

    if discriminante > 0:
        r1 = round(ecuacion.getRaiz1(), 6)
        r2 = round(ecuacion.getRaiz2(), 6)
        print(f"La ecuacion tiene dos raices {r1} y {r2}")
    elif discriminante == 0:
        r1 = int(ecuacion.getRaiz1()) if ecuacion.getRaiz1().is_integer() else ecuacion.getRaiz1()
        print(f"La ecuacion tiene una raiz {r1}")
    else:
        print("La ecuacion no tiene raices reales")