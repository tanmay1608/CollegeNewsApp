package com.example.collegenews;


public class EventInfo {
    private String text;
    private String image;
    private String likes;
    private String postId;

    public EventInfo() {
    }

    public EventInfo(String text, String image, String likes, String postId) {
        this.text = text;
        this.image = image;
        this.likes=likes;
        this.postId=postId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
