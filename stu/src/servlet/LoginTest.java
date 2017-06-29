package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class LoginTest
 */

public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String user="root";
	private String password="aqgywagl";
	private String url="jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8";
	private Connection co=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = null,passwd=null;
		String id = null;
		 id=request.getParameter("id");
		try {
			 String sql="SELECT username,password FROM userdata where id=?";
			 co=DriverManager.getConnection(url,user,password);
				ps=co.prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				while(rs.next()){
					username=rs.getString("username");
					passwd=rs.getString("password");
				}
				if(request.getParameter("username").equals(username)&&request.getParameter("password").equals(passwd))
		     request.getRequestDispatcher("choose.jsp").forward(request, response);
				else{
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				co.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
