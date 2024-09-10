package prep_java.bill_split;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Group{
    name,
    User[],
    Expense[] expenses

    addUser()
    addExpense
    addAmountOwed(User lender, User borrower, int amount)
    settleAmount(User lender, User borrower, int amount)

}*/
public class Group {
    private String name;
    private Map<String, User> users;
    private List<Expense> expenses;

    public Group(String groupName) {
        this.name = groupName;
        this.users = new HashMap<>();
        this.expenses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public void addUser(String name){
        User user = new User(name);
        this.users.put(name, user);
    }

    public void addExpense(String reason, List<String> users, String paidByUserName, Double amount){
        User paidBy = this.getUserByName(paidByUserName);
        List<User> usersDividing = new ArrayList<>();
        for(String userName: users){
            usersDividing.add(this.getUserByName(userName));
        }
        Expense expense = new ExpenseBuilder().setAmount(amount).setReason(reason).setPaidBy(paidBy).setUsersDividing(usersDividing).build();
        this.expenses.add(expense);
    }

    public User getUserByName(String name){
        if(this.users.containsKey(name)){
            return this.users.get(name);
        }

        return null;
    }

    public void printAllExpenses(){
        for(Expense e: this.expenses){
            System.out.println("Expense Amount: "+ e.getAmount());
            System.out.println("Expense Reason: "+ e.getReason());
            System.out.println("Expense divided Between: ");
            this.users.forEach((userName, users)->{
                System.out.print(userName+ ", ");
            });
        }
    }
}
