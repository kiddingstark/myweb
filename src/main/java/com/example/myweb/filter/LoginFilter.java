package com.example.myweb.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: zhengruihong
 * @description: TODO
 * @date: 2022/6/4 8:03 下午
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(httpResponse);
        HttpSession session = httpRequest.getSession();
        String uri = httpRequest.getRequestURI();
        if (uri.contains("/user/login")
                || uri.contains("/user/index")
                || uri.contains("/user/logout")
                || (null != session && null != (session.getAttribute("username")))) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        wrapper.sendRedirect("/user/index");
    }
}
