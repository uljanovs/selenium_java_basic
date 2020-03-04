package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class Task2  {
    WebDriver driver;
   // static FeedbackField feedBack;

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
//    check that all field are empty and no tick are clicked
////         "Don't know" is selected in "Genre"
////         "Choose your option" in "How do you like us?"
////         check that the button send is blue with white letters


        assertEquals("",driver.findElement(By.id("fb_name")).getText());
        assertEquals("",driver.findElement(By.id("fb_age")).getText());
        assertFalse(driver.findElement(By.xpath("//*[@id='lang_check']/input[1]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id='lang_check']/input[2]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id='lang_check']/input[3]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id='lang_check']/inputt[4]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id='fb_form']/form/div[4]/input[1]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id='fb_form']/form/div[4]/input[2]")).isSelected());
        assertTrue(driver.findElement(By.xpath("//*[@id='fb_form']/form/div[4]/input[3]")).isSelected());;
        assertEquals("Choose your option",driver.findElement(By.name("like_us")).getText());
        assertEquals("",driver.findElement(By.xpath("//*[@id='fb_form']//textarea")).isDisplayed());
        assertEquals("Send",driver.findElement(By.className("w3-btn-block ")).isDisplayed());
        assertEquals("rgba(33, 150, 243, 1)", driver.findElement(By.cssSelector(".w3-btn-block ")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.cssSelector(".w3-btn-block")).getCssValue("color"));




        /* (driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[1]")).isDisplayed();

        assertEquals(driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[1]")).isDisplayed();
        assertEquals(driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[2]")).isDisplayed()
*/

    }


    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)

        driver.findElement(By.className("w3-btn-block ")).click();
        assertEquals("", driver.findElement(By.xpath("//*[@id='name']")).getText());;
        assertEquals("", driver.findElement(By.xpath("//*[@id='age']")).getText());;
        assertEquals("", driver.findElement(By.xpath("//*[@id='language']")).getText());
        assertEquals("null", driver.findElement(By.id("gender")).getText());
        assertEquals("null", driver.findElement(By.id("option")).getText());
        assertEquals("", driver.findElement(By.id("comment")).getText());
        assertEquals("rgba(76, 175, 80, 1)", driver.findElement(By.className(" w3-green")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.className("w3-green")).getCssValue("color"));
        assertEquals("rgba(244, 67, 54, 1)", driver.findElement(By.className("w3-red")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.className("w3-red")).getCssValue("color"));

    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)
 driver.findElement(By.id("fb_name")).sendKeys("Ivan");
 driver.findElement(By.id("fb_age")).sendKeys("25");
 driver.findElement((By.xpath("//*[@id='lang_check']/input[2]"))).isSelected();
 driver.findElement(By.xpath("*[@id='fb_form']/form/div[4]/input[1]")).isSelected();
         Select dropdown = new Select(driver.findElement(By.id("like_us")));
        dropdown.selectByIndex(1);
        driver.findElement(By.xpath("//*[@id='fb_form']//textarea")).sendKeys("Supercalifragilisticexpialidocious");
        driver.findElement(By.className("w3-btn-block ")).click();
        assertEquals("Ivan", driver.findElement(By.id("name")).getText());
        assertEquals("25", driver.findElement(By.id("age")).getText());
        assertEquals("French", driver.findElement(By.id("language")).getText());
        assertEquals("male", driver.findElement(By.id("gender")).getText());
        assertEquals("Good", driver.findElement(By.id("option")).getText());
        assertEquals("Supercalifragilisticexpialidocious", driver.findElement(By.id("comment")).getText());
        assertEquals("rgba(76, 175, 80, 1)", driver.findElement(By.className(" w3-green")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.className("w3-green")).getCssValue("color"));
        assertEquals("rgba(244, 67, 54, 1)", driver.findElement(By.className("w3-red")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.className("w3-red")).getCssValue("color"));


    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
//         click "Send"
//         click "Yes"
//         check message text: "Thank you, NAME, for your feedback!"
//         color of text is white with green on the background
        driver.findElement(By.id("fb_name")).sendKeys("Ivan");
        driver.findElement(By.className("w3-btn-block")).click();
        driver.findElement(By.className("w3-green")).click();
        assertEquals("Thank you, Ivan, for your feedback!", driver.findElement(By.id("message")).getText());
        assertEquals("rgba(76, 175, 80, 1)", driver.findElement(By.className("w3-panel")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.id("message")).getCssValue("color"));
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
//         click "Yes"
//         check message text: "Thank you for your feedback!"
//         color of text is white with green on the background
        driver.findElement(By.className("w3-btn-block ")).click();
        driver.findElement(By.className("w3-green")).click();
        assertEquals("Thank you for your feedback!", driver.findElement(By.id("message")).getText());
        assertEquals("rgba(76, 175, 80, 1)", driver.findElement(By.className("w3-panel")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.id("message")).getCssValue("color"));


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
