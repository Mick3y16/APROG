/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5;

import java.util.Scanner;
/**
 *
 * @author Pedro Moreira
 */
public class ex2 {

    public static void main(String[] args) {
        // Inicialização do Scanner para ler os dados introduzidos pelo utilizador.
        Scanner scan = new Scanner(System.in);
        int numalunos, discip;

        // Vou pedir ao utilizador o numero de alunos e não o deixo avançar enquanto o mesmo for menor que 1.
        do {
            System.out.println("Quantos alunos tem a turma? (Deve ter pelo menos um.)");
            // Ler próximo inteiro.
            numalunos = scan.nextInt();
        } while(numalunos < 1);

        // Vou pedir ao utilizador o numero de disciplinas e não o deixo avançar enquanto o mesmo for menor que 1.
        do {
            System.out.println("Quantas disciplinas pretende avaliar? (Deve avaliar pelo menos uma.)");
            // Ler próximo inteiro.
            discip = scan.nextInt();
        } while(discip < 1);

        // De i = 1 até ao numero de disciplinas vou:
        for(int i = 1; i <= discip; i++) {
            // Pedir o nome da disciplina.
            System.out.println("\nQual o nome da "+i+"ª disciplina? ");
            String nomediscip = scan.next();
            
            // Declarar duas variáveis do tipo string para armazenar o caractér "*" conforme o número de positivas e negativas
            String positivas = "", negativas = "";
            System.out.println("Digite as notas dos alunos (Devem estar compreendidas entre 0 e 20):");
            /**
             * 
             * Alternativa ao ciclo while mais abaixo.
             * 
             *  // De i = 1 até ao número de alunos o ciclo vai correr.
             *  for(i=1; i<=numalunos; i++) {
             *      // Enquanto a nota não estiver entre 0 e 20, o ciclo vai continuar a pedir a nota.
             *      do {
             *          System.out.print("Introduza a nota: ");
             *          nota = scan.nextDouble();
             *      } while(nota < 0 || nota > 20);
             *      
             *      // Caso a nota seja positiva é adicionado um "*" à String positivas.
             *      if(nota >= 9.5) {
             *          positivas += "*";
             *      // Senão é adicionado um "*" à String positivas.
             *      } else {
             *          positivas += "*";
             *      }
             *  }
             * 
             */         
            // Declaração de um contador para verificar se as notas introduzidas, equivalem ao número de alunos
            int j = 0;
            
            // Enquanto as notas introduzidas forem diferentes do número de alunos, o ciclo vai correr.
            while(j != numalunos) {
                // Ler nota.
                double nota = scan.nextDouble();

                // Se a nota estiver entre 0 e 20, é válida
                if(nota >= 0 && nota <= 20) {
                    // Soma 1 valor ao contador
                    j++;
                    // Caso a nota seja positiva é adicionado um "*" à String positivas.
                    if(nota >= 9.5) {
                        positivas += "*";
                    // Senão é adicionado um "*" à String positivas.
                    } else {
                        negativas += "*";
                    }
                    // Senão descarta-a e segue para a próxima.
                } else {
                    System.out.println(nota+" não é uma nota válida.");
                }
            }
            
            // Chamada do método, passando-lhe os resultados de forma a imprimir os mesmos.
            imprimir(nomediscip, positivas, negativas);
        }
    }

    public static void imprimir(String disciplina, String positivas, String negativas) {
            // Este método tem como função apresentar os resultados obtidos pelo main.
            System.out.print("\nDisciplina: "+disciplina);
            System.out.print("\n- Positivas: ");
            System.out.print(positivas == "" ? "Não existem positivas." : positivas);
            System.out.print("\n- Negativas: ");
            System.out.print(negativas == "" ? "Não exitem negativas." : negativas);
            System.out.print("\n");
    }
}
