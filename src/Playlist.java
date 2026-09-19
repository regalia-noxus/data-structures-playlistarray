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
    // Method untuk mencari lagu berdasarkan judul yang diketik user
    public void cariLagu(String targetJudul) {
        if (totalLagu == 0) { // kalau playlist belum ada isinya hentikan proses pencarian
            System.out.println("Playlist masih kosong!"); // // keluar dari method, tidak perlu lanjut ke bawah
            return;
        }
        // Variabel penanda (flag) untuk mencatat apakah lagu berhasil ditemukan atau tidak
        boolean ditemukan = false;

        // Perulangan Linear Search fungsinya memeriksa elemen array satu per satu dari indeks ke-0 sampai terakhir
        for (int i = 0; i < totalLagu; i++) {
            // Membandingkan judul tanpa memedulikan huruf besar/kecil
            if (lagu[i].getJudul().equalsIgnoreCase(targetJudul)) {
                System.out.println("\nLagu ditemukan pada indeks ke-" + i + ":");
                System.out.printf("%s - %s (%.2f menit)%n",
                    lagu[i].getJudul(),
                    lagu[i].getArtis(),
                    lagu[i].getDurasi()
                );
                ditemukan = true; //Ubah status penanda menjadi true karena sudah ketemu
                break;    // Langsung hentikan perulangan supaya efisien, tidak perlu cek sisa lagu
            }
        }
        // Jika setelah perulangan selesai status ditemukan masih bernilai false
        if (!ditemukan) {
            System.out.println("Lagu dengan judul '" + targetJudul + "' tidak ditemukan.");
        }
    }

    // ==========================================================
    // Anggota 2: DELETION (penghapusan & pergeseran array)
    // ==========================================================
    // Method untuk menghapus lagu berdasarkan judul serta merapatkan kembali susunan array
    public void hapusLagu(String targetJudul) {
        // validasi kalau playlist kosong, tidak ada data yang bisa dihapus
        if (totalLagu == 0) {
            System.out.println("Playlist masih kosong!");
            return;
        }
        // ini variabel untuk menyimpan posisi indeks lagu yang ingin dihapus
        // diinisialisasi dengan -1 sebagai penanda awal (artinya belum ketemu)
        int indexDitemukan = -1;

        // Mencari posisi lagu yang akan dihapus
        for (int i = 0; i < totalLagu; i++) {
            if (lagu[i].getJudul().equalsIgnoreCase(targetJudul)) {
                indexDitemukan = i; // Simpan indeks posisi lagu yang ditemukan
                break;
            }
        }
        // jika setelah dicari nilainya tetap -1, artinya lagu tidak ada di dalam playlist
        if (indexDitemukan == -1) {
            System.out.println("Lagu '" + targetJudul + "' tidak ditemukan.");
            return;
        }
        // ini adalah proses Pergeseran (Shifting) ke arah kiri
        // dimulai dari posisi lagu yang dihapus sampai ke elemen sebelum terakhir
        // menggeser elemen setelah lagu yang dihapus satu posisi ke kiri
        for (int i = indexDitemukan; i < totalLagu - 1; i++) {
            lagu[i] = lagu[i + 1];
        }

        // Membersihkan posisi terakhir dan mengurangi jumlah lagu, lebih jelasnya bersihkan posisi elemen paling akhir yang sudah diduplikasi ke kiri
        lagu[totalLagu - 1] = null;
        totalLagu--; // kurangi jumlah penanda total lagu karena satu lagu sudah berhasil dibuang

        System.out.println("Lagu '" + targetJudul + "' berhasil dihapus!");
        System.out.println("\nDaftar lagu saat ini:");
        tampilkanSemuaLagu();
    }
}
