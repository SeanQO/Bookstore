package collections;

public class HT_Element<K, V> {
	
	private K key;
	private V value;
	private HT_Element<K, V> next;
	
	public HT_Element(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public HT_Element<K, V> getNext() {
		return next;
	}

	public void setNext(HT_Element<K, V> next) {
		this.next = next;
	}
	
}
