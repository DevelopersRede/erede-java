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

        if (this.threeDSecure == null) {
            this.threeDSecure = new ThreeDSecure();
        }

        threeDSecure.setEmbedded(true);
        threeDSecure.setOnFailure(ThreeDSecure.DECLINE_ON_FAILURE);

        setCapture(true);
        setThreeDSecure(threeDSecure);

        return this;
    }

    public Transaction creditCard(String cardNumber, String securityCode, String expirationMonth,
                                  String expirationYear, String cardHolderName) {
        setCard(cardNumber, securityCode, expirationMonth, expirationYear, cardHolderName,
                Transaction.CREDIT);

        setCapture(true);

        return this;
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

    public Transaction threeDSecure(Device device) {
        return threeDSecure(device, ThreeDSecure.DECLINE_ON_FAILURE);
    }

    public Transaction threeDSecure(Device device, String onFailure) {
        return threeDSecure(device, onFailure, ThreeDSecure.MPI_REDE);
    }

    public Transaction threeDSecure(Device device, String onFailure, String mpi) {
        return threeDSecure(device, onFailure, mpi, "", null);
    }

    public Transaction threeDSecure(
            Device device,
            String onFailure,
            String mpi,
            String directoryServerTransactionId,
            String userAgent
    ) {
        if (this.threeDSecure == null) {
            threeDSecure = new ThreeDSecure(device);
        } else {
            threeDSecure.setDevice(device);
        }

        threeDSecure.setDirectoryServerTransactionId(directoryServerTransactionId);
        threeDSecure.setOnFailure(onFailure);
        threeDSecure.setEmbedded(mpi.equals(ThreeDSecure.MPI_REDE));
        threeDSecure.setUserAgent(userAgent);

        setThreeDSecure(threeDSecure);

        return this;
    }
}
