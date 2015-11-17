package fevereiro2014;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Formatter;
import java.util.Scanner;

/*
 *
 * @author Pedro
 */
public class Grupo3 {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner ler = new Scanner(System.in);

        System.out.println("Digite o mês:");
        String mes = ler.next();
        System.out.println("Digite o ano:");
        String ano = Integer.toString(ler.nextInt());

        String[] funcionarios = new String[50];
        double[] salarios = new double[50];
        int[] horasExtra = new int[50];

        int n = lerFicheiroInfo(mes, ano, funcionarios, salarios, horasExtra);

        calcularSalarioTotal(n, salarios, horasExtra);
        ordenarDecrescente(n, funcionarios, salarios);
        
        criarFicheiroSalarios(n, mes, ano, funcionarios, salarios);
    }

    public static void criarFicheiroSalarios(int n, String mes, String ano, String[] funcionarios, double[] salarios) throws FileNotFoundException, UnsupportedEncodingException {
        Formatter escFich = new Formatter(new File("Salarios" + mes + ano + ".txt"), "UTF-8");
        
        for (int i = 0; i < n; i++) {
            escFich.format("%s/%.2f%n", funcionarios[i], salarios[i]);
        }
        
        escFich.close();
    }

    public static void ordenarDecrescente(int n, String[] funcionarios, double[] salarios) {
        String straux;
        double dblaux;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (salarios[i] < salarios[j]) {
                    dblaux = salarios[i];
                    salarios[i] = salarios[j];
                    salarios[j] = dblaux;
                    
                    straux = funcionarios[i];
                    funcionarios[i] = funcionarios[j];
                    funcionarios[j] = straux;
                }
            }
        }
    }

    public static void calcularSalarioTotal(int n, double[] salarios, int[] horasExtra) {
        for (int i = 0; i < n; i++) {
            salarios[i] += (salarios[i] / 100) * horasExtra[i];
        }
    }

    public static void criarFicheiroErros(String erros) throws FileNotFoundException, UnsupportedEncodingException {
        Formatter escFich = new Formatter(new File("Erros.txt"), "UTF-8");

        escFich.format("%s", erros);
        escFich.close();
    }

    public static void preencherVetores(int n, String[] info, String[] funcionarios, double[] salarios, int[] horasExtra) {
        funcionarios[n] = info[0].trim();
        salarios[n] = Double.parseDouble(info[1].trim());

        if (info.length == 3) {
            horasExtra[n] = Integer.parseInt(info[2].trim());
        }
    }

    public static int lerFicheiroInfo(String mes, String ano, String[] funcionarios, double[] salarios, int[] horasExtra) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner lerFich = new Scanner(new File("Info" + mes + ano + ".txt"), "UTF-8");
        String linhas, erros = "";
        String[] info;
        int n = 0;

        while (lerFich.hasNextLine() && n < 50) {
            linhas = lerFich.nextLine();

            if (linhas.length() > 0) {
                info = linhas.split("/");

                if (info.length < 2 || info.length > 3) {
                    erros += linhas+ "\n";
                } else {
                    preencherVetores(n, info, funcionarios, salarios, horasExtra);
                    n++;
                }
            }
        }

        if (erros.length() > 0) {
            criarFicheiroErros(erros);
        }

        return n;
    }
}
