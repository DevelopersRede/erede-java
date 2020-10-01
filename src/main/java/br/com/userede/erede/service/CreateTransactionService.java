package br.com.userede.erede.service;

import br.com.userede.erede.Store;
import br.com.userede.erede.Transaction;
import br.com.userede.erede.TransactionResponse;
import java.io.IOException;
import com.google.gson.GsonBuilder;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;


public class CreateTransactionService extends AbstractTransactionService {

  public CreateTransactionService(Store store, Transaction transaction, Logger logger) {
    super(store, transaction, logger);
  }

  @Override
  public TransactionResponse execute() throws URISyntaxException, IOException {
    HttpPost request;
    request = new HttpPost(getUri().build());
    String entity = new GsonBuilder().create().toJson(transaction);
    request.setEntity(new StringEntity(entity, StandardCharsets.UTF_8));
    return sendRequest(request);
  }
}
