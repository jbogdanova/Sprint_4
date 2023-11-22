import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.praktikum.services.qascooter.drivers.DriverFactory;
import ru.praktikum.services.qascooter.pages.OrderPage;

import static org.junit.Assert.assertEquals;

public class CheckOrderValidationTest {
    WebDriver driver;

    @Test
    public void checkValidationFirstName() {
        driver = DriverFactory.getDriver();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.open();
        orderPage.inputFirstName("abcde");
        orderPage.clickOrderHeader();
        String error = orderPage.getValidationErrorText();
        assertEquals("Введите корректное имя", error);
    }

    @Test
    public void checkValidationSecondName() {
        driver = DriverFactory.getDriver();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.open();
        orderPage.inputSecondName("abcde");
        orderPage.clickOrderHeader();
        String error = orderPage.getValidationErrorText();
        assertEquals("Введите корректную фамилию", error);
    }

    @Test
    public void checkValidationAddress() {
        driver = DriverFactory.getDriver();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.open();
        orderPage.inputAddress("abcde");
        orderPage.clickOrderHeader();
        String error = orderPage.getValidationErrorText();
        assertEquals("Введите корректный адрес", error);
    }

    @Test
    public void checkValidationMetroStation() {
        driver = DriverFactory.getDriver();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.open();
        orderPage.inputFirstName("Анна");
        orderPage.inputSecondName("Павлова");
        orderPage.inputAddress("Москва");
        orderPage.inputTelephoneNumber("89994562343");
        orderPage.clickNextButton();
        String error = orderPage.getValidationErrorText();
        assertEquals("Выберите станцию", error);
    }

    @Test
    public void checkValidationTelephoneNumber() {
        driver = DriverFactory.getDriver();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.open();
        orderPage.inputTelephoneNumber("8909");
        orderPage.clickOrderHeader();
        String error = orderPage.getValidationErrorText();
        assertEquals("Введите корректный номер", error);
    }
}
