package by.tms.service;

import by.tms.model.Comment;
import by.tms.model.Post;
import by.tms.model.User;
import by.tms.model.UserRole;
import by.tms.storage.PostStorage;
import java.util.ArrayList;
import java.util.List;

public class PostService {

    private static final PostStorage postStorage = new PostStorage();

    public int getPostId() {
        return postStorage.getPostId();
    }

    public List<Post> findAll(User user) {
        return postStorage.getAll(user);
    }

    public Post findPost(int idPost, String userName) {
        return postStorage.findByIdPost(idPost,userName);
    }

    public String createNewPost(int idPost, String userName, String text) {
        if (idPost <= 0 && userName == null && text == null) {
            System.out.println("User doesn't created!");
            return null;
        }
        Post post = new Post(idPost, userName, text, new ArrayList<Comment>(), new ArrayList<String>(), false);
        return postStorage.savePost(post);
    }


    public String PublishOrNot (int idPost, String userName){
     Post post =  postStorage.findByIdPost(idPost, userName);
       post.setValue(true);
       return "Publish";
    }

    public void addCommentById(int idPost, Comment comment) {
        postStorage.addCommentByIdInPost(idPost, comment);
    }

    public String deletePostById(int idPost, String userName) {
        return postStorage.deletePostById(idPost, userName);
    }

    public void removeCommentInPost(int idPost, Comment comment, String userName) {
        postStorage.removeCommentInPost(idPost, comment, userName);
    }

    public String addLike(int idPost, User user) {
        return postStorage.addLikeInPost(idPost, user);
    }

    public String deleteLike(int idPost, User user) {
        return postStorage.deleteLikeInPost(idPost, user);
    }

}


