package org.api.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Marco Tahat	
 * Use this to Convert the usr input into stateCode.
 *
 */
public class StateCodeUtil {

	private static final Map<String, String> stateMap;
	static {
		Map<String, String> states = new HashMap<String, String>();
		states.put("Alabama", "AL");
		states.put("Alaska", "AK");
		states.put("Arizona", "AZ");
		states.put("Arkansas", "AR");
		states.put("California", "CA");
		states.put("Colorado", "CO");
		states.put("Connecticut", "CT");
		states.put("Delaware", "DE");
		states.put("District Of Columbia", "DC");
		states.put("Florida", "FL");
		states.put("Georgia", "GA");
		states.put("Hawaii", "HI");
		states.put("Idaho", "ID");
		states.put("Illinois", "IL");
		states.put("Indiana", "IN");
		states.put("Iowa", "IA");
		states.put("Kansas", "KS");
		states.put("Kentucky", "KY");
		states.put("Louisiana", "LA");
		states.put("Maine", "ME");
		states.put("Maryland", "MD");
		states.put("Massachusetts", "MA");
		states.put("Michigan", "MI");
		states.put("Minnesota", "MN");
		states.put("Mississippi", "MS");
		states.put("Missouri", "MO");
		states.put("Montana", "MT");
		states.put("Nebraska", "NE");
		states.put("Nevada", "NV");
		states.put("New Hampshire", "NH");
		states.put("New Jersey", "NJ");
		states.put("New Mexico", "NM");
		states.put("New York", "NY");
		states.put("North Carolina", "NC");
		states.put("North Dakota", "ND");
		states.put("Ohio", "OH");
		states.put("Oklahoma", "OK");
		states.put("Oregon", "OR");
		states.put("Pennsylvania", "PA");
		states.put("Prince Edward Island", "PE");
		states.put("Puerto Rico", "PR");
		states.put("Rhode Island", "RI");
		states.put("South Carolina", "SC");
		states.put("South Dakota", "SD");
		states.put("Tennessee", "TN");
		states.put("Texas", "TX");
		states.put("Utah", "UT");
		states.put("Vermont", "VT");
		states.put("Virginia", "VA");
		states.put("Washington", "WA");
		states.put("West Virginia", "WV");
		states.put("Wisconsin", "WI");
		states.put("Wyoming", "WY");
		states.put("American Samoa", "AS");
		states.put("Guam", "GU");
		states.put("Northern Mariana Islands", "MP");
		states.put("Puerto Rico", "PR");
		states.put("U.S. Virgin Islands", "VI");
		stateMap = Collections.unmodifiableMap(states);
	}

	private StateCodeUtil() {

	}

	public static String getStateCode(String stateName) {
		String code = stateMap.get(stateName);
		return StringUtils.isNotEmpty(code)? code : stateName;
	}
}
