/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl4;

import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class ex5 {
    /**
     * @param args the command line arguments
     * 
     * O algoritmo tem como função eliminar todos os algarismos pares do número
     * inserido pelo utilizador, escrevendo o número sem os mesmos.
     * Ex: 134569 -> 1359
     */
    public static void main(String[] args) {
        int num, d, aux, res;
        String input;
        
        res = 0;
        aux = 1;
        
        input = JOptionPane.showInputDialog("Digite um número:");
        num = Integer.parseInt(input);
        
        while(num != 0) {
            d = num % 10;
            
            if(d % 2 == 1) {
                res += d * aux;
                aux *= 10;
            }
            num /= 10;
        }
        
        JOptionPane.showMessageDialog(null,"O resultado é: "+ res);
    }
}
