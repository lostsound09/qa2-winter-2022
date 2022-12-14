package tickets.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ByIdOrName;
import tickets.BaseFunc;

public class PassengerInfoPage {
    private BaseFunc baseFunc;
    private final By FIRST_NAME_INPUT = ByIdOrName.id("name");
    private final By LAST_NAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By ADULTS = By.id("adults");
    private final By CHILDREN = By.id("children");
    private final By BAG = By.id("bugs");
    private final By FLIGHT = By.id("flight");
    private final By GET_PRICE_BTN = By.xpath(".//span[.= 'Get Price']");


    public PassengerInfoPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void typeFirstName(String firstName) {
        baseFunc.type(FIRST_NAME_INPUT, firstName);
    }
    public void typeLastName(String lastName){
        baseFunc.type(LAST_NAME, lastName);
    }
    public void typeDiscountCode(String discountCode) {
        baseFunc.type(DISCOUNT, discountCode);
    }
    public void typeAdultCount(String adultCount) {
        baseFunc.type(ADULTS, adultCount);
    }
    public void typeChildrenCount(String childrenCount) {
        baseFunc.type(CHILDREN, childrenCount);
    }
    public void typeBagCount(String bagCount) {
        baseFunc.type(BAG, bagCount);
    }
    public void selectFlightDay(String flightDay) {
        baseFunc.select(FLIGHT, flightDay);
    }

    public void clickGetPriceButton() {
        baseFunc.click(GET_PRICE_BTN);
    }
}

