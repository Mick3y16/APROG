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
public class ex4 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);       
        
        int n, cont, i, num, div;
        
        System.out.println("Introduza a quantidade de números que pretende encontrar.");
        n = scan.nextInt();
        
        num = 2;
        cont = 0;
        
        while(n != cont) {
            div = 0;
            
            for(i = 1; i <= num/2; i++) {
                if(num%i == 0) {
                    div += i;
                }
            }
            
            if(num == div) {
                cont += 1;
                System.out.println("O número "+ num +" é perfeito.");
            }
            
            num += 2;
        }
    }
}
