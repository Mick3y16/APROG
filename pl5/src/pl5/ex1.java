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
public class ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira a sua sequência de palavras:");
        String input = "";

        int cont = 1;
        boolean palindromo = false;

        while(palindromo == false) {
            System.out.print("- ");
            input = scan.next();

            if(metodo1(input) == true) {
                palindromo = true;
            }
            cont++;
        }
        System.out.println("A palavra "+input+" é um palíndromo e foi encontra depois de "+cont+" tentativas.");
    }

    /*
     * Este método aceita uma string dada pelo utilizador,
     * e parte do principio que a mesma é um palíndromo,
     * começa por coloca-la em minúsculas e conta os seus 
     * caratéres, para depois comprar cada uma das posições
     * de i, com o seu simétrico que é 'tamanho - 1 - i', descartando
     * a possibilidade de que a string seja um palíndromo 
     * no momento em que 'i' e 'tamanho - 1 - i' são diferentes.
     */
    public static boolean metodo1(String pal) {
        boolean resposta = true;
        pal = pal.toLowerCase();
        int tamanho = pal.length();
        for (int i = 0; i < tamanho / 2; i++) {
            if (pal.charAt(i) != pal.charAt(tamanho - 1 - i)) {
                resposta = false;
                break;
            }
        }
        return resposta;
    }

    /*
     * Este método aceita uma string dada pelo utilizador
     * coloca-a em minúsculas e conta os caractéres dela,
     * para depois comparar a posição de 'i' com o seu 
     * simétrico 'j - 1'.
     * Enquanto i for menor que j e os caracteres em i forem
     * iguais aos de j, o ciclo vai correr, incrementado i e
     * decrementando j, retornando no fim o resultado.
     */
    public static boolean metodo2(String pal) {
        int i, j;
        pal = pal.toLowerCase();
        i = 0;
        j = pal.length() - 1;
        while (i < j && pal.charAt(i) == pal.charAt(j)) {
            i++;
            j--;
        }
        return i >= j;
    }

}
