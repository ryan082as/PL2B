package tugas2.sesudah;
                              // extract superclass {method displayInfo,  passengerName, startLocation, destination, price} Ticket
public class TaxiTicket extends Ticket implements Operational {
    public static final double TAX_RATE = 0.1;
    private double duration;
    private double speed;

    private static final double MIN_SPEED = 5;
    private static final double MAX_SPEED = 100;

    public TaxiTicket(TicketInfo ticketInfo) {
        super(ticketInfo.passengerName(), ticketInfo.startLocation(), ticketInfo.destination(), ticketInfo.price());       // introduce parameter object {assangerName, startLocation, destination, price} TicketInfo
        this.duration = ticketInfo.duration();
        this.speed = ticketInfo.speed();
    }

    @Override
    public void checkStatus() {          // rename cS = checkStatus
        System.out.println("Your taxi is heading to " + destination);
    }

    @Override
    public void displayEstimatedDuration() {         // rename dED = displayEstimatedDuration
        System.out.println("Estimated travel duration: " + duration + " minutes");
    }

    @Override
    public void displayRoute() {          // rename dR = displayRoute
        System.out.println("Route: " + startLocation + " -> " + destination);
    }

    public void slowDown(double speedReduction) {
        speed -= speedReduction;
        if (speed < MIN_SPEED) {
            speed = MIN_SPEED;
        }
        duration += speedReduction * 0.5;
        System.out.println("Taxi slowed down! Current speed: " + speed + " km/h");
    }

    public void speedUp(double speedIncrease) {
        speed += speedIncrease;
        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }
        System.out.println("Taxi sped up! Current speed: " + speed + " km/h");
    }

    @Override
    public void displayInfo() {          // rename dI = displayInfo
        System.out.println("Passenger Name : " + passengerName);
        System.out.println("Start Location : " + startLocation);
        System.out.println("Destination : " + destination);
        System.out.println("Price : " + price);
        System.out.println("Final Price : " + calculateFinePrice());     // introduce constant 0.1 = TAX_RATE    &   extract method  prc + (prc * 0.1) = calculateFinalPrice
    }

    private double calculateFinePrice() {
        return price + (price * TAX_RATE);
    }

    public void detailedInfo() {
        displayInfo();
        System.out.println("Duration : " + duration + " minutes");
        System.out.println("Speed : " + speed + " km/h");
    }

                              }
