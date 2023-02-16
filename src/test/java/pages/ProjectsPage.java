package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectsPage extends BasePage {

    private final static By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");
    private final static By SEARCH_INPUT_FIELD = By.xpath("//div/input[@name='title']");
    private final static String ANY_PROJECT_LOCATOR = "//div/a[@class='defect-title' and text()='%s']";


    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForCreateNewProjectsButtonIsDisplayed() {
        waitForElementDisplayed(CREATE_NEW_PROJECT_BUTTON);
    }

    public boolean isCreateNewProjectButtonDisplayed() {
        return driver.findElement(CREATE_NEW_PROJECT_BUTTON).isDisplayed();
    }

    public void clickCreateNewProjectButton() {
        driver.findElement(CREATE_NEW_PROJECT_BUTTON).click();
    }

    public void clickToProject(String value) {
        driver.findElement(By.xpath(String.format(ANY_PROJECT_LOCATOR, value))).click();
    }

}
