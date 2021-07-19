package zenika.principes.yagni;

public class DefaultStrategyFactory implements StrategyFactory {
    private DefaultStrategyFactory() {
    }

    static DefaultStrategyFactory instance;

    public static StrategyFactory getInstance() {
        if (instance == null)
            instance = new DefaultStrategyFactory();
        return instance;
    }

    public MessageStrategy createStrategy(final MessageBody mb) {
        return new MessageStrategy() {
            MessageBody body = mb;

            public void sendMessage() {
                Object obj = body.getPayload();
                System.out.println(obj);
            }
        };
    }
}