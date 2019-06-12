package com.vn.tma.ntd.VM.security;

import com.vn.tma.ntd.VM.model.UserPrincipal;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

/**
 * The Class JwtTokenProvider
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@Component
public class JwtTokenProvider {
    private static final Logger logger = LoggerFactory.getLogger( JwtTokenProvider.class );

    @Value("${spring.jwt.jwt_secret}")
    private String jwtSecret;

    @Value("${spring.jwt.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    private Key key = Keys.secretKeyFor( SignatureAlgorithm.HS256 );

    public String generateToken(Authentication authentication) {

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date( now.getTime() + jwtExpirationInMs );
        return Jwts.builder()
                .setSubject( Long.toString( userPrincipal.getId() ) )
                .setIssuedAt( new Date() )
                .setExpiration( expiryDate )
                .signWith( key )
                .compact();
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey( key )
                .parseClaimsJws( token )
                .getBody();

        return Long.parseLong( claims.getSubject() );
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey( jwtSecret ).parseClaimsJws( authToken );
            return true;
        } catch (SignatureException ex) {
            logger.error( "Invalid JWT signature" );
        } catch (MalformedJwtException ex) {
            logger.error( "Invalid JWT token" );
        } catch (ExpiredJwtException ex) {
            logger.error( "Expired JWT token" );
        } catch (UnsupportedJwtException ex) {
            logger.error( "Unsupported JWT token" );
        } catch (IllegalArgumentException ex) {
            logger.error( "JWT claims string is empty." );
        }
        return false;
    }
}
