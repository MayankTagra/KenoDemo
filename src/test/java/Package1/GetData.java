package Package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetData {
	
	static Connection con=null;
	static String url="jdbc:sqlite:C://sqlite/CollegeDB.db";
	public static void main(String[] args)
	{	
		retrievetData();
		int countResult=count();
		System.out.println("CountResult"+" "+countResult);
		
		int averageResult=dataAvg();
		System.out.println("Average Result"+" "+averageResult);
		
		
		int sumResult=DataSum();
		System.out.println("Sum Result"+" "+sumResult);
		
	}
	
	public static void insertData() throws SQLException
	{	
		
		try
		{
			con=DriverManager.getConnection(url);
			Statement stm=con.createStatement();
			
			String sql="INSERT INTO personelDetail(\"id\",\"firstname\",\"lastname\","
					+ "\"age\") VALUES (3,\"Manish\",\"Tiwary\")";
			stm.execute(sql);
			System.out.println("Successful Insertion Of Data into Table");
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured");
			e.printStackTrace();
		}
	
	}
	
	public static void retrievetData()
	{
		try
		{
			con=DriverManager.getConnection(url);
			Statement stm=con.createStatement();
			String sql="SELECT * FROM personelDetail";
			ResultSet res=stm.executeQuery(sql);
			System.out.println("id"+"  "+"FirstName"+"  "+"LastName"+"  "+"age");
			
			while(res.next())
			{
				System.out.print(res.getInt("id"));
				System.out.print("   ");
				System.out.print(res.getString("firstname"));
				System.out.print("     ");
				System.out.print(res.getString("lastname"));
				System.out.print("     ");
				System.out.print(res.getInt("age"));
				System.out.println();
			}
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured");
			e.printStackTrace();
			
		}
	}
	
	public static int count()
	{	int i = 0;
		try
		{
			con=DriverManager.getConnection(url);
			Statement stm=con.createStatement();
			String sql="SELECT COUNT(firstname) FROM personelDetail";
			ResultSet res=stm.executeQuery(sql);
			while(res.next())
			{
				System.out.println("Count"+" "+res.getInt(1));
				 i=res.getInt(1);
				
			}
			return i;
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured");
			e.printStackTrace();
			
			return 0;
		}
		
	}
	public static int  dataAvg() 
	{		
		int j=0;
		
		try
		{
			con=DriverManager.getConnection(url);
			Statement stm=con.createStatement();
			
			String sql="SELECT AVG(firstname) FROM personelDetail";
			ResultSet res=stm.executeQuery(sql);
			while(res.next())
			{
				j=res.getInt(1);
			}
			
			return j;
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured");
			e.printStackTrace();
			return 0;
		}
		
	}
	public static int  DataSum()
	{	
		int k=0;
		
		try
		{	
			con=DriverManager.getConnection(url);
			Statement stm=con.createStatement();
			String sql="SELECT SUM(id) from personelDetail";
			ResultSet res=stm.executeQuery(sql);
			while(res.next())
			{
				k=res.getInt(1);
				
			}
			return k;
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured");
			e.printStackTrace();
			return 0;
		}
	}
	public static void  innerOperation()
	{
		try
		{
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured");
			e.printStackTrace();
		}
	}

}
