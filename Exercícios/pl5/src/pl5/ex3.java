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
        // Inicialização do Scanner para ler os dados introduzidos pelo utilizador.
        Scanner scan = new Scanner(System.in);
        
        // Ler os primeiros 3 valores introduzidos pelo utilizador.
        System.out.print("Insira as medidas dos lados do triangulo ABC: ");
            double a = scan.nextDouble();
            double b = scan.nextDouble();
            double c = scan.nextDouble();

        // Se algum dos valores lidos for 0, o programa retorna o erro e para.
        if(a == 0 || b == 0 || c == 0) {
            System.out.print("Nenhum dos lados do triângulo pode ser zero.");
        // Senão se a soma de dois dos valores lidos for menor ou igual que o terceiro, o programa retorna erro e para.
        } else if(a+b <= c || a+c <= b || b+c <= a) {
            System.out.print("Não é possivel desenhar um triângulo com as medidas dadas.");
        // Senão se os valores passarem na validação calculamos o angulo chamando o método
        // desenvolvido anteriormente, passando os valores por ordem diferente.
        } else {
            // Ang (a,b,c)
            double ab = calcularangulo(a,b,c);
            // Ang (a,c,b)
            double ac = calcularangulo(a,c,b);
            // Ang (b,c,a)
            double bc = calcularangulo(b,c,a);

            // Apresentar ao utilizador o resultado formatando-o a 3 casas decimais por ângulo, usando o printf
            System.out.printf("Ângulo AB: %.3fº Ângulo AC: %.3fº Ângulo BC: %.3fº\n", ab, ac, bc);
        }
    }

    /**
     * Este método calcula o valor do angulo de um triangulo 
     * dados os 3 lados, através da seguinte equação:
     * 
     *              x^2 + y^2 - z^2 
     *    arc cos = _______________
     * 
     *                   2xy
     * 
     * Para tal usamos a Classe Math, a mesma pode ser consultada em:
     *  http://docs.oracle.com/javase/7/docs/api/java/lang/Math.html
     * 
     * Os métodos usados são:
     *      - Math.toDegrees();
     *      - Math.acos();
     *      - Math.pow();
     * 
     * Decidi não usar o Math.pow(); porque não justificava chamar um 
     * método para multiplicar uma variável por ela própria.
     * 
     * @param a
     * @param b
     * @param c
     * @return angle
     */
    public static double calcularangulo(double a, double b, double c) {
        // Calcula e retorna o valor do ângulo em graus.
        double angle = Math.toDegrees(Math.acos((a*a+b*b-c*c)/(2*a*b)));
        return angle;
    }
}
