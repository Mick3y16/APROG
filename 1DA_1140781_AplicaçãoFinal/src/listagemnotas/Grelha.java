/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listagemnotas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Pedro Moreira
 */
public class Grelha {

    /**
     * Este método tem como função ler um ficheiro, cujo nome é dado pelo
     * utilizador de forma a preencher a matriz que contém as classificações dos
     * alunos relativamente a cada questão...
     *
     * @param mat1
     * @param mat2
     * @param mat3
     * @param a
     */
    public static void lerResultados(String[][] mat1, String[][] mat2, double[][] mat3, int a) {
        int q;
        Main.scan.nextLine();
        do {
            System.out.printf("Insira o nome da questão para a qual pretende carregar os resultados, (Ex: G1): ");
            String ficheiro = Main.scan.nextLine();
            q = Validar.qindice(mat2, ficheiro);

            if (q != -1) {
                try (Scanner resultado = new Scanner(new File(Global.WORK_DIR + ficheiro+".txt"), Global.CHAR_ENCODING)) {
                    System.out.printf(Global.FILE_RESULT_LOADED, ficheiro);
                    int linha = 1, r = 0;
                    while (resultado.hasNextLine() && r < a) {
                        String str = resultado.nextLine();

                        if (!Validar.strnula(str)) {
                            System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_EMPTYLINE, linha);
                        } else {
                            String[] vectemp = str.split(";");

                            if (!Validar.nparm(vectemp)) {
                                System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_PARAMETERTOTAL, linha);
                            } else if (!Validar.strnula(vectemp[0]) || !Validar.strnula(vectemp[1])) {
                                System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_PARAMETEREMPTY, linha);
                            } else if (!Validar.numero(vectemp[0])) {
                                System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_NUMBER_NOT, linha);
                            } else if (!Validar.strcomp(vectemp[0], 7)) {
                                System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_NUMBER_SIZE, linha);
                            } else if (Validar.numrep(mat1, vectemp[0], a)) {
                                System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_NUMBER_EXISTS_NOT, linha);
                            } else if (!Validar.fraccionario(vectemp[1])) {
                                System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_PERCENT_NOT, linha);
                            } else {
                                int i = Validar.aluno(mat1, vectemp[0], a);

                                mat3[i][mat3[0].length - 1] -= mat3[i][q] * (Double.parseDouble(mat2[1][q]) / 500);
                                mat3[i][q] = Double.parseDouble(vectemp[1].replace(",", ".").replace("%", "").trim());
                                mat3[i][mat3[0].length - 1] += mat3[i][q] * (Double.parseDouble(mat2[1][q]) / 500);
                                r++;
                            }
                        }
                        linha++;
                    }
                    resultado.close();
                } catch (FileNotFoundException ex) {
                    System.out.printf(Global.FILE_RESULT_NOTFOUND, ficheiro+".txt");
                    q = -1;
                }
            } else {
                System.out.printf(Global.ERROR_QUEST_EXISTS_NOT);
            }
        } while (q == -1);
    }

    public static String[][] lerFicheiro() {
        String titulo = Global.DEF_TITLE, descr = Global.DEF_DESCR;
        String[][] mattemp = null;
        int t = 0;
        try (Scanner grelha = new Scanner(new File(Global.WORK_DIR + Global.FILE_GRELHA), Global.CHAR_ENCODING)) {
            System.out.printf(Global.FILE_GRELHA_LOADED);
            int linha = 1, leituras = 0;
            while (grelha.hasNextLine() && leituras < 2) {
                String str = grelha.nextLine();

                if (!Validar.strnula(str)) {
                    System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_EMPTYLINE, linha);
                } else {
                    String[] vectemp = str.split(";");

                    if (leituras == 0) {
                        if (!Validar.nparm(vectemp)) {
                            System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_PARAMETERTOTAL, linha);
                        } else {
                            if (Validar.strnula(vectemp[0])) {
                                titulo = vectemp[0].trim();
                            } else {
                                System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_TITLE_NULL, linha);
                            }
                            if (Validar.strnula(vectemp[1])) {
                                descr = vectemp[1].trim();
                            } else {
                                System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_DESCR_NULL, linha);
                            }
                        }
                    } else {
                        mattemp = new String[2][vectemp.length + 1];
                        int total = 0;

                        for (int i = 0; i < vectemp.length; i++) {
                            String[] vectemp2 = vectemp[i].split("-");

                            if (!Validar.nparm(vectemp2)) {
                                System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_GRELHAPARM_TOTAL, linha, i + 1);
                            } else if (!Validar.strnula(vectemp2[0]) || !Validar.strnula(vectemp2[1])) {
                                System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_GRELHAPARM_NULL, linha, i + 1);
                            } else {
                                String grupo = vectemp2[0].trim();
                                String valor = vectemp2[1].trim().replace("%", "");
                                if (!Validar.qrep(mattemp, grupo, t)) {
                                    System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_GRELHAPARM_EXISTS, linha, i + 1);
                                } else if (!Validar.fraccionario(valor)) {
                                    System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_GRELHAPARM_PERCENT_NOT, linha, i + 1);
                                } else {
                                    mattemp[0][t] = grupo;
                                    mattemp[1][t] = valor;
                                    t++;

                                    total += Integer.parseInt(valor);
                                }
                            }
                        }
                        if (total != 100) {
                            System.out.printf(Global.ERROR_PERCENT_FAIL, linha);
                            return null;
                        }
                    }
                    leituras++;
                }
                linha++;
            }
            grelha.close();
        } catch (FileNotFoundException ex) {
            System.out.printf(Global.FILE_GRELHA_NOTFOUND);
            return null;
        }

        String[][] matfinal = criarGrelha(mattemp, t, titulo, descr);
        if (matfinal[0].length == 1) {
            System.out.printf(Global.FILE_GRELHA_NOTCREATED);
            return null;
        }
        
        return matfinal;
    }

    /**
     * Este método tem como função criar a grelha que guarda as questões e seus
     * respectivos valores, o titulo e a descrição de uma dada prova.
     *
     * @param mat
     * @param t
     * @param str1
     * @param str2
     * @return
     */
    private static String[][] criarGrelha(String[][] mat, int t, String str1, String str2) {
        String[][] matfinal = new String[2][t + 1];

        matfinal[0][matfinal[0].length - 1] = str1;
        matfinal[1][matfinal[0].length - 1] = str2;

        for (int i = 0; i < matfinal.length; i++) {
            for (int j = 0; j < matfinal[0].length - 1; j++) {
                matfinal[i][j] = mat[i][j];
            }
        }
        return matfinal;
    }

    /**
     * Este método tem como função criar uma grelha com o nº de perguntas de um
     * dado exame e o seu respectivo valor, juntamente com o nome e descrição
     * desse mesmo exame.
     *
     * @param mat
     */
    public static void mostrarGrelha(String[][] mat) {
        System.out.printf(Global.GRELHA_TITLE, mat[0][mat[0].length - 1]);
        System.out.printf(Global.GRELHA_DESCR, mat[1][mat[0].length - 1]);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length - 1; j++) {
                System.out.printf(Global.GRELHA_HEAD, (i == 1 ? mat[i][j] + "%" : mat[i][j]));
            }
            System.out.println();
        }
    }

}
