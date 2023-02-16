package pages;

import models.Project;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectDetailsPage extends BasePage {

    private final static By PROJECT_CODE_LOCATOR = By.xpath("//h1[@class='VqrSGU']");
    private final static By PROJECT_NAME_LOCATOR = By.xpath("//div[@class='sqabXr']");
    private final static By CREATE_SUITE_BUTTON_LOCATOR = By.id("create-suite-button");
    private final static By CREATE_CASE_BUTTON_LOCATOR = By.id("create-case-button");
    private final static String CREATED_CASE_LOCATOR_BY_NAME = "//div[@id='suitecases-container']//div[text()='%s']";
    private final static String CASE_DETAIL_LOCATOR = "./preceding-sibling::div/a";

    public ProjectDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getProjectCode() {
        String s = driver.findElement(PROJECT_CODE_LOCATOR).getText().toLowerCase();
        s = s.substring(0, s.indexOf(' '));
        return s;
    }

    public String getProjectName() {
        String s = driver.findElement(PROJECT_NAME_LOCATOR).getText();
        return s;
    }

    public Project getProjectDetails() {
        Project.ProjectBuilder project = new Project.ProjectBuilder(getProjectName(), getProjectCode());
        return project.build();
    }

    public void clickToCreateSuite() {
        driver.findElement(CREATE_SUITE_BUTTON_LOCATOR).click();
    }

    public void clickToCreateCase() {
        driver.findElement(CREATE_CASE_BUTTON_LOCATOR).click();
    }

    public void waitForCreateCaseButtonIsDisplayed() {
        waitForElementDisplayed(CREATE_CASE_BUTTON_LOCATOR);
    }

    public void clickToCreatedCase(TestCase testCase) {
        WebElement caseTitle = driver.findElement(By.xpath(String.format(CREATED_CASE_LOCATOR_BY_NAME, testCase.getTitle())));
        caseTitle.findElement(By.xpath(CASE_DETAIL_LOCATOR)).click();
    }
}
