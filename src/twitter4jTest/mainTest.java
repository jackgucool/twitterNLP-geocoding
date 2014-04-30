package twitter4jTest;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.json.DataObjectFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class mainTest {

	public static void main(String[] args) throws TwitterException {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("vLfFTV5dTuB6mHwaTXtbXq7Q0")
				.setOAuthConsumerSecret(
						"6w943HUQ4fkjens2MQgUBvCHvoEaZjiWizGU4AkQcnKKK4rfG3")
				.setOAuthAccessToken(
						"1332222577-h265alYd18ek9V1CtFuQpk7vaQ1f0r8WsjCW2gT")
				.setOAuthAccessTokenSecret(
						"jTEtx1g2WesoYISH3gP8Z5OPYmYVKG3yAvqhTTmGWECyk")
				// .setUseSSL(true) // enable ssl to satisfy new twitter policy
				.setJSONStoreEnabled(true); // to store JSON file
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		
		
		
		
		
		String[] usrName = { "PGHtransit", "TotalTrafficPIT",
				"511PAPittsburgh", "WPXITraffic", "pgtraffic" };
		List<String> keyUsers = Arrays.asList(usrName);
		String from = "from:";
		Query query = new Query("@pgtraffic");
		query.setCount(100);

		ArrayList<Status> searchResultList = new ArrayList<Status>();

		QueryResult result = twitter.search(query);
		searchResultList = (ArrayList<Status>) result.getTweets();
//		int i = 0;
//		
//		while ( result.hasNext() & (i < 10)) {
//			System.out.print(i);
//			i = i + 1;
//			query = result.nextQuery();
//			result = twitter.search(query);
//			searchResultList.addAll((ArrayList<Status>) result.getTweets());
//		}
		
		for (Status tweet : searchResultList) {
			System.out.println(tweet.getText());
			System.out.println(tweet.getCreatedAt());
		}
		
		// System.out.println(searchResultList);
		// try {
		// FileWriter file = new FileWriter(
		// "/Users/yiminggu/Desktop/temp.json", true);
		// for (Status tweet : searchResultList) {
		// String temp = DataObjectFactory.getRawJSON(tweet);
		// file.write(temp + "\n");
		// }
		// file.flush();
		// file.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
//		System.out.print(twitter.getRateLimitStatus());
		System.out.println(searchResultList.size());
//		System.out.println(i);

	}
	
}
