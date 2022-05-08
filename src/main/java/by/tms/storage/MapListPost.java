package by.tms.storage;

import by.tms.model.Comment;
import by.tms.model.Post;
import by.tms.model.User;
import by.tms.service.CommentService;
import by.tms.service.PostService;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapListPost {
    private static final HashMap<String, List<Post>> hashMap = new HashMap<>();
    private final PostService postService = new PostService();
    private static final int BEGINNING_OF_NUMBERING_POST = 1;
    private List<Post> listPost;

    public String methodAddInHashMap(User user, Post post) {
        int sizeMap = hashMap.size() + 1;
        if (user == null && post ==null) {
            System.out.println("*** return array of out bounds ***");
            return null;
        }
        listPost = hashMap.get(user.getName());

        if (listPost == null) {
            listPost = new ArrayList<>();
            post.setPostId(BEGINNING_OF_NUMBERING_POST);
            hashMap.put(user.getName(), listPost);
            hashMap.get(user.getName()).add(post);
        } else {
            post.setPostId(listPost.size() + 1);
            hashMap.get(user.getName()).add(post);
        }
        return String.valueOf(post);
    }

    public String methodEditPostById (int idPost, String text, String userName) {
        if (idPost <= 0  && text == null && userName == null) {
            System.out.println("*** ??? == null, methodEditCommentByIdInPost ***");
            return null;
        }
        listPost = hashMap.get(userName);
        if (listPost == null) { return null; }

        for (Post post : listPost) {
            if (post != null && post.getPostId() == idPost) {
               post.setText(text);
                return String.valueOf(post);
            }
        }
        return null;
    }

    public String methodDeletePostById(int idPost, String userName) {
        if (idPost <= 0 && userName == null) {
            System.out.println("*** ??? == null, methodDeleteCommentByIdInPost ***");
            return null;
        }
        listPost = hashMap.get(userName);
        if (listPost == null) { return null; }

        for (Post post : listPost) {
            if (post != null && post.getPostId() == idPost) {

                postService.deletePostById(idPost, userName);
                hashMap.get(userName).remove(post);
                return "Deleted";
            }
        }
        return null;
    }
}
