package ru.praktikum.services.qascooter.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    public static WebDriver getDriver() {
        String browser = System.getProperty("browser", "chrome");

        if (browser.equals("chrome")) {
            return WebDriverManager.chromedriver().create();
        }

        if (browser.equals("firefox")) {
            return WebDriverManager.firefoxdriver().create();
        }

        return null;
    }
}
