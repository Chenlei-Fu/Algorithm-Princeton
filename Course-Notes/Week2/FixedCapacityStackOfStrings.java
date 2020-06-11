public class FixedCapacityStackOfStrings {
    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity){
        s = new String[capacity];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void push(String item){
        if(N == s.length) resize(2 * s.length);
        s[N++] = item;
    }

    public void resize(int capacity){
        String[] copy = new String[capacity];
        for(int i = 0; i < N; i++){
            copy[i] = s[i];
        }
        s = copy;
        // N + (2+4+8+...+N) ~ 3N
    }

    public String pop(){
        // return s[--N]; -- loitering
        String item = s[--N];
        s[N] = null;
        if(N > 0 && N == s.length/4) resize(s.length/2);
        return item;
    }
}

/* Stack consideration
 * Overflow and underflow
 * Underflow: throw exception if pop from an empty stack
 * Overflow: use resizing array for array implementation.
 * Loitering: Holding a reference to an object when it is no loger needed.
 */