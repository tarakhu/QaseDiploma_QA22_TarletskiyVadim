package modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewSuiteModal extends BaseModal {

    private final static By SUITE_NAME_LOCATOR = By.id("title");

    public NewSuiteModal(WebDriver driver) {
        super(driver);
    }


}
