package me.chan.kanban.config;

import me.chan.kanban.domain.Member;
import me.chan.kanban.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.time.LocalDateTime;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();

        http

                //h2-console 사용하기 위한 설정
                .csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("!/h2-console/**"))
            .and()
                .headers()
                .frameOptions()
                .sameOrigin()
            .and()

                .authorizeRequests()
                .antMatchers("/",
                        "/login",
                        "/register",
                        "/css/**",
                        "/images/**",
                        "/js/**",
                        "/h2-console/**")
                .permitAll()
                .anyRequest().authenticated()
            .and()

            /*
                .oauth2Login()
                .loginPage("/login")
                .defaultSuccessUrl("/loginSuccess")
                .failureUrl("/loginFailure")
            .and()
                .exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
            .and()
            */
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
//                .passwordParameter("password")
//                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
//                .successForwardUrl("/") //login 성공후 405에러  why?

            .and()
                .logout()
                .logoutSuccessUrl("/")
            .and()
                .addFilterBefore(filter, CsrfFilter.class);
//                .csrf().disable() ;
    }



    @Autowired
    MemberRepository memberRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                Member member = memberRepository.findByEmail(email);
                if(member==null) throw new UsernameNotFoundException(email);
                member.setUpdatedDateNow();
                memberRepository.save(member); //마지막 로그인시간 기록
                return member;
            }
        });
    }

/*
    private ClientRegistration getRegistration(OAuth2ClientProperties clientProperties, String client) {
        if("google".equals(client)) {
            OAuth2ClientProperties.Registration registration
                    = clientProperties.getRegistration().get("google");
            return CommonOAuth2Provider.GOOGLE.getBuilder(client)
                    .clientId(registration.getClientId())
                    .clientSecret(registration.getClientSecret())
                    .scope("email","profile")
                    .build();

        }
        return null;

    }
*/


}
