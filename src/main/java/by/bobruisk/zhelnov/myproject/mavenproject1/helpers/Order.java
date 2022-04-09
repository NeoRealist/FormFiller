package by.bobruisk.zhelnov.myproject.mavenproject1.helpers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.bobruisk.zhelnov.myproject.mavenproject1.Controllers.dbcontrollers.DatabaseHandler;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Order {
	IntegerProperty id;
	StringProperty street;
	StringProperty city;
	static List<Order> orders;

	public Order(Integer id, String street, String city) {
		this.id = new SimpleIntegerProperty(id);
		this.street = new SimpleStringProperty(street);
		this.city = new SimpleStringProperty(city);
	}

	public int getId() {
		return id.get();
	}

	public void setId(int id) {
		this.id.set(id);
	}

	public IntegerProperty idProperty() {
		return id;
	}

	public String getStreet() {
		return street.get();
	}

	public void setStreet(String street) {
		this.street.set(street);
	}

	public StringProperty streetProperty() {
		return street;
	}

	public String getCity() {
		return city.get();
	}

	public void setCity(String city) {
		this.city.set(city);
	}

	public StringProperty cityProperty() {
		return city;
	}

	public String toString() {
		return id + ", " + street + ", " + city;

	}
	public static ArrayList<Order> getOrders() {
		DatabaseHandler dbHandler = new DatabaseHandler();
		ArrayList<Order> arr = new ArrayList();
		
		String select  = "SELECT * FROM street";
		
		try {
			
			PreparedStatement prSt = dbHandler.getDBConnection().prepareStatement(select);
			ResultSet rs = prSt.executeQuery(select);
			while(rs.next()) {
				arr.add(new Order(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
//		arr.add(new Order(1, "New York", "New York")); // 8,323,340
//		arr.add(new Order(2, "Colorado", "Denver"));
//		arr.add(new Order(3, "Missouri", "Kansas City"));
//		arr.add(new Order(4, "Nebraska", "Custer"));
//		arr.add(new Order(5, "Iowa", "Black Hawk"));
//		arr.add(new Order(6, "Nevada", "Las Vegas"));
//		arr.add(new Order(7, "California", "San Diego")); // 1.54m
//		arr.add(new Order(8, "Illinois", "Chicago")); // 2.2m
//		arr.add(new Order(9, "Massachusetts", "Boston")); // 4.3m
//		arr.add(new Order(10, "Vermont", "Montpellier"));
//		arr.add(new Order(11, "Alberta", "Revelstoke"));
//		arr.add(new Order(12, "Manitoba", "Winnipeg"));
//		arr.add(new Order(13, "British Colombia", "Terrace"));
		return (ArrayList<Order>) arr;
		
	}


}
