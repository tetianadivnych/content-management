package com.divnych.contentmanagement.model;

import com.divnych.contentmanagement.entity.Color;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleResponse {

    private Long id;

    private String text;

    private Color color;

}
