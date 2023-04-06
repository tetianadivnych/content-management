package com.divnych.contentmanagement.model;

import com.divnych.contentmanagement.entity.Color;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAndArticleResponse {

    private Long user_id;
    private String user_name;
    private Integer user_age;
    private List<Long> article_ids;
    private List<String> article_texts;
    private List<Color> article_colors;
}
