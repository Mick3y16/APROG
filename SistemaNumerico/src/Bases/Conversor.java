package Bases;

import java.util.Scanner;

public class Conversor {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int baseact, basefin;
        boolean valido;
        String num;

        System.out.println("Em que base se encontra o número que pretende inserir? [2-16]");
        do {
            baseact = scan.nextInt();
            if (baseact < 2 || baseact > 16) {
                System.out.print("Inseriu uma base inválida, tente novamente: ");
            }
        } while (baseact < 2 || baseact > 16);

        do {
            System.out.print("Por favor, insira um número: ");
            num = scan.next();
            valido = validador(num, baseact);
            if (valido == false) {
                System.out.println("O número inserido não existem em base " + baseact + ".");
            }
        } while (valido == false);

        System.out.println("Para que base pretende converter o número? [2-16]");
        do {
            basefin = scan.nextInt();
            if (basefin < 2 || basefin > 16) {
                System.out.print("Inseriu uma base inválida, tente novamente: ");
            }
        } while (basefin < 2 && basefin > 17);

        if (basefin == baseact) {
            System.out.println("O número já se encontra na base inserida, o programa irá terminar.");
        } else {
            int numdecimal = convdecimal(num, baseact);

            if (basefin != 10) {
                String nvnum = convbasefin(numdecimal, basefin);
                System.out.print("O número " + num + " de base " + baseact + " é equivalente ao número " + nvnum + " em base " + basefin + ".");
            } else {
                System.out.print("O número " + num + " de base " + baseact + " é equivalente ao número " + numdecimal + " em base " + basefin + ".");
            }

        }
    }

    public static int convdecimal(String num, int baseact) {
        int k = 0, tamanho = num.length() - 1, valor, numdecimal = 0;

        while (tamanho >= 0) {
            char caracter = num.charAt(tamanho);

            valor = numeralizar(caracter);

            numdecimal += valor * Math.pow(baseact, k);

            k++;
            tamanho--;
        }

        return numdecimal;
    }

    public static String convbasefin(int numdecimal, int basefin) {
        String nvnum = "";

        while (numdecimal != 0) {

            int dig = numdecimal % basefin;

            nvnum += caracterizar(dig);

            numdecimal /= basefin;
        }

        return new StringBuilder(nvnum).reverse().toString();
    }

    public static boolean validador(String num, int baseact) {
        boolean validacao = true;
        int k = 0, tamanho = num.length();

        while (k < tamanho && validacao == true) {
            char caracter = num.charAt(k);

            int valor = numeralizar(caracter);

            if (valor / baseact >= 1) {
                validacao = false;
            }
            k++;
        }

        return validacao;
    }

    public static char caracterizar(int digito) {
        switch (digito) {
            case 10:
                return 'A';
            case 11:
                return 'B';
            case 12:
                return 'C';
            case 13:
                return 'D';
            case 14:
                return 'E';
            case 15:
                return 'F';
            default:
                return (char) (digito + 48);
        }
    }

    public static int numeralizar(char caracter) {
        switch (caracter) {
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            default:
                return Character.getNumericValue(caracter);
        }
    }

}
