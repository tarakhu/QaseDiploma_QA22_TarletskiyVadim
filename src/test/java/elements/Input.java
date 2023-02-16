package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Input extends BaseElement {

    private final static String INPUT_LOCATOR = "//input[@id='%s']";
    private final static String INPUT_RADIO_LOCATOR = "//span/input[@value='%s']";


    public Input(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValueForInput(String value) {
        WebElement input = driver.findElement(By.xpath(String.format(INPUT_LOCATOR, this.label)));
        scrollIntoView(input);
        input.sendKeys(value);
    }

    public void setValueForCodeInput(String value) {
        Actions actions = new Actions(driver);
        WebElement input = driver.findElement(By.xpath(String.format(INPUT_LOCATOR, this.label)));
        scrollIntoView(input);
        actions.doubleClick(input).perform();
        input.sendKeys(Keys.BACK_SPACE);
        input.sendKeys(value);
    }



    public void setValueForInputRadio(String value) {
        WebElement inputRadio = driver.findElement(By.xpath(String.format(INPUT_RADIO_LOCATOR, value)));
        scrollIntoView(inputRadio);
        inputRadio.click();
    }

}
