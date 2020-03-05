package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class Task2 {
    WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://uljanovs.github.io/sitetasks/provide_feedback");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void initialFeedbackPage() throws Exception {

//         TODO:
//      check that all field are empty and no tick are clicked
        List<WebElement> english = driver.findElements(By.xpath("//*[@id=\"lang_check\"]/input[1]"));
        for (WebElement checkboxEnglish : english) {
            assertFalse(checkboxEnglish.isSelected());
        }
        List<WebElement> french = driver.findElements(By.xpath("//*[@id=\"lang_check\"]/input[1]"));
        for (WebElement checkboxFrench : french) {
            assertFalse(checkboxFrench.isSelected());
        }
        List<WebElement> spanish = driver.findElements(By.xpath("//*[@id=\"lang_check\"]/input[1]"));
        for (WebElement checkboxSpanish : spanish) {
            assertFalse(checkboxSpanish.isSelected());
        }
        List<WebElement> chinese = driver.findElements(By.xpath("//*[@id=\"lang_check\"]/input[1]"));
        for (WebElement checkboxChinese : chinese) {
            assertFalse(checkboxChinese.isSelected());
        }

        WebElement inputName = driver.findElement(By.id("fb_name"));
        String textInsideName = inputName.getAttribute("value");
        assertTrue(textInsideName.isEmpty());

        WebElement inputAge = driver.findElement(By.id("fb_age"));
        String textInsideAge = inputAge.getAttribute("value");
        assertTrue(textInsideAge.isEmpty());

//      "Don't know" is selected in "Genre"
        List<WebElement> gender = driver.findElements(By.cssSelector("//*[@id=\"fb_form\"]/form/div[4]/input[3]"));
        for (WebElement noGender : gender) {
            assertTrue(noGender.isSelected());
        }

//      "Choose your option" in "How do you like us?"
        List<WebElement> likeUs = driver.findElements(By.cssSelector("//*[@id=\"like_us\"]/option[1]"));
        for (WebElement choose : likeUs) {
            assertTrue(choose.isSelected());
        }
    }

    public void styleChecks() throws Exception {
//         check that the button send is blue with white letters
        WebElement send = driver.findElement(By.cssSelector(".w3-blue"));
        assertEquals("rgba(33, 150, 243, 1)", send.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", send.getCssValue("color"));
    }


    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
        WebElement send = driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/button"));
        send.click();
//         click "Send" without entering any data
//         check fields are empty or null
        WebElement inputName = driver.findElement(By.id("name"));
        String textInsideName = inputName.getAttribute("value");
        assertTrue(textInsideName.isEmpty());

        WebElement inputAge = driver.findElement(By.id("age"));
        String textInsideAge = inputAge.getAttribute("value");
        assertTrue(textInsideAge.isEmpty());

        WebElement inputLanguage = driver.findElement(By.id("language"));
        String textInsideLanguage = inputLanguage.getAttribute("value");
        assertTrue(textInsideLanguage.isEmpty());

        WebElement inputGender = driver.findElement(By.id("gender"));
        assertEquals("null", inputGender.getAttribute("value"));

        WebElement inputOption = driver.findElement(By.id("gender"));
        assertEquals("null", inputOption.getAttribute("value"));

        WebElement inputComment = driver.findElement(By.id("comment"));
        assertEquals("null", inputComment.getAttribute("value"));

//         check button colors
//         (green with white letter and red with white letters)
        WebElement yes = driver.findElement(By.cssSelector(".w3-green"));
        assertEquals("rgba(76, 175, 80, 1)", yes.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", yes.getCssValue("color"));

        WebElement no = driver.findElement(By.cssSelector(".w3-red"));
        assertEquals("rgba(244, 67, 54, 1)", no.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", no.getCssValue("color"));
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
    }

    //         TODO:
//         fill the whole form, click "Send"
    @FindBy(how = How.ID, using = "fb_name")
    private WebElement inputName;

    public void EnterInfo(String[] args) {
        inputName.clear();
        inputName.sendKeys("Hanna");
    }

    @FindBy(how = How.ID, using = "fb_age")
    private WebElement inputAge;

    public void EnterAge() {
        inputAge.clear();
        inputAge.sendKeys("18");
    }

    public void clickEnglish() {
        WebElement english = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[1]"));
        english.click();
    }

    public void clickFemale() {
        WebElement female = driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[2]"));
        female.click();
    }

    public void clickGood() {
        WebElement good = driver.findElement(By.xpath("//*[@id=\"like_us\"]/option[2]"));
        good.click();
    }

    public void EnterComment(String[] args) {
        inputAge.clear();
        inputAge.sendKeys("Would recommend to a friend");
    }

    public void clickSend() {
        WebElement send = driver.findElement(By.cssSelector(".w3-blue"));
        send.click();
    }

    //         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters

    void yesNoButtons() {

    WebElement yes = driver.findElement(By.cssSelector(".w3-green"));
    assertEquals("rgba(76, 175, 80, 1)",yes.getCssValue("background-color"));
    assertEquals("rgba(255, 255, 255, 1)",yes.getCssValue("color"));

    WebElement no = driver.findElement(By.cssSelector(".w3-red"));
    assertEquals("rgba(244, 67, 54, 1)",no.getCssValue("background-color"));
    assertEquals("rgba(255, 255, 255, 1)",no.getCssValue("color"));
}
    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
//         click "Send"
//         click "Yes"
//         check message text: "Thank you, NAME, for your feedback!"
//         color of text is white with green on the background
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
//         click "Yes"
//         check message text: "Thank you for your feedback!"
//         color of text is white with green on the background
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
//         click "Send"
//         click "No"
//         check fields are filled correctly
    }
}
