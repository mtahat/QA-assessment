package org.api.integration;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.api.application.RestApplication;
import org.api.domain.RestClient;
import org.api.domain.Result;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Marco Tahat
 * Parameterized test, this covers all happy scenarios for the 55
 * states that the service support, plus the 'all' option.
 * also this class cover the integration part between the Application, Domain and Util classes.
 */
@RunWith(Parameterized.class)
public class RestApplicationTest {
   private String input;
   private Result expectedResult;
   private RestClient restClient;

   @Before
   public void initialize() {
      this.restClient = new RestClient();
   }

   /**
    * Each parameter should be placed as an argument here
    * Every time runner triggers, it will pass the arguments
    * from parameters we defined in testSuite() method
    */
	
   public RestApplicationTest(String input, Result expectedResult) {
      this.input = input;
      this.expectedResult = expectedResult;
   }

   @SuppressWarnings("rawtypes")
   @Parameterized.Parameters(name = "{index} Input: {0}")
   public static Collection testSuite() {
      return Arrays.asList(new Object[][] {
         { "Alabama", new Result("Montgomery", "Birmingham", "State found matching code [AL].") },
         { "AL", new Result("Montgomery", "Birmingham", "State found matching code [AL].")},
         { "Alaska", new Result("Juneau", "Anchorage", "State found matching code [AK].") },
         { "AK", new Result("Juneau", "Anchorage", "State found matching code [AK].")},
         { "Arizona", new Result("Phoenix", "Phoenix", "State found matching code [AZ].") },
         { "AZ", new Result("Phoenix", "Phoenix", "State found matching code [AZ].")},
         { "Arkansas", new Result("Little Rock", "Little Rock", "State found matching code [AR].") },
         { "AR", new Result("Little Rock", "Little Rock", "State found matching code [AR].") },
         { "California", new Result("Sacramento", "Los Angeles", "State found matching code [CA].") },
         { "CA", new Result("Sacramento", "Los Angeles", "State found matching code [CA].")},
         { "Colorado", new Result("Denver", "Denver", "State found matching code [CO].") },
         { "CO", new Result("Denver", "Denver", "State found matching code [CO].")},
         { "Connecticut", new Result("Hartford", "Bridgeport", "State found matching code [CT].") },
         { "CT", new Result("Hartford", "Bridgeport", "State found matching code [CT].")},
         { "Delaware", new Result("Dover", "Wilmington", "State found matching code [DE].") },
         { "DE", new Result("Dover", "Wilmington", "State found matching code [DE].")},
         { "Florida", new Result("Tallahassee", "Jacksonville", "State found matching code [FL].") },
         { "FL", new Result("Tallahassee", "Jacksonville", "State found matching code [FL].")},
         { "Georgia", new Result("Atlanta", "Atlanta", "State found matching code [GA].") },
         { "GA", new Result("Atlanta", "Atlanta", "State found matching code [GA].")},
         { "Hawaii", new Result("Honolulu", "Honolulu", "State found matching code [HI].") },
         { "HI", new Result("Honolulu", "Honolulu", "State found matching code [HI].")},
         { "Idaho", new Result("Boise", "Boise", "State found matching code [ID].") },
         { "ID", new Result("Boise", "Boise", "State found matching code [ID].") },
         { "Illinois", new Result("Springfield", "Chicago", "State found matching code [IL].") },
         { "IL", new Result("Springfield", "Chicago","State found matching code [IL].")},
         { "Indiana", new Result("Indianapolis", "Indianapolis", "State found matching code [IN].") },
         { "IN", new Result("Indianapolis", "Indianapolis", "State found matching code [IN].")},
         { "Iowa", new Result("Des Moines", "Des Moines", "State found matching code [IA].") },
         { "IA", new Result("Des Moines", "Des Moines", "State found matching code [IA].")},
         { "Kansas", new Result("Topeka", "Wichita", "State found matching code [KS].") },
         { "KS", new Result("Topeka", "Wichita", "State found matching code [KS].")},
         { "Kentucky", new Result("Frankfort", "Louisville", "State found matching code [KY].") },
         { "KY", new Result("Frankfort", "Louisville", "State found matching code [KY].")},
         { "Louisiana", new Result("Baton Rouge", "New Orleans", "State found matching code [LA].") },
         { "Louisiana", new Result("Baton Rouge", "New Orleans", "State found matching code [LA].")},
         { "Maine", new Result("Augusta", "Portland", "State found matching code [ME].") },
         { "ME", new Result("Augusta", "Portland", "State found matching code [ME].") },
         { "Maryland", new Result("Annapolis", "Baltimore", "State found matching code [MD].") },
         { "MD", new Result("Annapolis", "Baltimore", "State found matching code [MD].")},
         { "Massachusetts", new Result("Boston", "Boston", "State found matching code [MA].") },
         { "MA", new Result("Boston", "Boston", "State found matching code [MA].")},
         { "Michigan", new Result("Lansing", "Detroit", "State found matching code [MI].") },
         { "MI", new Result("Lansing", "Detroit", "State found matching code [MI].")},
         { "Minnesota", new Result("St. Paul", "Minneapolis", "State found matching code [MN].") },
         { "MN", new Result("St. Paul", "Minneapolis", "State found matching code [MN].")},
         { "Mississippi", new Result("Jackson", "Jackson", "State found matching code [MS].") },
         { "MS", new Result("Jackson", "Jackson", "State found matching code [MS].")},
         { "Missouri", new Result("Jefferson City", "Kansas City", "State found matching code [MO].") },
         { "MO", new Result("Jefferson City", "Kansas City", "State found matching code [MO].")},
         { "Montana", new Result("Helena", "Billings", "State found matching code [MT].") },
         { "MT", new Result("Helena", "Billings", "State found matching code [MT].") },
         { "Nebraska", new Result("Lincoln", "Omaha", "State found matching code [NE].") },
         { "NE", new Result("Lincoln", "Omaha", "State found matching code [NE].")},
         { "Nevada", new Result("Carson City", "Las Vegas", "State found matching code [NV].") },
         { "NV", new Result("Carson City", "Las Vegas", "State found matching code [NV].")},
         { "New Hampshire", new Result("Concord", "Manchester", "State found matching code [NH].")},
         { "NH", new Result("Concord", "Manchester", "State found matching code [NH].")},
         { "New Jersey", new Result("Trenton", "Newark", "State found matching code [NJ].") },
         { "NJ", new Result("Trenton", "Newark", "State found matching code [NJ].")},
         { "New Mexico", new Result("Santa Fe", "Albuquerque", "State found matching code [NM].") },
         { "NM", new Result("Santa Fe", "Albuquerque", "State found matching code [NM].")},
         { "New York", new Result("Albany", "New York City", "State found matching code [NY].") },
         { "NY", new Result("Albany", "New York City", "State found matching code [NY].")},
         { "North Carolina", new Result("Raleigh", "Charlotte", "State found matching code [NC].") },
         { "NC", new Result("Raleigh", "Charlotte", "State found matching code [NC].") },
         { "North Dakota", new Result("Bismarck", "Fargo", "State found matching code [ND].") },
         { "ND", new Result("Bismarck", "Fargo", "State found matching code [ND].")},
         { "Ohio", new Result("Columbus", "Columbus", "State found matching code [OH].") },
         { "OH", new Result("Columbus", "Columbus", "State found matching code [OH].")},
         { "Oklahoma", new Result("Oklahoma City", "Oklahoma City", "State found matching code [OK].") },
         { "OK", new Result("Oklahoma City", "Oklahoma City", "State found matching code [OK].")},
         { "Oregon", new Result("Salem", "Portland", "State found matching code [OR].") },
         { "OR", new Result("Salem", "Portland", "State found matching code [OR].")},
         { "Pennsylvania", new Result("Harrisburg", "Philadelphia", "State found matching code [PA].") },
         { "PA", new Result("Harrisburg", "Philadelphia", "State found matching code [PA].")},
         { "Rhode Island", new Result("Providence", "Providence", "State found matching code [RI].") },
         { "RI", new Result("Providence", "Providence", "State found matching code [RI].")},
         { "South Carolina", new Result("Columbia", "Charleston", "State found matching code [SC].") },
         { "SC", new Result("Columbia", "Charleston", "State found matching code [SC].")},
         { "South Dakota", new Result("Pierre", "Sioux Falls", "State found matching code [SD].") },
         { "SD", new Result("Pierre", "Sioux Falls", "State found matching code [SD].") },
         { "Texas", new Result("Austin", "Houston", "State found matching code [TX].") },
         { "TX", new Result("Austin", "Houston", "State found matching code [TX].")},
         { "Tennessee", new Result("Nashville", "Nashville", "State found matching code [TN].") },
         { "TN", new Result("Nashville", "Nashville", "State found matching code [TN].")},
         { "Utah", new Result("Salt Lake City", "Salt Lake City", "State found matching code [UT].") },
         { "UT", new Result("Salt Lake City", "Salt Lake City", "State found matching code [UT].")},
         { "Vermont", new Result("Montpelier", "Burlington", "State found matching code [VT].") },
         { "VT", new Result("Montpelier", "Burlington", "State found matching code [VT].")},
         { "Virginia", new Result("Richmond", "Virginia Beach", "State found matching code [VA].") },
         { "VA", new Result("Richmond", "Virginia Beach", "State found matching code [VA].")},
         { "Washington", new Result("Olympia", "Seattle", "State found matching code [WA].") },
         { "WA", new Result("Olympia", "Seattle", "State found matching code [WA].")},
         { "West Virginia", new Result("Charleston", "Charleston", "State found matching code [WV].") },
         { "WV", new Result("Charleston", "Charleston", "State found matching code [WV].") },
         { "Wisconsin", new Result("Madison", "Milwaukee", "State found matching code [WI].") },
         { "WI", new Result("Madison", "Milwaukee", "State found matching code [WI].")},
         { "Wyoming", new Result("Cheyenne", "Cheyenne", "State found matching code [WY].") },
         { "WY", new Result("Cheyenne", "Cheyenne", "State found matching code [WY].")},
         { "American Samoa", new Result("Pago Pago", null, "State found matching code [AS].") },
         { "AS", new Result("Pago Pago", null , "State found matching code [AS].")},
         { "Guam", new Result("Hagåtña", null, "State found matching code [GU].") },
         { "GU", new Result("Hagåtña", null, "State found matching code [GU].")},
         { "Northern Mariana Islands", new Result("Saipan", null, "State found matching code [MP].") },
         { "MP", new Result("Saipan", null, "State found matching code [MP].")},
         { "Puerto Rico", new Result("San Juan", null, "State found matching code [PR].") },
         { "PR", new Result("San Juan", null, "State found matching code [PR].")},
         { "U.S. Virgin Islands", new Result("Charlotte Amalie", null, "State found matching code [VI].") },
         { "VI", new Result("Charlotte Amalie", null, "State found matching code [VI].")},
         { "all", new Result(null, null, "Total [55] records found.")}
      });
   }

   
	/**
	 * this test will be executed the size of the collection in the testSuite.
	 */
	@Test
	public void testStateDetailsService() {
		Result actualResult = RestApplication.processRequest(restClient, this.input);
		assertEquals(expectedResult, actualResult);
	}
   
  
}