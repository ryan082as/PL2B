package tugas2.sesudah;

public class Main {
    public static void main(String[] args) {        // move members psvm = tugas2.sesudah.Main
        TaxiTicket ticket = new TaxiTicket(new TicketInfo("Alice", "Downtown", "Airport", 50.0, 30.0, 60.0));

        ticket.detailedInfo();

        ticket.checkStatus();
        ticket.displayRoute();
        ticket.displayEstimatedDuration();

        System.out.println("\n--- Simulating speed change ---");
        ticket.slowDown(20);
        ticket.speedUp(15);

        System.out.println("\n--- Updated Info ---");
        ticket.detailedInfo();
    }
}
