package org.restful_booker;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.restful_booker.actions.LoginUser;
import org.restful_booker.constants.User;

import static org.hamcrest.CoreMatchers.notNullValue;

public class LoginUserTest {
    @Test
    @DisplayName("Success login user test")
    @Description("Upon successful authorization, the token is returned")
    public void succesLoginUserTest() {
        User user = new User();
        LoginUser loginUser = new LoginUser(user);
        loginUser.loginUser()
                .assertThat()
                .statusCode(200)
                .and()
                .body("token", notNullValue());
    }

}
