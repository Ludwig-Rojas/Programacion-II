"""
4. Estadísticas: calcular el promedio y la desviación estándar.
Solución en Programación Modular-Estructurada (PE).
"""

import math


def promedio(datos):
    if not datos:
        return 0.0
    return sum(datos) / len(datos)


def desviacion(datos):
    n = len(datos)
    if n <= 1:
        return 0.0

    prom = promedio(datos)
    suma_cuadrados = sum((x - prom) ** 2 for x in datos)
    return math.sqrt(suma_cuadrados / (n - 1))


if __name__ == "__main__":
    entrada = input("Ingrese 10 numeros: ").split()
    numeros = [float(x) for x in entrada]

    prom = round(promedio(numeros), 2)
    desv = round(desviacion(numeros), 5)

    print(f"El promedio es {prom}")
    print(f"La desviación estándar es {desv}")