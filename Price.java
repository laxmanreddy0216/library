import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Price extends HttpServlet
{
	
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		PrintWriter pw=null;
		String s=null,bprice=null;
		public void myMethod(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
			try
			{
					res.setContentType("text/html");
					pw=res.getWriter();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","laxman","0216");
					String id=req.getParameter("t1");
					String price=req.getParameter("t2");
					s="select bprice from book where bid="+id+"";
					ps=con.prepareStatement(s);
					rs=ps.executeQuery();
				while(rs.next())
				{
						bprice=rs.getString(1);
						rs.setString("t2");
				}
			}

				
				/*if(b2name.equalsIgnoreCase(bname)&&bid.equals(id))
				{
				 RequestDispatcher rd=req.getRequestDispatcher("bprice11.html");
				rd.forward(req,res);
				}
				else
				{
					pw.println("no book");
					}
				}
				
			}*/
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
