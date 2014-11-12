
package pl6;

import java.util.Scanner;

/**
 *
 */
public class ex4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Insira o número de valores que pretende guardar: ");
        int n = scan.nextInt();

        int[] numeros = new int[n];
        System.out.print("Insira os valores: ");
        for (int i = 0; i < n; i++) {
            numeros[i] = scan.nextInt();
        }

        char op;
        do {
            System.out.print("\nO que pretende fazer com os valores guardados?\n1 - Apresentar os valores\n2 - Inverter os valores\n3 - Rodar os valores para a direita\n4 - Terminar\nOpção: ");
            op = scan.next().charAt(0);

            switch (op) {
                case '1':
                    listarnum(numeros);
                    break;
                case '2':
                    invertnum(numeros);
                    break;
                case '3':
                    rodarnum(numeros);
                    break;
                case '4':
                    break;
                default:
                    System.out.println("Opção inválida!!");
            }

        } while (op != '4');
    }

    public static void listarnum(int[] vec) {
        System.out.print("Os números guardados são:");
        for (int i = 0; i < vec.length; i++) {
            System.out.print("[" + vec[i] + "]");
        }
        System.out.print("\n");
    }

    public static void invertnum(int[] vec) {
        int aux, j = vec.length - 1;

        for (int i = 0; i < (vec.length - 1) / 2; i++) {
            aux = vec[i];
            vec[i] = vec[j];
            vec[j] = aux;

            j--;
        }
    }

    public static void rodarnum(int[] vec) {
        int n = vec.length - 1, aux = vec[n];

        for (int i = n; i > 0; i--) {
            vec[i] = vec[i - 1];
        }
        vec[0] = aux;
    }

}
