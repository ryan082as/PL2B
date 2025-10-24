package tugas3.sesudah;

import java.util.Scanner;

public class MainProgram {

    private static double[] getInputPengeluaran(Scanner input) {
        double[] data = new double[BaseKeuangan.JUMLAH_HARI_MINGGU];
        System.out.println("\n--- Masukkan Pengeluaran ---");

        for (int i = 0; i < BaseKeuangan.JUMLAH_HARI_MINGGU; i++) {
            boolean valid = false;
            while (!valid) {
                System.out.print("Masukkan pengeluaran hari " + BaseKeuangan.NAMA_HARI[i] + " (Rp): ");

                if (input.hasNextDouble()) {
                    // Refactoring 3: Inline Variable (pengeluaranInput di-inline)
                    double pengeluaran = input.nextDouble();

                    if (pengeluaran < 0) {
                        System.out.println("⚠ Peringatan: Pengeluaran tidak boleh negatif.");
                    } else {
                        data[i] = pengeluaran;
                        valid = true;
                    }
                } else {
                    System.out.println("❌ Input salah. Mohon masukkan angka yang valid.");
                    input.next();
                }
            }
        }
        return data;
    }

    private static void tampilkanHasil(PengeluaranMingguan laporan) {
        // Output menggunakan Interface IHitungKeuangan
        IHitungKeuangan perhitungan = laporan;

        System.out.println("\n==================================================");
        System.out.println("             REKAPITULASI PENGELUARAN");
        System.out.println("==================================================");

        System.out.println("RINCIAN PENGELUARAN HARIAN:");
        double[] harian = laporan.getPengeluaranHarian(); // Refactoring 6: Menggunakan Getter

        for (int i = 0; i < BaseKeuangan.JUMLAH_HARI_MINGGU; i++) {
            System.out.printf("%-8s : Rp %,.2f%n", BaseKeuangan.NAMA_HARI[i], harian[i]);
        }

        System.out.println("--------------------------------------------------");
        // Refactoring 1: Nama metode dan output sudah berubah (totalJumlah)
        System.out.printf("💰 Total Pengeluaran Minggu Ini : Rp %,.2f%n", perhitungan.getTotalJumlah());
        System.out.printf("⚖️  Rata-rata Pengeluaran Harian : Rp %,.2f%n", perhitungan.hitungRataRata());
        System.out.println("==================================================");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("  SISTEM PERHITUNGAN PENGELUARAN DALAM SEMINGGU");
        System.out.println("==================================================");

        // 1. INPUT
        double[] dataPengeluaran = getInputPengeluaran(input);

        // 2. PROSES (Instansiasi Subclass)
        PengeluaranMingguan laporanMingguan = new PengeluaranMingguan(dataPengeluaran);

        // 3. OUTPUT
        tampilkanHasil(laporanMingguan);

        input.close();
    }
}
