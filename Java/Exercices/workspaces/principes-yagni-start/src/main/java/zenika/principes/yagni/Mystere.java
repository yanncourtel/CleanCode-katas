package zenika.principes.yagni;

public class Mystere {
    
    public static void main(String[] args) {
        MessageBody mb = new MessageBody();
        mb.configure("Hello World!");
        StrategyFactory asf = DefaultStrategyFactory.getInstance();
        MessageStrategy strategy = asf.createStrategy(mb);
        mb.send(strategy);
    }
    
}
