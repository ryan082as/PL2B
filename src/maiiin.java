import java.util.Scanner;

public class maiiin {

    // Fungsi f(x) = x^2 - x - 6
    // Mengubah persamaan f(x) = 0 menjadi bentuk x = g(x)

    public static double fungsi(double x) {
        return x * x - x - 6;
    }

    public static double g2(double x) {
        return x * x - 6;
    }

    // Metode Iterasi Sederhana
    public static double iterasiSederhana(double tebakanAwal, double toleransi, int maksIterasi, int pilihanG) {
        double x0 = tebakanAwal;
        double x1;
        int iterasi = 0;
        double error = toleransi + 1;

        System.out.println("\n=== METODE ITERASI SEDERHANA ===");
        System.out.println("Persamaan: f(x) = x² - x - 6");
        System.out.println("Tebakan awal: " + x0);
        System.out.println("Toleransi: " + toleransi);
        System.out.println("Maksimum iterasi: " + maksIterasi);
        System.out.println("\nIterasi\t  x\t\t  g(x)\t\t  Error");
        System.out.println("------------------------------------------------");

        while (error > toleransi && iterasi < maksIterasi) {

            x1 = g2(x0);

            error = Math.abs(x1 - x0);

            System.out.printf("%d\t  %.6f\t  %.6f\t  %.6f\n",
                    iterasi + 1, x0, x1, error);

            // Cek konvergensi
            if (error <= toleransi) {
                System.out.println("\n✓ Konvergen!");
                return x1;
            }

            x0 = x1;
            iterasi++;
        }

        if (iterasi >= maksIterasi) {
            System.out.println("\n⚠ Peringatan: Maksimum iterasi tercapai");
        }

        return x0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("PROGRAM ITERASI SEDERHANA");
        System.out.println("Persamaan: f(x) = x² - x - 6");
        System.out.println("Akar sebenarnya: x = 3 dan x = -2");

        // Input parameter
        System.out.print("\nMasukkan tebakan awal (x0): ");
        double x0 = scanner.nextDouble();

        System.out.print("Masukkan toleransi error (contoh: 0.0001): ");
        double toleransi = scanner.nextDouble();

        System.out.print("Masukkan maksimum iterasi: ");
        int maksIterasi = scanner.nextInt();

        // Pilih bentuk iterasi
        /*System.out.println("\nPilih bentuk iterasi:");
        System.out.println("1. x = √(x + 6)  (konvergen untuk x > -6)");
        System.out.println("2. x = x² - 6    (jarang konvergen)");
        System.out.println("3. x = 6/(x - 1) (konvergen untuk |x| kecil)");
        System.out.print("Pilihan (1-3): ");
        int pilihan = scanner.nextInt();*/
        int pilihan =0;
        try {
            double akar = iterasiSederhana(x0, toleransi, maksIterasi, pilihan);
            System.out.printf("\nAkar yang ditemukan: x = %.6f\n", akar);
            System.out.printf("Nilai f(akar) = %.8f\n", fungsi(akar));

            // Verifikasi
            if (Math.abs(fungsi(akar)) < 0.001) {
                System.out.println("✓ Hasil valid (f(akar) ≈ 0)");
            } else {
                System.out.println("⚠ Hasil mungkin tidak akurat");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Coba ubah tebakan awal atau pilihan iterasi");
        }

        scanner.close();
    }
}