package pages;
import enums.FormData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class JotFormPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public JotFormPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void fillForm(String firstName,
                         String lastName,
                         String email,
                         String roomType,
                         String guests,
                         String flightNumber,
                         String specialRequest) {

        getElement(FormData.FIRST_NAME.getLocator()).sendKeys(firstName);
        getElement(FormData.LAST_NAME.getLocator()).sendKeys(lastName);
        getElement(FormData.EMAIL.getLocator()).sendKeys(email);

        Select room = new Select(getElement(FormData.ROOM_TYPE.getLocator()));
        room.selectByVisibleText(roomType);

        WebElement guest = getElement(FormData.GUESTS.getLocator());
        guest.clear();
        guest.sendKeys(guests);

        WebElement arrivalDate = getElement(FormData.ARRIVAL_DATE.getLocator());
        arrivalDate.sendKeys(Keys.CONTROL + "a");
        arrivalDate.sendKeys("06-20-2026");

        WebElement arrivalTime = getElement(FormData.ARRIVAL_TIME.getLocator());
        arrivalTime.sendKeys(Keys.CONTROL + "a");
        arrivalTime.sendKeys("10:30");

        new Select(getElement(FormData.ARRIVAL_AMPM.getLocator()))
                .selectByVisibleText("AM");

        new Select(getElement(FormData.DEPARTURE_MONTH.getLocator()))
                .selectByVisibleText("June");

        new Select(getElement(FormData.DEPARTURE_DAY.getLocator()))
                .selectByVisibleText("25");

        new Select(getElement(FormData.DEPARTURE_YEAR.getLocator()))
                .selectByVisibleText("2026");

        WebElement pickup = getElement(FormData.FREE_PICKUP_YES.getLocator());
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", pickup);

        getElement(FormData.FLIGHT_NUMBER.getLocator()).sendKeys(flightNumber);
        getElement(FormData.SPECIAL_REQUEST.getLocator()).sendKeys(specialRequest);
    }

    public void clickSubmit() {

        try {
            WebElement submit = wait.until(
                    ExpectedConditions.elementToBeClickable(FormData.SUBMIT.getLocator())
            );

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", submit);

            submit.click();

        } catch (Exception e) {
            System.out.println("Submit button not found or not clickable");
            e.printStackTrace();
        }
    }
}