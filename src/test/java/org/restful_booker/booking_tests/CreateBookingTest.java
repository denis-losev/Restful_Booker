package org.restful_booker.booking_tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.restful_booker.POJO.bookingInfo.BookingDates;
import org.restful_booker.POJO.bookingInfo.BookingInfo;
import org.restful_booker.actions.CreateBooking;

import static org.hamcrest.CoreMatchers.equalTo;

public class CreateBookingTest {
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
    public void createBookingTest() {
        CreateBooking createdBooking = new CreateBooking();
        createdBooking.createBooking(bookingInfo)
                .assertThat()
                .statusCode(200)
                .and()
                .body("bookingid", equalTo(createdBooking.getBookingid()));
    }
}
