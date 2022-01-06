package org.api.application;

import java.util.Scanner;

import org.api.domain.MessageHandler;
import org.api.domain.RestClient;
import org.api.domain.Result;
import org.api.util.StateCodeUtil;

import io.restassured.response.Response;

/**
 * @author Marco Tahat
 * Simple Java Application based on Rest Assure library.
 * this application has been develop for interview perp. 
 *
 */
public class RestApplication {
	
	
	/**
	 * Main Method, run this project as Java Application 
	 * @param args
	 */
	public static void main(String[] args) {
		RestClient restClient = new RestClient();
		String input = null;
		Result result;
		
		System.out.print(MessageHandler.BORDER);
		System.out.print(MessageHandler.WELCOME);
		System.out.print(MessageHandler.BORDER);
		
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println(MessageHandler.INPUT_PROMPT);
			input = scan.nextLine();
			try {
				result = processRequest(restClient, input);
			}catch (Exception exception) {
				result = new Result(null, null, MessageHandler.EXCEPTION);
			}
			System.out.println(result.toString());
			
		} while(!input.equals(MessageHandler.EXIT));
		
		scan.close();
		 	
	}

	/**
	 * @param restClient -- the client to consume the API
	 * @param input -- User input from console, this is case 
	 * Accepted Inputs: <Case Sensitive>
	 * 		1- state code: two letters Upper Case for example; NY
	 * 		2- state name: first letter should be upper case, for example: New York
	 * @return results taken from the response.
	 */
	public static Result processRequest(RestClient restClient, String input) {
		Result result = new Result();
		
		Response response = restClient.get("{code}", StateCodeUtil.getStateCode(input));
		String message = MessageHandler.processMessage((String) restClient.extract(response, "RestResponse.messages[0]"));
		
		if(MessageHandler.isFound(message)){
			result.setLargestCity((String) restClient.extract(response, "RestResponse.result.largest_city"));
			result.setCapital((String) restClient.extract(response, "RestResponse.result.capital"));
		}
		result.setMessage(message);
		return result;
	}

}
