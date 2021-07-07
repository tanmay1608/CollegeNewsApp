package com.example.collegenews;


public class ModelClass {
    String news;
    ModelClass()
    {

    }

    public ModelClass(String news) {
        this.news = news;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
