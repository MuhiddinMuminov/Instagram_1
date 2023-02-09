package uz.pdp.Instagram.model.post;

import uz.pdp.Instagram.model.BaseModel;

import java.util.UUID;

public class Post extends BaseModel {
    private PostType postType;
    private UUID userId;
    private String description;
    private Integer likes;

    public Post(PostType postType, UUID userId, String description, Integer likes) {
        this.postType = postType;
        this.userId = userId;
        this.description = description;
        this.likes = likes;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Post(PostType postType, UUID userId, String description) {
        this.postType = postType;
        this.userId = userId;
        this.description = description;
    }

    public Post(PostType postType, UUID userId) {
        this.postType = postType;
        this.userId = userId;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return
                "PostType = " + postType +"  ||  "+
                "Likes = "+likes+  "  ||  " +
                "Description = " + description+"  ||  "+
                "UserId = " + userId;
    }
}
