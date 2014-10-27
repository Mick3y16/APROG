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
public class ex1 {
    /*
     * O algoritmo tem como função ler uma sequencia de números ditada pelo utilizador.
     * Para cada um desses números o algoritmo verifica se são pares e caso sejam,
     * faz a sua contagem e soma a duas  outras variáveis.
     * No final verifica de foram inseridos ou não números pares na sequencia e caso
     * tenham sido, calcula a média da sua soma, e dá a divisão inteira dos pares pelo
     * total de números, senão limita-se a dizer que não existem números pares.
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n, i, num, soma = 0, cont = 0, media;
        double percentpar;

        String input = JOptionPane.showInputDialog("Quantos números pretende inserir?");
        n = Integer.parseInt(input);

        for(i = 1; i <= n; i++) {
            input = JOptionPane.showInputDialog("Insira o número!");
            num = Integer.parseInt(input);

            if(num % 2 == 0) {
                cont += 1;
                soma += num;
            }
        }

        if(cont != 0) {
            media = soma/cont;
            percentpar = (float)cont*100/n;
            // Optei por mudar para a percentagem, não faz muito sentido fazer a apresentação da fracção dos números. Se fizesse como estava ficaria (float)cont/n
            JOptionPane.showMessageDialog(null, "A percentagem de números pares é de "+ percentpar +"% e a média da sua soma é de "+ media +"!", "Resultado", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,"Não foram inseridos números pares!");
        }
    }

}
