package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iata {

  @SerializedName("code")
  private String code;

  @SerializedName("departureTax")
  private String departureTax;

  @SerializedName("flight")
  private List<Flight> flight;

  private void prepareFlight() {
    if (flight == null) {
      flight = new ArrayList<>();
    }
  }

  public Iata addFlight(Flight flight) {
    prepareFlight();

    this.flight.add(flight);

    return this;
  }

  public Iterator<Flight> getFlightIterator() {
    prepareFlight();

    return flight.iterator();
  }

  public String getCode() {
    return code;
  }

  public Iata setCode(String code) {
    this.code = code;
    return this;
  }

  public String getDepartureTax() {
    return departureTax;
  }

  public Iata setDepartureTax(String departureTax) {
    this.departureTax = departureTax;
    return this;
  }
}
