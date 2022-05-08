package by.tms.service;

import by.tms.model.Comment;
import by.tms.model.User;
import by.tms.storage.CommentStorage;

public class CommentService {

    private static final CommentStorage commentStorage = new CommentStorage();

    public Comment findComment(int idComment) {
        return commentStorage.findByIdComment(idComment);
    }

    public int getCommentId() {
        return commentStorage.getCommentId();
    }

    public void removeComment(Comment comment, String userName) {
        commentStorage.removeComment(comment, userName);
    }

    public void createNewComment(int idComment, String userName, String text) {
        if (idComment <= 0 && userName == null && text == null) {
            System.out.println("User doesn't created");
            return;
        }
        commentStorage.saveComment(new Comment(idComment, userName, text));
    }

}

