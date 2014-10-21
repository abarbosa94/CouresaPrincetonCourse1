import java.util.Iterator;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class DequeTest {
	@Test
	
	public void TestAddLast() {
		Deque<Integer> Test = new Deque<Integer>();
		Test.addFirst(1);
		Test.addFirst(2);
		Test.addFirst(3);
		Test.removeLast();
		//Test.removeLast();
		//Test.removeLast();
		Iterator itr = Test.iterator();
		while(itr.hasNext()) {
			 System.out.println(itr.next());
		}	
	}

}
