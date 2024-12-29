package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.requests.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import com.beust.ah.A;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test

public class UpdateProfileTest {

    public void updateProfileTest(){
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("avantika","Password@123"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginResponse.getToken());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        System.out.println(userProfileResponse.getUsername());


        ProfileRequest  profileRequest = new ProfileRequest.Builder()
                .firstName("Disha")
                .lastName("Bhatt")
                .email("abc@123")
                .mobileNumber("1234567890").build();
        response = userProfileManagementService.updateProfile(loginResponse.getToken(),profileRequest);
        System.out.println("response = "+response.asPrettyString());
    }



}
