import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Lbook extends HttpServlet
{
	Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		PrintWriter pw=null;
		String s1=null,s2=null,s3=null,s4=null,s5=null,s6=null;
		public void myMethod(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
			try
			{
					res.setContentType("text/html");
					pw=res.getWriter();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","laxman","0216");
				    String a2=req.getParameter("t1");
                    ps=con.prepareStatement("select bprice from ir where bid='?';");
					ps.setString(1,a2);
					rs=ps.executeQuery();
					//pw.println("<html><body><h3><u>Press ctrl + F to search Pending Returns</u></h3></body></html>");
					while(rs.next())
				{
                    
					s1=rs.getString("1");
				                        
                                        pw.println(s1);
                                        
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
	

					
              

