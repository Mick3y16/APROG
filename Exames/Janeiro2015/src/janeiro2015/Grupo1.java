/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janeiro2015;

import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Grupo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
            ED:
                num, numaux, totaldigitos, codigo, pardig, digrepetidor, digrepetido, i INTEIRO
        
            ALG
                INICIO
                    ESCREVER("Introduza o número:")
                    LER(num)
                    
                    totaldigitos <- 0
                    numaux <- num
        
                    ENQUANTO (numaux <> 0) FAZER
                        numaux <- numaux DIV 10
                        totaldigitos <- totaldigitos + 1
                    FIMENQUANTO
        
                    SE (totaldigitos MOD 2 = 0)
                    ENTÃO
                        totaldigitos <- 0
                        codigo <- 0
        
                        ENQUANTO (num <> 0) FAZER
                            pardig <- num MOD 100;
                            digrepetido <- pardig MOD 10
                            digrepetidor <- pardig DIV 10
        
                            PARA (i = 0 ATÉ digrepetidor PASSO + 1) FAZER
                                codigo <- codigo + digrepetido * POT(10, totaldigitos)
                                totaldigitos <- totaldigitos + 1
                            FIMPARA
        
                            num <- num DIV 100
                        FIMENQUANTO
        
                        ESCREVER(codigo)
                    SENÃO
                        ESCREVER("O número não tem um total de digitos par.")
                    FIMSE
                FIM
        
        */
        Scanner ler = new Scanner(System.in);
        int num, numaux, totaldigitos, codigo, pardig, digrepetidor, digrepetido, i;
        
        System.out.println("Introduza o número:");
        num = ler.nextInt();
        
        totaldigitos = 0;
        numaux = num;
        while (numaux != 0) {
            numaux /= 10;
            totaldigitos++;
        }
        
        if (totaldigitos % 2 == 0) {
            
            totaldigitos = 0;
            codigo = 0;
            while (num != 0) {
                pardig = num % 100;
                
                digrepetido = pardig % 10;
                digrepetidor = pardig / 10;
                
                for (i = 0; i < digrepetidor; i++) {
                    codigo += digrepetido * (int) Math.pow(10, totaldigitos);
                    totaldigitos++;
                }
                
                num /= 100;
            }
            
            System.out.println(codigo);
        } else {
            System.out.println("O número não tem um total de digitos par.");
        }
    }
    
}
