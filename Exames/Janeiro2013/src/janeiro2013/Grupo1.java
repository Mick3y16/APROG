/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janeiro2013;

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
            num, nvnum, dig, digant, c, p INTEIRO
        ALG 
            INÍCIO
                REPETIR
                    LER(num)
                ENQUANTO (num < 0)
        
                d <- 0
                c <- 0
                digant <- -1
                ENQUANTO (num <> 0)
                    dig <- num MOD 10
                    
                    SE (digant <> dig) 
                        ENTÃO
                            nvnum <- nvnum + POT(10, c) * dig
                            c <- c + 1
                    FIMSE
                    
                    d <- d + 1
                    num <- num DIV 10
                    digant <- dig
                FIMENQUANTO
        
                SE (c <> d)
                    ENTÃO
                        ESCREVER(nvnum)
                    SENÃO
                        ESCREVER("Não foi introduzido um número com algarismos consecutivos.")
                FIMSE
            FIM
        
        */
    }
    
}
