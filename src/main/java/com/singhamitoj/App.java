package com.singhamitoj;

import java.util.HashMap;

public class App {
	int mm = 0;

	public static void main(String[] args) {
		System.out.println("Hello World!");

		App p = new App();
		Auctions auction = p.createAuctionForPen();
		Bidder winner = p.findWinnerBidder(auction.getBidders());
		System.out.println("Winning bid is " + winner.getMaxPossibleBid() + " and Bidder is " + winner.getName()
				+ "for Item " + auction.getItem().getItemName());

		Auctions auction2 = p.createAuctionForPencil();
		Bidder winner2 = p.findWinnerBidder(auction2.getBidders());
		System.out.println("Winning bid is " + winner2.getMaxPossibleBid() + " and Bidder is " + winner2.getName()
				+ "for Item " + auction2.getItem().getItemName());
	}

	public Auctions createAuctionForPen() {
		int i = 0;
		Auctions auction = new Auctions();
		Items item = getItem("Pen", 1, "pen is being auctioned");
		Bidder b1 = getBidder("linda", 31, 11, 96);
		Bidder b2 = getBidder("dave", 91, 5, 92);
		Bidder b3 = getBidder("eric", 4, 3, 96);
		HashMap<Integer, Bidder> bidders = new HashMap<Integer, Bidder>();
		bidders.put(i++, b1);
		bidders.put(i++, b2);
		bidders.put(i++, b3);
		auction.setItem(item);
		auction.setBidders(bidders);

		return auction;
	}

	public Auctions createAuctionForPencil() {
		int i = 0;
		Auctions auction = new Auctions();
		Items item = getItem("Pencil", 1, "pencil is being auctioned");
		Bidder b1 = getBidder("linda", 31, 11, 96);
		Bidder b2 = getBidder("dave", 91, 5, 92);
		Bidder b3 = getBidder("eric", 4, 3, 96);
		HashMap<Integer, Bidder> bidders = new HashMap<Integer, Bidder>();
		bidders.put(i++, b1);
		bidders.put(i++, b2);
		bidders.put(i++, b3);
		auction.setItem(item);
		auction.setBidders(bidders);

		return auction;
	}

	public Items getItem(String itemName, int itemId, String itemDescription) {
		return new Items(itemName, itemId, itemDescription);
	}

	public Bidder getBidder(String bidderName, int startBid, int auto, int max) {
		return new Bidder(startBid, auto, max, getMaxBidPossible(startBid, auto, max), bidderName, mm++);
	}

	public int getMaxBidPossible(int startBid, int auto, int max) {
		return ((max - startBid) / auto) * auto + startBid;
	}

	public Bidder findWinnerBidder(HashMap<Integer, Bidder> bb) {
		Bidder firstMaxBidder;
		Bidder secondtMaxBidder;
		if (bb.size() < 1)
			return bb.get(0);
		else {
			firstMaxBidder = bb.get(0);
			if (bb.get(1).getMaxPossibleBid() > bb.get(0).getMaxPossibleBid()) {

				secondtMaxBidder = firstMaxBidder;
				firstMaxBidder = bb.get(1);
			} else {
				secondtMaxBidder = bb.get(1);
			}
			for (int j = 2; j < bb.size(); j++) {
				if (bb.get(j).getMaxPossibleBid() > firstMaxBidder.getMaxPossibleBid()) {
					secondtMaxBidder = firstMaxBidder;
					firstMaxBidder = bb.get(j);
				} else if (bb.get(j).getMaxPossibleBid() > secondtMaxBidder.getMaxPossibleBid()) {
					secondtMaxBidder = bb.get(j);
				}
			}
			System.out.println(firstMaxBidder.getMaxPossibleBid() + " " + secondtMaxBidder.getMaxPossibleBid());
			if (firstMaxBidder.getStartBid() > secondtMaxBidder.getMaxBid()) {
				firstMaxBidder.setMaxPossibleBid(firstMaxBidder.getStartBid());
				return firstMaxBidder;
			}

			if (firstMaxBidder.getMaxPossibleBid() - secondtMaxBidder.getMaxPossibleBid() >= firstMaxBidder
					.getIncrement()) {
				if ((secondtMaxBidder.getMaxPossibleBid() - firstMaxBidder.getStartBid())
						% firstMaxBidder.getIncrement() == 0) {
					if (firstMaxBidder.getBidderId() < secondtMaxBidder.getBidderId())
						firstMaxBidder.setMaxPossibleBid(secondtMaxBidder.getMaxPossibleBid());
					return firstMaxBidder;
				} else {
					firstMaxBidder
							.setMaxPossibleBid(secondtMaxBidder.getMaxPossibleBid() + firstMaxBidder.getIncrement()
									- (secondtMaxBidder.getMaxPossibleBid() - firstMaxBidder.getStartBid())
											% firstMaxBidder.getIncrement());
					return firstMaxBidder;
				}
			} else
				return firstMaxBidder;

		}
	}

}
