package ru.praktikum.services.qascooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.services.qascooter.components.AccordionItemComponent;
import ru.praktikum.services.qascooter.components.HeaderComponent;
import ru.praktikum.services.qascooter.utils.WebUtils;

public class MainPage extends BasePage {
    private final int ACCORDION_SIZE = 8;
    private final HeaderComponent header;
    private final AccordionItemComponent[] accordion = new AccordionItemComponent[ACCORDION_SIZE];
    private final By orderButton = By.xpath(".//button[contains(@class, 'Button_Middle')]");

    public MainPage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver);
        for (int i = 0; i < ACCORDION_SIZE; i++) {
            accordion[i] = new AccordionItemComponent(driver, i);
        }
    }

    public HeaderComponent getHeader() {
        return header;
    }

    public AccordionItemComponent getAccordionItem(int id) {
        return accordion[id];
    }

    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void clickOrderButton() {
        WebUtils.scrollTo(driver, driver.findElement(orderButton));
        driver.findElement(orderButton).click();
    }
}
