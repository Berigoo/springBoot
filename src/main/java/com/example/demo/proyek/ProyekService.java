package com.example.demo.proyek;

import com.example.demo.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyekService {

    @Autowired
    private ProyekRepository repository;

    public ProyekDTO getProyek(Long id){
        Proyek proyek = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Proyek with id: " + id + " not found!"));
        return map(proyek);
    }


    private ProyekDTO map(Proyek proyek){
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
}
