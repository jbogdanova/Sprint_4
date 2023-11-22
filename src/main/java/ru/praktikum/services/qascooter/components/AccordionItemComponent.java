package ru.praktikum.services.qascooter.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.praktikum.services.qascooter.pages.BasePage;
import ru.praktikum.services.qascooter.utils.WebUtils;

public class AccordionItemComponent extends BasePage {
    private final By accordionItemHeading;
    private final By accordionItemPanel;

    public AccordionItemComponent(WebDriver driver, int id) {
        super(driver);
        accordionItemHeading = By.id("accordion__heading-" + id);
        accordionItemPanel = By.id("accordion__panel-" + id);
    }

    public void clickAccordionItem() throws InterruptedException {
        WebElement accordionItemHeading = driver.findElement(this.accordionItemHeading);
        WebUtils.scrollTo(driver, accordionItemHeading);
        Thread.sleep(100);
        accordionItemHeading.click();
    }

    public String getAccordionItemHeadingText() {
        return driver.findElement(accordionItemHeading).getText();
    }

    public String getAccordionItemPanelText() {
        return driver.findElement(accordionItemPanel).getText();
    }
}
