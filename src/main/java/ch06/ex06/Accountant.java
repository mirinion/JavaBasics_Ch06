package ch06.ex06;

public class Accountant extends Employee {
	private int skill1C;
	public Accountant(String name, double salary, int skill1C) {
		super(name, salary);
		this.skill1C = skill1C;
	}

	public int getSkill1C() {
		return skill1C;
	}

	public void setSkill1C(int skill1C) {
		this.skill1C = skill1C;
	}

	@Override
	public String toString() {
		return "Accountant{" +
				"skill1C=" + skill1C +
				", salary=" + salary +
				", name='" + name + '\'' +
				'}';
	}


}
