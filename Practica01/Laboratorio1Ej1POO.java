/*
 * 4. Problemas asignados para entrega
 *
 * 1. Cronometro. Diseñe una clase llamada Cronometro. La clase contiene:
 *    a) Los atributos privados inicia y finaliza con metodos getter.
 *    b) Un constructor sin argumentos que inicializa inicia con la hora actual.
 *    c) Un metodo llamado inicia() que restablece inicia a la hora actual.
 *    d) Un metodo llamado detener() que establece finaliza a la hora actual.
 *    e) Un metodo llamado lapsoDeTiempo() que retorna el tiempo transcurrido del
 *       cronometro en milisegundos.
 *
 * Dibuje el diagrama UML de la clase e implementela. Escriba un programa de prueba
 * que mida el tiempo de ejecucion de la ordenacion de 100.000 numeros mediante la
 * ordenacion por seleccion.
 */

import java.util.Random;

class Cronometro {
    private long inicia;
    private long finaliza;

    public Cronometro() {
        inicia = System.currentTimeMillis();
        finaliza = inicia;
    }

    public long getInicia() {
        return inicia;
    }

    public long getFinaliza() {
        return finaliza;
    }

    public void inicia() {
        inicia = System.currentTimeMillis();
    }

    public void detener() {
        finaliza = System.currentTimeMillis();
    }

    public long lapsoDeTiempo() {
        return finaliza - inicia;
    }
}

public class Laboratorio1Ej1POO {
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

        Cronometro cronometro = new Cronometro();
        cronometro.inicia();
        ordenamientoPorSeleccion(numeros);
        cronometro.detener();

        System.out.println("Tiempo transcurrido: " + cronometro.lapsoDeTiempo() + " ms");
    }
}