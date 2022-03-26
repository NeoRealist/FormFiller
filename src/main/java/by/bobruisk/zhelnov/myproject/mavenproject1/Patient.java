package by.bobruisk.zhelnov.myproject.mavenproject1;

public class Patient {
	private FullName fullName;
	private BirthDate birthDate;
	private HomeAddress homeAddress;
	
	
	
	public Patient(FullName fullName, BirthDate birthDate, HomeAddress homeAdress) {
		super();
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.homeAddress = homeAdress;
	}



	public FullName getFullName() {
		return fullName;
	}
	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}
	public BirthDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(BirthDate birthDate) {
		this.birthDate = birthDate;
	}
	public HomeAddress getHomeAdress() {
		return homeAddress;
	}
	public void setHomeAdress(HomeAddress homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	@Override
	public String toString() {
		return fullName + ", " + birthDate + ", " + homeAddress;
	}
        
	
	
}
