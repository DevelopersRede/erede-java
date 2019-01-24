package br.com.userede.erede.service;

import br.com.userede.erede.Store;
import br.com.userede.erede.Transaction;
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
  public Transaction execute() {
    try {
      String uri = store.getEnvironment().getEndpoint("transactions");
      URIBuilder uriBuilder;

      if (refund) {
        uri = String.format("%s/%s/refunds", uri, tid);
      }

      uriBuilder = new URIBuilder(uri);

      if (reference != null) {
        uriBuilder.setParameter("reference", reference);
      }

      HttpGet request = new HttpGet(uriBuilder.build());

      return sendRequest(request);
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    return null;
  }
}
