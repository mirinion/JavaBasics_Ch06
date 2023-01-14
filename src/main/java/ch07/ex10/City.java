package ch07.ex10;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

@Data
public class City implements Comparable<String> {
	private String name;

	public City(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(String o) {
		return name.compareTo(o);
	}
}
