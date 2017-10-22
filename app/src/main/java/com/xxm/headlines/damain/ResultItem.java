package com.xxm.headlines.damain;

public class ResultItem {
	/*作者*/
	private String author_name;
	/*类型*/
	private String category;
	/*时间*/
	private String date;
	/*图片1*/
	private String thumbnail_pic_s;
	/*图片2*/
	private String thumbnail_pic_s02;
	/*图片3*/
	private String thumbnail_pic_s03;
	/*标题*/
	private String title;
	/*唯一标识*/
	private String uniquekey;
	/*新闻链接*/
	private String url;
	
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getThumbnail_pic_s() {
		return thumbnail_pic_s;
	}
	public void setThumbnail_pic_s(String thumbnail_pic_s) {
		this.thumbnail_pic_s = thumbnail_pic_s;
	}
	public String getThumbnail_pic_s02() {
		return thumbnail_pic_s02;
	}
	public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
		this.thumbnail_pic_s02 = thumbnail_pic_s02;
	}
	public String getThumbnail_pic_s03() {
		return thumbnail_pic_s03;
	}
	public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
		this.thumbnail_pic_s03 = thumbnail_pic_s03;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUniquekey() {
		return uniquekey;
	}
	public void setUniquekey(String uniquekey) {
		this.uniquekey = uniquekey;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "ResultItem [author_name=" + author_name + ", category=" + category + ", date=" + date
				+ ", thumbnail_pic_s=" + thumbnail_pic_s + ", thumbnail_pic_s02=" + thumbnail_pic_s02
				+ ", thumbnail_pic_s03=" + thumbnail_pic_s03 + ", title=" + title + ", uniquekey=" + uniquekey
				+ ", url=" + url + "]";
	}
	
	
}
