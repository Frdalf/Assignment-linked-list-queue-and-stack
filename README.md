# Sistem Antrian Rumah Sakit (RS DIGITAL)

Sistem manajemen antrian rumah sakit sederhana yang dibangun dengan Java untuk mendemonstrasikan implementasi dan perbedaan penggunaan tiga struktur data fundamental: **Linked List**, **Queue**, dan **Stack**.

## 🚀 Fitur Utama

- **Pendaftaran Pasien Baru**: Menambahkan pasien ke database master dan antrian aktif sekaligus.
- **Panggilan Pasien (FIFO)**: Memanggil pasien berikutnya sesuai urutan pendaftaran menggunakan prinsip *First-In-First-Out*.
- **Undo Panggilan (LIFO)**: Membatalkan panggilan terakhir dan mengembalikan pasien ke antrian menggunakan prinsip *Last-In-First-Out*.
- **Manajemen Data Master**: Melihat semua daftar pasien, mencari pasien berdasarkan nama, atau menghapus data pasien tertentu.
- **Visualisasi Struktur Data**: Tampilan konsol yang informatif untuk memantau status Queue (Antrian) dan Stack (Riwayat).

## 📊 Implementasi Struktur Data

Proyek ini menggunakan implementasi struktur data kustom (bukan dari Java Collections Framework) untuk tujuan pembelajaran:

1.  **Linked List (`LinkedListPasien`)**: Berfungsi sebagai penyimpanan data utama (Master Data). Memungkinkan akses dan manipulasi data secara fleksibel seperti fitur pencarian dan penghapusan node.
2.  **Queue (`QueueAntrian`)**: Mengelola antrian pasien yang menunggu. Memastikan pasien dilayani tepat waktu sesuai urutan kedatangan.
3.  **Stack (`StackRiwayat`)**: Menyimpan riwayat panggilan pasien terbaru. Memungkinkan fitur *Undo* dengan mengambil data paling atas (panggilan terakhir).

## 🛠️ Prasyarat

- Java Development Kit (JDK) 8 atau versi di atasnya.

## 💻 Cara Menjalankan

1.  Clone repository ini:
    ```bash
    git clone https://github.com/username/repository-name.git
    ```
2.  Masuk ke direktori proyek:
    ```bash
    cd "Tugas 1 linked list stack and queue"
    ```
3.  Kompilasi file Java:
    ```bash
    javac src/*.java -d out
    ```
4.  Jalankan program:
    ```bash
    java -cp out Main
    ```

## 📝 Tampilan Menu

```text
┌─────────────────────────────────────────┐
│  Antrian: 4    |  Riwayat: 0    |  Total Pasien: 4   │
├─────────────────────────────────────────┤
│  [1] Daftar Pasien Baru                 │
│  [2] Panggil Pasien Berikutnya          │
│  [3] Lihat Antrian Saat Ini (Queue)     │
│  [4] Lihat Semua Pasien (LinkedList)    │
│  [5] Lihat Riwayat Tindakan (Stack)     │
│  [6] Undo Panggilan Terakhir            │
│  [7] Cari Pasien                        │
│  [8] Hapus Pasien dari Data             │
│  [0] Keluar                             │
└─────────────────────────────────────────┘
```

---
*Proyek ini dibuat untuk tugas mata kuliah Struktur Data - Semester 4.*
