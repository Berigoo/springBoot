package com.example.demo.proyek;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "proyek")
public class Proyek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nama_proyek", nullable = false)
    private String NamaProyek;

    @Column(name = "client", nullable = false)
    private String Client;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name = "tgl_mulai", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime TanggalMulai;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name = "tgl_selesai", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime TanggalSelesai;

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

    public LocalDateTime getTanggalMulai () {
        return TanggalMulai;
    }

    public void setTanggalMulai (LocalDateTime tanggalMulai) {
        TanggalMulai = tanggalMulai;
    }

    public LocalDateTime getTanggalSelesai () {
        return TanggalSelesai;
    }

    public void setTanggalSelesai (LocalDateTime tanggalSelesai) {
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