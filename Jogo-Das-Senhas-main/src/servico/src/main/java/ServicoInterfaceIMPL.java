import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServicoInterfaceIMPL extends UnicastRemoteObject implements ServicoInterface {
    //senha dos jogadores
    private int senha;
    //Receber as senhas dos jogadores
    private ServicoReceberSenha receberSenha;

    public ServicoInterfaceIMPL(int senha) throws RemoteException {
        this.senha = senha;
    }

    //metodo de validação de senha
    @Override
    public void validarSenha(ServicoReceberSenha receberSenha) throws RemoteException {

        do{
            System.out.println(senha);
        }while (senha == true);{
            receberSenha();
            validarSenha(receberSenha);
        }

    }


    //Metodo para receber a senha
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


//deixando no sistema a nossa senha até ela atender a primeiro jogador que ACERTAR a senha
    @Override
    public void armazenarSenhas(ServicoReceberSenha receberSenha) throws RemoteException {
        receberSenha();
    }

}
