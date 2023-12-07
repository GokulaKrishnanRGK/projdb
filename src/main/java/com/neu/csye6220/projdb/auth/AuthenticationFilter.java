package com.neu.csye6220.projdb.auth;

import com.neu.csye6220.projdb.entity.Login;
import com.neu.csye6220.projdb.entity.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    private static List<String> allowedURLs = List.of("/", "/login", "/logout", "/register");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Login login = (Login) request.getSession().getAttribute("login");
        String requestURI = request.getRequestURI();
        logger.info("Request URI in filter: " + requestURI);
        if(!allowedURLs.contains(requestURI)){
            if(login == null){
                logger.error("In filter: Redirecting to login page");
                response.sendRedirect("/login");
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
