/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setembro2013;

import java.io.FileNotFoundException;

/**
 *
 * @author Pedro
 */
public class Grupo2 {

    public static void main(String[] args) {
        String[][] info = {
            {"PedroMoreira", "9:23", "14:39", "fim", "", "", "", "", "", "", ""},
            {"AbelAndrade", "12:27", "16:52", "19:29", "16:20", "fim", "", "", "", "", ""},
            {"DanielDias", "8:30", "20:30", "17:30", "5:29", "19:00", "13:00", "14:00", "15:17", "18:45", "00:15"}
        };

        int n = 3;
        //lerAcesso(ficheiroxpto, info);

        String[] acessos = obterListaAcessosNoPeriodo(info, n, "0:00", "23:59");

        int i = 0;
        while (!acessos[i].equalsIgnoreCase("fim")) {
            System.out.println(acessos[i]);
            i++;
        }

        String[] contarAcessos = contabilizarAcessoPorUtilizador(acessos);

        i = 0;
        while (!contarAcessos[i].equalsIgnoreCase("fim")) {
            System.out.println(contarAcessos[i]);
            i++;
        }
    }

    public static String[] contabilizarAcessoPorUtilizador(String[] acessos) {
        String[] utilizadores = new String[acessos.length];
        int i = 0;
        while (i < acessos.length && !acessos[i].equalsIgnoreCase("fim")) {
            String[] stuff = acessos[i].split(";");
            utilizadores[i] = stuff[0];
            i++;
        }

        String[] contarAcessos = new String[utilizadores.length];
        int totalacessos = 1, outrocontadorfodasse = 0;
        for (int j = 0; j < i-1; j++) {
            for (int k = j + 1; k < i; k++) {
                if (utilizadores[j].equals(utilizadores[k])) {
                    totalacessos++;
                }
            }
            contarAcessos[outrocontadorfodasse] = utilizadores[j] + ";" + totalacessos;
            outrocontadorfodasse++;
            
            j += totalacessos;
        }
        if (outrocontadorfodasse < i) {
            contarAcessos[outrocontadorfodasse] = "fim";
        }

        return contarAcessos;
    }

    public static String[] obterListaAcessosNoPeriodo(String[][] info, int n, String ini, String fin) {
        String[] acessos = new String[n * 10];
        int e = 0, j;

        for (int i = 0; i < n; i++) {
            j = 1;
            while (j < 11 && !info[i][j].equalsIgnoreCase("fim")) {
                if (converteStringParaInt(info[i][j]) >= converteStringParaInt(ini)
                        && converteStringParaInt(info[i][j]) <= converteStringParaInt(fin)) {
                    acessos[e] = info[i][0] + ";" + info[i][j];
                    e++;
                }
                j++;
            }
        }
        if (e != n * 10) {
            acessos[e] = "fim";
        }

        return acessos;
    }

    public static int lerAcesso(String nomeFx, String[][] info) throws FileNotFoundException {
        /* Lê ficheiros e retorna o numéro de elem lidos.
        
         Matriz info: n x 11
            
         Nome + 10 entradas
        
         */
        return 0;
    }

    public static int converteStringParaInt(String valor) {
        return Integer.parseInt(valor.replaceAll(":", ""));
    }

    public static void listarValores(String[] dados) {
        // Lista um vetor....
    }

}
