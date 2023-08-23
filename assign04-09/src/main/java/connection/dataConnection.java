package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class dataConnection {
	
	public static Connection connectmethod() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/advancejava","root","");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}

}
