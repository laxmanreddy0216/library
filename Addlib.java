import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Addlib extends HttpServlet
{
	Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		PrintWriter pw=null;
		String a1=null,a2=null,q=null;
		public void myMethod(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
			try
			{
					res.setContentType("text/html");
					pw=res.getWriter();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","laxman","0216");
                    String a1=req.getParameter("u1");
					String a2=req.getParameter("u2");
					String a3=req.getParameter("u3");
					ps=con.prepareStatement("insert into librarian values(?,?,?)");
					ps.setString(1,a1);
					ps.setString(2,a2);
					ps.setString(3,a3);
					int k=ps.executeUpdate();
						if(k!=0)
				{
							pw.println("Added Succesfully");
				
							RequestDispatcher rd=req.getRequestDispatcher("addlib.html");
								rd.forward(req,res);
				}
						else
							pw.println("failed");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
}
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	myMethod(req,res);
	}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	myMethod(req,res);
	}

	}
	