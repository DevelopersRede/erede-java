package br.com.userede.erede;

public class Store {

    private Environment environment;
    private String filiation;
    private String token;

    public Store(String filiation, String token, Environment environment) {
        this.environment = environment;
        this.filiation = filiation;
        this.token = token;
    }

    public Store(String filiation, String token) {
        this(filiation, token, Environment.production());
    }

    public Environment getEnvironment() {
        return environment;
    }

    public Store setEnvironment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public String getFiliation() {
        return filiation;
    }

    public Store setFiliation(String filiation) {
        this.filiation = filiation;
        return this;
    }

    public String getToken() {
        return token;
    }

    public Store setToken(String token) {
        this.token = token;
        return this;
    }
}
