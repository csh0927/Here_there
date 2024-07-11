package com.example.here_there.domain.user.domain;

import com.example.here_there.domain.review.domain.Review;
import com.example.here_there.global.entity.BaseIdEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseIdEntity {

    @Column(length = 20, nullable = false)
    private String nickname;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Interest> interests;

    @OneToMany
    private List<Review> review;

    private String originalFileName;

    private String storedFileName;

    private Long fileSize;

    @Builder
    public User(String nickname, String email, String password, List<Interest> interests) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.interests = interests;
    }

    public void update(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
    }

    public void uploadImages(String originalFileName, String storedFileName, Long fileSize) {
        this.originalFileName = originalFileName;
        this.storedFileName = storedFileName;
        this.fileSize = fileSize;
    }

    public void updateInterest(List<Interest> interests) {
        this.interests = interests;
    }
}
