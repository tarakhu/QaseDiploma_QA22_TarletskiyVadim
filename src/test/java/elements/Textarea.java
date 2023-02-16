package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Textarea extends BaseElement {

    private final static String TEXTAREA_LOCATOR = "//textarea[@id='%s']";

    public Textarea(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        WebElement textArea = driver.findElement(By.xpath(String.format(TEXTAREA_LOCATOR, this.label)));
        scrollIntoView(textArea);
        textArea.sendKeys(value);
    }

}
