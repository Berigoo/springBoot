package com.example.demo.lokasi;

import com.example.demo.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LokasiService {

    @Autowired
    private LokasiRepository repository;

    public LokasiDTO getLokasi(Long id){
        Lokasi lokasi = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Lokasi with id: " + id + " not found!"));
        return map(lokasi);
    }

    public List<LokasiDTO> getAllLokasi(){
        List<Lokasi> lokasis = repository.findAll();
        return maps(lokasis);
    }

    public LokasiDTO addNew(Lokasi lokasi){
        repository.save(lokasi);

        return map(lokasi);
    }

    public LokasiDTO update(Lokasi lokasi, int id){
        Optional<Lokasi> entity = repository.findById((long)id);
        entity.get().setNamaLokasi(lokasi.getNamaLokasi());
        entity.get().setNegara(lokasi.getNegara());
        entity.get().setProvinsi(lokasi.getProvinsi());
        entity.get().setKota(lokasi.getKota());

        repository.save(entity.get());
        return map(entity.get());
    }

    public boolean delete(int id){
        Optional<Lokasi> lokasi = repository.findById((long) id);
        if(!lokasi.isPresent()) return false;

        repository.delete(lokasi.get());
        return true;
    }

    private LokasiDTO map(Lokasi lokasi){
        LokasiDTO dto = new LokasiDTO();
        dto.setId(lokasi.getId());
        dto.setNamaLokasi(lokasi.getNamaLokasi());
        dto.setNegara(lokasi.getNegara());
        dto.setProvinsi(lokasi.getProvinsi());
        dto.setKota(lokasi.getKota());
        dto.setCreatedAt(lokasi.getCreatedAt());

        return dto;
    }

    private List<LokasiDTO> maps(List<Lokasi> lokasis){
        List<LokasiDTO> dtos = new ArrayList<>();
        for (int i = 0; i < lokasis.size(); i++) {
            dtos.add(map(lokasis.get(i)));
        }
        return dtos;
    }
}
