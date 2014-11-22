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
public class x3_cp {

    public static void main(String[] args) {
        /**
         *  Esta parte do código encontra-se responsável por criar a matriz que 
         *  irá guardar os valores da solução de sodoku, efectuando a leitura
         *  dos mesmos. O código foi testado com as duas soluções expostas abaixo 
         *  de forma a verificar se estava correcto.
         * 
         *  int[][] sodoku = new int[9][9];
         *  criarSodoku(sodoku);
         * 
         *  int[][] sodoku = {{9, 7, 6, 5, 4, 3, 1, 2, 8}, {8, 2, 1, 7, 9, 6, 4, 5, 3}, {5, 4, 3, 2, 1, 8, 9, 7, 6}, {2, 6, 4, 1, 3, 9, 7, 8, 5}, {7, 5, 8, 4, 6, 2, 3, 1, 9}, {1, 3, 9, 8, 7, 5, 6, 4, 2}, {6, 1, 2, 9, 5, 4, 8, 3, 7}, {4, 9, 5, 3, 8, 7, 2, 6, 1}, {3, 8, 7, 6, 2, 1, 5, 9, 4}};
         */      
        int[][] sodoku = {{5, 3, 4, 6, 7, 8, 9, 1, 2}, {6, 7, 2, 1, 9, 5, 3, 4, 8}, {1, 9, 8, 3, 4, 2, 5, 6, 7}, {8, 5, 9, 7, 6, 1, 4, 2, 3}, {4, 2, 6, 8, 5, 3, 7, 9, 1}, {7, 1, 3, 9, 2, 4, 8, 5, 6}, {9, 6, 1, 5, 3, 7, 2, 8, 4}, {2, 8, 7, 4, 1, 9, 6, 3, 5}, {3, 4, 5, 2, 8, 6, 1, 7, 9}};
        
        mostrarSodoku(sodoku);

        if ((valColunas(sodoku) == true) && (valLinhas(sodoku) == true) && (valMatrizes(sodoku) == true)) {
            System.out.println("\nA solução do Sodoku é válida!");
        } else {
            System.out.println("\nA solução do Sodoku é inválida!");
        }

    }

    public static void criarSodoku(int[][] vec) {
        Scanner scan = new Scanner(System.in);

        int elem, c = 0;
        for (int i = 0; i < vec.length; i++) {
                System.out.print("Digite os elementos da " + (i + 1) + " linha: ");
            for (int j = 0; j < vec[i].length; j++) {
                do {
                    vec[i][j] = scan.nextInt();
                    if (vec[i][j] < 1 || vec[i][j] > 9) {
                        System.out.println("Os valores do Sodoku devem estar compreendidos entre [1-9].");
                        System.out.print("Digite os elementos da " + (i + 1) + " linha:");
                    }
                } while (vec[i][j] < 1 || vec[i][j] > 9);

                
            }
        }
    }

    public static void mostrarSodoku(int[][] vec) {
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[i].length; j++) {
                System.out.print("[" + vec[i][j] + "]");
            }
            System.out.println();
        }
    }

    public static boolean valColunas(int[][] vec) {

        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[0].length - 1; j++) {
                for (int k = j + 1; k < vec[0].length; k++) {
                    if (vec[j][i] == vec[k][i]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean valLinhas(int[][] vec) {

        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[0].length - 1; j++) {
                for (int k = j + 1; k < vec[0].length; k++) {
                    if (vec[i][j] == vec[i][k]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean valMatrizes(int[][] vec) {
        int linha = 0, coluna = 0;
        
        while(linha < 9) {
            while (coluna < 9) {
                for (int i = linha; i < linha+3; i++) {
                    for (int j = coluna; j < coluna+3; j++) {
                        for (int k = linha; k < linha+3; k++) {
                            for (int l = coluna; l < coluna+3; l++) {
                                if (vec[i][j] == vec[k][l] && (i != k && j != l)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
                coluna += 3;
            }
            linha += 3;
        }
        return true;
    }

}
