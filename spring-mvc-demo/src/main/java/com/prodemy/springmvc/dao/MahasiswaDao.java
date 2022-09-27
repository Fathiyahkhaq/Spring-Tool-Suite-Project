package com.prodemy.springmvc.dao;

import java.util.List;

import com.prodemy.springmvc.controller.Mahasiswa;

public interface MahasiswaDao {
	public Mahasiswa findById(int id) throws Exception;
	public void deleteById(int id) throws Exception;
	public void insert(Mahasiswa mhs) throws Exception;
	public void update(Mahasiswa mhs) throws Exception;
	public List<Mahasiswa> findAll() throws Exception;

}
