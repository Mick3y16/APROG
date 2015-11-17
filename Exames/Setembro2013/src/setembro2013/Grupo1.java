/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setembro2013;

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
            num, numorg, novonum, cont, qtd INTEIRO
        
        ALG
            INICIO
                REPETIR
                    ESCREVER("Introduza um número de 4 algarismos positivo:")
                    LER(num)
                ENQUANTO (num < 999)
        
                cont <- 0
                numorg <- num
                numnovo <- 0
        
                ENQUANTO (numorg <> 0) FAZER
                    num <- num DIV 10
                    cont <- cont + 1
                FIM ENQUANTO
        
                REPETIR
                    ESCREVER("Introduza um valor em 1 e", cont ,".")
                    LER(qtd)
                ENQUANTO (qtd < 1 OU qtd > cont)
        
                PARA (i = 0 ATÉ i = qtd PASSO +1) FAZER
                    div <- num MOD 10
                    
                    numnovo <- numnovo x 10 + dig
                    
                    num <- num DIV 10
                FIMPARA
        
                SE (num <> 0)
                    ENTÃO
                        numnovo <- POT(10, cont - qtd) * numnovo + num
                FIMSE
                
                ESCREVER (numnovo)
        
                FIMENQUANTO                    
            FIM
        */
    }
}
