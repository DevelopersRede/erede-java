package br.com.userede.erede;

import br.com.userede.erede.service.CancelTransactionService;
import br.com.userede.erede.service.CaptureTransactionService;
import br.com.userede.erede.service.CreateTransactionService;
import br.com.userede.erede.service.GetTransactionService;
import java.util.logging.Logger;

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

  public Transaction authorize(Transaction transaction) {
    return create(transaction);
  }

  public Transaction create(Transaction transaction) {
    CreateTransactionService createTransactionService = new CreateTransactionService(store,
        transaction, logger);

    return createTransactionService.execute();
  }

  public Transaction cancel(Transaction transaction) {
    CancelTransactionService cancelTransactionService = new CancelTransactionService(store,
        transaction, logger);

    return cancelTransactionService.execute();
  }

  public Transaction capture(Transaction transaction) {
    CaptureTransactionService captureTransactionService = new CaptureTransactionService(store,
        transaction, logger);

    return captureTransactionService.execute();
  }

  public Transaction get(String tid) {
    GetTransactionService getTransactionService = new GetTransactionService(store, null, logger);
    getTransactionService.setTid(tid);

    return getTransactionService.execute();
  }

  public Transaction getByReference(String reference) {
    GetTransactionService getTransactionService = new GetTransactionService(store, null, logger);
    getTransactionService.setReference(reference);

    return getTransactionService.execute();
  }

  public Transaction getRefunds(String tid) {
    GetTransactionService getTransactionService = new GetTransactionService(store, null, logger);
    getTransactionService.setTid(tid);
    getTransactionService.setRefund(true);

    return getTransactionService.execute();
  }

  public Transaction zero(Transaction transaction) {
    Integer amount = transaction.getAmount();
    Boolean capture = transaction.getCapture();

    transaction.setAmount(0);
    transaction.capture();

    transaction = create(transaction);

    transaction.setAmount(amount);
    transaction.capture(capture);

    return transaction;


  }

}
