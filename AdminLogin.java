import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AdminLogin extends HttpServlet
{
	
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		PrintWriter pw=null;
		String s=null,lid=null,lpass=null;
		public void myMethod(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
			try
			{
					res.setContentType("text/html");
					pw=res.getWriter();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","laxman","0216");
					String eid=req.getParameter("a1");
					String epass=req.getParameter("a2");
					s="select aid,apwd from admin";
					ps=con.prepareStatement(s);
					rs=ps.executeQuery();
				while(rs.next())
				{
						lid=rs.getString(1);
						lpass=rs.getString(2);
				
				if(eid.equalsIgnoreCase(lid)&&epass.equals(lpass))
				{
				 RequestDispatcher rd=req.getRequestDispatcher("adminall13.html");
				rd.forward(req,res);
				}
				else
				{
					pw.println("<html>");
					pw.println("<body bgcolor='white'>");
					pw.println("<u>");
					pw.println("Oops......!!!&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login failed");
					pw.println("</u>");
					pw.println("<a href='http://localhost:0216/loginapp/admin.html'>Go To LoginPage</a>");
					pw.println("</body>");
					pw.println("<html>");
					}
				}
				
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
