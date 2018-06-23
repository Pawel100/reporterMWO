package agh.mwo.reporter;

public class Employee {
	private String name;
	private String surname;
	private double hours;
	private String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	private String getSurname() {
		return surname;
	}
	private void setSurname(String surname) {
		this.surname = surname;
	}
	private double getHours() {
		return hours;
	}
	private void setHours(double hours) {
		this.hours = hours;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", hours=" + hours + "]";
	}
}
