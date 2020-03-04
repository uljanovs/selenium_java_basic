package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;


public class AgeSamplePage extends GenericSamplePage {
    @FindBy(how = How.ID, using = "fb_form") // By.id("fb_form")
    private WebElement formInput; // WebElement formInput = driver.findElement(By.id("fb_form"));
    @FindBy(how = How.ID, using = "fb_name") // By.id("fb_name")
    private WebElement nameInput; // WebElement nameInput = driver.findElement(By.id("fb_name"));
    @FindBy(how = How.NAME, using = "fb_age") // By.name("fb_age")
    private WebElement ageInput;
    @FindBy(how = How.NAME, using = "w3-check") // By.name("w3-check")
    private WebElement languageInput;
    @FindBy(how = How.NAME, using = "w3-radio") // By.name("w3-radio")
    private WebElement genderInput;
    @FindBy(how = How.NAME, using = "w3-select") // By.name("w3-select")
    private WebElement choiceInput;
    @FindBy(how = How.NAME, using = "w3-input w3-border") // By.name("w3-input w3-border")
    private WebElement commentInput;
    @FindBy(how = How.ID, using = "send")
    private WebElement sendButton;
    @FindBy(how = How.CLASS_NAME, using = "error") // By.className("error)
    private WebElement errorText;

    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);

public class Test2_sos {

    checkPageHeaderText("Give us your feedback!");
    assertEquals(nameInput.getAttribute("value"), "Enter name here");
    assertEquals(ageInput.getAttribute("value"), "");
    assertFalse(errorText.isDisplayed());
}
