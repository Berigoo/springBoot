package com.example.demo.proyek;

import com.example.demo.DTOs.ProyekAndLokasi;
import com.example.demo.DTOs.ProyekAndLokasis;
import com.example.demo.DTOs.WithInfo;
import com.example.demo.RequestBody.ProyekPost;
import com.example.demo.RequestBody.ProyekUpdate;
import com.example.demo.lokasi.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/proyek")
public class ProyekController {

    @Autowired
    private ProyekService service;
    @Autowired
    private ProyekRepository repository;
    @Autowired
    private LokasiRepository lokasiRepository;

    @GetMapping("{id}")
    public ResponseEntity<ProyekAndLokasis> getProyek(@PathVariable("id") Long id){
        ProyekAndLokasis dto = service.getProyek(id);
        return new ResponseEntity<ProyekAndLokasis>(dto,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<ProyekAndLokasis>> getAllProyek(){
        return new ResponseEntity<List<ProyekAndLokasis>>(service.getAllProyek(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<WithInfo<ProyekAndLokasi>> addNew(@RequestBody ProyekPost req){
        WithInfo<ProyekAndLokasi> dto = new WithInfo<>();
        Proyek proyek = new Proyek();
        proyek.setNamaProyek(req.getNamaProyek());
        proyek.setClient(req.getClient());
        proyek.setKeterangan(req.getKeterangan());
        proyek.setTanggalMulai(req.getTanggalMulai());
        proyek.setTanggalSelesai(req.getTanggalSelesai());
        proyek.setPimpinanProyek(req.getPimpinanProyek());
        proyek = repository.save(proyek);

        if(!lokasiRepository.existsById(req.getLokasiId())) {
            dto.setInfo("Lokasi Id Not Found");
            dto.setData(null);
            return new ResponseEntity<WithInfo<ProyekAndLokasi>>(dto, HttpStatus.NOT_FOUND);
        }

        dto.setInfo("Row Created!");
        dto.setData(service.addNew(proyek, req.getLokasiId()));
        return new ResponseEntity<WithInfo<ProyekAndLokasi>>(dto, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<WithInfo<ProyekDTO>> update(@RequestBody ProyekUpdate proyek, @PathVariable("id") Long id){
        WithInfo<ProyekDTO> dto = new WithInfo<>();
        if(!repository.existsById((long) id)) {
            dto.setInfo("Row Not Exist!");
            dto.setData(null);
            return new ResponseEntity<WithInfo<ProyekDTO>>(dto, HttpStatus.NOT_FOUND);
        }

        dto.setInfo("Row Updated!");
        dto.setData(service.update(proyek, proyek.getLokasis(), Math.toIntExact(id)));
        if(dto.getData() != null) {
            return new ResponseEntity<WithInfo<ProyekDTO>>(dto, HttpStatus.OK);
        }else{
            dto.setInfo("Row Failed to Update!");
            return new ResponseEntity<WithInfo<ProyekDTO>>(dto, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        if(service.delete(id))
            return new ResponseEntity<String>("Row Deleted!", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Row Not Exist!", HttpStatus.NOT_FOUND);
    }
}
