package com.example.demo.proyek;

import com.example.demo.DTOs.WithInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyek")
public class ProyekController {

    @Autowired
    private ProyekService service;
    @Autowired
    private ProyekRepository repository;

    @GetMapping("{id}")
    public ResponseEntity<ProyekDTO> getProyek(@PathVariable("id") Long id){
        ProyekDTO dto = service.getProyek(id);
        return new ResponseEntity<ProyekDTO>(dto,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<ProyekDTO>> getAllProyek(){
        return new ResponseEntity<List<ProyekDTO>>(service.getAllProyek(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<WithInfo<ProyekDTO>> addNew(@RequestBody Proyek proyek){
        WithInfo<ProyekDTO> dto = new WithInfo<>();
        if(repository.existsById((long) proyek.getId())) {
            dto.setInfo("Row Exists!");
            dto.setData(null);
            return new ResponseEntity<WithInfo<ProyekDTO>>(dto, HttpStatus.BAD_REQUEST);
        }

        dto.setInfo("Row Created!");
        dto.setData(service.addNew(proyek));
        return new ResponseEntity<WithInfo<ProyekDTO>>(dto, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<WithInfo<ProyekDTO>> update(@RequestBody Proyek proyek, @PathVariable("id") Long id){
        WithInfo<ProyekDTO> dto = new WithInfo<>();
        if(repository.existsById((long) proyek.getId())) {
            dto.setInfo("Row Not Exist!");
            dto.setData(null);
            return new ResponseEntity<WithInfo<ProyekDTO>>(dto, HttpStatus.NOT_FOUND);
        }

        dto.setInfo("Row Updated!");
        dto.setData(service.update(proyek, Math.toIntExact(id)));
        return new ResponseEntity<WithInfo<ProyekDTO>>(dto, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        if(service.delete(id))
            return new ResponseEntity<String>("Row Deleted!", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Row Not Exist!", HttpStatus.NOT_FOUND);
    }
}
