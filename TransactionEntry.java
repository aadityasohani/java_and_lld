import java.util.Stack;

public class TransactionEntry {
    private int totalCreditAmount;
    private int totalDebitAmount;
    private Stack<Integer> creditAmounts;
    private Stack<Integer> debitAmounts;

    TransactionEntry(){
        this.debitAmounts = new Stack<>();
        this.totalDebitAmount = 0;
        this.creditAmounts = new Stack<>();
        this.totalCreditAmount = 0;
    }

    public void debitAmount(int val){
        this.totalDebitAmount += val;
        this.debitAmounts.push(val);
    }
    public void creditAmount(int val){
        this.totalCreditAmount += val;
        this.creditAmounts.push(val);
    }

    public int getTotalDebitAmount(){
        return this.totalDebitAmount;
    }

    public int getTotalCreditAmount(){
        return this.totalCreditAmount;
    }

    public void undoDebit(){
        if(!this.debitAmounts.empty()){
            int lastDebit = this.debitAmounts.pop();
            this.totalDebitAmount -= lastDebit;
        }
    }
    public void undoCredit(){
        if(!this.creditAmounts.empty()){
            int lastDebit = this.creditAmounts.pop();
            this.totalCreditAmount -= lastDebit;
        }
    }

    public int remainingBalance(){
        return this.totalCreditAmount - this.totalDebitAmount;
    }

}
