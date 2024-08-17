package com.example.demo.lokasi;

import com.example.demo.DTOs.WithInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lokasi")
public class LokasiController {

    @Autowired
    private LokasiService service;
    @Autowired
    private LokasiRepository repository;

    @GetMapping("{id}")
    public ResponseEntity<LokasiDTO> getLokasi(@PathVariable("id") Long id){
        LokasiDTO dto = service.getLokasi(id);
        return new ResponseEntity<LokasiDTO>(dto,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<LokasiDTO>> getAllLokasi(){
        return new ResponseEntity<List<LokasiDTO>>(service.getAllLokasi(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<WithInfo<LokasiDTO>> addNew(@RequestBody Lokasi lokasi){
        WithInfo<LokasiDTO> dto = new WithInfo<>();
        if(repository.existsById((long) lokasi.getId())) {
            dto.setInfo("Row Exists!");
            dto.setData(null);
            return new ResponseEntity<WithInfo<LokasiDTO>>(dto, HttpStatus.BAD_REQUEST);
        }

        dto.setInfo("Row Created!");
        dto.setData(service.addNew(lokasi));
        return new ResponseEntity<WithInfo<LokasiDTO>>(dto, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<WithInfo<LokasiDTO>> update(@RequestBody Lokasi lokasi, @PathVariable("id") Long id){
        WithInfo<LokasiDTO> dto = new WithInfo<>();
        if(!repository.existsById((long) lokasi.getId())) {
            dto.setInfo("Row Not Exist!");
            dto.setData(null);
            return new ResponseEntity<WithInfo<LokasiDTO>>(dto, HttpStatus.NOT_FOUND);
        }

        dto.setInfo("Row Updated!");
        dto.setData(service.update(lokasi, Math.toIntExact(id)));
        return new ResponseEntity<WithInfo<LokasiDTO>>(dto, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        if(service.delete(id))
            return new ResponseEntity<String>("Row Deleted!", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Row Not Exist!", HttpStatus.NOT_FOUND);
    }
}
