
package pl6;

import java.util.Scanner;

/**
 *
 */
public class ex2 {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nome = new String[50];
        double[] vencimento = new double[50];

        int k = 0;

        char op;
        do {
            System.out.print("\nO que pretende fazer?\n1 - Criar lista de funcionários e respectivos vencimentos\n2 - Mostrar funcionários que recebem ordenados inferiores à média\n3 - Apresentar a percentagem de funcionários que recebem ordenados inferiores a um dado valor\n4 - Terminar\nOpção: ");
            op = scan.next().charAt(0);

            switch (op) {
                case '1':
                    k = lerNomes(nome, vencimento);
                    break;
                case '2':
                    if(k != 0) {
                        listagem(nome, vencimento, k);
                    } else {
                        System.out.println("Não existem funcionários guardados.");
                    }
                    break;
                case '3':
                    if(k != 0) {
                        System.out.print("Digite o valor: ");
                        int lim = scan.nextInt();
                        listPerc(vencimento, k, lim);
                    } else {
                        System.out.println("Não existem funcionários guardados.");
                    }
                    break;
                case '4':
                    break;
                default:
                    System.out.println("Opção inválida!!");
            }

        } while (op != '4');
    }

    public static int lerNomes(String[] nome, double[] vencimento) {
        int k = -1;

        System.out.println("Proceda à introdução dos nomes, para terminar digite \"tt\".");
        do {
            k++;

            System.out.print("Insira o nome do " + (k + 1) + "º funcionário: ");
            scan.nextLine();
            nome[k] = scan.nextLine();

            if (!nome[k].equals("tt")) {
                System.out.print("Insira o vencimento em € de " + nome[k] + ": ");
                vencimento[k] = scan.nextDouble();
            }

        } while (!nome[k].equals("tt") && k < nome.length);

        return k;
    }

    public static void listPerc(double[] vencimentos, int x, double val) {
        int c = 0;

        for (int i = 0; i < x; i++) {
            if(vencimentos[i] < val) {
                c++;
            }
        }

        double perc = (double)c*100/x;

        System.out.println("A percetagem de funcionários que recebem abaixo de "+val+"€ é: "+perc+"%");

    }

    public static void listagem(String[] nome, double[] v, int k) {
        System.out.println("Os funcionários com ordenados inferiores à média , são:");
        for (int i = 0; i < k; i++) {
            if (v[i] < calcmed(v, k)) {
                System.out.println(nome[i]);
            }
        }
    }

    public static double calcmed(double[] v, int k) {
        double soma = 0;

        for (int i = 0; i < k; i++) {
            soma += v[i];
        }

        return soma / k;
    }

}
