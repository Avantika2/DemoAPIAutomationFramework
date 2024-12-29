package com.api.tests;

import static io.restassured.RestAssured.*;
import java.net.URL;
import java.net.URLClassLoader;

import com.api.base.AuthService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)

public class LoginAPITest {

    @Test(description = "Verify if login is working.....")
    public void loginTest() {

        LoginRequest loginRequest = new LoginRequest("avantika","Password@123");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class); 
        System.out.println("response = "+response.prettyPrint());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(loginResponse.getToken() !=null);
        Assert.assertEquals(loginResponse.getEmail(),"abc@123");
    }


}