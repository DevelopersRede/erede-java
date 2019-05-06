package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class Link {

  @SerializedName("method")
  private String method;
  @SerializedName("rel")
  private String rel;
  @SerializedName("href")
  private String href;

  public String getMethod() {
    return method;
  }

  public String getRel() {
    return rel;
  }

  public String getHref() {
    return href;
  }
}
