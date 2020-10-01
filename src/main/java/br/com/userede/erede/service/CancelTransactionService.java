package br.com.userede.erede.service;

import br.com.userede.erede.Store;
import br.com.userede.erede.Transaction;
import br.com.userede.erede.TransactionResponse;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;

public class CancelTransactionService extends AbstractTransactionService {

  public CancelTransactionService(Store store, Transaction transaction,
      Logger logger) {
    super(store, transaction, logger);
  }

  @Override
  public URIBuilder getUri() throws URISyntaxException {
    URIBuilder uriBuilder = super.getUri();

    return uriBuilder
        .setPath(String.format("%s/%s/refunds", uriBuilder.getPath(), transaction.getTid()));
  }

  @Override
  public TransactionResponse execute() throws IOException, URISyntaxException {
    HttpPost request = new HttpPost(getUri().build());
    String entity = new GsonBuilder().create().toJson(transaction);
    request.setEntity(new StringEntity(entity));
    return sendRequest(request);
  }
}
