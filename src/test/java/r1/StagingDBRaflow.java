package r1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StagingDBRaflow {

	public static void main(String[] args) throws SQLException {
		
		//jdbc:sqlserver://APP01\\SQL2016;databaseName=PreciseMri;
		String connectionDetail = "jdbc:sqlserver://APP04-STAG-WIN2;trustServerCertificate=true;databaseName=PreciseMri_Staging";
		String username = "sa";
		String pass =  "N716$c%&bAP";  //"N716$c%&bAP";
		//IntegratedSecurity=true
		/// Connection con = DriverManager.getConnection(connectionDetail, username,
		/// pass);
		// DriverManager.registerDriver(new
		/// com.microsoft.sqlserver.jdbc.SQLServerDriver());
		Connection con = DriverManager.getConnection(connectionDetail, username, pass);
		System.out.println("Connection made");

		String sql = "Select top(10) * from PatientModule";

		Statement st = con.createStatement();

		ResultSet res = st.executeQuery(sql);
		int count1 = 0;
		while (res.next()) {

			for (int i = 0; i < res.getMetaData().getColumnCount(); i++) {
				String sx2 = res.getString(i + 1);
				System.out.print(sx2 + " ");

			}
			count1++;
			System.out.println();
		}

		System.out.println("***************************");

		con.close();
	}
}
