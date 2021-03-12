package collections;

public class QElement<T> {
	
	private T t;
	private QElement<T> nextElement;
	
	public QElement() {

	}
	
	public T getT() {
		return t;
	}
	
	public void setT(T t) {
		this.t = t;
	}
	
	public QElement<T> getNextElement(){
		return nextElement;
	}
	
	public void setNextElement(QElement<T> nextElement) {
		this.nextElement = nextElement;
	}
}
