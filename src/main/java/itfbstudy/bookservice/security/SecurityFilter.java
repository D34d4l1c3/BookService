package itfbstudy.bookservice.security;

import itfbstudy.bookservice.advice.BookNotFound;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;


@Component
public class SecurityFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException, AccessDeniedException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String headerValue = request.getHeader("authorization");
        response.setCharacterEncoding("UTF-8");
        if  (headerValue == null || !headerValue.startsWith("Bearer ")) {
            response.setStatus(401);
            throw new AccessDeniedException("Доступ без токена запрещен");
        }
        else chain.doFilter(req, response);
    }

}