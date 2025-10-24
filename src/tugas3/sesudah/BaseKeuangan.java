package tugas3.sesudah;

// Refactoring 7: Extract Superclass
public abstract class BaseKeuangan {

    // Refactoring 5: Introduce Constant
    protected static final int JUMLAH_HARI_MINGGU = 7;
    protected static final String[] NAMA_HARI = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"};

    // Refactoring 6: Encapsulate Field
    private double[] pengeluaranHarian;

    // Refactoring 1: Rename (dari totalPengeluaran)
    protected double totalJumlah;

    public BaseKeuangan(double[] pengeluaranHarian) {
        this.pengeluaranHarian = pengeluaranHarian;
        hitungTotal(); // Hitung total saat objek dibuat
    }

    // Getter untuk data harian
    public double[] getPengeluaranHarian() {
        return pengeluaranHarian;
    }

    // Logika perhitungan total, dipindahkan dari main
    private void hitungTotal() {
        this.totalJumlah = 0;
        for (double p : this.pengeluaranHarian) {
            this.totalJumlah += p;
        }
    }

    // Metode abstrak yang harus diimplementasikan oleh subclass
    public abstract double hitungRataRata();
    public abstract double getTotalJumlah();
}
