public class CurrentAccount extends Account{
    private double overdraftLimit;

    CurrentAccount(double overdraftLimit, String accountNumber){
        super(accountNumber);
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public void deposit(double amount){
        balance+=amount;
    }

    @Override
    public void withdraw(double amount){
        if(balance+overdraftLimit<amount){
            System.out.println("Insufficient balance");
        }else{
            double reqWithdrawAmount = amount;
            amount = Math.max(amount - balance, 0.0);
            this.balance -= Math.min(balance, reqWithdrawAmount);
            this.overdraftLimit -= amount;
        }
    }
}
