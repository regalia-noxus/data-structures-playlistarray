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
}
