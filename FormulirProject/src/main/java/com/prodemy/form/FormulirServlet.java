package com.prodemy.form;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/input")
public class FormulirServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		String kode = req.getParameter("kode");
		String nama = req.getParameter("nama");
		String alamat = req.getParameter("alamat");
		
		String SQL_INSERT = "INSERT INTO \"MAHASISWA\""+
        		"VALUES (nextval('seq_mhs'),?,?,?) ";
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/Universitas","postgres","postgres");
				PreparedStatement ps = conn.prepareStatement(SQL_INSERT);){
			ps.setString(1, kode);
			ps.setString(2, nama);
			ps.setString(3, alamat);
			
			int count=ps.executeUpdate();
			if (count==0) {
				out.println("Data belum tersimpan di database.");
			} else {
				out.println("Data sudah tersimpan di database.");
			}
			
		} catch (SQLException e) {
			out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			out.println(e.getMessage());
			e.printStackTrace();
		}
		out.close();
	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doGet(req, resp);
//	}
	

}
