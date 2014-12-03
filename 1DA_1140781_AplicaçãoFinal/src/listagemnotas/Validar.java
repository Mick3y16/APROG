/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listagemnotas;

import java.util.InputMismatchException;

/**
 *
 * @author Pedro Moreira
 */
public class Validar {

    /**
     * Este método tem como função verificar se um dado aluno existe dentro de
     * uma matriz. Caso o mesmo exista, o método retorna a linha em que o dito
     * aluno se encontra, caso não exista retorna -1.
     * 
     * @param mat
     * @param str
     * @param a
     * @return 
     */
    public static int aluno(String[][] mat, String str, int a) {
        for (int i = 0; i < a; i++) {
            if (mat[i][0].equals(str.trim())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Este método tem como função validar o input do utilizador de forma a
     * determinar se o mesmo é um inteiro ou não.
     * 
     * @return 
     */
    public static int inteiro() {
        try {
            System.out.printf(Global.INPUT_OPTION);
            return Main.scan.nextInt();
        } catch (InputMismatchException e) {
            Main.scan.next();
            return -1;
        }
    }

    /**
     * Este método tem como função verificar se uma dada string é ou não um 
     * double e se o mesmo está entre o seguinte intervalo: [ 0, 100 ]
     * 
     * Caso esteja retorna true, senão retorna false.
     * 
     * @param str
     * @return 
     */
    public static boolean fraccionario(String str) {
        str = str.replace(",", ".").replace("%", "").trim();

        try {
            double perc = Double.parseDouble(str);
            if (perc >= 0 && perc <= 100) {
                return true;
            }
        } catch (NumberFormatException e) {
        }
        return false;
    }

    /**
     * Este método verifica o comprimento de um dado vector é igual a 2. Caso
     * seja, retorna true.
     * 
     * @param vec
     * @return
     */
    public static boolean nparm(String[] vec) {
        return vec.length == 2;
    }

    /**
     * Este método verifica se uma dada string contém ou não números. Caso
     * contenha, retorna false.
     * 
     * @param str
     * @return 
     */
    public static boolean nome(String str) {
        return !str.matches(".*[0-9!\"#$%&'()*+,-./:;<=>?@^_`´{|}~ºª£§€«»\\[\\]\\\\\\\\].*");
    }

    /**
     * Este método tem como função formatar um nome lido, depois de o mesmo ser 
     * validado, capitalizando as primeiras letras de cada nome e colocando as
     * restantes em minusculas.
     * 
     * @param str
     * @return 
     */
    public static String nomeformatar(String str) {
        
        str = str.toLowerCase();
        String[] vectemp = str.split(" ");
        
        String pl, strf = "";
        for (int i = 0; i < vectemp.length; i++) {
            if (vectemp[i].equals("de") ||
                vectemp[i].equals("do") ||
                vectemp[i].equals("dos") ||
                vectemp[i].equals("da") ||
                vectemp[i].equals("das"))
            {
                pl = Character.toString(vectemp[i].charAt(0));
            } else {
                pl = Character.toString(vectemp[i].charAt(0)).toUpperCase();
            }
            strf += pl;
            for (int j = 1; j < vectemp[i].length(); j++) {
                strf += vectemp[i].charAt(j);
            }
            strf += " ";
        }
        
        return strf;
    }
    
    /**
     * Este método verifica se um elemento já se encontra guardado numa dada
     * matriz e caso se encontre retorna false, de forma a que ele não seja 
     * guardado novamente.
     * 
     * @param mat
     * @param str
     * @param a
     * @return 
     */
    public static boolean numrep(String[][] mat, String str, int a) {
        for (int i = 0; i < a; i++) {
            if (mat[i][0].equals(str.trim())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Este método verifica se uma dada string é ou não um número. Caso seja,
     * retorna true.
     * 
     * @param str
     * @return 
     */
    public static boolean numero(String str) {
        try {
            Integer.parseInt(str.trim());
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }
    
    /**
     * Este método tem como função verificar se a string passada existe dentro
     * da matriz. Caso exista o método retorna a sua posição.
     * 
     * @param mat
     * @param str
     * @return 
     */
    public static int qindice(String[][] mat, String str) {
        for (int i = 0; i < mat[0].length-1; i++) {
            if (str.equals(mat[0][i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Este método verifica se uma dada questão já se encontra inserida na 
     * grelha de forma a que ela não seja guardada novamente.
     * 
     * @param mat
     * @param str
     * @param q
     * @return 
     */
    public static boolean qrep(String[][] mat, String str, int q) {
        for (int i = 0; i < q; i++) {
            if (mat[0][i].equals(str.trim())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Este método tem como função verificar se o valor passado como parametro
     * está entre o comprimento da matriz, também passada como parametro.
     * 
     * @param mat
     * @param i
     * @return 
     */
    public static boolean questao(String[][] mat, int i) {
        return i < mat[0].length && i > 0;
    }

    /**
     * Este método verifica o comprimento de uma dada string. Caso o comprimento
     * da string seja igual ao valor passado também por parametro, ele retorna
     * true.
     * 
     * @param str
     * @param t
     * @return 
     */
    public static boolean strcomp(String str, int t) {
        return str.trim().length() == t;
    }

    /**
     * Este método verifica o comprimento de uma string de forma a ver se a
     * mesma se encontra vazia ou não. Caso esteja, retorna false.
     * 
     * @param str
     * @return
     */
    public static boolean strnula(String str) {
        return str.trim().length() > 0;
    }

}
