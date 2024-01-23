package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Student;

public class StudentControllerImplements implements StudentController {

	Connection conn=null;
	
	public StudentControllerImplements()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	
	@Override
	public boolean addStudent(Student std) {
		
		
		String sql="insert into studenttable (fname,lname,city,number,age) values(?,?,?,?,?)";
		try {
			PreparedStatement pstm= conn.prepareStatement(sql);
			pstm.setString(1,std.getFname());
			pstm.setString(2,std.getLname());
			pstm.setString(3, std.getCity());
			pstm.setString(4, std.getNumber());
			pstm.setInt(5, std.getAge());
			pstm.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}
	
	
	
	
	
	
	

}
