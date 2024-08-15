package com.example.demo.proyek;

import java.sql.Date;
import java.sql.Timestamp;

public class ProyekDTO {
    private int id;
    private String NamaProyek;
    private String Client;
    private Date TanggalMulai;
    private Date TanggalSelesai;
    private String PimpinanProyek;
    private String Keterangan;
    private Timestamp CreatedAt;


    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getNamaProyek () {
        return NamaProyek;
    }

    public void setNamaProyek (String namaProyek) {
        NamaProyek = namaProyek;
    }

    public String getClient () {
        return Client;
    }

    public void setClient (String client) {
        Client = client;
    }

    public Date getTanggalMulai () {
        return TanggalMulai;
    }

    public void setTanggalMulai (Date tanggalMulai) {
        TanggalMulai = tanggalMulai;
    }

    public Date getTanggalSelesai () {
        return TanggalSelesai;
    }

    public void setTanggalSelesai (Date tanggalSelesai) {
        TanggalSelesai = tanggalSelesai;
    }

    public String getPimpinanProyek () {
        return PimpinanProyek;
    }

    public void setPimpinanProyek (String pimpinanProyek) {
        PimpinanProyek = pimpinanProyek;
    }

    public String getKeterangan () {
        return Keterangan;
    }

    public void setKeterangan (String keterangan) {
        Keterangan = keterangan;
    }

    public Timestamp getCreatedAt () {
        return CreatedAt;
    }

    public void setCreatedAt (Timestamp createdAt) {
        CreatedAt = createdAt;
    }
}
