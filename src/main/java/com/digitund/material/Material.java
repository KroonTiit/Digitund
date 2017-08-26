package com.digitund.material;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Material {
	@Id @GeneratedValue
	private long id;
	private long compMaterialId;
	private long orderNr;
	private String type;
	private String textContent;
	private long videoStart;
	private long videoEnd;
	private String youtubeId;
	private String imageUrl;
	public Material() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCompMaterialId() {
		return compMaterialId;
	}
	public void setCompMaterialId(long compMaterialId) {
		this.compMaterialId = compMaterialId;
	}
	public long getOrderNr() {
		return orderNr;
	}
	public void setOrderNr(long orderNr) {
		this.orderNr = orderNr;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTextContent() {
		return textContent;
	}
	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}
	public long getVideoStart() {
		return videoStart;
	}
	public void setVideoStart(long videoStart) {
		this.videoStart = videoStart;
	}
	public long getVideoEnd() {
		return videoEnd;
	}
	public void setVideoEnd(long videoEnd) {
		this.videoEnd = videoEnd;
	}
	public String getYoutubeId() {
		return youtubeId;
	}
	public void setYoutubeId(String youtubeId) {
		this.youtubeId = youtubeId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String description;
	
}
