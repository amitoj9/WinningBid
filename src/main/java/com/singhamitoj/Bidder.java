package com.singhamitoj;

public class Bidder {
	
	private int startBid;
	private int increment;
	private int maxBid;
	private int maxPossibleBid;
	private String name;
	private int bidderId;
	public int getBidderId() {
		return bidderId;
	}
	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}
	public int getStartBid() {
		return startBid;
	}
	public void setStartBid(int startBid) {
		this.startBid = startBid;
	}
	public int getIncrement() {
		return increment;
	}
	public void setIncrement(int increment) {
		this.increment = increment;
	}
	public int getMaxBid() {
		return maxBid;
	}
	public void setMaxBid(int maxBid) {
		this.maxBid = maxBid;
	}
	public int getMaxPossibleBid() {
		return maxPossibleBid;
	}
	public void setMaxPossibleBid(int maxPossibleBid) {
		this.maxPossibleBid = maxPossibleBid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Bidder(int startBid, int increment, int maxBid, int maxPossibleBid, String name,int bidderId) {
	
		this.startBid = startBid;
		this.increment = increment;
		this.maxBid = maxBid;
		this.maxPossibleBid = maxPossibleBid;
		this.name = name;
		this.bidderId=bidderId;
	}
	
}
