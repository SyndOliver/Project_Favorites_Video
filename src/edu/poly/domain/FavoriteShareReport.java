package edu.poly.domain;

import java.util.Date;

public class FavoriteShareReport {
	private String username,videoId,emails;
	private Date shareDate;
	
	public FavoriteShareReport() {
	}
	public FavoriteShareReport(String username, String videoId, String emails, Date shareDate) {
		this.username = username;
		this.videoId = videoId;
		this.emails = emails;
		this.shareDate = shareDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getEmails() {
		return emails;
	}
	public void setEmails(String emails) {
		this.emails = emails;
	}
	public Date getShareDate() {
		return shareDate;
	}
	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}
	
	
}
