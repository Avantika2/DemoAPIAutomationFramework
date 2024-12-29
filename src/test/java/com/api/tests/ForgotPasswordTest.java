package com.api.tests;

import com.api.base.AuthService;
import com.api.models.requests.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest {
    @Test(description = "Verify if forgotPassword API is working.....")
    public void ForgotPasswordTest(){
        AuthService authService = new AuthService();
        Response  response = authService.forgotPassowrd("avantikahatmode100@gmail.com");
        System.out.println(response.asPrettyString());
    }
}
