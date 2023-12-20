package org.restful_booker.actions;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.restful_booker.constants.Requests;
import org.restful_booker.constants.Token;
import org.restful_booker.constants.User;

public class LoginUser extends Requests {
    User user;

    public LoginUser(User user) {
        this.user = user;
    }

    @Step("Login user")
    public ValidatableResponse loginUser() {
        return doPostRequest(AUTH_ENDPOINT, user);
    }

    @Step("Get token")
    public String getToken() {
        return loginUser().extract().body().as(Token.class).getToken();
    }
}
