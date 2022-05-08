package by.tms.storage;

import by.tms.model.Comment;
import by.tms.model.User;
import java.util.ArrayList;
import java.util.List;

public class CommentStorage {

    private static final List<Comment> comments = new ArrayList<>();

    public void saveComment(Comment comment) {
        comments.add(comment);
    }

    public int getCommentId() {
        return comments.size() + 1;
    }

    public Comment findByIdComment(int idComment) {
        if (idComment <= 0) { return null; }
        for (Comment comment : comments) {
            if (comment != null && comment.getCommentId() == idComment && comment.getCommentId() > 0) {
                return comment;
            }
        }
        return null;
    }

    public void removeComment(Comment comment, String userName) {
        if (comment == null && userName == null) {
            System.out.println("User doesnt created");
            return;
        }
        int commentsIndex = 0;
        for (Comment item : comments) {
            if (item.equals(comment)) {
                comments.remove(comments.get(commentsIndex));
                return;
            }
            commentsIndex++;
        }
    }

}
