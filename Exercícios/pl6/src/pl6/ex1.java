
package pl6;

import java.util.Scanner;

/**
 *
 */
    
/* Este algoritmo tem como funcionalidade ler os primeiros dez valores
 * inteiros e guarda-los num vector. De seguida o método verifica cada um
 * dos valores em busca dos que são pares, quando encontrar um valor por faz
 * a soma do seu valor a uma variável e faz a sua contagem. No final caso
 * tenha sido encontrado pelo menos um par o algoritmo apresenta uma média.
 */
//public class Enigma
public class ex1 {

    public static void main(String[] args) {
        int i, s = 0, c = 0;
        int[] v = new int[10];
        Scanner ler = new Scanner(System.in);
        for (i = 0; i < v.length; i++) {
            v[i] = ler.nextInt();
        }
        for (i = 0; i < v.length; i++) {
            if (v[i] % 2 == 0) {
                s = s + v[i];
                c++;
            }
        }
        if (c != 0) {
            System.out.println(((double) s) / c);
        } else {
            System.out.println("Operação impossível de realizar");
        }

        menornum(v);
    }

    public static void menornum(int[] v) {
        int indice = 0, menor = v[0];

        for (int i = 1; i < v.length; i++) {
            if (v[i] < menor) {
                menor = v[i];
                indice = i;
            }
        }

        System.out.println("O menor número contido no vector é: " + menor + " e encontra na" + (indice + 1) + "ª posição.");
    }

}
