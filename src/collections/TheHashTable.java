package collections;

public class TheHashTable<K, V> implements IHashTable<K, V> {

	HT_Element<K, V>[] slots;
	int maxs;
	int size;

	@SuppressWarnings("unchecked")
	public TheHashTable() {
		maxs = 499;
		slots = new HT_Element[maxs];
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// funtion h
	public int getSlotIndex(K key) {
		return (Integer) key;
	}

	public V get(K key) {

		int index = getSlotIndex(key);

		HT_Element<K, V> f = slots[index];
		while (f != null) {
			if (f.getKey().equals(key)) {
				return f.getValue();
			}
			f = f.getNext();
		}
		return null;
	}

	public V remove(K key) {
		int index = getSlotIndex(key);
		HT_Element<K, V> f = slots[index];
		if (f == null) {
			return null;
		}
		if (f.getKey().equals(key)) {
			V val = f.getValue();
			f = f.getNext();
			slots[index] = f;
			size--;
			return val;
		} else {
			HT_Element<K, V> prev = null;
			while (f != null) {

				if (f.getKey().equals(key)) {
					prev.setNext(f.getNext());
					size--;
					return f.getValue();
				}
				prev = f;
				f = f.getNext();
			}
			size--;
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public void add(K key, V value) {

		int index = getSlotIndex(key);
		//int index = 400;

		HT_Element<K, V> f = slots[index];
		HT_Element<K, V> toAdd = new HT_Element<K, V>(key, value);
		if (f == null) {
			slots[index] = toAdd;
			size++;

		} else {
			while (f != null) {
				if (f.getKey().equals(key)) {
					f.setValue(value);
					size++;
					break;
				}
				f = f.getNext();
			}
			if (f == null) {
				f = slots[index];
				toAdd.setNext(f);
				slots[index] = toAdd;
				size++;
			}
		}
		if ((1.0 * size) / maxs > 0.7) {
			// do something
			HT_Element<K, V>[] tmp = slots;
			slots = new HT_Element[maxs];
			maxs = 2 * maxs;

			for (HT_Element<K, V> theE : tmp) {
				while (theE != null) {
					add(theE.getKey(), theE.getValue());
					theE.setNext(theE.getNext());
				}
			}

		}
	}

}
