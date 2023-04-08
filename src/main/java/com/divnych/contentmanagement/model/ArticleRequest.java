package com.divnych.contentmanagement.model;

import com.divnych.contentmanagement.entity.Color;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleRequest {

    private Long id;

    private String text;

    private Color color;

    private Long userId;


}
