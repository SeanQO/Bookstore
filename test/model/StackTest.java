package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collections.Stack;

public class StackTest {

	private Stack<Book> theStack;
	
	public void setUp1() {
		
		theStack = new Stack<Book>();
	}
	
	public void setUp2() {
		
		theStack = new Stack<Book>();
		theStack.push(new Book("El Codigo DaVinci", "Dan Brown", "Panamericana", 369, 123, 24.75, "Capitulo 1. El linaje de Jesus y Maria Magdalena.", "No hay criticas aun."));
	}
	
	public void setUp3() {
		
		theStack = new Stack<Book>();
		theStack.push(new Book("El Codigo DaVinci", "Dan Brown", "Panamericana", 369, 123, 24.75, "Capitulo 1. El linaje de Jesus y Maria Magdalena.", "No hay criticas aun."));
		theStack.push(new Book("Un Dolor Imperial", "Peter Van Houten", "Planeta", 324, 265, 25.00, "Capitulo1. Tengo cancer desde lo 12 años…", "Nohay criticas aun."));
		theStack.push(new Book("La Biblia de los Caidos", "Fernando Trujillo", "Planeta", 319, 364, 21.50, "Capitulo1. La iglesia nos ha mentido desde el principio", "Es un libro que atenta contra la dotrina sagrada."));
	}
	
	@Test
	public void isEmptyTest1() {
		setUp1();
		assertTrue(theStack.isEmpty());
	}
	
	@Test
	public void isEmptyTest2() {
		setUp2();
		assertFalse(theStack.isEmpty());
	}
	
	@Test
	public void sizeTest1() {
		setUp1();
		assertEquals(0, theStack.size);
	}
	@Test
	public void sizeTest2() {
		setUp2();
		assertEquals(1, theStack.size);
	}
	
	/**
	 * Test limit case, verifies if the stack generates an Exception if it tries to
	 * delete an element of the queue when there's no element
	 */
	@Test
	public void popTestLimits() {

		setUp2();
		theStack.pop();
		assertNull(theStack.top());
		assertThrows(NullPointerException.class, () -> theStack.pop());
	}
	
	/**
	 * Test the pop method where the stack has two elements and verifies that
	 * the front is the one who remains when the another element was removed
	 */
	@Test
	public void popTestCaseBase() {
		setUp3();
		theStack.pop();
		assertEquals("Un Dolor Imperial", theStack.top().getT().getName());
	}
	
	/**
	 * Test the stack method, it catchs a NullPointerException when a null element
	 * is tried to insert to the stack
	 */
	@Test
	public void enqueueTestInterestingCase() {
		setUp2();

		try {
			theStack.push(null);
			//fail("check null pointer");

		} catch (NullPointerException e) {

		}

	}
	
	/**
	 * Test the enqueue method, it verifies that the top elemement enqueued it's
	 * the last element in the stack
	 */
	@Test
	public void pushTopTest() {
		setUp2();
		theStack.push(new Book("Un Dolor Imperial", "Peter Van Houten", "Planeta", 324, 265, 25.00, "Capitulo1. Tengo cancer desde lo 12 años…", "Nohay criticas aun."));
		assertEquals("Un Dolor Imperial", theStack.getTop().getT().getName());
	}
	
}
