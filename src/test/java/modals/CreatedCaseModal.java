package modals;

import elements.Dropdown;
import enums.*;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreatedCaseModal extends BaseModal {

    private final static By CASE_DETAILS_TITLE_LOCATOR = By.xpath("//h1/div");
    private final static By CASE_DETAILS_DESCRIPTION_LOCATOR = By.xpath("//label[@for='0-description']/parent::section//div/p");


    public CreatedCaseModal(WebDriver driver) {
        super(driver);
    }

    public String getCaseTitle() {
        return driver.findElement(CASE_DETAILS_TITLE_LOCATOR).getText();
    }

    public String getCaseDescription() {
        return driver.findElement(CASE_DETAILS_DESCRIPTION_LOCATOR).getText();
    }

    public TestCase getTestCaseDetails() {
        TestCase.TestCaseBuilder testCase = new TestCase.TestCaseBuilder(getCaseTitle(),
                Status.fromString(new Dropdown(driver, "status").getValue()),
                Severity.fromString(new Dropdown(driver, "severity").getValue()),
                Priority.fromString(new Dropdown(driver, "priority").getValue()),
                Type.fromString(new Dropdown(driver, "type").getValue()),
                Layer.fromString(new Dropdown(driver, "layer").getValue()),
                IsFlaky.fromString(new Dropdown(driver, "is_flaky").getValue()),
                Behavior.fromString(new Dropdown(driver, "behavior").getValue()),
                AutomationStatus.fromString(new Dropdown(driver, "automation").getValue()))
                .setDescription(getCaseDescription());
            return testCase.build();
    }
}
