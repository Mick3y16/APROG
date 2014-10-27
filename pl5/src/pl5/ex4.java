/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5;

import javax.swing.JOptionPane;

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
         * factorial();
         * arranjos();
         * combinacoes();
         * permutacoes();
         * 
         */
        String[] calculo = { "Arranjos", "Combinações", "Permutações"};

        Object calc = JOptionPane.showInputDialog(null,"Qual o cálculo que pretende efectuar?", null,JOptionPane.INFORMATION_MESSAGE, null, calculo, calculo[0]);

        if(calc.equals("Permutações")) {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Quantas possibilidades tem?"));
            long hipoteses = calculocombinatorio.CalCombinatorio.permutacoes(n);
            JOptionPane.showMessageDialog(null, "É possivel organizar as suas possibilidades de "+hipoteses+" maneiras.");
        } else {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Quantas possibilidades tem?"));
            int p = Integer.parseInt(JOptionPane.showInputDialog("Quer organiza-las em que quantidade?"));
            
            if(calc.equals("Arranjos")) {
                long hipoteses = calculocombinatorio.CalCombinatorio.arranjos(n, p);
                if(hipoteses== -1) {
                    JOptionPane.showMessageDialog(null, "O valor de n nunca pode ser menor que p.");
                } else {
                    JOptionPane.showMessageDialog(null, "Existem "+hipoteses+" hipóteses num arranjo de "+n+", "+p+" a "+p+".");
                }
            } else {
                long hipoteses = calculocombinatorio.CalCombinatorio.combinacoes(n, p);
                if(hipoteses== -1) {
                    JOptionPane.showMessageDialog(null, "O valor de n nunca pode ser menor que p.");
                } else {
                    JOptionPane.showMessageDialog(null, "Existem "+hipoteses+" hipóteses numa combinação de "+n+", "+p+" a "+p+".");
                }
            }
        }
    }
}


/**
 * * Cálculos vários utilizando métodos da classeCalCombinatorio
 
public classTeste {
    public static void main(String[ ] args) {
        long n1,n2,res;

        Formatter obj1=new Formatter(System.out);
        Scanner obj2=new Scanner(System.in);

        obj1.format("%s%n","Escreva n");
        n1= obj2.nextLong();
        obj1.format("%s%n","Escreva p");
        n2= obj2.nextLong();

        res=CalCombinatorio.combinacoes(n1,n2);

        if(res !=-1) {
            obj1.format("%s%d%n","Resultado=",res); 
        } else {
            obj1.format(“ERRO!“);
        }
    }
}*/