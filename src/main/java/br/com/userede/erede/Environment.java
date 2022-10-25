package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class Environment {

    private static final String PRODUCTION = "https://api.userede.com.br/erede";
    private static final String SANDBOX = "https://api.userede.com.br/desenvolvedores";
    private static final String VERSION = "v1";

    @SerializedName("ip")
    private String ip;

    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("endpoint")
    private String endpoint;

    public Environment(String baseUrl) {
        endpoint = String.format("%s/%s/", baseUrl, Environment.VERSION);
    }

    public static Environment production() {
        return new Environment(Environment.PRODUCTION);
    }

    public static Environment sandbox() {
        return new Environment(Environment.SANDBOX);
    }

    public String getIp() {
        return ip;
    }

    public Environment setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getSessionId() {
        return sessionId;
    }

    public Environment setSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public String getEndpoint(String service) {
        return endpoint + service;
    }

    public Environment setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }
}
