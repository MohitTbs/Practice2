package r1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTestingInsert {

	public static void main(String[] args) throws SQLException {
		String connectionDetail = "jdbc:sqlserver://server;trustServerCertificate=true;databaseName=Mechmachine";
		String username = "sa";
		String pass = "sa2021";
		//IntegratedSecurity=true
		/// Connection con = DriverManager.getConnection(connectionDetail, username,
		/// pass);
		// DriverManager.registerDriver(new
		/// com.microsoft.sqlserver.jdbc.SQLServerDriver());
		
		Connection con = DriverManager.getConnection(connectionDetail, username, pass);
		String q = "insert into PersonDetails (id,Name,Grade,Origin,Income,FamilyMember)"
				+"values(?,?,?,?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(q);
		
		pstmt.setInt(1,7);
		pstmt.setString(2, "Vrush");
		pstmt.setInt(3, 44);
		pstmt.setString(4, "Nepal");
		pstmt.setInt(5, 30145);
		pstmt.setInt(6, 20);
		
		int affectedRow =0;
		affectedRow = pstmt.executeUpdate();
		System.out.println("Affected Row: "+affectedRow);
		con.close();
	}
}
