import org.openqa.selenium.By;

public class DiscoverCarsLocators {
    private final By LOGO = By.xpath(".//div[contains(@class, 'logo-cell')]//a");
    private final By CURRENCY = By.xpath(".//a[@id = 'currentCurrency']");
    private final By LOG_IN = By.xpath(".//a[contains(@class, 'my-booking')]");
    private final By HOME_CAPTION = By.xpath(".//div[contains(@class, 'home-caption')]");
    private final By PICK_DATE = By.xpath(".//input[@name = 'pickDate']");
    private final By PICK_DATE_SUBMIT = By.xpath(".//input[@name = 'pickDateSubmit']");
    private final By SB_COUNTRY = By.xpath(".//u[@id = 'sb-country']");
    private final By SUBMIT_LOCATION = By.xpath(".//button[@id = 'location-submit']");
    private final By REVIEW_ARROW_LEFT = By.xpath(".//div[@id = 'review-arrow-left']");
    private final By TP_WIDGET_REVIEW = By.xpath("(.//div[@class = 'tp-widget-review'])[4]");
    private final By RECOMMENDED_BY = By.xpath(".//section[@class = 'recommended-by']//h2");

    private final By CAR_GROUPS_SMALL = By.xpath(".//a[@data-id = 'car-groups-small']");
    private final By NEXT_BTN = By.xpath(".//div[contains(@class, 'next')]");
    private final By SHOWING_CARS = By.xpath(".//span[@class = 'showing-cars']");
    private final By PRICE = By.xpath(".//div[contains(@class, 'showing')]//a");
    private final By BAG = By.xpath("(.//div[@class =  'car-basic-info']//ul//span)[2]");
    private final By SPECIAL_OFFERS = By.xpath(".//div[contains(@class,  'flt-type') and not(contains(@class, 'hide'))][1]");
    private final By RENTAL_CONDITIONS = By.xpath("(.//div[@class = 'rc-link'])[1]");
    private final By VIEW_BTN = By.xpath("(.//a[contains(@class, 'btn-book')])[1]");
    private final By AIR_CONDITIONING_PRICE = By.xpath(".//div[@id = 'filter-air-conditioning']//span[@class = 'min-price']");
    private final By GASOLINE = By.xpath(".//label[contains(@class, 'filter-fuel-type') and contains(text(), 'Gasoline')]");
    private final By PARTIAL_PREPAYMENT = By.xpath("(.//span[contains(@class, 'badge') and .='Partial prepayment'])[2]");
    private final By NUMBER_OF_SEATS = By.xpath(".//label[@for= 'number-of-seats-seats-4']");
    private final By SUPPLIER_RATING = By.xpath("(.//div[@class= 'supplier-rating'])[2]");
    private final By CAR_PRICE = By.xpath("(.//div[@class= 'price-item-price-main'])[2]");



}
