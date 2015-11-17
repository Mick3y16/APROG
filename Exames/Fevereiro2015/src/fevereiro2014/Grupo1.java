package fevereiro2014;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Grupo1 {
    /*
    ED:
        num, numnovo, pot, dig INTEIRO
    
    ALG
        INICIO
            REPETIR
                ESCREVER("Introduza um número positivo com 4 algarismos")
                LER(num)
            ENQUANTO (num < 1000)
    
            numnovo <- 0
            pot <- 1
    
            ENQUANTO (num <> 0) FAZER
                dig <- num MOD 10
                num <- num DIV 10

                SE (dig MOD 2 = 0) 
                ENTÃO
                    numnovo <- numnovo + dig * pot
                    pot <- pot * 10
                SENÃO SE (pot <> 1)
                    ESCREVER(numnovo)
                    numnovo <- 1
                    pot <- 1
                FIMSE
                
            FIMENQUANTO
        FIM    
    */
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        long num, numnovo, pot,dig;
        
        do {
            System.out.println("Introduza um número de 4 algarismos positivo:");
            num = ler.nextLong();
        } while(num < 1000);
        
        numnovo = 0;
        pot = 1;        
        while (num != 0) {
            dig = num % 10;
            //System.out.println(dig);
            num /= 10;
            if (dig % 2 == 0) {
                numnovo += dig * pot;
                pot *= 10;
            } else if (pot != 1) {
                System.out.println(numnovo);
                numnovo = 0;
                pot = 1;
            }
        }
        
    }
    
}
