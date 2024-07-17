public class Main {
    public static void main(String []args){
//        BmiChild bmiChild = new BmiChild("Aaditya", 22, 175, 74);
//        bmiChild.printInfo();


//        TransactionEntry transactionEntry = new TransactionEntry();
//        transactionEntry.creditAmount(500);
//        transactionEntry.debitAmount(100);
//
//        transactionEntry.undoCredit();
//        System.out.println(transactionEntry.remainingBalance());


        StackUsingArray stackUsingArray = new StackUsingArray();
        stackUsingArray.push(45);
        System.out.println(stackUsingArray.top());
        System.out.println(stackUsingArray.pop());
        System.out.println(stackUsingArray.top());
        System.out.println(stackUsingArray.isEmpty());

    }
}
