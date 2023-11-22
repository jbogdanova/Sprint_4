package ru.praktikum.services.qascooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrackPage extends BasePage {
    private final By trackNotFound = By.xpath(".//img[contains(@alt, 'Not found')]");

    public TrackPage(WebDriver driver) {
        super(driver);
    }

    public void isDisplayedTrackNotFound() {
        driver.findElement(trackNotFound).isDisplayed();
    }
}
