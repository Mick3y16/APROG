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
public class ex6 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num, contp_sq1, contp_sq2;
        String input;
        
        input = JOptionPane.showInputDialog("Insira a primeira sequência de números, para terminar digite 0:");
        num = Integer.parseInt(input);
        
        contp_sq1 = 0;
        contp_sq2 = 0;
        
        while(num != 0) {
            if(num % 2 == 0) {
                contp_sq1 += 1;
            }
            
            input = JOptionPane.showInputDialog("Próximo valor:");
            num = Integer.parseInt(input);
        }
        
        input = JOptionPane.showInputDialog("Insira a segunda sequência de números, para terminar digite -1:");
        num = Integer.parseInt(input);
        
        while(num != -1) {
            if(num % 2 == 0 && num != 0) {
                contp_sq2 += 1;
            }            
            
            input = JOptionPane.showInputDialog("Próximo valor:");
            num = Integer.parseInt(input);
        }
        
        if(contp_sq1 > contp_sq2) {
            JOptionPane.showMessageDialog(null,"A primeira sequência contém mais números pares!");
        } else if(contp_sq2 > contp_sq1) {
            JOptionPane.showMessageDialog(null,"A segunda sequência contém mais números pares!");
        } else if(contp_sq2 == 0 && contp_sq1 == 0) {
            JOptionPane.showMessageDialog(null,"Não foram introduzidos números pares em nenhuma das sequências!");
        } else {
            JOptionPane.showMessageDialog(null,"Ambas as sequências contêm o mesmo número de pares!");
        }

    }
}
