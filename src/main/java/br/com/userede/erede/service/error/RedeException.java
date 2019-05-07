package br.com.userede.erede.service.error;

import br.com.userede.erede.TransactionResponse;

public class RedeException extends RuntimeException {

  private RedeError redeError;
  private TransactionResponse transactionResponse;

  public RedeException(String message, RedeError redeError,
      TransactionResponse transactionResponse) {
    super(message);

    this.redeError = redeError;
    this.transactionResponse = transactionResponse;
  }

  public RedeError getRedeError() {
    return this.redeError;
  }

  public TransactionResponse getTransaction() {
    return this.transactionResponse;
  }

}
