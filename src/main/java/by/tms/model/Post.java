package by.tms.model;

import java.util.List;

public class Post {

    private int postId;
    private String userName;
    private String text;
    private List<Comment> comments;
    private List<String> like;
    private boolean value=false;

    public Post() { }

    public Post(int postId, String userName, String text, List<Comment> comments, List<String> like, boolean value) {
        this.postId = postId;
        this.userName = userName;
        this.text = text;
        this.comments = comments;
        this.like = like;
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(Comment comments) {
        this.comments.add(comments);
    }

    public List<String> getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like.add(like);
    }

    @Override
    public String toString() {
        return "Post №" + postId +
                ", name: " + userName +
                ", text: '" + text + '\'' +
                ", comments: " + comments +
                ", like: " + like;
    }

}
