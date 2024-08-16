package com.example.demo.proyek_lokasi;

import com.example.demo.lokasi.Lokasi;
import com.example.demo.proyek.Proyek;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "proyek_lokasi")
public class ProyekLokasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "proyek_id")
    private Proyek proyek;

    @ManyToOne
    @JoinColumn(name = "lokasi_id")
    private Lokasi lokasi;


    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public Proyek getProyek () {
        return proyek;
    }

    public void setProyek (Proyek proyek) {
        this.proyek = proyek;
    }

    public Lokasi getLokasi () {
        return lokasi;
    }

    public void setLokasi (Lokasi lokasi) {
        this.lokasi = lokasi;
    }
}
