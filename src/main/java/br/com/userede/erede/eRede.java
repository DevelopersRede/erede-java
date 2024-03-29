package br.com.userede.erede;

import br.com.userede.erede.service.CancelTransactionService;
import br.com.userede.erede.service.CaptureTransactionService;
import br.com.userede.erede.service.CreateTransactionService;
import br.com.userede.erede.service.GetTransactionService;

import java.util.logging.Logger;

public class eRede {

    public static final String VERSION = "1.2.0";
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

    public TransactionResponse authorize(Transaction transaction) {
        return create(transaction);
    }

    public TransactionResponse create(Transaction transaction) {
        CreateTransactionService createTransactionService = new CreateTransactionService(store,
                transaction, logger);

        return createTransactionService.execute();
    }

    public TransactionResponse cancel(Transaction transaction) {
        CancelTransactionService cancelTransactionService = new CancelTransactionService(store,
                transaction, logger);

        return cancelTransactionService.execute();
    }

    public TransactionResponse capture(Transaction transaction) {
        CaptureTransactionService captureTransactionService = new CaptureTransactionService(store,
                transaction, logger);

        return captureTransactionService.execute();
    }

    public TransactionResponse get(String tid) {
        GetTransactionService getTransactionService = new GetTransactionService(store, null, logger);
        getTransactionService.setTid(tid);

        return getTransactionService.execute();
    }

    public TransactionResponse getByReference(String reference) {
        GetTransactionService getTransactionService = new GetTransactionService(store, null, logger);
        getTransactionService.setReference(reference);

        return getTransactionService.execute();
    }

    public TransactionResponse getRefunds(String tid) {
        GetTransactionService getTransactionService = new GetTransactionService(store, null, logger);
        getTransactionService.setTid(tid);
        getTransactionService.setRefund(true);

        return getTransactionService.execute();
    }

    public TransactionResponse zero(Transaction transaction) {
        transaction.setAmount(0);
        transaction.capture();

        return create(transaction);
    }

}
