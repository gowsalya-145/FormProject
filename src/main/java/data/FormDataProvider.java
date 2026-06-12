package data;
import enums.FormData;
import org.testng.annotations.DataProvider;
public class FormDataProvider {

    @DataProvider(name = "bookingData")
    public Object[][] bookingData() {

        return new Object[][]{
                {
                        "Gowsalya",
                        "K",
                        "gowsalya@test.com",
                        "Standard Room (1 to 2 People)",
                        "2",
                        "AI203",
                        "Need Airport Pickup"
                }
        };
    }
}
