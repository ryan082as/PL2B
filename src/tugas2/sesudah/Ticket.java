package tugas2.sesudah;

public abstract class Ticket {
    public String passengerName;      // rename pName = passengerName
    public String startLocation;  // rename sLocation = startLocation
    public String destination;       // rename dest = destination
    protected double price;       // rename prc = price

    public Ticket(String passengerName, String startLocation, String destination, double price) {
        this.passengerName = passengerName;
        this.startLocation = startLocation;
        this.destination = destination;
        this.price = price;
    }

    public abstract void displayInfo();
}
