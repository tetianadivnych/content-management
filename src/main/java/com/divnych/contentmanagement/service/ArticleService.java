package com.divnych.contentmanagement.service;

import com.divnych.contentmanagement.converter.EntityConverter;
import com.divnych.contentmanagement.entity.Article;
import com.divnych.contentmanagement.model.ArticleUserResponse;
import com.divnych.contentmanagement.repository.ArticleRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<ArticleUserResponse> getArticlesPerUser(String color) {
        List<Article> articles = articleRepository.getArticlesByColor(color);
        return EntityConverter.convertArticlesPerUser(articles);
    }


}
