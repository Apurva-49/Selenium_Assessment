package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
public class DemoPage {

    WebDriver driver;
    public DemoPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators

    By textInput = By.id("myTextInput");
    By svgRect = By.id("svgRect");
    By iframe = By.id("myFrame3");
    By dropdown = By.id("mySelect");
    By htmlMeter = By.id("meterBar");


    public void enterTextInputField(String text) {
        driver.findElement(textInput).clear();
        driver.findElement(textInput).sendKeys(text);
    }

    public String getTextInputFieldValue() {
        return driver.findElement(textInput).getAttribute("value");
    }

    public String getSvgRectColor() {
        return driver.findElement(svgRect).getAttribute("fill");
    }

    public void toggleIframeCheckbox() {
        driver.switchTo().frame(driver.findElement(iframe));
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        if (checkbox.isSelected()) {
            System.out.println("Checkbox is already selected");
        }
        else
            {
            checkbox.click();
        }
        driver.switchTo().defaultContent();
    }

    public boolean isIframeCheckboxSelected() {
        driver.switchTo().frame(driver.findElement(iframe));
        boolean isIframeCheckboxSelected = driver.findElement(By.cssSelector("input[type='checkbox']")).isSelected();
        driver.switchTo().defaultContent();
        return isIframeCheckboxSelected;
    }

    public void selectDropdownOption(String visibleText) {
        Select dropdownElement = new Select(driver.findElement(dropdown));
        dropdownElement.selectByVisibleText(visibleText);
    }

    public String getMeterValue() {
        return driver.findElement(htmlMeter).getAttribute("value");
    }

    public void closeBrowser() {
        driver.quit();
    }
}

