package zenika.supple.vo;

import static java.util.Objects.requireNonNull;

//1. Quels sont les pbs ds cette classe? 
// -->Absence de validation, mélange de préoccupations, duplication 
//   Proposer un refactor.
// --> Introduire un VO MonetaryAmount ou utiliser Joda Money
// (Dans la suite on suppose qu'on a codé notre propre MonetaryAmount)
// --> Comportement:
//        -Encapsulation magnitude + unité (pattern Quantity de Fowler)
//        -Egalité
//        -Comparaison
//        -Validation (dès la construction)
//        -Comparaison
//2. En dehors de la validation, conversion, et comparaison qu'on vient de mettre, 
//   quels autres comportement pourrait-on placer sur MonetaryAmount?
// --> par ex:
//  -Parse/format: Conversion depuis/vers représentation textuelle
//  -Parse/format: Conversion depuis/vers représentation textuelle
//  -Opérations "internes" (restant ds le mm type): + * / - etc..
//  -etc.. Comportement propre au domaine particulier
public class Bid {

    private final AuctionId auction;
    private final MonetaryAmount amount;

    private Bid(AuctionId auction, MonetaryAmount amount) {
        this.auction = requireNonNull(auction);
        this.amount = requireNonNull(amount);//On est sur que Amount est valide si non-null
    }

    public boolean isHigherThan(Bid that, Rates r) {
        return this.amount.isBiggerThan(that.amount, r);
    }
    
    
    
    public static BidBuilder on(AuctionId auction) {
        return new BidBuilder(auction);
    }
    
    public static class BidBuilder {
        private AuctionId auction;

        public BidBuilder(AuctionId auction) {
            this.auction = auction;
        }

        public Bid at(MonetaryAmount amount) {
            return new Bid(auction, amount);
        }
    }
}
