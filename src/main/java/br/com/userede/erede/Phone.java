package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class Phone {

  public static final String CELLPHONE = "1";
  public static final String HOME = "2";
  public static final String WORK = "3";
  public static final String OTHER = "4";

  @SerializedName("ddd")
  private String ddd;

  @SerializedName("number")
  private String number;

  @SerializedName("type")
  private String type;

  public Phone(String ddd, String number, String type) {
    this.ddd = ddd;
    this.number = number;
    this.type = type;
  }

  public Phone(String ddd, String number) {
    this(ddd, number, Phone.CELLPHONE);
  }

  public String getDdd() {
    return ddd;
  }

  public Phone setDdd(String ddd) {
    this.ddd = ddd;
    return this;
  }

  public String getNumber() {
    return number;
  }

  public Phone setNumber(String number) {
    this.number = number;
    return this;
  }

  public String getType() {
    return type;
  }

  public Phone setType(String type) {
    this.type = type;
    return this;
  }
}
