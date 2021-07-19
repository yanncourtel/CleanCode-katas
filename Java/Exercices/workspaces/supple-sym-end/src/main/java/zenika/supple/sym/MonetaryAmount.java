package zenika.supple.sym;

public interface MonetaryAmount {
    
    MonetaryAmount plus(MonetaryAmount that);
    
    MonetaryAmount minus(MonetaryAmount that);
    
}
