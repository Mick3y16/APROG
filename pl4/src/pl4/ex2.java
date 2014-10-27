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
public class ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n, i, temp, dia, tempmax;
        String input;

        dia = 0;
        tempmax = Integer.MIN_VALUE;

        input = JOptionPane.showInputDialog("Quer inserir as temperaturas de quantos dias?");
        n = Integer.parseInt(input);

        for(i = 1; i <= n; i++) {
            input = JOptionPane.showInputDialog("Insira uma temperatura!");
            temp = Integer.parseInt(input);

            if(temp < -30 || temp >= 50) {
                JOptionPane.showMessageDialog(null,"Temperatura Extrema");
            } else if(temp < 9) {
                JOptionPane.showMessageDialog(null,"Muito Frio");
            } else if(temp < 15) {
                JOptionPane.showMessageDialog(null,"Frio");
            } else if(temp < 20) {
                JOptionPane.showMessageDialog(null,"Ameno");
            } else if(temp < 30) {
                JOptionPane.showMessageDialog(null,"Quente");
            } else {
                JOptionPane.showMessageDialog(null,"Muito Quente");
            }

            if(temp > tempmax) {
                tempmax = temp;
                dia = i;
            }
        }

        if(dia != 0) {
            JOptionPane.showMessageDialog(null,"A temperatura mais alta registada, foi de "+tempmax+"ºC e ocorreu no dia "+dia+".");
        }
    }
}
