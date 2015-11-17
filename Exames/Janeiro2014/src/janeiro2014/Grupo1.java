/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janeiro2014;

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
           num, numpar, numimp, contpar, contimp, dig INTEIRO
        
        ALG
            INICIO
                LER(num)
                ENQUANTO (num < 1) FAZER        
                    contpar <- 0
                    contimp <- 0
                    
                    ENQUANTO (num <> 0) FAZER
                        dig <- num MOD 10
        
                        SE (dig MOD 2 = 0) ENTÃO
                            numpar <- numpar + POT(10, contpar) * dig
                            contpar <- contpar + 1
                        SENÃO
                            numimp <- numimp + POT(10, contimp) * dig
                            contimp <- contimp + 1
                        FIMSE
                        
                    FIMENQUANTO
        
                    SE (numpar = 0) ENTÃO
                        ESCREVER("Não foi possivel criar um número par")
                        ESCREVER(numimp)
                    SENÃO SE (numimp = 0) ENTÃO
                        ESCREVER(numimp)
                        ESCREVER("Não foi possivel criar um número par")
                    SENÃO
                        ESCREVER(numpar)
                        ESCREVER(numimp)
                    FIMSE
        
                    LER(num)
                FIMENQUANTO
            FIM
        
        */
    }
    
}
