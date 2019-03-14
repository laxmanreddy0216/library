import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Vbooks extends HttpServlet
{
	Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		PrintWriter pw=null;
		String s1=null,s2=null,s3=null,s4=null,s5=null;
		public void myMethod(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
			try
			{
					res.setContentType("text/html");
					pw=res.getWriter();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","laxman","0216");
                    ps=con.prepareStatement("select * from book");
					rs=ps.executeQuery();
					pw.println("<html><body><h3><u>Press ctrl + F to search a book</u></h3></body></html>");
					while(rs.next())
				{
                    s1=rs.getString("bname");
					s2=rs.getString("bid");
					s3=rs.getString("bedition");
					s4=rs.getString("bdate");
					s5=rs.getString("bprice");
				                        pw.println("<html><body><h3><u>name&nbsp;,&nbsp;ID</u></h3></body>");
                                        pw.println(s1);
                                        pw.println(s2);
										pw.println("<br>");
				}
                         }
                         catch(Exception e)
                        {
                          e.printStackTrace();
                         }
finally
{
	try
	{
		ps.close();
        con.close();
        rs.close();
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}

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
	

					
              

