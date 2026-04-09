public class Pasien {
    public int id;
    public String nama;
    public int umur;
    public String keluhan;
    public String waktuDaftar;

    public Pasien(int id, String nama, int umur, String keluhan, String waktuDaftar) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
        this.keluhan = keluhan;
        this.waktuDaftar = waktuDaftar;
    }

    @Override
    public String toString() {
        return String.format("[ID:%03d] %-20s | Umur: %2d | Keluhan: %-25s | Daftar: %s",
                id, nama, umur, keluhan, waktuDaftar);
    }
}