/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5;

import javax.swing.*;

/**
 *
 * @author Pedro Moreira
 */
public class ex4 {

    public static void main(String[] args) {
        /**
         * 
         * Class CalCombinatorio
         * 
         * arranjos();
         * combinacoes();
         * permutacoes();
         * 
         */
        
        String calc = JOptionPane.showInputDialog(null, new JLabel("Arranjos | Combinações | Permutações",JLabel.CENTER), "Que cálculo pretende efectuar?", JOptionPane.PLAIN_MESSAGE);
        calc = calc.toLowerCase();
        int n, p;
        long hipoteses;
        switch(calc) {
            case "arranjos":
                do {
                    n = Integer.parseInt(JOptionPane.showInputDialog("Quantas possibilidades tem? (Insira um valor positivo)"));
                    p = Integer.parseInt(JOptionPane.showInputDialog("Quer organiza-las em que quantidade? (O valor deve ser menor ou igual às possibilidades)"));
                } while(n < 1 || p < 1);
                
                hipoteses = calculocombinatorio.CalCombinatorio.arranjos(n, p);
                if(hipoteses== -1) {
                    JOptionPane.showMessageDialog(null, "O valor de n nunca pode ser menor que p.");
                } else {
                    JOptionPane.showMessageDialog(null, "Existem "+hipoteses+" hipóteses num arranjo de "+n+", "+p+" a "+p+".");
                }
                break;
            case "combinações":
                do {
                    n = Integer.parseInt(JOptionPane.showInputDialog("Quantas possibilidades tem? (Insira um valor positivo)"));
                    p = Integer.parseInt(JOptionPane.showInputDialog("Quer organiza-las em que quantidade? (O valor deve ser menor ou igual às possibilidades)"));
                } while(n < 1 || p < 1);
                
                hipoteses = calculocombinatorio.CalCombinatorio.combinacoes(n, p);
                if(hipoteses== -1) {
                    JOptionPane.showMessageDialog(null, "O valor de n nunca pode ser menor que p.");
                } else {
                    JOptionPane.showMessageDialog(null, "Existem "+hipoteses+" hipóteses numa combinação de "+n+", "+p+" a "+p+".");
                }
                
                break;
            case "permutações":
                do {
                    n = Integer.parseInt(JOptionPane.showInputDialog("Quantas possibilidades tem? (Insira um valor positivo)"));
                } while(n < 1);
                
                hipoteses = calculocombinatorio.CalCombinatorio.permutacoes(n);
                JOptionPane.showMessageDialog(null, "É possivel organizar as suas possibilidades de "+hipoteses+" maneiras.");
        
                break;
            default:
                JOptionPane.showMessageDialog(null, "Não foi inserido um pedido de cálculo válido.");
                break;           
        }
            
    }
}
