package ru.praktikum.services.qascooter.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.praktikum.services.qascooter.pages.BasePage;
import ru.praktikum.services.qascooter.utils.WebUtils;

public class AccordionItemComponent extends BasePage {
    public AccordionItemComponent(WebDriver driver) {
        super(driver);
    }

    public void clickAccordionItem(int id) {
        WebElement accordionItemHeading = driver.findElement(By.id("accordion__heading-" + id));
        accordionItemHeading.click();
    }

    public String getAccordionItemHeadingText(int id) {
        By accordionItemHeading = By.id("accordion__heading-" + id);
        return driver.findElement(accordionItemHeading).getText();
    }

    public String getAccordionItemPanelText(int id) {
        By accordionItemPanel = By.id("accordion__panel-" + id);
        WebUtils.wait(driver, accordionItemPanel);
        return driver.findElement(accordionItemPanel).getText();
    }
}
