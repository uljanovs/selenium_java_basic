package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task2 {
    WebDriver driver;
    private String value;

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
        assertEquals("", driver.findElement(By.id("comment")).getText());
        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            assertFalse(checkbox.isSelected());
            List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));
            for (WebElement radioButton : radioButtons) {
                assertFalse(radioButton.isSelected());
            }
//         "Don't know" is selected in "Genre"
                assertTrue("", driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[3]")).isSelected());

//         "Choose your option" in "How do you like us?"
                Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"like_us\"]")));
                dropdown.selectByIndex(0);
//         check that the button send is blue with white letters
            }
            assertEquals("rgb(33, 150, 243)",
                    driver.findElement(By.cssSelector(".w3-blue")).getCssValue("background-color"));
            assertEquals("rgb(255, 255, 255)",
                    driver.findElement(By.cssSelector(".w3-btn")).getCssValue("color"));
        }
    @Test
        public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
              WebElement send = driver.findElement(By.cssSelector(".w3-btn-block"));
              send.click();

////         check fields are empty or null
     assertEquals("", driver.findElement(By.cssSelector("#name")).getText());
               assertEquals("", driver.findElement(By.cssSelector("#age")).getText());
               assertEquals("", driver.findElement(By.cssSelector("#language")).getText());
               assertEquals("", driver.findElement(By.cssSelector("#gender")).getText());
               assertEquals("", driver.findElement(By.cssSelector("#option")).getText());
              assertEquals("", driver.findElement(By.cssSelector("#comment")).getText());

////         check button colors
////         (green with white letter and red with white letters)
     assertEquals("rgba(76, 175, 80, 1);",
     driver.findElement(By.cssSelector(".w3-green")).getCssValue("background-color"));
    assertEquals("rgba(255, 255, 255, 1)",
     driver.findElement(By.cssSelector(".w3-btn")).getCssValue("color"));
    assertEquals("rgba(244, 67, 54, 1)",
     driver.findElement(By.cssSelector(".w3-red")).getCssValue("background-color"));
    assertEquals("rgba(255, 255, 255, 1)",
     driver.findElement(By.cssSelector(".w3-btn")).getCssValue("color"));
     }

        @Test
        public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
                driver.findElement(By.xpath("//button[@type='submit']")).click();

//         check fields are filled correctly
                driver.findElement(By.id("fb_name")).sendKeys("ilona");
                driver.findElement(By.id("fb_age")).sendKeys("17");
                driver.findElement(By.xpath("//*[@id='lang_check']/input[1]")).click();
                driver.findElement(By.xpath("//input[@value='female']")).click();
                driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys(":)");
                driver.findElement(By.xpath("//button[@type='submit']")).click();

//         check button colors
//         (green with white letter and red with white letters)

            assertEquals("rgba(76, 175, 80, 1);",
                    driver.findElement(By.cssSelector(".w3-green")).getCssValue("background-color"));
            assertEquals("rgba(255, 255, 255, 1)",
                    driver.findElement(By.cssSelector(".w3-btn")).getCssValue("color"));
            assertEquals("rgba(244, 67, 54, 1)",
                    driver.findElement(By.cssSelector(".w3-red")).getCssValue("background-color"));
            assertEquals("rgba(255, 255, 255, 1)",
                    driver.findElement(By.cssSelector(".w3-btn")).getCssValue("color"));
        }

        @Test
        public void yesOnWithNameFeedbackPage() throws Exception {

//         TODO:
//         enter only name
                driver.findElement(By.id("fb_name")).sendKeys("ilona");

//         click "Send"
                driver.findElement(By.xpath("//button[@type='submit']")).click();

//         click "Yes"
                driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[1]")).click();

//         check message text: "Thank you, NAME, for your feedback!"
                String message = driver.findElement(By.cssSelector("#message")).getText();
                assertEquals("Thank you, ilona, for your feedback!", message);

//         color of text is white with green on the background

            assertEquals("rgba(76, 175, 80, 1);",
                    driver.findElement(By.cssSelector(".w3-green")).getCssValue("background-color"));
            assertEquals("rgba(255, 255, 255, 1)",
                    driver.findElement(By.cssSelector(".w3-btn")).getCssValue("color"));
        }

        @Test
        public void yesOnWithoutNameFeedbackPage () throws Exception {
//          TODO:
////         click "Send" (without entering anything
    driver.findElement(By.xpath("//button[@type='submit']")).click();

////         click "Yes"
     driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[1]")).click();

////         check message text: "Thank you for your feedback!"
    String message = driver.findElement(By.cssSelector("#message")).getText();
    assertEquals("Thank you, ilona, for your feedback!", message);

////         color of text is white with green on the background

    assertEquals("rgba(76, 175, 80, 1);",
    driver.findElement(By.cssSelector(".w3-green")).getCssValue("background-color"));
    assertEquals("rgba(255, 255, 255, 1)",
    driver.findElement(By.cssSelector(".w3-btn")).getCssValue("color"));
    }

        @Test
        public void noOnFeedbackPage () throws Exception {
//         TODO:
//         fill the whole form
            driver.findElement(By.id("fb_name")).sendKeys("ilona");
            driver.findElement(By.id("fb_age")).sendKeys("17");
            driver.findElement(By.xpath("//*[@id='lang_check']/input[1]")).click();
            driver.findElement(By.xpath("//input[@value='female']")).click();
            driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys(":)");

//         click "Send"
            driver.findElement(By.xpath("//button[@type='submit']")).click();

//         click "No"
            driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[2]")).click();

//         check fields are filled correctly


    assertEquals("", driver.findElement(By.id("fb_name")).getText());
        assertEquals("", driver.findElement(By.id("fb_age")).getText());
        assertEquals("", driver.findElement(By.id("comment")).getText());
            List<WebElement> checkboxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
            List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));
        }
        }
