package org.restful_booker.booking_tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.restful_booker.POJO.bookingInfo.BookingDates;
import org.restful_booker.POJO.bookingInfo.BookingInfo;
import org.restful_booker.actions.CreateBooking;
import org.restful_booker.actions.GetBookingId;
import org.restful_booker.actions.GetBookingInfo;

import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetBookingInfoTest {
    BookingInfo bookingInfo = new BookingInfo(
            "Denis",
            "Test",
            "Eat",
            777,
            false,
            new BookingDates("2023-12-05", "2023-12-06")
    );

    @Test
    @DisplayName("Get booking info test")
    @Description("Get booking info about first ID in list")
    public void getBookingInfoTest() {
        GetBookingId bookingIds = new GetBookingId();
        int id = bookingIds.getAllBookingIds().get(0);
        ValidatableResponse booking = new GetBookingInfo().getBookingInfoById(id);
        booking.assertThat()
                .statusCode(200)
                .and()
                .body("$", hasKey("firstname"))
                .body("$", hasKey("lastname"))
                .body("$", hasKey("totalprice"))
                .body("$", hasKey("depositpaid"))
                .body("$", hasKey("bookingdates"))
                .body("$", hasKey("additionalneeds"));
    }

    @Test
    @DisplayName("Created booking test")
    @Description("Get info about created booking")
    public void getInfoAboutCreatedBookingTest() {
        CreateBooking createdBooking = new CreateBooking();
        createdBooking.createBooking(bookingInfo);
        int id = createdBooking.getBookingid();
        ValidatableResponse booking = new GetBookingInfo().getBookingInfoById(id);
        booking.assertThat()
                .statusCode(200)
                .and()
                .body("firstname", equalTo(bookingInfo.getFirstname()))
                .body("lastname", equalTo(bookingInfo.getLastname()))
                .body("totalprice", equalTo(bookingInfo.getTotalprice()))
                .body("depositpaid", equalTo(bookingInfo.isDepositpaid()))
                .body("bookingdates.checkin", equalTo(bookingInfo.getBookingdates().getCheckin()))
                .body("bookingdates.checkout", equalTo(bookingInfo.getBookingdates().getCheckout()))
                .body("additionalneeds", equalTo(bookingInfo.getAdditionalneeds()));
    }
}
