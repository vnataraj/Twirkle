import java.util.Scanner;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.URI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;





import java.net.URLEncoder;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.internal.http.HttpResponse;


public class Trial {

	public static String getUserRequest() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the search term for twitter: ");
		return reader.next();
	}
	
	public static void main(String[] args) throws TwitterException
	{
		//Twitter twitter = new TwitterFactory().getInstance();
		ConfigurationBuilder cb = new ConfigurationBuilder();
		TwitterStream twitter = new TwitterStreamFactory(cb.build()).getInstance();

	    AccessToken accessToken = new AccessToken("956128004-TD4TePUotW0RpDFEEr1lvdnXTNPgrrats48YYjng", 
	    												"5B2rloxwUQpN5hLWgeOrb7HPc88osMlfcv8TH4z591o");
	    twitter.setOAuthConsumer("n1JT7qBAVEiJGY2H9NRZAQ", "ScLPXE8SMmEYPS59SpGaM5tCl6HpN0P1A5W6LJV76QQ");
	    twitter.setOAuthAccessToken(accessToken);

	    //Query query = new Query(getUserRequest());
		
		FilterQuery filter = new FilterQuery();    
		double[][] bb= {{-180, -90}, {180, 90}};
		filter.locations(bb);
		String[] track = {"#mhacks", "#hackers", "#ipl"};
		//track[0] = getUserRequest();
		filter.track(track);
		
		StatusListener listener = new StatusListener() {
			
			@Override
			public void onException(Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			    System.out.println("Failed to search tweets: " + e.getMessage());
			    System.exit(-1);			
			}
			
			@Override
			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
				// TODO Auto-generated method stub
				// The predicate is too broad - make it more selective
				System.out.println("TRACK LIMITATION NOTICE");
				System.out.println("Number of statuses limited administratively: " + numberOfLimitedStatuses);				
			}
			
			@Override
			public void onStatus(Status tweet) {
				// TODO Auto-generated method stub
				
				//if(tweet.getText().contains("#music")){
					System.out.println("USER:  @" + tweet.getUser().getScreenName() + " \nTEXT:  " + tweet.getText());
		        	if (tweet.getGeoLocation() != null && tweet.getCreatedAt() != null) {
		        		System.out.println("\nLOCATION:   " + tweet.getGeoLocation().getLatitude()
		        					+ "   " + tweet.getGeoLocation().getLongitude()
		        					+ "\nDATE:   " + tweet.getCreatedAt().toString());
		        		
		        		
		        		StringBuilder getRequest = new StringBuilder();
		        		
		        		try {
							
			        		getRequest.append("http://twirkle.herobo.com/addTweet.php?id=");
			        		getRequest.append(tweet.getId());
			        		getRequest.append("&createdAt=");
			        		getRequest.append(tweet.getCreatedAt().toString());
			        		getRequest.append("&retweetCount=");
			        		getRequest.append(tweet.getRetweetCount());
			        		getRequest.append("&latitude=");
			        		getRequest.append(tweet.getGeoLocation().getLatitude());
			        		getRequest.append("&longitude=");
			        		getRequest.append(tweet.getGeoLocation().getLongitude());
			        		getRequest.append("&user_id=");
			        		getRequest.append(tweet.getUser().getId());
			        		getRequest.append("&user_name=");
			        		getRequest.append(URLEncoder.encode(tweet.getUser().getName(), "UTF-8"));
							getRequest.append("&text=");
			        		getRequest.append(URLEncoder.encode(tweet.getText(), "UTF-8"));
		        		} catch (UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        		
		        		
		        		try{
		        		
		        			String req = getRequest.toString().replace(" ","%20");
		        			System.out.println(req);
			        		URL obj=new URL(req);
			        		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			       		 	con.setConnectTimeout(1000);
							// optional default is GET
			        		
							System.out.println("\nSending 'GET' request to URL : " + req);
							//System.out.println("Response Code : " + responseCode);
							BufferedReader in = new BufferedReader(
							        new InputStreamReader(con.getInputStream()));
							String inputLine;
							StringBuffer response = new StringBuffer();
					 
							while ((inputLine = in.readLine()) != null) {
								response.append(inputLine);																
							}
							in.close();
							con.disconnect();
					 
							//print result
							System.out.println(response.toString());
				 
		        		}
		        		catch(IOException e)
		        		{
		        			e.printStackTrace();
		        			System.out.println("errrra");
		        		}		        		
		        	}	
			}

			public void onDeletionNotice1(StatusDeletionNotice arg0) {
				// TODO Auto-generated method stub
				
			}

			public void onScrubGeo1(long arg0, long arg1) {
				// TODO Auto-generated method stub
				
			}

			public void onStallWarning1(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			
				//}		     
			}
			
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void onScrubGeo(long userId, long upToStatusId) {
				// TODO Auto-generated method stub
				// Content removal request
			}
			
			@Override
			public void onDeletionNotice(StatusDeletionNotice arg0) {
				// TODO Auto-generated method stub
				// Content removal request
			}
			
		};
		twitter.addListener(listener);
		twitter.filter(filter);
		//QueryResult result = ((SearchResource) twitter).search(query);
	}
}
