package com.example.Timesheet.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController extends AbstractController{
	String url = "jdbc:sqlserver://localhost:1433;databaseName=timesheetdb;user=admin;password=Cgi12345*"; //local

	 
	  @GetMapping("/person")
	    public Person getLastName(@RequestParam(value="id", defaultValue="0") int id) throws SQLException {
		
		  String sqlQuery = "SELECT * FROM Persons WHERE PersonID = " +id +";"; 
		  Connection conn = DriverManager.getConnection(url); 
		  Statement statement = conn.createStatement(); 
		  ResultSet rs = statement.executeQuery(sqlQuery);
		  Person person = new Person();
		  
		  while (rs.next()) {//Un mapping doit être fait avec mapstruct
				  person.setId(rs.getInt("PersonID"));
				  person.setLastName(rs.getString("LastName"));
				  person.setFirstName(rs.getString("FirstName"));
				  person.setAddress(rs.getString("Address"));
				  person.setCity(rs.getString("City"));
		
				}
	      return person;
	       
	    }
	  
	  @PutMapping("/putPerson")
	  public Person putPerson(@RequestBody Person person) throws SQLException {
		  String sqlQuery = "INSERT INTO Persons (PersonID, LastName,FirstName, Address, City) VALUES ("+person.getId()+","+"'"+person.getLastName()+"'"
		  +","+"'"+person.getFirstName()+"'"+","+"'"+person.getAddress()+"'"+","+"'"+person.getCity()+"'"+")"; 
		  System.out.println(sqlQuery);
		  Connection conn = DriverManager.getConnection(url); 
		  Statement statement = conn.createStatement(); 
		  statement.executeUpdate(sqlQuery);
		  
		  return person;
	  }
}
