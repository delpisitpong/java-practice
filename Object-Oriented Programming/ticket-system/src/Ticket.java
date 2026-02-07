public class Ticket {
    private final String ticket_id;
    private final Movie movie;
    private final String show_time;
    private final String seat_number;
    private final double price;
    private boolean is_booked;
    private boolean is_used;

    public Ticket(String ticket_id, Movie movie, String show_time, String seat_number, double price) {
        this.ticket_id = ticket_id;
        this.movie = movie;
        this.show_time = show_time;
        this.seat_number = seat_number;
        this.price = price;
        this.is_booked = false;
        this.is_used = false;
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public Movie getMovie() {
        return movie;
    }

    public String bookTicket() {
        if (!is_booked) {
            is_booked = true;
            return "Ticket booked";
        } else {
            return "This ticket is already booked";
        }
    }

    public String useTicket() {
        if (!is_booked) {
            return "Please book the ticket first";
        }
        if (is_used) {
            return "Ticket already used";
        } else {
            is_used = true;
            return "Enjoy the movie!!";
        }
    }

    @Override
    public String toString() {
        return "Ticket Id: " + ticket_id +
                "\nMovie: " + movie +
                "\nShow Time: " + show_time +
                "\nSeat Number: " + seat_number +
                "\nTicket Price: " + price +
                "\nBooked: " + (is_booked ? "Yes" : "No") +
                "\nUsed: " + (is_used ? "Yes" : "No");
    }
}
