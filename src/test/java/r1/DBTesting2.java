package r1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTesting2 {

	public static void main(String[] args) throws SQLException {

		String connectionDetail = "jdbc:sqlserver://server;trustServerCertificate=true;databaseName=PreciseMRI_Staging";
		String username = "sa";
		String pass = "sa2021";
		// IntegratedSecurity=true
		/// Connection con = DriverManager.getConnection(connectionDetail, username,
		/// pass);
		// DriverManager.registerDriver(new
		/// com.microsoft.sqlserver.jdbc.SQLServerDriver());
		Connection con = DriverManager.getConnection(connectionDetail, username, pass);
		System.out.println("Connection made");
		String likeArgument = "%_SIG____";

		String sql = "select * from STUDYSTATUSVALUES where STATUS like '" + likeArgument + "'";

		Statement st = con.createStatement();

		ResultSet res = st.executeQuery(sql);

		int count = 0;
		while (res.next()) {
			count++;
			String name = res.getString("STATUS");
			System.out.println(name);

		}
		System.out.println(count);

		con.close();
	}

}
