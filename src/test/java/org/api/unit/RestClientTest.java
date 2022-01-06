package org.api.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.api.domain.RestClient;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.response.Response;



public class RestClientTest {
	private static RestClient restClient;
	
	@BeforeClass
	public static void setup() {
		restClient = new RestClient();
	}
	
    @Test
    public void successResponseShouldReturnStatusCode_200() {
		Response response = restClient.get("{code}", "TX");
		response.then().statusCode(200);
    }
    
    @Test
    public void invalidStateCodeResponseShouldReturnErrorMessage() {
		Response response = restClient.get("{code}", "XYZ");
		String message = (String) restClient.extract(response, "RestResponse.messages[0]");
		assertTrue(message.contains("No matching state found for requested code"));
    }
    
    @Test
    public void testExtractValueAtPath() {
    	Response response = restClient.get("{code}", "TX");
    	String country = (String) restClient.extract(response, "RestResponse.result.country");
		
    	assertEquals("USA", country);
    }
    
    @Test
    public void extractInvalidPathReturnsNull() {
    	Response response = restClient.get("{code}", "TX");
    	String country = (String) restClient.extract(response, "/--/");
		
    	assertEquals(null, country);
    }
    
    @Test(expected = NullPointerException.class) 
    public void nullResponseThrowsNullPointerException() {
    	restClient.extract(null, "");
    }
}
