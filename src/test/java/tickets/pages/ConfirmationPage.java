package tickets.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tickets.BaseFunc;

public class ConfirmationPage {
    private BaseFunc baseFunc;
    private final By BOOKING_CONFIRMATION_TEXT = By.xpath(".//div[@class = 'finalTxt']");


    public ConfirmationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void assertBookingSuccessful() {
        WebElement confirmationText = baseFunc.waitForElement(BOOKING_CONFIRMATION_TEXT);
        Assertions.assertEquals("Thank You for flying with us!", confirmationText.getText());
    }
}
