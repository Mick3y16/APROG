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
public class ex4 {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Insira a sua matriz.");
        int c;
        do {
            System.out.print("Digite o nº de colunas: ");
            c = scan.nextInt();
            if (c < 1) {
                System.out.println("A matriz deve de ser no minimo 1 coluna!");
            }
        } while (c < 1);
        int l;
        do {
            System.out.print("Digite o nº de linhas: ");
            l = scan.nextInt();
            if (l < 1) {
                System.out.println("A matriz deve de ser no minimo 1 linha!");
            }
        } while (l < 1);

        int[][] matriz = new int[l][c];

        System.out.println("Digite os elementos da matriz:");
        criarMatriz(matriz);

        mostrarMatriz(matriz);

        int[][] elmatriz = new int[c * l][2];

        int t = contelMatriz(matriz, elmatriz);

        ordenarelMatriz(elmatriz, t);

        mostrarelMatriz(elmatriz, t);

    }

    public static void criarMatriz(int[][] vec) {
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[i].length; j++) {
                vec[i][j] = scan.nextInt();
            }
        }
    }

    public static void mostrarMatriz(int[][] vec) {
        System.out.println("\nMatriz:");
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[0].length; j++) {
                System.out.printf("%3d", vec[i][j]);
            }
            System.out.println();
        }
    }

    public static int contelMatriz(int[][] vec1, int[][] vec2) {
        int e = 0;
        for (int i = 0; i < vec1.length; i++) {
            for (int j = 0; j < vec1[0].length; j++) {
                boolean guardar = true;
                for (int k = 0; k < e; k++) {

                    if (vec1[i][j] == vec2[k][0]) {
                        guardar = false;
                        vec2[k][1]++;
                    }
                }
                if (guardar == true) {
                    vec2[e][0] = vec1[i][j];
                    vec2[e][1] = 1;
                    e++;
                }
            }
        }
        return e;
    }

    public static void ordenarelMatriz(int[][] vec, int t) {
        int[] aux = new int[2];
        for (int i = 0; i < t - 1; i++) {
            for (int j = i + 1; j < t; j++) {
                if (vec[i][1] < vec[j][1]) {
                    aux[0] = vec[i][0];
                    aux[1] = vec[i][1];

                    vec[i][0] = vec[j][0];
                    vec[i][1] = vec[j][1];

                    vec[j][0] = aux[0];
                    vec[j][1] = aux[1];
                }
            }
        }
    }

    public static void mostrarelMatriz(int[][] vec, int t) {
        System.out.print("\nElementos da matriz: ");
        for (int i = 0; i < t; i++) {
            System.out.printf("%3d ", vec[i][0]);
        }
        System.out.print("\n                     ");
        for (int i = 0; i < t; i++) {
            System.out.printf("%3d ", vec[i][1]);
        }
        System.out.println();
    }

}
