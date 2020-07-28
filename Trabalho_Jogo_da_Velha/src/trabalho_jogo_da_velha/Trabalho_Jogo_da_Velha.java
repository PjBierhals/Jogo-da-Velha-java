/*
 Trabalho do segundo, primeira etapa Semestre de Análise e Desenvolvimento de Sistemas
 trabalho consiste em uso de Classe e metodos 
 */
package trabalho_jogo_da_velha;

/**
 *
 * @author pjbier
 */
public class Trabalho_Jogo_da_Velha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jogo.escolhaSimbolo = "X";//variavel inicializada como "X"
        //variavel de controle sobre o simbolo e a posiÃ§Ã£o
        Jogo.iniciaTabuleiro();
        Jogo.exibeJogada();//chama o metodo de exibiÃ§Ã£o da matriz que nÃ£o  Ã© mais null
        do {
            Jogo.testaCasa();
            Jogo.simboloJogador();//troca  o simbolo 
            Jogo.exibeJogada();//exibe  amatriz  ja preenchida
        } while (true!= Jogo.verificaJogadas());//se a verificaÃ§Ã£o foi  dada  como  jogo ganho sai doloop
        if (Jogo.empate == true) {//confere  se o tipo de encerramento foi empate
            System.out.println("Empatou");//exibbe a mensage
        }

    }
}