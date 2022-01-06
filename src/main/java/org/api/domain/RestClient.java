package org.api.domain;

import static io.restassured.RestAssured.given;

import org.api.util.ApiConfig;
import org.api.util.ConfigUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class RestClient {
	
	private ApiConfig config;
	
	public RestClient() {
		 config = ConfigUtil.getApiConfig();
	     RestAssured.basePath = config.getPath();
	     RestAssured.baseURI = config.getHost();
	}
	
	public Response get(String path, Object... pathParams) {
		//Implement Rest Assured call to Get the response for given path.
		//TO DO
		return null;
	}
	
	//Extract Results From Response using Path to Service
	public Object extract(Response response, String path) {
		ValidatableResponse validResponse = null;
		//TO DO
		return null;
	}
}
