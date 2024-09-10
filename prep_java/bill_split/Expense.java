package prep_java.bill_split;


import java.util.ArrayList;
import java.util.List;

/*
*
*
Expense{
    reason,
    amount,
    User paidBy,
    User[] dividedBetween

    changeAmount(int newAmount)
    addDividedBetweenUser(User u)
    removeDividedBetweenUser(User u)
}
* */
public class Expense {
    private String reason;
    private Double amount;
    private User paidBy;
    private List<User> dividedBetween;

    public Expense(String reason, List<User> usersDividing, User paidBy, Double amount) {
        this.reason = reason;
        this.paidBy = paidBy;
        this.amount = amount;
        this.dividedBetween = new ArrayList<>();
        for(User user: usersDividing){
            if(user.equals(paidBy)){
                continue;
            }
            this.dividedBetween.add(user);
            double amountOwedIndividually = amount/usersDividing.size();
            user.addAmountOwed(paidBy, amountOwedIndividually);
            paidBy.addAmountOwed(user, -1*amountOwedIndividually);
        }
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public List<User> getDividedBetween() {
        return dividedBetween;
    }

    public void setDividedBetween(List<User> dividedBetween) {
        this.dividedBetween = dividedBetween;
    }

    public void changeAmount(Double amount){
        this.amount = amount;
    }

    public void addDividedBetweenUser(User user){
        for(User u: dividedBetween){
            if(u.equals(user)){
                return;
            }
        }
        this.dividedBetween.add(user);
    }

    public void removeDividedBetweenUser(User user){
        this.dividedBetween.remove(user);
    }

}
