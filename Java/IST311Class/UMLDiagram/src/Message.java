public class Message {
    public Person sender;
    public Person recipient;

    public String content;

    public Message(Person sender,Person recipient, String content) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
    }

    public void sendMessage(){

    }

    public Message receiveMessage(){
        return null;
    }
}
