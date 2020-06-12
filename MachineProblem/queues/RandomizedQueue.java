/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        this.size = 0;
        this.items = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        validate(item);
        if (size == items.length) {
            resize(size << 1);
        }
        items[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        validate();
        int random = StdRandom.uniform(size);
        Item item = items[random];
        items[random] = items[--size];
        items[size] = null;
        if (size > 0 && size == items.length >> 2) {
            resize(items.length >> 1);
        }
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        validate();
        return items[StdRandom.uniform(size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int[] randomIdx;
        private int current;

        public RandomizedQueueIterator() {
            randomIdx = new int[size];
            for (int i = 0; i < size; i++) randomIdx[i] = i;
            StdRandom.shuffle(randomIdx);
            current = 0;
        }
        public boolean hasNext() {
            return current != randomIdx.length;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return items[randomIdx[current++]];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* helper  functions */
    private void validate() {
        if (isEmpty()) throw new NoSuchElementException();
    }

    private void validate(Item item) {
        if (item == null) throw new IllegalArgumentException();
    }

    private void resize(int capacity) {
        assert capacity >= size;
        Item[] newItems = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        for (int i = 0; i < 10; ++i)
            rq.enqueue(i);
        Iterator<Integer> it = rq.iterator();
        while (it.hasNext()) StdOut.print(it.next() + " ");
        StdOut.println(" size: " + rq.size());
        it = rq.iterator();
        while (it.hasNext()) StdOut.print(it.next() + " ");
        StdOut.println(" size: " + rq.size());

        for (int j = 0; j < 3; ++j) {
            for (int i = 0; i < 3; ++i)
                rq.dequeue();
            it = rq.iterator();
            while (it.hasNext()) StdOut.print(it.next() + " ");
            StdOut.println(" size: " + rq.size());
        }
    }

}
