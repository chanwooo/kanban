package me.chan.kanban.resolver;

import me.chan.kanban.domain.User;
import me.chan.kanban.repository.UserRepository;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Map;


@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    private UserRepository userRepository;

    public UserArgumentResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getSession();
        User user = (User) session.getAttribute("user");
        return getUser(user, session);
    }
    private User getUser(User user, HttpSession session) {
        if(user == null) {
            try {
                OAuth2AuthenticationToken authentication =
                        (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

                Map<String, Object> map = authentication.getPrincipal().getAttributes();

                User convertUser = convertUser(authentication.getAuthorizedClientRegistrationId(), map);

                user = userRepository.findByMail(convertUser.getMail());

                if(user == null) { user = userRepository.save(convertUser); }

                session.setAttribute("user", user);


            } catch (ClassCastException e) {
                return user;
            }
        }
        return user;
    }

    private User convertUser(String authority, Map<String, Object> map) {
        if("GOOGLE".equals(authority)) return getModernUser("GOOGLE", map);
        return null;
    }

    private User getModernUser(String social, Map<String, Object> map) {
        return User.builder()
                .nickName(String.valueOf(map.get("name")))
                .mail(String.valueOf(map.get("email")))
                .principal(String.valueOf(map.get("id")))
                .createdDate(LocalDateTime.now())
                .build();
    }


}
