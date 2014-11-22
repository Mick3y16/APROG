/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl7;

/**
 *
 * @author Pedro Moreira
 */
public class ex2 {

    /**
     * O método tem como função construir um vector bi-dimensional, de forma a
     * formar uma matriz, e no final apresenta o maior elemento de cada uma das
     * linhas.
     *
     * @param args
     */
    public static void main(String[] args) {
        int x;
        int m[][] = {{1, 4, 2, 1}, {9, 7, 2, 2}, {1, 7, 3, 5}, {2, 5, 0, 3}, {4, 7, 2, 1}};
        for (int i = 0; i < m.length; i++) {
            x = m[i][0];
            for (int j = 1; j < m[i].length; j++) {
                if (m[i][j] > x) {
                    x = m[i][j];
                }
            }
            System.out.println(x);
        }

        mostrarMatriz(m);

        mediaMatriz(m);

        mostrarMatriztrans(m);
    }

    public static void mostrarMatriz(int[][] vec) {
        System.out.println("\nMatriz:");
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[i].length; j++) {
                System.out.print("[" + vec[i][j] + "]");
            }
            System.out.println();
        }
    }

    public static void mediaMatriz(int[][] vec) {
        double media = 0;
        System.out.println("\nMedias:");
        for (int i = 0; i < vec[i].length; i++) {
            double soma = 0;
            for (int j = 0; j < vec.length; j++) {
                soma += vec[j][i];
            }
            media += soma;
            System.out.println("A media da soma da " + (i + 1) + "ª coluna é " + soma / vec.length);
        }
        System.out.println("A média da soma da matriz é de: " + media / (vec[0].length*vec.length));
    }

    public static void mostrarMatriztrans(int[][] vec) {
        System.out.println("\nMatriz transposta:");
        for (int i = 0; i < vec[i].length; i++) {
            for (int j = 0; j < vec.length; j++) {
                System.out.print("[" + vec[j][i] + "]");
            }
            System.out.print("\n");
        }

    }

}
