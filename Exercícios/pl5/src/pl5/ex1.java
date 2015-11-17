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
        // Inicialização do Scanner para ler os dados introduzidos pelo utilizador
        Scanner scan = new Scanner(System.in);
        
        // Pedido ao utilizador para digitar a sequência de palavras.
        System.out.println("Insira a sua sequência de palavras:");

        // Declaração de um contador, para contar as palavras que são introduzidas, até encontrar um palíndromo.
        int cont = 0;
        // Declaração de uma variavel, como sendo falsa para entrar dentro do ciclo de modo a procurar palíndromos.
        boolean palindromo = false;

        // Enquanto não for encontrado um Palindromo, o ciclo vai correr.
        do {
            // Por cada vez que o ciclo corre é considerada uma tentativa.
            cont++;
            System.out.print("- ");
            // É lido o valor dado pelo utilizador.
            String input = scan.next();

            // Se o metodo1 retornar true, é porque encontrou um palindromo.
            if(metodo1(input) == true) {
                // Assim sendo podemos alterar o valor da variável palindromo e apresentar o resultado ao utilizador terminando o programa.
                palindromo = true;
                System.out.println("A palavra "+input+" é um palíndromo e foi encontra na "+cont+"ª tentativa.");
            } 
        } while(palindromo == false);
       
        
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
