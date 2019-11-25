package com.hzlgit.project.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import java.util.Date;

/**
 * @author sheng
 */
@Slf4j
public class JwtUtils {

    final static String base64EncodedSecretKey = "hzlg";
    final static long TOKEN_EXP = 1000 * 60 * 60 * 24;

    public static String getToken(String userName) {
        return Jwts.builder()
                .setSubject("user")
                .claim("username", userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXP))
                .signWith(SignatureAlgorithm.HS256, base64EncodedSecretKey)
                .compact();
    }

    /**
     * 解析token
     */
    public static String checkToken(String token) throws ServletException {
        try {
            final Claims claims = Jwts.parser().setSigningKey(base64EncodedSecretKey).parseClaimsJws(token).getBody();
            log.info("从token中解析到的username=={}", claims);
            String username = (String) claims.get("username");
            log.info("username=={}", username);
            return username;
        } catch (ExpiredJwtException e1) {
            throw new ServletException("token expired");
        } catch (Exception e) {
            throw new ServletException("other token exception");
        }
    }
}

