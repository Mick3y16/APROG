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
public class ex3 {

    public static void main(String[] args) {
        int idade, cont_total, cont_m18, percent;
        String input, nome, lista;

        nome = JOptionPane.showInputDialog("Insira o nome?");

        cont_total = 0;
        cont_m18 = 0;
        lista = "";
        
        while(!nome.equals("zzz")) {
            if(!nome.equals("zzz")) {
                input = JOptionPane.showInputDialog("Insira a idade?");
                idade = Integer.parseInt(input);
                
                if(idade >= 18) {
                    lista += nome + "\n";
                    cont_m18++;
                }
            }
            cont_total++;
            nome = JOptionPane.showInputDialog("Insira o nome?");            
        }
        if(cont_m18 > 0) {
            percent = cont_m18*100/cont_total;
            JOptionPane.showMessageDialog(null, "Os nomes das pessoas com mais de 18 anos são: \n"+ lista +"\n A percentagem de pessoas maiores de idade é de "+ percent +"%.");
        } else {
            JOptionPane.showMessageDialog(null, "Não foram inseridas pessoas com idades superiores a 18 anos.");    
        }
    }
    
}
