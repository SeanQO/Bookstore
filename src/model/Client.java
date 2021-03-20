package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Client {
	int[] isnbList;
	Stack<Book> basket;
	int id;
	String name;
	double timeInStore;

	public Client(String name, int id) {
		
		basket = new Stack<Book>();
		timeInStore = 0;
		this.id = id;
		this.name = name;

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int[] getIsnbList() {
		return isnbList;
	}

	public Stack<Book> getBasket() {
		return basket;
	}

	public double getTimeInStore() {
		return timeInStore;
	}

	public void addBookToBasket(Book book) {
		basket.add(book);

	}

	public void initializeIsbnList(int length) {
		isnbList = new int[length];
	}

	public void sortIsnbList(int sortingMethod) {
		switch (sortingMethod) {
		case 1:
			insertionSortImperative(null);
			break;
		case 2:
			mergeSort(null, sortingMethod);
			break;
		case 3:
			radixSort(null);
			break;

		}

	}

	public void addTime(double time) {
		timeInStore += time;
	}

	public static void insertionSortImperative(int[] input) {
        for (int i = 1; i < input.length; i++) {
            int key = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] > key) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = key;
        }
    }
	
	/*
	public static int[] insertionSort(int[] nums) {

		for (int i = 1; i < nums.length; i++) {
			for (int j = i; j > 0 && nums[j - 1] > nums[j]; j--) {
				int tmp = nums[j];
				nums[j] = nums[j - 1];
				nums[j - 1] = tmp;
			}
		}
		return nums;
	}
	*/

	public static void mergeSort(int[] a, int n) {
		
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
		}
		mergeSort(l, mid);
		mergeSort(r, n - mid);

		merge(a, l, r, mid, n - mid);
	}

	public static void merge(int[] a, int[] l, int[] r, int left, int right) {

		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			} else {
				a[k++] = r[j++];
			}
		}
		while (i < left) {
			a[k++] = l[i++];
		}
		while (j < right) {
			a[k++] = r[j++];
		}
	}
	
	public static void radixSort(int numbers[]) {
        int maximumNumber = findMaximumNumberIn(numbers);

        int numberOfDigits = calculateNumberOfDigitsIn(maximumNumber);

        int placeValue = 1;

        while (numberOfDigits-- > 0) {
            applyCountingSortOn(numbers, placeValue);
            placeValue *= 10;
        }
    }

    private static void applyCountingSortOn(int[] numbers, int placeValue) {
        int range = 10; // radix or the base

        int length = numbers.length;
        int[] frequency = new int[range];
        int[] sortedValues = new int[length];

        for (int i = 0; i < length; i++) {
            int digit = (numbers[i] / placeValue) % range;
            frequency[digit]++;
        }

        for (int i = 1; i < range; i++) {
            frequency[i] += frequency[i - 1];
        }

        for (int i = length - 1; i >= 0; i--) {
            int digit = (numbers[i] / placeValue) % range;
            sortedValues[frequency[digit] - 1] = numbers[i];
            frequency[digit]--;
        }

        System.arraycopy(sortedValues, 0, numbers, 0, length);
    }

    private static int calculateNumberOfDigitsIn(int number) {
        return (int) Math.log10(number) + 1; // valid only if number > 0
    }

    private static int findMaximumNumberIn(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }
    
   

}