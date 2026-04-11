public class StackRiwayat {
    private Node top;
    private int size;

    public StackRiwayat() {
        top = null;
        size = 0;
    }

    // Push - Simpan Pasien yang Sudah Dipanggil ke Riwayat
    public void push(Pasien pasien) {
        Node newNode = new Node(pasien);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Pop - ambil riwayat terakhir (untuk fitur undo)
    public Pasien pop() {
        if (isEmpty()) return null;
        Pasien pasien = top.data;
        top = top.next;
        size--;
        return pasien;
    }

    // Peek - lihat riwayat terakhir tanpa menghapus
    public Pasien peek() {
        if (isEmpty()) return null;
        return top.data;
    }

    // Tampilkan Riwayat dari Terbaru ke Terlama (LIFO)
    public void tampilkan() {
        if (isEmpty()) {
            System.out.println("  (Belum ada riwayat tindakan)");
            return;
        }
        Node current = top;
        int urutan = 1;
        while (current != null) {
            String label = (urutan == 1) ? " <-- TERBARU" : "";
            System.out.println("  " + urutan + ". " + current.data + label);
            current = current.next;
            urutan++;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}