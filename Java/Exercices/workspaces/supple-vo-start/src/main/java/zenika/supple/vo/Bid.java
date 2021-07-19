package zenika.supple.vo;

import static java.util.Objects.requireNonNull;

public class Bid {

    private final AuctionId auction;
    private final int amount;
    private final String currencyCode;

    private Bid(AuctionId auction, int amount, String currencyCode) {
        this.auction = auction;
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    public boolean isHigherThan(Bid b, Rates r) {
        requireNonNull(b);
        requireNonNull(r);

        double rate = r.from(b.currencyCode).to(this.currencyCode);
        int otherBidAmountInSameCurrency = (int) Math.round(b.amount * rate);
        return this.amount >= otherBidAmountInSameCurrency;
    }



    public static BidBuilder on(AuctionId auction) {
        return new BidBuilder(auction);
    }

    public static class BidBuilder {
        private AuctionId auction;

        public BidBuilder(AuctionId auction) {
            this.auction = auction;
        }

        public Bid at(int amount, String currency) {
            return new Bid(auction, amount, currency);
        }
    }
}
