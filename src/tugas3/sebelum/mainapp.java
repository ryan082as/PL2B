package tugas3.sebelum;
import java.util.Scanner;

public class mainapp {

    public static void main(String[] args) {
        // Inisialisasi Scanner untuk input pengguna
        Scanner input = new Scanner(System.in);

        // Variabel dan data
        double[] pengeluaranHarian = new double[7];
        String[] namaHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"};
        double totalPengeluaran = 0; // Variabel ini akan di-rename

        System.out.println("==================================================");
        System.out.println("  SISTEM PERHITUNGAN PENGELUARAN DALAM SEMINGGU");
        System.out.println("==================================================");

        // Logika Input, Validasi, dan Perhitungan Total dicampur
        for (int i = 0; i < pengeluaranHarian.length; i++) {
            System.out.print("Masukkan pengeluaran hari " + namaHari[i] + " (Rp): ");

            try {
                if (input.hasNextDouble()) {
                    // Variabel input langsung
                    double pengeluaranInput = input.nextDouble();

                    pengeluaranHarian[i] = pengeluaranInput; // Variabel ini akan di-inline

                    if (pengeluaranHarian[i] < 0) {
                        System.out.println("⚠ Peringatan: Pengeluaran tidak boleh negatif. Masukkan ulang.");
                        i--;
                    } else {
                        totalPengeluaran += pengeluaranHarian[i];
                    }
                } else {
                    System.out.println("❌ Input salah. Mohon masukkan angka yang valid.");
                    input.next();
                    i--;
                }
            } catch (Exception e) {
                System.out.println("Terjadi error tak terduga.");
                input.next();
                i--;
            }
        }

        // Logika Perhitungan Rata-Rata
        double rataRataPengeluaran = totalPengeluaran / pengeluaranHarian.length;

        // Logika Output
        System.out.println("\n==================================================");
        System.out.println("             REKAPITULASI PENGELUARAN");
        System.out.println("==================================================");

        System.out.println("RINCIAN PENGELUARAN HARIAN:");
        for (int i = 0; i < pengeluaranHarian.length; i++) {
            System.out.printf("%-8s : Rp %,.2f%n", namaHari[i], pengeluaranHarian[i]);
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("Total Pengeluaran Minggu Ini : Rp %,.2f%n", totalPengeluaran);
        System.out.printf("Rata-rata Pengeluaran Harian : Rp %,.2f%n", rataRataPengeluaran);
        System.out.println("==================================================");

        input.close();
    }
}