package com.fastfood.fastfood.config.security;


import com.fastfood.fastfood.entities.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@AllArgsConstructor
public class UserSession {


    private final HttpServletRequest request;


    public User getUser(){
        return null;
        // TODO: 6/8/2022 return verification
    }
}
