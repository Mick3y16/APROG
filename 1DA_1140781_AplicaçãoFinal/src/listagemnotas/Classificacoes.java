/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listagemnotas;

/**
 *
 * @author Pedro Moreira
 */
public class Classificacoes {

    public static void actualizarInfo(String[][] mat1, String[][] mat2, double[][] mat3, int a) {
        String num;
        Main.scan.nextLine();
        do {
            System.out.printf("Insira o nº do aluno: ");
            num = Main.scan.nextLine();
            if (!Validar.strnula(num)) {
                System.out.printf(Global.ERROR_NUMBER_NULL);
            } else if (!Validar.numero(num)) {
                System.out.printf(Global.ERROR_NUMBER_NOT);
            } else if (!Validar.strcomp(num, 7)) {
                System.out.printf(Global.ERROR_NUMBER_SIZE);
            } else if (Validar.numrep(mat1, num, a)) {
                System.out.printf(Global.ERROR_NUMBER_EXISTS_NOT);
            }
        } while (!Validar.strnula(num) || !Validar.numero(num) || !Validar.strcomp(num, 7) || Validar.numrep(mat1, num, a));
        int i = Validar.aluno(mat1, num, a);
        
        int op;
        do {
            mostrarAluno(mat1, mat2, mat3, i);
            
            System.out.printf(Global.RESET + "Qual o campo que pretende alterar? [ 1. Nome | 2. Resultados | 0. Concluído ]");
            op = Validar.inteiro();
            if (op < 0 || op > 2) {
                System.out.printf(Global.ERROR_OPTION_INVALID);
            }
            
            Main.scan.nextLine();
            switch (op) {
                case 0:
                    System.out.printf(Global.EDIT_DONE);
                    break;
                case 1:
                    String nome;
                    do {
                        System.out.print("Digite o novo nome a ser guardado: ");
                        nome = Main.scan.nextLine();
                        if (!Validar.strnula(nome)) {
                            System.out.printf(Global.ERROR_NAME_NULL);
                        } else if (!Validar.nome(nome)) {
                            System.out.printf(Global.ERROR_NAME_NOT);
                        }
                    } while (!Validar.strnula(nome) || !Validar.nome(nome));

                    mat1[i][1] = Validar.nomeformatar(nome);
                    break;
                case 2:
                    int q;
                    do {
                        System.out.printf("Qual o resultado que pretende alterar?%n");
                        int k = 0;
                        System.out.printf("[ ");
                        while (k < mat2[0].length - 2) {
                            System.out.print((k + 1) + ". " + mat2[0][k] + " | ");
                            k++;
                        }
                        System.out.printf(k + 1 + ". " + mat2[0][k] + " ]: ");
                        q = Validar.inteiro();
                        if (!Validar.questao(mat2, q)) {
                            System.out.printf(Global.ERROR_OPTION_INVALID);
                        }
                    } while (!Validar.questao(mat2, q));
                    String perc;
                    do {
                        System.out.printf("Insira o resultado correcto: ");
                        perc = Main.scan.next();
                        if (!Validar.fraccionario(perc)) {
                            System.out.printf(Global.ERROR_PERCENT_NOT);
                        }
                    } while (!Validar.fraccionario(perc));

                    mat3[i][mat3[0].length - 1] -= mat3[i][q - 1] * (Double.parseDouble(mat2[1][q - 1]) / 500);
                    mat3[i][q - 1] = Double.parseDouble(perc.replace(",", ".").replace("%", "").trim());
                    mat3[i][mat3[0].length - 1] += mat3[i][q - 1] * (Double.parseDouble(mat2[1][q - 1]) / 500);

                    break;
                default:
                    break;
            }
        } while (op != 0);
    }
    
    private static void mostrarAluno(String[][] mat1, String[][] mat2, double[][] mat3, int n) {
        /* Nº, Nome, Questões e Total */
        System.out.printf("%n"+Global.ALUNO_TABLE, Global.ALUNO_TABLE_C1, Global.ALUNO_TABLE_C2);
        for (int i = 0; i < mat2[0].length - 1; i++) {
            System.out.printf(Global.GRELHA_HEAD, mat2[0][i]);
        }
        System.out.printf(Global.CLASS_TOTAL_HEAD);
        
        /* Aluno e respectivas classificações */
        System.out.printf(Global.ALUNO_TABLE, mat1[n][0], mat1[n][1]);

        /* Listar as classificações de forma dinamica */
        int j = 0;
        while (j < mat3[0].length - 1) {
            System.out.printf(Global.CLASS_BODY, mat3[n][j]);
            j++;
        }
        System.out.printf(Global.CLASS_TOTAL_BODY, mat3[n][mat3[0].length - 1]);
        System.out.printf("%n%n");
    }

    /**
     * Este método tem como função combinar as 3 matrizes criadas anteriormente
     * de forma a mostrar as classificações.
     *
     * @param mat1
     * @param mat2
     * @param mat3
     * @param a
     */
    public static void mostrarClass(String[][] mat1, String[][] mat2, double[][] mat3, int a) {

        /* Titulo e descrição */
        System.out.printf(Global.GRELHA_TITLE, mat2[0][mat2[0].length - 1]);
        System.out.printf(Global.GRELHA_DESCR, mat2[1][mat2[0].length - 1]);

        /* Nº, Nome, Questões e Total */
        System.out.printf(Global.ALUNO_TABLE, Global.ALUNO_TABLE_C1, Global.ALUNO_TABLE_C2);
        for (int i = 0; i < mat2[0].length - 1; i++) {
            System.out.printf(Global.GRELHA_HEAD, mat2[0][i]);
        }
        System.out.printf(Global.CLASS_TOTAL_HEAD);

        /* Espaçamento, Valor das questões */
        System.out.printf(Global.ALUNO_TABLE, "", "");
        for (int i = 0; i < mat2[0].length - 1; i++) {
            System.out.printf(Global.GRELHA_HEAD2, mat2[1][i]);
        }
        System.out.printf(Global.TABLE_DIV);

        /* Listagem dos alunos e respectivas classificações */
        for (int i = 0; i < a; i++) {
            System.out.printf(Global.ALUNO_TABLE, mat1[i][0], mat1[i][1]);

            /* Listar as classificações de forma dinamica */
            int j = 0;
            while (j < mat3[0].length - 1) {
                System.out.printf(Global.CLASS_BODY, mat3[i][j]);
                j++;
            }
            System.out.printf(Global.CLASS_TOTAL_BODY, mat3[i][mat3[0].length - 1]);
            System.out.println();
        }
    }

    /**
     * Este método tem como função ordenar a matriz que contém os alunos,
     * pelo nome ou número, fazendo corresponder a matriz das classificações 
     * a cada um deles.
     *
     * @param mat1
     * @param mat2
     * @param a
     * @param column
     */
    public static void ordenarAlun(String[][] mat1, double[][] mat2, int a, int column) {
        for (int i = 0; i < a - 1; i++) {
            for (int j = i + 1; j < a; j++) {
                if (mat1[i][column].compareTo(mat1[j][column]) > 0) {
                    ordenar(mat1, mat2, i, j);
                }
            }
        }
    }

    /**
     * Este método tem como função ordenar a matriz que contém os alunos,
     * numéricamente, fazendo corresponder a matriz das classificações a cada um
     * deles.
     *
     * @param mat1
     * @param mat2
     * @param a
     */
    public static void ordenarPositiv(String[][] mat1, double[][] mat2, int a) {
        for (int i = 0; i < a - 1; i++) {
            for (int j = i + 1; j < a; j++) {
                if (mat2[i][mat2[0].length - 1] < mat2[j][mat2[0].length - 1]) {
                    ordenar(mat1, mat2, i, j);
                }
            }
        }
    }

    /**
     * Este método tem como função trocar as linhas das matrizes passadas por
     * parametro, nas respectivas posições.
     */
    private static void ordenar(String[][] mat1, double[][] mat2, int i, int j) {
        String[] vaux1;

        vaux1 = mat1[i];
        mat1[i] = mat1[j];
        mat1[j] = vaux1;

        double[] vaux2;

        vaux2 = mat2[i];
        mat2[i] = mat2[j];
        mat2[j] = vaux2;
    }

    /**
     * Este método tem como função contar e retornar o número de classificações
     * acima de um dado valor.
     *
     * @param mat
     * @param a
     * @return
     */
    public static int contarPositivas(double[][] mat, int a) {
        int p = 0;
        for (int i = 0; i < a; i++) {
            if (mat[i][mat[0].length - 1] >= Global.POSITIVA) {
                p++;
            }
        }
        return p;
    }

}
