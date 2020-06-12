/* *****************************************************************************
 *  Name: Chenlei Fu
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private final Node head;
    private int size;


    private class Node {
        private Item item;
        private Node prev;
        private Node next;
        Node(Item item) {
            this.item = item;
            this.prev = null;
            this.next = null;
        }
        Node(Item item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
        void remove() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
            this.nullify();
        }
        void nullify() {
            this.item = null;
            this.next = null;
            this.prev = null;
        }
    }

    /* help functions */
    private void validate() {
        if (isEmpty()) throw new NoSuchElementException();
    }

    private void validate(Item item) {
        if (item == null) throw new IllegalArgumentException();
    }

    private void insert(Item item, Node prev, Node next) {
        Node temp = new Node(item, prev, next);
        prev.next = temp;
        next.prev = temp;
    }

    // construct an empty deque
    public Deque() {
        head = new Node(null);
        head.prev = head;
        head.next = head;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        validate(item);
        insert(item, head, head.next);
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        validate(item);
        insert(item, head.prev, head);
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        validate();
        Item item = head.next.item;
        head.next.remove();
        size--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        validate();
        Item item = head.prev.item;
        head.prev.remove();
        size--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = head.next;
        public boolean hasNext() {
            return current != head;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            current = current.next;
            return current.prev.item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        for (int i = 0; i < 10; i += 2) {
            deque.addFirst(i);
            deque.addLast(i + 1);
        }
        Iterator<Integer> it = deque.iterator();
        while (it.hasNext()) {
            StdOut.print(it.next() + " ");
        }
        StdOut.println("size: " + deque.size());

        for (int i = 0; i < 3; ++i) {
            deque.removeLast();
            deque.removeFirst();
        }
        it = deque.iterator();
        while (it.hasNext()) StdOut.print(it.next() + " ");
        StdOut.println("size: " + deque.size());

        for (int i = 0; i < 6; i += 2) {
            deque.addLast(i);
            deque.addFirst(i + 1);
        }
        it = deque.iterator();
        while (it.hasNext()) StdOut.print(it.next() + " ");
        StdOut.println(" size: " + deque.size());
    }

}
