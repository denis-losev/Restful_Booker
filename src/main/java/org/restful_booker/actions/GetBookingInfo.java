package org.restful_booker.actions;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.restful_booker.POJO.bookingInfo.BookingInfo;
import org.restful_booker.constants.Requests;

public class GetBookingInfo extends Requests {
    @Step("Get Booking Info request")
    public ValidatableResponse getBookingInfoById(int id) {
        return doGetRequest(BOOKING_ENDPOINT, id);
    }

    @Step("Get BookingInfo POJO")
    public BookingInfo getPOJOBookingInfo(int id) {
        return getBookingInfoById(id).extract().body().as(BookingInfo.class);
    }
}
