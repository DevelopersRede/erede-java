package br.com.userede.erede;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

import com.google.gson.Gson;

public class TestErede {

	public static void main(String[] args) throws URISyntaxException, IOException {
		// Replace "PV" and "token"
		Store store = new Store("PV", "TOKEN", Environment.sandbox());
		
		// Ativa retorno das bandeiras.
		store.setBrandReturnOpen(true);
		Gson gson = new Gson();

		// Transação que será autorizada
		Integer randnum = new Random().nextInt(10000 - 100) + 100;
		Transaction transaction = new Transaction(20.99, "pedido" + randnum.toString());
		transaction.creditCard("5448280000000007", "123", "12", "2020", "Jhon James Rambo");

		System.out.println("Transação original: \n" + gson.toJson(transaction));

		// Autoriza a transação
		TransactionResponse transactionResp;
		transactionResp = (new eRede(store).create(transaction));

		if (transactionResp.getReturnCode().equals("00")) {
			System.out.printf("Transação autorizada com sucesso: %s\n", transactionResp.getTid());
		}

		// Consulta a transação
		TransactionResponse transactionResponse = (new eRede(store).get(transactionResp.getTid()));
		System.out.println("Consulta:\n" + gson.toJson(transactionResponse));
	}
}
