package com.prodemy.h1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Fathiyah's Profile Page</title>");
			out.println("<link rel = 'stylesheet' href = 'styles.css'>");
			
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> My profile </h1>");
		out.println("<table style='width:75%' border='1px' align='center'>");
		
		out.println("<tr>  <td colspan='7'><h2>");
		//out.println("<a href='https://drive.google.com/file/d/1sKiBFqIMAELPW-hHIVOi8xJQniYunyDK/view?usp=sharing' target='blank'>");
		out.println("<img src='https://lh6.googleusercontent.com/ozcQNK1zbWVzp3gL05RFVaXIQfYWkxdY0VdOtmHTqtGGn92Ga-Jpvawwd3jZaOUsPWs=w2400' width='100'>");
		//out.println("</a>");
		out.println("</h2>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");	
		out.println("<td>Nama</td>");		
		out.println("<td> : </td>");		
		out.println("<td>Fathiyah Kalamal Haq</td>");		
		out.println("<td>    </td>");		
		out.println("<td>Almamater</td>");		
		out.println("<td>:</td>");		
		out.println("<td>UNPAD</td>");		

		out.println("</tr>");	
		out.println("<tr>");	
		out.println("<td>Domisili</td>");		
		out.println("<td> : </td>");		
		out.println("<td>Cirebon, Jawa Barat</td>");		
		out.println("<td>    </td>");	
		out.println("<td>Hobi</td>");		
		out.println("<td> : </td>");				
		out.println("<td>Panahan</td>");		
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Gender</td>");		
		out.println("<td> : </td>");		
		out.println("<td>Perempuan</td>");		
		out.println("<td>    </td>");		
		out.println("<td>Github</td>");		
		out.println("<td> : </td>");		
		out.println("<td>");
		out.println("<a href = 'https://github.com/Fathiyahkhaq' target='blank'>");			
			out.println("Fathiyahkhaq ");			
			out.println("</a>");		
			out.println("</td>");
			out.println("</tr>");
			

			out.println("</table>");
		out.println("</body>");
		out.println("</html>");

		
	}

}
