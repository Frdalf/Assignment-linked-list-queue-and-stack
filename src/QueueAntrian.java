public class QueueAntrian {
    private Node front;
    private Node rear;
    private int size;

    public QueueAntrian() {
        front = null;
        rear = null;
        size = 0;
    }

    // Enqueue - pasien masuk antrian (dari belakang)
    public void enqueue(Pasien pasien) {
        Node newNode = new Node(pasien);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Dequeue - panggil pasien (dari depan, FIFO)
    public Pasien dequeue() {
        if (isEmpty()) return null;
        Pasien pasien = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return pasien;
    }

    // Lihat siapa yang paling depan tanpa menghapus
    public Pasien peek() {
        if (isEmpty()) return null;
        return front.data;
    }

    // Tampilkan antrian dari depan ke belakang
    public void tampilkan() {
        if (isEmpty()) {
            System.out.println("  (Antrian kosong)");
            return;
        }
        Node current = front;
        int urutan = 1;
        while (current != null) {
            String label = (urutan == 1) ? " <-- DIPANGGIL BERIKUTNYA" : "";
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