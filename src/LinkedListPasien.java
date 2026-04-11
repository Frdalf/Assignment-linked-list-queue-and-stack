public class LinkedListPasien {
    private Node head;
    private int size;

    public LinkedListPasien() {
        head = null;
        size = 0;
    }

    // Tambah Pasien di Akhir List
    public void tambah(Pasien pasien) {
        Node newNode = new Node(pasien);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Hapus Pasien Berdasarkan ID
    public boolean hapus(int id) {
        if (head == null) return false;

        if (head.data.id == id) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.id == id) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Cari pasien berdasarkan nama (traverse bebas)
    public Pasien cari(String nama) {
        Node current = head;
        while (current != null) {
            if (current.data.nama.equalsIgnoreCase(nama)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    // Tampilkan semua pasien
    public void tampilkan() {
        if (head == null) {
            System.out.println("  (Belum ada pasien terdaftar)");
            return;
        }
        Node current = head;
        int no = 1;
        while (current != null) {
            System.out.println("  " + no + ". " + current.data);
            current = current.next;
            no++;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}