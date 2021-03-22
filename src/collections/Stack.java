package collections;

import java.util.ArrayList;

public class Stack<T> implements IStack<T> {
	
	private SElement <T> top;
	public int size;
	
	public Stack() {
		
		size = 0;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void push(T t) {
		SElement<T> element = new SElement<T>();
		element.setT(t);
		
		if (isEmpty()) {
			top = element;
		}else {
			element.setPrevElement(top);
			top = element;
		}
		
		size = size + 1;
		
	}

	public SElement<T> top() {
		return top;
	}

	public SElement<T> pop() {
		@SuppressWarnings("unused")
		SElement<T> t = top;
		if (top.getPrevElement() == null) {
			top = null;
		} else {
			top = top.getPrevElement();
		}
		return null;
	}
	
	public SElement<T> getTop() {
        return top;
    }
	
	public int getSize() {
		return size;
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


	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<T> toArray() {
		ArrayList<T> booksArray = new ArrayList<>();
		Stack<T> temp = new Stack<T>();
		while(!temp.isEmpty()) {
			temp.pop();
			booksArray.add((T) temp);
		}

	   return booksArray;
	}
}
