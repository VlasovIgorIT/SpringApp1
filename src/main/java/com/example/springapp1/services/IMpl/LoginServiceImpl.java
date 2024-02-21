package com.example.springapp1.services.IMpl;

import com.example.springapp1.models.LoginParams;
import com.example.springapp1.services.LoginService;

public class  LoginServiceImpl implements LoginService {

    @Override
    public String login(LoginParams loginParams) {
        return loginParams.getEmail();

    }
}
