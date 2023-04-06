package com.divnych.contentmanagement.converter;

import com.divnych.contentmanagement.entity.Article;
import com.divnych.contentmanagement.entity.Color;
import com.divnych.contentmanagement.entity.User;
import com.divnych.contentmanagement.model.UserAndArticleResponse;
import com.divnych.contentmanagement.model.UserResponse;
import java.util.List;
import java.util.stream.Collectors;

public class EntityConverter {

    public static UserResponse convertUser(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setAge(user.getAge());
        return response;
    }

    public static UserAndArticleResponse convertUserAndArticle(User user) {
        UserAndArticleResponse response = new UserAndArticleResponse();
        response.setUser_id(user.getId());
        response.setUser_name(user.getName());
        response.setUser_age(user.getAge());
        List<Article> articles = user.getArticles();
        List<Long> ids = articles.stream()
            .map(article -> article.getId())
            .collect(Collectors.toList());
        List<String> texts = articles.stream()
            .map(article -> article.getText())
            .collect(Collectors.toList());
        List<Color> colors = articles.stream()
            .map(article -> article.getColor())
            .collect(Collectors.toList());
        response.setArticle_ids(ids);
        response.setArticle_texts(texts);
        response.setArticle_colors(colors);
        return response;
    }


}
