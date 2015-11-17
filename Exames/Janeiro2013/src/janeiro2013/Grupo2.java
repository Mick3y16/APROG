/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janeiro2013;

/**
 *
 * @author Pedro
 */
public class Grupo2 {
    
    public static void main(String[] args) {
        //int[][] mat = criarMatriz(n, m);
        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        
        rotacaoEsquerda(mat);
        mostrarMatriz(mat);
        
        int[][] mat2 = {{11, 10}, {15, 14}};
        
        if (verificarMatrizContida(mat, mat2)) {
            System.out.println("Está contida!");
        } else {
            System.out.println("Não está contida!");
        }
    }
    
    public static boolean verificarMatrizContida(int[][] mat1, int[][] mat2) {
        int linha = 0, coluna = 0;
        
        while (linha <= mat1.length - mat2.length) {
            while (coluna <= mat1[0].length - mat2[0].length) {
                if (matrizIgual(mat1, mat2, linha, coluna)) {
                    return true;
                }
                coluna++;
            }
            linha++;
            coluna = 0;           
        }
        
        return false;
    }
    
    public static boolean matrizIgual(int[][] mat1, int[][] mat2, int linha, int coluna) {
        for (int i = 0; i < mat2.length; i++) {
            for (int j = 0; j < mat2.length; j++) {
                if (mat1[i+linha][j+coluna] != mat2[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static void rotacaoEsquerda(int[][] mat) {
        int aux;
        
        for (int i = 0; i < mat[0].length; i++) {
            for (int j = 0; j < mat[0].length - 1; j++) {
                    aux = mat[i][j];
                    mat[i][j] = mat[i][j+1];
                    mat[i][j+1] = aux;
            }
        }
    }
    
    public static int[][] criarMatriz(int n, int m) {
        /* Cria uma matriz de números inteiros com n linhas e m colunas,
        preenche-a a partir de valores lidos no teclado e no final retorna
        essa matriz */
        
        return null;
    }
    
    public static void mostrarMatriz(int[][] m) {
        /* Apresenta no ecrã a matriz n passada por parâmetro */
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.printf("%3s",m[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
}
