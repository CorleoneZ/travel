package com.travel.service;

import com.travel.reponse.back.Article;
import com.travel.util.HomeCateInit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private List<Article> articleLists;
    private Article article;

    public void initArticle() {
        HomeCateInit.init();
    }

    public Article getArticle(int id) {

        for (Article s : articleLists) {
            if (id == 0) {
                article = s;
            }
        }
        return article;
    }
}
