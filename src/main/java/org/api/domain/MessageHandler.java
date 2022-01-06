package org.api.domain;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Marco Tahat	
 * Use this class to handle Messages.. 
 * TBD: you can move the string constants to a resource bundle package 
 */
public class MessageHandler {
	
	/**
	 * private constructor, this will prevent instance 
	 * Instantiation from outside
	 */
	private MessageHandler() {
		
	}

	public static final String EXIT = "Exit";
	public static final String EXIT_MESSAGE = "\nThank you for using State Details Service!\nShutting Down the APP, See you Soon :)";
	public static final String INPUT_PROMPT = "\nPlease Enter State Name or State Code: ";
	public static final String ERROR_MESSAGE = "No matching state found for requested code";
	public static final String EMPTY = StringUtils.EMPTY;
	public static final String BORDER = "----------------------------------------------";
	public static final String WELCOME = "\nWelcome to State Details Service!\nYou can Exit any time by typing 'Exit'\n";
	public static final String FOUND = "State found matching code";
	public static final String EXCEPTION = "Invalid Request! Try Different Input";

	/**
	 * @param message
	 * @return true if the response return valid results for user input.
	 */
	public static boolean isFound(String message) {
		return StringUtils.isNotBlank(message) && message.contains(FOUND);
	}
	
	/**
	 * @param message
	 * @return predefined message if the user input is Exit.
	 */
	public static String processMessage(String message) {
		return StringUtils.isNotBlank(message) && message.contains(EXIT)? EXIT_MESSAGE : message;
	}

}
