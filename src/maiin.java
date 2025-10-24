import java.util.Scanner;

public class maiin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("  METODE ITERASI SEDERHANA");
        System.out.println("====================================");

        // Input dari pengguna
        System.out.print("Masukkan tebakan awal (x0): ");
        double x = scanner.nextDouble();

        System.out.print("Masukkan toleransi error: ");
        double toleransi = scanner.nextDouble();

        System.out.print("Masukkan maksimum iterasi: ");
        int maxIterasi = scanner.nextInt();

        System.out.println("\nProses Iterasi:");
        System.out.println("Iterasi\t x\t\t g(x)\t\t Error");
        System.out.println("----------------------------------------");

        // Proses iterasi
        int iterasi = 0;
        double error = 1000; // Nilai error awal yang besar

        while (error > toleransi && iterasi < maxIterasi) {
            // Simpan nilai x sebelumnya
            double xLama = x;

            // Hitung nilai x baru menggunakan fungsi g(x)
            x = hitungG(xLama);

            // Hitung error
            error = Math.abs(x - xLama);

            // Tampilkan hasil iterasi
            System.out.printf("%d\t %.6f\t %.6f\t %.6f\n",
                    iterasi + 1, xLama, x, error);

            iterasi++;
        }

        // Tampilkan hasil akhir
        System.out.println("\n====================================");
        System.out.println("HASIL AKHIR:");
        System.out.println("====================================");
        System.out.printf("Akar yang ditemukan: %.6f\n", x);
        System.out.printf("Nilai f(akar): %.6f\n", hitungF(x));
        System.out.printf("Jumlah iterasi: %d\n", iterasi);
        System.out.printf("Error akhir: %.6f\n", error);

        scanner.close();
    }

    // Fungsi f(x) yang akan dicari akarnya
    // Contoh: f(x) = x³ - 2x - 5
    public static double hitungF(double x) {
        return x * x - x - 6;
    }

    // Fungsi g(x) untuk iterasi
    // Dari f(x) = x³ - 2x - 5 = 0, kita ubah menjadi:
    // x = g(x) = (x³ - 5) / 2
    public static double hitungG(double x) {
        return (x * x * x - 5) / 2;
    }
}