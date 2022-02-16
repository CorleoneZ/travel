package com.travel.service;

import com.travel.reponse.back.Article;
import com.travel.util.HomeCateInit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private Article article;

    public List<Article> initArticle() {
        return HomeCateInit.init();
    }

    public Article getArticle(String id, List<Article> articleList) {

        for (Article s : articleList) {
            if (id.equals(s.getId())) {
                article = s;
            }
        }
        return article;
    }
}
