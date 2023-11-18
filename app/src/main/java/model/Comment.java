package model;

import java.util.Date;
import java.util.List;

public class Comment {
    // Fields
    private String id;
    private String writer;
    private String detail;
    private Date uploadTime;
    private List<String> files;
    private String rootPost;
    private List<String> comments;

    // Constructor
    private Comment(String id, String writer, String detail, Date uploadTime,
                    List<String> files, String rootPost, List<String> comments) {
        this.id = id;
        this.writer = writer;
        this.detail = detail;
        this.uploadTime = uploadTime;
        this.files = files;
        this.rootPost = rootPost;
        this.comments = comments;
    }

    // Named Constructor
    public static Comment makeComment() {
        // named constructor
        // TODO: implement
        return new Comment(null, null, null, null, null, null, null);
    }

    // Methods
    public void addComment(String rootPostId, Comment newComment) {
        // 댓글 리스트에 추가 / 대댓글의 경우 rootPost가 Comment
        // TODO: implement
    }

    public void deleteComment(String rootPostId, String commentId) {
        // 댓글 리스트에서 삭제
        // TODO: implement
    }

    // getter
    public String getId() {
        return id;
    }

    public String getWriter() {
        return writer;
    }

    public String getDetail() {
        return detail;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public List<String> getFiles() {
        return files;
    }

    public String getRootPost() {
        return rootPost;
    }

    public List<String> getComments() {
        return comments;
    }
}

