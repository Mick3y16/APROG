/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listagemnotas;

import java.util.Scanner;

/**
 *
 * @author Pedro Moreira
 */
public class Main {

    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        intro();
        String[][] alunos = new String[100][2];

        int n = 0;
        int a = Aluno.lerFicheiro(alunos);

        String[][] grelha = Grelha.lerFicheiro();
        if (grelha == null) {
            System.exit(0);
        }
        /* Método de criar a Grelha caso o retorno falhe... ??? */
        double[][] classificacoes = new double[alunos.length][grelha[0].length];

        int op;
        menu();
        do {
            if (n != a) {
                n = a;
                Classificacoes.ordenarAlun(alunos, classificacoes, a, 1);
            }
            op = Validar.inteiro();
            switch (op) {
                case 1:
                    menu();
                    break;
                case 2:
                    if (a != 0) {
                        Aluno.mostrarAlunos(alunos, a);
                    } else {
                        System.out.printf(Global.ERROR_ALUNO_EMPTY);
                    }
                    break;
                case 3:
                    if (a != alunos.length) {
                        a = Aluno.adicionarAlunos(alunos, a);
                    } else {
                        System.out.printf(Global.ERROR_ALUNO_FULL);
                    }
                    break;
                case 4:
                    if (a != 0) {
                        Aluno.gravarFicheiro(alunos, a);
                    } else {
                        System.out.printf(Global.ERROR_ALUNO_EMPTY);
                    }
                    break;
                case 5:
                    Grelha.mostrarGrelha(grelha);
                    break;
                case 6:
                    Grelha.lerResultados(alunos, grelha, classificacoes, a);
                    break;
                case 7:
                    if (a != 0) {
                        Classificacoes.mostrarClass(alunos, grelha, classificacoes, a);
                    } else {
                        System.out.printf(Global.ERROR_ALUNO_EMPTY);
                    }
                    break;
                case 8:
                    if (a != 0) {
                        Classificacoes.actualizarInfo(alunos, grelha, classificacoes, a);
                    } else {
                        System.out.printf(Global.ERROR_ALUNO_EMPTY);
                    }
                    break;
                case 9:
                    if (a != 0) {
                        int p = Classificacoes.contarPositivas(classificacoes, a);
                        if (p != 0) {
                            Classificacoes.ordenarPositiv(alunos, classificacoes, a);
                            Classificacoes.mostrarClass(alunos, grelha, classificacoes, p);
                            Classificacoes.ordenarAlun(alunos, classificacoes, a, 1);
                        } else {
                            System.out.printf(Global.ERROR_CLASS_POSITIVE_NOT);
                        }
                    } else {
                        System.out.printf(Global.ERROR_ALUNO_EMPTY);
                    }
                    break;
                case 10:
                    if (a != 0) {
                        Classificacoes.ordenarAlun(alunos, classificacoes, a, 0);
                        Html.criarPagina(alunos, grelha, classificacoes, a);
                        Classificacoes.ordenarAlun(alunos, classificacoes, a, 1);
                    } else {
                        System.out.printf(Global.ERROR_ALUNO_EMPTY);
                    }
                    break;
                default:
                    System.out.printf(Global.ERROR_OPTION_INVALID);
                    break;
                case 0:
                    System.out.printf("%n");
                    break;
            }
        } while (op != 0);
    }

    /**
     * Este método tem como função apresentar um menu de opções ao utilizador.
     */
    private static void menu() {
        System.out.printf("%n"
                + "1.  Mostra Menu%n"
                + "2.  Mostrar Alunos%n"
                + "3.  Adicionar Aluno(s)%n"
                + "4.  Gravar Alunos%n"
                + "5.  Mostrar Grelha%n"
                + "6.  Ler Resultados%n"
                + "7.  Mostrar Classificações%n"
                + "8.  Alterar dados%n"
                + "9.  Mostrar Classificações positivas%n"
                + "10. Criar versão WEB das Classificações%n"
                + "0.  Terminar%n");
    }
    
    private static void intro() {
        System.out.printf(""
                + " ________   ________   ________        ________  ___   ________    ________   ___ %n"
                + "|\\   __  \\ |\\   __  \\ |\\   __  \\      |\\  _____\\|\\  \\ |\\   ___  \\ |\\   __  \\ |\\  \\         %n"
                + "\\ \\  \\|\\  \\\\ \\  \\|\\  \\\\ \\  \\|\\  \\     \\ \\  \\__/ \\ \\  \\\\ \\  \\\\ \\  \\\\ \\  \\|\\  \\\\ \\  \\   %n"
                + " \\ \\   __  \\\\ \\   ____\\\\ \\   ____\\     \\ \\   __\\ \\ \\  \\\\ \\  \\\\ \\  \\\\ \\   __  \\\\ \\  \\  %n"
                + "  \\ \\  \\ \\  \\\\ \\  \\___| \\ \\  \\___|      \\ \\  \\_|  \\ \\  \\\\ \\  \\\\ \\  \\\\ \\  \\ \\  \\\\ \\  \\____  %n"
                + "   \\ \\__\\ \\__\\\\ \\__\\     \\ \\__\\          \\ \\__\\    \\ \\__\\\\ \\__\\\\ \\__\\\\ \\__\\ \\__\\\\ \\_______\\%n"
                + "    \\|__|\\|__| \\|__|      \\|__|           \\|__|     \\|__| \\|__| \\|__| \\|__|\\|__| \\|_______|%n"
                + "                                                                             APROG 2014-2015%n");
    }

}
