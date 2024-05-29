package in.registerPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.eclipse.jdt.internal.compiler.ast.TryStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.tagext.TryCatchFinally;

@WebServlet("/regForm")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String myName = req.getParameter("name1");
		String myEmail = req.getParameter("email1");
		String myPass = req.getParameter("pass1");
		String myGender = req.getParameter("gender1");
		String myCity = req.getParameter("city1");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationForm", "root",
					"shreyas@mySQL");
			PreparedStatement ps = con.prepareStatement("INSERT INTO RegisteredUser VALUES(?,?,?,?,?)");
			ps.setString(1, myName);
			ps.setString(2, myEmail);
			ps.setString(3, myPass);
			ps.setString(4, myGender);
			ps.setString(5, myCity);
			int count = ps.executeUpdate();
			if (count > 0) {
				resp.setContentType("text/html");
				out.print("<h3 style ='color:green'>User Registerd Succesufully</h3>");

				RequestDispatcher rd = req.getRequestDispatcher("/Index.jsp");
				rd.include(req, resp);
			} else {
				resp.setContentType("text/html");
				out.print("<h3 style ='color:error'>User Error</h3>");

				RequestDispatcher rd = req.getRequestDispatcher("/Index.jsp");
				rd.include(req, resp);

			}
		} catch (Exception e) {
			out.print("<h3 style ='color:error'>Exception Occured :" + e.getMessage() + "</h3>");

			RequestDispatcher rd = req.getRequestDispatcher("/Index.jsp");
			rd.include(req, resp);

		}
	}
}
