package zenika.principes.yagni;

public class MessageBody {
Object payload;
public Object getPayload() {
return payload;
}
public void configure(Object obj) {
payload = obj;
}
public void send(MessageStrategy ms) {
ms.sendMessage();
}
}
