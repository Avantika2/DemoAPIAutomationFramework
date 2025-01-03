package com.api.base;

import com.api.models.requests.LoginRequest;
import com.api.models.requests.SignUpRequest;
import io.restassured.response.Response;

import javax.naming.ldap.HasControls;
import java.util.HashMap;

public class AuthService extends BaseService{

    private static final String BASE_PATH = "/api/auth/";

    public Response login(LoginRequest payload){
        return postRequest(payload,BASE_PATH+"login");
    }

    public Response signUp(SignUpRequest payload){


        return postRequest(payload, BASE_PATH+"signup");

    }

    public Response forgotPassowrd(String emailAddress){
        HashMap<String,String> payload = new HashMap<String, String>();
        payload.put("email",emailAddress);
        return postRequest(payload,BASE_PATH+"forgot-password");
    }
}
