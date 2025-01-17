package model;
import java.util.Arrays;
import collections.*;

public class Client {
	int[] isnbList;
	
	Stack<Book> basket;
	int id;
	String name;
	double timeInStore;

	public Client(String name, int id) {

		isnbList = new int[0];
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
	
	public void addIsbn(int isbn) {
		int n = isnbList.length;
		int newArr[] = new int[n+1];  
		int value = isbn;  

		for(int i = 0; i<n; i++) {  
		newArr[i] = isnbList[i];  
		
		}  
		
		newArr[n] = value;  
		
		isnbList = newArr;
	}

	public Stack<Book> getBasket() {
		return basket;
	}

	public double getTimeInStore() {
		return timeInStore;
	}

	
	public void addBookToBasket(Book book) {
		basket.push(book);

	}

	public void sortIsnbList(int sortingMethod) {
		switch (sortingMethod) {
		case 1:
			insertionSortImperative(isnbList);
			break;
		case 2:
			//shellSort(isnbList);
			mergeSort(isnbList, isnbList.length);
			break;
		case 3:
			radixSort(isnbList);
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
	
	public static void mergeSort(int arr[], int n) {

		int curr_size;
		int left_start;

		for (curr_size = 1; curr_size <= n - 1; curr_size = 2 * curr_size) {

			for (left_start = 0; left_start < n - 1; left_start += 2 * curr_size) {

				int mid = Math.min(left_start + curr_size - 1, n - 1);

				int right_end = Math.min(left_start + 2 * curr_size - 1, n - 1);

				merge(arr, left_start, mid, right_end);
			}
		}
	}

	public static void merge(int arr[], int l, int m, int r) {
		int i, j, k;
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}
		for (j = 0; j < n2; j++) {
			R[j] = arr[m + 1 + j];
		}

		i = 0;
		j = 0;
		k = l;

		while (i < n1 && j < n2) {

			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}

			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	/*
	public static void shellSort(int[] a) {
		int increment = a.length / 2;
		while (increment > 0) {
			for (int i = increment; i < a.length; i++) {
				int j = i;
				int temp = a[i];
				while (j >= increment && a[j - increment] > temp) {
					a[j] = a[j - increment];
					j = j - increment;
				}
				a[j] = temp;
			}
			if (increment == 2) {
				increment = 1;
			} else {
				increment *= (5.0 / 11);
			}
		}
	}
	*/
	
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
        return (int) Math.log10(number) + 1; // valid only if number > 0 O(1)
    }

    private static int findMaximumNumberIn(int[] arr) {
        return Arrays.stream(arr).max().getAsInt(); //O(1)
    }
    
   /*
    public ArrayList<Book> booksToArray(){
	   ArrayList<Book> booksArray = new ArrayList<>();
		Stack<Book> tempBasket = new Stack<Book>();
		while(!tempBasket.isEmpty()) {
			SElement<Book> temp = tempBasket.pop().getT();
			booksArray.add(temp);
		}

	   return booksArray;
	   
	   
   }
   */ 
    

}