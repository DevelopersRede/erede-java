package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {

    @SerializedName("billing")
    private Address billing;

    @SerializedName("customer")
    private Customer customer;

    @SerializedName("environment")
    private Environment environment;

    @SerializedName("iata")
    private Iata iata;

    @SerializedName("items")
    private List<Item> items;

    @SerializedName("shipping")
    private List<Address> shipping;

    private void prepareItems() {
        if (items == null) {
            items = new ArrayList<>();
        }
    }

    public Cart addItem(Item item) {
        prepareItems();

        items.add(item);

        return this;
    }

    public Address address() {
        return address(Address.BOTH);
    }

    public Address address(int type) {
        Address address = new Address();

        if ((type & Address.BILLING) == Address.BILLING) {
            setBillingAddress(address);
        }

        if ((type & Address.SHIPPING) == Address.SHIPPING) {
            setShippingAddress(address);
        }

        return address;
    }

    public Iterator<Item> getItemIterator() {
        prepareItems();

        return items.iterator();
    }

    public Address getBilling() {
        return billing;
    }

    public Cart setBilling(Address billing) {
        this.billing = billing;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Cart setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public Cart setEnvironment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public Iata getIata() {
        return iata;
    }

    public Cart setIata(Iata iata) {
        this.iata = iata;
        return this;
    }

    public Cart setBillingAddress(Address billing) {
        this.billing = billing;

        return this;
    }

    public Address getShippingAddress() {
        if (shipping != null && shipping.size() > 0) {
            return shipping.get(0);
        }

        return null;
    }

    public Cart setShippingAddress(Address shipping) {
        this.shipping = new ArrayList<>();
        this.shipping.add(shipping);

        return this;
    }
}
