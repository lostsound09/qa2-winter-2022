import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TicketsTest {
    private final By FROM = By.id("afrom");
    private final By TO = By.id("bfrom");
    private final By GO_BTN = By.xpath(".//span[@class = 'gogogo']");

    private final By FIRST_NAME_INPUT = ByIdOrName.id("name");
    private final By LAST_NAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By ADULTS = By.id("adults");
    private final By CHILDREN = By.id("children");
    private final By BAG = By.id("bugs");
    private final By FLIGHT = By.id("flight");
    private final By GET_PRICE_BTN = By.xpath(".//span[.= 'Get Price']");
    private final By DESTINATION_FROM = By.xpath("(.//div[@class = 'infoTxt']//span)[1]");
    private final By DESTINATION_TO = By.xpath("(.//div[@class = 'infoTxt']//span)[2]");
    private final By FIRST_NAME = By.xpath("(.//div[@id = 'response']/span[@class = 'bTxt'])[1]");
    private final By RESPONSE = By.id("response");
    private final By BOOK_BTN = By.id("book2");
    private final By BOOK_CONFIRMATION_BTN = By.id("book3");
    private final By BOOK_BLOCK = By.id("book");
    private final String SEAT = ".//div[@class = 'line']/div[.= '%d']";
    private final By BOOKING_CONFIRMATION_TEXT = By.xpath(".//div[@class = 'finalTxt']");



    private WebDriver browser;
    private WebDriverWait wait;

    @Test
    public void reservationCheck() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://www.qaguru.lv:8089/tickets/");

        wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        String destinationFrom = "RIX";
        String destinationTo = "SFO";
        String firstName = "First Name";
        String lastName = "Last Name";
        String discount = "Discount Code";
        String adults = "3";
        String children = "2";
        String bag = "1";
        String flight = "13";
        select(FROM, destinationFrom);
        select(TO, destinationTo);

        Select airportFrom = new Select(browser.findElement(FROM));
        airportFrom.selectByValue(destinationFrom);

        Select airportTO = new Select(browser.findElement(TO));
        airportTO.selectByValue(destinationTo);

        browser.findElement(GO_BTN).click();


        type(FIRST_NAME_INPUT, "First Name");
        type(LAST_NAME, "Last Name");
        type(DISCOUNT, "Discount Code");
        type(ADULTS, "3");
        type(CHILDREN, "2");
        type(BAG, "1");
        select(FLIGHT, "13");

        browser.findElement(GET_PRICE_BTN).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(RESPONSE));
        Assertions.assertEquals(destinationFrom, browser.findElement(DESTINATION_FROM).getText());
        Assertions.assertEquals(destinationTo, browser.findElement(DESTINATION_TO).getText());
        Assertions.assertEquals(firstName + "!", browser.findElement(FIRST_NAME).getText());
        String response = browser.findElement(RESPONSE).getText();
        Assertions.assertTrue(response.contains("for 4220 EUR"));

        browser.findElement(BOOK_BTN).click();
        int seatNumber = 8;
        browser.findElement(By.xpath(SEAT.formatted(seatNumber))).click();
        String seat = browser.findElement(BOOK_BLOCK).getText();
        Assertions.assertEquals("Your seat is: " + seatNumber, seat);
        browser.findElement(BOOK_CONFIRMATION_BTN).click();
        WebElement confirmationText = wait.until(ExpectedConditions.presenceOfElementLocated(BOOKING_CONFIRMATION_TEXT));
        Assertions.assertEquals("Thank You for flying with us!", confirmationText.getText());

    }
    private void select(By locator, String value) {
        WebElement we = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select select = new Select(we);
        select.selectByValue(value);
    }
    private void type(By locator, String text) {
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        input.clear();
        input.sendKeys(text);
    }
}
