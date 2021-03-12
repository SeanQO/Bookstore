package collections;

public interface IQueue<T> {
	
	public boolean isEmpty();
	
	public void enqueue(T t);
	
	public QElement<T> front();
	
	public QElement<T> dequeue();
}
