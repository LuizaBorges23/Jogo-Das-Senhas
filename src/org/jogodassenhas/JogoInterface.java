package org.exemple;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JogoInterface extends Remote {
    void jogar(int tentativa) throws RemoteException;
    void mostrarjogo() throws RemoteException;

}
