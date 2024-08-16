package com.example.demo.helper;

import com.example.demo.DTOs.ProyekAndLokasi;
import com.example.demo.DTOs.ProyekAndLokasis;
import com.example.demo.lokasi.Lokasi;
import com.example.demo.lokasi.LokasiDTO;
import com.example.demo.proyek.Proyek;
import com.example.demo.proyek.ProyekDTO;
import com.example.demo.proyek_lokasi.ProyekLokasi;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mapper {
    public ProyekDTO map (Proyek proyek) {
        ProyekDTO dto = new ProyekDTO();
        dto.setId(proyek.getId());
        dto.setNamaProyek(proyek.getNamaProyek());
        dto.setClient(proyek.getClient());
        dto.setTanggalMulai(proyek.getTanggalMulai());
        dto.setTanggalSelesai(proyek.getTanggalSelesai());
        dto.setPimpinanProyek(proyek.getPimpinanProyek());
        dto.setKeterangan(proyek.getKeterangan());
        dto.setCreatedAt(proyek.getCreatedAt());

        return dto;
    }

    public List<ProyekDTO> map (List<Proyek> proyeks) {
        List<ProyekDTO> dtos = new ArrayList<>();
        for (int i = 0; i < proyeks.size(); i++) {
            dtos.add(map(proyeks.get(i)));
        }
        return dtos;
    }
    public LokasiDTO map(Lokasi lokasi){
        LokasiDTO dto = new LokasiDTO();
        dto.setId(lokasi.getId());
        dto.setNamaLokasi(lokasi.getNamaLokasi());
        dto.setNegara(lokasi.getNegara());
        dto.setProvinsi(lokasi.getProvinsi());
        dto.setKota(lokasi.getKota());
        dto.setCreatedAt(lokasi.getCreatedAt());

        return dto;
    }

    public List<LokasiDTO> maps(List<Lokasi> lokasis){
        List<LokasiDTO> dtos = new ArrayList<>();
        for (int i = 0; i < lokasis.size(); i++) {
            dtos.add(map(lokasis.get(i)));
        }
        return dtos;
    }

    public ProyekAndLokasi map(Proyek proyek, Lokasi lokasi){
        ProyekAndLokasi dto = new ProyekAndLokasi();
        dto.setLokasi(map(lokasi));
        dto.setProyek(map(proyek));

        return dto;
    }

    public List<LokasiDTO> toLokasiDtos(List<ProyekLokasi> proyekLokasis){
        List<LokasiDTO> dtos = new ArrayList<>();
        for (int i = 0; i < proyekLokasis.size(); i++) {
            dtos.add(map(proyekLokasis.get(i).getLokasi()));
        }
        return dtos;
    }
    public List<ProyekAndLokasis> toProyekAndLokasis(List<Proyek> proyeks){
        List<ProyekAndLokasis> dtos = new ArrayList<>();
        for (int i = 0; i < proyeks.size(); i++) {
            ProyekAndLokasis dto = new ProyekAndLokasis();
            Proyek proyek = proyeks.get(i);
            List<LokasiDTO> lokasis = toLokasiDtos(proyek.getProyekLokasis());
            ProyekDTO proyekDTO = map(proyek);

            dto.setProyek(proyekDTO);
            dto.setLokasis(lokasis);
            dtos.add(dto);
        }
        return dtos;
    }

    public ProyekAndLokasis toProyekAndLokasis(Proyek proyek){
        ProyekAndLokasis dto = new ProyekAndLokasis();
        List<LokasiDTO> lokasis = toLokasiDtos(proyek.getProyekLokasis());
        ProyekDTO proyekDTO = map(proyek);

        dto.setProyek(proyekDTO);
        dto.setLokasis(lokasis);
        return dto;
    }
}
