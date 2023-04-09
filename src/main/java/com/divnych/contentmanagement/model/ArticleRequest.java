package com.divnych.contentmanagement.model;

import com.divnych.contentmanagement.entity.EColor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleRequest {

    private Long id;

    private String text;

    private EColor color;

    private Long userId;


}
