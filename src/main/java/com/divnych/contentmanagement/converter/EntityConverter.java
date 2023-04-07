package com.divnych.contentmanagement.converter;

import com.divnych.contentmanagement.entity.Article;
import com.divnych.contentmanagement.entity.User;
import com.divnych.contentmanagement.model.ArticleResponse;
import com.divnych.contentmanagement.model.UserAndArticlesResponse;
import com.divnych.contentmanagement.model.UserResponse;
import java.util.List;
import java.util.stream.Collectors;

public class EntityConverter {

    private EntityConverter() {
        throw new IllegalStateException("Utility class");
    }

    public static UserResponse convertUser(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setAge(user.getAge());
        return response;
    }

    private static ArticleResponse convertArticle(Article article) {
        ArticleResponse response = new ArticleResponse();
        response.setId(article.getId());
        response.setText(article.getText());
        response.setColor(article.getColor());
        return response;
    }

    public static List<ArticleResponse> convertArticles(List<Article> articles) {
        return articles.stream()
            .map(article -> EntityConverter.convertArticle(article))
            .collect(Collectors.toList());
    }

    public static UserAndArticlesResponse convertUserAndArticles(User user) {
        UserAndArticlesResponse response = new UserAndArticlesResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setAge(user.getAge());
        List<Article> articles = user.getArticles();
        response.setArticles(EntityConverter.convertArticles(articles));
        return response;
    }

}
