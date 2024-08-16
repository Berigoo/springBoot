package com.example.demo.lokasi;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class LokasiDTO {
    private int id;
    private String NamaLokasi;
    private String Negara;
    private String Provinsi;
    private String Kota;
    private Timestamp CreatedAt;


    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getNamaLokasi () {
        return NamaLokasi;
    }

    public void setNamaLokasi (String namaLokasi) {
        NamaLokasi = namaLokasi;
    }

    public String getNegara () {
        return Negara;
    }

    public void setNegara (String negara) {
        Negara = negara;
    }

    public String getProvinsi () {
        return Provinsi;
    }

    public void setProvinsi (String provinsi) {
        Provinsi = provinsi;
    }

    public String getKota () {
        return Kota;
    }

    public void setKota (String kota) {
        Kota = kota;
    }

    public Timestamp getCreatedAt () {
        return CreatedAt;
    }

    public void setCreatedAt (Timestamp createdAt) {
        CreatedAt = createdAt;
    }
}
