package ch07.ex01;

import java.util.*;

public class ex01 {
	public static void main(String[] args) {
		int n = 100;

		HashSet<Integer> hashSet = new HashSet<>(n-1);
		BitSet bitSet = new BitSet(n-1);

		fillHashSet(hashSet, 2, n - 1);
		fillBitSet(bitSet, 2, n - 1);

		System.out.println(Arrays.toString(sieveHashSet(hashSet, 2, n)));
		System.out.println(Arrays.toString(sieveBitSet(bitSet, 2, n)));
	}

	public static Integer[] sieveHashSet(HashSet<Integer> hashSet, int lowerBound, int upperBound) {
		for (int s = lowerBound; s * s <= upperBound; s++) {
			for (int j = s*s; j <= upperBound; j += s) {
				hashSet.remove(j);
			}
		}
		return hashSet.toArray(new Integer[0]);
	}

	public static Integer[] sieveBitSet(BitSet bitSet, int lowerBound, int upperBound) {
		for (int s = lowerBound; s * s <= upperBound; s++) {
			for (int j = s*s; j <= upperBound; j += s) {
				bitSet.set(j, false);
			}
		}

		List<Integer> resultArr = new ArrayList<>();
		for (int i = lowerBound; i < bitSet.length(); i++) {
			if(bitSet.get(i)) {
				resultArr.add(i);
			}
		}

		return resultArr.toArray(new Integer[0]);
	}
	
	

	private static void fillHashSet(HashSet<Integer> hashSet, int lowerBound, int upperBound) {
		for (int i = lowerBound; i <= upperBound; i++) {
			hashSet.add(i);
		}
	}

	private static void fillBitSet(BitSet bitSet, int lowerBound, int upperBound) {
		bitSet.set(lowerBound, upperBound, true);
	}

}
