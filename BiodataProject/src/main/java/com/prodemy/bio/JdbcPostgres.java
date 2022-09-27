package com.prodemy.bio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JdbcPostgres {

	public static void main(String[] args) {
		List<Mahasiswa> result = new ArrayList<>();

        String SQL_INSERT = "INSERT INTO \"MAHASISWA\""+
        		"VALUES (nextval('seq_mhs'),?,?,?) ";
		
	
	try (Connection conn = DriverManager.getConnection(
			"jdbc:postgresql://localhost:5432/Universitas","postgres","postgres");
			PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)){
		
		

	    ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            String kode = resultSet.getString("KODE");
            String nama = resultSet.getString("NAMA");
            String alamat = resultSet.getString("ALAMAT");

            Mahasiswa obj = new Mahasiswa();
            obj.setKode(kode);
            obj.setNama(nama);
            obj.setAlamat(alamat);

            result.add(obj);

        }
        result.forEach(x -> System.out.println(x));
		//INSERT INTO "MAHASISWA"
		//VALUES (nextval('seq_mhs'), '1005','nama_example','alamat_example')
	} catch (SQLException e) {
		System.err.format("SQL State: %s\n%s", e.getSQLState(),e.getMessage());
	} catch (Exception e) {
		e.printStackTrace();
	}

 }
}