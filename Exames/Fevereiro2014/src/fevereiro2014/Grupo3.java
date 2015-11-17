/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fevereiro2014;

import java.util.Scanner;
import java.util.Formatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Pedro
 */
public class Grupo3 {
    
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        String conteudo = lerFich();
        
        String[] dados = preencherVetor(conteudo);
        int[] palavras = contarPalavras(dados);
        
        ordenar(dados, palavras);
        ordenarAlfa(dados, palavras);
        
        criarFich(dados);
    }
    
    public static void criarFich(String[] dados) throws FileNotFoundException, UnsupportedEncodingException {
        Formatter escrever = new Formatter(new File("Ordenando.txt"), "UTF-8");
        
        for (int i = 0; i < dados.length; i++) {
            escrever.format("%s%n", dados[i]);
        }
        
        escrever.close();
    }

    
    public static void ordenar(String[] dados, int[] palavras) {
        int menor = palavras[0], aux;
        String straux;
        
        for (int i = 0; i < palavras.length-1; i++) {
            for (int j = i+1; j < palavras.length; j++) {
                if (palavras[i] > palavras [j]) {
                    aux = palavras[i];
                    palavras[i] = palavras[j];
                    palavras[j] = aux;
                    
                    straux = dados[i];
                    dados[i] = dados[j];
                    dados[j] = straux;
                }
            }
        }
    }
    
    public static void ordenarAlfa(String[] dados, int[] palavras) {
        String straux;
        
        for (int i = 0; i < dados.length-1; i++) {
            for (int j = i+1; j < dados.length; j++) {
                if (dados[i].compareTo(dados[j]) > 0 && palavras[i] == palavras[j]) {
                    straux = dados[i];
                    dados[i] = dados[j];
                    dados[j] = straux;
                }
            }
        }
    }
    
    public static int[] contarPalavras(String[] dados) {
        int[] palavras = new int[dados.length];
      
        for (int i = 0; i < dados.length; i++) {
            palavras[i] = dados[i].length() - dados[i].replaceAll(" ", "").length() + 1;
        }
        
        return palavras;
    }
    
    public static String[] preencherVetor(String conteudo) {
        return conteudo.split("/");
    }
    
    public static String lerFich() throws FileNotFoundException {
        String conteudo = "";
        
        Scanner ler = new Scanner(new File("Original.txt"), "UTF-8");
        
        while (ler.hasNextLine()) {
            conteudo += ler.nextLine().trim();
            conteudo += "/";
        }
        
        return conteudo;
    }
    
}
