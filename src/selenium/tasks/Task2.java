package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

public class Task2 {
    WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://uljanovs.github.io/site/tasks/provide_feedback");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void initialFeedbackPage() throws Exception {
//         TODO:
//         check that all field are empty and no tick are clicked
//         "Don't know" is selected in "Genre"
//         "Choose your option" in "How do you like us?"
//         check that the button send is blue with white letters
        assertEquals(driver.findElement(By.cssSelector("#fb_name")).getText(), "");
        assertEquals(driver.findElement(By.cssSelector("#fb_age")).getText(), "");
        assertTrue(driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(4) > input:nth-child(6)")).isSelected());
        Select select = new Select(driver.findElement(By.cssSelector("#like_us")));
        select.selectByIndex(0);
        WebElement h1 = driver.findElement(By.cssSelector("#fb_form > form > button"));
        assertEquals("Choose your option", select.getFirstSelectedOption().getText());
        assertEquals("rgba(33, 150, 243, 1)", h1.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", h1.getCssValue("color"));
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)
        driver.findElement(By.cssSelector("#fb_form > form > button")).click();
        assertEquals("", driver.findElement(By.id("name")).getText());
        assertEquals("", driver.findElement(By.id("age")).getText());
        assertEquals("", driver.findElement(By.id("language")).getText());
        assertEquals("null", driver.findElement(By.id("gender")).getText());
        assertEquals("null", driver.findElement(By.id("option")).getText());
        assertEquals("", driver.findElement(By.id("comment")).getText());
        WebElement h1 = driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge"));
        assertEquals("rgba(76, 175, 80, 1)", h1.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", h1.getCssValue("color"));
        WebElement h2 = driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-red.w3-xlarge"));
        assertEquals("rgba(244, 67, 54, 1)", h2.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", h2.getCssValue("color"));
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)
        WebElement textName = driver.findElement(By.id("fb_name"));
        String sendName = "Name";
        textName.sendKeys(sendName);
        WebElement textAge = driver.findElement(By.id("fb_age"));
        String sendAge = "22";
        textAge.sendKeys(sendAge);
        WebElement option1 = driver.findElement(By.cssSelector("#lang_check > input:nth-child(2)"));
        option1.click();
        WebElement option2 = driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(4) > input:nth-child(2)"));
        option2.click();
        Select select = new Select(driver.findElement(By.cssSelector("#like_us")));
        select.selectByIndex(3);
        WebElement textCom = driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(6) > textarea"));
        String comText = "Random Comment";
        textCom.sendKeys(comText);
        driver.findElement(By.cssSelector("#fb_form > form > button")).click();
        assertEquals(sendName, driver.findElement(By.id("name")).getText());
        assertEquals(sendAge, driver.findElement(By.id("age")).getText());
        assertEquals("English", driver.findElement(By.id("language")).getText());
        assertEquals("male", driver.findElement(By.id("gender")).getText());
        assertEquals("Bad", driver.findElement(By.id("option")).getText());
        assertEquals(comText, driver.findElement(By.id("comment")).getText());
        WebElement h1 = driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge"));
        assertEquals("rgba(76, 175, 80, 1)", h1.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", h1.getCssValue("color"));
        WebElement h2 = driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-red.w3-xlarge"));
        assertEquals("rgba(244, 67, 54, 1)", h2.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", h2.getCssValue("color"));

    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
//         click "Send"
//         click "Yes"
//         check message text: "Thank you, NAME, for your feedback!"
//         color of text is white with green on the background
        WebElement textName = driver.findElement(By.id("fb_name"));
        String sendName = "Name";
        textName.sendKeys(sendName);
        driver.findElement(By.cssSelector("#fb_form > form > button")).click();
        driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge")).click();
        assertEquals("Thank you, " + sendName + ", for your feedback!", driver.findElement(By.id("message")).getText());
        WebElement h1 = driver.findElement(By.cssSelector("#fb_thx > div"));
        assertEquals("rgba(76, 175, 80, 1)", h1.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", h1.getCssValue("color"));
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
//         click "Yes"
//         check message text: "Thank you for your feedback!"
//         color of text is white with green on the background
        driver.findElement(By.cssSelector("#fb_form > form > button")).click();
        driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge")).click();
        assertEquals("Thank you for your feedback!", driver.findElement(By.id("message")).getText());
        WebElement h1 = driver.findElement(By.cssSelector("#fb_thx > div"));
        assertEquals("rgba(76, 175, 80, 1)", h1.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", h1.getCssValue("color"));
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
//         click "Send"
//         click "No"
//         check fields are filled correctly
        WebElement textName = driver.findElement(By.id("fb_name"));
        String sendName = "Name";
        textName.sendKeys(sendName);
        WebElement textAge = driver.findElement(By.id("fb_age"));
        String sendAge = "22";
        textAge.sendKeys(sendAge);
        WebElement option1 = driver.findElement(By.cssSelector("#lang_check > input:nth-child(2)"));
        option1.click();
        WebElement option2 = driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(4) > input:nth-child(2)"));
        option2.click();
        Select select = new Select(driver.findElement(By.cssSelector("#like_us")));
        select.selectByIndex(3);
        WebElement textCom = driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(6) > textarea"));
        String comText = "Random Comment";
        textCom.sendKeys(comText);
        driver.findElement(By.cssSelector("#fb_form > form > button")).click();
        driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-red.w3-xlarge")).click();
        assertEquals(sendName, driver.findElement(By.id("fb_name")).getAttribute("value"));
        assertEquals(sendAge, driver.findElement(By.id("fb_age")).getAttribute("value"));
        assertTrue(driver.findElement(By.cssSelector("#lang_check > input:nth-child(2)")).isSelected());
        assertTrue(driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(4) > input:nth-child(2)")).isSelected());
        assertEquals("Bad", driver.findElement(By.id("like_us")).getAttribute("value"));
        assertEquals(comText, driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(6) > textarea")).getAttribute("value"));

    }
}
