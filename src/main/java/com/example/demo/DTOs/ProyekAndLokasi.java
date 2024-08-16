package com.example.demo.DTOs;

import com.example.demo.lokasi.LokasiDTO;
import com.example.demo.proyek.ProyekDTO;

public class ProyekAndLokasi {
    private ProyekDTO proyek;
    private LokasiDTO lokasi;


    public ProyekDTO getProyek () {
        return proyek;
    }

    public void setProyek (ProyekDTO proyek) {
        this.proyek = proyek;
    }

    public LokasiDTO getLokasi () {
        return lokasi;
    }

    public void setLokasi (LokasiDTO lokasi) {
        this.lokasi = lokasi;
    }
}
