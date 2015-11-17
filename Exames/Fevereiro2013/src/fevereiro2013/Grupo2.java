/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fevereiro2013;

/**
 *
 * @author Pedro
 */
public class Grupo2 {
    
    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 0}, {3, 0, 4}, {0, 5, 6}};
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
        
        trocarElementos(matriz);
        System.out.println("");
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    public static void trocarElementos(int[][] matriz) {
        int aux;
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < 0 + i; j++) {
                aux = matriz[i][j];
                matriz[i][j] = matriz[j][i];
                matriz[j][i] = aux;
                        
            }
        }
    }
    
    public static int imparesDePares(int[][] matriz, int[] vec) {
        int c = 0;
        
        for (int i = 0; i < matriz.length; i = i + 2) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] % 2 != 0) {
                    vec[i] += matriz[i][j];
                    c++;
                }
            }
        }
        
        return c;
    }
        
    public static int[][] lerMatriz(int n) {
        /* Lê uma matriz quadrada de ordem n de numero inteiros e retorna-a */
        return null;
    }
    
    public static void mostarMatriz(int[][] m) {
        /* Mostrar super matriz!!! */
    }
    
    public static void listarVetor(int[] v, int n) {
        /* Escreve n elementos de um vetor */
    }

}
