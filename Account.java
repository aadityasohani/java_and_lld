public abstract class Account {
    protected String accountNumber;
    protected double balance;
    public Account(String accountNumber){
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
}
