package me.chan.kanban.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ValueGenerationType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

@NoArgsConstructor
@Entity

public class Member implements UserDetails {

    private static final long serialVersionUID=1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long idx;

    @Getter
    @Setter
    @Column(unique = true)
    private String email;

    @Getter
    @Setter
    private String nickName;

    @Setter
    private String password;

    @Getter
    private String principal;

    @Getter
    private LocalDateTime createdDate;

    @Getter
    private LocalDateTime updatedDate;



    @Builder
    public Member(String email, String nickName, String password, String principal, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.email = email;
        this.nickName = nickName;
        this.password = password;
        this.principal = principal;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public void setUpdatedDateNow() {
        this.updatedDate = LocalDateTime.now();
    }

//    public void setCreatedDateNow(LocalDateTime createdDate) {
//        this.createdDate = LocalDateTime.now();
//    }

    @Override
    public String toString() {

        return idx+" "+email+" "+nickName+" "+password+" "+principal+" "+createdDate+" "+updatedDate;
    }

    public String toStringDetail() {

        return "idx : "+idx+"\nemail : "+email+"\nnickName : "+nickName+"\npassword : "+password
                +"\nprincipal : "+principal+"\ncreatedDate : "+createdDate+"\nupdatedDate : "+updatedDate;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
