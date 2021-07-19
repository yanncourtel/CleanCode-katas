package zenika.supple.sym;

//Détecter le smell et proposer un refactor
public interface MonetaryAmount {

    MonetaryAmount plus(MonetaryAmount that);

    void substract(MonetaryAmount that);

}
