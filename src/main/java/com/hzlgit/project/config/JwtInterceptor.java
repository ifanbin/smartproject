package com.hzlgit.project.config;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 拦截器
 *
 * @author sheng
 */
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!request.getRequestURI().startsWith("/api")) {
            return true;
        }
        if (request.getRequestURI().startsWith("/api/file")) {
            return true;
        }
        if (request.getRequestURI().startsWith("/api/enterprise-simple")) {
            return true;
        }
        if (request.getRequestURI().startsWith("/api/users")) {
            return true;
        }
        if (request.getRequestURI().startsWith("/api/users/getWxUserOpenid")) {
            return true;
        }
        if ("/sign-in".equals(request.getRequestURI()) || RequestMethod.OPTIONS.toString().equals(request.getMethod())) {
            return true;
        }
        String token = request.getHeader("TOKEN");
        if (token == null || "".equals(token.trim())) {
            throw new ServletException("non-existent token.");
        }
        //获取表中的token
        // log.info("token is {}", token);
        try {
            JwtUtils.checkToken(token);
            return true;
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}

