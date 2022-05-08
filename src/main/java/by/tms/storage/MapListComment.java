package by.tms.storage;

import by.tms.model.Comment;
import by.tms.model.User;
import by.tms.service.CommentService;
import by.tms.service.PostService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapListComment {

    private static final HashMap<Integer, List<Comment>> hashMap = new HashMap<>();
    private final PostService postService = new PostService();
    private final CommentService commentService = new CommentService();
    private List<Comment> listComment;
    private static final int BEGINNING_OF_NUMBERING_COMMENT = 1;

    public String methodAddInHashMap(int idPost, Comment comment) {
        int sizeMap = hashMap.size() + 1;
        if ((idPost > sizeMap) && idPost <= 0 && comment == null) {
            System.out.println("Check metod ");
            return null;
        }
        listComment = hashMap.get(idPost);

        if (listComment == null) {
            listComment = new ArrayList<>();
            comment.setCommentId(BEGINNING_OF_NUMBERING_COMMENT);
            hashMap.put(idPost, listComment);
            hashMap.get(idPost).add(comment);
            postService.addCommentById(idPost, comment);

        } else {
            comment.setCommentId(listComment.size() + 1);
            postService.addCommentById(idPost, comment);
            hashMap.get(idPost).add(comment);
        }
        return (comment.getCommentId() + " | " + comment.getUserName() + " | " + comment.getText());
    }

    public String methodEditCommentByIdInPost(int idPost, int idComment, String text, String userName) {
        if (idPost <= 0 && idComment <= 0 && text == null && userName == null) {
            System.out.println("*** ??? == null, methodEditCommentByIdInPost ***");
            return null;
        }
        listComment = hashMap.get(idPost);
        if (listComment == null) { return null; }

        for (Comment comment : listComment) {
            if (comment != null && comment.getCommentId() == idComment) {
                comment.setText(text);
                return (comment.getCommentId() + " | " + userName + " | " + text);
            }
        }
        return null;
    }

    public String methodDeleteCommentByIdInPost(int idPost, int idComment, String userName) {
        if (idPost <= 0 && idComment <= 0 && userName == null) {
            System.out.println("*** ??? == null, methodDeleteCommentByIdInPost ***");
            return null;
        }
        listComment = hashMap.get(idPost);
        if (listComment == null) { return null; }

        for (Comment comment : listComment) {
            if (comment != null && comment.getCommentId() == idComment) {
                commentService.removeComment(comment, userName);
                postService.removeCommentInPost(idPost, comment, userName);
                hashMap.get(idPost).remove(comment);
                return "Deleted";
            }
        }
        return null;
    }

}
