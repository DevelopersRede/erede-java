package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class Document {

  @SerializedName("type")
  private String type;

  @SerializedName("number")
  private String number;

  public Document(String type, String number) {
    this.type = type;
    this.number = number;
  }

  public String getType() {
    return type;
  }

  public Document setType(String type) {
    this.type = type;
    return this;
  }

  public String getNumber() {
    return number;
  }

  public Document setNumber(String number) {
    this.number = number;
    return this;
  }
}
