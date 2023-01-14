package ch07.ex13;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache<K,V> extends LinkedHashMap<K,V> {
	int maxEntriesCount;
	public Cache(int maxEntriesCount) {
		super();
		this.maxEntriesCount = maxEntriesCount;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
		return size() > maxEntriesCount;
	}

}
