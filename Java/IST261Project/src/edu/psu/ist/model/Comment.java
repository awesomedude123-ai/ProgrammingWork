package edu.psu.ist.model;

public class Comment {

    private static int newId=0;
    private String name;

    private User user;

    private String message;

    private int conversationId = 0;
    private static int currentMaxConvo=0;


    public Comment(String name, User user, String message) {
        this.name = name;
        this.user = user;
        this.message = message;
        newId++;
        currentMaxConvo++;
        this.conversationId=currentMaxConvo;
    }

    public Comment(String name, User user, String message, int conversationId) {
        this.name = name;
        this.user = user;
        this.message = message;
        this.conversationId = conversationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static int getNewId() {
        return newId;
    }

    public static void setNewId(int newId) {
        Comment.newId = newId;
    }

    public int getConversationId() {
        return conversationId;
    }

    public void setConversationId(int conversationId) {
        this.conversationId = conversationId;
    }

    public static int getCurrentMaxConvo() {
        return currentMaxConvo;
    }

    public static void setCurrentMaxConvo(int currentMaxConvo) {
        Comment.currentMaxConvo = currentMaxConvo;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "name='" + name + '\'' +
                ", user=" + user.getName() +
                ", message='" + message + '\'' +
                ", conversation id='" + conversationId + '\'';
    }

    public boolean decideToInsert(Comment comment){
        if(this.conversationId == comment.getConversationId()){
            return true;
        }
        return false;
    }
}
