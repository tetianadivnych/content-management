package com.divnych.contentmanagement.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleUserResponse {

    private UserResponse user;
    private List<ArticleResponse> articles;


}
