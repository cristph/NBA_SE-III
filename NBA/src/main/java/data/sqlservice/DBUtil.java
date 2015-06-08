package data.sqlservice;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static String driver=null;
	private static String url=null;
	private static String username=null;
	private static String password=null;

	static
	{
		Properties prop=new Properties();
		try {
			FileReader in=new FileReader("src//config.sqlDriver.properties");
			prop.load(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver=prop.getProperty("driver");
		url=prop.getProperty("url");
		username=prop.getProperty("username");
		password=prop.getProperty("password");
	}
	public static Connection open(){
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn)
	{
		if(conn!=null)
		{
			try 
		    {
				conn.close();
			} 
		    catch (SQLException e) 
		    {
			    e.printStackTrace();
			}
		}
	}
}
