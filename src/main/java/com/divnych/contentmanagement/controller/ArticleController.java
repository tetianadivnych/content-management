package com.divnych.contentmanagement.controller;

import com.divnych.contentmanagement.model.ArticleUserResponse;
import com.divnych.contentmanagement.service.ArticleService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/color/{color}")
    public List<ArticleUserResponse> getArticlesPerUser(@PathVariable String color) {
        return articleService.getArticlesPerUser(color);
    }
}
