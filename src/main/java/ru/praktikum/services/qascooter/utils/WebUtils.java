package ru.praktikum.services.qascooter.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class WebUtils {

    public static void waitUrl(WebDriver driver, String url) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.urlContains(url));

    }

    public static void nextWindow(WebDriver driver, String currentHandle) {
        Set<String> handles = driver.getWindowHandles();
        for (String actual : handles) {
            if (!actual.equalsIgnoreCase(currentHandle)) {
                driver.switchTo().window(actual);
            }
        }
    }

    public static void wait(WebDriver driver, By element) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
