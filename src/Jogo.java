import java.util.Random;
import java.util.ArrayList;
public class Jogo
{
    /*
     * Attributes
     * campoJogador -  tabuleiro com os navios do jogador.
     * campoComputador - tabuleiro com os navios do computador.
     * tentativa - armazena o número de jogadas que o jogador fez.
     * acertos - armazena o número de acertos que o jogador fez.
     * disparo - armazena o disparo dado nos turnos.
     */

    //Definindo atributos de jogo
    private int ganhou = 0;
    int tentativas = 0;
    ArrayList<String> ataquesP1 = new ArrayList<String>();
    ArrayList<String> ataquesP2 = new ArrayList<String>();

    //Instanciando objetos para os jogadores 1 e 2
    Jogador P1;
    Jogador P2;

    //Construtor
    public Jogo()
    {
        //Inicializando os objetos instanciados
        this.P1 = new Jogador();
        this.P2 = new Jogador();
        this.P1.sortearNavios();
        this.P2.sortearNavios();

    }

    //retorna -1 se perdeu, 0 se não ha ganhador, e 1 se venceu.
    public int getGanhou(){

        return ganhou;
    }


    //Método para o jogador 1 atacar.
    public void realizarAtaqueP1(){

        Random sorteio = new Random();
        int[] tiro = new int[2];
        this.tentativas++;

        tiro[0] = sorteio.nextInt(10);
        tiro[1] = sorteio.nextInt(10);

        switch (this.P2.verificaAcerto(tiro))
        {
            case -1:
                break;
            case 0:
                String e = "AtaqueP1-  " + "linha: " + tiro[0] + "coluna: " + tiro[1];
                ataquesP1.add(e);
                break;

            case 1:
                e = "Acerto!" + "AtaqueP1-  " + "linha: " + tiro[0] + "coluna: " + tiro[1];
                ataquesP1.add(e);
                this.P1.incrementaAcertos();
                verificaGanhador();
                break;

            default:
                break;

        }

    }
    //Método para o jogador 2 atacar.
    public void realizarAtaqueP2(){

        Random sorteio = new Random();
        int[] tiro = new int[2];
        this.tentativas++;

        //Definindo coordenadas do ataque

            tiro[0] = sorteio.nextInt(10);
            tiro[1] = sorteio.nextInt(10);


        switch (this.P1.verificaAcerto(tiro))
        {
            case -1:
                break;
            case 0:
                String e = "AtaqueP2-  " + "linha: " + tiro[0] + "coluna: " + tiro[1];
                ataquesP2.add(e);
                break;

            case 1:
                e = "Acerto!" + "AtaqueP2-  " + "linha: " + tiro[0] + "coluna: " + tiro[1];
                ataquesP2.add(e);
                this.P2.incrementaAcertos();
                verificaGanhador();
                break;

            default:
                break;

        }

    }


        //Método que verifica a cada jogada se um ganhador ja foi definido.
        // 30 acertos é a quantidade necessária para eliminar todos os barcos de cada jogador.
    public void verificaGanhador(){

        if (this.P1.getAcertos() == 30){

            ganhou = 1;
        }

        if (this.P2.getAcertos() == 30){

            ganhou = -1;
        }

    }

}
