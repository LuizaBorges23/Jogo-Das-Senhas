import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServicoInterfaceIMPL extends UnicastRemoteObject implements ServicoInterface {

    private int senha;
    private ServicoReceberSenha receberSenha;

    public ServicoInterfaceIMPL(int senha) throws RemoteException {
        this.senha = senha;
    }

    @Override
    public void validarSenha(ServicoReceberSenha receberSenha) throws RemoteException {

     /*   do{
            System.out.println(senha);
        }while (senha == 4);{
            receberSenha();
            validarSenha(receberSenha);
        }

      */
    }

    private void receberSenha() {
        for (ServicoReceberSenha s : receberSenha.receberSenha()) {
            try{
                s.receberSenha( senha );
                System.out.println( "Senha recebida com sucesso!" );
            }catch (Exception e){
                System.out.println( "Erro ao receber senha!" );
            }

        }
    }

    @Override
    public void estadoPartida() throws RemoteException {
        armazenarSenhas(receberSenha);
        atualizarSenhas(receberSenha, true);

    }

    @Override
    public void armazenarSenhas(ServicoReceberSenha receberSenha) throws RemoteException {
        receberSenha();
    }


    @Override
    public void atualizarSenhas(ServicoReceberSenha receberSenha, boolean status) throws RemoteException {
        if (status == true) {
            System.out.println("Status atualizado com sucesso");
        }else{
            System.out.println("Erro ao atualizarStatus");
        }
    }


}
