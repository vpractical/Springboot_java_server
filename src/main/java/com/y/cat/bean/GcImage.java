package com.y.cat.bean;

public class GcImage {
	private int id;
	/**
	 * 0=unknow;1=dnf;
	 */
	private int type;
	private String name;
	/**
	 * url=图片地址;link=引用地址;
	 */
	private String url,link;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
	
}
