/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janeiro2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Grupo3 {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        String fichMarcas = lerFich("Marcas");
        String fichVendas = lerFich("Vendas");

        String[] marcas = preencherVetorMarcas(fichMarcas);

        double[] vendas = new double[marcas.length];
        int[] totalvendas = new int[marcas.length];

        preencherVetorVendasEtotalVendas(marcas, vendas, totalvendas, fichVendas);

        ordenarDecrescente(marcas, vendas, totalvendas);

        criarFich(marcas, vendas, totalvendas, "TOP");
        /*for (int i = 0; i < marcas.length; i++) {
         System.out.println(marcas[i] + " " + vendas[i] + " " + totalvendas[i]);
         }*/
    }

    public static void criarFich(String[] marcas, double[] vendas, int[] totalvendas, String nomeFich) throws FileNotFoundException, UnsupportedEncodingException {
        Formatter escrFich = new Formatter(new File(nomeFich + ".txt"), "UTF-8");

        for (int i = 0; i < marcas.length; i++) {
            escrFich.format("%s %.2f %d%n", marcas[i], vendas[i], totalvendas[i]);
        }

        escrFich.close();
    }

    public static void ordenarDecrescente(String[] marcas, double[] vendas, int[] totalvendas) {
        String straux;
        double daux;
        int iaux;

        for (int i = 0; i < marcas.length - 1; i++) {
            for (int j = i + 1; j < marcas.length; j++) {
                if (totalvendas[i] < totalvendas[j]) {
                    straux = marcas[i];
                    marcas[i] = marcas[j];
                    marcas[j] = straux;

                    daux = vendas[i];
                    vendas[i] = vendas[j];
                    vendas[j] = daux;

                    iaux = totalvendas[i];
                    totalvendas[i] = totalvendas[j];
                    totalvendas[j] = iaux;
                }
            }
        }
    }

    public static int procurarMarcas(String[] marcas, String marca) {
        for (int i = 0; i < marcas.length; i++) {
            if (marcas[i].equalsIgnoreCase(marca)) {
                return i;
            }
        }

        return -1;
    }

    public static void preencherVetorVendasEtotalVendas(String[] marcas, double[] vendas, int[] totalVendas, String fichVendas) {
        String[] linhas = fichVendas.split("#");

        int guardarEm;
        for (int i = 0; i < linhas.length; i++) {
            String[] colunas = linhas[i].split(":");

            guardarEm = procurarMarcas(marcas, colunas[0]);

            if (guardarEm != -1) {
                vendas[guardarEm] = Double.parseDouble(colunas[1].replace(",", "."));
                totalVendas[guardarEm]++;
            }
        }
    }

    public static String[] preencherVetorMarcas(String fichMarcas) {
        return fichMarcas.split("#");
    }

    public static String lerFich(String nomeFich) throws FileNotFoundException {
        Scanner lerFich = new Scanner(new File(nomeFich + ".txt"), "UTF-8");
        String str, conteudo = "";

        while (lerFich.hasNextLine()) {
            str = lerFich.nextLine().replaceAll(" |€", "");

            if (str.length() > 0) {
                conteudo += str + "#";
            }
        }

        return conteudo.replaceAll("[#]+", "#");
    }

}
