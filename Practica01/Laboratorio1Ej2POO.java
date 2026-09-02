/*
 * 2. Algebra: ecuacion lineal 2 x 2. Diseñe la clase EcuacionLineal para un
 * sistema de ecuaciones de 2 x 2.
 *
 *     ax + by = e
 *     cx + dy = f
 *
 *     x = (ed - bf) / (ad - bc)      y = (af - ec) / (ad - bc)
 *
 * La clase contiene:
 *    a) Los atributos privados a, b, c, d, e y f.
 *    b) Un constructor para los argumentos para a, b, c, d, e y f.
 *    c) Un metodo tieneSolucion() que devuelve true si ad - bc no es cero.
 *    d) Dos metodos getX() y getY() que retornan la solucion de la ecuacion.
 *
 * Dibuje el diagrama UML de la clase e implementela. Escriba un programa de
 * prueba (Test) que solicite al usuario ingresar a, b, c, d, e y f y muestre
 * el resultado. Si ad - bc es 0, indique que "La ecuacion no tiene solucion".
 */

import java.util.Scanner;

class EcuacionLineal {
    private double a, b, c, d, e, f;

    public EcuacionLineal(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public boolean tieneSolucion() {
        return (a * d - b * c) != 0;
    }

    public double getX() {
        return (e * d - b * f) / (a * d - b * c);
    }

    public double getY() {
        return (a * f - e * c) / (a * d - b * c);
    }
}

public class Laboratorio1Ej2POO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese a, b, c, d, e, f: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        double e = sc.nextDouble();
        double f = sc.nextDouble();

        EcuacionLineal ecuacion = new EcuacionLineal(a, b, c, d, e, f);

        if (ecuacion.tieneSolucion()) {
            System.out.println("x = " + ecuacion.getX() + ", y = " + ecuacion.getY());
        } else {
            System.out.println("La ecuacion no tiene solucion");
        }

        sc.close();
    }
}