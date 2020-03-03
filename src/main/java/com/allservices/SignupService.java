package com.allservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class SignupService implements DbOperations{

	public int save(String mailid, String pwd,String uname) {
		
		String url="jdbc:mysql://localhost:3306/demo";
		String user ="root";
		String password = "Xpsr350";
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,password);
			PreparedStatement pst = con.prepareStatement("insert into user values(?,?,?)");
			pst.setString(1,mailid);
			pst.setString(2,pwd);
			pst.setString(3,uname);
			i = pst.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e+"occured");
		}
		if(i>0)
			return 1;
		else
			return 0;
		
	}
}
