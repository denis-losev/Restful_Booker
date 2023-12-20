package org.restful_booker.actions;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import lombok.Getter;
import org.restful_booker.POJO.bookingInfo.BookingInfo;
import org.restful_booker.constants.Requests;

@Getter
public class CreateBooking extends Requests {
    int bookingid;

    @Step("Create booking")
    public ValidatableResponse createBooking(BookingInfo bookingInfo) {
        ValidatableResponse response = doPostRequest(BOOKING_ENDPOINT, bookingInfo);
        this.bookingid = response.extract().path("bookingid");
        return response;
    }
}
