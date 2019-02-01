package me.chan.kanban.resolver;

import me.chan.kanban.domain.Member;
import me.chan.kanban.repository.MemberRepository;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
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

/*
@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    private MemberRepository userRepository;

    public UserArgumentResolver(MemberRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(Member.class);
    }

//    @Override
//    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
//                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
//                .getRequest().getSession();
//        Member user = (Member) session.getAttribute("user");
//        return getUser(user, session);
//    }

//    private Member getUser(Member user, HttpSession session) {
//        if(user == null) {
//            try {
//                OAuth2AuthenticationToken authentication =
//                        (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
//                Map<String, Object> map = authentication.getPrincipal().getAttributes();
//                Member convertUser = getModernUser(map);
//                user = userRepository.findByMail(convertUser.getMail());
//                if(user == null) { user = userRepository.save(convertUser); }
//                session.setAttribute("user", user);
//            } catch (ClassCastException e) {
//                return user;
//            }
//        }
//        return user;
//    }

    private Member getModernUser(Map<String, Object> map) {
        return Member.builder()
                .nickName(String.valueOf(map.get("name")))
                .mail(String.valueOf(map.get("email")))
                .principal(String.valueOf(map.get("id")))
                .createdDate(LocalDateTime.now())
                .build();
    }



}
*/