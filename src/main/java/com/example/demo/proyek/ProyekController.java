package com.example.demo.proyek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyek")
public class ProyekController {

    @Autowired
    private ProyekService service;
    @GetMapping("{id}")
    public ResponseEntity<ProyekDTO> getProyek(@PathVariable("id") Long id){
        ProyekDTO dto = service.getProyek(id);
        return new ResponseEntity<ProyekDTO>(dto,HttpStatus.OK);
    }

}
