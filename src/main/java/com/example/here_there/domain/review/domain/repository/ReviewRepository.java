package com.example.here_there.domain.review.domain.repository;

import com.example.here_there.domain.review.domain.Review;
import com.example.here_there.domain.user.domain.Interest;
import com.example.here_there.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT country FROM Review WHERE user_id = :userId", nativeQuery = true)
    List<String> findCountryByUserId(@Param("userId") Long userId);

    List<Review> findByUser(User user);

    List<Review> findByTitleContaining(String keyword);

    @Query("SELECT DISTINCT r FROM Review r JOIN r.interests i WHERE i IN :interests")
    List<Review> findByInterestsIn(@Param("interests") List<Interest> interests);
}