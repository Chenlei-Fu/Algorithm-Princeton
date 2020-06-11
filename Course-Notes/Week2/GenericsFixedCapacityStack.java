public class GenericsFixedCapacityStack<Item> {
    private Item[] s;
    private int N = 0;
    public GenericsFixedCapacityStack(int capacity){
        // s = new Item[capacity]; -- Not allow generic array creation.
        s = (Item[]) new Object[capacity];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public void push(Item item){
        s[N++] = item;
    }
    public Item pop(){
        return s[--N];
    }
}
/* Wrapper type: each primitive type has a wrapper object type
 * Ex: Integer is wrapper type for int
 * Autoboxing. Automatic cast between a primitive type and its wrapper.
 * Syntactic sugar: Behind-the scenes casting
 * Bottom line: client code can use generic stack for any type of data
 */