/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl7;

import java.util.Scanner;

/**
 *
 * @author Pedro Moreira
 */
public class ex1 {

    public static Scanner scan = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n;
        do {
            System.out.print("Digite quantos números pretende ler: ");
            n = scan.nextInt();
            if (n < 1) {
                System.out.println("ERRO: Tem que ler pelo menos 1 número!");
            }
        } while (n < 1);

        int[] numeros = new int[n];

        lerNum(numeros, n);

        ordenarNum(numeros);

        int m;
        if (n != 1) {
            do {
                System.out.print("Digite quantos desses números quer mostrar como maiores: ");
                m = scan.nextInt();
                if (m < 1) {
                    System.out.println("ERRO: Tem que mostrar pelo menos 1 número!");
                }
                if (m > n) {
                    System.out.println("ERRO: Não pode mostrar mais números que aqueles que leu!");
                }
            } while (m < 1 || m > n);
        } else {
            m = 1;
        }
        mostrarNum(numeros, m);
    }

    public static void lerNum(int[] vec, int n) {
        if (n == 1) {
            System.out.print("Digite o número: ");
        } else {
            System.out.print("Digite todos os números: ");
        }
        for (int i = 0; i < n; i++) {
            vec[i] = scan.nextInt();
        }
    }

    public static void ordenarNum(int[] vec) {
        int aux;
        for (int i = 0; i < vec.length - 1; i++) {
            for (int j = i + 1; j < vec.length; j++) {
                if (vec[i] < vec[j]) {
                    aux = vec[i];
                    vec[i] = vec[j];
                    vec[j] = aux;
                }
            }
        }
    }

    public static void mostrarNum(int[] vec, int m) {
        if (m == 1) {
            System.out.print("O maior número é: ");
        } else {
            System.out.print("Os " + m + " primeiros maiores números são: ");
        }
        for (int i = 0; i < m; i++) {
            System.out.print(vec[i] + " ");
        }
    }
}
