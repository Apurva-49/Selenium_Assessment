package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pages.DemoPage;
import base.DriverFactory;

public class DemoPageSteps
{
    WebDriver driver;
    DemoPage demoPage;
    String svgColor;

    @Given("user navigates to the demo page")
    public void userNavigatesToDemoPage() {

        driver = DriverFactory.getDriver();
        driver.get("https://seleniumbase.io/demo_page");
        driver.manage().window().maximize();
        demoPage = new DemoPage(driver);
    }

    @When("user fills in the text input field with {string}")
    public void userFillsInTheTextInputField(String text) {
        demoPage.enterTextInputField(text);
        
    }

    @Then("user verifies the text input field contains {string}")
    public void theUserVerifiesTextInputShouldContainValue(String expectedText) {
        Assert.assertEquals(expectedText,demoPage.getTextInputFieldValue());

    }

    @When("user retrieves the color from the SVG rectangle")
    public void userGetTheColorFromTheSVGRectangle() {
        svgColor = demoPage.getSvgRectColor();
    }

    @Then("user prints the color value")
    public void userPrintTheColorValue() {
        System.out.println("SVG Color: " + svgColor);

    }

    @When("user toggles the checkbox in the iframe")
    public void userTogglesTheCheckboxInTheIframe() {
        demoPage.toggleIframeCheckbox();
    }

    @Then("user verifies the checkbox is checked")
    public void userVerifiesItShouldBeChecked() {
        Assert.assertTrue(demoPage.isIframeCheckboxSelected());

    }

    @When("user sets the dropdown to {string}")
    public void userSetTheDropdown(String arg0) {
        demoPage.selectDropdownOption(arg0);
    }

    @Then("user verifies the HTML meter changes to {string}")
    public void theHTMLMeterShouldChangeTo(String expectedValue) {
        Assert.assertEquals(expectedValue, demoPage.getMeterValue());

    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}
