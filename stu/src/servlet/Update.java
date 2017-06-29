package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String user="root";
	private String password="aqgywagl";
	private String url="jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8";
	private Connection co=null;
	private PreparedStatement ps=null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		request.setCharacterEncoding("utf-8");
		 String id=request.getParameter("sid");
		 String name=request.getParameter("sname");
		 String math=request.getParameter("smath");
		 String cl=request.getParameter("scl");
		 String db=request.getParameter("sdb");
		 String ds=request.getParameter("sds");
		 String ja=request.getParameter("sjava");
		 
		try {
			 String sql="UPDATE student SET �ߵ���ѧ=?,C����=?,���ݽṹ=?,���ݿ�=?,java=?,����=? WHERE ѧ��=?";
			 co=DriverManager.getConnection(url,user,password);
				ps=co.prepareStatement(sql);
				ps.setString(1, math);
				ps.setString(2, cl);
				ps.setString(3, ds);
				ps.setString(4, db);
				ps.setString(5, ja);
				ps.setString(6, name);
				ps.setString(7, id);
				ps.executeUpdate();
				//System.out.println(c);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				co.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	  request.getRequestDispatcher("list").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
