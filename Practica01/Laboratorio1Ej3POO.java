/*
 * 3. (Álgebra: Ecuaciones Cuadráticas) Diseñe la clase EcuacionLineal para la
 * ecuación cuadrática ax^2 + bx + c = 0. La clase contiene:
 * 
 *    a) Los atributos privados a, b y c, que representan a los 3 coeficientes.
 *    b) Un constructor para los argumentos para a, b y c.
 *    c) Un método getDiscriminante() que devuelve el discriminante b^2 - 4ac.
 *    d) Dos métodos getRaiz1() y getRaiz2() que retornan las dos raíces de la
 *       ecuación.
 * 
 *       r1 = (-b + sqrt(b^2 - 4ac)) / 2a      y      r2 = (-b - sqrt(b^2 - 4ac)) / 2a
 * 
 * Estos métodos solo son útiles si el discriminante es positivo. Si el discriminante
 * es negativo, devuelva 0.
 * Dibuje el diagrama UML de la clase e impleméntela. Escriba un programa de prueba
 * (Test) que solicite al usuario introducir los valores de a, b y c, y muestre el
 * resultado según el discriminante. Si el discriminante es positivo, muestre las dos
 * raíces. Si el discriminante es 0, muestre la única raíz. De lo contrario, muestre
 * "La ecuación no tiene raíces reales".
 * 
 * Ejemplo de entrada
 * Ingrese a, b, c: 1.0 3 1
 * Ingrese a, b, c: 1 2.0 1
 * Ingrese a, b, c: 1 2 3
 * 
 * Ejemplo de salida
 * La ecuacion tiene dos raices -0.381966 y -2.61803
 * La ecuacion tiene una raiz -1
 * La ecuacion no tiene raices reales
 */

import java.util.Locale;
import java.util.Scanner;

class EcuacionLineal {
    private double a;
    private double b;
    private double c;

    public EcuacionLineal(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminante() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public double getRaiz1() {
        double disc = getDiscriminante();
        if (disc < 0) {
            return 0;
        }
        return (-b + Math.sqrt(disc)) / (2 * a);
    }

    public double getRaiz2() {
        double disc = getDiscriminante();
        if (disc < 0) {
            return 0;
        }
        return (-b - Math.sqrt(disc)) / (2 * a);
    }
}

public class Laboratorio1Ej3POO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Ingrese a, b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        EcuacionLineal ecuacion = new EcuacionLineal(a, b, c);
        double discriminante = ecuacion.getDiscriminante();

        if (discriminante > 0) {
            System.out.printf(Locale.US, "La ecuacion tiene dos raices %.6f y %.6f%n", 
                              ecuacion.getRaiz1(), ecuacion.getRaiz2());
        } else if (discriminante == 0) {
            double r1 = ecuacion.getRaiz1();
            if (r1 == (long) r1) {
                System.out.println("La ecuacion tiene una raiz " + (long) r1);
            } else {
                System.out.println("La ecuacion tiene una raiz " + r1);
            }
        } else {
            System.out.println("La ecuacion no tiene raices reales");
        }

        sc.close();
    }
}