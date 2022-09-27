package com.prodemy.bio;

public class Mahasiswa {
    private String kode;
    private String nama;
    private String alamat;
    
    public Mahasiswa() {
    }

    public Mahasiswa(String kode, String nama, String alamat) {
        this.kode = kode;
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", kode='" + kode + '\'' +
                ", nama=" + nama +
                ", alamat=" + alamat +
                '}';
    }
}
