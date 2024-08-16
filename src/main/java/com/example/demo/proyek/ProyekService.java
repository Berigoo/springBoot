package com.example.demo.proyek;

import com.example.demo.DTOs.ProyekAndLokasi;
import com.example.demo.DTOs.ProyekAndLokasis;
import com.example.demo.exceptions.ResourceNotFound;
import com.example.demo.helper.Mapper;
import com.example.demo.lokasi.Lokasi;
import com.example.demo.lokasi.LokasiRepository;
import com.example.demo.proyek_lokasi.ProyekLokasi;
import com.example.demo.proyek_lokasi.ProyekLokasiRepository;
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
    @Autowired
    private LokasiRepository lokasiRepository;
    @Autowired
    private ProyekLokasiRepository proyekLokasiRepository;
    @Autowired
    private Mapper map;
    //@Autowired
   // private ProyekLokasiRepository bridgeRepository;

    public ProyekAndLokasis getProyek(Long id){
        Proyek proyek = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Proyek with id: " + id + " not found!"));
        return map.toProyekAndLokasis(proyek);
    }

    public List<ProyekAndLokasis> getAllProyek(){
        List<Proyek> proyeks = repository.findAll();
        return map.toProyekAndLokasis(proyeks);
    }

    public ProyekAndLokasi addNew(Proyek proyek, Long lokasiId){
        Optional<Lokasi> lokasi = lokasiRepository.findById(lokasiId);

        ProyekLokasi proyekLokasi = new ProyekLokasi();
        proyekLokasi.setProyek(proyek);
        proyekLokasi.setLokasi(lokasi.get());
        proyekLokasiRepository.save(proyekLokasi);


        return map.map(proyek, lokasi.get());
    }

    public ProyekDTO update(Proyek proyek, int id){
        Optional<Proyek> entity = repository.findById((long)id);
        entity.get().setNamaProyek(proyek.getNamaProyek());
        entity.get().setClient(proyek.getClient());
        entity.get().setTanggalMulai(proyek.getTanggalMulai());
        entity.get().setTanggalSelesai(proyek.getTanggalSelesai());
        entity.get().setKeterangan(proyek.getKeterangan());
        entity.get().setPimpinanProyek(proyek.getPimpinanProyek());

        return map.map(entity.get());
    }

    public boolean delete(int id){
        Optional<Proyek> proyek = repository.findById((long) id);
        if(!proyek.isPresent()) return false;

        repository.delete(proyek.get());
        return true;
    }

}
