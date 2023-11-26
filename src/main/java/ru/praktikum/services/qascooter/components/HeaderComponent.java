package ru.praktikum.services.qascooter.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.services.qascooter.pages.BasePage;
import ru.praktikum.services.qascooter.utils.WebUtils;

public class HeaderComponent extends BasePage {
    private final By logoYandex = By.xpath(".//a[@href='//yandex.ru']");
    private final By logoScooter = By.xpath(".//a[@href='/']");
    private final By orderButton = By.xpath(".//div[contains(@class, 'Header_Nav')]/button[contains(@class, 'Button_Button')]");
    private final By orderStatusButton = By.xpath(".//button[contains(@class, 'Header_Link')]");
    private final By orderNumber = By.xpath("//input[@placeholder='Введите номер заказа']");
    private final By goButton = By.xpath(".//div[contains(@class, 'Header_SearchInput')]/button[contains(@class, 'Button_Button')]");

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    }

    public void clickLogoScooter() {
        driver.findElement(logoScooter).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
    }

    public void inputOrderNumber(String value) {
        driver.findElement(orderNumber).sendKeys(value);
    }

    public void clickGoButton() {
        WebUtils.wait(driver, goButton);
        driver.findElement(goButton).click();
    }
}
