package pages;
import enums.FormData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class JotFormPage {


    private final WebDriver driver;

    public JotFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(String firstName,
                         String lastName,
                         String email,
                         String roomType,
                         String guests,
                         String flightNumber,
                         String specialRequest) {

        // First Name
        driver.findElement(FormData.FIRST_NAME.getLocator())
                .sendKeys(firstName);

        // Last Name
        driver.findElement(FormData.LAST_NAME.getLocator())
                .sendKeys(lastName);

        // Email
        driver.findElement(FormData.EMAIL.getLocator())
                .sendKeys(email);

        // Room Type
        Select roomTypeDropdown =
                new Select(driver.findElement(FormData.ROOM_TYPE.getLocator()));

        roomTypeDropdown.selectByVisibleText(roomType);

        // Guests
        WebElement guestField =
                driver.findElement(FormData.GUESTS.getLocator());

        guestField.clear();
        guestField.sendKeys(guests);

        // Arrival Date
        WebElement arrivalDate =
                driver.findElement(FormData.ARRIVAL_DATE.getLocator());

        arrivalDate.sendKeys(Keys.CONTROL + "a");
        arrivalDate.sendKeys("06-20-2026");

        // Arrival Time
        WebElement arrivalTime =
                driver.findElement(FormData.ARRIVAL_TIME.getLocator());

        arrivalTime.sendKeys(Keys.CONTROL + "a");
        arrivalTime.sendKeys("10:30");

        // AM/PM
        Select ampm =
                new Select(driver.findElement(FormData.ARRIVAL_AMPM.getLocator()));

        ampm.selectByVisibleText("AM");

        // Departure Month
        Select depMonth =
                new Select(driver.findElement(FormData.DEPARTURE_MONTH.getLocator()));

        depMonth.selectByVisibleText("June");

        // Departure Day
        Select depDay =
                new Select(driver.findElement(FormData.DEPARTURE_DAY.getLocator()));

        depDay.selectByVisibleText("25");

        // Departure Year
        Select depYear =
                new Select(driver.findElement(FormData.DEPARTURE_YEAR.getLocator()));

        depYear.selectByVisibleText("2026");

        // Free Pickup Radio Button
        WebElement pickup =
                driver.findElement(FormData.FREE_PICKUP_YES.getLocator());

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", pickup);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", pickup);

        // Flight Number
        driver.findElement(FormData.FLIGHT_NUMBER.getLocator())
                .sendKeys(flightNumber);

        // Special Request
        driver.findElement(FormData.SPECIAL_REQUEST.getLocator())
                .sendKeys(specialRequest);
    }

    public void clickSubmit() {

        WebElement submit =
                driver.findElement(FormData.SUBMIT.getLocator());

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", submit);

        submit.click();
    }
}