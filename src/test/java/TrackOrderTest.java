import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.praktikum.services.qascooter.drivers.DriverFactory;
import ru.praktikum.services.qascooter.pages.MainPage;
import ru.praktikum.services.qascooter.pages.TrackPage;

public class TrackOrderTest {
    WebDriver driver;

    @Test
    public void trackOrder() {
        driver = DriverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.getHeader().clickOrderStatusButton();
        mainPage.getHeader().inputOrderNumber("111");
        mainPage.getHeader().clickGoButton();
        TrackPage trackPage = new TrackPage(driver);
        trackPage.isDisplayedTrackNotFound();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
