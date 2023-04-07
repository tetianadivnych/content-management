package com.divnych.contentmanagement.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAndArticlesResponse {

    private Long id;
    private String name;
    private Integer age;
    private List<ArticleResponse> articles = new ArrayList<>();

}
