import java.util.Random;
public class Jogador
{
    /**
     * Atributos de Classe
     * tabuleiro - representa a matriz que armazena o campo de batalha
     * navios - armazena a posição dos navios no campo
     */

    //Atributos
    private int acertos = 0;
    int[][] tabuleiro;
    int[][] navios;
    int tiros = 0;

    public Jogador()
    {
        //Gera um novo tabuleiro
        this.tabuleiro = new int[10][10];
        this.navios = new int[10][10];
        this.tiros = 0;

    }

    public int getAcertos()
    {
        return acertos;
    }

    public void incrementaAcertos()
    {
        acertos++;
    }


     //* Método feito para posicionar návios no mapa do jogo
     //* de acordo com as coordenadas recebidas e já validadas
     //* pela classe jogo.

    public void posicionarNavios(int li, int lf, int ci, int cf){

        //Condicional para posicionar em linha vertical (cima para baixo)
        if (lf > li && ci == cf){

            for (int linha = li; linha <= lf; linha++){

                this.navios[linha][ci] = 1;
            }

        }
        //Condicional para posicionar em linha vertical (baixo para cima)
        if (li > lf)
        {

            for (int linha = li; linha >= lf; linha--){

                this.navios[linha][ci] = 1;
            }

        }

        //Condicional para posicionar em linha horizontal (esquerda para direita)
        if (cf > ci){

            for (int coluna = ci; coluna <= cf; coluna++){

                this.navios[li][coluna] = 1;
            }

        }
        //Condicional para posicionar em linha horizontal (direita para esquerda)
        if (ci > cf){

            for (int coluna = ci; coluna >= cf; coluna--){

                this.navios[li][coluna] = 1;
            }

        }

    }


     // Método para validar se uma posição escolhida pelo usuário está
     // disponivel para o posicionamento d eum novo navio.
    //Método Anti-Sobreposição
    public boolean verificaDisponibilidade(int li, int lf, int ci, int cf){

        boolean retorno = true;
        //vertical
        if (lf > li && ci == cf)
        {

            for (int linha = li; linha <= lf; linha++){

                if (this.navios[linha][ci] == 1){
                    retorno = false;
                }

            }

        }

        if (li > lf){

            for (int linha = li; linha >= lf; linha--){

                if (this.navios[linha][ci] == 1) retorno = false;
            }

        }

        if (cf > ci){

            for (int coluna = ci; coluna <= cf; coluna++){

                if (this.navios[li][coluna] == 1) {
                    retorno = false;
                }
            }

        }

        if (ci > cf){

            for (int coluna = ci; coluna >= cf; coluna--){

                if (this.navios[li][coluna] == 1) {
                    retorno = false;
                }
            }

        }

        return retorno;

    }

    /**
     * Método que distribui Randomicamente os Navios pelo mapa em
     * posição vertical.
     */
    //Posicionar Navios aleatoriamente
    public void sortearNavios(){

        Random sorteio = new Random();

        int[] ci = new int[2]; //Coordenadas Iniciais
        int[] cf = new int[2]; //Coordenadas Finais

        // Submarinos
        for (int i = 0; i < 4; i++)
        {
            int probabilidade = sorteio.nextInt(10);
            if (probabilidade >= 5)
            {
                //Posicionamento Submarinos (1x2)
                do{
                    ci[0] = sorteio.nextInt(10);
                    ci[1] = sorteio.nextInt(10);
                    if(ci[0] < 9){
                        cf[0] = ci[0] + 1;
                        cf[1] = ci[1];
                    }
                    else{
                        cf[0] = ci[0] - 1;
                        cf[1] = ci[1];
                    }
                }while(!verificaDisponibilidade(ci[0], cf[0], ci[1], cf[1]));
                posicionarNavios(ci[0], cf[0], ci[1], cf[1]);
            }
            else
            {
                //Posicionamento Submarinos (2x1)
                do{
                    ci[0] = sorteio.nextInt(10);
                    ci[1] = sorteio.nextInt(10);
                    if(ci[1] < 9){
                        cf[0] = ci[0];
                        cf[1] = ci[1] + 1;
                    }
                    else{
                        cf[0] = ci[0];
                        cf[1] = ci[1] - 1;
                    }
                }while(!verificaDisponibilidade(ci[0], cf[0], ci[1], cf[1]));
                posicionarNavios(ci[0], cf[0], ci[1], cf[1]);
            }

        }

        for (int i = 0; i < 3; i++)
        {
            int probabilidade = sorteio.nextInt(10);
            if (probabilidade >= 5) {
                //Posicionamento ContraTorpedeiros (1x3)
                do {
                    ci[0] = sorteio.nextInt(10);
                    ci[1] = sorteio.nextInt(10);
                    if (ci[0] < 8) {
                        cf[0] = ci[0] + 2;
                        cf[1] = ci[1];
                    } else {
                        cf[0] = ci[0] - 2;
                        cf[1] = ci[1];
                    }
                } while (!verificaDisponibilidade(ci[0], cf[0], ci[1], cf[1]));
                posicionarNavios(ci[0], cf[0], ci[1], cf[1]);
            }else{
                //Posicionamento ContraTorpedeiros (3x1)
                do {
                    ci[0] = sorteio.nextInt(10);
                    ci[1] = sorteio.nextInt(10);
                    if (ci[1] < 8) {
                        cf[0] = ci[0];
                        cf[1] = ci[1] + 2;
                    } else {
                        cf[0] = ci[0];
                        cf[1] = ci[1] - 2;
                    }
                } while (!verificaDisponibilidade(ci[0], cf[0], ci[1], cf[1]));
                posicionarNavios(ci[0], cf[0], ci[1], cf[1]);
            }
        }


        for (int i = 0; i < 2; i++)
        {
            int probabilidade = sorteio.nextInt(10);
            if (probabilidade >= 5) {
                //Posicionamento Navios-Tanque (1x4)
                do {
                    ci[0] = sorteio.nextInt(10);
                    ci[1] = sorteio.nextInt(10);
                    if (ci[0] < 7) {
                        cf[0] = ci[0] + 3;
                        cf[1] = ci[1];
                    } else {
                        cf[0] = ci[0] - 3;
                        cf[1] = ci[1];
                    }
                } while (!verificaDisponibilidade(ci[0], cf[0], ci[1], cf[1]));
                posicionarNavios(ci[0], cf[0], ci[1], cf[1]);
            }else{
                //Posicionamento Navios-Tanque (4x1)
                do {
                    ci[0] = sorteio.nextInt(10);
                    ci[1] = sorteio.nextInt(10);
                    if (ci[1] < 7) {
                        cf[0] = ci[0];
                        cf[1] = ci[1] + 3;
                    } else {
                        cf[0] = ci[0];
                        cf[1] = ci[1] - 3;
                    }
                } while (!verificaDisponibilidade(ci[0], cf[0], ci[1], cf[1]));
                posicionarNavios(ci[0], cf[0], ci[1], cf[1]);
            }
        }
        int probabilidade = sorteio.nextInt(10);
        if (probabilidade >= 5) {
            //Posicionamento Porta-Aviões (1x5)
            do {
                ci[0] = sorteio.nextInt(10);
                ci[1] = sorteio.nextInt(10);
                if (ci[0] < 6) {
                    cf[0] = ci[0] + 4;
                    cf[1] = ci[1];
                } else {
                    cf[0] = ci[0] - 4;
                    cf[1] = ci[1];
                }
            } while (!verificaDisponibilidade(ci[0], cf[0], ci[1], cf[1]));
            posicionarNavios(ci[0], cf[0], ci[1], cf[1]);
        }
        else{
            //Posicionamento Porta-Aviões (5x1)
            do {
                ci[0] = sorteio.nextInt(10);
                ci[1] = sorteio.nextInt(10);
                if (ci[1] < 6) {
                    cf[0] = ci[0];
                    cf[1] = ci[1] + 4;
                } else {
                    cf[0] = ci[0];
                    cf[1] = ci[1] - 4;
                }
            } while (!verificaDisponibilidade(ci[0], cf[0], ci[1], cf[1]));
            posicionarNavios(ci[0], cf[0], ci[1], cf[1]);
        }

    }

    //* verifica se o disparo acertou ou não
    public int verificaAcerto(int[] tiro)
    {

        if (tabuleiro[tiro[0]][tiro[1]] != 0) return -1;   //Ja atacou este lugar

        if (navios[tiro[0]][tiro[1]] == 1){ //Acertou tiro

            tabuleiro[tiro[0]][tiro[1]] = 1;
            return 1;
        }
        else{
            tabuleiro[tiro[0]][tiro[1]] = -1;   //Errou tiro
            return 0;
        }

    }
}
