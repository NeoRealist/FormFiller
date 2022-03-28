package by.bobruisk.zhelnov.myproject.mavenproject1.Controllers.dbcontrollers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.bobruisk.zhelnov.myproject.mavenproject1.User;

public class DatabaseHandler extends Configs {
	
	Connection dbConnection;
	
	public Connection getDBConnection() 
		throws ClassNotFoundException, SQLException{
			String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPassword);
			return dbConnection;
		}
	
	public void signUpUser(User user) {
		
		String insert = "INSERT INTO " + Const.USER_TABLE
				+ "(" + Const.USER_NAME + "," + Const.USER_SURNAME + ","
				+ Const.USER_PATRONYMIC + "," + Const.USER_ORGANISATION + ","
				+ Const.USER_DEPARTMENT + "," + Const.USER_SPECIALITY + ","
				+ Const.USER_EMAIL + "," + Const.USER_PASSWORD + ")" + " VALUES(?,?,?,?,?,?,?,?)";		
		
		try {
			PreparedStatement prSt = getDBConnection().prepareStatement(insert);	
			prSt.setString(1, user.getFullName().getName());
			prSt.setString(2, user.getFullName().getSurname());
			prSt.setString(3, user.getFullName().getPatronymic());
			prSt.setString(4, user.getOrganizationName());
			prSt.setString(5, user.getDepartmentName());
			prSt.setString(6, user.getSpeciality());
			prSt.setString(7, user.getEmail());
			prSt.setString(8, user.getPassword());
			
			prSt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultSet hasUser(String email, String password) {
		ResultSet resultSet = null;
		
		String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_EMAIL + "=? AND " + Const.USER_PASSWORD + "=?";
		
		try {
			PreparedStatement prSt = getDBConnection().prepareStatement(select);
			prSt.setString(1, email);
			prSt.setString(2, password);
			
			resultSet = prSt.executeQuery();			
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
		
		
	}
	
	
	

}
