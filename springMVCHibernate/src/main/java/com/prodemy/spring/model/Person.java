package com.prodemy.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Mahasiswa")
public class Person {

	@Id
	@Column(name="ID")
	@SequenceGenerator(name="pk_mahasiswa",sequenceName="seq_mhs", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_mahasiswa")
	private int id;
	
	@Column(name="MHS_NIM")
	private String nim;
	
	@Column(name="MHS_NAMA")
	private String nama;
	
	@Column(name="MHS_EMAIL")
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}
	
	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString(){
		return "id="+id+", nim="+nim+", name="+nama+", email="+email;
	}
}
