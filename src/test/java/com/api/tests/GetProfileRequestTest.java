package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.api.listeners.TestListener.class)
public class GetProfileRequestTest {

    @Test(description = "Getting profiles of users")
    public void getProfileInfo(){

        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("avantika","Password@123"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginResponse.getToken());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        System.out.println(userProfileResponse.getUsername());
    }
}
