public class BankFacade
{
  
    private readonly AccountService account;
    private readonly LoanService loan;

    public BankFacade()
    {
        
        account = new AccountService();
        loan = new LoanService();
    }

    
    public void DoBanking()
    {
        Console.WriteLine("Iniciando operações bancárias");

        
        account.CheckSaldo();
        loan.ApplyLoan();

        Console.WriteLine("Operações bancárias finalizadas");
    }
}