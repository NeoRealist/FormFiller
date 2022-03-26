package by.bobruisk.zhelnov.myproject.mavenproject1;


public class HomeAddress {
		
	private String streetName;
	private Integer homeNumber;
	private String homeBuildingNumber;
	private Integer flatNumber;
	
	public HomeAddress(String streetName, int homeNumber, String homeBuildingNumber, int flatNumber)  {
		setStreetName(streetName);
		setHomeNumber(homeNumber);
		setHomeBuildingNumber(homeBuildingNumber);
		setFlat(flatNumber);
	}
	public HomeAddress(String streetName, int homeNumber)  {
		setStreetName(streetName);
		setHomeNumber(homeNumber);
		this.homeBuildingNumber = null;
		this.flatNumber = null;
		
	}
	public HomeAddress(String streetName, int homeNumber,  int flatNumber)  {
		setStreetName(streetName);
		setHomeNumber(homeNumber);
		this.homeBuildingNumber = null;
		setFlat(flatNumber);
	}
	public HomeAddress() {
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
		this.homeNumber = homeNumber;
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
	public void setFlat(int flatNumber)  {
		this.flatNumber = flatNumber;

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
