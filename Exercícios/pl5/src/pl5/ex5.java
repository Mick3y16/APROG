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
public class ex5 {

    public static void main(String[] args) {
        // Inicialização do Scanner para ler os dados introduzidos pelo utilizador.
        Scanner scan = new Scanner(System.in);
        // Declaração das variáveis
        int n, num1, num2, mdigc=0, mnum1=0, mnum2=0, ent=0;

        System.out.println("Quantos pares de números pretende inserir? (Deve inserir pelo menos 1.)");
        // Enquanto n não for pelo menos 1 o programa não passa daqui.
        do {
            // Leitura de um valor n, para saber quantos pares de números vão ser introduzidos.
            n = scan.nextInt();
        } while(n < 1);

        // De i = 1 até ao valor de n, vamos pedir 2 números inteiros ao utilizador.
        for(int i=1; i<=n; i++) {
            // Enquanto os dois numeros inseridos não forem superiores a 0, o utilizador tem de os voltar a introduzir.
            do {
                System.out.print("Insira dois números inteiros positivos:\n1º - ");
                // Leitura do primeiro valor inteiro.
                num1 = scan.nextInt();
                System.out.print("2º - ");
                // Leitura do segundo valor inteiro.
                num2 = scan.nextInt();
            } while(num1 < 1 && num2 < 1);

            // Chamada do metodo para contar os digitos em comum entre ambos os números e guardar o valor retornado numa variavél.
            int digc = digcomunsv2(num1, num2);

            // Se o valor de digc for maior que o anteriormente guardado então.
            if(digc > mdigc) {
                // Guardamos esse valor, os números que lhe deram origem e o valor de i, para saber em qual dos ciclos isso ocorreu.
                mdigc = digc;
                mnum1 = num1;
                mnum2 = num2;
                ent = i;
            }
        }
        // Se ent for diferente de zero é porque num dos ciclos foi introduzido um par de números com digitos em comum.
        if(ent != 0) {
            System.out.println("O primeiro par de números com mais digitos em comum é "+mnum1+" e "+mnum2+", respectivamente, tem "+mdigc+" digitos em comum e foi o "+ent+"º par a dar entrada.");
        // Senão...
        } else {
            System.out.println("Não foi encontrado nenhum par de números com digitos comuns.");
        }
    }

    public static int digcomuns(int num1, int num2) {
        // Declaração de um contador, para contar os digitos em comum.
        int digc=0;

        // Enquanto ambos os numeros forem diferentes de 0, o ciclo corre. No momento em que um ou ambos forem 0, ele para.
        while(num1 != 0 && num2 != 0) {
            // Vamos guardar o resto da divisão de cada um dos números por 10 numa variavél.
            int dnum1 = num1%10;
            int dnum2 = num2%10;

            // Caso o valor das duas variáveis seja igual, encontramos um digito em comum.
            if(dnum1 == dnum2) {
                digc++;
            }
            
            // Vamos retirar o algarismo mais à direita a cada um dos números e correr novamente o ciclo.
            num1 /= 10; // num1 = num1 / 10;
            num2 /= 10; // num2 = num2 / 10;
        }
        // Retorna a quantidade de digitos na mesma posição entre os números.
        return digc;
    }

    /*
     * Forma complicada??
     */
    public static int digcomunsv2(int num1, int num2) {
        String str1 = Integer.toString(num1);
        String str2 = Integer.toString(num2);

        int tam1 = str1.length();
        int tam2 = str2.length();

        int digc = 0;
        while (tam1-1 >= 0 || tam2-1 >= 0) {
            if(str1.charAt(tam1-1) == str2.charAt(tam2-1)) {
                digc++;
            }
            tam1--;
            tam2--;
        }
        return digc;
    }
}
