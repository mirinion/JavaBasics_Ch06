package ch06.ex04;

public class Ex04 {
	public static void main(String[] args) {
		Table<Integer, String> table = new Table<Integer, String>();

		table.setValueByKey(0, "Boris");
		table.setValueByKey(2, "Petr");
		table.setValueByKey(5, "Denis");

		System.out.println(table.getValue(0));

		table.setValueByKey(0, "Igor");
		System.out.println(table.getValue(0));

		try {
			table.deleteByKey(2);
			System.out.println(table.getValue(2));
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
