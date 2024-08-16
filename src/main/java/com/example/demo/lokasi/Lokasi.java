package com.example.demo.lokasi;

import com.example.demo.proyek.Proyek;
import com.example.demo.proyek_lokasi.ProyekLokasi;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "lokasi")
public class Lokasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nama_lokasi", nullable = false)
    private String NamaLokasi;

    @Column(name = "negara", nullable = false)
    private String Negara;

    @Column(name = "provinsi", nullable = false)
    private String Provinsi;

    @Column(name = "kota")
    private String Kota;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp CreatedAt;

    @OneToMany(mappedBy = "lokasi", cascade = CascadeType.ALL, orphanRemoval = true)
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