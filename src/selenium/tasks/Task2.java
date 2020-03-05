package selenium.tasks;

import org.junit.After;
import org.junit.Assert;
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
//         check that all field are empty and no tick are clicked
        assertEquals("", driver.findElement(By.id("fb_name")).getText());
        assertEquals("", driver.findElement(By.id("fb_age")).getText());
//         "Don't know" is selected in "Genre"
        assertTrue(driver.findElement(By.xpath("//*[@id='fb_form']/form/div[4]/input[3]")).isSelected());
//         "Choose your option" in "How do you like us?"
        assertEquals("Choose your option",
                driver.findElement(By.xpath("//*[@id='like_us']/option[1]")).getText());
//         check that the button send is blue with white letters
        assertEquals("rgba(33, 150, 243, 1)",
                driver.findElement(By.xpath("//*[@id='fb_form']/form/button")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)",
                driver.findElement(By.xpath("//*[@id='fb_form']/form/button")).getCssValue("color"));
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
        driver.findElement(By.xpath("//button[@type='submit']")).click();
//         check fields are empty or null
        assertEquals("", driver.findElement(By.id("name")).getText());
        assertEquals("", driver.findElement(By.id("age")).getText());
        assertEquals("", driver.findElement(By.id("language")).getText());
        assertEquals("null", driver.findElement(By.id("gender")).getText());
        assertEquals("null", driver.findElement(By.id("option")).getText());
        assertEquals("", driver.findElement(By.id("comment")).getText());
//        check button colors
//        (green with white letter and red with white letters
//      //red
        assertEquals("rgba(244, 67, 54, 1)",
                driver.findElement(By.className("w3-red")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)",
                driver.findElement(By.className("w3-red")).getCssValue("color"));
        //green
        assertEquals("rgba(76, 175, 80, 1)",
                driver.findElement(By.className(" w3-green")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)",
                driver.findElement(By.className("w3-green")).getCssValue("color"));

    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
        driver.findElement(By.id("fb_name")).sendKeys("Test");
        driver.findElement(By.id("fb_age")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id='lang_check']/input[1]")).click();
        driver.findElement(By.xpath("//input[@value='male']")).click();
        WebElement testDropDown = driver.findElement(By.id("like_us"));
        Select dropdown = new Select(testDropDown);
        dropdown.selectByIndex(2);
        driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Comment");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

//         check fields are filled correctly
        assertEquals("Test",  driver.findElement(By.id("name")).getText());
        assertEquals("123", driver.findElement(By.id("age")).getText());
        assertEquals("English", driver.findElement(By.id("language")).getText());
        assertEquals("male", driver.findElement(By.id("gender")).getText());
        assertEquals("Ok, i guess", driver.findElement(By.id("option")).getText());
        assertEquals("Comment", driver.findElement(By.id("comment")).getText());

//         check button colors
//         (green with white letter and red with white letters)
        //red
        assertEquals("rgba(244, 67, 54, 1)",
                driver.findElement(By.className("w3-red")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)",
                driver.findElement(By.className("w3-red")).getCssValue("color"));
        //green
        assertEquals("rgba(76, 175, 80, 1)",
                driver.findElement(By.className(" w3-green")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)",
                driver.findElement(By.className("w3-green")).getCssValue("color"));


    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
        driver.findElement(By.id("fb_name")).sendKeys("Test");
//         click "Send"
        driver.findElement(By.xpath("//button[@type='submit']")).click();
//         click "Yes"
        driver.findElement(By.className("w3-green")).click();
//         check message text: "Thank you, NAME, for your feedback!"
        assertEquals("Thank you, Test, for your feedback!",
                driver.findElement(By.id("message")).getText());
//         color of text is white with green on the background
        assertEquals("rgba(76, 175, 80, 1)",
                driver.findElement(By.className("w3-panel")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)",
                driver.findElement(By.id("message")).getCssValue("color"));
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
        driver.findElement(By.xpath("//button[@type='submit']")).click();
//         click "Yes"
        driver.findElement(By.className("w3-green")).click();
//         check message text: "Thank you for your feedback!"
        assertEquals("Thank you for your feedback!",
                driver.findElement(By.id("message")).getText());
//         color of text is white with green on the background
        assertEquals("rgba(76, 175, 80, 1)",
                driver.findElement(By.className("w3-panel")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)",
                driver.findElement(By.id("message")).getCssValue("color"));
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
        driver.findElement(By.id("fb_name")).sendKeys("Test");
        driver.findElement(By.id("fb_age")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id='lang_check']/input[1]")).click();
        driver.findElement(By.xpath("//input[@value='male']")).click();
        WebElement testDropDown = driver.findElement(By.id("like_us"));
        Select dropdown = new Select(testDropDown);
        dropdown.selectByIndex(2);
        driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Comment");
//         click "Send"
        driver.findElement(By.xpath("//button[@type='submit']")).click();
//         click "No"
        driver.findElement(By.className("w3-red")).click();
//         check fields are filled correctly
        assertEquals("Test", driver.findElement(By.id("fb_name")).getAttribute("value"));
        assertEquals("123", driver.findElement(By.id("fb_age")).getAttribute("value"));
        assertTrue(driver.findElement(By.xpath("//*[@id='lang_check']/input[1]")).isSelected());
        assertTrue(driver.findElement(By.xpath("//input[@value='male']")).isSelected());
        assertEquals("Ok, i guess", driver.findElement(By.id("like_us")).getAttribute("value"));
        assertEquals("Comment",
                driver.findElement(By.xpath("//textarea[@name='comment']")).getAttribute("value"));


    }
}