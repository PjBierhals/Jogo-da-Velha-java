/*
Classe Jogo com metodos de exibição e resolução
 */
package trabalho_jogo_da_velha;

import java.util.Scanner;

/**
 *
 * @author pjbier
 */
public class Jogo {

    /**
     *
     */
    public static String matriz[][] = new String[3][3];//matriz global utilizada para simbolizar o tabuleiro
    public static String escolhaSimbolo;//variavel global utilizada para selecionar o simbolo na jogada
    public static boolean empate;//varialvel global para caso de empate 

//inicio dos metodos
    public static void exibeJogada() {//metodo que exibe a matriz em forma de tabuleiro no console a cada jogada
        for (int i = 0; i <= 2; i++) {//controla as linhas da matriz 
            for (int j = 0; j <= 2; j++) {//controla  as colunas da matriz
                System.out.print(matriz[i][j]);//exibe o que ta armazenado na posição especificada
                                               //primeiramente o número depois, a jogada "X" ou "O"
                if (j < 2) {//controla o caracter especial "|" nas  colunas
                            //interagindo com a posição ou jogada 
                    System.out.print(" | ");//exibe ocaracter  dentro da matriz
                }
            }
            System.out.println("");
            if (i < 2) {//controla o caracter especial "---+" nas  linhas
                System.out.print("--+---+---");//exibe a  linha dentro da matriz
            }
            System.out.println("");//pula  para a  proxima linha  apos preenchimento da coluna
        }
    }

    public static void simboloJogador() {//metodo que alterna o número pelo simbolo de cada jogador
        if (escolhaSimbolo.equals("X")) {//verifica o que simbolo que esta armazenado se for o "X", faz a troca "O"
            escolhaSimbolo = "O";
        } else {
            escolhaSimbolo = "X";
        }

    }//representa os dois itens

    public static boolean jogadaJogador(String escolhaSimbolot, int numero) {//altera o numero pelo simbolo
                                         //metodo recebe uma simbolo e um número e retorna verdadeiro ou falso  
        boolean trocaNumLetra = false;//variavel usada para confirmar se o número foi trocado por simbolo "X" ou "O"
        for (int i = 0; i <=2; i++) {//monta  a matriz
            for (int j = 0; j <=2; j++) {
                if (matriz[i][j].equals(Integer.toString(numero))) {//converte a variavel inteira para string
                                        //confere se o numero foi  subistituido o pelo  simbolo
                                        //ou seja se o que está armazenado na posição da matriz for string equivalente ao número
                    matriz[i][j] = escolhaSimbolot;//troca o número pelo simbolo na sua respectiva  posição
                    trocaNumLetra = true;//troca  para  verdadeiro a variavel
                }
                //se o que está armazenado na posição da matriz não for igual ao a número e sim um simbolo
                //não faz nada e retorna falso
            }

        }
        return trocaNumLetra;//armazena o retorno do metodo
    }

    public static boolean verificaJogadas() {
        boolean fimJogo = false;//variavel que controla o fim do jogo
        int oc = 0;//variavel que controla as casa ocupadas

        //verifcalinhas
        for (int linhas = 0; linhas < 3; linhas++) {
            if ((matriz[linhas][0].equals(matriz[linhas][1])) && (matriz[linhas][1].equals(matriz[linhas][2]))) {
                fimJogo = true;//termina o jogo
                System.out.println("Vencedor Player: " + matriz[linhas][1]);//exibe o player vencedor
            }
        }
        //verificacolunas
        for (int colunas = 0; colunas < 3; colunas++) {
            if ((matriz[0][colunas].equals(matriz[1][colunas])) && (matriz[1][colunas].equals(matriz[2][colunas]))) {
                fimJogo = true;
                System.out.println("Vencedor Player: " + matriz[1][colunas]);
            }
        }
        //verificadiagonais
        if (((matriz[0][0].equals(matriz[1][1])) && (matriz[1][1].equals(matriz[2][2])))
                || ((matriz[0][2].equals(matriz[1][1])) && (matriz[1][1].equals(matriz[2][0])))) {
            fimJogo = true;
            System.out.println("Vencedor Player: " + matriz[1][1]);
        }
        for (int i = 0; i < 3; i++) {//monta a matriz e testa se tudo foi ocupado
            for (int j = 0; j < 3; j++) {
                if ((!matriz[i][j].equals("X")) && (!matriz[i][j].equals("O"))) {//se foi diferente de "X"ou "O"
                    oc++;//se ainda  ha alguma conta mais 1
                }
            }
        }
        if (oc == 0) {//se nÃ£o ha mais lugares ha ocupar e nenhuma das opÃ§Ãµes acima foram validadas 
            empate = true;//empate e verdadeiro
            fimJogo = true;
        }

        return fimJogo;
    }

    public static void iniciaTabuleiro() {//preenche o tabuleiro com numeros
        int cont = 1;//contador  para preencher  a matriz na primeira vez 
        for (int i = 0; i < 3; i++) {//usado para preencher  a matriz  com  números
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = Integer.toString(cont);//preenche a posição da matris convertendo o inteiro em string
                cont++;//conta mais um a cada volta do  loop
            }
        }
    }

    public static void testaCasa() {
        Scanner inserir = new Scanner(System.in);
        boolean simPos;
        do {
            System.out.println("Escolha um Numero Para " + escolhaSimbolo);//pede para inserir a casa da matriz
            String escPosi = inserir.next();// //recebe o valor do teclado e armazena na variavel
            if (escPosi.matches("^[1-9]")) {//verifica se o número entre 1  e 9
                int valPosi = Integer.parseInt(escPosi);// se o número é  valido, converte para inteiro
                simPos = jogadaJogador(escolhaSimbolo, valPosi);//chama  o metodo para validar a  posição  trocando  numero pelo  simbolo
                //retornando verdadeiro ou falso
            } else {
                System.err.println("Posição Invalido ou Não é Posição");//se o numero não vor valido ou letra
                simPos = false;
            }
        } while (simPos != true);//fica no loop enquanto simPos não for verdadeiro 
                    //controla   se a troca  foi  feita  tirando do loop

    }

}
