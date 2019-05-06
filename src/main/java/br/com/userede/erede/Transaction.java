package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Transaction {

  public static final String CREDIT = "credit";
  public static final String DEBIT = "debit";

  public static final Integer ORIGIN_EREDE = 1;
  public static final Integer ORIGIN_VISA_CHECKOUT = 4;
  public static final Integer ORIGIN_MASTERPASS = 6;

  @SerializedName("additional")
  private Additional additional;
  @SerializedName("amount")
  private Integer amount;
  @SerializedName("antifraud")
  private Antifraud antifraud;
  @SerializedName("antifraudRequired")
  private Boolean antifraudRequired;
  @SerializedName("authorization")
  private Authorization authorization;
  @SerializedName("authorizationCode")
  private String authorizationCode;
  @SerializedName("cancelId")
  private String cancelId;
  @SerializedName("capture")
  private Boolean capture;
  @SerializedName("cardBin")
  private String cardBin;
  @SerializedName("cardHolderName")
  private String cardHolderName;
  @SerializedName("cardNumber")
  private String cardNumber;
  @SerializedName("cart")
  private Cart cart;
  @SerializedName("dateTime")
  private String dateTime;
  @SerializedName("distributorAffiliation")
  private Integer distributorAffiliation;
  @SerializedName("expirationMonth")
  private String expirationMonth;
  @SerializedName("expirationYear")
  private String expirationYear;
  @SerializedName("iata")
  private Iata iata;
  @SerializedName("installments")
  private Integer installments;
  @SerializedName("kind")
  private String kind;
  @SerializedName("last4")
  private String last4;
  @SerializedName("nsu")
  private String nsu;
  @SerializedName("origin")
  private Integer origin;
  @SerializedName("reference")
  private String reference;
  @SerializedName("refundDateTime")
  private String refundDateTime;
  @SerializedName("refundId")
  private String refundId;
  @SerializedName("refunds")
  private List<Refund> refunds;
  @SerializedName("requestDateTime")
  private String requestDateTime;
  @SerializedName("returnCode")
  private String returnCode;
  @SerializedName("returnMessage")
  private String returnMessage;
  @SerializedName("securityCode")
  private String securityCode;
  @SerializedName("softDescriptor")
  private String softDescriptor;
  @SerializedName("storageCard")
  private Integer storageCard;
  @SerializedName("subscription")
  private Boolean subscription;
  @SerializedName("threeDSecure")
  private ThreeDSecure threeDSecure;
  @SerializedName("tid")
  private String tid;
  @SerializedName("urls")
  private List<Url> urls;

  public Transaction(double amount, String reference) {
    this((int) Math.round(amount * 100), reference);
  }

  public Transaction(int amount, String reference) {
    this.amount = amount;
    this.reference = reference;
  }

  private void prepareUrls() {
    if (urls == null) {
      urls = new ArrayList<>();
    }
  }

  public Transaction addUrl(Url url) {
    prepareUrls();

    this.urls.add(url);

    return this;
  }

  public Transaction additional(String gateway, String module) {
    additional = new Additional(gateway, module);

    return this;
  }

  public Additional getAdditional() {
    return additional;
  }

  public Transaction addUrl(String url) {
    return addUrl(url, Url.CALLBACK);
  }

  public Transaction addUrl(String url, String type) {
    return addUrl(new Url(url, type));
  }

  public Transaction capture() {
    return capture(true);
  }

  public Transaction capture(Boolean capture) {
    if (!capture && kind.equals(Transaction.DEBIT)) {
      throw new IllegalArgumentException("Debit transactions will always be captured");
    }

    this.capture = capture;

    return this;
  }

  public Integer getAmount() {
    return amount;
  }

  public Transaction setAmount(Integer amount) {
    this.amount = amount;
    return this;
  }

  public Antifraud getAntifraud() {
    return antifraud;
  }

  public Transaction setAntifraud(Antifraud antifraud) {
    this.antifraud = antifraud;
    return this;
  }

  public Boolean getAntifraudRequired() {
    return antifraudRequired;
  }

  public Transaction setAntifraudRequired(Boolean antifraudRequired) {
    this.antifraudRequired = antifraudRequired;
    return this;
  }

  public Authorization getAuthorization() {
    return authorization;
  }

  public Transaction setAuthorization(Authorization authorization) {
    this.authorization = authorization;
    return this;
  }

  public String getAuthorizationCode() {
    return authorizationCode;
  }

  public Transaction setAuthorizationCode(String authorizationCode) {
    this.authorizationCode = authorizationCode;
    return this;
  }

  public String getCancelId() {
    return cancelId;
  }

  public Transaction setCancelId(String cancelId) {
    this.cancelId = cancelId;
    return this;
  }

  public Boolean getCapture() {
    return capture;
  }

  public Transaction setCapture(Boolean capture) {
    this.capture = capture;
    return this;
  }

  public String getCardBin() {
    return cardBin;
  }

  public Transaction setCardBin(String cardBin) {
    this.cardBin = cardBin;
    return this;
  }

  public String getCardHolderName() {
    return cardHolderName;
  }

  public Transaction setCardHolderName(String cardHolderName) {
    this.cardHolderName = cardHolderName;
    return this;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public Transaction setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
    return this;
  }

  public Cart getCart() {
    return cart;
  }

  public Transaction setCart(Cart cart) {
    this.cart = cart;
    return this;
  }

  public String getDateTime() {
    return dateTime;
  }

  public Transaction setDateTime(String dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  public Integer getDistributorAffiliation() {
    return distributorAffiliation;
  }

  public Transaction setDistributorAffiliation(Integer distributorAffiliation) {
    this.distributorAffiliation = distributorAffiliation;
    return this;
  }

  public String getExpirationMonth() {
    return expirationMonth;
  }

  public Transaction setExpirationMonth(String expirationMonth) {
    this.expirationMonth = expirationMonth;
    return this;
  }

  public String getExpirationYear() {
    return expirationYear;
  }

  public Transaction setExpirationYear(String expirationYear) {
    this.expirationYear = expirationYear;
    return this;
  }

  public Iata getIata() {
    return iata;
  }

  public Transaction setIata(Iata iata) {
    this.iata = iata;
    return this;
  }

  public Integer getInstallments() {
    return installments;
  }

  public Transaction setInstallments(Integer installments) {
    this.installments = installments;
    return this;
  }

  public String getKind() {
    return kind;
  }

  public Transaction setKind(String kind) {
    this.kind = kind;
    return this;
  }

  public String getLast4() {
    return last4;
  }

  public Transaction setLast4(String last4) {
    this.last4 = last4;
    return this;
  }

  public String getNsu() {
    return nsu;
  }

  public Transaction setNsu(String nsu) {
    this.nsu = nsu;
    return this;
  }

  public Integer getOrigin() {
    return origin;
  }

  public Transaction setOrigin(Integer origin) {
    this.origin = origin;
    return this;
  }

  public String getReference() {
    return reference;
  }

  public Transaction setReference(String reference) {
    this.reference = reference;
    return this;
  }

  public String getRefundDateTime() {
    return refundDateTime;
  }

  public Transaction setRefundDateTime(String refundDateTime) {
    this.refundDateTime = refundDateTime;
    return this;
  }

  public String getRefundId() {
    return refundId;
  }

  public Transaction setRefundId(String refundId) {
    this.refundId = refundId;
    return this;
  }

  public String getRequestDateTime() {
    return requestDateTime;
  }

  public Transaction setRequestDateTime(String requestDateTime) {
    this.requestDateTime = requestDateTime;
    return this;
  }

  public String getReturnCode() {
    return returnCode;
  }

  public Transaction setReturnCode(String returnCode) {
    this.returnCode = returnCode;
    return this;
  }

  public String getReturnMessage() {
    return returnMessage;
  }

  public Transaction setReturnMessage(String returnMessage) {
    this.returnMessage = returnMessage;
    return this;
  }

  public String getSecurityCode() {
    return securityCode;
  }

  public Transaction setSecurityCode(String securityCode) {
    this.securityCode = securityCode;
    return this;
  }

  public String getSoftDescriptor() {
    return softDescriptor;
  }

  public Transaction setSoftDescriptor(String softDescriptor) {
    this.softDescriptor = softDescriptor;
    return this;
  }

  public Integer getStorageCard() {
    return storageCard;
  }

  public Transaction setStorageCard(Integer storageCard) {
    this.storageCard = storageCard;
    return this;
  }

  public Boolean getSubscription() {
    return subscription;
  }

  public Transaction setSubscription(Boolean subscription) {
    this.subscription = subscription;
    return this;
  }

  public ThreeDSecure getThreeDSecure() {
    return threeDSecure;
  }

  public Transaction setThreeDSecure(ThreeDSecure threeDSecure) {
    this.threeDSecure = threeDSecure;
    return this;
  }

  public String getTid() {
    return tid;
  }

  public Transaction setTid(String tid) {
    this.tid = tid;
    return this;
  }

  public Cart cart() {
    return cart(false);
  }

  public Cart cart(Boolean antifraud) {
    return cart(antifraud, Environment.production());
  }

  public Cart cart(Boolean antifraud, Environment environment) {
    Cart cart = new Cart();
    cart.setEnvironment(environment);

    setAntifraudRequired(antifraud);
    setCart(cart);

    return cart;
  }

  public Transaction debitCard(String cardNumber, String securityCode, String expirationMonth,
      String expirationYear, String cardHolderName) {

    setCard(cardNumber, securityCode, expirationMonth, expirationYear, cardHolderName,
        Transaction.DEBIT);

    capture = true;
    threeDSecure = new ThreeDSecure();
    threeDSecure.setEmbedded(true);
    threeDSecure.setOnFailure(ThreeDSecure.DECLINE_ON_FAILURE);

    return this;
  }

  public Transaction creditCard(String cardNumber, String securityCode, String expirationMonth,
      String expirationYear, String cardHolderName) {
    return setCard(cardNumber, securityCode, expirationMonth, expirationYear, cardHolderName,
        Transaction.CREDIT);
  }

  public Transaction setCard(String cardNumber, String securityCode, String expirationMonth,
      String expirationYear, String cardHolderName, String kind) {
    setCardNumber(cardNumber);
    setSecurityCode(securityCode);
    setExpirationMonth(expirationMonth);
    setExpirationYear(expirationYear);
    setCardHolderName(cardHolderName);
    setKind(kind);

    return this;
  }
}
