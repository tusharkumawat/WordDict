package WordDict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;




public class DBInfo 
{
	static Connection con=null;
	static
	{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		
	}
	catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	}
	public static Connection getConnection()
	{
		
		try
		{
		   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/worddict", "root", "rat");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	
}
