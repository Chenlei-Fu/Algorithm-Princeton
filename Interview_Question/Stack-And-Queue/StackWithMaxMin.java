import java.util.Stack;
public class StackWithMaxMin extends Stack<Integer>{
    private Stack<Integer> minStack;
    private Stack<Integer> maxStack;

    public StackWithMaxMin () {
        minStack = new Stack<Integer>();    
        maxStack = new Stack<Integer>();    
    }

    public void push(int value){
        if(value <= min()){
            minStack.push(value);
        }
        if(value >= max()){
            maxStack.push(value);
        }
        super.push(value);
    }

    public Integer pop(){
        int value = super.pop();
        if(value == min()){
            minStack.pop();
        }
        if(value == max()){
            maxStack.pop();
        }
        return value;
    }

    public int min(){
        if(minStack.isEmpty()){
            return Integer.MAX_VALUE;
        } else{
            return minStack.peek();
        }
    }

    public int max(){
        if (maxStack.isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            return maxStack.peek();
        }
    }

    public static void main(String[] args) {
        StackWithMaxMin s = new StackWithMaxMin();
        s.push(7);
        s.push(4);
        s.push(5);
        s.push(1);
        s.push(9);
        System.out.println("max is:" + s.max());
        System.out.println("min is:" + s.min());
        s.pop();
        s.pop();
        System.out.println("max is:" + s.max());
        System.out.println("min is:" + s.min());
    }
}