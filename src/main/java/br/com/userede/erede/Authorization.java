package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class Authorization {

  @SerializedName("affiliation")
  private String affiliation;

  @SerializedName("amount")
  private int amount;

  @SerializedName("authorizationCode")
  private String authorizationCode;

  @SerializedName("cardBin")
  private String cardBin;

  @SerializedName("cardHolderName")
  private String cardHolderName;

  @SerializedName("dateTime")
  private String dateTime;

  @SerializedName("installments")
  private int installments;

  @SerializedName("kind")
  private String kind;

  @SerializedName("last4")
  private String last4;

  @SerializedName("nsu")
  private String nsu;

  @SerializedName("origin")
  private String origin;

  @SerializedName("reference")
  private String reference;

  @SerializedName("returnCode")
  private String returnCode;

  @SerializedName("returnMessage")
  private String returnMessage;

  @SerializedName("status")
  private String status;

  @SerializedName("subscription")
  private String subscription;

  @SerializedName("tid")
  private String tid;

  @SerializedName("Brand")
  private Brand brand;

  public String getAffiliation() {
    return affiliation;
  }

  public Authorization setAffiliation(String affiliation) {
    this.affiliation = affiliation;
    return this;
  }

  public double getAmount() {
    return (double) amount / 100;
  }

  public Authorization setAmount(int amount) {
    this.amount = amount;
    return this;
  }

  public String getAuthorizationCode() {
    return authorizationCode;
  }

  public Authorization setAuthorizationCode(String authorizationCode) {
    this.authorizationCode = authorizationCode;
    return this;
  }

  public String getCardBin() {
    return cardBin;
  }

  public Authorization setCardBin(String cardBin) {
    this.cardBin = cardBin;
    return this;
  }

  public String getCardHolderName() {
    return cardHolderName;
  }

  public Authorization setCardHolderName(String cardHolderName) {
    this.cardHolderName = cardHolderName;
    return this;
  }

  public String getDateTime() {
    return dateTime;
  }

  public Authorization setDateTime(String dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  public int getInstallments() {
    return installments;
  }

  public Authorization setInstallments(int installments) {
    this.installments = installments;
    return this;
  }

  public String getKind() {
    return kind;
  }

  public Authorization setKind(String kind) {
    this.kind = kind;
    return this;
  }

  public String getLast4() {
    return last4;
  }

  public Authorization setLast4(String last4) {
    this.last4 = last4;
    return this;
  }

  public String getNsu() {
    return nsu;
  }

  public Authorization setNsu(String nsu) {
    this.nsu = nsu;
    return this;
  }

  public String getOrigin() {
    return origin;
  }

  public Authorization setOrigin(String origin) {
    this.origin = origin;
    return this;
  }

  public String getReference() {
    return reference;
  }

  public Authorization setReference(String reference) {
    this.reference = reference;
    return this;
  }

  public String getReturnCode() {
    return returnCode;
  }

  public Authorization setReturnCode(String returnCode) {
    this.returnCode = returnCode;
    return this;
  }

  public String getReturnMessage() {
    return returnMessage;
  }

  public Authorization setReturnMessage(String returnMessage) {
    this.returnMessage = returnMessage;
    return this;
  }

  public String getStatus() {
    return status;
  }

  public Authorization setStatus(String status) {
    this.status = status;
    return this;
  }

  public String getSubscription() {
    return subscription;
  }

  public Authorization setSubscription(String subscription) {
    this.subscription = subscription;
    return this;
  }

  public String getTid() {
    return tid;
  }

  public Authorization setTid(String tid) {
    this.tid = tid;
    return this;
  }

  public Brand getBrand() {
	return brand;
  }

  public Authorization setBrand(Brand brand) {
	this.brand = brand;
	return this;
  }
}