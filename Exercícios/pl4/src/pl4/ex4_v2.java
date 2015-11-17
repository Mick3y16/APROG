/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl4;

import java.util.Scanner;
/**
 *
 * @author
 */
public class ex4_v2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int np, cont, n, div;
        double nump, i;
        
        System.out.println("Introduza a quantidade de números que pretende encontrar.");
        np = scan.nextInt();
        
        cont = 0;
        n = 1;
        
        while(np != cont && n != 63) {
           nump = (Math.pow(2, n)-1);
           
           div = 1;
           
           for(i = 1; i <= nump/2; i++) {
               if(nump%i == 0) {
                   div += 1;
               }
           }
           
           if(div == 2) {
               nump = Math.pow(2, n-1)*(Math.pow(2, n)-1);
               System.out.printf("O número %.0f é perfeito.\n",nump);
               cont++;
           }

           n += 1;
        }
    }
}
