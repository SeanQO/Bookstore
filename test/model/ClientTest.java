package model;

import static org.junit.Assert.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class ClientTest {
	
	@Test
    public void insertionSortTest() {
        int[] input = {6, 2, 3, 4, 5, 1};
        Client.insertionSortImperative(input);
        int[] expected = {1, 2, 3, 4, 5, 6};
        assertArrayEquals("the two arrays are not equal", expected, input);
    }
	
	@Test
	public void shellSortTest() {
	    int[] actual = { 5, 1, 6, 2, 3, 4 };
	    int[] expected = { 1, 2, 3, 4, 5, 6 };
	    Client.mergeSort(actual,actual.length);
	    assertArrayEquals(expected, actual);
	}
	
	@Test
	public void radizSortTest() {
	    int[] numbers = {387, 468, 134, 123, 68, 221, 769, 37, 7};
	    Client.radixSort(numbers);
	    int[] numbersSorted = {7, 37, 68, 123, 134, 221, 387, 468, 769};
	    assertArrayEquals(numbersSorted, numbers); 
	}

}
