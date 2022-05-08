package by.tms.model;

public class Comment {

    private int commentId;
    private String userName;
    private String text;

    public Comment() { }

    public Comment(int commentId, String userName, String text) {
        this.commentId = commentId;
        this.userName = userName;
        this.text = text;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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

    @Override
    public String toString() {
        return "{№" + commentId +
                ", name: " + userName +
                ", text: '" + text + '\'' + '}';
    }

}
