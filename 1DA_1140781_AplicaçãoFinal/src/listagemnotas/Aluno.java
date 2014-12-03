/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listagemnotas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Pedro Moreira
 */
public class Aluno {

    /**
     * Este método tem como função ler um ficheiro de texto e processar os dados
     * do mesmo de forma a criar uma matriz que contenha informação sobre os
     * alunos nele contidos, nomeadamente o nº e o nome.
     *
     * @param mat
     * @return
     */
    public static int lerFicheiro(String[][] mat) {
        int a = 0, linha = 1;

        try (Scanner aluno = new Scanner(new File(Global.WORK_DIR + Global.FILE_ALUNOS), Global.CHAR_ENCODING)) {
            System.out.printf(Global.FILE_ALUNOS_LOADED);
            while (aluno.hasNextLine() && a < mat.length) {
                String str = aluno.nextLine();
                if (!Validar.strnula(str)) {
                    System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_EMPTYLINE, linha);
                } else {
                    String[] vectemp = str.split(";");
                    if (!Validar.nparm(vectemp)) {
                        System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_PARAMETERTOTAL, linha);
                    } else if (!Validar.strnula(vectemp[0]) || !Validar.strnula(vectemp[1])) {
                        System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_PARAMETEREMPTY, linha);
                    } else if (!Validar.numero(vectemp[0])) {
                        System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_NAME_NOT, linha);
                    } else if (!Validar.strcomp(vectemp[0], 7)) {
                        System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_NUMBER_SIZE, linha);
                    } else if (!Validar.numrep(mat, vectemp[0], a)) {
                        System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_NUMBER_EXISTS, linha);
                    } else if (!Validar.nome(vectemp[1])) {
                        System.out.printf(Global.ERROR_PRINTLINE + Global.ERROR_NAME_NOT, linha);
                    } else {
                        mat[a][0] = (vectemp[0].trim());
                        mat[a][1] = Validar.nomeformatar(vectemp[1].trim());
                        a++;
                    }
                }
                linha++;
            }
            aluno.close();
        } catch (FileNotFoundException ex) {
            System.out.printf(Global.FILE_ALUNOS_NOTFOUND);
            return 0;
        }
        return a;
    }

    /**
     * Este método tem como função guardar num ficheiro a matriz que contém os
     * alunos, separando as colunas por " ; ".
     *
     * @param mat
     * @param a
     */
    public static void gravarFicheiro(String[][] mat, int a) {
        try (Formatter gravarficheiro = new Formatter(new File(Global.FILE_ALUNOS), Global.CHAR_ENCODING)) {
            System.out.printf(Global.FILE_ALUNOS_SAVED);

            for (int i = 0; i < a; i++) {
                gravarficheiro.format(Global.ALUNO_FILE_STRUCTURE, mat[i][0], mat[i][1]);
            }

            gravarficheiro.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
        }
    }

    /**
     * Este método tem como função criar uma tabela com a listagem de todos os
     * alunos inseridos, mostrando o nº e nome de todos.
     *
     * @param mat
     * @param a
     */
    public static void mostrarAlunos(String[][] mat, int a) {
        System.out.printf("%n"+Global.ALUNO_TABLE+"%n", Global.ALUNO_TABLE_C1, Global.ALUNO_TABLE_C2);
        for (int i = 0; i < a; i++) {
            System.out.printf(Global.ALUNO_TABLE+"%n", mat[i][0], mat[i][1]);
        }
    }

    /**
     * Este método tem como função adicionar alunos à matriz alunos validando a
     * informação inserida. O número de alunos a ser inserido é dado pelo
     * utilizador.
     *
     * Nº de alunos: - Não pode ser inferior a 0 nem maior do que o espaço
     * disponivel.
     *
     * Nº do aluno: - Não pode ser nulo, tem que ser um número, conter apenas 7
     * digitos e ser unico.
     *
     * Nome: - Não pode ser nulo, nem conter números.
     *
     * @param mat
     * @param a
     * @return
     */
    public static int adicionarAlunos(String[][] mat, int a) {
        int n;
        do {
            System.out.printf("Digite o número de alunos que pretende inserir (0 para cancelar): ");
            n = Main.scan.nextInt();
            if (n < 0) {
                System.out.printf(Global.ERROR_ALUNO_NEGATIVE);
            } else if (n > mat.length - a) {
                System.out.printf(Global.ERROR_ALUNO_MEMORY, (mat.length - a));
            }
        } while (n < 0 || n > mat.length - a);
        if (n == 0) {
            return a;
        } else {
            String num, nome;
            Main.scan.nextLine();
            for (int i = 0; i < n; i++) {
                do {
                    System.out.printf("Número do %dº aluno: ", (i + 1));
                    num = Main.scan.nextLine();
                    if (!Validar.strnula(num)) {
                        System.out.printf(Global.ERROR_NUMBER_NULL);
                    } else if (!Validar.numero(num)) {
                        System.out.printf(Global.ERROR_NUMBER_NOT);
                    } else if (!Validar.strcomp(num, 7)) {
                        System.out.printf(Global.ERROR_NUMBER_SIZE);
                    } else if (!Validar.numrep(mat, num, a)) {
                        System.out.printf(Global.ERROR_NUMBER_EXISTS);
                    }
                } while (!Validar.strnula(num) || !Validar.numero(num) || !Validar.strcomp(num, 7) || !Validar.numrep(mat, num, a));

                do {
                    System.out.printf("Nome do aluno com o nº %s: ", num);
                    nome = Main.scan.nextLine();
                    if (!Validar.strnula(nome)) {
                        System.out.printf(Global.ERROR_NAME_NULL);
                    } else if (!Validar.nome(nome)) {
                        System.out.printf(Global.ERROR_NAME_NOT);
                    }
                } while (!Validar.strnula(nome) || !Validar.nome(nome));

                mat[a][0] = num;
                mat[a][1] = Validar.nomeformatar(nome);
                a++;
            }
            return a;
        }
    }

}
