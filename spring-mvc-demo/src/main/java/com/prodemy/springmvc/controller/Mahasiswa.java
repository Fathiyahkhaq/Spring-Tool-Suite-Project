package com.prodemy.springmvc.controller;

public class Mahasiswa {
	private int id;
    private String kode;
    private String nama;
    private String alamat;
 
    // Getter and setter methods
 
    // Getter
    public String getAlamat() { return alamat; }
 
    // Setter
    public void setAlamat(String alamat)
    {
        this.alamat = alamat;
    }

 
    // Getter
    public int getId() { return id; }
 
    // Setter
    public void setId(int id) { this.id = id; }
 
    // Getter
    public String getKode() { return kode; }
 
    // Setter
    public void setKode(String kode) { this.kode = kode; }
 
    // Getter
    public String getNama() { return nama; }
 
    // Setter
    public void setNama(String nama)
    {
        this.nama = nama;
    }

}
