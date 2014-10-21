import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] q;
    private int N = 0;
    private int first = 0;
    private int last = 0;
    private int tail = 0;

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
               temp[i] = q[(first + i) % q.length];
           }
           q = temp;
           first = 0;
           last = N;
           tail = N;
       }
       public void enqueue(Item item) { // add the item
            if (item ==  null) {
                throw new NullPointerException();
            }
            if (N == q.length) {
                resize(2 * q.length);
            }
            q[last] = item; //first add then add
            last++;
            if (last == q.length) {
                last = 0;
            }
            tail++;
            q[tail - 1] = item;
            N++;
            /*System.out.println("q[last]:"+ q[tail-1]);
            System.out.println("q[first]:"+q[first]);*/
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
        if (n == first) {
            q[n] = null;
            first++;
        }
        else if (n != last) {
            //System.out.println("Im here !");
            //System.out.println("q[last]:"+q[tail-1]);
            q[n] = q[tail - 1]; //swap with the last
            //System.out.println("new q[n]:"+q[n]);
            q[tail - 1] = null;
            last--;
            tail--;
        }
        else {
        	q[last] = null;
            last--;
            tail--;
        }
        N--;
        if (first == q.length) {
            first = 0;
        }
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
        while(q[n] == null) {
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
                Item item = q[(i + first) % q.length];
                i++;
                return item;
            }
     }

}
