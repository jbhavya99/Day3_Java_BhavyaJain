package com.bhavya;

import java.util.*;

public class TicketReservation {
    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    private List<Passenger> confirmedList = new ArrayList<>();
    private Deque<Passenger> waitingList = new ArrayDeque<>();

    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
        //using Passenger class to create objects in TicketReservation class
        Passenger p = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);
        if(confirmedList.size() < CONFIRMEDLIST_LIMIT){
            confirmedList.add(p);
            return true;//Booked successfully
        }
        else if(waitingList.size() < WAITINGLIST_LIMIT){
            waitingList.add(p);
            return true;//Waitlisted successfully
        }
        return false;//Booking failed i.e. no space
    }

    //Note that removing the passenger matching the confirmationNumber has to happen in this removePassenger() and not in the cancel() method.
    public boolean cancel(String confirmationNumber) {
        // Find in confirmedList & remove if found there
        if (removePassenger(confirmedList.iterator(), confirmationNumber)) {
            // Move the first passenger from waitingList to confirmedList
            if (!waitingList.isEmpty()) {
                confirmedList.add(waitingList.poll());
            }
            return true;
        }

        // Try to remove from waitingList, return true if found otherwise false
        return removePassenger(waitingList.iterator(), confirmationNumber);
    }

    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
        while (iterator.hasNext()) {
            Passenger p = iterator.next();
            if (p.getConfirmationNumber().equals(confirmationNumber)) {
                iterator.remove(); // Safely removes the passenger from the collection
                return true; // Passenger found and removed
            }
        }
        return false; // Passenger not found

    }

}
