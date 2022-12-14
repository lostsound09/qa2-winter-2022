package tickets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tickets.pages.HomePage;
import tickets.pages.PassengerInfoPage;
import tickets.pages.ConfirmationPage;
import tickets.pages.SelectSeatPage;

public class TicketTestOnPages {
    private final String URL = "http://www.qaguru.lv:8089/tickets/";
    private final String FROM_AIRPORT = "RIX";
    private final String TO_AIRPORT = "SFO";
    private tickets.BaseFunc baseFunc = new BaseFunc();

    @Test
    public void successfulRegistrationTest() {
        baseFunc.openUrl(URL);
        HomePage homePage = new HomePage(baseFunc);
        homePage.selectAirports(FROM_AIRPORT, TO_AIRPORT);

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);

        String firstName = "First Name";

        infoPage.typeFirstName(firstName);
        infoPage.typeLastName("Last Name");
        infoPage.typeDiscountCode("Discount Code");
        infoPage.typeAdultCount("3");
        infoPage.typeChildrenCount("2");
        infoPage.typeBagCount("1");
        infoPage.selectFlightDay("13");

        infoPage.clickGetPriceButton();
        SelectSeatPage selectSeatPage = new SelectSeatPage(baseFunc);

        selectSeatPage.assertFromAirportEquals(FROM_AIRPORT);
        selectSeatPage.assertToAirportEquals(TO_AIRPORT);
        selectSeatPage.assertFirstNameEquals(firstName);
        selectSeatPage.assertPriceEquals(4220);

        selectSeatPage.clickBookButton();
        int seatNumber = 8;
        selectSeatPage.clickSeatButton(seatNumber);
        selectSeatPage.assertSeatEquals(seatNumber);
        selectSeatPage.clickBookConfirmationButton();

        ConfirmationPage confirmationPage = new ConfirmationPage(baseFunc);
        confirmationPage.assertBookingSuccessful();

    }
}
