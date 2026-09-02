/*
 * 4. Estadísticas: calcular el promedio y la desviación estándar.
 * Solución en Programación Modular-Estructurada (PE).
 */

import java.util.Locale;
import java.util.Scanner;

public class Laboratorio1Ej4PE {

    public static double promedio(double[] datos) {
        if (datos == null || datos.length == 0) {
            return 0.0;
        }
        double suma = 0;
        for (double x : datos) {
            suma += x;
        }
        return suma / datos.length;
    }

    public static double desviacion(double[] datos) {
        if (datos == null || datos.length <= 1) {
            return 0.0;
        }
        double prom = promedio(datos);
        double sumaCuadrados = 0;
        for (double x : datos) {
            sumaCuadrados += Math.pow(x - prom, 2);
        }
        return Math.sqrt(sumaCuadrados / (datos.length - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        double[] numeros = new double[10];
        System.out.print("Ingrese 10 numeros: ");
        for (int i = 0; i < 10; i++) {
            numeros[i] = sc.nextDouble();
        }

        System.out.printf(Locale.US, "El promedio es %.2f%n", promedio(numeros));
        System.out.printf(Locale.US, "La desviación estandard es %.5f%n", desviacion(numeros));

        sc.close();
    }
}