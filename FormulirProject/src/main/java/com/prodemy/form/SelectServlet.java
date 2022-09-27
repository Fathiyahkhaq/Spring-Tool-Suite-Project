package com.prodemy.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/select")
public class SelectServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<html><body align='center'>");
		out.println("<h1> Tabel Mahasiswa</h1>");
//		String kode = req.getParameter("kode");
//		String nama = req.getParameter("nama");
//		String alamat = req.getParameter("alamat");
		
//		String SQL_SELECT = "SELECT * FROM \"MAHASISWA\"";
		
//		try {
//			Class.forName("org.postgresql.Driver");
//		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		
		try 
		{
			
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Universitas","postgres","postgres");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM \"MAHASISWA\"");
			ResultSet rs = ps.executeQuery();
			//resp.setHeader("Content-type","text/html");
			
//			out.println("<!DOCTYPE html>");
//			out.println("<html>");
//			out.println("<head>\r\n"
//					+ "<meta charset=\"UTF-8\">\r\n"
//					+ "<title>view table</title>\r\n"
//					+ "</head>");
//			out.println("<body>");
			
			out.println("<table align='center' border=1>");
			out.println("<caption>Daftar Mahasiswa</caption>");
//			ResultSetMetaData rsmd = rs.getMetaData();
//			int n = rsmd.getColumnCount();
//			
//			out.println("<tr>");
//			for (int i=1; i<=n;i++) {
//				out.println("<th>"+rsmd.getColumnName(i)+"</th>");
//			}
//			
//			out.print("</tr><br>");
			out.println("<tr><th>mhs_id</th><th>mhs_kode</th><th>mhs_nama</th><th>mhs_alamat</th><th>pr_id</th><th>fk_id</th><tr>");
			
//			while (rs.next()) {
//				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+
//							rs.getString(2)+"</td><td>"+
//							rs.getString(3)+"</td><td>"+
//							rs.getString(4)+"</td><td>"+
//							rs.getString(5)+"</td><td>"+
//							rs.getString(6)+"</td></tr><br>");
//			}
			while(rs.next()) {
				int id = rs.getInt("mhs_id");
				String kode = rs.getString("mhs_kode");
				String nama = rs.getString("mhs_nama");
				String alamat = rs.getString("mhs_alamat");
				int pr = rs.getInt("pr_id");
				int fk = rs.getInt("fk_id");
				out.println("<tr><td>" + id + "</td><td>" + kode + 
						"</td><td>" + nama + "</td><td>" + alamat+ 
						"</td><td>" + pr+ "</td><td>" + fk+"</td></tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		} catch (SQLException e) {
			out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			out.println(e.getMessage());
			e.printStackTrace();
		}
		out.close();
	}

}
