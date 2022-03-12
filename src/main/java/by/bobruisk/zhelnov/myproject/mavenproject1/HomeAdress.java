package by.bobruisk.zhelnov.myproject.mavenproject1;

import by.bobruisk.zhelnov.myproject.mavenproject1.Exeptions.IncorrectNumberException;

public class HomeAdress {
		
	private String streetName;
	private Integer homeNumber;
	private String homeBuildingNumber;
	private Integer flatNumber;
	
	public HomeAdress(String streetName, int homeNumber, String homeBuildingNumber, int flatNumber) {
		setStreetName(streetName);
		setHomeNumber(homeNumber);
		setHomeBuildingNumber(homeBuildingNumber);
		setFlat(flatNumber);
	}
	public HomeAdress(String streetName, int homeNumber) {
		setStreetName(streetName);
		setHomeNumber(homeNumber);
		this.homeBuildingNumber = null;
		this.flatNumber = null;
		
	}
	public HomeAdress(String streetName, int homeNumber,  int flatNumber) {
		setStreetName(streetName);
		setHomeNumber(homeNumber);
		this.homeBuildingNumber = null;
		setFlat(flatNumber);
	}
	
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public int getHomeNumber() {
		return homeNumber;
	}
	public void setHomeNumber(int homeNumber) {
		if(homeNumber>=1&&homeNumber<=100000) {
		this.homeNumber = homeNumber;
		} else {
			throw new IncorrectNumberException("Only numbers from 1 to 100000", homeNumber);
		}
	}
	public String getHomeBuildingNumber() {
		return homeBuildingNumber;
	}
	public void setHomeBuildingNumber(String homeBuildingNumber) {
		this.homeBuildingNumber = homeBuildingNumber;
	}
	public int getFlatNumber() {
		return flatNumber;
	}
	public void setFlat(int flatNumber) {
		if(flatNumber>=1&&flatNumber<=100000) {
		this.flatNumber = flatNumber;
		} else {
			throw new IncorrectNumberException("Only numbers from 1 to 100000", flatNumber);
			}
	}
	@Override
	public String toString() {
		if(flatNumber==null) {
			return streetName + " " + homeNumber;
		}
		else if(homeBuildingNumber.equals("")) {
			return streetName + " " + homeNumber + "-" + flatNumber;
		}else {
		return streetName + " " + homeNumber + "/"
				+ homeBuildingNumber + "-" + flatNumber;
		}
	}
	
	
	
	

}
