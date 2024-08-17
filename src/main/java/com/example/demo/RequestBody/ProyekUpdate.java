package com.example.demo.RequestBody;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class ProyekUpdate {
    private String NamaProyek;

    private String Client;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime TanggalMulai;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime TanggalSelesai;

    private String PimpinanProyek;

    private String Keterangan;

    private List<Long> lokasis;


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

    public List<Long> getLokasis () {
        return lokasis;
    }

    public void setLokasis (List<Long> lokasis) {
        this.lokasis = lokasis;
    }
}
