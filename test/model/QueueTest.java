package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import collections.Queue;
import model.Client;

public class QueueTest {

	private Queue<Client> theQueue;
	
	public void setUp1() {
		theQueue = new Queue<Client>();

		theQueue.enqueue(new Client("Danna", 1151970));
	}
	
	public void setUp2() {

		theQueue = new Queue<Client>();

		theQueue.enqueue(new Client("Danna", 1151970));
		theQueue.enqueue(new Client("Andrea", 8322170));

	}
	
	@Test
	public void isEmptyTest() {
		setUp1();
		assertFalse(theQueue.isEmpty());
	}
	
	@Test
	public void sizeTest() {
		setUp1();
		assertEquals(1, theQueue.size);
	}
	
	/**
	 * Test limit case, verifies if the queue generates an Exception if it tries to
	 * delete an element of the queue when there's no element
	 */
	@Test
	public void dequeueTestLimits() {

		setUp1();
		theQueue.dequeue();

		assertNull(theQueue.front());

		assertThrows(NullPointerException.class, () -> theQueue.dequeue());
	}
	
	/**
	 * Test the dequeue method where the queue has two elements and verifies that
	 * the front is the one who remains when the another element was removed
	 */
	@Test
	public void dequeueTestCaseBase() {
		setUp2();
		theQueue.dequeue();

		assertEquals("Andrea", theQueue.front().getT().getName());
	}
	
	/**
	 * Test the enqueue method, it catchs a NullPointerException when a null element
	 * is tried to insert to the queue
	 
	@Test
	public void enqueueTestInterestingCase() {
		setUp1();

		try {
			theQueue.enqueue(null);
			fail("check null pointer");

		} catch (NullPointerException e) {

		}

	}
	*/
	
	/**
	 * Test the enqueue method, it verifies that the last elemement enqueued it's
	 * the last element in the queue
	 */
	@Test
	public void enqueueLastTest() {
		setUp1();

		theQueue.enqueue(new Client("Camilo", 85693321));

		assertEquals("Camilo", theQueue.getLast().getT().getName());
	}
}
