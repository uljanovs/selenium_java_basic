package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        assertEquals("", driver.findElement(By.id("fb_name")).getText());
        assertEquals("", driver.findElement(By.id("fb_age")).getText());
        assertFalse(driver.findElement(By.cssSelector("#lang_check > input:nth-child(2)")).isSelected());
        assertFalse(driver.findElement(By.cssSelector("#lang_check > input:nth-child(4)")).isSelected());
        assertFalse(driver.findElement(By.cssSelector("#lang_check > input:nth-child(6)")).isSelected());
        assertFalse(driver.findElement(By.cssSelector("#lang_check > input:nth-child(8)")).isSelected());
        assertFalse(driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(4) > input:nth-child(2)")).isSelected());
        assertFalse(driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(4) > input:nth-child(4)")).isSelected());

        //         "Don't know" is selected in "Genre"
        assertTrue(driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(4) > input:nth-child(6)")).isSelected());
//         "Choose your option" in "How do you like us?"
        assertTrue("Choose your option", driver.findElement(By.cssSelector("#like_us > option:nth-child(1)")).isSelected());
//         check that the button send is blue with white letters
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data

        WebElement start = driver.findElement(By.cssSelector("#fb_form > form > button"));
        start.click();
//         check fields are empty or null
           assertEquals("", driver.findElement(By.cssSelector("#name")).getText());
        assertEquals("", driver.findElement(By.cssSelector("#age")).getText());
        assertEquals("", driver.findElement(By.cssSelector("#language")).getText());
        assertEquals("null", driver.findElement(By.cssSelector("#gender")).getText());
        assertEquals("null", driver.findElement(By.cssSelector("#option")).getText());
        assertEquals("", driver.findElement(By.cssSelector("#comment")).getText());

//         check button colors
//         (green with white letter and red with white letters)
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
        driver.findElement(By.cssSelector("#name")).sendKeys("Ingars");
        driver.findElement(By.cssSelector("#age")).sendKeys("35");
        driver.findElement(By.cssSelector("#lang_check > input:nth-child(2)")).click();
       Select likeUs = new Select (driver.findElement(By.cssSelector("#like_us")));
        likeUs.selectByIndex(1);

//         check fields are filled correctly

//         check button colors
//         (green with white letter and red with white letters)
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
