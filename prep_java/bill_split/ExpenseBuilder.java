package prep_java.bill_split;

import java.util.ArrayList;
import java.util.List;


//builder pattern
public class ExpenseBuilder {
    private String reason;
    private List<User> usersDividing;
    private User paidBy;
    private double amount;


    ExpenseBuilder setReason(String reason){
        this.reason = reason;
        return this;
    }

    ExpenseBuilder setUsersDividing(List<User> usersDividing){
        this.usersDividing = usersDividing;
        return this;
    }
    ExpenseBuilder setAmount(double amount){
        this.amount = amount;
        return this;
    }
    ExpenseBuilder setPaidBy(User paidBy){
        this.paidBy = paidBy;
        return this;
    }

    Expense build(){
        reason = reason == null || reason.isEmpty() ? "unknown" : reason;
        usersDividing = usersDividing == null ? new ArrayList<>() : usersDividing;
        return new Expense(this.reason, this.usersDividing, this.paidBy, this.amount);
    }
}
