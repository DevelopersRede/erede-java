package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class Address {

  public final static int BILLING = 1;
  public final static int SHIPPING = 2;
  public final static int BOTH = 3;

  public final static int APARTMENT = 1;
  public final static int HOUST = 2;
  public final static int COMMERCIAL = 3;
  public final static int OTHER = 4;

  @SerializedName("address")
  private String address;

  @SerializedName("addresseeName")
  private String addresseeName;

  @SerializedName("city")
  private String city;

  @SerializedName("number")
  private String number;

  @SerializedName("state")
  private String state;

  @SerializedName("type")
  private int type;

  @SerializedName("zipCode")
  private String zipCode;

  public String getAddress() {
    return address;
  }

  public Address setAddress(String address) {
    this.address = address;
    return this;
  }

  public String getAddresseeName() {
    return addresseeName;
  }

  public Address setAddresseeName(String addresseeName) {
    this.addresseeName = addresseeName;
    return this;
  }

  public String getCity() {
    return city;
  }

  public Address setCity(String city) {
    this.city = city;
    return this;
  }

  public String getNumber() {
    return number;
  }

  public Address setNumber(String number) {
    this.number = number;
    return this;
  }

  public String getState() {
    return state;
  }

  public Address setState(String state) {
    this.state = state;
    return this;
  }

  public int getType() {
    return type;
  }

  public Address setType(int type) {
    this.type = type;
    return this;
  }

  public String getZipCode() {
    return zipCode;
  }

  public Address setZipCode(String zipCode) {
    this.zipCode = zipCode;
    return this;
  }
}
