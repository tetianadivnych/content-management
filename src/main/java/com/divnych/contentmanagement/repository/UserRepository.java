package com.divnych.contentmanagement.repository;

import com.divnych.contentmanagement.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "select * from users u inner join articles a on u.id=a.user_id")
    List<User> getUsersAndArticles();

}
