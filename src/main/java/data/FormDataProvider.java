package data;
import enums.FormData;
import org.testng.annotations.DataProvider;
public class FormDataProvider {

    @DataProvider(name = "bookingData", parallel = true)
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
                },
                {
                        "John",
                        "David",
                        "john@test.com",
                        "Standard Room (1 to 2 People)",
                        "3",
                        "AI204",
                        "Extra Bed"
                },
                {
                        "Priya",
                        "S",
                        "priya@test.com",
                        "Standard Room (1 to 2 People)",
                        "4",
                        "AI205",
                        "Sea View"
                }
        };
    }
}
