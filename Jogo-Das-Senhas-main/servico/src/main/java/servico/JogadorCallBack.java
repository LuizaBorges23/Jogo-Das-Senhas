package servico;
import java.rmi.Remote;

import java.rmi.RemoteException;


public interface JogadorCallBack extends Remote {

    void inicioJogo() throws RemoteException;

    // Se houver vítoria, derrota ou empate
    void finalizaJogo(String resultado) throws RemoteException;

    // Resposta para palpite do jogador e tentativas restantes
    void resultadoSenha(int corretos, int deslocados, int valorTentativaRestante, boolean palpiteResultado) throws RemoteException;

    // Jogada do adversário idependente de qual seja o jogador (a ou b)
    void jogoAdversario (int corretos, int deslocados, int [] valorPalpite) throws RemoteException;
}