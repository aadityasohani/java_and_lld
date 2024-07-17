public class StackUsingArray {
    int []stack;
    int curr;

    StackUsingArray(){
        stack = new int[30];
        curr = -1;
    }

    public void push(int val){
        if(curr == 29){
            System.out.println("Stack Overflow, can't add new element");
        }else{
            stack[++curr] = val;
        }
    }

    public boolean isEmpty(){
        return curr == -1;
    }


    public int pop(){
        if(!this.isEmpty()){
            return stack[curr--];
        }
        System.out.println("Stack Underflow, no element to pop");
        return -1;
    }

    public int top(){
        if(!this.isEmpty()){
            return stack[curr];
        }
        System.out.println("Stack is empty");
        return -1;
    }

}
