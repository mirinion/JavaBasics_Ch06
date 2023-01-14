package ch07.ex10;

import java.util.*;

public class Ex10 {
	public static void main(String[] args) {
		City msc = new City("Moscow");
		City nn = new City("Nizhniy Novgorod");
		City ufa = new City("Ufa");
		City spb = new City("Saint's Petersburg");

		RoadsMap roadsMap = new RoadsMap();
		roadsMap.addAdj(ufa, msc, 2500);
		roadsMap.addAdj(ufa, nn, 1500);
		roadsMap.addAdj(msc, nn, 800);
		roadsMap.addAdj(spb, msc, 800);
		roadsMap.addAdj(spb,nn,900);

		System.out.println(roadsMap.adjMap);
	}
}
