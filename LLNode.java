public class LLNode {
    int data;
    LLNode next;

    LLNode(int data){
        this.data = data;
        this.next = null;
    }

    public void addNext(LLNode llNode){
        this.next = llNode;
    }
}
