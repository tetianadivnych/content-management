package com.divnych.contentmanagement.controller;

import com.divnych.contentmanagement.model.ArticleRequest;
import com.divnych.contentmanagement.model.ArticleUserResponse;
import com.divnych.contentmanagement.service.ArticleService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/save")
    public void saveArticle(@RequestBody ArticleRequest articleRequest) {
        articleService.saveArticle(articleRequest);
    }

    @GetMapping("/color/{color}")
    public List<ArticleUserResponse> getArticlesPerUser(@PathVariable String color) {
        return articleService.getArticlesPerUser(color);
    }

}
