package com.companyname.chatapp.dao;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.companyname.chatapp.utils.ConfigReader;

//necessary for crud operation in RDBMS
public class CommonDAO {

	 public static Connection createConnection() throws ClassNotFoundException, SQLException {
   	  //1st loading class 
   	  Class.forName(ConfigReader.getValue("Driver"));//
   	  //2nd connection 
   	  final  String CONNECTION_STRING=ConfigReader.getValue("CONNECTION");
      final  String User_id=ConfigReader.getValue("Userid");
      final String Password=ConfigReader.getValue("Password");
   	  Connection con=DriverManager.getConnection(CONNECTION_STRING,User_id,Password);
   	  if(con!=null)
   	  {
   		 System.out.println("succesfully connected");
   	  }
   	  else
       System.out.print("dfdsf");
   	 return con;   
	 }
	 public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 CommonDAO cd=new CommonDAO();
		 cd.createConnection();
	 }
}
