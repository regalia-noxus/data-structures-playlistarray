/*
 * Group 3:
 * 1. HILMAN WASIANDI KHAIRURRIZAL - 2902817490
 * 2. CHRISTOFFER YOEL EVANDRI VIEBRIAN - 2902816336
 * 3. SULAIHA - 2902806442
 * 4. IRFAN SISWARA - 2902813126
 * 5. M. AKMAL ZULKARNAEN PRIADI - 2902826015
 */

import java.util.Scanner;

public class PlaylistArray {
	
	//Menjalankan program dan menampilkan menu sesuai peran pengguna
	// Jika Admin bisa menambahkan lagu
	// jika user bisa melihat list lagu

    public static void main(String[] args) {

    	Scanner input = new Scanner(System.in); // Membuat Scanner untuk membaca input dari keyboard agar bisa diketik dan interaktif

    	Playlist playlist = new Playlist(10); //Membuat object Playlist dengan kapasitas awal 10 lagu

    	// Data lagu awal
        // Ditambahkan tanpa menampilkan pesan ke layar
        playlist.tambahLaguAwal(
            new Lagu("Perfect", "Ed Sheeran", 4.23)
        );

        playlist.tambahLaguAwal(
            new Lagu("Shivers", "Ed Sheeran", 3.50)
        );

        int pilihan;

        do {
            
            // MENU UTAMA
            System.out.println("\n=== MENU PLAYLIST MUSIK ===");
            System.out.println("1. Tampilkan semua lagu");
            System.out.println("2. Tambah lagu baru");
            System.out.println("3. Hapus lagu berdasarkan judul");
            System.out.println("4. Cari lagu berdasarkan judul");
            System.out.println("5. Urutkan berdasarkan durasi");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = bacaAngka(input);

            switch (pilihan) {

                // TRAVERSAL
                case 1:
                    playlist.tampilkanSemuaLagu();
                    break;

                // INSERTION
                case 2:

                    System.out.print("Masukkan judul lagu : ");
                    String judul = input.nextLine();

                    System.out.print("Masukkan artis      : ");
                    String artis = input.nextLine();

                    System.out.print("Masukkan durasi (menit): ");
                    double durasi = bacaDesimal(input);

                    Lagu laguBaru = new Lagu(judul, artis, durasi);

                    playlist.tambahLagu(laguBaru);

                    break;

                // MENU 3
                case 3:
                    System.out.println(
                        "Fitur hapus lagu menunggu anggota 2."
                    );
                    break;

                // MENU 4
                case 4:
                    System.out.println(
                        "Fitur cari lagu menunggu anggota 2."
                    );
                    break;

                // MENU 5
                case 5:
                    System.out.println(
                        "Fitur pengurutan lagu menunggu anggota 2."
                    );
                    break;

                // KELUAR
                case 6:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println(
                        "Pilihan tidak tersedia. Silakan pilih 1-6."
                    );
            }

        } while (pilihan != 6);

        input.close();
    }

    // Membaca input angka
    private static int bacaAngka(Scanner input) {

        while (!input.hasNextInt()) {
            System.out.print(
                "Input harus berupa angka. Masukkan kembali: "
            );
            input.nextLine();
        }

        int angka = input.nextInt();
        input.nextLine();

        return angka;
    }

    // Membaca input durasi
    private static double bacaDesimal(Scanner input) {

        while (true) {

            if (input.hasNextDouble()) {

                double angka = input.nextDouble();
                input.nextLine();

                if (angka > 0) {
                    return angka;
                }

            } else {
                input.nextLine();
            }

            System.out.print(
                "Durasi harus berupa angka positif. Masukkan kembali: "
            );
        }
    }
}
