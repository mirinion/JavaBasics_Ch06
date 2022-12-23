package Ex04;

import java.util.ArrayList;

public class Table<K,V> {
	private ArrayList<Entry> entries = new ArrayList<>();

	public V getValue(K key) {
		Entry entry = getEntry(key);
		if (entry == null) {
			throw new IllegalArgumentException("This key is not exist");
		}
		return entry.value;

	}

	public void setValueByKey(K key, V value) {
		Entry entry = getEntry(key);
		if (entry != null) {
			entry.value = value;
		} else {
			entries.add(new Entry(key, value));
		}
	}

	public void deleteByKey(K key) {
		entries.removeIf(e -> key.equals(e.key));
	}

	private Entry getEntry(K key) {
		for (Entry entry : entries) {
			if (key.equals(entry.key)) {
				return entry;
			}
		}

		return null;
	}

	private class Entry {
		private K key;
		private V value;
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}
