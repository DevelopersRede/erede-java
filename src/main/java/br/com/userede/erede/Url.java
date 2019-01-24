package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class Url {

  public static final String CALLBACK = "callback";
  public static final String THREE_D_SECURE_FAILURE = "threeDSecureFailure";
  public static final String THREE_D_SECURE_SUCCESS = "threeDSecureSuccess";

  @SerializedName("type")
  public String type = Url.CALLBACK;

  @SerializedName("url")
  private String url;

  public Url() {
  }

  public Url(String url) {
    this(url, Url.CALLBACK);
  }

  public Url(String url, String type) {
    this.url = url;
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public Url setType(String type) {
    this.type = type;
    return this;
  }

  public String getUrl() {
    return url;
  }

  public Url setUrl(String url) {
    this.url = url;
    return this;
  }
}
