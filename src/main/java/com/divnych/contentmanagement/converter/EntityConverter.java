package com.divnych.contentmanagement.converter;

import com.divnych.contentmanagement.entity.Article;
import com.divnych.contentmanagement.entity.User;
import com.divnych.contentmanagement.model.ArticleResponse;
import com.divnych.contentmanagement.model.ArticleUserResponse;
import com.divnych.contentmanagement.model.UserResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
            .map(EntityConverter::convertArticle)
            .collect(Collectors.toList());
    }

    public static List<ArticleUserResponse> convertArticlesPerUser(List<Article> articles) {
        List<ArticleUserResponse> articleUserResponses = new ArrayList<>();
        Map<User, List<Article>> map = articles.stream()
            .collect(Collectors.groupingBy(Article::getUser));
        Set<Entry<User, List<Article>>> entrySet = map.entrySet();
        for (Entry<User, List<Article>> entry : entrySet) {
            User user = entry.getKey();
            List<Article> userArticles = entry.getValue();
            ArticleUserResponse response = new ArticleUserResponse();
            response.setUser(convertUser(user));
            response.setArticles(convertArticles(userArticles));
            articleUserResponses.add(response);
        }
        return articleUserResponses;
    }

}
