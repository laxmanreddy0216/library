import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Issue extends HttpServlet
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
                    String a1=req.getParameter("b1");
					String a2=req.getParameter("b2");
					String a3=req.getParameter("b3");
					String a4=req.getParameter("b4");
					String a5=req.getParameter("b5");
					String a6=req.getParameter("b6");
					ps=con.prepareStatement("insert into ir values(?,?,?,?,?,?)");
					ps.setString(1,a1);
					ps.setString(2,a2);
					ps.setString(3,a3);
					ps.setString(4,a4);
					ps.setString(5,a5);
					ps.setString(6,a6);
					int k=ps.executeUpdate();
					if(k!=0)
				{
					RequestDispatcher rd=req.getRequestDispatcher("issue10.html");
								rd.forward(req,res);
				}
						else
							pw.println("<html><body>failed</body></html>");
			
			
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		/*try{
                    Connection con=null;
		            PreparedStatement ps=null;
		            ResultSet rs=null;
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","laxman","0216");
                    
					ps=con.prepareStatement("select * from book");
					rs=ps.executeQuery();

					while(rs.next())
				{
					s1=rs.getString("bname");
					s2=rs.getString("bid");
					s3=rs.getString("bedition");
					s4=rs.getString("bdate");
					s5=rs.getString("bprice");
				}
				System.out.println(s1);
                   if(s2.equals(a2)&&s1.equalsIgnoreCase(a1))
				{
							//pw.println("Added Succesfully");*/
							
			
			
			/*catch (Exception e)
			{
				e.printStackTrace();
			}*/
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
	