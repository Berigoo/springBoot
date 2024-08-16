CREATE TABLE proyek_lokasi(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    proyek_id INT,
    lokasi_id INT
);

ALTER TABLE proyek_lokasi ADD FOREIGN KEY (proyek_id) REFERENCES proyek(id) ON DELETE CASCADE  ON UPDATE CASCADE;
ALTER TABLE proyek_lokasi ADD FOREIGN KEY (lokasi_id) REFERENCES lokasi(id) ON DELETE CASCADE ON UPDATE CASCADE;


