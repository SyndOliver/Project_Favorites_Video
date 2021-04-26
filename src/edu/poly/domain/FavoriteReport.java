package edu.poly.domain;

import java.util.Date;

public class FavoriteReport {
	private String videoTitle;
	private Long favoriteCount;
	private Date newesDate;
	private Date oldesDate;
	
	
	public FavoriteReport() {
		
	}
	
	public FavoriteReport(String videoTitle, Long favoriteCount, Date newesDate, Date oldesDate) {
		this.videoTitle = videoTitle;
		this.favoriteCount = favoriteCount;
		this.newesDate = newesDate;
		this.oldesDate = oldesDate;
	}

	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public Long getFavoriteCount() {
		return favoriteCount;
	}
	public void setFavoriteCount(Long favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	public Date getNewesDate() {
		return newesDate;
	}
	public void setNewesDate(Date newesDate) {
		this.newesDate = newesDate;
	}
	public Date getOldesDate() {
		return oldesDate;
	}
	public void setOldesDate(Date oldesDate) {
		this.oldesDate = oldesDate;
	}
	
}
