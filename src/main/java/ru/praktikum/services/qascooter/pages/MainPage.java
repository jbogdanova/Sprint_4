package ru.praktikum.services.qascooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.services.qascooter.components.AccordionItemComponent;
import ru.praktikum.services.qascooter.components.HeaderComponent;

public class MainPage extends BasePage {
    private final HeaderComponent header;
    private final AccordionItemComponent accordion;
    private final By orderButton = By.xpath(".//button[contains(@class, 'Button_Middle')]");
    private final By cookieButton = By.id("rcc-confirm-button");

    public MainPage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver);
        accordion = new AccordionItemComponent(driver);
    }

    public HeaderComponent getHeader() {
        return header;
    }

    public AccordionItemComponent getAccordionItem() {
        return accordion;
    }

    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }
}
