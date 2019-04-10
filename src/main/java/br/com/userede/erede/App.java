package br.com.userede.erede;

import java.nio.charset.Charset;
import java.util.Random;

/**
 * Hello world!
 */
public class App {

  public static String randOrder(String base) {
    return base + new Random().nextInt();
  }

  public static void main(String[] args) {
    Environment environment = Environment.sandbox();
    Store store = new Store("10000850", "eb3c322b84ff475c95abb16673659664", environment);
    Transaction transaction = new Transaction(20.99, App.randOrder("p"))
        .creditCard(
            "5448280000000007",
            "123",
            "12",
            "2020",
            "Fulano de Tal"
        ).capture(false);

    transaction = (new eRede(store).create(transaction));

    if (transaction.getReturnCode().equals("00")) {
      System.out.printf("Transação autorizada com sucesso: %s\n", transaction.getTid());

      transaction = (new eRede(store)).capture(transaction);

      transaction = new Transaction(20.99, transaction.getReference()).setTid(transaction.getTid());

      transaction = (new eRede(store)).cancel(transaction);



      System.out.println(transaction.getTid());
    }
  }
}
