import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ServicoInterface extends Remote {

    void validarSenha (ServicoReceberSenha receberSenha) throws RemoteException;
    void estadoPartida() throws RemoteException;
    void armazenarSenhas(ServicoReceberSenha receberSenha) throws RemoteException;
    void atualizarSenhas(ServicoReceberSenha receberSenha, boolean status) throws RemoteException;
}
