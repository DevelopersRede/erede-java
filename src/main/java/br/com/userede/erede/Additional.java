package br.com.userede.erede;

public class Additional {

  private String gateway;
  private String module;

  public Additional(String gateway, String module) {
    setGateway(gateway);
    setModule(module);
  }

  public String getGateway() {
    return gateway;
  }

  public Additional setGateway(String gateway) {
    this.gateway = gateway;
    return this;
  }

  public String getModule() {
    return module;
  }

  public Additional setModule(String module) {
    this.module = module;
    return this;
  }
}
