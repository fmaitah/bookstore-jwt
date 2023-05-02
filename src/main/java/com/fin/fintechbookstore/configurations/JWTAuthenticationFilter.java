package com.fin.fintechbookstore.configurations;

import com.fin.fintechbookstore.services.MyUserDetailsService;
import com.fin.fintechbookstore.utilities.Constants;
import com.fin.fintechbookstore.utilities.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;

@Transactional
@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter
        extends OncePerRequestFilter
{

    final MyUserDetailsService myUserDetailsService;
    final JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader(Constants.AUTHORIZATION);
        final String userName;
        final String jwtToken;

        if (authHeader == null || !authHeader.startsWith(Constants.BEARER)) {
            filterChain.doFilter(request, response);
            return;
        }

        jwtToken = authHeader.substring(7);
        userName = jwtUtil.extractUsername(jwtToken);

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            final UserDetails userDetails = myUserDetailsService.loadUserByUsername(userName);

            if (jwtUtil.isTokenValid(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }

}
