package org.restful_booker.booking_tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.restful_booker.actions.GetBookingId;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;

public class GetAllIdsTest {
    @Test
    @DisplayName("Get all id's test")
    @Description("Get all id's test")
    public void getAllIdTest() {
        List<Integer> bookingIds = new GetBookingId().getAllBookingIds();
        Assert.assertFalse(bookingIds.isEmpty());
    }
}
