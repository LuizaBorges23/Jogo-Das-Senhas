import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ServicoInterface extends Remote {

    void validarSenha (String senha) throws RemoteException;
    void estadoPartida() throws RemoteException;
    void armazenarSenhas() throws RemoteException;

}
