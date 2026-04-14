import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    static LinkedListPasien daftarPasien = new LinkedListPasien();
    static QueueAntrian antrian = new QueueAntrian();
    static StackRiwayat riwayat = new StackRiwayat();
    static Scanner scanner = new Scanner(System.in);
    static int idCounter = 1;
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║     SISTEM ANTRIAN RUMAH SAKIT - RS DIGITAL          ║");
        System.out.println("║     Implementasi: LinkedList + Queue + Stack         ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        // Data Awal untuk Demo
        demoDataAwal();

        boolean running = true;
        while (running) {
            tampilkanMenu();
            int pilihan = inputAngka("Pilih menu: ");

            switch (pilihan) {
                case 1 -> daftarPasienBaru();
                case 2 -> panggilPasien();
                case 3 -> lihatAntrian();
                case 4 -> lihatSemuaPasien();
                case 5 -> lihatRiwayat();
                case 6 -> undoPanggilan();
                case 7 -> cariPasien();
                case 8 -> hapusPasien();
                case 0 -> {
                    System.out.println("\n  Terima kasih! Program selesai.");
                    running = false;
                }
                default -> System.out.println("\n  [!] Pilihan tidak valid!");
            }

            if (running) {
                System.out.print("\n  Tekan ENTER untuk lanjut...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    static void tampilkanMenu() {
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.printf( "│  Antrian: %-3d  |  Riwayat: %-3d  |  Total Pasien: %-3d    │%n",
                antrian.getSize(), riwayat.getSize(), daftarPasien.getSize());
        System.out.println("├─────────────────────────────────────────────────────────┤");
        System.out.println("│  [1] Daftar Pasien Baru                                 │");
        System.out.println("│  [2] Panggil Pasien Berikutnya                          │");
        System.out.println("│  [3] Lihat Antrian Saat Ini (Queue)                     │");
        System.out.println("│  [4] Lihat Semua Pasien (LinkedList)                    │");
        System.out.println("│  [5] Lihat Riwayat Tindakan (Stack)                     │");
        System.out.println("│  [6] Undo Panggilan Terakhir                            │");
        System.out.println("│  [7] Cari Pasien                                        │");
        System.out.println("│  [8] Hapus Pasien dari Data                             │");
        System.out.println("│  [0] Keluar                                             │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
    }

    // ─── FITUR 1: Daftar Pasien Baru ───────────────────────────────
    static void daftarPasienBaru() {
        System.out.println("\n  ══ PENDAFTARAN PASIEN BARU ══");
        System.out.print("  Nama     : ");
        String nama = scanner.nextLine().trim();
        if (nama.isEmpty()) { System.out.println("  [!] Nama tidak boleh kosong!"); return; }

        int umur = inputAngka("  Umur     : ");
        System.out.print("  Keluhan  : ");
        String keluhan = scanner.nextLine().trim();
        if (keluhan.isEmpty()) { System.out.println("  [!] Keluhan tidak boleh kosong!"); return; }

        String waktu = LocalDateTime.now().format(dtf);
        Pasien pasienBaru = new Pasien(idCounter++, nama, umur, keluhan, waktu);

        // Simpan ke LinkedList (data master)
        daftarPasien.tambah(pasienBaru);
        // Masukkan ke Queue (antrian)
        antrian.enqueue(pasienBaru);

        System.out.println("\n  ✓ Pasien berhasil didaftarkan!");
        System.out.println("  → Ditambahkan ke LinkedList (data master)");
        System.out.println("  → Dimasukkan ke Queue (antrian)");
        System.out.println("  → Nomor antrian: " + antrian.getSize());
    }

    // ─── FITUR 2: Panggil Pasien (Dequeue) ─────────────────────────
    static void panggilPasien() {
        System.out.println("\n  ══ PANGGIL PASIEN ══");
        if (antrian.isEmpty()) {
            System.out.println("  [!] Antrian kosong, tidak ada pasien yang menunggu.");
            return;
        }

        Pasien dipanggil = antrian.dequeue(); // Ambil dari depan Queue (FIFO)
        riwayat.push(dipanggil);             // Simpan ke Stack (LIFO)

        System.out.println("\n  🔔 Memanggil pasien...");
        System.out.println("  ─────────────────────────────────────────────");
        System.out.println("  " + dipanggil);
        System.out.println("  ─────────────────────────────────────────────");
        System.out.println("  → Didequeue dari Queue (FIFO - yang pertama daftar, pertama dipanggil)");
        System.out.println("  → Dipush ke Stack riwayat (bisa di-undo)");

        if (!antrian.isEmpty()) {
            System.out.println("  → Pasien berikutnya: " + antrian.peek().nama);
        } else {
            System.out.println("  → Antrian sekarang kosong.");
        }
    }

    // ─── FITUR 3: Lihat Antrian ─────────────────────────────────────
    static void lihatAntrian() {
        System.out.println("\n  ══ ANTRIAN SAAT INI [QUEUE - FIFO] ══");
        System.out.println("  Jumlah pasien menunggu: " + antrian.getSize());
        System.out.println("  DEPAN ↓");
        antrian.tampilkan();
        System.out.println("  BELAKANG ↑");
        System.out.println("  (Pasien masuk dari belakang, dipanggil dari depan)");
    }

    // ─── FITUR 4: Lihat Semua Pasien ────────────────────────────────
    static void lihatSemuaPasien() {
        System.out.println("\n  ══ SEMUA PASIEN TERDAFTAR [LINKED LIST] ══");
        System.out.println("  Total: " + daftarPasien.getSize() + " pasien");
        daftarPasien.tampilkan();
        System.out.println("  (Node saling terhubung via pointer next)");
    }

    // ─── FITUR 5: Lihat Riwayat ─────────────────────────────────────
    static void lihatRiwayat() {
        System.out.println("\n  ══ RIWAYAT TINDAKAN [STACK - LIFO] ══");
        System.out.println("  Total riwayat: " + riwayat.getSize());
        System.out.println("  TOP ↓");
        riwayat.tampilkan();
        System.out.println("  BOTTOM ↑");
        System.out.println("  (Pasien terakhir dipanggil tampil paling atas)");
    }

    // ─── FITUR 6: Undo Panggilan ─────────────────────────────────────
    static void undoPanggilan() {
        System.out.println("\n  ══ UNDO PANGGILAN TERAKHIR ══");
        if (riwayat.isEmpty()) {
            System.out.println("  [!] Tidak ada riwayat untuk di-undo.");
            return;
        }

        System.out.println("  Riwayat terakhir: " + riwayat.peek());
        System.out.print("  Yakin ingin undo? (y/n): ");
        String konfirmasi = scanner.nextLine().trim();

        if (konfirmasi.equalsIgnoreCase("y")) {
            Pasien dikembalikan = riwayat.pop();   // Pop dari Stack
            antrian.enqueue(dikembalikan);          // Kembalikan ke Queue

            System.out.println("\n  ✓ Undo berhasil!");
            System.out.println("  → Dipop dari Stack riwayat");
            System.out.println("  → Dienqueue kembali ke Queue antrian");
            System.out.println("  → " + dikembalikan.nama + " kembali ke antrian");
        } else {
            System.out.println("  Undo dibatalkan.");
        }
    }

    // ─── FITUR 7: Cari Pasien ────────────────────────────────────────
    static void cariPasien() {
        System.out.println("\n  ══ CARI PASIEN [LinkedList - Traverse] ══");
        System.out.print("  Masukkan nama yang dicari: ");
        String nama = scanner.nextLine().trim();

        System.out.println("  → Melakukan traverse dari head LinkedList...");
        Pasien hasil = daftarPasien.cari(nama);

        if (hasil != null) {
            System.out.println("  ✓ Pasien ditemukan:");
            System.out.println("    " + hasil);
        } else {
            System.out.println("  [!] Pasien dengan nama '" + nama + "' tidak ditemukan.");
        }
    }

    // ─── FITUR 8: Hapus Pasien ───────────────────────────────────────
    static void hapusPasien() {
        System.out.println("\n  ══ HAPUS PASIEN [LinkedList - Delete Node] ══");
        int id = inputAngka("  Masukkan ID pasien yang dihapus: ");

        boolean berhasil = daftarPasien.hapus(id);
        if (berhasil) {
            System.out.println("  ✓ Pasien ID " + id + " berhasil dihapus dari LinkedList.");
            System.out.println("  → Node dihapus, pointer next disesuaikan.");
        } else {
            System.out.println("  [!] Pasien dengan ID " + id + " tidak ditemukan.");
        }
    }

    // ─── Helper ──────────────────────────────────────────────────────
    static int inputAngka(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int angka = Integer.parseInt(scanner.nextLine().trim());
                return angka;
            } catch (NumberFormatException e) {
                System.out.println("  [!] Masukkan angka yang valid!");
            }
        }
    }

    static void demoDataAwal() {
        System.out.println("\n  [Demo] Memuat data awal...");
        String[][] data = {
                {"Budi Santoso",   "35", "Demam tinggi"},
                {"Siti Rahayu",    "28", "Sakit kepala"},
                {"Ahmad Fauzi",    "45", "Batuk pilek"},
                {"Dewi Kusuma",    "52", "Nyeri sendi"},
        };
        for (String[] d : data) {
            String waktu = LocalDateTime.now().format(dtf);
            Pasien p = new Pasien(idCounter++, d[0], Integer.parseInt(d[1]), d[2], waktu);
            daftarPasien.tambah(p);
            antrian.enqueue(p);
        }
        System.out.println("  ✓ " + daftarPasien.getSize() + " pasien demo berhasil dimuat.\n");
    }
}