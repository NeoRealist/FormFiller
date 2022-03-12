package by.bobruisk.zhelnov.myproject.mavenproject1;

public class Patient {
	private FullName fullName;
	private BirthDate birthDate;
	private HomeAdress homeAdress;
	
	
	
	public Patient(FullName fullName, BirthDate birthDate, HomeAdress homeAdress) {
		super();
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.homeAdress = homeAdress;
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
	public HomeAdress getHomeAdress() {
		return homeAdress;
	}
	public void setHomeAdress(HomeAdress homeAdress) {
		this.homeAdress = homeAdress;
	}
	
	@Override
	public String toString() {
		return fullName + ", " + birthDate + ", " + homeAdress;
	}
        
	
	
}
