package com.example.demo.proyek_lokasi;

import com.example.demo.lokasi.Lokasi;
import com.example.demo.proyek.Proyek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProyekLokasiRepository extends JpaRepository<ProyekLokasi, Long> {
    @Query("FROM ProyekLokasi WHERE proyek = ?1")
    List<ProyekLokasi> findByProyek(Proyek proyek);

    @Query("From ProyekLokasi WHERE proyek = ?1 AND lokasi = ?2")
    ProyekLokasi findByProyekAndLokasi(Proyek proyek, Lokasi lokasi);
}
