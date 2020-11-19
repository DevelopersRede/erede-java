package br.com.userede.erede;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import br.com.userede.erede.service.CancelTransactionService;
import br.com.userede.erede.service.CaptureTransactionService;
import br.com.userede.erede.service.CreateTransactionService;
import br.com.userede.erede.service.GetTransactionService;

public class eRede {

  public static final String VERSION = "1.1.0";
  public static final String ARTIFACT_ID = "br.com.userede.erede";
  public static final String USER_AGENT = "eRede/" + eRede.VERSION + " (Java; %s)";

  private final Store store;
  private final Logger logger;

  public eRede(Store store) {
    this(store, Logger.getLogger(eRede.ARTIFACT_ID));
  }

  public eRede(Store store, Logger logger) {
    this.store = store;
    this.logger = logger;
  }

  public TransactionResponse authorize(Transaction transaction) throws URISyntaxException, IOException {
    return create(transaction);
  }

  public TransactionResponse create(Transaction transaction) throws URISyntaxException, IOException {
    CreateTransactionService createTransactionService = new CreateTransactionService(store,
        transaction, logger);
    createTransactionService.setUserAgent(String.format(eRede.USER_AGENT, store.getFiliation()));

    return createTransactionService.execute();
  }

  public TransactionResponse cancel(Transaction transaction) throws IOException, URISyntaxException {
    CancelTransactionService cancelTransactionService = new CancelTransactionService(store,
        transaction, logger);
    cancelTransactionService.setUserAgent(String.format(eRede.USER_AGENT, store.getFiliation()));

    return cancelTransactionService.execute();
  }

  public TransactionResponse capture(Transaction transaction) throws IOException, URISyntaxException {
    CaptureTransactionService captureTransactionService = new CaptureTransactionService(store,
        transaction, logger);
    captureTransactionService.setUserAgent(String.format(eRede.USER_AGENT, store.getFiliation()));

    return captureTransactionService.execute();
  }

  public TransactionResponse get(String tid) throws IOException, URISyntaxException {
    GetTransactionService getTransactionService = new GetTransactionService(store, null, logger);
    getTransactionService.setTid(tid);
    getTransactionService.setUserAgent(String.format(eRede.USER_AGENT, store.getFiliation()));

    return getTransactionService.execute();
  }

  public TransactionResponse getByReference(String reference) throws IOException, URISyntaxException {
    GetTransactionService getTransactionService = new GetTransactionService(store, null, logger);
    getTransactionService.setReference(reference);
    getTransactionService.setUserAgent(String.format(eRede.USER_AGENT, store.getFiliation()));

    return getTransactionService.execute();
  }

  public TransactionResponse getRefunds(String tid) throws IOException, URISyntaxException {
    GetTransactionService getTransactionService = new GetTransactionService(store, null, logger);
    getTransactionService.setTid(tid);
    getTransactionService.setRefund(true);
    getTransactionService.setUserAgent(String.format(eRede.USER_AGENT, store.getFiliation()));

    return getTransactionService.execute();
  }

  public TransactionResponse zero(Transaction transaction) throws Exception {
    transaction.setAmount(0);
    transaction.capture();

    return create(transaction);
  }

}
