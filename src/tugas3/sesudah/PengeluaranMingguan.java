package tugas3.sesudah;

public class PengeluaranMingguan extends BaseKeuangan implements IHitungKeuangan {

    public PengeluaranMingguan(double[] pengeluaranHarian) {
        super(pengeluaranHarian);
    }

    // Implementasi dari IHitungKeuangan
    @Override
    public double getTotalJumlah() {
        return this.totalJumlah;
    }

    // Implementasi Refactoring 2: Extract Method
    @Override
    public double hitungRataRata() {
        if (JUMLAH_HARI_MINGGU == 0) return 0;
        return this.totalJumlah / JUMLAH_HARI_MINGGU;
    }
}
