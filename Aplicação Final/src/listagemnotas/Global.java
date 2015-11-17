/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listagemnotas;

/**
 *
 * @author Pedro Moreira
 */
public class Global {

    /* Configurações */
    public static final String WORK_DIR = "src/listagemnotas/ficheiros/"; // Directório de trabalho
    public static final String CHAR_ENCODING = "UTF-8"; // Formato de gravação
    public static final String FILE_ALUNOS = "alunos.txt"; // Nome do ficheiro que contém o nº e nome do aluno
    public static final String FILE_GRELHA = "grelha.txt"; // Nome do ficheiro que contém a grelha de avaliação
    public static final String PAGINA_HTML = "Pagina.html"; // Nome do ficheiro HTML criado pelo programa
    public static final double POSITIVA = 9.5; // Valor considerado como classificação positiva
    public static final String DEF_TITLE = "Sem título"; // Título por defeito
    public static final String DEF_DESCR = "Sem descrição"; // Descrição por defeito

    /* Formatações (Tabelas/Ficheiros) */
    public static final String ALUNO_TABLE_C1 = "Nº"; // Nome da primeira coluna
    public static final String ALUNO_TABLE_C2 = "Nome"; // Nome da segunda coluna
    public static final String ALUNO_TABLE = "%-7s  %-45s"; // Formato das colunas
    public static final String ALUNO_FILE_STRUCTURE = "%s ; %s%n"; // Formato do ficheiro
    public static final String GRELHA_TITLE = "%n%s"; // Formato do Título da grelha
    public static final String GRELHA_DESCR = "%n%s%n%n"; // Formato do Descrição da grelha
    public static final String GRELHA_HEAD = "%6s "; // Formato do Nome da questão
    public static final String GRELHA_HEAD2 = "%6s%%"; // Formato do Valor da questão
    public static final String TABLE_DIV = "%n________________________________________________________________________________________%n%n";
    public static final String CLASS_BODY = "%6.0f%%"; // Formato das Classificações
    public static final String CLASS_TOTAL_HEAD = " Total (0-20)%n"; // Nome da coluna do total
    public static final String CLASS_TOTAL_BODY = "%8.1f"; // Formatado do Valor do Total
    public static final String HTML_DATE = "dd-MM-yyyy"; // Formato do output da data no ficheiro HTML

    /* Cores */
    public static final String RESET = "\u001B[0m"; // Preto
    private static final String R = "\u001B[31m"; // Vermelho
    private static final String G = "\u001B[32m"; // Verde
    private static final String B = "\u001B[34m"; // Azul

    /* Mensagens Input */
    public static final String INPUT_OPTION = B + "%nOpção: " + RESET;
    public static final String EDIT_DONE = G + "Sucesso: Alterações concluidas, irá agora retornar ao menu principal.%n" + RESET;
    /* Mensagens Output sobre ficheiros */
    public final static String FILE_ALUNOS_LOADED = G + "Sucesso: Ficheiro " + FILE_ALUNOS + " carregado em memória.%n" + RESET;
    public final static String FILE_ALUNOS_SAVED = G + "Sucesso: Ficheiro guardado com o nome " + FILE_ALUNOS + ".%n" + RESET;
    public final static String FILE_ALUNOS_NOTFOUND = R + "Erro: O ficheiro " + FILE_ALUNOS + " não foi encontrado, não foram carregados alunos.%n" + RESET;
    public final static String FILE_GRELHA_LOADED = G + "Sucesso: Ficheiro " + FILE_GRELHA + " carregado em memória.%n" + RESET;
    public final static String FILE_GRELHA_NOTFOUND = R + "Erro: Ficheiro " + FILE_GRELHA + " não encontrado, o programa vai encerrar.%n" + RESET;
    public final static String FILE_GRELHA_NOTCREATED = R + "Erro: Não foi possível criar a grelha, o programa vai encerrar.%n" + RESET;
    public final static String FILE_RESULT_LOADED = G + "Sucesso: Ficheiro %s.txt carregado em memória.%n" +RESET;
    public final static String FILE_RESULT_NOTFOUND = R + "Erro: Ficheiro %s.txt não encontrado, tente novamente.%n" + RESET;
    public final static String FILE_HTML_SAVED = G + "Sucesso: Ficheiro guardado com o nome " + PAGINA_HTML + ".%n" + RESET;

    /* Erros... */

    /* ...de leitura */
    public static final String ERROR_PRINTLINE = R+ "Linha %2d, " + RESET;
    public static final String ERROR_FILE_ALUNOS_NOTFOUND = R + "Erro: Ficheiro " + FILE_ALUNOS + " não encontrado, o programa vai encerrar.%n" + RESET;
    public static final String ERROR_EMPTYLINE = R + "Erro: Linha em branco.%n" + RESET;
    public static final String ERROR_PARAMETERTOTAL = R + "Erro: O total de parametros é diferente do pretendido.%n" + RESET;
    public static final String ERROR_PARAMETEREMPTY = R + "Erro: Um ou mais parametros encontram-se vazios.%n" + RESET;

    public static final String ERROR_GRELHAPARM_TOTAL = R + "Erro: A %dª questão tem um número inválido de elementos.%n" + RESET;
    public static final String ERROR_GRELHAPARM_EXISTS = R + "Erro: A %dª questão já existe.%n" + RESET;
    public static final String ERROR_GRELHAPARM_NULL = R + "Erro: A %dª questão tem um ou mais elementos nulos.%n" + RESET;
    public static final String ERROR_GRELHAPARM_PERCENT_NOT = R + "Erro: A %dª questão não tem uma percentagem válida.%n" + RESET;

    /* ...de leitura e input */
    public static final String ERROR_OPTION_INVALID = R + "Erro: Opção inválida.%n" + RESET;
    public static final String ERROR_NAME_NULL = R + "Erro: O nome não pode ser nulo.%n" + RESET;
    public static final String ERROR_NAME_NOT = R + "Erro: O nome só pode ser constituido por letras.%n" + RESET;
    public static final String ERROR_NUMBER_NULL = R + "Erro: O número não pode ser nulo.%n" + RESET;
    public static final String ERROR_NUMBER_NOT = R + "Erro: O número não é válido.%n" + RESET;
    public static final String ERROR_NUMBER_SIZE = R + "Erro: O número deve ter 7 digitos.%n" + RESET;
    public static final String ERROR_NUMBER_EXISTS = R + "Erro: O número já se encontra atribuido a um aluno.%n" + RESET;
    public static final String ERROR_NUMBER_EXISTS_NOT = R + "Erro: O número que inseriu não se encontra atribuido a um aluno.%n" + RESET;
    public static final String ERROR_TITLE_NULL = R + "Erro: O titulo está vazio, foi aplicado um por defeito.%n" + RESET;
    public static final String ERROR_DESCR_NULL = R + "Erro: A descrição está vazia, foi aplicada uma por defeito.%n" + RESET;
    public static final String ERROR_QUEST_EXISTS_NOT = R + "Erro: A questão não existe.%n" + RESET;
    public static final String ERROR_PERCENT_NOT = R + "Erro: Não inseriu uma percentagem válida.%n" + RESET;
    public static final String ERROR_PERCENT_FAIL = R + "Erro: O valor de todas as questões não corresponde a 100%%, o programa vai encerrar.%n" + RESET;

    /* ...de input */
    public static final String ERROR_ALUNO_EMPTY = R + "Erro: Não existem alunos guardados em memória." + RESET;
    public static final String ERROR_ALUNO_FULL = R + "Erro: Não é possível guardar mais alunos em memória." + RESET;
    public static final String ERROR_ALUNO_NEGATIVE = R + "Erro: Não pode inserir um número negativo de alunos.%n" + RESET;
    public static final String ERROR_ALUNO_MEMORY = R + "Erro: Não existe espaço para guardar tantos alunos em memória. Restante: %d espaços.%n" + RESET;
    public static final String ERROR_CLASS_POSITIVE_NOT = R + "Erro: Não existem classificações positivas.%n" + RESET;

}
