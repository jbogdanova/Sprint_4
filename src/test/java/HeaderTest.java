import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.praktikum.services.qascooter.drivers.DriverFactory;
import ru.praktikum.services.qascooter.pages.MainPage;
import ru.praktikum.services.qascooter.utils.WebUtils;

import static org.junit.Assert.assertEquals;

public class HeaderTest {
    WebDriver driver;

    @Test
    public void checkLogoScooter() {
        driver = DriverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.getHeader().clickLogoScooter();
        assertEquals("https://qa-scooter.praktikum-services.ru/", driver.getCurrentUrl());
    }

    @Test
    public void checkLogoYandex() {
        driver = DriverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.getHeader().clickLogoYandex();
        WebUtils.nextWindow(driver, driver.getWindowHandle());
        WebUtils.waitUrl(driver, "https://dzen.ru/");
        assertEquals("https://dzen.ru/?yredirect=true", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
