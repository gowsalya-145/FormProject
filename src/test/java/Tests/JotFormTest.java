package Tests;
import base.BaseTest;
import data.FormDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.JotFormPage;

import java.util.List;

public class JotFormTest extends BaseTest {

    @Test(dataProvider = "bookingData",
            dataProviderClass = FormDataProvider.class)
    public void submitBookingForm(String firstName,
                                  String lastName,
                                  String email,
                                  String roomType,
                                  String guests,
                                  String flightNumber,
                                  String specialRequest) {

        JotFormPage page = new JotFormPage(driver, wait);

        page.fillForm(firstName, lastName, email,
                roomType, guests, flightNumber, specialRequest);

        page.clickSubmit();
    }
    }
