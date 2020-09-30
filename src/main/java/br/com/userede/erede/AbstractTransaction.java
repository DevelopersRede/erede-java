package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class AbstractTransaction<C> {

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
  private C capture;
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
  @SerializedName("links")
  private List<Link> links;

  @SerializedName("SubMerchant")
  private SubMerchant submerchant;

  @SerializedName("PaymentFacilitatorID")
  private Long paymentFacilitatorID;

  @SerializedName("IndependentSalesOrganizationID")
  private String independentSalesOrganizationID;

  private void prepareUrls() {
    if (urls == null) {
      urls = new ArrayList<>();
    }
  }

  public AbstractTransaction<C> addUrl(Url url) {
    prepareUrls();

    this.urls.add(url);

    return this;
  }

  public AbstractTransaction<C> addUrl(String url) {
    return addUrl(new Url(url));
  }

  public AbstractTransaction<C> addUrl(String url, String kind) {
    return addUrl(new Url(url, kind));
  }

  public AbstractTransaction<C> additional(String gateway, String module) {
    additional = new Additional(gateway, module);

    return this;
  }

  public Additional getAdditional() {
    return additional;
  }

  public AbstractTransaction<C> setAdditional(Additional additional) {
    this.additional = additional;
    return this;
  }

  public double getAmount() {
    return (double) amount / 100;
  }

  public AbstractTransaction<C> setAmount(double amount) {
    this.amount = (int) Math.round(amount * 100);
    return this;
  }

  public AbstractTransaction<C> setAmount(Integer amount) {
    this.amount = amount;
    return this;
  }

  public Antifraud getAntifraud() {
    return antifraud;
  }

  public AbstractTransaction<C> setAntifraud(Antifraud antifraud) {
    this.antifraud = antifraud;
    return this;
  }

  public Boolean getAntifraudRequired() {
    return antifraudRequired;
  }

  public AbstractTransaction<C> setAntifraudRequired(Boolean antifraudRequired) {
    this.antifraudRequired = antifraudRequired;
    return this;
  }

  public Authorization getAuthorization() {
    return authorization;
  }

  public AbstractTransaction<C> setAuthorization(Authorization authorization) {
    this.authorization = authorization;
    return this;
  }

  public String getAuthorizationCode() {
    return authorizationCode;
  }

  public AbstractTransaction<C> setAuthorizationCode(String authorizationCode) {
    this.authorizationCode = authorizationCode;
    return this;
  }

  public String getCancelId() {
    return cancelId;
  }

  public AbstractTransaction<C> setCancelId(String cancelId) {
    this.cancelId = cancelId;
    return this;
  }

  public C getCapture() {
    return capture;
  }

  public AbstractTransaction<C> setCapture(C capture) {
    this.capture = capture;
    return this;
  }

  public String getCardBin() {
    return cardBin;
  }

  public AbstractTransaction<C> setCardBin(String cardBin) {
    this.cardBin = cardBin;
    return this;
  }

  public String getCardHolderName() {
    return cardHolderName;
  }

  public AbstractTransaction<C> setCardHolderName(String cardHolderName) {
    this.cardHolderName = cardHolderName;
    return this;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public AbstractTransaction<C> setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
    return this;
  }

  public Cart getCart() {
    return cart;
  }

  public AbstractTransaction<C> setCart(Cart cart) {
    this.cart = cart;
    return this;
  }

  public String getDateTime() {
    return dateTime;
  }

  public AbstractTransaction<C> setDateTime(String dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  public Integer getDistributorAffiliation() {
    return distributorAffiliation;
  }

  public AbstractTransaction<C> setDistributorAffiliation(Integer distributorAffiliation) {
    this.distributorAffiliation = distributorAffiliation;
    return this;
  }

  public String getExpirationMonth() {
    return expirationMonth;
  }

  public AbstractTransaction<C> setExpirationMonth(String expirationMonth) {
    this.expirationMonth = expirationMonth;
    return this;
  }

  public String getExpirationYear() {
    return expirationYear;
  }

  public AbstractTransaction<C> setExpirationYear(String expirationYear) {
    this.expirationYear = expirationYear;
    return this;
  }

  public Iata getIata() {
    return iata;
  }

  public AbstractTransaction<C> setIata(Iata iata) {
    this.iata = iata;
    return this;
  }

  public Integer getInstallments() {
    return installments;
  }

  public AbstractTransaction<C> setInstallments(Integer installments) {
    this.installments = installments;
    return this;
  }

  public String getKind() {
    return kind;
  }

  public AbstractTransaction<C> setKind(String kind) {
    this.kind = kind;
    return this;
  }

  public String getLast4() {
    return last4;
  }

  public AbstractTransaction<C> setLast4(String last4) {
    this.last4 = last4;
    return this;
  }

  public String getNsu() {
    return nsu;
  }

  public AbstractTransaction<C> setNsu(String nsu) {
    this.nsu = nsu;
    return this;
  }

  public Integer getOrigin() {
    return origin;
  }

  public AbstractTransaction<C> setOrigin(Integer origin) {
    this.origin = origin;
    return this;
  }

  public String getReference() {
    return reference;
  }

  public AbstractTransaction<C> setReference(String reference) {
    this.reference = reference;
    return this;
  }

  public String getRefundDateTime() {
    return refundDateTime;
  }

  public AbstractTransaction<C> setRefundDateTime(String refundDateTime) {
    this.refundDateTime = refundDateTime;
    return this;
  }

  public String getRefundId() {
    return refundId;
  }

  public AbstractTransaction<C> setRefundId(String refundId) {
    this.refundId = refundId;
    return this;
  }

  public List<Refund> getRefunds() {
    return refunds;
  }

  public AbstractTransaction<C> setRefunds(List<Refund> refunds) {
    this.refunds = refunds;
    return this;
  }

  public String getRequestDateTime() {
    return requestDateTime;
  }

  public AbstractTransaction<C> setRequestDateTime(String requestDateTime) {
    this.requestDateTime = requestDateTime;
    return this;
  }

  public String getReturnCode() {
    return returnCode;
  }

  public AbstractTransaction<C> setReturnCode(String returnCode) {
    this.returnCode = returnCode;
    return this;
  }

  public String getReturnMessage() {
    return returnMessage;
  }

  public AbstractTransaction<C> setReturnMessage(String returnMessage) {
    this.returnMessage = returnMessage;
    return this;
  }

  public String getSecurityCode() {
    return securityCode;
  }

  public AbstractTransaction<C> setSecurityCode(String securityCode) {
    this.securityCode = securityCode;
    return this;
  }

  public String getSoftDescriptor() {
    return softDescriptor;
  }

  public AbstractTransaction<C> setSoftDescriptor(String softDescriptor) {
    this.softDescriptor = softDescriptor;
    return this;
  }

  public Integer getStorageCard() {
    return storageCard;
  }

  public AbstractTransaction<C> setStorageCard(Integer storageCard) {
    this.storageCard = storageCard;
    return this;
  }

  public Boolean getSubscription() {
    return subscription;
  }

  public AbstractTransaction<C> setSubscription(Boolean subscription) {
    this.subscription = subscription;
    return this;
  }

  public ThreeDSecure getThreeDSecure() {
    return threeDSecure;
  }

  public AbstractTransaction<C> setThreeDSecure(ThreeDSecure threeDSecure) {
    this.threeDSecure = threeDSecure;
    return this;
  }

  public String getTid() {
    return tid;
  }

  public AbstractTransaction<C> setTid(String tid) {
    this.tid = tid;
    return this;
  }

  public List<Url> getUrls() {
    return urls;
  }

  public AbstractTransaction<C> setUrls(List<Url> urls) {
    this.urls = urls;
    return this;
  }

  public List<Link> getLinks() {
    return links;
  }

  public AbstractTransaction<C> setLinks(List<Link> links) {
    this.links = links;
    return this;
  }

	public SubMerchant getSubmerchant() {
		return submerchant;
	}

	public AbstractTransaction<C> setSubmerchant(SubMerchant submerchant) {
		this.submerchant = submerchant;
		return this;
	}

	public Long getPaymentFacilitatorID() {
		return paymentFacilitatorID;
	}

	public AbstractTransaction<C> setPaymentFacilitatorID(Long paymentFacilitatorID) {
		this.paymentFacilitatorID = paymentFacilitatorID;
		return this;
	}

	public String getIndependentSalesOrganizationID() {
		return independentSalesOrganizationID;
	}

	public AbstractTransaction<C> setIndependentSalesOrganizationID(String independentSalesOrganizationID) {
		this.independentSalesOrganizationID = independentSalesOrganizationID;
		return this;
	}

}
