import java.util.Stack;
public class QueueWithTwoStack<E> {
    private Stack<E> inbox;
    private Stack<E> outbox;
    private int size;

    public QueueWithTwoStack(){
        inbox = new Stack<E>();
        outbox = new Stack<E>();
    }
    public void enqueue(E item){
        inbox.push(item);
        size++;
    }
    public E dequeue(){
        if(outbox.isEmpty()){
            while(!inbox.isEmpty()){
                outbox.push(inbox.pop());
            }
        }
        E temp = null;
        if(!outbox.isEmpty()){
            temp = outbox.pop();
            size--;
        }
        return temp;
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        QueueWithTwoStack<Integer> myQueue = new QueueWithTwoStack<Integer>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        System.out.println(myQueue.dequeue());
    }
}