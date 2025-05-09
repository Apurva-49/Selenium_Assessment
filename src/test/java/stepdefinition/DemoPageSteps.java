package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import pages.DemoPage;



public class DemoPageSteps {

    WebDriver driver;
    DemoPage demoPage;
    String svgColor;




    @Given("user navigates to demo page")
    public void userNavigatesToDemoPage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://seleniumbase.io/demo_page");
        driver.manage().window().maximize();
        demoPage = new DemoPage(driver);
    }

    @When("user fills in the Text input field with {string}")
    public void userFillsInTheTextInputField(String text) {
        demoPage.enterTextInputField(text);
        
    }


    @Then("the user verifies text input should contain {string}")
    public void theUserVerifiesTextInputShouldContainValue(String expectedText) throws InterruptedException {
        Assert.assertEquals(expectedText, demoPage.getTextInputFieldValue());



        driver.quit();
    }


    @When("user get the color from the SVG rectangle")
    public void userGetTheColorFromTheSVGRectangle() {
        svgColor = demoPage.getSvgRectColor();
    }

    @Then("user print the color value")
    public void userPrintTheColorValue() {
        System.out.println("SVG Color: " + svgColor);
        driver.quit();
    }

    @When("user toggles the checkbox in the iframe")
    public void userTogglesTheCheckboxInTheIframe() {
        demoPage.toggleIframeCheckbox();
    }

    @Then("user verifies it should be checked")
    public void userVerifiesItShouldBeChecked() {
        Assert.assertTrue(demoPage.isIframeCheckboxSelected());

        driver.quit();
    }

    @When("user set the dropdown to {string}")
    public void userSetTheDropdown(String arg0) {
        demoPage.selectDropdownOption(arg0);

    }

    @Then("the HTML meter should change to {string}")
    public void theHTMLMeterShouldChangeTo(String expectedValue) {
        Assert.assertEquals(expectedValue, demoPage.getMeterValue());

        driver.quit();

    }


}
