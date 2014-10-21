import java.util.Iterator;
import org.junit.Test;

public class QueueTest {

	@Test
	public void TestAddLast() {
		RandomizedQueue<String> Test = new RandomizedQueue<String>();
		Test.enqueue("A");
		Test.enqueue("B");
		Test.enqueue("C");
		Test.enqueue("D");
		Test.enqueue("I");
		Test.enqueue("J");
		Test.enqueue("K");
		Test.enqueue("L");
		Test.enqueue("M");
		Test.dequeue();
		Test.dequeue();
		Test.dequeue();
		Iterator itr = Test.iterator();
		while(itr.hasNext()) {
			 System.out.println(itr.next());
		}
		
	}

}