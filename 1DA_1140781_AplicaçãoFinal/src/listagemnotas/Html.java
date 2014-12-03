/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listagemnotas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

/**
 *
 * @author Pedro Moreira
 */
public class Html {

    /**
     * Este método tem como função combinar as 3 matrizes criadas anteriormente
     * de forma a criar uma página HTML com os resultados de cada aluno.
     *
     * @param mat1
     * @param mat2
     * @param mat3
     * @param a
     */
    public static void criarPagina(String[][] mat1, String[][] mat2, double[][] mat3, int a) {
        try (Formatter grdfich = new Formatter(new File(Global.WORK_DIR + Global.PAGINA_HTML), Global.CHAR_ENCODING)) {
            System.out.printf(Global.FILE_HTML_SAVED);

            head(grdfich);

            legenda(grdfich, mat2);
            
            tabela(grdfich, mat1, mat2, mat3, a);

            mostrardata(grdfich);
            
            grdfich.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
        }

    }

    /**
     * Este método tem como função criar o cabeçalho da página html, que apesar 
     * de não ser directamente visivel ao utilizador, está encarregue de dizer
     * ao broswer o charset usado e definir o estilo da página.
     * 
     * @param html 
     */
    private static void head(Formatter html) {
        html.format(""
                + "<!DOCTYPE html>%n"
                + "<html>%n"
                + "<head>%n"
                + "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />%n"
                + "\t<title>Listagem de notas</title>%n"
                + "<style>%n"
                + "body { padding: 40px; }%n"
                + "table { border: 1px; }%n"
                + "thead { background-color: #808080; }%n"
                + "tbody { background-color: #cccccc; }%n"
                + "tbody > tr:hover { background-color: #e6e6e6; }%n"
                + "td { padding: 2px 10px; }%n"
                + ".total { font-weight: bold; text-align: center; }%n"
                + "</style>%n"
                + "</head>%n");
    }

    /**
     * Este método tem como função apresentar o titulo e a descrição na página
     * HTML.
     * 
     * @param html
     * @param mat 
     */
    public static void legenda(Formatter html, String[][] mat) {
        html.format(""
                + "<body>%n"
                + "\t<h2>%s</h2>%n"
                + "\t<p>%s</p>%n", mat[0][mat[0].length - 1], mat[1][mat[0].length - 1]);
   
    }
    
    /**
     * Este método tem como função criar a tabela das classificações interligando
     * todas as matrizes passadas por parametro.
     * 
     * @param html
     * @param mat1
     * @param mat2
     * @param mat3
     * @param a 
     */
    private static void tabela(Formatter html, String[][] mat1, String[][] mat2, double[][] mat3, int a) {
    /* Início do cabeçalho da tabela */
        
        /* Coluna do Nº e Nome dos alunos */
        html.format(""
                + "\t<table>%n"
                + "\t\t<thead>%n"
                + "\t\t<tr>%n"
                + "\t\t\t<td><strong>Nº</strong></td>%n"
                + "\t\t\t<td><strong>Nome</strong></td>%n");

        /* Coluna de cada uma das questões do exame */
        for (int i = 0; i < mat2[0].length - 1; i++) {
            html.format(""
                + "\t\t\t<td><strong>%s<br/>%s</strong></td>%n", mat2[0][i], mat2[1][i]+"%");
        }

        /* Coluna do total */
        html.format(""
                + "\t\t\t<td><strong>Total (0-20)</strong></td>%n"
                + "\t\t</tr>"
                + "\t\t</thead>%n");

    /* Início do corpo da tabela */
        html.format(""
                + "\t\t<tbody>%n");

        /* Listagem do nº e nome de cada aluno */
        for (int i = 0; i < a; i++) {
            html.format(""
                + "\t\t<tr>%n"
                + "\t\t\t<td>%s</td>%n"
                + "\t\t\t<td>%s</td>%n", mat1[i][0], mat1[i][1]);

            /* Para cada aluno listar os resultados de cada uma das questões */
            int k = 0;
            while (k < mat3[0].length - 1) {
                html.format(""
                + "\t\t\t<td>%.0f%%</td>%n", mat3[i][k]);
                k++;
            }
            /* e respectivo total */
            html.format(""
                + "\t\t\t<td class=\"total\">%.1f</td>%n"
                + "\t\t</tr>%n", mat3[i][mat3[0].length - 1]);
            }

        /* Fim */
        html.format(""
                + "\t\t</tbody>%n"
                + "\t</table>%n");
    }
    
    /**
     * Este método tem como função apresentar a data no final do ficheiro HTML
     * 
     * @param html 
     */
    public static void mostrardata(Formatter html) {
        html.format(""
                + "\t<p>Data: %s</p>%n"
                + "</body>%n"
                + "</html>%n", data());
    }

    /**
     * Este método tem como função calcular a data actual e retornar o dia, mês
     * e ano corrente, formatado da seguinte forma: dia-mês-ano
     *
     * @return
     */
    private static String data() {
        Date verdata = new Date();
        SimpleDateFormat date = new SimpleDateFormat(Global.HTML_DATE);
        return date.format(verdata);
    }

}
