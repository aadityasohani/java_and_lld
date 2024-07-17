public class SavingsAccount extends Account{
    private final double interestRate = 3.5;
    SavingsAccount(String accountNumber){
        super(accountNumber);
    }

    @Override
    public void withdraw(double amount){
        if(amount > balance){
            System.out.println("Insufficient Balance");
        }else{
            balance -= amount;
        }
    }

    @Override
    public void deposit(double amount){
        balance += amount;
    }

    public void addInterest(){
        balance = balance + balance*this.interestRate/100;
    }
}
