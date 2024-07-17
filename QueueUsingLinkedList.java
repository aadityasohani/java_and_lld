public class QueueUsingLinkedList {
    LinkedListUsingNode queue;

    QueueUsingLinkedList(){
        this.queue = new LinkedListUsingNode();
    }

    public void enqueue(int val){
        this.queue.insertNode(val);
    }

    public boolean isEmpty(){
        return this.queue.head == null;
    }
    public int dequeue() throws Exception{
        if(this.isEmpty()){
            throw new Exception("No element to dequeue");
        }

        return this.queue.popHead();
    }   


}
