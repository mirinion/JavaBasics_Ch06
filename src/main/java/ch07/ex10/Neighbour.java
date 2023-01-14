package ch07.ex10;

import lombok.Data;

@Data
public class Neighbour implements Comparable<Neighbour> {
	private City city;
	private int distance;

	public Neighbour(City city, int distance) {
		this.city = city;
		this.distance = distance;
	}


	@Override
	public int compareTo(Neighbour o) {
		return city.compareTo(o.city.getName());
	}
}
