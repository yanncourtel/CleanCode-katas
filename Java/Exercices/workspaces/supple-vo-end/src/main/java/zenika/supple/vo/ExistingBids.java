package zenika.supple.vo;

import java.util.Optional;

public interface ExistingBids {
    
    Optional<Bid> findHighestBidOn(AuctionId auction);
    
}
