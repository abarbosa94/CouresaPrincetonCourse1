import java.util.Iterator;

import org.junit.Test;


public class QueueTest {

    @Test
    public void queueTest() {
        RandomizedQueue<Integer> a = new RandomizedQueue<Integer>();
        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(3);
        a.enqueue(4);
        a.enqueue(5);
        a.enqueue(6);
        a.dequeue();
        //a.dequeue();
        //a.dequeue();
        Iterator itr = a.iterator();
        while(itr.hasNext()) {
        	System.out.println(itr.next());
        }
        
        
	}

}
