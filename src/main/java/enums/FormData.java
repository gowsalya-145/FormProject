package enums;
import org.openqa.selenium.By;
public enum FormData {
    FIRST_NAME(By.xpath("//input[@name='q16_name[first]']")),
    LAST_NAME(By.xpath("//input[@name='q16_name[last]']")),
    EMAIL(By.xpath("//input[@name='q17_email17']")),

    ROOM_TYPE(By.xpath("//select[@name='q6_roomType']")),
    GUESTS(By.xpath("//input[@name='q18_numberOf18']")),

    ARRIVAL_DATE(By.xpath("//input[@id='lite_mode_22']")),
    ARRIVAL_TIME(By.xpath("//input[@name='q22_arrivalDate[timeInput]']")),
    ARRIVAL_AMPM(By.xpath("//select[@name='q22_arrivalDate[ampm]']")),

    DEPARTURE_MONTH(By.xpath("//select[@name='q20_departureDate20[month]']")),
    DEPARTURE_DAY(By.xpath("//select[@name='q20_departureDate20[day]']")),
    DEPARTURE_YEAR(By.xpath("//select[@name='q20_departureDate20[year]']")),

    FREE_PICKUP_YES(By.xpath("//label[@for='input_10_0']")),

    FLIGHT_NUMBER(By.xpath("//input[@name='q28_flightNumber28']")),

    SPECIAL_REQUEST(By.xpath("//textarea[@name='q30_specialRequests']")),

    SUBMIT(By.xpath("//button[@id='input_2']"));

    private final By locator;

    FormData(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }
}
