package zenika.principes.yagni;

public interface StrategyFactory {
     MessageStrategy createStrategy(MessageBody mb);
}
