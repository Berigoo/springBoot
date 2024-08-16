package com.example.demo.DTOs;

import com.example.demo.lokasi.LokasiDTO;
import com.example.demo.proyek.ProyekDTO;

import java.util.List;

public class ProyekAndLokasis {
    private ProyekDTO proyek;
    private List<LokasiDTO> lokasis;


    public ProyekDTO getProyek () {
        return proyek;
    }

    public void setProyek (ProyekDTO proyek) {
        this.proyek = proyek;
    }

    public List<LokasiDTO> getLokasis () {
        return lokasis;
    }

    public void setLokasis (List<LokasiDTO> lokasis) {
        this.lokasis = lokasis;
    }
}
