/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janeiro2015;

//import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Grupo2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanner ler = new Scanner(System.in);
        int n = 3;
        /*do {
            System.out.println("Introduza o comprimento do vetor.");
            n = ler.nextInt();
        } while (n < 0);*/
        int[] v1 = lerVetor(n);
        
        int m = 3;
        /*do {
            System.out.println("Introduza o comprimento da matriz");
            m = ler.nextInt();
        } while(m < n);*/
        int[][] mat = lerMatriz(m, m);
        
        if(existeVetorNaMatriz(v1, mat)) {
            System.out.println("O vetor existe na matriz!");
        } else {
            System.out.println("O vetor não existe na matriz!");
        }
    }
    
    public static boolean existeVetorNaMatriz(int[] vec, int[][] mat) {
        // Colunas
        for (int i = 0; i < mat.length; i++) {
            if(verificarSubVetor(extrairVetorDaColuna(mat, i), vec)) {
                return true;
            }
        }
        
        // Linhas
        for (int i = 0; i < mat.length; i++) {
            if(verificarSubVetor(mat[i], vec)) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean verificarSubVetor(int[] vec1, int[] vec2) {
        for (int i = 0; i <= vec1.length-vec2.length; i++) {
            if (subVetor(vec1, vec2, i)) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean subVetor(int[] vec1, int[] vec2, int i) {
        for (int j = 0; j < vec2.length; j++) {
            if (vec1[j+i] != vec2[j]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static int[] extrairVetorDaColuna(int[][] mat, int col) {
        int[] vec = new int[mat.length];
        
        for (int i = 0; i < mat.length; i++) {
            vec[i] = mat[i][col];
        }
        
        return vec;
    }
    
    public static int[][] lerMatriz(int i, int j) {
        int[][] matriz = {{4, 5, 1}, {7, 8, 2}, {1, 6, 3}};
        
        return matriz;
    }
    
    public static int[] lerVetor(int n) {
        int[] vetor = {1, 2, 3};
        
        return vetor;
    }
}
