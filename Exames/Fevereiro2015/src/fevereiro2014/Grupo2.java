package fevereiro2014;

//import java.util.Scanner;
/**
 *
 * @author Pedro
 */
public class Grupo2 {

    public static void main(String[] args) {
        /*
         Scanner ler = new Scanner(System.in);
                
         int l, c;
         do {
         System.out.println("Introduza o nº total de filas.");
         l = ler.nextInt();
         System.out.println("Introduza o nº de lugares de cada fila.");
         c = ler.nextInt();
         } while (l < 0 && c < 0);
         */

        // Independentemente do tamanho, a matriz irá sempre ter 5 linhas e 7 colunas.
        int[][] mat1 = lerMatriz1();
        int[][] mat2 = lerMatriz2();
        int[] vec = new int[mat1.length * mat1[0].length];

        int n = precosDiferentes(mat1, vec);
        listar(vec, n);
        
        int lug;
        /*do {
            System.out.println("Introduza o nº total de filas.");
            lug = ler.nextInt();
        } while (lug < 0);*/
        
        lug = 5;
        int fila = lugaresContiguos(mat2, lug);

        if (fila != -1) {
            System.out.println("Existem " + lug + " lugares disponiveis na fila " + fila + ".");
        } else {
            System.out.println("Não existem " + n + "lugares disponiveis em nenhum fila.");
        }

        System.out.println("A percentagem de lugares centrais ocupados é " + calcularPercentagemOcupacaoLugaresCentrais(mat2) + "%.");
    }

    public static double calcularPercentagemOcupacaoLugaresCentrais(int[][] mat2) {
        double centro = (double) mat2.length / 2;
        int inicio, fim, totallugares;

        if (centro % 2.0 == 0) {
            inicio = (int) centro - 1;
            fim = (int) centro;
            totallugares = 2 * mat2.length;
        } else {
            inicio = (int) centro;
            fim = inicio;
            totallugares = mat2.length;
        }

        int k = 0;
        for (int i = 0; i < mat2.length; i++) {
            for (int j = inicio; j <= fim; j++) {
                if (mat2[i][j] == 1) {
                    k++;
                }
            }
        }

        return (double) (k * 100) / totallugares;
    }

    public static int lugaresContiguos(int[][] mat2, int n) {
        int k = 0;
        for (int i = 0; i < mat2.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                if (mat2[i][j] == 0) {
                    k++;

                    if (k == n) {
                        return ++i;
                    }
                } else {
                    k = 0;
                }
            }
            k = 0;
        }

        return -1;
    }

    public static int precosDiferentes(int[][] mat1, int[] vec) {
        int n = 0;

        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                if (!precoGuardado(vec, mat1[i][j], n)) {
                    vec[n] = mat1[i][j];
                    n++;
                }
            }
        }

        return n;
    }

    public static boolean precoGuardado(int[] vec, int preco, int n) {
        for (int i = 0; i < n; i++) {
            if (vec[i] == preco) {
                return true;
            }
        }

        return false;
    }

    public static void listar(int[] vec, int n) {
        System.out.print("Preços diferentes: ");
        for (int i = 0; i < n; i++) {
            System.out.print(vec[i] + "€ ");
        }
        System.out.println();
    }

    public static int[][] lerMatriz2() {
        int[][] lugares = {
            {1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 1, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 1}};

        return lugares;
    }

    public static int[][] lerMatriz1() {
        int[][] precos = {
            {9, 9, 10, 10, 10, 9, 9},
            {8, 8, 9, 9, 9, 8, 8},
            {7, 7, 8, 8, 8, 7, 7},
            {6, 6, 7, 7, 7, 6, 6},
            {5, 5, 6, 6, 6, 5, 100}
        };

        return precos;
    }
}
