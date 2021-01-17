package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class Item {

    public static final Integer PHYSICAL = 1;
    public static final Integer DIGITAL = 2;
    public static final Integer SERVICE = 3;
    public static final Integer AIRLINE = 4;

    @SerializedName("amount")
    private Integer amount;

    @SerializedName("description")
    private String description;

    @SerializedName("discount")
    private Integer discount;

    @SerializedName("freight")
    private Integer freight;

    @SerializedName("id")
    private String id;

    @SerializedName("quantity")
    private Integer quantity;

    @SerializedName("shippingType")
    private String shippingType;

    @SerializedName("type")
    private Integer type;

    public Item() {
    }

    public Item(String id, Integer quantity) {
        this(id, quantity, Item.PHYSICAL);
    }

    public Item(String id, Integer quantity, Integer type) {
        this.id = id;
        this.quantity = quantity;
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public Item setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getDiscount() {
        return discount;
    }

    public Item setDiscount(Integer discount) {
        this.discount = discount;
        return this;
    }

    public Integer getFreight() {
        return freight;
    }

    public Item setFreight(Integer freight) {
        this.freight = freight;
        return this;
    }

    public String getId() {
        return id;
    }

    public Item setId(String id) {
        this.id = id;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Item setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getShippingType() {
        return shippingType;
    }

    public Item setShippingType(String shippingType) {
        this.shippingType = shippingType;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Item setType(Integer type) {
        this.type = type;
        return this;
    }
}
