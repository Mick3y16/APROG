/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fevereiro2014;

/**
 *
 * @author Pedro
 */
public class Grupo2 {
    
    public static void main(String[] args) {
        //int[][] mat = lerMatriz();
        int[][] mat = {{1, 2, 3},{4, 5, 6},{7, 8 ,9}};
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
        //char num = parOuImpar();
        char num = 'i';
        
        int[][] ind = new int[mat.length * mat[0].length][2];
        
        int n = indicesMatris(mat, ind, num);
        
        mudaMatriz(mat, ind, n);
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println("");
        }
        
    }
    
    public static void mudaMatriz(int[][] mat, int[][] ind, int i) {
        int elem = 0;

        for (int j = 0; j < mat.length; j++) {
            for (int k = 0; k < mat[0].length; k++) {
                if (ind[elem][0] == j && ind[elem][1] == k) {
                    elem++;
                } else {
                    mat[j][k] += 1;
                }
            }
        }
    }
    
    public static int indicesMatris(int[][] mat, int[][] ind, char c) {
        int i = 0;
        
        for (int j = 0; j < mat.length; j++) {
            for (int k = 0; k < mat[0].length; k++) {
                if (c == 'p' && mat[j][k] % 2 == 0) {
                    ind[i][0] = j;
                    ind[i][1] = k;
                } else if (c == 'i' && mat[j][k] % 2 != 0) {
                    ind[i][0] = j;
                    ind[i][1] = k;
                }
                i++;
            }
        }

        return i;
    }    
    
    public static int[][] lerMatriz() {
        /* Cria, preenche e retorna uma matriz de números inteiros */
        return null;
    }
    
    public static char parOuImpar() {
        /* Pergunta ao utilizador se pretende pesquisar pares ou impares,
           devolvendo uum caratér (p ou i, respectivamente). */
        return 'a';
    }
    
    public static void mostrar(int[][] m, String s, int n) {
        /* Lista para o ecrã os elementos existentes na matriz m, apresentando
        uma mensagems relativa à matriz a mostrar. Recebe um terceiro parametro
        n, relativo ao número de linhas preenchidas da matriz, se não existir n,
        n = número de linhas da matriz.
        */
    }
    
}
