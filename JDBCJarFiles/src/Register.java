import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.get the info from the html to servelet 2.JDBC
		String name=request.getParameter("user");
		String email=request.getParameter("email");
		PrintWriter pw=response.getWriter();
		
		//pw.print(name+" "+email);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","lakshmich");	
		
		  String sql="insert into register values(?,?)";
		  PreparedStatement ps=con.prepareStatement(sql);
		  ps.setString(1, name);
		  ps.setString(2,email);
		  int i=ps.executeUpdate();
		  if(i>0) {
			  pw.print(i+" "+"record inserted successfully");
		  }
	   else {
		   pw.print("no record inserted");
	   }
		
	}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
