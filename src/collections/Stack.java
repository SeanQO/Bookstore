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
		SElement<T> t = top;
		if (top.getPrevElement() == null) {
			top = null;
		} else {
			top = top.getPrevElement();
		}
		return t;
	}
	
	public SElement<T> getTop() {
        return top;
    }
	
	public int getSize() {
		return size;
	}

	/*@Override
	public ArrayList<T> toArray() {
		ArrayList<T> booksArray = new ArrayList<>();
		Stack<T> temp = this;
		while(!temp.isEmpty()) {
			
			booksArray.add((T)temp.top.getT() );
			temp.pop();
		}
       
	   return booksArray;
	}*/
	
	 @Override
	    public ArrayList<T> toArray() {
			ArrayList<T> booksArray = new ArrayList<>();
			SElement<T> temp = top;
			while(temp!=null) {
				booksArray.add(temp.getT());
				temp = temp.getPrevElement();
			}
			return booksArray;
		}
}
