package tugas2.sebelum;

public class TaxiTicket {
    // Variabel instance (public)
    public String pName;      // passengerName
    public String slocation;  // startLocation
    public String dest;       // destination

    // Variabel instance (private)
    private double prc;       // price
    private double duration;
    private double speed;

    // Variabel statis final untuk batasan kecepatan
    private static final double MIN_SPEED = 5;
    private static final double MAX_SPEED = 100;

    // Konstruktor
    public TaxiTicket(String passengerName, String startLocation, String destination,
                      double price, double duration, double speed) {
        this.pName = passengerName;
        this.slocation = startLocation;
        this.dest = destination;
        this.prc = price;
        this.duration = duration;
        this.speed = speed;
    }

    // Metode untuk memeriksa status taksi (cs)
    public void cS() {
        System.out.println("Your taxi is heading to " + dest);
    }

    // Metode untuk menampilkan perkiraan durasi perjalanan (dED)
    public void dED() {
        System.out.println("Estimated travel duration: " + duration + " minutes");
    }

    // Metode untuk menampilkan rute (dR)
    public void dR() {
        System.out.println("Route: " + slocation + " -> " + dest);
    }

    // Metode untuk memperlambat taksi (slowDown)
    public void slowDown(double speedReduction) {
        speed -= speedReduction;
        // Memastikan kecepatan tidak di bawah MIN_SPEED
        if (speed < MIN_SPEED) {
            speed = MIN_SPEED;
        }

        // Asumsi: durasi bertambah 0.5 menit untuk setiap 1 km/jam perlambatan
        // Catatan: logika ini mungkin tidak realistis, tetapi mengikuti kode gambar
        duration += speedReduction * 0.5;

        System.out.println("Taxi slowed down! Current speed: " + speed + " km/h");
    }

    // Metode untuk mempercepat taksi (speedUp)
    public void speedUp(double speedIncrease) {
        speed += speedIncrease;
        // Memastikan kecepatan tidak melebihi MAX_SPEED
        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }
        System.out.println("Taxi sped up! Current speed: " + speed + " km/h");
    }

    // Metode untuk menampilkan info dasar penumpang dan perjalanan (di)
    public void dI() {
        System.out.println("Passenger Name : " + pName);
        System.out.println("Start Location : " + slocation);
        System.out.println("Destination : " + dest);
        System.out.println("Price : " + prc);
        // Harga akhir termasuk pajak 10%
        System.out.println("Final Price : " + (prc + (prc * 0.1)));
    }

    // Metode untuk menampilkan info lengkap termasuk durasi dan kecepatan (detailedInfo)
    public void detailedInfo() {
        dI(); // Memanggil metode dasar info
        System.out.println("Duration : " + duration + " minutes");
        System.out.println("Speed : " + speed + " km/h");
    }

    // Metode main untuk eksekusi
    public static void main(String[] args) {
        // Membuat objek TaxiTicket
        // pName="Alice", slocation="Downtown", dest="Airport", prc=50.0, duration=30.0, speed=60.0
        TaxiTicket ticket = new TaxiTicket("Alice", "Downtown", "Airport", 50.0, 30.0, 60.0);

        // Menampilkan info lengkap
        ticket.detailedInfo();

        // Memeriksa status taksi
        ticket.cS();

        // Menampilkan rute dan perkiraan durasi
        ticket.dR();
        ticket.dED();

        // Mensimulasikan perlambatan dan percepatan
        System.out.println("\n--- Simulating speed change ---");
        ticket.slowDown(20); // Kecepatan 60.0 -> 40.0
        ticket.speedUp(15);  // Kecepatan 40.0 -> 55.0

        // Menampilkan info lengkap lagi untuk melihat perubahan kecepatan/durasi
        System.out.println("\n--- Updated Info ---");
        ticket.detailedInfo();
    }
}

