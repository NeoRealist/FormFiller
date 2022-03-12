package by.bobruisk.zhelnov.myproject.mavenproject1;

public class FullName {
	private String surname;
	private String name;
	private String patronymic;
	
	public FullName(String surname,String name,String patronymic) {
		this.surname = surname;
		this.name = name;
		this.patronymic = patronymic;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	@Override
	public String toString() {
		return surname + " " + name + " " + patronymic;
	}
	

}
