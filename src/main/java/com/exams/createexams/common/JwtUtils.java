package com.exams.createexams.common;

import com.exams.createexams.model.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtUtils {

    private static final String SECRET_KEY = "intieningles";
    private static final String BEARER_TOKEN = "Bearer %s";
    private static final String AUTHORITIES = "authorities";
    private static final String BEARER_PART = "Bearer ";
    private static final String EMPTY = "";

    public Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY.getBytes(StandardCharsets.UTF_8))
            .parseClaimsJws(token).getBody();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractUsername(String authorizationHeader) {
        return extractClaim(getToken(authorizationHeader), Claims::getSubject);

    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public boolean isTokenExpired(String authorizationHeader) {
        return extractExpiration(getToken(authorizationHeader)).before(new Date());
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private String getToken(String authorizationHeader) {
        return authorizationHeader.replace(BEARER_PART, EMPTY);
    }

    private String createToken(String subject, String role) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
            .commaSeparatedStringToAuthorityList(role);
        String token = Jwts.builder()
            .claim(AUTHORITIES,
                grantedAuthorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList()))
            .setSubject(subject)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes(StandardCharsets.UTF_8))
            .compact();
        return String.format(BEARER_TOKEN, token);
    }

    public String generateToken(UserDetails userDetails) {
        User user = (User) userDetails;
        return createToken(user.getUsername(), user.getRoles().get(0).getName());
    }

}
