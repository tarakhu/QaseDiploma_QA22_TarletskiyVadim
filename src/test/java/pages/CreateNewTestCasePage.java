package pages;

import elements.Dropdown;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateNewTestCasePage extends HomePage {

    private final static By TEST_CASE_TITLE_LOCATOR = By.id("title");
    private final static By DESCRIPTION_LOCATOR = By.xpath("//label[text()='Description']/parent::div//div/p");
    private final static By SAVE_BUTTON_LOCATOR = By.id("save-case");

    public CreateNewTestCasePage(WebDriver driver) {
        super(driver);
    }

    public void setValueForDescription(String value) {
        driver.findElement(DESCRIPTION_LOCATOR).sendKeys(value);
    }

    public void setValueForTitle(String value) {
        driver.findElement(TEST_CASE_TITLE_LOCATOR).sendKeys(value);
    }

    public void clickToSaveCaseButton() {
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }

    public void waitForSaveButtonIsDisplayed() {
        waitForElementDisplayed(SAVE_BUTTON_LOCATOR);
    }

    public void fillForm(TestCase testCase) {
        new CreateNewTestCasePage(driver).setValueForTitle(testCase.getTitle());
        new CreateNewTestCasePage(driver).setValueForDescription(testCase.getDescription());
        new Dropdown(driver, "Status").setValue(testCase.getStatus().getName());
        new Dropdown(driver, "Automation status").setValue(testCase.getAutomationStatus().getName());
        new Dropdown(driver, "Behavior").setValue(testCase.getBehavior().getName());
        new Dropdown(driver, "Is flaky").setValue(testCase.getIsFlaky().getName());
        new Dropdown(driver, "Layer").setValue(testCase.getLayer().getName());
        new Dropdown(driver, "Priority").setValue(testCase.getPriority().getName());
        new Dropdown(driver, "Severity").setValue(testCase.getSeverity().getName());
        new Dropdown(driver, "Type").setValue(testCase.getType().getName());
    }
}
