package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class Brand {

	@SerializedName("name")
	private String name;

	@SerializedName("returnCode")
	private String returnCode;

	@SerializedName("returnMessage")
	private String returnMessage;

	@SerializedName("authorizationCode")
	private String authorizationCode;

	public String getName() {
		return name;
	}

	public Brand setName(String name) {
		this.name = name;
		return this;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public Brand setReturnCode(String returnCode) {
		this.returnCode = returnCode;
		return this;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public Brand setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
		return this;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public Brand setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
		return this;
	}

}
