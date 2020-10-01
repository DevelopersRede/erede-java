package br.com.userede.erede.service;

import br.com.userede.erede.Store;
import br.com.userede.erede.Transaction;
import br.com.userede.erede.TransactionResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

public class GetTransactionService extends AbstractTransactionService {

  private String reference;
  private String tid;
  private Boolean refund = false;

  public GetTransactionService(Store store,
      Transaction transaction, Logger logger) {
    super(store, transaction, logger);
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public void setRefund(Boolean refund) {
    this.refund = refund;
  }

  public void setTid(String tid) {
    this.tid = tid;
  }

  @Override
  public URIBuilder getUri() throws URISyntaxException {
    URIBuilder uriBuilder = super.getUri();

    if (reference != null) {
      return uriBuilder.setParameter("reference", reference);
    }

    if (refund) {
      return uriBuilder.setPath(String.format("%s/%s/refunds", uriBuilder.getPath(), tid));
    }

    return uriBuilder.setPath(String.format("%s/%s", uriBuilder.getPath(), tid));
  }

  @Override
  public TransactionResponse execute() throws IOException, URISyntaxException {
      HttpGet request = new HttpGet(getUri().build());
      return sendRequest(request);
  }
}
