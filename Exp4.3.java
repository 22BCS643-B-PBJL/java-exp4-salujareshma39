/*
Hard Level:
Develop a ticket booking system with synchronized threads to ensure no double booking of seats. Use thread priorities to simulate VIP bookings being processed first. java code of its in finding all the cards in a given symbol using Collection interface.
*/
import java.util.concurrent.locks.*;

class TicketBookingSystem {
    private static final int TOTAL_SEATS = 10;
    private boolean[] seats = new boolean[TOTAL_SEATS];
    private final Lock lock = new ReentrantLock();

    public boolean bookSeat(int seatNumber) {
        lock.lock();
        try {
            if (seats[seatNumber]) {
                return false;  // Already booked
            } else {
                seats[seatNumber] = true;
                return true;   // Successfully booked
            }
        } finally {
            lock.unlock();
        }
    }
}

class TicketBookingThread extends Thread {
    private TicketBookingSystem system;
    private int seatNumber;

    public TicketBookingThread(TicketBookingSystem system, int seatNumber, String name, int priority) {
        super(name);
        this.system = system;
        this.seatNumber = seatNumber;
        setPriority(priority);  // VIP gets higher priority
    }

    public void run() {
        if (system.bookSeat(seatNumber)) {
            System.out.println(getName() + " successfully booked seat " + seatNumber);
        } else {
            System.out.println(getName() + " failed to book seat " + seatNumber + " (already booked)");
        }
    }
}

public class TicketBookingApp {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();

        TicketBookingThread vip1 = new TicketBookingThread(system, 2, "VIP1", Thread.MAX_PRIORITY);
        TicketBookingThread user1 = new TicketBookingThread(system, 2, "User1", Thread.MIN_PRIORITY);
        TicketBookingThread user2 = new TicketBookingThread(system, 3, "User2", Thread.NORM_PRIORITY);
        TicketBookingThread vip2 = new TicketBookingThread(system, 3, "VIP2", Thread.MAX_PRIORITY);

        vip1.start();
        user1.start();
        user2.start();
        vip2.start();
    }
}
