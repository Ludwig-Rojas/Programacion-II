/*
 * 4. Estadísticas: calcular el promedio y la desviación estándar. En las aplicaciones comerciales,
 * a menudo se le pide que calcule el promedio y la desviación estándar de los datos. La
 * desviación estándar es una estadística que le indica cuán estrechamente se agrupan todos
 * los diversos datos alrededor de la media en un conjunto de datos. Por ejemplo, ¿cuál es la
 * edad promedio de los estudiantes en una clase? ¿Qué tan cerca están las edades? Si todos
 * los estudiantes tienen la misma edad, la desviación es 0. Utilice la siguiente fórmula:
 * 
 *        promedio = (sum_{i=1}^n x_i) / n
 *        desviacion = sqrt( (sum_{i=1}^n (x_i - promedio)^2) / (n - 1) )
 * 
 * Su programa debe contener los siguientes métodos:
 *     - promedio() obtiene el promedio de los valores en punto flotante
 *     - desviacion() devuelve la desviación estándar de los valores en punto flotante.
 * 
 * Escriba un programa que solicite al usuario ingresar 10 números, muestre el promedio y
 * las desviaciones estándar de estos números.
 * Ejemplo de entrada
 * 1.9 2.5 3.7 2 1 6 3 4 5 2
 * Ejemplo de salida
 * El promedio es 3.11
 * La desviación estandard es 1.55738
 * 
 * Obtenga la solución en la Programación Modular-Estructura y luego en Programación
 * Orientada a Objetos, para ello dibuje el diagrama UML para la clase Estadistica y luego
 * implemente la clase. Agregue de forma escrita las ventajas de utilizar la P.O.O.
 */

import java.util.Locale;
import java.util.Scanner;

class Estadistica {
    private double[] datos;

    public Estadistica(double[] datos) {
        this.datos = datos;
    }

    public double promedio() {
        if (datos == null || datos.length == 0) {
            return 0.0;
        }
        double suma = 0;
        for (double x : datos) {
            suma += x;
        }
        return suma / datos.length;
    }

    public double desviacion() {
        if (datos == null || datos.length <= 1) {
            return 0.0;
        }
        double prom = promedio();
        double sumaCuadrados = 0;
        for (double x : datos) {
            sumaCuadrados += Math.pow(x - prom, 2);
        }
        return Math.sqrt(sumaCuadrados / (datos.length - 1));
    }
}

public class Laboratorio1Ej4POO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        double[] numeros = new double[10];
        System.out.print("Ingrese 10 numeros: ");
        for (int i = 0; i < 10; i++) {
            numeros[i] = sc.nextDouble();
        }

        Estadistica estadistica = new Estadistica(numeros);

        System.out.printf(Locale.US, "El promedio es %.2f%n", estadistica.promedio());
        System.out.printf(Locale.US, "La desviación estandard es %.5f%n", estadistica.desviacion());

        sc.close();
    }
}