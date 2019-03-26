package com.example.Timesheet.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class TimesheetApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(TimesheetApplication.class, args);
		getConnection();
	}
	public static Connection getConnection() throws Exception{
		try {

			String url = "jdbc:sqlserver://localhost:1433;databaseName=timesheetdb;user=admin;password=Cgi12345*"; //local

			Connection conn = DriverManager.getConnection(url);
			System.out.println("Connected successfuly");

			
			
			return conn;
		}catch (Exception e) {
			
			System.out.println(e);
		}
		
		return null;
		
	}
}
