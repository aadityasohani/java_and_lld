package prep_java.bill_split;

import java.util.*;

public class BillSplitDriver {

    public static void main(String[] args){
        Map<String, Group> groups = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("chose from below:");
            System.out.println("1. Create new Group");
            System.out.println("2. Add Members to Group");
            System.out.println("3. Add new expenses to Group");
            System.out.println("4. Print all Expenses");
            System.out.println("5. Print all Groups");
            System.out.println("6 Exit");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Name your Group");
                    String groupName = sc.next();
                    if(groups.containsKey(groupName)){
                        System.out.println("group already exists");
                        break;
                    }
                    Group newGroup = createNewGroup(groupName);
                    groups.put(groupName, newGroup);
                    break;
                case 2:
                    addNewMembers(sc, groups);
                    break;
                case 3:
                    addNewExpenseToGroup(sc, groups);
                    break;
                case 4:
                    printAllExpenses(sc, groups);
                    break;
                case 5:
                    printAllGroups(groups);
                default:
                    return;
            }

        }


    }

    private static void printAllGroups(Map<String, Group> groups) {
        groups.forEach((groupName, group)->{
            System.out.println("#"+ groupName);
        });
    }

    private static void printAllExpenses(Scanner sc, Map<String, Group> groups) {
        System.out.println("Which Group expenses do you want to read?");
        String groupName = sc.next();

        if(!groups.containsKey(groupName)){
            System.out.println("No such group found!");
            return;
        }
        Group group = groups.get(groupName);

        group.printAllExpenses();

    }

    private static void addNewExpenseToGroup(Scanner sc, Map<String, Group> groups) {
        System.out.println("To Which group do you want to add?");
        String groupName = sc.next();

        if(!groups.containsKey(groupName)){
            System.out.println("No such group found!");
            return;
        }
        Group group = groups.get(groupName);

        System.out.println("Reason of Expense?");
        String reason = sc.nextLine();
        sc.next();

        System.out.println("Expense Amount?");
        double amount = sc.nextDouble();

        System.out.println("Who paid?");
        String paidBy = sc.next();

        System.out.println("Add users who will divide the expense \n number of users?");
        int num = sc.nextInt();

        List<String> dividedBetween = new ArrayList<>();
        for(int i = 0;i<num;i++){
            System.out.println("name of member" + (i+1));
            String memberName = sc.next();
            dividedBetween.add(memberName);
        }

        group.addExpense(reason, dividedBetween, paidBy, amount);
    }

    private static void addNewMembers(Scanner sc, Map<String, Group> groups) {
        System.out.println("To Which group do you want to add?");
        String groupName = sc.next();
        if(!groups.containsKey(groupName)){
            System.out.println("No such group found!");
            return;
        }
        Group group = groups.get(groupName);
        System.out.println("How many users do you want to add?");
        int num = sc.nextInt();
        for(int i = 0;i<num;i++){
            System.out.println("name of "+ (i+1) + " member");
            String memberName = sc.next();
            group.addUser(memberName);
        }
    }

    static Group createNewGroup(String groupName){
        return new Group(groupName);
    }
}
