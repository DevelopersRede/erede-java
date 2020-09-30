package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class SubMerchant {

	@SerializedName("MCC")
	private Long mcc;

	@SerializedName("SubMerchantID")
	private String submerchantID;

	@SerializedName("Address")
	private String address;

	@SerializedName("City")
	private String city;

	@SerializedName("State")
	private String state;

	@SerializedName("Country")
	private String country;

	@SerializedName("Cep")
	private String cep;

	@SerializedName("Cnpj")
	private String cnpj;

	public Long getMcc() {
		return mcc;
	}

	public SubMerchant setMcc(Long mcc) {
		this.mcc = mcc;
		return this;
	}

	public String getSubmerchantID() {
		return submerchantID;
	}

	public SubMerchant setSubmerchantID(String submerchantID) {
		this.submerchantID = submerchantID;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public SubMerchant setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getCity() {
		return city;
	}

	public SubMerchant setCity(String city) {
		this.city = city;
		return this;
	}

	public String getState() {
		return state;
	}

	public SubMerchant setState(String state) {
		this.state = state;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public SubMerchant setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getCep() {
		return cep;
	}

	public SubMerchant setCep(String cep) {
		this.cep = cep;
		return this;
	}

	public String getCnpj() {
		return cnpj;
	}

	public SubMerchant setCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

}
