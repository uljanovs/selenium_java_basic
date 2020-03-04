package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FeedbackField {

    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameInput; // WebElement nameInput = driver.findElement(By.id("name"));
    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"lang_check\"]/input[1]")
    private WebElement english;
    @FindBy(how = How.XPATH, using = "//*[@id=\"lang_check\"]/input[2]")
    private WebElement french;
    @FindBy(how = How.XPATH, using = "//*[@id=\"lang_check\"]/input[3]")
    private WebElement spanish;
    @FindBy(how = How.XPATH, using = "//*[@id=\"lang_check\"]/input[4]")
    private WebElement chinese;
    @FindBy(how = How.XPATH, using = "//*[@id=\"fb_form\"]/form/div[4]/input[1]")
    private WebElement male;
    @FindBy(how = How.XPATH, using = "//*[@id=\"lang_check\"]/input[4]")
    private WebElement female;
    @FindBy(how = How.XPATH, using = "//*[@id=\"fb_form\"]/form/div[4]/label[3]")
    private WebElement disabled;
    @FindBy(how = How.NAME, using = " option")
    private WebElement likeUs;
    @FindBy(how = How.CLASS_NAME, using = "w3-btn-block ")
    private WebElement sendButton;



    public void enterName(String name) {

        nameInput.clear();
        nameInput.sendKeys(name);
}
    public void enterAge(int age) {
        enterAge(String.valueOf(age));
    }

    public void enterAge(String age) {
        ageInput.clear();
        ageInput.sendKeys(age);
    }
    public void clickSend() {
        sendButton.click();
    }

    public void checkHeaderText(String aHeaderText) {
        assertEquals(getPageHeader(), aHeaderText);
    }
}


    public void checkEmptyField() {
        checkHeaderText("Give us your feedback!");
        assertEquals(nameInput.getAttribute("value"), "Enter name here");
        assertEquals(ageInput.getAttribute("value"), "");
        assertFalse(errorText.isDisplayed());
    }