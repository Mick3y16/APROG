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
public class ex5 {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Insira a sua matriz.");
        int c;
        do {
            System.out.print("Digite o nº de colunas: ");
            c = scan.nextInt();
            if (c < 2) {
                System.out.println("A matriz deve de ser no minimo 2 coluna!");
            }
        } while (c < 2);
        int l;
        do {
            System.out.print("Digite o nº de linhas: ");
            l = scan.nextInt();
            if (l < 2) {
                System.out.println("A matriz deve de ser no minimo 2 linha!");
            }
        } while (l < 2);

        int[][] matriz = new int[l][c];

        System.out.println("Digite os elementos da matriz:");
        criarMatriz(matriz, l, c);

        mostrarMatriz(matriz, l, c);

        somaelemMatriz(matriz, l, c);
    }

    public static void somaelemMatriz(int[][] vec, int l, int c) {
        int k = 0, msoma = Integer.MIN_VALUE;
        int s = c * l;

        int[][] vecdados = new int[s][3];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                int soma = 0;
                for (int m = 0; m < l; m++) {
                    for (int n = 0; n < c; n++) {
                        if (m != i && n != j) {
                            soma += vec[m][n];
                        }
                    }
                }
                if (soma > msoma) {
                    k = 0;
                    msoma = soma;
                    vecdados[k][0] = vec[i][j];
                    vecdados[k][1] = i;
                    vecdados[k][2] = j;
                } else if (soma == msoma) {
                    k++;
                    vecdados[k][0] = vec[i][j];
                    vecdados[k][1] = i;
                    vecdados[k][2] = j;
                }
            }
        }
        int cont = 0;
        System.out.println("\nA maior soma é " + msoma + ":");
        while (cont <= k) {
            System.out.println("- Pode ser encontrada cortando a matriz pelo elemento " + vecdados[cont][0] + " que se encontra na " + (vecdados[cont][1]+1) + "ª linha e na " + (vecdados[cont][2]+1) + "ª coluna.");

            cont++;
        }
    }

    public static void mostrarMatriz(int[][] vec, int l, int c) {
        System.out.println("\nMatriz:");
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                System.out.printf("%3d",vec[i][j]);
            }
            System.out.println();
        }
    }

    public static void criarMatriz(int[][] vec, int l, int c) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                vec[i][j] = scan.nextInt();
            }
        }
    }

}
