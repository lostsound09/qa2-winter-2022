import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonTest {
    private final By ACCEPT_COOKIES_BTN = By.id("sp-cc-accept");
    private final By BESTSELLER_LINK = By.xpath(".//a[@data-csa-c-content-id = 'nav_cs_bestsellers']");
    private final By AIS_DISMISS_BTN = By.xpath(".//input[@data-action-params = '{\"toasterType\":\"AIS_INGRESS\"}']");
    private final By BOOKS_LINK = By.xpath(".//div[@role = 'treeitem']//a[.= 'Books']");
    private final By GRID_ITEM = By.id("gridItemRoot");
    private final By SEE_ALL_REVIEWS_LINK = By.xpath(".//a[@data-hook = 'see-all-reviews-link-foot']");
    private final By TOTAL_REVIEW_COUNT = By.xpath(".//div[@data-hook = 'total-review-count']/span");
    private final By RATING_OUT_OF_TEXT = By.xpath(".//span[@data-hook = 'rating-out-of-text']");

    private WebDriver browser;
    private WebDriverWait wait;

    @Test
    public void openHomePageCheck() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://www.amazon.de/");
        wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        acceptCookies();
        dismissInternationalShippingTooltip();
        clickOnBestsellerCategory();

        clickOnBooksLink();
        WebElement book = findGridItemNumber(4);
        clickOnGridItemName(book);

        String productPageReviewCountText = getReviewCountText();
        String productPageStarRatingText = getStarRatingText();
        System.out.println("Review Count: \"" + productPageReviewCountText + "\"");
        System.out.println("Star Rating: \"" + productPageStarRatingText + "\"");

        clickOnSeeAllReviewsLink();

        String reviewPageReviewCountText = getReviewCountText();
        System.out.println("Total Review Text: \"" + reviewPageReviewCountText + "\"");
        Assertions.assertEquals(productPageReviewCountText, reviewPageReviewCountText);

        String reviewPageStarRatingText = getStarRatingText();
        System.out.println("Rating Out Of Text: \"" + reviewPageStarRatingText + "\"");
        Assertions.assertEquals(productPageStarRatingText, reviewPageStarRatingText);
    }

    private void clickOnSeeAllReviewsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(SEE_ALL_REVIEWS_LINK));
        browser.findElement(SEE_ALL_REVIEWS_LINK).click();
    }

    private String getStarRatingText() {
        return browser.findElement(RATING_OUT_OF_TEXT).getText();
    }

    private String getReviewCountText() {
        wait.until(ExpectedConditions.elementToBeClickable(TOTAL_REVIEW_COUNT));
        return browser.findElement(TOTAL_REVIEW_COUNT).getText();
    }

    private static void clickOnGridItemName(WebElement book) {
        book.findElement(By.className("a-link-normal")).click();
    }

    private WebElement findGridItemNumber(int gridItemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(GRID_ITEM));
        return browser.findElements(GRID_ITEM).get(gridItemNumber - 1);
    }

    private void clickOnBooksLink() {
        wait.until(ExpectedConditions.elementToBeClickable(BOOKS_LINK));
        browser.findElement(BOOKS_LINK).click();
    }

    private void clickOnBestsellerCategory() {
        browser.findElement(BESTSELLER_LINK).click();
    }

    private void dismissInternationalShippingTooltip() {
        wait.until(ExpectedConditions.elementToBeClickable(AIS_DISMISS_BTN));
        browser.findElement(AIS_DISMISS_BTN).click();
    }

    private void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();
    }
}
