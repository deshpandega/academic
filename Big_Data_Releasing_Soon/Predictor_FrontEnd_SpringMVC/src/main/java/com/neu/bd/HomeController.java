package com.neu.bd;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	int statusCount = 0;
	String twitMovie = "";
	//	long minmID = 0;
	ArrayList<String> arrIDList = new ArrayList<String>();
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	/**
	 * Clear the text fields
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/home.htm", method = RequestMethod.GET)
	public ModelAndView clearText(HttpServletRequest request, HttpServletResponse response){
		System.out.println("Clear movie name");
		ModelAndView mv = new ModelAndView("home", "movieName", "helloWorld");
		return mv;
	}

	/**
	 * Get the movie name from page and call Facebook APIs for getting name, fan count, talking about count, category and genre.
	 * This method calls another set of methods to get the job done
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/findMovie.htm", method = RequestMethod.GET)
	public ModelAndView findMovieNameAndMakeAPICalls(HttpServletRequest request, HttpServletResponse response){
		String movieName = request.getParameter("movieName").trim();
		String movieToBeSearched = movieName;
		String[] parts = movieName.split(" ");
		movieName="";
		if(parts.length>1){
			for(int i=0;i<parts.length;i++){
				movieName=movieName+parts[i];
			}
		}
		else{
			movieName = request.getParameter("movieName").trim();
		}
		movieName = movieName.replaceAll("[^a-zA-Z0-9 ]", "");
		int flag = 0;
		MoviePojo movieObj = new MoviePojo();

		String facebookResponse = fetchFacebookMovieFansAndTrendingCount(movieName, flag);
		System.out.println("Response received from Facebook:"+facebookResponse);
		String tweetResponse = fetchTwitterResponse(movieName, 1);
		System.out.println("tweetResponse:"+tweetResponse);
		if(tweetResponse.isEmpty()){
			System.out.println("Empty!!");
		}
		if(tweetResponse.equals("")){
			System.out.println("Empty tweet received");
		}
		//		if(tweetResponse.)
		System.out.println("Response received from Twitter:"+tweetResponse);

		String TwitterTagsLocsResponse = fetchTwitterTagsAndLocs(movieName,"", 0,0);
		System.out.println("Response received from Twitter TagsLoc:"+TwitterTagsLocsResponse);

		String minID = parseTwitterData(TwitterTagsLocsResponse,movieObj,0);
		if(minID.isEmpty()){
			System.out.println("minID is empty");
		}else{
			System.out.println("minID is not empty");
			for(int i=0;i<5;i++){
				String TwitterTagsLocsResponse2 = fetchTwitterTagsAndLocs(movieName, minID,0,1);
				System.out.println("Response received from Twitter TagsLoc:"+TwitterTagsLocsResponse2);
				if(!TwitterTagsLocsResponse2.isEmpty()){
					minID = parseTwitterData(TwitterTagsLocsResponse2,movieObj,1);
				}
				//				if(minID.isEmpty()){
				//					System.out.println("minID is empty");
				//				}
			}

		}



		String imdbResponse = fetchIMDBResponse(movieToBeSearched);
		System.out.println("imdbResponse"+imdbResponse);

		JSONObject jsonFBObj;
		JSONObject jsonTwitterObj;
		JSONObject jsonOMDBObj;

		try {
			if(facebookResponse.isEmpty() || facebookResponse.equalsIgnoreCase("Movie not found")){
				movieObj.setMovieName(movieToBeSearched);
				movieObj.setFanCount("N/A");
				movieObj.setTrendingCount("N/A");
				movieObj.setCategory("N/A");

			}else{
				jsonFBObj = new JSONObject(facebookResponse);
				if(jsonFBObj.has("name"))
					movieObj.setMovieName(movieToBeSearched);
				else
					movieObj.setMovieName("N/A");
				if(jsonFBObj.has("fan_count"))
					movieObj.setFanCount(Integer.toString(jsonFBObj.getInt("fan_count")));
				else
					movieObj.setFanCount("N/A");
				if(jsonFBObj.has("talking_about_count"))
					movieObj.setTrendingCount(Integer.toString(jsonFBObj.getInt("talking_about_count")));
				else
					movieObj.setTrendingCount("N/A");
				if(jsonFBObj.has("category"))
					movieObj.setCategory(jsonFBObj.getString("category"));
				else
					movieObj.setCategory("N/A");

			}if(tweetResponse.isEmpty()){
				movieObj.setTweetFollowers("N/A");
			}else{
				jsonTwitterObj = new JSONObject(tweetResponse);
				if(jsonTwitterObj.has("followers_count"))
					movieObj.setTweetFollowers(Long.toString(jsonTwitterObj.getLong("followers_count")));
				else
					movieObj.setTweetFollowers("N/A");

			}if(imdbResponse.isEmpty()){
				movieObj.setGenre("N/A");
				movieObj.setYear("N/A");
				movieObj.setImdbVotes("N/A");
				movieObj.setImdbRating("N/A");
				movieObj.setType("N/A");
				movieObj.setActors("N/A");
				movieObj.setDirector("N/A");
				movieObj.setWriter("N/A");

			}else{
				jsonOMDBObj = new JSONObject(imdbResponse);
				if(jsonOMDBObj.has("Genre"))
					movieObj.setGenre(jsonOMDBObj.getString("Genre"));
				else
					movieObj.setGenre("N/A");

				if(jsonOMDBObj.has("Year"))
					movieObj.setYear(jsonOMDBObj.getString("Year"));
				else
					movieObj.setYear("N/A");

				if(jsonOMDBObj.has("imdbVotes"))
					movieObj.setImdbVotes(jsonOMDBObj.getString("imdbVotes"));
				else
					movieObj.setImdbVotes("N/A");
				if(jsonOMDBObj.has("imdbRating"))
					movieObj.setImdbRating(jsonOMDBObj.getString("imdbRating"));
				else
					movieObj.setImdbRating("N/A");
				if(jsonOMDBObj.has("Type"))
					movieObj.setType(jsonOMDBObj.getString("Type"));
				else
					movieObj.setType("N/A");
				if(jsonOMDBObj.has("Actors"))
					movieObj.setActors(jsonOMDBObj.getString("Actors"));
				else
					movieObj.setActors("N/A");
				if(jsonOMDBObj.has("Director"))
					movieObj.setDirector(jsonOMDBObj.getString("Director"));
				else
					movieObj.setDirector("N/A");
				if(jsonOMDBObj.has("Writer"))
					movieObj.setWriter(jsonOMDBObj.getString("Writer"));
				else
					movieObj.setWriter("N/A");
			}


		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		}

		System.out.println("-------------------------------------------------------------------");
		System.out.println("Data fetched for:"+movieName);
		System.out.println("Movie Name:"+movieObj.getMovieName());
		System.out.println("Genre:"+movieObj.getGenre());
		System.out.println("Year:"+movieObj.getYear());
		System.out.println("Type:"+movieObj.getType());
		System.out.println("IMDBRatings:"+movieObj.getImdbRating());
		System.out.println("IMDBVotes:"+movieObj.getImdbVotes());
		System.out.println("Actors:"+movieObj.getActors());
		System.out.println("Writer:"+movieObj.getWriter());
		System.out.println("Director:"+movieObj.getDirector());
		System.out.println("Fan Count:"+movieObj.getFanCount());
		System.out.println("Trending Count:"+movieObj.getTrendingCount());
		System.out.println("Follower Count:"+movieObj.getTweetFollowers());
		int totHashTags = 0;
		int totLocs = 0;

		if(movieObj.getHashTagsList()!=null){
			for(int i=0;i<movieObj.getHashTagsList().size();i++){
				for(int j=0;j<movieObj.getHashTagsList().get(i).size();j++){
					totHashTags++;
				}
			}
		}
		if(movieObj.getLocation()!=null){
			for(int i=0;i<movieObj.getLocation().size();i++){
				for(int j=0;j<movieObj.getLocation().get(i).size();j++){
					totLocs++;
				}
			}
		}
		if(movieObj.getHashTagsList()!=null){
			System.out.println("Hash Tag Count:"+movieObj.getHashTagsList().size());
		}else{
			System.out.println("Hash Tag Count:0");
		}
		System.out.println("Total Hash Tag Count:"+totHashTags);
		if(movieObj.getLocation()!=null){
			System.out.println("location Count:"+movieObj.getLocation().size());
		}else{
			System.out.println("location Count:0");
		}
		System.out.println("Total location Count:"+totLocs);
		if(movieObj.getHashTagsList()!=null){
			System.out.println("Generating file with hash tags for word cloud:In Progress");
			try {
				PrintWriter out = new PrintWriter("hashTags.txt");

				for(int i=0;i<movieObj.getHashTagsList().size();i++){
					for(int j=0;j<movieObj.getHashTagsList().get(i).size();j++){
						//					System.out.println("TAG"+movieObj.getHashTagsList().get(i).get(j));
						out.println(movieObj.getHashTagsList().get(i).get(j));
					}
				}
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("-->"+e.getMessage());
			} 

			System.out.println("Generating file with hash tags for word cloud:Success!");
		}

		if(movieObj.getLocation()!=null){
			System.out.println("Generating file with locations for map:In Progress");		
			try {
				PrintWriter out = new PrintWriter("locations.txt");

				for(int i=0;i<movieObj.getLocation().size();i++){
					for(int j=0;j<movieObj.getLocation().get(i).size();j++){
						if(!movieObj.getLocation().get(i).get(j).equals("")){
							out.println(movieObj.getLocation().get(i).get(j));
						}
					}
				}
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("-->"+e.getMessage());
			} 
			System.out.println("Generating file with locations for map:Success!");
		}
		System.out.println("Twitter movie found with moviname:"+twitMovie);


		//		System.out.println("OMDB Response:"+imdbResponse);

		//String[] inputMovie = {movieObj.getYear(), "0",movieObj.getImdbRating(),movieObj.getGenre(),"0","0",movieObj.getMovieName(), movieObj.getImdbVotes(), movieObj.getType(),"N/A",movieObj.getDirector(),"N/A",movieObj.getActors(),"N/A","N/A","N/A",movieObj.getWriter(),"N/A",movieObj.getTweetFollowers(),movieObj.getTrendingCount(),movieObj.getFanCount()};
		String[] inputMovie = {movieObj.getYear(), "0",movieObj.getImdbRating(),movieObj.getGenre(),"0","0",movieObj.getMovieName(), movieObj.getImdbVotes(), movieObj.getType(),"N/A",movieObj.getDirector(),"N/A",movieObj.getActors(),"N/A","N/A",movieObj.getWriter(),"N/A",movieObj.getTweetFollowers(),movieObj.getTrendingCount(),movieObj.getFanCount()};
		for(int i=0;i<inputMovie.length;i++){
			System.out.println("Data:"+inputMovie[i]);
		}
		System.out.println("Generating data with:"+inputMovie.length);
		getData(inputMovie);
		

		ModelAndView mv = new ModelAndView("home", "movieObject", movieObj);
		return mv;

	}

	private String parseTwitterData(String TwitterTagsLocsResponse,MoviePojo movieObj, int flag) {
		JSONObject jsonTwitterTagsLocs;
		String minID ="";

		try {
			if(TwitterTagsLocsResponse.isEmpty()){
				movieObj.setHashTagsList(null);
				movieObj.setLocation(null);
				movieObj.setIdList(null);

			}else{

				jsonTwitterTagsLocs = new JSONObject(TwitterTagsLocsResponse);
				JSONArray statusList = jsonTwitterTagsLocs.getJSONArray("statuses");
				if(statusList.length()!=0){
					statusCount = statusCount + statusList.length();
					System.out.println("statusList"+statusList.length());
					ArrayList<ArrayList<String>> listOfHashTagsList = new ArrayList<ArrayList<String>>();
					ArrayList<ArrayList<String>> listOfLocsList = new ArrayList<ArrayList<String>>();
					int locCount=0;
					ArrayList<String> idList = new ArrayList<String>();
					for(int i=0;i<statusList.length();i++){
						ArrayList<String> locList = new ArrayList<String>();
						JSONObject status = statusList.getJSONObject(i);
						JSONObject entities = status.getJSONObject("entities");
						JSONObject user = status.getJSONObject("user");
						locList.add(user.getString("location"));
						locCount++;
						arrIDList.add(Long.toString(status.getLong("id")));
						if(flag==0){
							idList.add(Long.toString(status.getLong("id")));
						}else{
							movieObj.getIdList().add(Long.toString(status.getLong("id")));
						}
						if(status.has("retweeted_status")){
							JSONObject retweetedStat = status.getJSONObject("retweeted_status");
							if(retweetedStat.has("user")){
								JSONObject rtUser = retweetedStat.getJSONObject("user");
								locList.add(rtUser.getString("location"));
								locCount++;
							}
						}


						JSONArray hashTagsList = entities.getJSONArray("hashtags");
						ArrayList<String> tempList = new ArrayList<String>();
						for(int j=0;j<hashTagsList.length();j++){
							String text = hashTagsList.getJSONObject(j).getString("text");
							tempList.add(text);
						}
						listOfLocsList.add(locList);
						listOfHashTagsList.add(tempList);
						if(flag==0){
							movieObj.setHashTagsList(listOfHashTagsList);
							movieObj.setLocation(listOfLocsList);
						}else{
							movieObj.getLocation().add(locList);
							movieObj.getHashTagsList().add(tempList);
						}

					}
					if(flag==0){
						movieObj.setIdList(idList);
					}
					minID= movieObj.getIdList().get(movieObj.getIdList().size()-1);
				}
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		}
		return minID;
	}



	private String fetchIMDBResponse(String movieName) {
		// TODO Auto-generated method stub

		movieName = URLEncoder.encode(movieName);
		System.out.println("Searching for movie:"+movieName);
		String urlToBeHit = "https://www.omdbapi.com/?t="+movieName+"&y=&plot=short&r=json";
		StringBuilder results = new StringBuilder();
		try {

			HttpURLConnection connection = (HttpURLConnection) ((new URL(urlToBeHit).openConnection()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				results.append(line);
			}
			connection.disconnect();
			System.out.println("Result:::"+results.toString());

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		}

		return results.toString();
	}

	/**
	 * Calls the Facebook API for getting user access token
	 * @param movieName
	 * @param flag
	 * @return
	 */
	private String fetchFacebookMovieFansAndTrendingCount(String movieName, int flag) {
		// TODO Auto-generated method stub
		String appID = "615171405336124";
		String appSecret = "1b9bb7bad204029fd4b124a085d5cc96";
		String redirectURI = "http://localhost:9081/bd/";
		String uri = "https://graph.facebook.com/oauth/access_token?client_id=" + appID +
				"&client_secret=" + appSecret +
				"&grant_type=client_credentials" +
				"&redirect_uri=" + redirectURI +
				"&scope=user_about_me";

		System.out.println("------>>>"+uri);
		String output = "";
		URL urlToBeHit;
		try {
			urlToBeHit = new URL(uri);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			InputStream is = urlToBeHit.openStream();
			int r;
			while ((r = is.read()) != -1) {
				baos.write(r);
			}

			String responseFromFB = new String(baos.toByteArray());
			is.close();
			baos.close();

			String TOKEN_INDEX = "accesss_token=";
			String token = responseFromFB.substring(TOKEN_INDEX.length()-1);
			System.out.println(token);

			//Call recursion method
			String op = callFacebookAPI(movieName, token, flag);

			output = op;

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return output;
	}


	/**
	 * Use user access token returned from Facebook API and try out different patterns to get get the movie fan count
	 * @param movieName
	 * @param token
	 * @param flag
	 * @return
	 */
	private String callFacebookAPI(String movieName, String token, int flag) {
		// TODO Auto-generated method stub
		String addedPart = "";
		String output = "";
		HttpURLConnection conn = null;
		String responseMessage="";
		String movie = movieName;
		try{
			if(flag==0){
				conn = hitFacebookGraphURL(movie, token, addedPart);
				responseMessage = conn.getResponseMessage();
				if(conn.getResponseCode() == 200){
					String outputValues = fetchDataFromConnection(conn);
					String category = findACategory(outputValues);
					if(category.equalsIgnoreCase("Fictional Character")||category.equalsIgnoreCase("Movie")){
						output = outputValues;
					}
					else{
						flag = 1;
						output = callFacebookAPI(movie, token, flag);
					}
				}
				else{
					flag = 1;
					output = callFacebookAPI(movie, token, flag);
				}
			}
			else if(flag == 1){
				addedPart = "Official";
				conn = hitFacebookGraphURL(movie, token, addedPart);
				if(conn.getResponseCode() == 200){
					String outputValues = fetchDataFromConnection(conn);
					String category = findACategory(outputValues);
					if(category.equalsIgnoreCase("Fictional Character")||category.equalsIgnoreCase("Movie")){
						output = outputValues;
					}
					else{
						flag = 2;
						output = callFacebookAPI(movie, token, flag);
					}
				}
				else{
					flag = 2;
					output = callFacebookAPI(movie, token, flag);
				}
			}
			else if(flag == 2){
				addedPart = "TheFilm";
				conn = hitFacebookGraphURL(movie, token, addedPart);
				if(conn.getResponseCode() == 200){
					String outputValues = fetchDataFromConnection(conn);
					String category = findACategory(outputValues);
					if(category.equalsIgnoreCase("Fictional Character")||category.equalsIgnoreCase("Movie")){
						output = outputValues;
					}
					else{
						flag = 3;
						output = callFacebookAPI(movie, token, flag);
					}
				}
				else{
					flag = 3;
					output = callFacebookAPI(movie, token, flag);
				}
			}
			else if(flag == 3){
				addedPart = "TheMovie";
				conn = hitFacebookGraphURL(movie, token, addedPart);
				if(conn.getResponseCode() == 200){
					String outputValues = fetchDataFromConnection(conn);
					String category = findACategory(outputValues);
					if(category.equalsIgnoreCase("Fictional Character")||category.equalsIgnoreCase("Movie")){
						output = outputValues;
					}
					else{
						flag = 4;
						output = callFacebookAPI(movie, token, flag);
					}
				}
				else{
					flag = 4;
					output = callFacebookAPI(movie, token, flag);
				}
			}
			else if(flag == 4){
				addedPart = "Mov";
				conn = hitFacebookGraphURL(movie, token, addedPart);
				if(conn.getResponseCode() == 200){
					String outputValues = fetchDataFromConnection(conn);
					String category = findACategory(outputValues);
					if(category.equalsIgnoreCase("Fictional Character")||category.equalsIgnoreCase("Movie")){
						output = outputValues;
					}
					else{
						flag = 5;
						output = callFacebookAPI(movie, token, flag);
					}
				}
				else{
					flag = 5;
					output = callFacebookAPI(movie, token, flag);
				}
			}
			else if(flag == 5){
				addedPart = "Movie";
				conn = hitFacebookGraphURL(movie, token, addedPart);
				if(conn.getResponseCode() == 200){
					String outputValues = fetchDataFromConnection(conn);
					String category = findACategory(outputValues);
					if(category.equalsIgnoreCase("Fictional Character")||category.equalsIgnoreCase("Movie")){
						output = outputValues;
					}
					else{
						flag = 6;
						output = callFacebookAPI(movie, token, flag);
					}
				}
				else{
					flag = 6;
					output = callFacebookAPI(movie, token, flag);
				}
			}
			else if(flag == 6){
				addedPart = "Film";
				conn = hitFacebookGraphURL(movie, token, addedPart);
				if(conn.getResponseCode() == 200){
					String outputValues = fetchDataFromConnection(conn);
					String category = findACategory(outputValues);
					if(category.equalsIgnoreCase("Fictional Character")||category.equalsIgnoreCase("Movie")){
						output = outputValues;
					}
					else{
						flag = 7;
						output = callFacebookAPI(movie, token, flag);
					}
				}
				else{
					flag = 7;
					output = callFacebookAPI(movie, token, flag);
				}
			}
			else{
				output = "Movie not found";
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			output = "Movie not found";
		}

		return output;
	}


	/**
	 * Make the call to Facecbook API with movie name created from above scenarios and get result
	 * @param movieName
	 * @param token
	 * @param addedPart
	 * @return
	 */
	private HttpURLConnection hitFacebookGraphURL(String movieName, String token, String addedPart) {
		// TODO Auto-generated method stub
		String domain = "https://graph.facebook.com/v2.8/";
		String fields = "?fields=id,name,fan_count,talking_about_count,category,genre&";

		movieName = movieName + addedPart;
		String graph = domain + movieName + fields + "access_token=" + token;
		System.out.println("graph url---> "+graph);

		HttpURLConnection conn = null;
		URL graphURL;
		try {
			graphURL = new URL(graph);
			conn = (HttpURLConnection) graphURL.openConnection();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		}
		return conn;
	}


	/**
	 * Fetch data from the url hit
	 * @param conn
	 * @return
	 */
	private String fetchDataFromConnection(HttpURLConnection conn) {
		// TODO Auto-generated method stub
		String finalOP = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String output;
			System.out.println("Output from Server .... ");

			while ((output = br.readLine()) != null) {
				System.out.println(output);
				finalOP = output;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		}

		conn.disconnect();
		return finalOP;
	}


	/**
	 * Find category of the data we received to check if it is movie or something else
	 * @param outputValues
	 * @return
	 */
	private String findACategory(String outputValues) {
		// TODO Auto-generated method stub
		String[] outputThings = outputValues.split(",");
		String category = outputThings[4].split(":")[1];
		category = category.replaceAll("[^a-zA-Z0-9 ]", "");
		System.out.println(category);
		return category;
	}


	/**
	 * Calls the Twitter API for getting user access token
	 * @param movieName
	 * @param flag
	 * @return
	 */
	private String fetchTwitterResponse(String movieName, int flag) {
		// TODO Auto-generated method stub
		String AccessToken = "806978634489745413-C2UXCq9v3tuuxPlfOm7hhbuUBhErdI2";
		String AccessSecret = "1j8oqhPh5npyrqs8m6gzXwIRTUWxglnNrR2eSU8f2JVSI";
		String ConsumerKey = "TTRd8m5cY1RDKv7DGhVwEOv2l";
		String ConsumerSecret = "So5LYa4CmFqX4qU8IukkgxAwDsqDdJ2OGXeXzKSvlXl8cMkI2Z";

		System.out.println("Keys set");
		String response = "";
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(
				ConsumerKey,
				ConsumerSecret);

		consumer.setTokenWithSecret(AccessToken, AccessSecret);

		try {
			HttpGet request1 = new HttpGet("https://api.twitter.com/1.1/users/show.json?screen_name=" + movieName);
			consumer.sign(request1);
			HttpClient client = new DefaultHttpClient();
			HttpResponse response1;
			try {
				response1 = client.execute(request1);
				int statusCode = response1.getStatusLine().getStatusCode();
				System.out.println(statusCode + ":" + response1.getStatusLine().getReasonPhrase());
				if(statusCode != 200){
					if(flag==1){
						movieName = movieName+"Official";
						fetchTwitterResponse(movieName,2);
					}if(flag==2){
						movieName = movieName+"TheFilm";
						fetchTwitterResponse(movieName,3);
					}if(flag==3){
						movieName = movieName+"TheMovie";
						fetchTwitterResponse(movieName,4);
					}if(flag==4){
						movieName = movieName+"Mov";
						fetchTwitterResponse(movieName,5);
					}if(flag==5){
						movieName = movieName+"Movie";
						fetchTwitterResponse(movieName,6);
					}if(flag==6){
						movieName = movieName+"Film";
						fetchTwitterResponse(movieName,7);
					}else{
						System.out.println("Movie not found");
					}

					//					fetchTwitterResponse(movieName, flag);
				}else{

					response = IOUtils.toString(response1.getEntity().getContent());
					System.out.println("Movie name:"+movieName);
					System.out.println("Message:"+response);
				}
				twitMovie = movieName;
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("-->"+e.getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("-->"+e.getMessage());
			}

		} catch (OAuthMessageSignerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		} catch (OAuthExpectationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		} catch (OAuthCommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		}

		return response;
	}

	private String fetchTwitterTagsAndLocs(String movieName, String minID, int call, int flag) {
		// TODO Auto-generated method stub
		String AccessToken = "806978634489745413-C2UXCq9v3tuuxPlfOm7hhbuUBhErdI2";
		String AccessSecret = "1j8oqhPh5npyrqs8m6gzXwIRTUWxglnNrR2eSU8f2JVSI";
		String ConsumerKey = "TTRd8m5cY1RDKv7DGhVwEOv2l";
		String ConsumerSecret = "So5LYa4CmFqX4qU8IukkgxAwDsqDdJ2OGXeXzKSvlXl8cMkI2Z";

		System.out.println("Keys set");
		String response = "";
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(
				ConsumerKey,
				ConsumerSecret);

		consumer.setTokenWithSecret(AccessToken, AccessSecret);

		HttpGet request1=null;
		try {

			if(flag==0){
				System.out.println("Calling without"+minID);
				request1 = new HttpGet("https://api.twitter.com/1.1/search/tweets.json?q=%23"+movieName+"&count=100");
			}else{
				System.out.println("Calling with"+minID);
				long maxID= Long.parseLong(minID);
				maxID = maxID-1;
				request1 = new HttpGet("https://api.twitter.com/1.1/search/tweets.json?q=%23"+movieName+"&count=100&max_id="+maxID);
			}
			consumer.sign(request1);
			HttpClient client = new DefaultHttpClient();
			HttpResponse response1;
			try {
				response1 = client.execute(request1);
				int statusCode = response1.getStatusLine().getStatusCode();
				System.out.println(statusCode + ":" + response1.getStatusLine().getReasonPhrase());
				if(statusCode != 200){
					if(call==0){
						movieName = movieName+"Official";
						fetchTwitterTagsAndLocs(movieName,minID,2,flag);
					}if(call==2){
						movieName = movieName+"TheFilm";
						fetchTwitterTagsAndLocs(movieName,minID,3,flag);
					}if(call==3){
						movieName = movieName+"TheMovie";
						fetchTwitterTagsAndLocs(movieName,minID,4,flag);
					}if(call==4){
						movieName = movieName+"Mov";
						fetchTwitterTagsAndLocs(movieName,minID,5,flag);
					}if(call==5){
						movieName = movieName+"Movie";
						fetchTwitterTagsAndLocs(movieName,minID,6,flag);
					}if(call==6){
						movieName = movieName+"Film";
						fetchTwitterTagsAndLocs(movieName,minID,7,flag);
					}else{
						System.out.println("Movie not found");
					}
				}else{

					response = IOUtils.toString(response1.getEntity().getContent());
					System.out.println("Movie name:"+movieName);
					System.out.println("Message:"+response);
				}
				twitMovie = movieName;
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (OAuthMessageSignerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		} catch (OAuthExpectationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		} catch (OAuthCommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		}

		return response;
	}
	
	
	public void getData(String[] inputStr){
		Set<Float> ratings = new HashSet<Float>();

		Set<String> genres = new HashSet<String>();

		Map<String,Integer> genreLookup = new HashMap<String, Integer>();

		Set<String> languages = new HashSet<String>();

		Map<String,Integer> languageLookup = new HashMap<String, Integer>();

		Set<String> directors = new HashSet<String>();

		Map<String,ArrayList<Float>> directorsRating = new HashMap<String, ArrayList<Float>>();

		Map<String,Float> directorsRatingFinal = new HashMap<String, Float>();

		Set<String> actors = new HashSet<String>();

		Map<String,ArrayList<Float>> actorsRating = new HashMap<String, ArrayList<Float>>();

		Map<String,Float> actorsRatingFinal = new HashMap<String, Float>();

		Set<String> countrys = new HashSet<String>();

		Set<String> rateds = new HashSet<String>();

		Set<String> writers = new HashSet<String>();

		Map<String,ArrayList<Float>> writersRating = new HashMap<String, ArrayList<Float>>();

		Map<String,Float> writersRatingFinal = new HashMap<String, Float>();

		Set<String> years = new HashSet<String>();

		Map<String,Integer> typeLookup = new HashMap<String, Integer>();

		int count = 0;


		try {

			CsvReader dataC = new CsvReader("C:/Users/infer/Desktop/Fall16/BigData/Project/finalData/output6NewWithFbFinal.csv", ',');

			ArrayList<String[]> recs = new ArrayList<String[]>();
			int c = 0;
			while (dataC.readRecord()){
				recs.add(dataC.getValues());
			}

			recs.add(inputStr);

			for(String[] v : recs)
			{
				count++;
				String[] a = v;

				//Seperating released year
				int timez = 0;
				if(a[16].contains("-")){
					String[] yearD = a[16].split("-");
					Integer curYear = Integer.parseInt(yearD[2].trim());
					timez = curYear/10;
					years.add(String.valueOf(timez));
				}

				//Seperating ratings
				String[] rating = a[2].split(",");
				for(String z : rating){
					if(z.equals("N/A")){
						Float r = new Float(0);
						ratings.add(r);
					} else {
						ratings.add(Float.parseFloat(z));
					}

				}

				//Segeregating types
				String type[] = a[7].split(",");
				int t = 0;
				for(String z : type){
					if(!typeLookup.containsKey(z.trim())){
						typeLookup.put(z.trim(), t++);
					}
				}

				//Seperating genres
				String[] genre = a[3].split(",");
				for(String z : genre){
					genres.add(z.trim());
				}

				//Seperating languages
				String[] language = a[9].split(",");
				for(String z : language){
					languages.add(z.trim());
				}

				//Seperating director
				String[] director = a[10].split(",");
				for(String z : director){
					directors.add(z.trim());
					//managing Rating
					String dirRat = a[2];
					if(!dirRat.equals("N/A")){
						if(directorsRating.containsKey(z.trim())){
							directorsRating.get(z.trim()).add(Float.parseFloat(a[2]));

						} else {
							ArrayList<Float> rat = new ArrayList<Float>();
							rat.add(Float.parseFloat(a[2]));
							directorsRating.put(z.trim(), rat);
						}
					}


				}

				//Seperating actors
				String[] actor = a[12].split(",");
				for(String z : actor){
					actors.add(z.trim());
					//managing Rating
					String actorRat = a[2];
					if(!actorRat.equals("N/A")){
						if(actorsRating.containsKey(z.trim())){
							actorsRating.get(z.trim()).add(Float.parseFloat(a[2]));

						} else {
							ArrayList<Float> rat = new ArrayList<Float>();
							rat.add(Float.parseFloat(a[2]));
							actorsRating.put(z.trim(), rat);
						}
					}
				}

				//Seperating countrys
				String[] country = a[13].split(",");
				for(String z : country){
					countrys.add(z.trim());
				}

				//Seperating rated
				String[] rated = a[14].split(",");
				for(String z : rated){
					rateds.add(z.trim());
				}

				//Seperating writer
				String[] writer = a[15].split(",");
				for(String z : writer){
					writers.add(z.trim());
					//managing Rating
					String writerRat = a[2];
					if(!writerRat.equals("N/A")){
						if(writersRating.containsKey(z.trim())){
							writersRating.get(z.trim()).add(Float.parseFloat(a[2]));

						} else {
							ArrayList<Float> rat = new ArrayList<Float>();
							rat.add(Float.parseFloat(a[2]));
							writersRating.put(z.trim(), rat);
						}
					}
				}
			}

			int lan = 0;
			for(String cur : languages){
				languageLookup.put(cur, lan++);
			}
			int gen = 0;
			for(String cur : genres){
				genreLookup.put(cur, gen++);
			}

			for(String cur : genreLookup.keySet()){
				System.out.println(cur + "," + genreLookup.get(cur));
			}

			for(String key : directorsRating.keySet()){
				Float avg = (float) 0;
				for(Float a : directorsRating.get(key)){
					avg+=a;
				}
				avg = avg/ (float)  directorsRating.get(key).size();

				directorsRatingFinal.put(key, avg);


			}

			for(String key : actorsRating.keySet()){
				Float avg = (float) 0;
				for(Float a : actorsRating.get(key)){
					avg+=a;
				}
				avg = avg/ (float)  actorsRating.get(key).size();

				actorsRatingFinal.put(key, avg);

			}

			for(String key : writersRating.keySet()){
				Float avg = (float) 0;
				for(Float a : writersRating.get(key)){
					avg+=a;
				}
				avg = avg/ (float)  writersRating.get(key).size();

				writersRatingFinal.put(key, avg);


			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		}

		/*****************************************************************************
		 ******************************************************************************
		 ******************************************************************************/

		//		System.out.println("This is war || This is war");

		try {
			CsvReader dataC = new CsvReader("C:/Users/infer/Desktop/Fall16/BigData/Project/finalData/output6NewWithFbFinal.csv", ',');
			ArrayList<String[]> recs = new ArrayList<String[]>();
			int c = 0;
			while (dataC.readRecord()){
				recs.add(dataC.getValues());
			}

			recs.add(inputStr);


			CsvWriter csvOutput = new CsvWriter(new FileWriter("C:/Users/infer/Desktop/Fall16/BigData/Project/finalData/input"+System.currentTimeMillis()+".csv", true), ',');


			//while (data.readRecord())
			for(String[] h : recs)
			{

				float[] outData = new float[51];
				String[] a = h;//data.getValues();


				//Doing for release
				int timez = 0;
				if(a[16].contains("-")){
					String[] yearD = a[16].split("-");
					Integer curYear = Integer.parseInt(yearD[2].trim());
					timez = curYear/10;
				}


				//
				int min = 10;
				String yearz = a[0].substring(0, 4);
				int tz = Math.min((Integer.parseInt(yearz) - 1900) / 10, min);

				outData[tz] = (float) 1;

				//Doing for genre
				String[] genre = a[3].split(",");
				for(String z : genre){
					if(genreLookup.containsKey(z.trim())){
						int genreNum = genreLookup.get(z.trim());
						outData[10 + genreNum ] = (float) 1;
					}
				}

				//imdb votes
				String imdbCount = a[7].replace(",", "");
				if(!imdbCount.equals("N/A")){
					float dg = Float.parseFloat(imdbCount)/(float) 10000;
					if (dg < 3)
						outData[35 + 1] = (float) 3;
					else 
						outData[35 + 1] = Float.parseFloat(imdbCount)/(float) 10000;
				} else {
					outData[35 + 1] = (float) 3;
				}


				//Movie Type 3 reserved
				String type[] = a[7].split(",");
				int t = 0;
				for(String z : type){
					if(typeLookup.containsKey(z.trim())){
						outData[37 + typeLookup.get(z.trim())] = (float) 1;
					}
				}


				//Seperating director
				int dirCount = 0;
				float dirScore = 0;
				String[] director = a[10].split(",");
				dirCount = director.length;
				for(String z : director){
					if(directorsRatingFinal.containsKey(z.trim()))
						dirScore += directorsRatingFinal.get(z.trim());
					else dirScore += (float) 3;
				}
				outData[36 + 4] = dirScore/((float) (dirCount * 1));


				//Seperating actors
				int actorCount = 0;
				float actorScore = (float) 0;
				String[] actor = a[12].split(",");
				actorCount = actor.length;
				for(String z : actor){
					//actors.add(z.trim());
					if(actorsRatingFinal.containsKey(z.trim()))
						actorScore += actorsRatingFinal.get(z.trim());
					else actorScore += (float) 6;
				}
				outData[36 + 5] = actorScore/((float) (actorCount * 1));



				//Seperating writer
				int writerCount = 0;
				float writerScore = 0;
				String[] writer = a[15].split(",");
				writerCount = writer.length;
				for(String z : writer){
					if(writersRatingFinal.containsKey(z.trim()))
						writerScore += writersRatingFinal.get(z.trim());
					else writerScore += (float) 6;
				}
				outData[36 + 6] = writerScore/((float) (writerCount * 1));



				//the three extra things
				//1 	a[17] facebook follower

				//4 min
				//5 - 0-1000
				//6 - 1000-10000
				//7 - 10000-50000
				//8 - 50000- 200000
				//9 - 200000-1000000
				//10 - 1000000

				int twitterCnt = 4;
				String twitterFollow = a[17];
				if(twitterFollow.matches("^[0-9]*$")){
					int twittercount = Integer.parseInt(twitterFollow);
					boolean assigned = false;
					if(twittercount <= 1000){
						twitterCnt++;
						assigned = true;
					}
					if(twittercount <= 10000 && !assigned){
						twitterCnt++;
						assigned = true;
					}
					if(twittercount <= 50000 && !assigned){
						twitterCnt++;
						assigned = true;
					}
					if(twittercount <= 200000 && !assigned){
						twitterCnt++;
						assigned = true;
					}
					if(twittercount <= 1000000 && !assigned){
						twitterCnt++;
						assigned = true;
					}
					if(twittercount > 1000000 && !assigned){
						twitterCnt++;
						assigned = true;
					}	
				}

				outData[43] = (float) twitterCnt;

				//FB Follower Count

				//3 min
				//4 -0- 500
				//5 - 500 - 5000
				//6 - 2000 - 10000
				//7 - 10000 - 100000
				//8 -
				int fbTACnt = 3;
				String fbTAFollow = a[18];
				if(fbTAFollow.matches("^[0-9]*$")){
					//		System.out.println("Trying to parse:"+fbTAFollow);
					int fbTAFollowcount = Integer.parseInt(fbTAFollow);
					boolean assigned = false;
					if(fbTAFollowcount <= 500 && !assigned){
						fbTACnt ++;
						assigned = true;
					}
					if(fbTAFollowcount <= 5000 && !assigned){
						fbTACnt++;
						assigned = true;
					}
					if(fbTAFollowcount <= 10000 && !assigned){
						fbTACnt++;
						assigned = true;
					}
					if(fbTAFollowcount <= 100000 && !assigned){
						fbTACnt++;
						assigned = true;
					}
					if(fbTAFollowcount > 100000 && !assigned){
						fbTACnt++;
						assigned = true;
					}	
				}

				outData[44] = (float) fbTACnt;

				//FB Fan Count
				//Same logic as twitter count
				//
				int fbFCnt = 4;
				String fbFollow = a[19];
				if(fbFollow.matches("^[0-9]*$")){
					int fbFollowcount = Integer.parseInt(fbFollow);
					boolean assigned = false;
					if(fbFollowcount <= 1000){
						fbFCnt++;
						assigned = true;
					}
					if(fbFollowcount <= 10000 && !assigned){
						fbFCnt++;
						assigned = true;
					}
					if(fbFollowcount <= 50000 && !assigned){
						fbFCnt++;
						assigned = true;
					}
					if(fbFollowcount <= 200000 && !assigned){
						fbFCnt++;
						assigned = true;
					}
					if(fbFollowcount <= 1000000 && !assigned){
						fbFCnt++;
						assigned = true;
					}
					if(fbFollowcount > 1000000 && !assigned){
						fbFCnt++;
						assigned = true;
					}	
				}

				outData[45] = (float) fbFCnt;

				//Seperating ratings
				String ratingWa = a[2];
				int ratDec = 0;
				int ratNDec = 0;
				int range = 0;
				if(!ratingWa.equals("N/A")){
					float ratingsWa = Float.parseFloat(ratingWa) * (float) 10;
					ratDec = (int) ratingsWa / 10;
					ratNDec = (int) ratingsWa % 10;
					range = (int) (Float.parseFloat(ratingWa) /  2);
				}else{
					range = 5 / 2;
				}

				outData[46 + range] = (float) 1;
				String[] output = new String[outData.length];
				for(int i = 0; i < outData.length; i++){
					output[i] = String.valueOf(outData[i]);
				}

				String YoY = a[0];
				csvOutput.writeRecord(output);
			}

			csvOutput.close();

			dataC.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		}



		/********************************************************************/

		//		System.out.println("This is war 2 || This is war 2");

		try {

			CsvWriter csvOutput = new CsvWriter(new FileWriter("C:/Users/infer/Desktop/Fall16/BigData/Project/finalData/inputMini.csv", true), ',');


			//while (data.readRecord())
			for(int i = 0; i < 1 ; i++)
			{

				float[] outData = new float[51];

				String[] a = inputStr;//data.getValues();

				//Doing for release

				//
				int min = 10;
				String yearz = a[0].substring(0, 4);
				int tz = Math.min((Integer.parseInt(yearz) - 1900) / 10, min);

				outData[tz] = (float) 1;
				//

				//Doing for genre
				String[] genre = a[3].split(",");
				for(String z : genre){
					if(genreLookup.containsKey(z.trim())){
						int genreNum = genreLookup.get(z.trim());
						outData[10 + genreNum ] = (float) 1;
					}
				}

				//imdb votes
				String imdbCount = a[7].replace(",", "");
				if(!imdbCount.equals("N/A")){
					float dg = Float.parseFloat(imdbCount)/(float) 10000;
					if (dg < 3)
						outData[35 + 1] = (float) 3;
					else 
						outData[35 + 1] = Float.parseFloat(imdbCount)/(float) 10000;
				} else {
					outData[35 + 1] = (float) 0;
				}


				//Movie Type 3 reserved
				String type[] = a[7].split(",");
				int t = 0;
				for(String z : type){
					if(typeLookup.containsKey(z.trim())){
						outData[37 + typeLookup.get(z.trim())] = (float) 1;
					}
				}


				//Seperating director
				int dirCount = 0;
				float dirScore = 0;
				String[] director = a[10].split(",");
				dirCount = director.length;
				for(String z : director){
					if(directorsRatingFinal.containsKey(z.trim()))
						dirScore += directorsRatingFinal.get(z.trim());
					else dirScore += (float) 3;
				}
				outData[36 + 4] = dirScore/((float) (dirCount * 1));


				//Seperating actors
				int actorCount = 0;
				float actorScore = (float) 0;
				String[] actor = a[12].split(",");
				actorCount = actor.length;
				for(String z : actor){
					//actors.add(z.trim());
					if(actorsRatingFinal.containsKey(z.trim()))
						actorScore += actorsRatingFinal.get(z.trim());
					else actorScore += (float) 6;
				}
				outData[36 + 5] = actorScore/((float) (actorCount * 1));



				//Seperating writer
				int writerCount = 0;
				float writerScore = 0;
				String[] writer = a[15].split(",");
				writerCount = writer.length;
				for(String z : writer){
					if(writersRatingFinal.containsKey(z.trim()))
						writerScore += writersRatingFinal.get(z.trim());
					else writerScore += (float) 6;
				}
				outData[36 + 6] = writerScore/((float) (writerCount * 1));



				//the three extra things
				//1 	a[17] facebook follower

				//4 min
				//5 - 0-1000
				//6 - 1000-10000
				//7 - 10000-50000
				//8 - 50000- 200000
				//9 - 200000-1000000
				//10 - 1000000

				int twitterCnt = 4;
				String twitterFollow = a[17];
				if(twitterFollow.matches("^[0-9]*$")){
					int twittercount = Integer.parseInt(twitterFollow);
					boolean assigned = false;
					if(twittercount <= 1000){
						twitterCnt++;
						assigned = true;
					}
					if(twittercount <= 10000 && !assigned){
						twitterCnt++;
						assigned = true;
					}
					if(twittercount <= 50000 && !assigned){
						twitterCnt++;
						assigned = true;
					}
					if(twittercount <= 200000 && !assigned){
						twitterCnt++;
						assigned = true;
					}
					if(twittercount <= 1000000 && !assigned){
						twitterCnt++;
						assigned = true;
					}
					if(twittercount > 1000000 && !assigned){
						twitterCnt++;
						assigned = true;
					}	
				}

				outData[43] = (float) twitterCnt;

				//FB Follower Count

				//3 min
				//4 -0- 500
				//5 - 500 - 5000
				//6 - 2000 - 10000
				//7 - 10000 - 100000
				//8 -
				int fbTACnt = 3;
				String fbTAFollow = a[18];
				if(fbTAFollow.matches("^[0-9]*$")){
					int fbTAFollowcount = Integer.parseInt(fbTAFollow);
					boolean assigned = false;
					if(fbTAFollowcount <= 500 && !assigned){
						fbTACnt ++;
						assigned = true;
					}
					if(fbTAFollowcount <= 5000 && !assigned){
						fbTACnt++;
						assigned = true;
					}
					if(fbTAFollowcount <= 10000 && !assigned){
						fbTACnt++;
						assigned = true;
					}
					if(fbTAFollowcount <= 100000 && !assigned){
						fbTACnt++;
						assigned = true;
					}
					if(fbTAFollowcount > 100000 && !assigned){
						fbTACnt++;
						assigned = true;
					}	
				}

				outData[44] = (float) fbTACnt;

				//FB Fan Count
				//Same logic as twitter count
				//
				int fbFCnt = 4;
				String fbFollow = a[19];
				if(fbFollow.matches("^[0-9]*$")){
					int fbFollowcount = Integer.parseInt(fbFollow);
					boolean assigned = false;
					if(fbFollowcount <= 1000){
						fbFCnt++;
						assigned = true;
					}
					if(fbFollowcount <= 10000 && !assigned){
						fbFCnt++;
						assigned = true;
					}
					if(fbFollowcount <= 50000 && !assigned){
						fbFCnt++;
						assigned = true;
					}
					if(fbFollowcount <= 200000 && !assigned){
						fbFCnt++;
						assigned = true;
					}
					if(fbFollowcount <= 1000000 && !assigned){
						fbFCnt++;
						assigned = true;
					}
					if(fbFollowcount > 1000000 && !assigned){
						fbFCnt++;
						assigned = true;
					}	
				}

				outData[45] = (float) fbFCnt;

				//Seperating ratings
				String ratingWa = a[2];
				int ratDec = 0;
				int ratNDec = 0;
				int range = 0;
				if(!ratingWa.equals("N/A")){
					float ratingsWa = Float.parseFloat(ratingWa) * (float) 10;
					ratDec = (int) ratingsWa / 10;
					ratNDec = (int) ratingsWa % 10;
					range = (int) (Float.parseFloat(ratingWa) /  2);
				}else{
					range = 5 / 2;
				}

				outData[46 + range] = (float) 1;
				String[] output = new String[outData.length];
				for(int j = 0; j < outData.length; j++){
					output[j] = String.valueOf(outData[j]);
				}

				String YoY = a[0];
				csvOutput.writeRecord(output);


			}

			csvOutput.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("-->"+e.getMessage());
		}
	}
}