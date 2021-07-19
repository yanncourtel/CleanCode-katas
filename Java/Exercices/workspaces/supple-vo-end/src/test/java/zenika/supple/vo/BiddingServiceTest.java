package zenika.supple.vo;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static zenika.supple.vo.BidOutcome.LOSING;
import static zenika.supple.vo.BidOutcome.WINNING;


public class BiddingServiceTest {

    private final AuctionId theAuction = new AuctionId();
    private final Bid
            lowBid          = Bid.on(theAuction).at(new MonetaryAmount(        1, "EUR")),
            midBidInEuros   = Bid.on(theAuction).at(new MonetaryAmount(      100, "EUR")),
            midBidInDollars = Bid.on(theAuction).at(new MonetaryAmount(      100, "USD")),
            highBid         = Bid.on(theAuction).at(new MonetaryAmount(1_000_000, "EUR"));

    private final Rates rates = eurosAreWorthTwiceAsMuchAsDollars();
    private final ExistingBids existingBids = mock(ExistingBids.class);
    private final BiddingService bidding = new BiddingService(existingBids, rates);


    @Test public void should_be_winning_when_no_other_bids() {
        whenThereAreNoBids();
            assertThat(outcomeOfPlacingMidBid()).isEqualTo(WINNING);
    }

    @Test public void should_be_winning_when_bid_is_higher() {
        whenHighestBidIs(lowBid);
            assertThat(outcomeOfPlacingMidBid()).isEqualTo(WINNING);
    }

    @Test public void should_be_losing_when_bid_is_lower() {
        whenHighestBidIs(highBid);
            assertThat(outcomeOfPlacingMidBid()).isEqualTo(LOSING);
    }

    @Test public void should_be_winning_when_bid_has_same_amount_in_higher_currency() {
        whenHighestBidIs(midBidInDollars);
            assertThat(outcomeOfPlacingMidBid()).isEqualTo(WINNING);
    }

    @Test public void should_be_losing_when_bid_has_same_amount_in_lower_currency() {
        whenHighestBidIs(midBidInEuros);
            assertThat(outcomeOfPlacingMidBidInDollars()).isEqualTo(LOSING);
    }



    private Rates eurosAreWorthTwiceAsMuchAsDollars() {
        Rates rates = mock(Rates.class);
        when(rates.from("EUR")).thenReturn(usd -> 2.0);
        when(rates.from("USD")).thenReturn(eur -> 0.5);
        return rates;
    }

    private void whenHighestBidIs(Bid b) {
        whenHighestBidIs(Optional.of(b));
    }
    private void whenThereAreNoBids() {
        whenHighestBidIs(Optional.empty());
    }
    private void whenHighestBidIs(Optional<Bid> b) {
        when(existingBids.findHighestBidOn(any())).thenReturn(b);
    }

    private BidOutcome outcomeOfPlacingMidBid() {
        return bidding.bid(theAuction, midBidInEuros);
    }
    private BidOutcome outcomeOfPlacingMidBidInDollars() {
        return bidding.bid(theAuction, midBidInDollars);
    }

}
