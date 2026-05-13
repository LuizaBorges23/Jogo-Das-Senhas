package servico;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServicoInterfaceIMPL extends UnicastRemoteObject implements ServicoInterface {
    //senha dos jogadores
    private int[] senhaPlayer1;
    private int[] senhaPlayer2;


    public ServicoInterfaceIMPL() throws RemoteException {
        super();
    }


    @Override
    public void validarSenha(int[] senha) throws RemoteException {
      if (senha == null || senha.length != 4 ) {
          throw new RemoteException("ERRO!!");
      }
          for(int i : senha){
              if(i < 1 || i > 6){
                  throw new RemoteException("ERRO!!");
              }
          }
          System.out.println("Validando Senha");

      }



    //deixando no sistema a nossa senha até ela atender a primeiro jogador que ACERTAR a senha
    @Override
    public void armazenarSenhas(int[] senha, int playerID) throws RemoteException {
        //validando se a senha ta nas regras jogo
        validarSenha(senha);

        if(playerID == 1){
            //se player1 enviou a senha vai ser a senha que o player2 vai tentar adivinhar
            this.senhaPlayer2 = senha;
            System.out.println("Armazenando Senha");
        }else if(playerID == 2){
            //se player1 enviou a senha vai ser a senha que o player2 vai tentar adivinhar
            this.senhaPlayer1 = senha;
            System.out.println("Armazenando Senha");
        }else{
            throw new RemoteException("ERRO!!");
        }

    }

    @Override
    public int[] comparaTentativas(int[] tentativas, int playerID) throws RemoteException {
        //Senha de comparação com base no player que está jogado;
        int[] senhaAlvo = (playerID == 1) ? senhaPlayer1:senhaPlayer2;
        //regras dos pinos
        int corretos = 0;
        int deslocados = 0;

        boolean[] pinoSenhaUsado = new boolean[4];
        boolean[] pinoTentativaUsado = new boolean[4];
        //senha de comparação não definida nula
        if (senhaAlvo==null){
            throw new RemoteException("Senha não definida");
        }
//para toda senha que tentarmos sinalizar
        for(int i =0; i < 4; i++){
            if(tentativas[i] == senhaAlvo[i]){
                corretos++;
                pinoSenhaUsado[i] = true;
                pinoTentativaUsado[i] = true;
            }
        }


        for(int i = 0; i < 4; i++){
            if (!pinoSenhaUsado[i]){
                for(int j = 0; j < 4; j++){
                    if(!pinoSenhaUsado[j] && tentativas[i] == senhaAlvo[j]){
                        deslocados++;
                        pinoSenhaUsado[j] = true;
                        break;
                    }
                }
            }
        }
        return new int[]{corretos, deslocados} ;
    }

    @Override
    public JogadorCallBack registrarJogador(JogadorCallBack callback) throws RemoteException {
        return callback;
    }

    @Override
    public void receberSenha(Integer senha) throws RemoteException {

    }


}
