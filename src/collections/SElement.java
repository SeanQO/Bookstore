package collections;

public class SElement<T> {
	
	private T t;
	private SElement<T> prevElement;
	
	public SElement() {
		
	}
	
	public T getT() {
		return t;
	}
	
	public void setT(T t) {
		this.t = t;
	}
	
	public SElement<T> getPrevElement(){
		return prevElement;
	}
	
	public void setPrevElement(SElement<T> prevElement) {
		this.prevElement = prevElement;
	}
}
