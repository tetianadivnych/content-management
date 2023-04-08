package com.divnych.contentmanagement.service;

import com.divnych.contentmanagement.converter.EntityConverter;
import com.divnych.contentmanagement.entity.Article;
import com.divnych.contentmanagement.entity.User;
import com.divnych.contentmanagement.model.ArticleRequest;
import com.divnych.contentmanagement.model.ArticleUserResponse;
import com.divnych.contentmanagement.repository.ArticleRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final UserService userService;

    public ArticleService(ArticleRepository articleRepository, UserService userService) {
        this.articleRepository = articleRepository;
        this.userService = userService;
    }

    public List<ArticleUserResponse> getArticlesPerUser(String color) {
        List<Article> articles = articleRepository.getArticlesByColor(color);
        return EntityConverter.convertArticlesPerUser(articles);
    }

    public void saveArticle(ArticleRequest request) {
        User user = userService.getUserById(request.getUserId());
        Article article = new Article();
        article.setUser(user);
        article.setText(request.getText());
        article.setColor(request.getColor());
        articleRepository.save(article);
    }

}
