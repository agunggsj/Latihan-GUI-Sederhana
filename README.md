# Playlist Sederhana

> Aplikasi ini hanya menampilkan nama lagu yang sedang "diputar". Tidak ada pemutaran audio sungguhan.

## Fitur

- Menambah lagu (judul dan artis) ke dalam daftar
- Memutar lagu yang dipilih, nama lagu tampil di bagian bawah jendela
- Menghapus lagu yang dipilih
- Mengosongkan seluruh playlist
- Klik dua kali pada lagu untuk langsung memutarnya
- Tekan Enter di kolom artis untuk menambah lagu dengan cepat

## Cara Menjalankan

1. Simpan file `PlaylistSederhana.java` di satu folder.
2. Buka terminal atau command prompt di folder tersebut.
3. Kompilasi dan jalankan:

```
javac PlaylistSederhana.java
java PlaylistSederhana
```

## Cara Menggunakan

| Aksi | Cara |
|---|---|
| Tambah lagu | Isi **Judul** dan **Artis**, lalu klik **Tambah** (atau tekan Enter di kolom Artis) |
| Putar lagu | Pilih lagu di daftar, lalu klik **Putar** atau klik dua kali pada lagunya |
| Hapus lagu | Pilih lagu di daftar, lalu klik **Hapus** |
| Kosongkan playlist | Klik **Kosongkan** |

Jika judul atau artis kosong saat menambah lagu, atau tidak ada lagu yang dipilih saat memutar atau menghapus, aplikasi akan menampilkan pesan peringatan.

## Struktur Komponen GUI

| Pedoman | Yang dipakai |
|---|---|
| Top-level Container Class | `JFrame` |
| Intermediate Container Class | `JPanel`, `JScrollPane` |
| Atomic Component Class | `JLabel`, `JTextField`, `JButton`, `JList` |
| Layout Classes (2 jenis) | `BorderLayout`, `FlowLayout` |
| Event Listener (interface) | `ActionListener` dengan override `actionPerformed()` |
| Event Listener (adapter) | `MouseAdapter` dengan override `mouseClicked()` |

### Susunan Layout

```
JFrame (BorderLayout)
├── NORTH   : JPanel (FlowLayout)   -> input judul, artis, tombol Tambah
├── CENTER  : JScrollPane           -> JList daftar lagu
└── SOUTH   : JPanel (BorderLayout)
    ├── CENTER : JPanel (FlowLayout) -> tombol Putar, Hapus, Kosongkan
    └── SOUTH  : JLabel              -> info lagu yang sedang diputar
```
