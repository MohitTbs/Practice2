package r1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;



public class DBTestingUpdate {

	public static void main(String[] args) {

		String connectionDetail = "jdbc:sqlserver://server;trustServerCertificate=true;databaseName=Mechmachine";
		String username = "sa";
		String pass = "sa2021";
		//IntegratedSecurity=true
		/// Connection con = DriverManager.getConnection(connectionDetail, username,
		/// pass);
		// DriverManager.registerDriver(new
		/// com.microsoft.sqlserver.jdbc.SQLServerDriver());
		 
		try {
			Connection con = DriverManager.getConnection(connectionDetail, username, pass);
			
			int affectedRows=0;

			
			//-----------Using PreparedStatement---------------//
			/*
			String q = "update PersonDetails set Name=?, Origin=? where id=?";
			PreparedStatement pstmt = con.prepareStatement(q);
			
			String name = "Vidhya";
			String origin = "Mexico";
			int id = 1;

			pstmt.setString(1, name);
			pstmt.setString(2, origin);
			pstmt.setInt(3, id);
			
			affectedRows = pstmt.executeUpdate(); -- This gives number of rows affected

			*/
			//-----------Using Statement---------------//
			
			/*
			int[] arr1 = {1,2};
			String st ="(";
			for(int k =0;k<arr1.length;k++) {
				st=st+arr1[k];
				if(k==(arr1.length-1)) {
					break;
				}
				st=st+",";
			}
			st=st+")";
			
			System.out.println("iLike: "+st);
			
			String q = "update PersonDetails set FamilyMember=14 where id in (1,2)";
			Statement stmt = con.createStatement();
			
			affectedRows =stmt.executeUpdate(q);
			System.out.println("Affected Rows: "+affectedRows);
			System.out.println("done..........");
			*/
			
			//--------------- Using String in "In" ---------------------//
			/*
			String q = "update PersonDetails set FamilyMember = 18 where Origin in ('Mexico','UT')";
			Statement stmt = con.createStatement();
			
			affectedRows =stmt.executeUpdate(q);
			*/
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
