package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dropdown extends BaseElement {

    private final static String DROPDOWN_LOCATOR = "//label[text()='%s']";
    private final static String DROPDOWN_BUTTON_LOCATOR = "./parent::div//button";
    private final static String OPTION_DROPDOWN_LOCATOR = "//div[@id='modals']//div[text()='%s']";

    private final static String DROPDOWN_DETAILS_NAME_LOCATOR = "//label[@for='0-%s']";
    private final static String DROPDOWN_DETAILS_OPTION_LOCATOR = "./following-sibling::div//div[text()]";

    public Dropdown(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        WebElement dropdown = driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, this.label)));
        scrollIntoView(dropdown);
        dropdown.findElement(By.xpath(DROPDOWN_BUTTON_LOCATOR)).click();
        dropdown.findElement(By.xpath(String.format(OPTION_DROPDOWN_LOCATOR, value))).click();
    }

    public String getValue() {
        WebElement data = driver.findElement(By.xpath(String.format(DROPDOWN_DETAILS_NAME_LOCATOR, this.label)));
        scrollIntoView(data);
//        return data.findElement(By.xpath(String.valueOf(DROPDOWN_DETAILS_OPTION_LOCATOR))).getText();
        return data.findElement(By.xpath(DROPDOWN_DETAILS_OPTION_LOCATOR)).getText();
    }
}
