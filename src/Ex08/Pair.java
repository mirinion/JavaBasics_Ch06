package Ex08;

import lombok.Data;

// E должен быть наследником Comparable, чтобы мы могли делать сравнения в max и min
@Data
public class Pair <E extends Comparable<? super E>> {
	private E first;
	private E second;

	public Pair(E first, E second) {
		this.first = first;
		this.second = second;
	}

	public E max() {
		return first.compareTo(second) > 0 ? first : second;
	}

	public E min() {
		return first.compareTo(second) < 0 ? first : second;
	}
}
