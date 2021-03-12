package collections;

public interface IStack<T> {
	
	public boolean isEmpty();
	
	public void push (T t);
	
	public SElement<T> top();
	
	public SElement<T> pop();
	
}
