package com.api.tests;

import com.api.base.AuthService;
import com.api.models.requests.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {
    @Test(description = "Verify if login API is working.....")
    public void createAccountTest(){

        SignUpRequest signUpRequest = new SignUpRequest.Builder().username("nnatasha").email("ndisha@gmail.com")
                .firstName("natasha")
                .lastname("Bhatt")
                .mobileNumber("1234567890")
                .password("Password@123")
                .build();
        AuthService authService  = new AuthService();
        Response response = authService.signUp(signUpRequest);
        System.out.println("response of account creation = "+response.asPrettyString());
        Assert.assertEquals(response.asPrettyString(),"User registered successfully!");
    }
}
