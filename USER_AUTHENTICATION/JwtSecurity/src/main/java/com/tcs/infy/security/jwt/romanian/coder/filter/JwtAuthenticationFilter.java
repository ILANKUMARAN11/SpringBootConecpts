package com.tcs.infy.security.jwt.romanian.coder.filter;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.infy.model.AuthenticationRequestVo;
import com.tcs.infy.security.UserPrincipal;
import com.tcs.infy.security.jwt.romanian.coder.JwtProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private JwtProperties jwtProperties;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager,JwtProperties jwtProperties) {
        this.authenticationManager = authenticationManager;
        this.jwtProperties=jwtProperties;
    }



    /* Trigger when we issue POST request to /login
    We also need to pass in {"username":"dan", "password":"dan123"} in the request body
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        // Grab credentials and map them to login viewmodel
        AuthenticationRequestVo credentials = null;
        try {
            credentials = new ObjectMapper().readValue(request.getInputStream(), AuthenticationRequestVo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create login token
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                credentials.getUsername(),
                credentials.getPassword(),
                new ArrayList<>());

        // Authenticate user
        Authentication auth = authenticationManager.authenticate(authenticationToken);

        return auth;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        // Grab principal
        UserPrincipal principal = (UserPrincipal) authResult.getPrincipal();

        // Create JWT Token
        String token = JWT.create()
                .withSubject(principal.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtProperties.getExpiryTime()))
                .sign(HMAC512(jwtProperties.getSecretKey().getBytes()));


        String userPrincipalJsonString="";
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(principal);
            userPrincipalJsonString=json;
            //System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        // Add token in response
        response.addHeader(jwtProperties.getHeader(), jwtProperties.getTokenPrefix() +  token);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(userPrincipalJsonString);
        out.flush();

    }
}
