package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
//         check that all field are empty and no tick are clicked DONE
//         "Don't know" is selected in "Genre" DONE
//         "Choose your option" in "How do you like us?" DONE
//         check that the button send is blue with white letters DONE
        assertEquals(driver.findElement(By.cssSelector("#fb_name")).getText(), "");

        assertEquals(driver.findElement(By.cssSelector("#fb_age")).getText(), "");
        assertTrue(driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(4) > input:nth-child(6)")).isSelected());
        Select select = new Select(driver.findElement(By.cssSelector("#like_us")));
        select.selectByIndex(0);
        assertEquals("Choose your option", select.getFirstSelectedOption().getText());
        WebElement button = driver.findElement(By.cssSelector("#fb_form > form > button"));
        assertEquals("rgba(33, 150, 243, 1)", button.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", button.getCssValue("color"));
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
        assertEquals(driver.findElement(By.cssSelector("#fb_name")).getText(), "");
        assertEquals(driver.findElement(By.cssSelector("#fb_age")).getText(), "");
        assertTrue(driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(4) > input:nth-child(6)")).isSelected());
        Select select = new Select(driver.findElement(By.cssSelector("#like_us")));
        select.selectByIndex(0);
        assertEquals("Choose your option", select.getFirstSelectedOption().getText());
        WebElement button = driver.findElement(By.cssSelector("#fb_form > form > button"));
        button.click();

        WebElement buttonYes = driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge"));
        assertEquals("rgba(76, 175, 80, 1)", buttonYes.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", buttonYes.getCssValue("color"));

        WebElement buttonNo = driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-red.w3-xlarge"));
        assertEquals("rgba(244, 67, 54, 1)", buttonNo.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", buttonNo.getCssValue("color"));

//         TODO:
//         click "Send" without entering any data DONE
//         check fields are empty or null DONE
//         check button colors
//         (green with white letter and red with white letters) DONE

    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {

        WebElement name = driver.findElement(By.cssSelector("#fb_name"));
        name.sendKeys("Kasya");
        WebElement age = driver.findElement(By.cssSelector("#fb_age"));
        age.sendKeys("35");
        WebElement button = driver.findElement(By.cssSelector("#fb_form > form > button"));
        button.click();

        assertEquals(driver.findElement(By.cssSelector("#name")).getText(), "Kasya");
        assertEquals(driver.findElement(By.cssSelector("#age")).getText(), "35");

        WebElement buttonYes = driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge"));
        assertEquals("rgba(76, 175, 80, 1)", buttonYes.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", buttonYes.getCssValue("color"));

        WebElement buttonNo = driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-red.w3-xlarge"));
        assertEquals("rgba(244, 67, 54, 1)", buttonNo.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", buttonNo.getCssValue("color"));


//         TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly DONE
//         check button colors
//         (green with white letter and red with white letters) DONE
    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
        WebElement name = driver.findElement(By.cssSelector("#fb_name"));
        name.sendKeys("Kasya");

        WebElement button = driver.findElement(By.cssSelector("#fb_form > form > button"));
        button.click();

        WebElement buttonYes = driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge"));
        buttonYes.click();

        WebElement message1 = driver.findElement(By.cssSelector("#message"));
        assertEquals("Thank you, Kasya, for your feedback!", message1.getText());// insert NAME insted of Kasya

        assertEquals("rgba(0, 0, 0, 0)", message1.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", message1.getCssValue("color"));

//         TODO:
//         enter only name DONE
//         click "Send" DONE
//         click "Yes" DONE
//         check message text: "Thank you, NAME, for your feedback!" DONE
//         color of text is white with green on the background DONE
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {

        WebElement name = driver.findElement(By.cssSelector("#fb_name"));
        name.sendKeys("");

        WebElement button = driver.findElement(By.cssSelector("#fb_form > form > button"));
        button.click();

        WebElement buttonYes = driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge"));
        buttonYes.click();

        WebElement message1 = driver.findElement(By.cssSelector("#message"));
        assertEquals("Thank you for your feedback!", message1.getText());// insert NAME insted of Kasya

        assertEquals("rgba(0, 0, 0, 0)", message1.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", message1.getCssValue("color"));

//         TODO:
//         click "Send" (without entering anything) DONE
//         click "Yes" DONE
//         check message text: "Thank you for your feedback!" DONE
//         color of text is white with green on the background DONE
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
        WebElement name = driver.findElement(By.cssSelector("#fb_name"));
        name.sendKeys("Kasya");

        WebElement age = driver.findElement(By.cssSelector("#fb_age"));
        age.sendKeys("35");

        WebElement language1 = driver.findElement(By.cssSelector("#lang_check > input:nth-child(2)"));
        language1.click();
        WebElement gender = driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(4) > input:nth-child(4)"));
        gender.click();
        Select select = new Select(driver.findElement(By.cssSelector("#like_us")));
        select.selectByIndex(2);

        WebElement button = driver.findElement(By.cssSelector("#fb_form > form > button"));
        button.click();

        WebElement buttonNo = driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-red.w3-xlarge"));
        buttonNo.click();
        assertEquals("Kasya", driver.findElement(By.id("fb_name")).getAttribute("value"));
       assertEquals("35", driver.findElement(By.cssSelector("#fb_age")).getAttribute("value"));
       assertTrue(driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(4) > input:nth-child(4)")).isSelected());
        assertEquals("Ok, i guess", driver.findElement(By.id("like_us")).getAttribute("value"));





//         TODO:
//         fill the whole form DONE
//         click "Send" DONE
//         click "No" DONE
//         check fields are filled correctly
    }
}
