"""
2. Algebra: ecuacion lineal 2 x 2. Diseñe la clase EcuacionLineal para un
sistema de ecuaciones de 2 x 2.

    ax + by = e
    cx + dy = f

    x = (ed - bf) / (ad - bc)      y = (af - ec) / (ad - bc)

La clase contiene:
   a) Los atributos privados a, b, c, d y f.
   b) Un constructor para los argumentos para a, b, c, d y f.
   c) Un metodo tieneSolucion() que devuelve true si ad - bc no es cero.
   d) Dos metodos getX() y getY() que retornan la solucion de la ecuacion.

Dibuje el diagrama UML de la clase e implementela. Escriba un programa de
prueba (Test) que solicite al usuario ingresar a, b, c, d, e y f y muestre el
resultado. Si ad - bc es 0, indique que "La ecuacion no tiene solucion".

Ejemplo de entrada
Ingrese a, b, c, d, e, f: 9.0 4.0 3.0 -5.0 -6.0 -21.0
Ingrese a, b, c, d, e, f: 1.0 2.0 2.0 4.0 4.0 5.0

Ejemplo de salida
x = -2.0, y = 3.0
La ecuacion no tiene solucion
"""


class EcuacionLineal:
    def __init__(self, a, b, c, d, e, f):
        self.__a = a
        self.__b = b
        self.__c = c
        self.__d = d
        self.__e = e
        self.__f = f

    def tieneSolucion(self):
        return (self.__a * self.__d - self.__b * self.__c) != 0

    def getX(self):
        a, b, c, d, e, f = self.__a, self.__b, self.__c, self.__d, self.__e, self.__f
        return (e * d - b * f) / (a * d - b * c)

    def getY(self):
        a, b, c, d, e, f = self.__a, self.__b, self.__c, self.__d, self.__e, self.__f
        return (a * f - e * c) / (a * d - b * c)


if __name__ == "__main__":
    datos = input("Ingrese a, b, c, d, e, f: ").split()
    a, b, c, d, e, f = (float(x) for x in datos)

    ecuacion = EcuacionLineal(a, b, c, d, e, f)

    if ecuacion.tieneSolucion():
        print(f"x = {ecuacion.getX()}, y = {ecuacion.getY()}")
    else:
        print("La ecuacion no tiene solucion")