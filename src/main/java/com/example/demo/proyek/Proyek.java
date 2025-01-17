package com.example.demo.proyek;

import com.example.demo.proyek_lokasi.ProyekLokasi;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

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

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp CreatedAt;

    @OneToMany(mappedBy = "proyek")
    private List<ProyekLokasi> proyekLokasis;


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

    public List<ProyekLokasi> getProyekLokasis () {
        return proyekLokasis;
    }

    public void setProyekLokasis (List<ProyekLokasi> proyekLokasis) {
        this.proyekLokasis = proyekLokasis;
    }
}