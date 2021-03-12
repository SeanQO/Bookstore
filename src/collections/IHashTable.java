package collections;

public interface IHashTable<K, V> {
	
	public int getSize();
	public boolean isEmpty();
	public int getSlotIndex(K key);
	public V get(K key);
	public V remove(K key);
	public void add(K key, V value);
	
}