package com.divnych.contentmanagement.repository;

import com.divnych.contentmanagement.entity.Article;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(nativeQuery = true, value = "select * from articles a inner join users u on a.user_id = u.id where a.color = :color")
    List<Article> getArticlesByColor(String color);

}
