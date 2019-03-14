import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Books extends HttpServlet
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
                    String a1=req.getParameter("b1");
					String a2=req.getParameter("b2");
					String a3=req.getParameter("b3");
					String a4=req.getParameter("b4");
					String a5=req.getParameter("b5");
					ps=con.prepareStatement("insert into book values(?,?,?,?,?)");
					ps.setString(1,a1);
					ps.setString(2,a2);
					ps.setString(3,a3);
					ps.setString(4,a4);
					ps.setString(5,a5);
					int k=ps.executeUpdate();
						if(k!=0)
				{
						pw.println(<html><head><script type="text/javascript"> alert("Inserted successfully");
				
							RequestDispatcher rd=req.getRequestDispatcher("books7.html");
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
