package tickets.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import tickets.BaseFunc;

public class SelectSeatPage {
    private BaseFunc baseFunc;
    private final By DESTINATION_FROM = By.xpath("(.//div[@class = 'infoTxt']//span)[1]");
    private final By DESTINATION_TO = By.xpath("(.//div[@class = 'infoTxt']//span)[2]");
    private final By FIRST_NAME = By.xpath("(.//div[@id = 'response']/span[@class = 'bTxt'])[1]");
    private final By RESPONSE = By.id("response");
    private final By BOOK_BTN = By.id("book2");
    private final String SEAT = ".//div[@class = 'line']/div[.= '%d']";
    private final By BOOK_BLOCK = By.id("book");
    private final By BOOK_CONFIRMATION_BTN = By.id("book3");



    public SelectSeatPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void assertFromAirportEquals(String airport) {
        Assertions.assertEquals(airport, baseFunc.waitForElement(DESTINATION_FROM).getText());
    }
    public void assertToAirportEquals(String airport) {
        Assertions.assertEquals(airport, baseFunc.waitForElement(DESTINATION_TO).getText());
    }
    public void assertFirstNameEquals(String firstName) {
        Assertions.assertEquals(firstName + "!", baseFunc.waitForElement(FIRST_NAME).getText());
    }
    public void assertPriceEquals(int price) {
        String response = baseFunc.waitForElement(RESPONSE).getText();
        Assertions.assertTrue(response.contains("for " + price + " EUR"));
    }
    public void assertSeatEquals(int seatNumber) {
        String seat = baseFunc.waitForElement(BOOK_BLOCK).getText();
        Assertions.assertEquals("Your seat is: " + seatNumber, seat);
    }
    public void clickBookButton() {
        baseFunc.waitForElement(BOOK_BTN).click();
    }
    public void clickSeatButton(int seatNumber) {
        baseFunc.waitForElement(By.xpath(SEAT.formatted(seatNumber))).click();
    }

    public void clickBookConfirmationButton() {
        baseFunc.waitForElement(BOOK_CONFIRMATION_BTN).click();

    }
}
