package com.divnych.contentmanagement.payload.response;

import com.divnych.contentmanagement.entity.EColor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleResponse {

    private Long id;

    private String text;

    private EColor color;

}
