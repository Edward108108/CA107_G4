package com.Goods;

import java.io.Serializable;

	public class GoodsVO implements Serializable{
	private String goodId;
	private String teacherId;
	private String goodName;
	private Double goodPrice;
	private String goodInfo;
	private byte[] goodImg;
	private Double goodStatus;
	
	public GoodsVO() {
		super();
	}
	public GoodsVO(String goodId, String teacherId, String goodName, Double goodPrice, String goodInfo, byte[] goodImg,
			Double goodStatus) {
		super();
		this.goodId = goodId;
		this.teacherId = teacherId;
		this.goodName = goodName;
		this.goodPrice = goodPrice;
		this.goodInfo = goodInfo;
		this.goodImg = goodImg;
		this.goodStatus = goodStatus;
	}
	
	public String getGoodId() {
		return goodId;
	}
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public Double getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(Double goodPrice) {
		this.goodPrice = goodPrice;
	}
	public String getGoodInfo() {
		return goodInfo;
	}
	public void setGoodInfo(String goodInfo) {
		this.goodInfo = goodInfo;
	}
	public byte[] getGoodImg() {
		return goodImg;
	}
	public void setGoodImg(byte[] goodImg) {
		this.goodImg = goodImg;
	}
	public Double getGoodStatus() {
		return goodStatus;
	}
	public void setGoodStatus(Double goodStatus) {
		this.goodStatus = goodStatus;
	}
	@Override
	public String toString() {
		return "GoodsVO [goodId=" + goodId + ", teacherId=" + teacherId + ", goodName=" + goodName + ", goodPrice="
				+ goodPrice + ", goodInfo=" + goodInfo + ", goodImg=" + goodImg + ", goodStatus=" + goodStatus + "]";
	}
	
}
