public class Playlist {

    // Array untuk menyimpan kumpulan objek Lagu
    private Lagu[] lagu;

    // Menyimpan jumlah lagu
    private int totalLagu;

    // CONSTRUCTOR
    public Playlist(int kapasitas) {

        lagu = new Lagu[kapasitas];

        totalLagu = 0;
    }

    // INSERTION
    // Digunakan ketika user memilih Menu 2
    public void tambahLagu(Lagu laguBaru) {

        // Mengecek apakah playlist sudah penuh
        if (totalLagu >= lagu.length) {

            System.out.println("Playlist penuh!");

            return;
        }

        // Memasukkan lagu ke posisi berikutnya
        lagu[totalLagu] = laguBaru;

        // Menambah jumlah lagu
        totalLagu++;

        // Pesan hanya muncul ketika user
        // memilih Menu 2
        System.out.println("Lagu berhasil ditambahkan!");

        System.out.println("\nDaftar lagu saat ini:");

        // Menampilkan semua lagu
        tampilkanSemuaLagu();
    }

    // INSERTION DATA AWAL
    // Tidak menampilkan pesan
    public void tambahLaguAwal(Lagu laguBaru) {

        if (totalLagu >= lagu.length) {
            return;
        }

        lagu[totalLagu] = laguBaru;

        totalLagu++;
    }


    // TRAVERSAL
    // Menampilkan semua lagu
    public void tampilkanSemuaLagu() {

        if (totalLagu == 0) {

            System.out.println("Playlist masih kosong.");

            return;
        }

        // Traversal array
        for (int i = 0; i < totalLagu; i++) {

            System.out.printf(
                "%d. %s - %s (%.2f menit)%n",
                i + 1,
                lagu[i].getJudul(),
                lagu[i].getArtis(),
                lagu[i].getDurasi()
            );
        }
    }
    // ==========================================================
    // Anggota 2: seraching (linear search)
    // ==========================================================
    public void cariLagu(String targetJudul) {
        if (totalLagu == 0) {
            System.out.println("Playlist masih kosong!");
            return;
        }

        boolean ditemukan = false;

        // Linear Search: menelusuri array satu per satu dari indeks 0
        for (int i = 0; i < totalLagu; i++) {
            // Membandingkan judul tanpa memedulikan huruf besar/kecil
            if (lagu[i].getJudul().equalsIgnoreCase(targetJudul)) {
                System.out.println("\nLagu ditemukan pada indeks ke-" + i + ":");
                System.out.printf("%s - %s (%.2f menit)%n",
                    lagu[i].getJudul(),
                    lagu[i].getArtis(),
                    lagu[i].getDurasi()
                );
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Lagu dengan judul '" + targetJudul + "' tidak ditemukan.");
        }
    }

    // ==========================================================
    // Anggota 2: DELETION (penghapusan & pergeseran array)
    // ==========================================================
    
    public void hapusLagu(String targetJudul) {
        if (totalLagu == 0) {
            System.out.println("Playlist masih kosong!");
            return;
        }

        int indexDitemukan = -1;

        // Mencari posisi lagu yang akan dihapus
        for (int i = 0; i < totalLagu; i++) {
            if (lagu[i].getJudul().equalsIgnoreCase(targetJudul)) {
                indexDitemukan = i;
                break;
            }
        }

        if (indexDitemukan == -1) {
            System.out.println("Lagu '" + targetJudul + "' tidak ditemukan.");
            return;
        }

        // Menggeser elemen setelah lagu yang dihapus satu posisi ke kiri
        for (int i = indexDitemukan; i < totalLagu - 1; i++) {
            lagu[i] = lagu[i + 1];
        }

        // Membersihkan posisi terakhir dan mengurangi jumlah lagu
        lagu[totalLagu - 1] = null;
        totalLagu--;

        System.out.println("Lagu '" + targetJudul + "' berhasil dihapus!");
        System.out.println("\nDaftar lagu saat ini:");
        tampilkanSemuaLagu();
    }
}
