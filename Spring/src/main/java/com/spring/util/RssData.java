package com.spring.util;

/**
 * @FileName	 : RssData.java
 * @Project      : cla-madame-core
 * @Date         : 2010. 4. 29. 
 * @작성자       : 김성복
 * @변경이력	 : 
 * @프로그램설명 : Rss파서
 */
public class RssData {

	private String title;
	private String date;
	private String link;
	private String category;
	private String content;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
