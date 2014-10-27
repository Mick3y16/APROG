/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5;

import java.text.DecimalFormat;
import javax.swing.*;

/**
 *
 * @author Pedro Moreira
 */
public class ex6 {
    
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        
        String[] solidos = { "Cilindro", "Cone", "Esfera"};
        Object solido = JOptionPane.showInputDialog(null,"Pretende calcular o volume de que sólido?", null,JOptionPane.INFORMATION_MESSAGE, null, solidos, solidos[0]);

        if(solido.equals("Esfera")) {
            JTextField strraio = new JTextField(13);

            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Raio:"));   
            myPanel.add(strraio);

            JOptionPane.showConfirmDialog(null, myPanel, "Insira os valores em metros", JOptionPane.OK_CANCEL_OPTION);

            double raio = Double.parseDouble(strraio.getText());

            // Volume da esfera
            double volume = (4.0/3)*Math.PI*Math.pow(raio, 3);

            JOptionPane.showMessageDialog(null, "O volume da esfera é de "+df.format(volume)+" metros cúbicos.");
        } else {
            JTextField strraio = new JTextField(5);
            JTextField stralt = new JTextField(5);

            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Raio:"));   
            myPanel.add(strraio);
            myPanel.add(new JLabel("Altura:"));
            myPanel.add(stralt);

            JOptionPane.showConfirmDialog(null, myPanel, "Insira os valores em metros", JOptionPane.OK_CANCEL_OPTION);

            double raio = Double.parseDouble(strraio.getText());
            double alt = Double.parseDouble(stralt.getText());

            if(solido.equals("Cilindro")) {
                // Volume do Cilindro
                double volume = Math.PI*Math.pow(raio, 2)*alt;

                JOptionPane.showMessageDialog(null, "O volume do cilindro é de "+df.format(volume)+" metros cúbicos.");
            } else {
                // Volume do Cone
                double volume = (1.0/3)*Math.PI*Math.pow(raio, 2)*alt;

                JOptionPane.showMessageDialog(null, "O volume do cone é de "+df.format(volume)+" metros cúbicos.");
            }
        }
    }
}
