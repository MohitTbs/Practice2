package r1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBTesting {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		String connectionDetail = "jdbc:sqlserver://server;trustServerCertificate=true;databaseName=Mechmachine";
		String username = "sa";
		String pass = "sa2021";
		//IntegratedSecurity=true
		/// Connection con = DriverManager.getConnection(connectionDetail, username,
		/// pass);
		// DriverManager.registerDriver(new
		/// com.microsoft.sqlserver.jdbc.SQLServerDriver());
		Connection con = DriverManager.getConnection(connectionDetail, username, pass);
		System.out.println("Connection made");

		String sql = "Select * from PersonDetails";

		Statement st = con.createStatement();

		ResultSet res = st.executeQuery(sql);

		int count = 0;
		while (res.next()) {
			count++;
			String name = res.getString("Name");
			System.out.println(name);

		}
		System.out.println(count);

		/////////////////

		String s2 = "SELECT  * FROM  INFORMATION_SCHEMA.TABLES";

		ResultSet rs2 = st.executeQuery(s2);
		int c1 = 0;

		int count1 = 0;
		while (rs2.next()) {

			for (int i = 0; i < rs2.getMetaData().getColumnCount(); i++) {
				String sx2 = rs2.getString(i + 1);
				System.out.print(sx2 + " ");

			}
			count1++;
			System.out.println();
		}

		System.out.println("***************************");

		con.close();
	}

}
