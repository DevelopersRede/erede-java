package br.com.userede.erede;

public class Transaction extends AbstractTransaction<Boolean> {

  public static final String CREDIT = "credit";
  public static final String DEBIT = "debit";

  public static final Integer ORIGIN_EREDE = 1;
  public static final Integer ORIGIN_VISA_CHECKOUT = 4;
  public static final Integer ORIGIN_MASTERPASS = 6;

  public Transaction(double amount, String reference) {
    setAmount(amount);
    setReference(reference);
  }

  public Transaction(int amount, String reference) {
    setAmount(amount);
    setReference(reference);
  }

  public Transaction capture() {
    return capture(true);
  }

  public Transaction capture(Boolean capture) {
    if (!capture && getKind().equals(Transaction.DEBIT)) {
      throw new IllegalArgumentException("Debit transactions will always be captured");
    }

    setCapture(capture);

    return this;
  }

  public Transaction debitCard(String cardNumber, String securityCode, String expirationMonth,
      String expirationYear, String cardHolderName) {

    setCard(cardNumber, securityCode, expirationMonth, expirationYear, cardHolderName,
        Transaction.DEBIT);

    ThreeDSecure threeDSecure = new ThreeDSecure();
    threeDSecure.setEmbedded(true);
    threeDSecure.setOnFailure(ThreeDSecure.DECLINE_ON_FAILURE);

    setCapture(true);
    setThreeDSecure(threeDSecure);

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
