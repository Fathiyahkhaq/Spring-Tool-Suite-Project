package com.prodemy.springmvc.dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.prodemy.springmvc.controller.Mahasiswa;
import com.prodemy.springmvc.dao.MahasiswaDao;

@Repository
public class MahasiswaDaoImpl implements MahasiswaDao{
	private Connection con = null;
	private String url = "jdbc:postgresql://localhost:5432/Universitas";
	private String username = "postgres";
	private String password = "postgres";
	
	public MahasiswaDaoImpl() {
		try {
			Class.forName("org.postgresql.Driver");			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() throws Exception {
		if (con!=null) {
			if (con.isClosed()) {
				con = DriverManager.getConnection(url, username, password);
			}
		} else {
			con = DriverManager.getConnection(url, username, password);
		}
		return con;
	}
	
	@Override
	public Mahasiswa findById(int id) throws Exception {
		Mahasiswa result = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			StringBuilder query = new StringBuilder("SELECT * FROM \"MAHASISWA\" WHERE \"MHS_ID\"=?");
			ps = getConnection().prepareStatement(query.toString());
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = new Mahasiswa();
				result.setId(rs.getInt("MHS_ID"));
				result.setKode(rs.getString("MHS_KODE"));
				result.setNama(rs.getString("MHS_NAMA"));
				result.setAlamat(rs.getString("MHS_ALAMAT"));
			}
		} finally {
			try {
				rs.close();
			} catch (Exception ignored) {}
			try {
				ps.close();
			} catch (Exception ignored) {}
		}
		
		return result;
	}
	@Override
	public void deleteById(int id) throws Exception {
		PreparedStatement ps = null;
		
		try {
			StringBuilder query = new StringBuilder("DELETE FROM \"MAHASISWA\" WHERE \"MHS_ID\" = ?");
			ps = getConnection().prepareStatement(query.toString());
			ps.setInt(1, id);
			ps.executeUpdate();
		} finally {
			try {
				ps.close();
			} catch (Exception ignored) {}			
		}
	}

	@Override
	public void insert(Mahasiswa mhs) throws Exception {
		PreparedStatement ps = null;
		
		try {
			StringBuilder query = new StringBuilder("INSERT INTO \"MAHASISWA\" VALUES (nextval('seq_mhs'),?,?,?)");
			ps = getConnection().prepareStatement(query.toString());
			//ps.setInt(1, mhs.getId());
			ps.setString(1, mhs.getKode());
			ps.setString(2, mhs.getNama());
			ps.setString(3, mhs.getAlamat());
			ps.executeUpdate();
		} finally {
			try {
				ps.close();
			} catch (Exception ignored) {}			
		}
	}

	@Override
	public void update(Mahasiswa mhs) throws Exception {
		PreparedStatement ps = null;
		
		try {
			StringBuilder query = new StringBuilder("UPDATE \"MAHASISWA\" SET \"MHS_KODE\"=?, \"MHS_NAMA\"=?, \"MHS_ALAMAT\"=? WHERE \"MHS_ID\" = ?");
			ps = getConnection().prepareStatement(query.toString());
			ps.setString(1, mhs.getKode());
			ps.setString(2, mhs.getNama());
			ps.setString(3, mhs.getAlamat());
			ps.setInt(4, mhs.getId());
			ps.executeUpdate();
		} finally {
			try {
				ps.close();
			} catch (Exception ignored) {}			
		}
	}

	@Override
	public List<Mahasiswa> findAll() throws Exception {
		List<Mahasiswa> result = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			StringBuilder query = new StringBuilder("SELECT * FROM \"MAHASISWA\"");
			ps = getConnection().prepareStatement(query.toString());
			rs = ps.executeQuery();
			if (rs.next()) {
				result = new ArrayList<>();
				do {
					Mahasiswa mhs = new Mahasiswa();
					mhs.setId(rs.getInt("MHS_ID"));
					mhs.setKode(rs.getString("MHS_KODE"));
					mhs.setNama(rs.getString("MHS_NAMA"));
					mhs.setAlamat(rs.getString("MHS_ALAMAT"));
					
					result.add(mhs);
				} while (rs.next());
			}
		} finally {
			try {
				rs.close();
			} catch (Exception ignored) {}
			try {
				ps.close();
			} catch (Exception ignored) {}
		}
		
		return result;	}
	
	
	
}
