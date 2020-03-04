package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//import selenium.pages.FeedbackField;
import javax.swing.*;

import static org.junit.Assert.*;


public class Task2  {
    WebDriver driver;
   // static FeedbackField feedBack;

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
//    check that all field are empty and no tick are clicked
////         "Don't know" is selected in "Genre"
////         "Choose your option" in "How do you like us?"
////         check that the button send is blue with white letters


        assertEquals("",driver.findElement(By.id("fb_name")).getAttribute("value"));
        assertEquals("",driver.findElement(By.id("fb_age")).getAttribute("value"));
        assertTrue(driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/label[3]")).isSelected());
        assertEquals("",driver.findElement(By.name("like_us")).isSelected());
        assertEquals("",driver.findElement(By.name("comment")).isDisplayed());
        //color
        assertEquals(driver.findElement(By.className("w3-btn-block ")).isDisplayed();


        /* (driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[1]")).isDisplayed();
        assertEquals(driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[2]")).isDisplayed();
        assertEquals(driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[3]")).isDisplayed();
        assertEquals(driver.findElement(By.xpath( "//*[@id=\"lang_check\"]/input[4]")).isDisplayed();
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
     //color
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
 driver.findElement((By.xpath("//*[@id=\"lang_check\"]/input[2]")).isSelected());



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
