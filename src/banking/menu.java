package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class menu {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String userName = "sys as sysdba";
			String password = "sys";
			
			Connection con = DriverManager.getConnection(url, userName, password);
			
            Statement stmt = con.createStatement();
            ResultSet ps = stmt.executeQuery("insert into product values(100,200000)");
			ResultSet rs = stmt.executeQuery("select * from product");	
			while(rs.next()) {
				System.out.println("Prod Id: "+rs.getString(1)+"  "+rs.getString(2));
				
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}