package br.com.userede.erede;

import com.google.gson.Gson;

import junit.framework.TestCase;

public class TestAuthorization extends TestCase {

	String auth = "  {  \"dateTime\": \"2020-12-14T19:26:17-03:00\",\n" + 
			"    \"returnCode\": \"00\",\n" + 
			"    \"returnMessage\": \"Success.\",\n" + 
			"    \"affiliation\": 11223344,\n" + 
			"    \"status\": \"Approved\",\n" + 
			"    \"reference\": \"1234\",\n" + 
			"    \"tid\": \"10012012141925580147\",\n" + 
			"    \"nsu\": \"504364149\",\n" + 
			"    \"kind\": \"Credit\",\n" + 
			"    \"amount\": 51,\n" + 
			"    \"installments\": 1,\n" + 
			"    \"cardHolderName\": \"Jhon Dole\",\n" + 
			"    \"cardBin\": \"112233\",\n" + 
			"    \"last4\": \"1234\",\n" + 
			"    \"origin\": 1,\n" + 
			"    \"subscription\": false,\n" + 
			"    \"brand\": {\n" + 
			"      \"name\": \"Mastercard\",\n" + 
			"      \"returnCode\": \"00\",\n" + 
			"      \"returnMessage\": \"Success.\",\n" + 
			"      \"authorizationCode\": \"031605\",\n" + 
			"      \"brandTid\": \"031605\"\n" + 
			"    } }";
	
	private Authorization authorization = new Authorization();
	private Gson gson = new Gson();
	
	public void testGetAuthorizationCode() {
		authorization = gson.fromJson(auth, Authorization.class);
		assertEquals("031605", authorization.getAuthorizationCode());
		
		auth = "  { " + 
				"    \"brand\": {\n" + 
				"      \"name\": \"Mastercard\",\n" + 
				"      \"returnCode\": \"00\",\n" + 
				"      \"returnMessage\": \"Success.\",\n" + 
				"      \"brandTid\": \"031605\"\n" + 
				"    } }";
		authorization = gson.fromJson(auth, Authorization.class);
		assertEquals(null, authorization.getAuthorizationCode());
		
		auth = "  {  \"authorizationCode\": \"\"\n } ";
		authorization = gson.fromJson(auth, Authorization.class);
		assertEquals(null, authorization.getBrand());
		assertEquals(null, authorization.getAuthorizationCode());
		
		auth = "  {  \"authorizationCode\": \"112233\"\n } ";
		authorization = gson.fromJson(auth, Authorization.class);
		assertEquals(null, authorization.getBrand());
		assertEquals("112233", authorization.getAuthorizationCode());
		
	}

//	public void testSetAuthorizationCode() {
//		fail("Not yet implemented");
//	}
//
//	public void testGetBrand() {
//		fail("Not yet implemented");
//	}
//
//	public void testSetBrand() {
//		fail("Not yet implemented");
//	}

}
