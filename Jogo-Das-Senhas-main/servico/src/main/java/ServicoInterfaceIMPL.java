import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServicoInterfaceIMPL extends UnicastRemoteObject implements ServicoInterface {

    protected ServicoInterfaceIMPL(int port) throws RemoteException {
        super(port);
    }

    @Override
    public void validarSenha(String senha) throws RemoteException {

    }

    @Override
    public void estadoPartida() throws RemoteException {

    }

    @Override
    public void armazenarSenhas() throws RemoteException {

    }
}
