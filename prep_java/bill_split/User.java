package prep_java.bill_split;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private Map<User, Double> owedAmount;
    private Double totalAmountOwed;

    public User(String name) {
        this.name = name;
        this.owedAmount = new HashMap<>();
        this.totalAmountOwed = 0.0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<User, Double> getOwedAmount() {
        return owedAmount;
    }

    public void setOwedAmount(Map<User, Double> owedAmount) {
        this.owedAmount = owedAmount;
    }

    public Double getTotalAmountOwed() {
        return totalAmountOwed;
    }

    public void setTotalAmountOwed(Double totalAmountOwed) {
        this.totalAmountOwed = totalAmountOwed;
    }

    public void addAmountOwed(User user, Double amount){
        if(this.owedAmount.containsKey(user)){
            this.owedAmount.put(user, this.owedAmount.get(user) + amount);
        }else{
            this.owedAmount.put(user, amount);
        }
    }

    public void printAllLedgers(){
        this.owedAmount.forEach((user, amount) -> {
            System.out.println(user.getName() + " " + amount);
        });
    }
}
