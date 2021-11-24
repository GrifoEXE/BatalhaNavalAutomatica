import java.io.FileWriter;
import java.io.IOException;

public class Principal
{
    public static void main(String[] args)
    {
        Jogador teste = new Jogador();
        Jogo gameplay = new Jogo();
        iniciarJogo(gameplay);
    }

    public static void iniciarJogo(Jogo gameplay)
    {
        String fileAtaquesP1 = "ataques1.txt";
        String fileAtaquesP2 = "ataques2.txt";
        String fileResultado = "saida.txt";

        do {
            gameplay.realizarAtaqueP1();     //Vez do Jogador atacar
            gameplay.realizarAtaqueP2();    //Vez do Computador Contra Atacar

        }
        while(gameplay.getGanhou() == 0);

        int j = gameplay.ataquesP1.size();

        try
        {
            FileWriter fw1 = new FileWriter(fileAtaquesP1);
            for (int i = 0; i < j; i++)
            {
                fw1.write(gameplay.ataquesP1.get(i) + "\n");
            }
            fw1.close();

        }catch(IOException e){
            System.out.println("Um erro do tipo IO ocorreu no arquivo ataques1.txt");
        }
        int k = gameplay.ataquesP2.size();

        try
        {
            FileWriter fw2 = new FileWriter(fileAtaquesP2);
            for (int i = 0; i < k; i++)
            {
                fw2.write(gameplay.ataquesP2.get(i) + "\n");
            }
            fw2.close();

        }catch(IOException e){
            System.out.println("Um erro do tipo IO ocorreu no arquivo ataques2.txt");
        }

        try
        {
            FileWriter fw3 = new FileWriter(fileResultado);
            //Mensagem Final do jogo
            if (gameplay.getGanhou() == 1) {
                fw3.write("P1 Ganhou" + "\n");
            }
            else if (gameplay.getGanhou() == -1){
                fw3.write("P2 Ganhou" + "\n");
            }
            fw3.write("Ataques P1: "+ gameplay.ataquesP1.size() + "\n");
            fw3.write("Ataques P2: "+ gameplay.ataquesP2.size() + "\n");

            fw3.close();
        }
        catch( IOException e) {
            System.out.println("Um erro do tipo IO ocorreu no arquivo ataques2.txt");
        }

    }

}
