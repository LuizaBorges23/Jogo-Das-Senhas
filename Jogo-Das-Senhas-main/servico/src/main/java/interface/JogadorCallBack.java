import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ServicoInterface extends Remote {
    // Se ambos os jogadres se registrarem
    void inicioJogo() throws RemoteException;

    // Se houver vítoria, derrota ou empate
    void finalizaJogo(String resultado) throws RemoteException;

    // Resposta para palpite do jogador e tentativas restantes
    void resultadoSenha(int valorCorreto, int valorDeslocado, int valorTentativaRestante, boolean palpiteResultado) throws RemoteException;

    // Jogada do adversário idependente de qual seja o jogador (a ou b)
    void jogoAdversario (int valorCorreto, int valorDeslocado, int [] valorPalpite) throws RemoteException;
}