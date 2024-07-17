public class LinkedListUsingNode {
    LLNode head;
    LLNode tail;

    LinkedListUsingNode(){
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int val){
        LLNode llNode = new LLNode(val);
        if(this.head == null){
            this.head = llNode;
        }else{
            tail.next = llNode;
        }
        tail = llNode;
    }

    int popHead(){
        int val = this.head!=null ? this.head.data : -1;
        if(this.head!=null){
            this.head = this.head.next;
        }
        if(this.head == null){
            tail = null;
        }
        return val;
    }

}
