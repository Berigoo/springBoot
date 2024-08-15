package com.example.demo.proyek;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "proyek")
public class Proyek {
    @Id
    private int id;

    @Column(name = "nama_proyek", nullable = false)
    private String NamaProyek;

    @Column(name = "client", nullable = false)
    private String Client;

    @Column(name = "tgl_mulai", nullable = false, columnDefinition = "DATETIME")
    private Date TanggalMulai;

    @Column(name = "tgl_selesai", nullable = false, columnDefinition = "DATETIME")
    private Date TanggalSelesai;

    @Column(name = "pimpinan_proyek", nullable = false)
    private String PimpinanProyek;

    @Column(name = "keterangan", columnDefinition = "TEXT")
    private String Keterangan;

    @Column(name = "created_at")
    private Timestamp CreatedAt;

    //
    //
    //

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