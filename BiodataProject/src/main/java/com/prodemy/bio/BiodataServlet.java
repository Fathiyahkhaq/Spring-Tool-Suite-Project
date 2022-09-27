/**
 * 
 */
package com.prodemy.bio;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
 * @author User
 *
 */
@WebServlet("/biodata")
public class BiodataServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();	
		
		String nim = req.getParameter("nim");
		String nama = req.getParameter("nama");
		String alamat = req.getParameter("alamat");
		String prodi = req.getParameter("prodi");
		
		out.println("<html>");
		out.println("<body >");
		out.println("<h2>Data yg disubmit:</h2>");
		out.println("nim: "+nim+"<br>");
		out.println("nama: "+nama+"<br>");
		out.println("alamat: "+alamat+"<br>");
		out.println("prodi: "+prodi+"<br>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
}
