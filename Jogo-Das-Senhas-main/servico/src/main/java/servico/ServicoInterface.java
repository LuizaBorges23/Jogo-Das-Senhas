package servico;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ServicoInterface extends Remote {

    //metodo de validação de senha
    void validarSenha(int[] senha) throws RemoteException;
//registra no servidor a senha que o jogador definiu para o seu oponente
    void armazenarSenhas(int[] senha, int playerID) throws RemoteException;
//recebe a jogada de um player, e compara com a senha armazenada e retorna um feedback
    int[] comparaTentativas(int[] tentativas, int playerID) throws RemoteException;
//registrar jogador no jogo
    JogadorCallBack registrarJogador (JogadorCallBack callback) throws RemoteException;
    void receberSenha(Integer senha) throws RemoteException;


}
