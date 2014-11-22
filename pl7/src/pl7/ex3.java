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
public class ex3 {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Digite o comprimento da matriz quadrada: ");
        int n;
        do {
            n = scan.nextInt();
            if (n < 1) {
                System.out.println("A matriz deve de ser no minimo 1x1!");
            }
        } while (n < 1);

        int[][] matriz = new int[n][n];

        System.out.println("Digite a matriz, linha a linha:");
        criarMatriz(matriz);

        int dp = calcDiagonalP(matriz);
        int ds = calcDiagonalS(matriz);
        
        if (dp == ds) {
            if (calcColunas(matriz, dp) == true && calcLinhas(matriz, dp) == true) {
                System.out.println("A matriz é um quadrado mágico.");
            } else {
                System.out.println("A matriz não é um quadrado mágico");
            }
        } else {
            System.out.println("A matriz não é um quadrado mágico");
        }

    }

    public static void criarMatriz(int[][] vec) {
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[i].length; j++) {
                vec[i][j] = scan.nextInt();
            }
        }
    }

    public static int calcDiagonalP(int[][] vec) {
        int dp = 0;
        for (int i = 0; i < vec.length; i++) {
            dp += vec[i][i];
        }
        return dp;
    }
    
    public static int calcDiagonalS(int[][] vec) {
        int i = 0, ds = 0;
        for (int t = vec.length-1; t > -1; t--) {
            ds += vec[i][t];
            
            i++;
        }
        
        return ds;
    }

    public static boolean calcColunas(int[][] vec, int val) {
        boolean resultado = true;
        int c = 0;

        while (resultado == true && c < vec.length) {
            int somacoluna = 0;

            for (int i = 0; i < vec.length; i++) {
                somacoluna += vec[c][i];
            }

            if (somacoluna != val) {
                resultado = false;
            }
            c++;
        }
        return resultado;
    }

    public static boolean calcLinhas(int[][] vec, int val) {
        int l = 0;

        while (l < vec.length) {
            int somalinha = 0;

            for (int i = 0; i < vec.length; i++) {
                somalinha += vec[i][l];
            }

            if (somalinha != val) {
                return false;
            }
            l++;
        }
        return true;
    }

}
