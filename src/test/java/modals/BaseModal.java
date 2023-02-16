package modals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BaseModal extends BasePage {

    private final static By CREATE_BUTTON = By.xpath("//button[@type='submit']");
    protected final Logger logger = LogManager.getLogger(this.getClass().getName());

    public BaseModal(WebDriver driver) {
        super(driver);
    }

    public void clickCreateButton() {

        driver.findElement(CREATE_BUTTON).click();
    }


}
