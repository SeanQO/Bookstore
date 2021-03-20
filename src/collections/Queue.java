package collections;

public class Queue<T> implements IQueue<T> {
	
	private QElement<T> first;
	private QElement<T> last;
	public int size;
	
	public Queue() {
		
		size = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void enqueue(T t) {
		QElement<T> element = new QElement<T>();
		element.setT(t);
		
		if (isEmpty()) {
			first = element;
			last = element;
		} else {
			last.setNextElement(element);
			last = element;
		}
		size = size+1;
	}

	public QElement<T> front() {
		return first;
	}

	public QElement<T> dequeue() {
		QElement<T> element = first;
		first = first.getNextElement();
		return element;
	}

	public QElement<T> getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }
}
