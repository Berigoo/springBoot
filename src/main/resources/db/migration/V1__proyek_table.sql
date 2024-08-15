CREATE TABLE proyek(
    id INT PRIMARY KEY,
    nama_proyek VARCHAR(255) NOT NULL,
    client VARCHAR(255) NOT NULL ,
    tgl_mulai DATETIME NOT NULL ,
    tgl_selesai DATETIME NOT NULL ,
    pimpinan_proyek VARCHAR(255) NOT NULL ,
    keterangan TEXT,
    created_at TIMESTAMP NOT NULL
)