package br.com.userede.erede.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;

import br.com.userede.erede.Store;
import br.com.userede.erede.Transaction;
import br.com.userede.erede.TransactionResponse;
import br.com.userede.erede.service.error.RedeError;
import br.com.userede.erede.service.error.RedeException;

abstract class AbstractTransactionService {

  final Store store;
  final Transaction transaction;
  private String userAgent;

  private final Logger logger;

  AbstractTransactionService(Store store, Transaction transaction, Logger logger) {
    this.store = store;
    this.transaction = transaction;
    this.logger = logger;
  }

  public abstract TransactionResponse execute() throws URISyntaxException, IOException;

  URIBuilder getUri() throws URISyntaxException {
    return new URIBuilder(store.getEnvironment().getEndpoint("transactions"));
  }

	TransactionResponse sendRequest(HttpUriRequest request) throws IOException {
		String credentials = Base64.getEncoder().encodeToString(
				String.format("%s:%s", store.getFiliation(), store.getToken()).getBytes(StandardCharsets.US_ASCII));

		request.addHeader(HttpHeaders.USER_AGENT, this.userAgent);
		request.addHeader(HttpHeaders.ACCEPT, "application/json");
		request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		request.addHeader(HttpHeaders.AUTHORIZATION, "Basic " + credentials);
		if (store.getBrandReturnOpen()) {
			request.addHeader("Transaction-Response", "brand-return-opened");
		}

		System.out.println("line:" + request.getRequestLine().toString());
		logger.log(Level.FINE, request.getRequestLine().toString());

		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		int status = httpResponse.getStatusLine().getStatusCode();

		String response = parseResponse(httpResponse);
		TransactionResponse transactionResponse = new Gson().fromJson(response, TransactionResponse.class);

		if (status < 200 || status >= 400) {
			RedeError redeError = new RedeError(transactionResponse.getReturnCode(),
					transactionResponse.getReturnMessage() + " Original Request:" + request.getRequestLine().toString() + " Response: "
							+ response);

			throw new RedeException(httpResponse.getStatusLine().toString(), redeError, transactionResponse);
		}
		return transactionResponse;
	}

  private String parseResponse(HttpResponse response) throws IOException {
    HttpEntity responseEntity = response.getEntity();
    InputStream responseEntityContent = responseEntity.getContent();

    Header contentEncoding = response.getFirstHeader("Content-Encoding");

    if (contentEncoding != null && contentEncoding.getValue().equalsIgnoreCase("gzip")) {
      responseEntityContent = new GZIPInputStream(responseEntityContent);
    }

    BufferedReader responseReader = new BufferedReader(
        new InputStreamReader(responseEntityContent));
    StringBuilder responseBuilder = new StringBuilder();
    String line;

    while ((line = responseReader.readLine()) != null) {
      responseBuilder.append(line);
    }

    return responseBuilder.toString();
  }

  public void setUserAgent(String userAgent) {
	this.userAgent = userAgent;
  }

}
