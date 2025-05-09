package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
public class DemoPage {

    WebDriver driver;
    public DemoPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators

    private WebElement getElementById(String id) {
        return driver.findElement(By.id(id));
    }
    WebElement textInput=null;
    WebElement svgRect =null;
    WebElement iframe = null;
    WebElement dropdown = null;
    WebElement htmlMeter = null;


    public void enterTextInputField(String text) {
        textInput = getElementById("myTextInput");

        textInput.clear();
       textInput.sendKeys(text);
    }

    public String getTextInputFieldValue() {
        textInput = getElementById("myTextInput");
        return textInput.getAttribute("value");
    }

    public String getSvgRectColor() {
        svgRect = getElementById("svgRect");
        return svgRect.getAttribute("fill");
    }

    public void toggleIframeCheckbox() {
        iframe=getElementById("myFrame3");
        driver.switchTo().frame((iframe));
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
        iframe=getElementById("myFrame3");
        driver.switchTo().frame((iframe));
        boolean isIframeCheckboxSelected = driver.findElement(By.cssSelector("input[type='checkbox']")).isSelected();
        driver.switchTo().defaultContent();
        return isIframeCheckboxSelected;
    }

    public void selectDropdownOption(String visibleText) {
       dropdown=getElementById("mySelect");
        Select dropdownElement = new Select(dropdown);
        dropdownElement.selectByVisibleText(visibleText);
    }

    public String getMeterValue() {
        htmlMeter=getElementById("meterBar");
        return htmlMeter.getAttribute("value");
    }


}

