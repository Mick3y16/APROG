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
public class x2_cp {
    
    public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) { 
        int f;
        do {
            System.out.print("Digite o número de funcionários da empresa: ");
            f = scan.nextInt();
            if (f < 0) {
                System.out.println("A empresa deve ter no minimo 1 funcionário.");
            }
        } while (f < 1);
        
        // Vector que guarda o nome dos funcionários
        // String[] funcionarios = new String[f];
        String[] funcionarios = {"Pedro Moreira", "Abel Andrade", "Daniel Dias"};
        // Vector com os meses
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        // Vector com as vendas anuais por funcionário
        //int[][] vendasanuais = new int[f][12];
        int[][] vendasanuais = 
        { { 100, 101, 103}, {98, 99, 0},{ 1000, 900, 899}, { 0, 10, 300}, { 300, 340, 600 }, { 100, 101, 103}, { 98, 99, 0}, { 1000, 900, 899}, { 300, 340, 600 }, { 100, 101, 103}, { 98, 99, 0}, { 1000, 900, 899} };
        
        // int func = 0;
        int func = 3;
        char op;
        mostraMenu();
        do {
            System.out.print("Opção: ");
            op = scan.next().charAt(0);
            switch(op) {
                case '1':
                    mostraMenu();
                    break;
                case '2':
                    System.out.println("Os valores foram preenchidos previamente.");
                    // func = lerNomes(funcionarios);
                    //lerVendasPFuncionario(funcionarios, meses, vendasanuais);
                    break;
                case '3':
                    if (func > 0) {
                        vendasAnuais(vendasanuais);
                    } else {
                        System.out.println("Não existem valores guardados.");
                    }
                    break;
                case '4':
                    if (func > 0) {
                        topVendasPVendedor(funcionarios, meses, vendasanuais);
                    } else {
                        System.out.println("Não existem valores guardados.");
                    }
                    break; 
                case '5':
                    if (func > 0) {
                        topVendasAnualPVendedor(funcionarios, vendasanuais);
                    } else {
                        System.out.println("Não existem valores guardados.");
                    }
                    break;
                case '6':
                    piorMesNoAno(meses, vendasanuais);
                    break;
                case '7':
                    percVendasAnoPVendedor(funcionarios, vendasanuais);
                    break;
                case '8':
                    mostrarVendasTrimestre(vendasanuais);
                    break;
                case '9':
                    // Terminar
                    break;
                default: 
                    System.out.println("Opção inválida!");
                    break;
            }
            
        } while (op != 9);
    }
    
    public static void mostrarVendasTrimestre(int[][]vec2) {
        // Por fazer...
    }
    
    public static void percVendasAnoPVendedor(String[] vec1, int[][] vec2) {
        int t = calcVendasAnuais(vec2), soma;
        
        int[] vectemp = new int[vec1.length];
        
        for (int i = 0; i < vec2[0].length; i++) {
            soma = 0;
            for (int j = 0; j < vec2.length; j++) {
                soma += vec2[j][i];
            }
            vectemp[i] = soma;
        }
        
        for (int i = 0; i < vectemp.length; i++) {
            System.out.printf("\n%15s %4d€ %.2f%%",vec1[i], vectemp[i], (double)vectemp[i]*100/t);
        }
        System.out.println();
    }
    
    
    
    public static void piorMesNoAno(String[] vec1, int[][] vec2) {
        int[] pioresvendas = new int[12];
        int piorv = calcVendasAnuais(vec2), k = 0;

        for (int i = 0; i < vec2.length; i++) {
            int totalvendas = 0;
            
            for (int j = 0; j < vec2[0].length; j++) {
                totalvendas += vec2[i][j];
            }
            
            if (piorv > totalvendas) {
                k = 0;
                piorv = totalvendas;
                pioresvendas[k] = i;
            } else if (piorv == totalvendas) {
                k++;
                pioresvendas[k] = i;
            }
        }
        
        System.out.println("O pior montante global de vendas foi "+piorv+"€ e ocorreu em:");

        for (int i = 0; i <= k; i++) {
            System.out.println("- "+vec1[pioresvendas[i]]);
        }
        
    }
    
    public static void topVendasAnualPVendedor(String[] vec1, int[][] vec2) {
        int maiorvenda = 0, f = 0;
        
        for (int i = 0; i < vec2[0].length; i++) {
            int totalvendas = 0;
            for (int j = 0; j < vec2.length; j++) {
                totalvendas += vec2[j][i];
            }
            
            if (totalvendas > maiorvenda) {
                maiorvenda = totalvendas;
                f = i;
            }
        }
        
        System.out.println("A maior venda ao ano foi de "+maiorvenda+"€ e foi feita pelo funcionário "+vec1[f]);

    }
    
    public static void topVendasPVendedor(String[] vec1, String[] vec2, int[][] vec3) {
        int f;
        do {
            System.out.println("Digite o nº de funcionários dos quais pretende ver o top de vendas mensal: ");
            f = scan.nextInt();
            if (f < 1 || f > vec1.length) {
                System.out.println("O nº de funcionários não é válido!");
            }
        } while (f < 1 || f > vec1.length);
        System.out.println(vec1.length);
        int[][] vectemp = new int[2][vec1.length];
        int k = 0;
        int aux[] = new int[2];
        
        while (k < 12) {
            for (int i = 0; i < vec1.length; i++) {
                vectemp[0][i] = i;
                vectemp[1][i] = vec3[k][i];
            }
            
            for (int i = 0; i < vectemp[0].length-1; i++) {
                for (int j = i+1; j < vectemp[0].length; j++) {
                    if (vectemp[1][i] < vectemp[1][j]) {
                        aux[0] = vectemp[0][i];
                        aux[1] = vectemp[1][i];
                        
                        vectemp[0][i] = vectemp[0][j];
                        vectemp[1][i] = vectemp[1][j];
                        
                        vectemp[0][j] = aux[0];
                        vectemp[1][j] = aux[1];
                    }
                }
            }
            if (f == 1) {
                System.out.println("O melhor funcionário no mês de "+vec2[k]+" foi:");
            } else {
                System.out.println("Os melhores funcionário no mês de "+vec2[k]+" foram:");
            }
            for (int i = 0; i < f; i++) {
                System.out.println("- "+vec1[vectemp[0][i]]+" com "+vectemp[1][i]+"€.");
            }

            k++;
        }
    }
    
    public static void vendasAnuais(int[][] vec) {
        int totalvendas = calcVendasAnuais(vec);
        
        System.out.println("O montante anual das vendas da empresa foi de "+totalvendas+"€.");
    }
    
    public static int calcVendasAnuais(int[][] vec) {
        int t = 0;
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[i].length; j++) {
                t += vec[i][j];
            }
        }
        return t;
    }
    
    public static void lerVendasPFuncionario(String[] vec1, String[] vec2 ,int[][] vec3 ) {
        for (int i = 0; i < vec3.length; i++) {
            System.out.println("Digite as vendas do funcionário "+vec1[i]);
            for (int j = 0; j < vec3[i].length; j++) {
                System.out.print(" - "+vec2[j]+": ");
                vec3[i][j] = scan.nextInt();
            }
        }
    }
    
    public static int lerNomes(String[] vec) {
        scan.nextLine();
        for (int i = 0; i < vec.length; i++) {
            System.out.print("Digite o nome do "+(i+1)+"º funcionário: ");
            vec[i] = scan.nextLine();
        }
        
        return vec.length;
    }
    
    public static void mostraMenu() {
        System.out.print( "\n1. Mostrar Menu.\n"
                        + "2. Guardar funcionários e respectivas vendas.\n"
                        + "3. Mostrar total de vendas da empresa no ano.\n"
                        + "4. Mostrar os melhores vendedores de cada mês.\n"
                        + "5. Mostrar o melhor vendedor do ano.\n"
                        + "6. Apresentar o mês onde as vendas foram menores.\n"
                        + "7. Listar a percentagem de vendas ao ano, por vendedor.\n"
                        + "8. Apresentar as vendas de forma trimestral.\n"
                        + "9. Terminar.\n");
    }
    
}
