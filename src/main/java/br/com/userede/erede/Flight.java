package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flight {

    @SerializedName("date")
    private String date;

    @SerializedName("ip")
    private String from;

    @SerializedName("number")
    private String number;

    @SerializedName("passenger")
    private List<Passenger> passenger;

    @SerializedName("to")
    private String to;

    public String getDate() {
        return date;
    }

    public Flight setDate(String date) {
        this.date = date;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public Flight setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public Flight setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getTo() {
        return to;
    }

    public Flight setTo(String to) {
        this.to = to;
        return this;
    }

    private void preparePassenger(boolean force) {
        if (force || passenger == null) {
            passenger = new ArrayList<>();
        }
    }

    public Flight setPassenger(Passenger passenger) {
        preparePassenger(true);

        this.passenger.add(passenger);

        return this;
    }

    public Flight addPassenger(Passenger passenger) {
        preparePassenger(false);

        this.passenger.add(passenger);

        return this;
    }

    public Iterator<Passenger> getPassengerIterator() {
        preparePassenger(false);

        return passenger.iterator();
    }
}
