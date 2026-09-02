"""
4. Estadísticas: calcular el promedio y la desviación estándar. En las aplicaciones comerciales,
a menudo se le pide que calcule el promedio y la desviación estándar de los datos. La
desviación estándar es una estadística que le indica cuán estrechamente se agrupan todos
los diversos datos alrededor de la media en un conjunto de datos. Por ejemplo, ¿cuál es la
edad promedio de los estudiantes en una clase? ¿Qué tan cerca están las edades? Si todos
los estudiantes tienen la misma edad, la desviación es 0. Utilice la siguiente fórmula:

       promedio = (sum_{i=1}^n x_i) / n
       desviacion = sqrt( (sum_{i=1}^n (x_i - promedio)^2) / (n - 1) )

Su programa debe contener los siguientes métodos:
    - promedio() obtiene el promedio de los valores en punto flotante
    - desviacion() devuelve la desviación estándar de los valores en punto flotante.

Escriba un programa que solicite al usuario ingresar 10 números, muestre el promedio y
las desviaciones estándar de estos números.
Ejemplo de entrada
1.9 2.5 3.7 2 1 6 3 4 5 2
Ejemplo de salida
El promedio es 3.11
La desviación estándar es 1.55738

Obtenga la solución en la Programación Modular-Estructura y luego en Programación
Orientada a Objetos, para ello dibuje el diagrama UML para la clase Estadistica y luego
implemente la clase. Agregue de forma escrita las ventajas de utilizar la P.O.O.
"""

import math


class Estadistica:

    def __init__(self, datos):
        self.__datos = [float(x) for x in datos]

    def promedio(self):
        if not self.__datos:
            return 0.0
        return sum(self.__datos) / len(self.__datos)

    def desviacion(self):
        n = len(self.__datos)
        if n <= 1:
            return 0.0

        prom = self.promedio()
        suma_cuadrados = sum((x - prom) ** 2 for x in self.__datos)
        return math.sqrt(suma_cuadrados / (n - 1))


if __name__ == "__main__":
    entrada = input("Ingrese 10 numeros: ").split()
    estadistica = Estadistica(entrada)

    prom = round(estadistica.promedio(), 2)
    desv = round(estadistica.desviacion(), 5)

    print(f"El promedio es {prom}")
    print(f"La desviación estándar es {desv}")