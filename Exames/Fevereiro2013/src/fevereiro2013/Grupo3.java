/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fevereiro2013;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 *
 * @author Pedro
 */
public class Grupo3 {
    
    private static final String nFichLer = "CONSULTAS.TXT";
    private static final String nFichEsc1 = "ADULTOS.TXT";
    private static final String nFichEsc2 = "CRIANCAS.TXT";
    
    public static void main(String[] args) throws FileNotFoundException {
        //conteudo = lerFich(nFichLer);
        String conteudo = "ACST,25122000,60/ACST,25122000,55/MRTS,25041974,70/MRTS,25041974,65/";
        
        String linhas[] = conteudo.split("/");
        
        String[][] consultas = new String[linhas.length][3]; 
        
        for (int i = 0; i < linhas.length; i++) {
            String[] info = linhas[i].split(",");
            
            for (int j = 0; j < consultas[i].length; j++) {
                consultas[i][j] = info[j];
            }
        }
        
        String[][] consultasadult = new String [consultas.length][2];
        String[][] consultascrian = new String [consultas.length][2];
        
        // Precorrer a matriz e guardar adultos
        for (int i = 0; i < consultas.length; i++) {
            for (int j = 0; j < consultas.length; j++) {
                
            }
        }
        
        
        for (int i = 0; i < consultas.length; i++) {
            for (int j = 0; j < consultas[i].length; j++) {
                System.out.print(consultas[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    public static String lerFich(String nomeFichLer) throws FileNotFoundException {
        String conteudo = "";
        
        Scanner ler = new Scanner(new File(nomeFichLer), "UTF-8");
        
        while(ler.hasNextLine()) {
            conteudo += ler.nextLine().trim();
            conteudo += "|";
        }
        
        return conteudo;
    }
    
}
