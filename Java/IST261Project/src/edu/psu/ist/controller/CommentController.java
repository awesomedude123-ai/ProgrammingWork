package edu.psu.ist.controller;

import edu.psu.ist.model.Comment;
import edu.psu.ist.model.SchoolType;
import edu.psu.ist.model.StudentUser;

import java.util.LinkedList;
import java.util.ListIterator;

public class CommentController {
    LinkedList<LinkedList<Comment>> comments = new LinkedList<>();

    public CommentController() {
        createInitialComments();

    }

    public void createInitialComments() {
        StudentUser user1 = new StudentUser("Sri", 2, SchoolType.Undergraduate, "PSU");
        StudentUser user2 = new StudentUser("Jake", 1, SchoolType.Undergraduate, "OSU");
        StudentUser user3 = new StudentUser("John", 4, SchoolType.Undergraduate, "Michigan");

        Comment comment1 = new Comment("This is cool", user1, "This is a cool message");
        Comment comment2 = new Comment("This is awesome", user2, "This is a awesome message");
        Comment comment3 = new Comment("This is cool 2", user3, "This is a cool message 2",1);


        System.out.println("-----------ADDING COMMENTS-----------");
        addComment(comment1);
        addComment(comment2);
        addComment(comment3);

        System.out.println("-----------PRINTING COMMENTS-----------");
        System.out.println(printComments());

        System.out.println("-----------REMOVING COMMENT-----------");
        removeComment(comment2);
        System.out.println("-----------PRINTING COMMENTS-----------");
        System.out.println(printComments());

        System.out.println("-----------GETTING COMMENT-----------");
        System.out.println(getComment(1,1).toString());

        System.out.println("-----------UPDATING COMMENT-----------");
        comment1.setName("This is really cool");
        System.out.println(printComments());
    }//end constructor

    public String printComments() {
        String value = "";
        ListIterator<LinkedList<Comment>> commentsIterator = this.comments.listIterator();
        while(commentsIterator.hasNext()) {
            LinkedList<Comment> commentList = commentsIterator.next();
            ListIterator<Comment> commentListIterator = commentList.listIterator();
            value+="[";
            while(commentListIterator.hasNext()) {
                Comment comment = commentListIterator.next();
                value=value + "\nName: "+comment.getName()+"\nMessage: "+comment.getMessage()+"\nUser: "+comment.getUser().getName()+"\n\n";
            }//end while loop
            value+="]\n";
        }//end while loop
        return value;
    }//end method

    public void addComment(Comment comment){
        boolean orderAdded = false;
        ListIterator<LinkedList<Comment>> commentsIterator = this.comments.listIterator();
        int index = -1;
        while(commentsIterator.hasNext()) {
            index++;
            LinkedList<Comment> commentsList = commentsIterator.next();
            boolean shoudldBeAdded = commentsList.get(0).decideToInsert(comment);
            if(shoudldBeAdded==true){
                commentsList.add(comment);
                this.comments.set(index,commentsList);
                orderAdded=true;
            }
        }
        if(orderAdded==false) {
            LinkedList<Comment> commentsList = new LinkedList<>();
            commentsList.add(comment);
            this.comments.add(commentsList);
        }
        System.out.println(this.comments.size());
    }

    public void removeComment(Comment comment) {
        int index = 0;
        boolean removed = false;
        for(LinkedList<Comment> list : this.comments){
            for(Comment comment1 : list){
                if(comment1.equals(comment)) {
                    list.remove(comment);
                    if(list.isEmpty()) {
                        this.comments.remove(index);
                    }else{
                        this.comments.set(index,list);
                    }

                    removed = true;
                    break;
                }
                if(removed==true) {
                    break;
                }
            }
            if(removed==true) {
                break;
            }
            index++;
        }
    }

    public Comment getComment(int commentNumber, int conversationNumber) {
        return this.comments.get(conversationNumber-1).get(commentNumber-1);
    }

    public void updateComment(int commentNumber, int conversationNumber, Comment newComment) {
        LinkedList<Comment> list = this.comments.get(conversationNumber-1);
        list.set(commentNumber-1,newComment);
        this.comments.set(conversationNumber-1,list);
    }
}
