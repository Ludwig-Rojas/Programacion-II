"""
1. Cronometro. Diseñe una clase llamada Cronometro. La clase contiene:
   a) Los atributos privados inicia y finaliza con metodos getter.
   b) Un constructor sin argumentos que inicializa inicia con la hora actual.
   c) Un metodo llamado inicia() que restablece inicia a la hora actual.
   d) Un metodo llamado detener() que establece finaliza a la hora actual.
   e) Un metodo llamado lapsoDeTiempo() que retorna el tiempo transcurrido del
      cronometro en milisegundos.

Dibuje el diagrama UML de la clase e implementela. Escriba un programa de prueba
que mida el tiempo de ejecucion de la ordenacion de 100.000 numeros mediante la
ordenacion por seleccion.
"""

import random
import time


class Cronometro:

    def __init__(self):
        self.__inicia = time.time() * 1000
        self.__finaliza = self.__inicia

    def get_inicia(self):
        return self.__inicia

    def get_finaliza(self):
        return self.__finaliza

    def inicia(self):
        self.__inicia = time.time() * 1000

    def detener(self):
        self.__finaliza = time.time() * 1000

    def lapsoDeTiempo(self):
        return self.__finaliza - self.__inicia


def ordenamiento_por_seleccion(lista):
    n = len(lista)
    for i in range(n - 1):
        indice_menor = i
        for j in range(i + 1, n):
            if lista[j] < lista[indice_menor]:
                indice_menor = j
        lista[i], lista[indice_menor] = lista[indice_menor], lista[i]


if __name__ == "__main__":
    numeros = [random.randint(0, 1000000) for _ in range(100000)]

    cronometro = Cronometro()
    cronometro.inicia()

    ordenamiento_por_seleccion(numeros)

    cronometro.detener()

    print("Tiempo transcurrido:", cronometro.lapsoDeTiempo(), "ms")