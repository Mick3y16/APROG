
package pl6;

import java.util.Scanner;

/**
 *
 */
public class ex6 {
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        String[] visitantes = new String[100];
        int n = 0;
        
        char op;
        System.out.print(""
                    + "\nO que pretende fazer?"
                    + "\n1 - Visualizar o menu."
                    + "\n2 - Inserir um visitante."
                    + "\n3 - Listar todos os visitantes."
                    + "\n4 - Actualizar um nome dado."
                    + "\n5 - Eliminar um visitante dado."
                    + "\n6 - Listar os nomes começados por uma dada letra."
                    + "\n7 - Listar os nomes repetidos."
                    + "\n8 - Terminar");
        do {
            System.out.print("\nOpção: ");
            op = scan.next().charAt(0);
            
            
            switch(op) {
                case '1':
                    mostrarMenu();
                    break;
                case '2':
                    scan.nextLine();
                    System.out.print("Digite o nome: ");
                    String nome = scan.nextLine();
                    n = inserirVisitante(visitantes, nome, n);
                    break;
                case '3':
                    System.out.println("Lista de Visitantes: ");
                    listarVisitantes(visitantes, n);
                    break;
                case '4':
                    System.out.print("Digite o número do visitante que pretende alterar: ");
                    int i = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Insira o nome nome: ");
                    String novonome = scan.nextLine();
                    boolean apagou = actualizarVisitantes(visitantes, novonome, i, n);
                    if (apagou == true) {
                        System.out.println("O nome foi alterado com sucesso.");
                    } else {
                        System.out.println("Não foi possível alterar o nome.");
                    }
                    break;
                case '5':
                    System.out.print("Digite o número do visitante que pretende apagar: ");
                    int d = scan.nextInt();
                    n = apagarVisitante(visitantes, d, n);                    
                    break;
                case '6':
                    System.out.print("Quer procurar visitantes com o nome iniciado por que letra? ");
                    char ch = scan.next().charAt(0);
                    System.out.println("Lista de Visitantes, cujo nome começa por "+ch+":");
                    listarVisitantesporCar(visitantes, ch, n);
                    break;
                case '7':
                    System.out.println("Lista de nomes repetidos:");
                    listarVisitantesRep(visitantes, n);
                    break;
                case '8':
                    // Terminar
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while(op != 7);
    }
    
    public static void listarVisitantesRep(String[] vec, int n) {
        String[] nomesrep = new String[50];
        int r = 0;
        
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(vec[i].equals(vec[j])) {
                    int contrep = 0; 
                    
                    for (int l = 0; l < r; l++) {
                        if(nomesrep[l].equals(vec[i])) {
                            contrep++;
                        }
                    }
                    
                    if (contrep == 0) {
                        nomesrep[r] = vec[i];
                        r++;
                    }
                }
            }
            
        }
        
        for (int i = 0; i < r; i++) {
            System.out.println(nomesrep[i]);
        }
        
    }
    
    public static void listarVisitantesporCar(String[] vec, char ch, int n) {
        for (int i = 0; i < n; i++) {            
            if (ch == (vec[i].charAt(0))) {
                System.out.println(vec[i]);
            }
        }
    }
    
    public static int apagarVisitante(String[] vec, int i, int n) {
        if(i-1 < n) {
            for (int j = i - 1; j < n - 1; j++) {
                vec[j] = vec[j + 1];
            }
            return --n;
        } else {
            return n;
        }
    }
    
    public static boolean actualizarVisitantes(String[] vec, String nome, int i, int n) {
        if (i > n) {
            return false;
        } else {
            vec[i-1] = nome;
            return true;
        }
    }
    
    public static void listarVisitantes(String[] vec, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println((i+1)+" - "+vec[i]);
        }
    }
    
    public static int inserirVisitante(String[] vec, String nome, int n) {
        for (int i = n; i < n+1; i++) {
            vec[i] = nome;
        }
        
        return ++n;
    }
    
    public static void mostrarMenu() {
          System.out.print(""
                    + "\nO que pretende fazer?"
                    + "\n1 - Visualizar o menu."
                    + "\n2 - Inserir um visitante."
                    + "\n3 - Listar todos os visitantes."
                    + "\n4 - Actualizar um nome dado."
                    + "\n5 - Eliminar um visitante dado"
                    + "\n6 - Listar os nomes começados por uma dada letra"
                    + "\n7 - Listar os nomes repetidos."
                    + "\n8 - Terminar");
    }
    
}
