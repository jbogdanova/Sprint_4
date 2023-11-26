import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import ru.praktikum.services.qascooter.drivers.DriverFactory;
import ru.praktikum.services.qascooter.pages.MainPage;
import ru.praktikum.services.qascooter.pages.OrderPage;

import static org.junit.Assert.assertFalse;

@RunWith(Parameterized.class)
public class CreateOrderTest {
    WebDriver driver;

    private final String entryPoint;
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String metroStation;
    private final String telephoneNumber;
    private final String date;
    private final String rentalPeriod;
    private final String scooterColour;
    private final String comment;

    public CreateOrderTest(String entryPoint, String firstName, String secondName, String address, String metroStation, String telephoneNumber, String date, String rentalPeriod, String scooterColour, String comment) {
        this.entryPoint = entryPoint;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.metroStation = metroStation;
        this.telephoneNumber = telephoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.scooterColour = scooterColour;
        this.comment = comment;
    }

    @Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{{"Header", "Юля", "Белимова", "Москва", "Черкизовская", "89096783324", "30.11.2023", "сутки", "чёрный жемчуг", "коммент"}, {"Main", "Аня", "Морозова", "Москва", "Сокольники", "89096783321", "28.11.2023", "двое суток", "серая безысходность", "коммент"},};
    }

    @Test
    public void createOrder() {
        driver = DriverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickCookieButton();
        if (entryPoint.equals("Header")) {
            mainPage.getHeader().clickOrderButton();
        } else if (entryPoint.equals("Main")) {
            mainPage.clickOrderButton();
        }
        mainPage.getHeader().clickOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.inputFirstName(firstName);
        orderPage.inputSecondName(secondName);
        orderPage.inputAddress(address);
        orderPage.inputMetroStation(metroStation);
        orderPage.inputTelephoneNumber(telephoneNumber);
        orderPage.clickNextButton();
        orderPage.inputDate(date);
        orderPage.inputRentalPeriod(rentalPeriod);
        orderPage.inputScooterColour(scooterColour);
        orderPage.inputComment(comment);
        orderPage.clickOrderButton();
        orderPage.clickAcceptButton();
        orderPage.isDisplayedSuccessMessage();
        assertFalse(orderPage.getSuccessText().isEmpty());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
