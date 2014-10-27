    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5;

import java.util.Scanner;

/**
 *
 * @author Pedro Moreira
 */
public class ex3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Insira as medidas dos lados do triangulo ABC: ");
            double a = scan.nextDouble();
            double b = scan.nextDouble();
            double c = scan.nextDouble();

        if(a == 0 || b == 0 || c == 0) {
            System.out.print("Nenhum dos lados do triângulo pode ser zero.");
        } else if(a+b <= c || a+c <= b || b+c <= a) {
            System.out.print("Não é possivel desenhar um triângulo com as medidas dadas.");
        } else {
            // Ang (a,b,c)
            double ab = calcularangulo(a,b,c);
            // Ang (a,c,b)
            double ac = calcularangulo(a,c,b);
            // Ang (b,c,a)
            double bc = calcularangulo(b,c,a);

            System.out.printf("Ângulo AB: %.3fº Ângulo AC: %.3fº Ângulo BC: %.3fº\n", ab, ac, bc);
        }
    }

    public static double calcularangulo(double a, double b, double c) {
        double angle = Math.toDegrees(Math.acos((a*a+b*b-c*c)/(2*a*b)));
        return angle;
    }
}
