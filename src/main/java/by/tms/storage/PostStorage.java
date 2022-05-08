package by.tms.storage;

import by.tms.model.Comment;
import by.tms.model.Post;
import by.tms.model.User;
import by.tms.model.UserRole;

import java.util.ArrayList;
import java.util.List;

public class PostStorage {

    private static final List<Post> posts = new ArrayList<>();

    public Post findByIdPost(int idPost, String userName) {
        if (idPost <= 0) {
            return null; }
        for (Post post : posts) {
            if (post != null && post.getPostId() == idPost && post.getUserName().equals(userName)) {
                return post;
            }
        }
        return null;
    }

    public String savePost(Post post){
        posts.add(post);
        return (post.getPostId() + " | " + post.getUserName() + " | " + post.getText());
    }

    public int getPostId() {
        return posts.size() + 1;
    }

    public List<Post> getAll(User user) {
        List<Post> postForUser = new ArrayList<>();
        if (user.getRole() == UserRole.ADMIN_ROLE) {
            return new ArrayList<>(posts); //все посты
        } else if (user.getRole() == UserRole.USER_ROLE ) { //только то что ты сам сделал
            for (Post post : posts) {
                if (post.getUserName() == user.getName()&& post.getValue()) {
                    postForUser.add(post);
                }
            }
        }
        return postForUser;
    }
//    public List<Post> getAll123() {
//        List<Post> list = new ArrayList<>();
//        for (Post item : posts) {
//            if (item.getValue() == true) {
//                list.add(item);
//            }
//        }
//        return list;
//    }

    public String editPostById(int idPost, String text, User user) {        // сделать проверку по логину
        for (Post post : posts) {                                           // (пользователей много а логин будет уникальным)
            if (idPost <= 0 && text == null && user == null && post == null) {
                System.out.println("??? == null, editPostById");

            } else if (post.getPostId() == idPost){
                post.setText(text);
                return (idPost + " | " + user.getName() + " | " + text);
            }
        }
        return null;
    }

    public String deletePostById(int idPost, String userName){
        for (Post post : posts) {
            if (idPost <= 0 && userName == null && post == null) {
                System.out.println("??? == null, deletePostById");

            } else if (post.getPostId() == idPost) {
                posts.remove(idPost - 1);
                int index = 0;
                for (Post item : posts) {
                    posts.set(index, item);
                    index++;
                }
                return "Deleted";
            }
        }
        return null;
    }

    public void removeCommentInPost(int idPost, Comment comment, String userName) {
        for (Post post : posts) {
            if (idPost <= 0 && userName == null && post == null) {
                System.out.println("??? == null, deletePostById");

            } else if (post.getPostId() == idPost) {
                for (Comment item : post.getComments()) {
                    if (item.getCommentId() == comment.getCommentId() && comment.getCommentId() > 0) {
                        post.getComments().remove(item);
                        return;
                    }
                }
            }
        }
    }

    public void addCommentByIdInPost(int idPost, Comment comment){
        for (Post post : posts){
            if (idPost <= 0 && comment == null && post == null) {
                System.out.println("??? == null, addCommentByIdInPost");

            } else if (post.getPostId() == idPost) {
                post.setComments(comment);
            }
        }
    }

    public String addLikeInPost(int idPost, User user) {
        for (Post post : posts) {
            if (idPost <= 0 && user == null && post == null) {
                System.out.println("*** ??? == null, deletePostById ***");
                return null;

            } else if (post.getPostId() == idPost) {
                post.setLike(user.getName());
                return user.getName();
            }
        }
        return null;
    }

    public String deleteLikeInPost(int idPost, User user) {
        for (Post post : posts) {
            if (idPost <= 0 && user == null && post == null) {
                System.out.println("*** ??? == null, deletePostById ***");
                return null;

            } else if (post.getPostId() == idPost) {
                for (String item : post.getLike()) {
                    if (item.equals(user.getName())) {
                        post.getLike().remove(item);
                        return "Deleted";
                    }
                }
            }
        }
        return null;
    }

}

