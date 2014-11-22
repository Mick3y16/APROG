/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl7;

import java.util.Scanner;

/**
 * Pretende-se fazer a gestão de um sistema de armazenamento automático de
 * produtos. Neste sistema, as prateleiras e os produtos são identificados
 * por números e códigos alfanuméricos, respetivamente. Não existem produtos
 * com códigos iguais e em cada prateleira só pode ficar armazenado um produto.
 * Cada produto fica registado com o número da prateleira onde se encontra
 * armazenado. Elabore uma aplicação com as seguintes funcionalidades:
 *  Inserir produtos no sistema, indicando os respetivos códigos de produto e números de prateleiras que ocupam;
 *  Modificar o número da prateleira ocupada por um produto;
 *  Remover produtos do sistema;
 *  Listar os produtos ordenados pelos números das prateleiras.
 * 
 * @author Pedro Moreira
 */
public class x1_cp {
    
    public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Bem vindo ao programa de armazenagem, insira o espaço disponivel para armazenamento.");
        System.out.print("Digite o numero de parteleiras disponíveis: ");
        int np;
        do {
            np = scan.nextInt();
            if (np < 1) {
                System.out.println("Tem que ter pelo menos uma parteleira de vago.");
            }
        } while (np < 1);
        for (int i = 0; i < np; i++) {
            System.out.print("Digite o espaço disponivel na "+(i+1)+"ª parteleira: ");
            int es;
            do {
            es = scan.nextInt();
                if (es < 1) {
                    System.out.println("A parteleira tem de ter pelo menos um lugar vago.");
                }
            } while (es < 1);
            String[][] armazem = new String[i][es];
        }
        
        String menu = "\n1. Visualizar menu\n2. Inserir produtos\n3. Mover produto\n4. Remover produto\n5. Listar produtos\n6. Terminar";
        System.out.println(menu);
        char op;
        do {
            System.out.print("Opção: ");
            op = scan.next().charAt(0);
            
            switch(op) {
                case '1':
                    mostrarMenu(menu);
                    break;
                case '2':
                    // Inserir produtos
                    break;
                case '3':
                    // Mover produto
                    break;
                case '4':
                    // Remover produto
                    break;
                case '5':
                    // Listar produtos
                    break;
                case '6':
                    System.out.println("Fim!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            
        } while(op != 6);
        
    }
    
    public static void inserirProd(String[][] vec) {
         int c = 0;
         //while () {
             
         //}
    }
    
    public static void mostrarMenu(String menu) {
        System.out.println(menu);
    }
    
}   
