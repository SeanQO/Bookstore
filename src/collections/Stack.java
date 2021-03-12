package collections;

public class Stack<T> implements IStack<T> {
	
	private SElement <T> top;
	
	public Stack() {
		
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

}
