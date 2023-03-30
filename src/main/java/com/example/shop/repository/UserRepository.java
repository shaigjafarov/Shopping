package com.example.shop.repository;

import com.example.shop.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query("select u from User u where u.username=:xxx")
    User nese(@Param("xxx") String username);

    @Query(nativeQuery = true, value = "select u.* from myschema.users u where u.username=:xxx")
    User nese1(@Param("xxx") String username);


}
