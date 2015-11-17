/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setembro2013;

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
        Scanner scan = new Scanner(System.in);

        System.out.println("Introduza o nome do ficheiro de leitura:");
        String fichLeitura = scan.nextLine();
        System.out.println("Introduza o nome do ficheiro de escrita:");
        String fichEscrita = scan.nextLine();

        String conteudo = lerFich(fichLeitura);
        String[][] info = preencherMatriz(conteudo);
        double[][] notas = new double[info.length][4];

        for (int i = 0; i < info.length; i++) {
            System.out.println("Digite as três notas do aluno " + info[i][0] + ", " + info[i][1]);
            for (int j = 0; j < notas[0].length - 1; j++) {
                notas[i][j] = scan.nextDouble();
            }
        }

        calcularMedia(notas);

        criarFich(info, notas, fichEscrita);
        
        double melhor = procurarMelhor(notas);
        double pior = procurarPior(notas);
        
        int totalmelhor = contarNota(notas, melhor);
        int totalpior = contarNota(notas, pior);
        
        System.out.println("A pior nota de frequência foi de "+melhor+" valores e foi obtida por "+ totalmelhor+" alunos.");
        System.out.println("A pior nota de frequência foi de "+pior+" valores e foi obtida por "+ totalpior+" alunos.");
        System.out.println("A média de notas foi de " + calcularMediaNotas(notas) + " valores.");
        
    }

    public static void criarFich(String[][] info, double[][] notas, String fichEscrita) throws FileNotFoundException, UnsupportedEncodingException {
        Formatter escrever = new Formatter(new File(fichEscrita + ".txt"), "UTF-8");

        for (int i = 0; i < info.length; i++) {
            escrever.format("%s %s %.1f%n", info[i][0], info[i][1], notas[i][3]);
        }

        escrever.close();
    }
    
    public static double calcularMediaNotas(double[][] notas) {
        int media = 0;
        
        for (int i = 0; i < notas.length; i++) {
            media += notas[i][3];
        }
        
        return media / notas.length;
    }

    public static int contarNota(double[][] notas, double nota) {
        int total = 0;
        
        for (int i = 0; i < notas.length; i++) {
            if (notas[i][3] == nota) {
                total++;
            }
        }
        
        return total;
    }
    
    public static double procurarPior(double[][] notas) {
        double pior = notas[0][3];
        
        for (int i = 1; i < notas.length; i++) {
            if (notas[i][3] < pior) {
                pior = notas[i][3];
            }
        }
        
        return pior;
    }

    public static double procurarMelhor(double[][] notas) {
        double melhor = notas[0][3];
        
        for (int i = 1; i < notas.length; i++) {
            if (notas[i][3] > melhor) {
                melhor = notas[i][3];
            }
        }
        
        return melhor;
    }

    public static void calcularMedia(double[][] notas) {
        double media;
        for (int i = 0; i < notas.length; i++) {
            media = 0.0;
            for (int j = 0; j < notas[0].length - 1; j++) {
                media += notas[i][j];
            }
            notas[i][3] = media / (notas[0].length-1);
        }
    }

    public static String[][] preencherMatriz(String counteudo) {
        String[] linhas = counteudo.split("/");

        String[][] info = new String[linhas.length][2];

        for (int i = 0; i < info.length; i++) {
            String[] dados = linhas[i].split(";");

            for (int j = 0; j < info[0].length; j++) {
                info[i][j] = dados[j];
            }
        }

        return info;
    }

    public static String lerFich(String fichLeitura) throws FileNotFoundException {
        String conteudo = "";

        Scanner ler = new Scanner(new File(fichLeitura + ".txt"), "UTF-8");

        while (ler.hasNextLine()) {
            conteudo += ler.nextLine();
            conteudo += "/";
        }

        return conteudo;
    }

}
