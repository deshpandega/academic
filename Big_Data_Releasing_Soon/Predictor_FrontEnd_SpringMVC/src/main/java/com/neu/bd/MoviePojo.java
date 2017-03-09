/**
 * 
 */
package com.neu.bd;

import java.util.ArrayList;

/**
 * @author Gaurang Deshpande (deshpande.ga@husky.neu.edu)
 *
 */
public class MoviePojo {
	private String movieName;
	private String fanCount;
	private String trendingCount;
	private String category;
	private String genre;
	private String tweetFollowers;
	private ArrayList<String> idList;
	
	private String year;
	private String imdbVotes;
	private String imdbRating;
	private String type;
	private String actors;
	private String director;
	private String writer;
	
	private ArrayList<ArrayList<String>> hashTagsList;
	private ArrayList<ArrayList<String>> location;
	
	
	public ArrayList<String> getIdList() {
		return idList;
	}
	public void setIdList(ArrayList<String> idList) {
		this.idList = idList;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getFanCount() {
		return fanCount;
	}
	public void setFanCount(String fanCount) {
		this.fanCount = fanCount;
	}
	public String getTrendingCount() {
		return trendingCount;
	}
	public void setTrendingCount(String trendingCount) {
		this.trendingCount = trendingCount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getTweetFollowers() {
		return tweetFollowers;
	}
	public void setTweetFollowers(String tweetFollowers) {
		this.tweetFollowers = tweetFollowers;
	}
	public ArrayList<ArrayList<String>> getHashTagsList() {
		return hashTagsList;
	}
	public void setHashTagsList(ArrayList<ArrayList<String>> hashTagsList) {
		this.hashTagsList = hashTagsList;
	}
	public ArrayList<ArrayList<String>> getLocation() {
		return location;
	}
	public void setLocation(ArrayList<ArrayList<String>> location) {
		this.location = location;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
}