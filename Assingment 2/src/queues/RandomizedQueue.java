import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] q;
    private int N = 0;

    public RandomizedQueue() { // construct an empty randomized queue
        q = (Item[]) new Object[2];
    }
        public boolean isEmpty() { // is the queue empty?
           if (N == 0) {
               return true;
           }
           return false;
        }
        public int size() { // return the number of items on the queue
            return N;
    }
    private void resize(int max) {
        assert max >= N; //test it
           Item[] temp = (Item[]) new Object[max];
           for (int i = 0; i < N; i++) {
               temp[i] = q[i % q.length];
           }
           q = temp;
       }
       public void enqueue(Item item) { // add the item
            if (item ==  null) {
                throw new NullPointerException();
            }
            if (N == q.length) {
                resize(2 * q.length);
            }
            q[N] = item; //first add then add
            N++;
        }
       public Item dequeue() { // delete and return a random item
        if (isEmpty()) {
            throw new NoSuchElementException("Underflow");
        }
        int n = StdRandom.uniform(N);
        while (q[n] == null) {
            n = StdRandom.uniform(N);
        }
        Item item = q[n];
        if (n != N - 1) {
            q[n] = q[N - 1];    //just swap with the last element
            q[N - 1] = null;
        }
        q[N - 1] = null; //if not it is the last element
        N--;
        //shrink
        if (N > 0 && N == q.length / 4) {
            resize(q.length / 2);
        }
        return item;
           }
   public Item sample() {  // return (but do not delete) a random item
        if (isEmpty()) {
            throw new NoSuchElementException("Underflow");
        }
        int n = StdRandom.uniform(N);
        while (q[n] == null) {
            n = StdRandom.uniform(N);
        }
        return q[n];
       }

    public Iterator<Item> iterator() {   // return an independent iterator over items in random order
        return new ArrayIterator();
    }
     private class ArrayIterator implements Iterator<Item> {
            private int i = 0;
            public boolean hasNext()  {
                if (i < N) {
                    return true;
                }
                return false;
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Item item = q[i % q.length];
                i++;
                return item;
            }
     }

}
