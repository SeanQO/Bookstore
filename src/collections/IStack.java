package collections;

import java.util.ArrayList;

public interface IStack<T> {
	
	public boolean isEmpty();
	
	public void push (T t);
	
	public SElement<T> top();
	
	public SElement<T> pop();
	
	public ArrayList<T> toArray();
	
}
