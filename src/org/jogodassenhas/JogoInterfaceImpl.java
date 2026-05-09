package org.jogodassenhas;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class JogoInterfaceImpl extends UnicastRemoteObject implements JogoInterface {

    private int tentativa;
    private String nome;

    protected JogoInterfaceImpl(int tentativa, String nome) throws RemoteException {
        this.tentativa = tentativa;
        this.nome = nome;
    }


    @Override
    public void jogar(int tentativa) throws RemoteException {

    }

    @Override
    public void mostrarjogo() throws RemoteException {

    }
}
