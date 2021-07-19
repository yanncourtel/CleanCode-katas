package zenika.supple.vo;

import java.util.Optional;

public class BiddingService {
    
    private final ExistingBids auctions;
    private final Rates exchange;

    public BiddingService(ExistingBids auctions, Rates exchange) {
        this.auctions = auctions;
        this.exchange = exchange;
    }

    public BidOutcome bid(AuctionId auction, Bid bid) {
        Optional<Bid> highestBid =  auctions.findHighestBidOn(auction);
        
        return highestBid
                .filter(b -> b.isHigherThan(bid, exchange))
                .map(b -> BidOutcome.LOSING)
                .orElse(BidOutcome.WINNING);
    }
    
}
