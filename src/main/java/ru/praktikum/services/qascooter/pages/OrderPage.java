package ru.praktikum.services.qascooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {
    private final By orderHeader = By.xpath(".//div[contains(@class, 'Order_Header')]");
    private final By firstName = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    private final By secondName = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");
    private final By address = By.xpath(".//input[contains(@placeholder, 'куда')]");
    private final By metroStation = By.xpath(".//div[contains(@class, 'select-search__value')]");
    private final By telephoneNumber = By.xpath(".//input[contains(@placeholder, 'Телефон')]");
    private final By nextButton = By.xpath(".//button[contains(@class, 'Button_Middle')]");
    private final By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriod = By.xpath(".//div[contains(@class, 'Dropdown-control')]");
    private final By comment = By.xpath(".//input[contains(@placeholder, 'Комментарий для курьера')]");
    private final By orderButton = By.xpath(".//div[contains(@class, 'Order_Buttons')]/button[contains(@class, 'Button_Button') and not(contains(@class, 'Inverted'))]");
    private final By acceptButton = By.xpath(".//button[text() = 'Да']");
    private final By successMessage = By.xpath(".//div[contains(@class, 'Order_ModalHeader') and text() = 'Заказ оформлен']");
    private final By successText = By.xpath(".//div[contains(@class, 'Order_Text')]");
    private final By validationError = By.xpath(".//div[contains(@class, 'Input_Visible') or contains(@class, 'Order_MetroError')]");

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void inputFirstName(String value) {
        driver.findElement(firstName).sendKeys(value);
    }

    public void inputSecondName(String value) {
        driver.findElement(secondName).sendKeys(value);
    }

    public void inputAddress(String value) {
        driver.findElement(address).sendKeys(value);
    }

    public void inputMetroStation(String value) {
        driver.findElement(metroStation).click();
        driver.findElement(By.xpath(".//li/button/div[contains(@class, 'Order_Text') and text()='" + value + "']")).click();
    }

    public void inputTelephoneNumber(String value) {
        driver.findElement(telephoneNumber).sendKeys(value);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void inputDate(String value) {
        driver.findElement(date).sendKeys(value);
        driver.findElement(date).sendKeys(Keys.ENTER);
    }

    public void inputRentalPeriod(String value) {
        driver.findElement(rentalPeriod).click();
        driver.findElement(By.xpath(".//div[text()='" + value + "' and @class='Dropdown-option']")).click();
    }

    public void inputScooterColour(String value) {
        driver.findElement(By.xpath(".//label[contains(@class, 'Checkbox_Label') and text() = '" + value + "']")).click();
    }

    public void inputComment(String value) {
        driver.findElement(comment).sendKeys(value);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickAcceptButton() {
        driver.findElement(acceptButton).click();
    }

    public void isDisplayedSuccessMessage() {
        driver.findElement(successMessage).isDisplayed();
        driver.findElement(successText).isDisplayed();
    }

    public String getSuccessText() {
        return driver.findElement(successText).getText();
    }

    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru/order");
    }

    public void clickOrderHeader() {
        driver.findElement(orderHeader).click();
    }

    public String getValidationErrorText() {
        return driver.findElement(validationError).getText();
    }
}
