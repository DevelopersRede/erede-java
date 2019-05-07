package br.com.userede.erede.service.error;

public class RedeError {

  private String returnCode;
  private String returnMessage;

  public RedeError(String returnCode, String returnMessage) {
    this.returnCode = returnCode;
    this.returnMessage = returnMessage;
  }

  public String getReturnCode() {
    return returnCode;
  }

  public String getReturnMessage() {
    return returnMessage;
  }
}
