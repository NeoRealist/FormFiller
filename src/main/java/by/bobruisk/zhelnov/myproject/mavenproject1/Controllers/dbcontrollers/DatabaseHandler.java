package by.bobruisk.zhelnov.myproject.mavenproject1.Controllers.dbcontrollers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.apache.ibatis.jdbc.ScriptRunner;

import by.bobruisk.zhelnov.myproject.mavenproject1.App;
import by.bobruisk.zhelnov.myproject.mavenproject1.Patient;
import by.bobruisk.zhelnov.myproject.mavenproject1.User;
import by.bobruisk.zhelnov.myproject.mavenproject1.helpers.Order;

public class DatabaseHandler extends Configs {
	
	URL url = App.class.getResource("constants/database.properties");

	Connection dbConnection;

	public Connection getDBConnection() throws ClassNotFoundException, SQLException {
		String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/sys";

		Class.forName("com.mysql.cj.jdbc.Driver");

		dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);

		checkOrCreateDatabase(dbConnection, connectionString);

		connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

		dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);

		createEntryTable(dbConnection);

		createUserTable(dbConnection);

		createStreetTable(dbConnection);
		runSqlScript(App.class.getResource("sql-scripts/addStreets.sql"));

		return dbConnection;
	}

	public void signUpUser(User user) throws ClassNotFoundException, SQLException {

		String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_NAME + "," + Const.USER_SURNAME + ","
				+ Const.USER_PATRONYMIC + "," + Const.USER_ORGANISATION + "," + Const.USER_DEPARTMENT + ","
				+ Const.USER_SPECIALITY + "," + Const.USER_EMAIL + "," + Const.USER_PASSWORD + ")"
				+ " VALUES(?,?,?,?,?,?,?,?)";

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

		String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_EMAIL + "=? AND "
				+ Const.USER_PASSWORD + "=?";

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

	private void checkOrCreateDatabase(Connection dbConnection, String connectionString) throws SQLException {
		Statement stat = dbConnection.createStatement();

		String checkdatabase = "show databases like '" + dbName + "'";
		String createdatabase = "create database " + dbName;
		stat = (Statement) dbConnection.createStatement();
		ResultSet resultSet = stat.executeQuery(checkdatabase);
		if (resultSet.next()) {
			System.out.println(dbName + " exist!");
			stat.close();
			dbConnection.close();
		} else {
			if (stat.executeUpdate(createdatabase) == 0) {
				dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
				stat = dbConnection.createStatement();
				stat.close();
				dbConnection.close();
				System.out.println("create database success!");
			}
		}

	}

	private void createUserTable(Connection dbConnection) throws SQLException {
		Statement stat = dbConnection.createStatement();
		stat.execute(
				"CREATE TABLE IF NOT EXISTS user(iduser int AUTO_INCREMENT PRIMARY KEY, name varchar(45), surname varchar(45),patronymic varchar(45),"
						+ "organisation varchar(45),department varchar(45),speciality varchar(45),"
						+ "email varchar(45),password varchar(45))");

	}

	private void createEntryTable(Connection dbConnection) throws SQLException {
		Statement stat = dbConnection.createStatement();
		stat.execute("CREATE TABLE IF NOT EXISTS entry(" + "  `date` VARCHAR(10) NOT NULL,"
				+ "  `patient_surname` VARCHAR(45) NOT NULL," + "  `patient_name` VARCHAR(45) NOT NULL,"
				+ "  `patient_patronymic` VARCHAR(45) NOT NULL," + "  `patient_date_of_birth` VARCHAR(10) NOT NULL,"
				+ "  `patient_address` VARCHAR(45) NOT NULL," + "  `survey_reason` VARCHAR(45) NOT NULL,"
				+ "  `issued_analyzes` VARCHAR(100) NOT NULL,"
				+ "  PRIMARY KEY (`date`, `patient_surname`, `patient_name`, `patient_patronymic`, `patient_address`, `patient_date_of_birth`, `survey_reason`, `issued_analyzes`))");
	}

	public void addEntry(Patient patient, String surveyReason, String issuedAnylyses) {
		String insert = "INSERT INTO " + Const.ENTRY_TABLE + "(" + Const.ENTRY_DATE + "," + Const.ENTRY_PATIENT_SURNAME
				+ "," + Const.ENTRY_PATIENT_NAME + "," + Const.ENTRY_PATIENT_PATRONYMIC + ","
				+ Const.ENTRY_PATIENT_DATE_OF_BIRTH + "," + Const.ENTRY_PATIENT_ADRESS + "," + Const.ENTRY_SURVEY_REASON
				+ "," + Const.ENTRY_ISSUED_ANALYZES + ")" + " VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement prSt = getDBConnection().prepareStatement(insert);
			prSt.setString(1, getDateTodayString());
			prSt.setString(2, patient.getFullName().getSurname());
			prSt.setString(3, patient.getFullName().getName());
			prSt.setString(4, patient.getFullName().getPatronymic());
			prSt.setString(5, patient.getBirthDate().toString());
			prSt.setString(6, patient.getHomeAdress().toString());
			prSt.setString(7, surveyReason);
			prSt.setString(8, issuedAnylyses);

			prSt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void createStreetTable(Connection dbConnection) throws SQLException {
		Statement stat = dbConnection.createStatement();
		stat.execute(
				"CREATE TABLE IF NOT EXISTS street(id int AUTO_INCREMENT PRIMARY KEY, name varchar(45),city varchar(45))");
	}

	public void addStreet(Order order) {
		String insert = "INSERT INTO " + Const.STREET_TABLE + "(" + Const.STREET_NAME + "," + Const.STREET_CITY + ")"
				+ " VALUES(?,?)";
		try {
			PreparedStatement prSt = getDBConnection().prepareStatement(insert);
			prSt.setString(1, order.getStreet());
			prSt.setString(2, order.getCity());

			prSt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static boolean isStreetsAdded = false;
	
	

	private void runSqlScript(URL url) {
		if (!isStreetsAdded) {
			ScriptRunner scriptRunner = new ScriptRunner(dbConnection);
			try {
				File file = Paths.get(url.toURI()).toFile();
				FileReader fileReader = new FileReader(file);
				Reader reader = new BufferedReader(fileReader);
				scriptRunner.runScript(reader);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			isStreetsAdded = true;
		}

	}

	private static String getDateTodayString() {
		String dateToday = String.valueOf(Calendar.getInstance().get(Calendar.DATE)) + "."
				+ String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1) + "."
				+ String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

		return dateToday;
	}

}
