/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janeiro2013;

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
        String conteudo  = lerFich();
        
        String[][] dados = preencherMatriz(conteudo);
        
        criarFich(dados);
    }

    public static String guardarHorasEmedia(String[] info) {
        String horas = "";
        int media = 0;
        for (int j = 1; j < info.length; j = j + 2) {
            String[] hora1 = info[j].split(":");
            String[] hora2 = info[j+1].split(":");
            int minutos1 = Integer.parseInt(hora1[0]) * 60 + Integer.parseInt(hora1[1]);
            int minutos2 = Integer.parseInt(hora2[0]) * 60 + Integer.parseInt(hora2[1]);

            horas += Integer.toString(minutos2 - minutos1) + ";";
            media += (minutos2 - minutos1);
        }
        
        horas += Integer.toString(media / (info.length/2));
        
        return horas;
    }
    
    public static String guardarNome(String nome) {
        String[] nomeformatado = nome.split(" ");
        
        return nomeformatado[nomeformatado.length - 1] + ", " + nomeformatado[0];
    }
    
    public static String[][] preencherMatriz(String conteudo) {
        String[] linhas = conteudo.split("/");

        String[][] dados = new String[linhas.length][2];

        for (int i = 0; i < dados.length; i++) {
            String info[] = linhas[i].split(";");
            
            dados[i][0] = guardarNome(info[0]);
            dados[i][1] = guardarHorasEmedia(info);
        }

        return dados;
    }

    public static void criarFich(String[][] dados) throws FileNotFoundException, UnsupportedEncodingException {
        Formatter escrever = new Formatter(new File("estatisticas.txt"), "UTF-8");
        
        for (int i = 0; i < dados.length; i++) {
            for (int j = 0; j < dados[0].length-1; j++) {
                escrever.format("%s;", dados[i][j]);
            }
            escrever.format("%s%n", dados[i][1]);
        }
        escrever.close();
    }
    
    public static String lerFich() throws FileNotFoundException {
        String conteudo = "";
        Scanner ler = new Scanner(new File("consultas.txt"), "UTF-8");

        while (ler.hasNextLine()) {
            conteudo += ler.nextLine();
            conteudo += "/";
        }

        return conteudo;
    }

}
