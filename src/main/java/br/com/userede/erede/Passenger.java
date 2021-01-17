package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class Passenger {

    @SerializedName("email")
    private String email;

    @SerializedName("name")
    private String name;

    @SerializedName("phone")
    private Phone phone;

    @SerializedName("ticket")
    private String ticket;

    public String getEmail() {
        return email;
    }

    public Passenger setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public Passenger setName(String name) {
        this.name = name;
        return this;
    }

    public Phone getPhone() {
        return phone;
    }

    public Passenger setPhone(Phone phone) {
        this.phone = phone;
        return this;
    }

    public String getTicket() {
        return ticket;
    }

    public Passenger setTicket(String ticket) {
        this.ticket = ticket;
        return this;
    }
}
