package collections;

import java.util.ArrayList;

public interface IQueue<T> {
	
	public int getSize();
	
	public boolean isEmpty();
	
	public void enqueue(T t);
	
	public QElement<T> front();
	
	public QElement<T> dequeue();
	
	public QElement<T> getLast();
	
	public ArrayList<T> toArray();
}
