package ch07.ex10;

import ch06.add.injectionExamples.Pair;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

@Data
public class RoadsMap {
	Map<City, PriorityQueue<Neighbour>> adjMap = new HashMap<>();

	public void addAdj(City from, City to, int distance) {
		addAdj(from, new Neighbour(to, distance));
	}

	public void addAdj(City from, Neighbour neighbour) {
		if (!adjMap.containsKey(from)) {
			adjMap.put(from, new PriorityQueue<>());
		}
		if (!adjMap.containsKey(neighbour.getCity())) {
			adjMap.put(neighbour.getCity(), new PriorityQueue<>());
		}
		adjMap.get(from).add(neighbour);
		adjMap.get(neighbour.getCity()).add(
				new Neighbour(from, neighbour.getDistance()));
		//Обратная дорога (двусвязный граф)
	}
}
