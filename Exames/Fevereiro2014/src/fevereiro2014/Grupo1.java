/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fevereiro2014;

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
            lim1, lim2, num, novonum, c INTEIRO
        
        ALG
            INICIO

                REPETIR
                    ESCREVER("Introduza o intervalo:")
                    LER(lim1, lim2)
                ENQUANTO (lim1 < 0 E lim2 <= lim1)

                LER(num)

                ENQUANTO (num > lim1 E num < lim2) FAZER
                    novonum <- 0
                    c <- 0

                    ENQUANTO (num <> 0) FAZER
                        dig <- num MOD 10
        
                        SE (dig MOD 2 = 0)
                            ENTÃO
                                dig <- dig + 1
                            SENÃO
                                dig <- dig - 1
                        FIMSE

                        novonum <- novonum + POT (10, c) * dig
                        c <- c + 1
        
                        num <- num DIV 10
        
                    FIMENQUANTO
        
                    ESCREVER(novonum)
        
                    LER (num)
       
                FIMENQUANTO        
            FIM       
        */
        
    }
    
}
