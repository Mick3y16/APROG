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
        Scanner scan = new Scanner(System.in);
        int numalunos, discip;

        do {
            System.out.println("Quantos alunos tem a turma? (Deve ter pelo menos um.)");
            numalunos = scan.nextInt();
        } while(numalunos < 1);

        do {
            System.out.println("Quantas disciplinas pretende avaliar? (Deve avaliar pelo menos uma.)");
            discip = scan.nextInt();
        } while(discip < 1);

        for(int i = 1; i <= discip; i++) {
            System.out.println("\nQual o nome da "+i+"ª disciplina? ");
            String nomediscip = scan.next();
            
            String positivas = "", negativas = "";
            System.out.println("Digite as notas dos alunos (Devem estar compreendidas entre 0 e 20):");
            int j = 0, k = 0;
            while(j != numalunos) {
                double nota = scan.nextDouble();

                if(nota >= 0 && nota <= 20) {
                    j++;
                    if(nota >= 9.5) {
                        positivas += "*";
                    } else {
                        negativas += "*";
                    }
                } else {
                    System.out.println(nota+" não é uma nota válida.");
                }
            }
            imprimir(nomediscip, positivas, negativas);
        }
    }

    public static void imprimir(String disciplina, String positivas, String negativas) {
            System.out.print("\nDisciplina: "+disciplina);
            System.out.print("\n- Positivas: ");
            System.out.print(positivas == "" ? "Não existem positivas." : positivas);
            System.out.print("\n- Negativas: ");
            System.out.print(negativas == "" ? "Não exitem negativas." : negativas);
            System.out.print("\n");
    }
}
