
package pl6;

import java.util.Scanner;

/**
 * O método principal do programa permite relizar a execucção de 2 métodos
 * disponiveis na classe Enigma e termina quando o utilizador selecionar a opção
 * 3.
 *
 * O método lerNomes() tem como função realizar uma leitura de nomes e guarda-
 * -los num vector, a leitura para quando o limite do array for atingido ou o
 * utilizador inserir a palavra FIM.
 *
 * O método listar() apresenta os primeiros n elementos do vector passado.
 *
 * O metodo enigma() tem como função apagar um valor dentro do vector passado e
 * num dado intervalo, usando para isso o vector em questão, uma string e um n.
 * Caso o valor não exista o método não faz nada.
 *
 */
//public class Enigma {
public class ex3 {

    /**
     *
     * - Foi alterado o conteúdo da String m.
     * - Foi adicionado um novo case para o método listar
     * - A classe Scanner foi inicializada na classe em vez de ser inicializada
     * no método, visto ser necessária em mais que um. 
     * - O método lista foi alterado para void, em vez de int, visto que a unica
     * coisa que faz é gerar a listagem dos n primeiros valores. ...
     * - Adicinei uma validação antes de executar o método de listar, para nunca
     * ser maior que o vector.
     */
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = 0;
        String nomes[] = new String[100];
        String m = "O que pretende fazer?\n1-Ler Nomes\n2-Listar Nomes\n3-Apagar Nome\n3-Terminar\nOpção: ";
        char op;
        do {
            System.out.print(m);
            op = scan.next().charAt(0);
            switch (op) {
                case '1':
                    n = lerNomes(nomes);
                    break;
                case '2':
                    int k;
                    do {
                        System.out.print("Digite quantos nomes quer listar: ");
                        k = scan.nextInt();
                    } while (k > n);
                    listar(nomes, k);
                    break;
                case '3':
                    System.out.println("Nome:");
                    scan.nextLine();
                    String nome = scan.nextLine();
                    n = enigma(nomes, nome, n);
                    break;
                case '4':
                    break;
                default:
                    System.out.println("Opção inválida!!");
            }
        } while (op != '4');
    }

    private static int lerNomes(String[] vec) {
        int n = -1;
        System.out.println("Insira os nomes que pretende ler, para terminar, escreva \"FIM\".");
        scan.nextLine();
        do {
            n++;
            vec[n] = scan.nextLine();
        } while (!vec[n].equals("FIM"));

        return n;
    }

    private static void listar(String[] vec, int n) {
        System.out.println("Lista de nomes:");
        for (int i = 0; i < n; i++) {
            System.out.println(vec[i]);
        }
        System.out.println("");
    }

    private static int enigma(String[] nomes, String nome, int n) {
        int i = 0;
        while (i < n && !nomes[i].equalsIgnoreCase(nome)) {
            i++;
        }
        if (i == n) {
            return n;
        } else {
            for (int j = i; j < n - 1; j++) {
                nomes[j] = nomes[j + 1];
            }
            return --n;
        }
    }
}
