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
        Scanner scan = new Scanner(System.in);
        int num1, num2, mdigc=0, ent=0;

        System.out.println("Quantos pares de números pretende inserir?");
        int n = scan.nextInt();

        for(int i=1; i<=n; i++) {
            do {
                System.out.print("Insira dois números inteiros positivos:\n1º - ");
                num1 = scan.nextInt();
                System.out.print("2º - ");
                num2 = scan.nextInt();
            } while(num1 < 1 && num2 < 1);

            int digc = digcomunsv2(num1, num2);

            if(digc > mdigc) {
                mdigc = digc;
                ent = i;
            }
        }
        if(ent != 0) {
            System.out.println("O nº máximo de dígitos comuns encontrado num par de números foi "+mdigc+" na "+ent+"ª entrada.");
        } else {
            System.out.println("Não foi encontrado nenhum par de números com digitos comuns.");
        }
    }

    public static int digcomuns(int num1, int num2) {
        int num=0, dnum1, dnum2;

        while(num1 != 0 && num2 != 0) {
            dnum1 = num1%10;
            dnum2 = num2%10;

            if(dnum1 == dnum2) {
                num++;
            }
            num1 /= 10;
            num2 /= 10;
        }
        return num;
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
