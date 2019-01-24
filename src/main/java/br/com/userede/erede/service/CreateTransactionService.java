package br.com.userede.erede.service;

import br.com.userede.erede.Store;
import br.com.userede.erede.Transaction;
import com.google.gson.GsonBuilder;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.logging.Logger;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

public class CreateTransactionService extends AbstractTransactionService {

  public CreateTransactionService(Store store, Transaction transaction, Logger logger) {
    super(store, transaction, logger);
  }

  @Override
  public Transaction execute() {
    try {
      HttpPost request = new HttpPost(getUri().build());
      String entity = new GsonBuilder().create().toJson(transaction);

      request.setEntity(new StringEntity(entity));

      return sendRequest(request);
    } catch (URISyntaxException | UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    return null;
  }
}
