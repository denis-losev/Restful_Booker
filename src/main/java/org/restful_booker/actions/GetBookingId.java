package org.restful_booker.actions;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.restful_booker.POJO.BookingId;
import org.restful_booker.constants.Requests;

import java.util.List;

public class GetBookingId extends Requests {
    @Step("Collect all Booking Id's")
    public List<Integer> getAllBookingIds() {
        List<Integer> ids;
        ValidatableResponse response = doGetRequest(BOOKING_ENDPOINT);
        JsonPath responseJsonPath = response.extract().jsonPath();
        ids = responseJsonPath.getList("bookingid");
        return ids;
    }
}
