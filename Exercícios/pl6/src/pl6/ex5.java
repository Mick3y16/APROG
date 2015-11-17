
package pl6;

import java.util.Scanner;

/**
 *
 */
public class ex5 {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nomecompleto = new String[100];
        String[] apelido = new String[100];

        System.out.println("Digite os nomes completos que pretende guardar.");
        int n = lerNomes(nomecompleto);

        System.out.println("\nLista de nomes:");
        listarNomes(nomecompleto, n);

        System.out.println("\nLista de nomes, cujo apelido começa por S:");
        int m = preencherVetorApelidosS(nomecompleto, apelido, n);

        listarNomes(apelido, m);
        if (m == 0) {
            System.out.println("Não existem apelidos começados por S.");
        }

        System.out.println("\nPercentagem de nomes, cujo apelido começa por S: " + (m * 100 / n) + "%.");

    }

    public static int lerNomes(String[] vec) {
        int k = -1;

        do {
            k++;

            vec[k] = scan.nextLine();

        } while (!vec[k].equals("FIM") && k < vec.length);

        return k;
    }

    public static void listarNomes(String[] vec, int k) {
        for (int i = 0; i < k; i++) {
            System.out.println(vec[i]);
        }
    }

    public static String apelido(String nomecompleto) {
        String[] vectemp = nomecompleto.split(" ");
        if (!vectemp[vectemp.length - 1].equals(vectemp[0])) {
            return vectemp[vectemp.length - 1];
        } else {
            return " ";
        }
    }

    public static int preencherVetorApelidosS(String[] vec1, String[] vec2, int k) {
        int n = 0;

        for (int i = 0; i < k; i++) {
            if (apelido(vec1[i]).charAt(0) == 'S') {
                vec2[n] = vec1[i];
                n++;
            }
        }
        return n;
    }

}
