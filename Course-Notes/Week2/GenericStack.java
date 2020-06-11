public class Stack<Item> {
    private Node first = null;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
        return item;
    }
}

/* Generics in Java: 
 * They were designed to extend Java's type system to allow "a type or method 
 * to operate on objects of various types while providing compile-time type safety" 
 */