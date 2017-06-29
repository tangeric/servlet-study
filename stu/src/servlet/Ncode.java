package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

import data.Count;
import data.Stuinfo;


public class Ncode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String user="root";
	private String password="aqgywagl";
	private String url="jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8";
	private Connection co=null;
	private Statement st=null;
	private ResultSet rs=null;
 
    public Ncode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
		int a=0;
		Stuinfo sf=new Stuinfo();
		Count con=new Count();
		try {
			 a=con.getcount();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int i, id[], math[], cl[], db[], ds[], ja[];
			i = 0;
			id = new int[a];
			math = new int[a];
			cl = new int[a];
			db = new int[a];
			ds = new int[a];
			ja = new int[a];
		String name[] =new String[a];
		try {
			 String sql="SELECT * FROM student";
			 co=DriverManager.getConnection(url,user,password);
				st=co.createStatement();
				rs=st.executeQuery(sql);
			while(rs.next()){
			 id[i]=rs.getInt("学号");
			 math[i]=rs.getInt("高等数学");
			 cl[i]=rs.getInt("C语言");
			 db[i]=rs.getInt("数据结构");
			 ds[i]=rs.getInt("数据库");
			 ja[i]=rs.getInt("java");
			 name[i]=rs.getString("姓名");
			 i++;
			}
			sf.setId(id);
			sf.setClanguage(cl);
			sf.setDatastruct(ds);
			sf.setDatebase(db);
			sf.setMaths(math);
			sf.setJava(ja);
			sf.setName(name);
		     HttpSession session=request.getSession(true);
		     session.setAttribute("student", sf);
		     request.getRequestDispatcher("select.jsp").forward(request, response);
		
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
