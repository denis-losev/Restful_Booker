package org.restful_booker.POJO.bookingInfo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
public class BookingInfo {
    String firstname, lastname, additionalneeds;
    int totalprice;
    boolean depositpaid;
    BookingDates bookingdates;
}
