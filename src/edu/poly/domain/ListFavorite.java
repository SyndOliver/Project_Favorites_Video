package edu.poly.domain;

import java.util.Date;

public class ListFavorite {
	private String favoriteId;
	private String usename;
	private String videoId;
	private Date likeDate;
	private String title;
	private String poster;
	private String description;
	
	
	
	
	public ListFavorite() {
	}
	public ListFavorite(String favoriteId, String usename, String videoId, Date likeDate, String title, String poster,
			String description) {
		
		this.favoriteId = favoriteId;
		this.usename = usename;
		this.videoId = videoId;
		this.likeDate = likeDate;
		this.title = title;
		this.poster = poster;
		this.description = description;
	}
	public String getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(String favoriteId) {
		this.favoriteId = favoriteId;
	}
	public String getUsename() {
		return usename;
	}
	public void setUsename(String usename) {
		this.usename = usename;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
