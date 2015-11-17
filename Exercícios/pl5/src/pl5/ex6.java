/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Pedro Moreira
 */
public class ex6 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        String solido;
        
        do {
            System.out.print("Prentende calcular o volume de que sólido? (Para Terminar digite fim.)\nCilindro | Cone | Esfera\n- ");
            solido = scan.next();
            solido = solido.toLowerCase();
            
            double volume = 0.0, alt, raio;
            
            switch(solido) {
                case "cilindro":
                    System.out.print("Qual o valor do raio? ");
                    raio = scan.nextDouble();
                    System.out.print("Qual o valor da altura? ");
                    alt = scan.nextDouble();
                    volume = vCilindro(raio, alt);
                    break;
                case "cone":
                    System.out.print("Qual o valor do raio? ");
                    raio = scan.nextDouble();
                    System.out.print("Qual o valor da altura? ");
                    alt = scan.nextDouble();
                    volume = vCone(raio, alt);
                    break;
                case "esfera":
                    System.out.print("Qual o valor do raio? ");
                    raio = scan.nextDouble();
                    volume = vEsfera(raio);
                    break;
                case "fim":
                    break;
                default:
                    System.out.println("Não foi inserido um sólido válido.");
                    break;
            }
            if(volume != 0.0) {
                System.out.println("O volume do(a) "+solido+" é "+df.format(volume)+".");
            }
        } while(!solido.equals("fim"));
    }
    
    // Calcula o volume de um cilindro
    public static double vCilindro(double raio, double alt) {
        double vol = (1.0/3)*Math.PI*Math.pow(raio, 2)*alt;
        return vol;
    }
    
    // Calcula o volume de um cone
    public static double vCone(double raio, double alt) {
        double vol = Math.PI*Math.pow(raio, 2)*alt;
        return vol;
    }
    
    // Calcula o volume de uma esfera
    public static double vEsfera(double raio) {
        double vol = (4.0/3)*Math.PI*Math.pow(raio, 3);
        return vol;
    }
}
