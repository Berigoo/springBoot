package com.example.demo.proyek;

import com.example.demo.exceptions.ResourceNotFound;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProyekService {

    @Autowired
    private ProyekRepository repository;

    public ProyekDTO getProyek(Long id){
        Proyek proyek = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Proyek with id: " + id + " not found!"));
        return map(proyek);
    }

    public List<ProyekDTO> getAllProyek(){
        List<Proyek> proyeks = repository.findAll();
        return maps(proyeks);
    }

    public ProyekDTO addNew(Proyek proyek){
        repository.save(proyek);

        return map(proyek);
    }

    public ProyekDTO update(Proyek proyek, int id){
        Optional<Proyek> entity = repository.findById((long)id);
        entity.get().setNamaProyek(proyek.getNamaProyek());
        entity.get().setClient(proyek.getClient());
        entity.get().setTanggalMulai(proyek.getTanggalMulai());
        entity.get().setTanggalSelesai(proyek.getTanggalSelesai());
        entity.get().setKeterangan(proyek.getKeterangan());
        entity.get().setPimpinanProyek(proyek.getPimpinanProyek());

        repository.save(entity.get());
        return map(entity.get());
    }

    public boolean delete(int id){
        Optional<Proyek> proyek = repository.findById((long) id);
        if(!proyek.isPresent()) return false;

        repository.delete(proyek.get());
        return true;
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

    private List<ProyekDTO> maps(List<Proyek> proyeks){
        List<ProyekDTO> dtos = new ArrayList<>();
        for (int i = 0; i < proyeks.size(); i++) {
            dtos.add(map(proyeks.get(i)));
        }
        return dtos;
    }
}
