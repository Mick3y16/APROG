/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janeiro2014;

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
        String[][] dados = preencherMatriz(conteudo);
        
        Scanner in = new Scanner(System.in);
        System.out.println("Digite a localidade:");
        String localidade = in.next();
        
        criarFich(dados, localidade);
        
    }
    
    public static void criarFich(String[][] dados, String localidade) throws FileNotFoundException, UnsupportedEncodingException {
        Formatter escrever = new Formatter(new File(localidade+".txt"), "UTF-8");
        int idades = 0, cont = 0;
        
        for (int linha = 0; linha < dados.length; linha++) {
            if (dados[linha][3].equals(localidade)) {
                escrever.format("%s;%s%n",dados[linha][0], dados[linha][1] );
                idades += Integer.parseInt(dados[linha][2]);
                cont++;
            }
        }
        escrever.format("Media das idades: %d anos.", Math.round(idades/cont));
        escrever.close();
    }
    
    public static String[][] preencherMatriz(String conteudo) {
        String[] linha = conteudo.split("/");
        
        String[][] dados = new String[linha.length][4];
        
        String[] info;
        for (int i = 0; i < linha.length; i++) {
            info = linha[i].split(";");
            for (int j = 0; j < dados[0].length; j++) {
                dados[i][j] = info[j];
            }
        }
        
        return dados;
    }
    
    public static String lerFich() throws FileNotFoundException {
        String conteudo = "";
        
        Scanner ler = new Scanner(new File("Clientes.txt"), "UTF-8");
        
        while(ler.hasNextLine()) {
            conteudo += ler.nextLine().trim();
            conteudo += "/";
        }
        
        return conteudo;
    }
    
}
