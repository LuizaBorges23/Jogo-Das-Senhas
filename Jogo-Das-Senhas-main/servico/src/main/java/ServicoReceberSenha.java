import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServicoReceberSenha extends Remote {
    void receberSenha(Integer senha) throws RemoteException;
    ServicoReceberSenha[] receberSenha();
}
