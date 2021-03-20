package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import collections.TheHashTable;

public class TheHashTableTest {

	TheHashTable<Integer, Book> hashTable;

	public void setUp1() {
		hashTable = new TheHashTable<Integer, Book>();
	}

	public void setUp2() {
		hashTable = new TheHashTable<Integer, Book>();
		hashTable.add(1234, new Book("El Codigo DaVinci", "Dan Brown", "Panamericana", 369, 1234, 24.75, "Capitulo 1. El linaje de Jesus y Maria Magdalena.", "No hay criticas aun."));
	}

	public void setUp3() {
		hashTable = new TheHashTable<Integer, Book>();

		hashTable.add(2459, new Book("Angeles y Demonios", "Dan Brown", "Planeta", 397, 2459, 26.14, "Capitulo1. El grupo de los Iluminatti ataca de nuevo.", "No hay criticas aun."));
		hashTable.add(2658, new Book("Un Dolor Imperial", "Peter Van Houten", "Planeta", 324, 2658, 25.00, "Capitulo1. Tengo cancer desde lo 12 años…", "Nohay criticas aun."));
		hashTable.add(3643, new Book("La Biblia de los Caidos", "Fernando Trujillo", "Planeta", 319, 3643, 21.50, "Capitulo1. La iglesia nos ha mentido desde el principio", "Es un libro que atenta contra la dotrina sagrada."));
	}
	
	/**
	 * Test the method isEmpty, where verifies in an empty hash table to check out
	 * if it's really empty, and in a non-empty hash table to check out it is not
	 * empty
	 */
	@Test
	public void isEmptyTest() {
		setUp1();
		assertTrue(hashTable.isEmpty());
	}
	
	@Test
	public void isEmptyTest2() {
		setUp2();
		assertFalse(hashTable.isEmpty());
	}
	
	/**
	 * Test the method get, which gives an element based on the key
	 */
	@Test
	public void getTest() {
		setUp3();
		assertEquals("Angeles y Demonios", hashTable.get(2459).getName());
	}
	
	@Test
	public void getTestInterestingCase() {
		setUp1();
		assertEquals(null, hashTable.get(0));
	}
	
	/**
	 * Test method remove, which verifies in an empty hash table and removes
	 * something, so it returns null, and in a hast table with elements, wich
	 * returns the element removed
	 * 
	 */
	@Test
	public void removeTestSpecialCase() {
		setUp1();
		Book returned = hashTable.remove(0);
		assertNull(returned);
	}
	
	@Test
	public void removeTestBaseCase() {
		setUp3();
		Book removed = hashTable.remove(3643);
		assertEquals("La Biblia de los Caidos", removed.getName());
	}
	
	/**
	 * Test method add, which verifies if the element added in a slot of the hash
	 * table it's truly added there verifying with the get method in that slot
	 */
	@Test
	public void addTest() {
		setUp3();

		hashTable.add(1125, new Book("La Ciudad de los Prodigios", "Claudio Stassi", "Alfaguara", 247, 1125, 16.40, "Capitulo1. En aquella ciudad todos tenian un don especial.", "No hay criticas aun."));

		assertEquals("La Ciudad de los Prodigios", hashTable.get(1125).getName());
	}
	
	@Test
	public void addTestInterestingCase() {
		setUp1();
		hashTable.add(1125, new Book("La Ciudad de los Prodigios", "Claudio Stassi", "Alfaguara", 247, 1125, 16.40, "Capitulo1. En aquella ciudad todos tenian un don especial.", "No hay criticas aun."));
		assertEquals(false, hashTable.isEmpty());
	}
}
