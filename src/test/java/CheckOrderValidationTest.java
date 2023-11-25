import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.praktikum.services.qascooter.constants.ValidationConstant;
import ru.praktikum.services.qascooter.drivers.DriverFactory;
import ru.praktikum.services.qascooter.pages.OrderPage;

import static org.junit.Assert.assertEquals;

public class CheckOrderValidationTest {
    WebDriver driver;
    OrderPage orderPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        orderPage = new OrderPage(driver);
        orderPage.open();
    }

    @Test
    public void checkValidationFirstName() {
        orderPage.inputFirstName(ValidationConstant.INVALID_NAME);
        orderPage.clickOrderHeader();
        String error = orderPage.getValidationErrorText();
        assertEquals("Введите корректное имя", error);
    }

    @Test
    public void checkValidationSecondName() {
        orderPage.inputSecondName(ValidationConstant.INVALID_NAME);
        orderPage.clickOrderHeader();
        String error = orderPage.getValidationErrorText();
        assertEquals("Введите корректную фамилию", error);
    }

    @Test
    public void checkValidationAddress() {
        orderPage.inputAddress(ValidationConstant.INVALID_ADDRESS);
        orderPage.clickOrderHeader();
        String error = orderPage.getValidationErrorText();
        assertEquals("Введите корректный адрес", error);
    }

    @Test
    public void checkValidationMetroStation() {
        orderPage.inputFirstName(ValidationConstant.VALID_FIRST_NAME);
        orderPage.inputSecondName(ValidationConstant.VALID_SECOND_NAME);
        orderPage.inputAddress(ValidationConstant.VALID_ADDRESS);
        orderPage.inputTelephoneNumber(ValidationConstant.VALID_PHONE);
        orderPage.clickNextButton();
        String error = orderPage.getValidationErrorText();
        assertEquals("Выберите станцию", error);
    }

    @Test
    public void checkValidationTelephoneNumber() {
        orderPage.inputTelephoneNumber(ValidationConstant.INVALID_PHONE);
        orderPage.clickOrderHeader();
        String error = orderPage.getValidationErrorText();
        assertEquals("Введите корректный номер", error);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
