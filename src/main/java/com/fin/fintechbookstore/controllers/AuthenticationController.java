package com.fin.fintechbookstore.controllers;

import com.fin.fintechbookstore.exceptions.CustomException;
import com.fin.fintechbookstore.model.dtos.AuthenticationRequest;
import com.fin.fintechbookstore.model.dtos.JWToken;
import com.fin.fintechbookstore.services.MyUserDetailsService;
import com.fin.fintechbookstore.services.RoleService;
import com.fin.fintechbookstore.services.UserService;
import com.fin.fintechbookstore.utilities.JWTUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@Transactional
@RestController
@RequestMapping("/auth")
public class AuthenticationController {


    AuthenticationManager authManager;
    MyUserDetailsService myUserDetailsService;
    JWTUtil jwtUtil;
    UserService userService;
    RoleService roleService;


    public AuthenticationController(AuthenticationManager authManager, MyUserDetailsService myUserDetailsService, JWTUtil jwtUtil, UserService userService, RoleService roleService) {
        this.authManager = authManager;
        this.myUserDetailsService = myUserDetailsService;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JWToken> authenticate(@RequestBody AuthenticationRequest request)throws CustomException {

        final UserDetails userDetail = myUserDetailsService.loadUserByUsername(request.getUsername());

        if (!myUserDetailsService.authenticate(request.getUsername(), request.getPassword())) {
            throw new CustomException("password not correct");
        }

        return ResponseEntity.ok(new JWToken(jwtUtil.generateToken(userDetail)));

    }

}
