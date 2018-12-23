package me.chan.kanban.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long idx;

    @Getter
    private String mail;


    @Getter
    private String nickName;

    private String password;

    @Getter
    private String social;

    @Getter
    private String principal;

    @Getter
    private LocalDateTime createdDate;

    @Getter
    private LocalDateTime updatedDate;

    @Builder
    public User(String mail, String nickName, String password, String social, String principal, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.mail = mail;
        this.nickName = nickName;
        this.password = password;
        this.social = social;
        this.principal = principal;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public void setUpdatedDateNow(LocalDateTime updatedDate) {
        this.updatedDate = LocalDateTime.now();
    }

    public void setCreatedDateNow(LocalDateTime createdDate) {
        this.createdDate = LocalDateTime.now();
    }
}
