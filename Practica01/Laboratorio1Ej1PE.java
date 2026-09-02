/*
 * 4. Problemas asignados para entrega
 *
 * 1. Cronometro. Diseñe una clase llamada Cronometro. La clase contiene:
 *    a) Los atributos privados inicia y finaliza con metodos getter.
 *    b) Un constructor sin argumentos que inicializa inicia with la hora actual.
 *    c) Un metodo llamado inicia() que restablece inicia a la hora actual.
 *    d) Un metodo llamado detener() que establece finaliza a la hora actual.
 *    e) Un metodo llamado lapsoDeTiempo() que retorna el tiempo transcurrido del
 *       cronometro en milisegundos.
 *
 * Dibuje el diagrama UML de la clase e implementela. Escriba un programa de prueba
 * que mida el tiempo de ejecucion de la ordenacion de 100.000 numeros mediante la
 * ordenacion por seleccion.
 *
 * (Version estructurada: el cronometro se maneja con metodos estaticos y
 * variables sueltas en lugar de una clase con objetos.)
 */

import java.util.Random;

public class Laboratorio1Ej1PE {
    public static long cronometroIniciar() {
        return System.currentTimeMillis();
    }

    public static long cronometroDetener() {
        return System.currentTimeMillis();
    }

    public static long cronometroLapso(long inicio, long fin) {
        return fin - inicio;
    }

    public static void ordenamientoPorSeleccion(int[] lista) {
        int n = lista.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < n; j++) {
                if (lista[j] < lista[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            int temp = lista[i];
            lista[i] = lista[indiceMenor];
            lista[indiceMenor] = temp;
        }
    }

    public static void main(String[] args) {
        int cantidad = 100000;
        int[] numeros = new int[cantidad];
        Random rnd = new Random();
        for (int i = 0; i < cantidad; i++) {
            numeros[i] = rnd.nextInt(1000000);
        }

        long inicio = cronometroIniciar();
        ordenamientoPorSeleccion(numeros);
        long fin = cronometroDetener();

        System.out.println("Tiempo transcurrido: " + cronometroLapso(inicio, fin) + " ms");
    }
}