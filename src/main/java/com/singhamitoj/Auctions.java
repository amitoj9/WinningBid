package com.singhamitoj;

import java.util.HashMap;

public class Auctions {
	
	Items item;
	HashMap<Integer,Bidder> bidders;
	public Items getItem() {
		return item;
	}
	public void setItem(Items item) {
		this.item = item;
	}
	public HashMap<Integer, Bidder> getBidders() {
		return bidders;
	}
	public void setBidders(HashMap<Integer, Bidder> bidders) {
		this.bidders = bidders;
	}

}
