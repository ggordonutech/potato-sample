import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			rawDBConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	//jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]
	private static String connectionString = "jdbc:mysql://localhost:3306/potatodb?useSSL=false";
	
	public static void rawDBConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Class.forName(com.mysql.jdbc.Driver.class.getName()).newInstance();
		Connection con = DriverManager.getConnection(connectionString,"root","");
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery("Select * from potatoes");
		if(rs != null) {
			while(rs.next()) {
				System.out.println("Got Potato with Id : "+rs.getInt("id")+" and types : "+rs.getString("type"));
			}
		}
		stat.close();
	}

}
