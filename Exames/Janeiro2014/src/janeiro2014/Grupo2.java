/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janeiro2014;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Grupo2 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //System.out.println("Pretender inserir um vetor de quantas posições?");
        //int n = 
        //double[][] mat = lerMatriz(i, j);
        double[][] mat = {{3.0, 4.0, 5.0}, {4.0, 2.0, 7.0}, {2.0, 1.0, 7.0}};
        //lerVetor(n);
        int[] v1 = {2, 4, 5};
        
        double[] res = calcularProduto(v1, mat);
        
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        
        System.out.println(minMax(mat));
    }
    
    public static double minMax(double[][] mat) {
        int[] linhas = new int[mat.length];
        int k = 0;
        double maior = 0;
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (maior < mat[i][j]) {
                    k = 0;
                    maior = mat[i][j];
                    linhas[k] = i;
                    k++;
                } else if (maior == mat[i][j]) {
                    linhas[k] = i;
                    k++;
                }
            }
        }
        
        double menor = Double.MAX_VALUE;
        
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (menor > mat[linhas[i]][j]) {
                    menor = mat[linhas[i]][j];
                }
            }
        }
        
        return menor;
    }
    
    public static double[] calcularProduto(int[] v1, double[][] mat) {
        double[] res = new double[mat.length];
        
        int j = mat[0].length - 1;
        for (int i = 0; i < mat.length; i++) {
            res[i] = mat[i][j] * v1[i];
            j--;
        }
        
        return res;
    }
    
    public static double[][] lerMatriz(int i, int j) {
        /* Cria, preenche e retorna uma matriz de números reais com i linhas e j colunas */
        return null;
    }
    
    public static int[] lerVetor(int n) {
        /* Cria, preence e retorna um vetor de números inteiros com n elementos */
        return null;
    }
    
    public static void listarMatriz(double[][] mat) {
        /* Escreve uma matriz de números reais */
    }
    
    public static void listarVetor(int[] v) {
        /* Escreve um vetor de números inteiros */        
    }
    
}
