package com.example.articles;

import jakarta.validation.constraints.Size;


public class Article {
    @Size(min=20, max=200, message="The article must be at lest 20 chars and no more than 200 chars")
    private String article;

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
