import java.util.Iterator;

import javax.xml.soap.Node;
public class StackIterator<Item> implements Iterable<Item> {
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    private class ListIterator implements Iteraotr<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current!=null;
        }
        public void remove(){
            /* not support */
        }
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
// Iterable Interface
// public interface Iterable<Item>{
//     Iterator<Item> iterator();
// }
// Iterator Interface
// public interface Iterator<Item>{
//     boolean hasNext();
//     Item next();
//     void remove();
// }