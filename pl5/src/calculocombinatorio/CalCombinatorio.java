/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculocombinatorio;

/**
 *
 * @author Pedro Moreira
 */
public class CalCombinatorio {
    /*
     * 
     * Disponibiliza métodos associados ao Cálculo Combinatório
     */ 
   
    /*
     * 
     * Calcular o factorial de um número
     *
     * @param num número inteiro não negativo
     * @return o valor do factorial do num
     */ 
    private static long factorial(long num) {
        long fact = 1;
        for (long i = num; i > 1; i = i - 1) {
            fact = fact * i;
        }
        return fact;
    }

    /**
     * 
     * Calcula os arranjo de n p a p
     * 
     * @param n número inteiro não negativo
     * @param p número inteiro não negativo
     * @return o valor
     */
    public static long arranjos(long n, long p) {
        if (n < p) {
            return -1;
        }
        return factorial(n) / factorial(n - p);
    }

    /**
     * 
     * Calcula os combinações de n p a p
     *
     * @param n número inteiro não negativo
     * @param p número inteiro não negativo
     * @return o valor
     */
    public static long combinacoes(long n, long p) {
        if (n < p) {
            return -1;
        }
        return factorial(n) / (factorial(p) * factorial(n - p));
    }

    /**
     * 
     * Calcula os combinações de n
     *
     * @param n número inteiro não negativo
     * @return o valor
     */
    public static long permutacoes(int n) {
        return factorial(n);
    }
}
