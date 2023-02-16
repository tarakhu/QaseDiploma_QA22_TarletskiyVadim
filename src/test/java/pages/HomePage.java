package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final static By USER_ICON = By.cssSelector("//span[@class='Eb2vGG']/img");
    private final static By PROJECTS_MENU_TAB_LOCATOR = By.xpath("//div[@class='DDVAeb']/a[text()='Projects']");
    private final static By WORKSPACE_MENU_TAB_LOCATOR = By.xpath("//div[@class='DDVAeb']/a[text()='Workspace']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openProjectsTab() {
        driver.findElement(PROJECTS_MENU_TAB_LOCATOR).click();
    }

    public void openWorkspaceTab() {
       driver.findElement(WORKSPACE_MENU_TAB_LOCATOR).click();
    }

    public void openUserIconInfo() {
        driver.findElement(USER_ICON).click();
    }
}
