package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Count {

	private String user="root";
	private String password="aqgywagl";
	private String url="jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8";
	private Connection co=null;
	private Statement st=null;
	private ResultSet rs=null;
	public int getcount() throws SQLException{
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql="SELECT * FROM student";
			 co=DriverManager.getConnection(url,user,password);
				st=co.createStatement();
				rs=st.executeQuery(sql);
				rs.last();
			 count=rs.getRow();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			co.close();
		}
		
		return count;
	}
}
