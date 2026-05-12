import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ServicoInterface extends Remote {
    int registrarJogador (JogadorCallBack callback) throws RemoteExeption;
    void armazenarSenha(int jogadorId, int[] senha) throws RemoteException;
    validarSenha (int jogadorId, int[] senhaChute);
}

//    void validarSenha (ServicoReceberSenha receberSenha) throws RemoteException;
//    void estadoPartida() throws RemoteException;
//    void armazenarSenhas(ServicoReceberSenha receberSenha) throws RemoteException;
//    void atualizarSenhas(ServicoReceberSenha receberSenha, boolean status) throws RemoteException;