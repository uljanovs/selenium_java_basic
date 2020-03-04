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
//         check that all fields are empty and no ticks are clicked

        assertEquals("", driver.findElement(By.id("fb_name")).getAttribute(value));
        assertEquals("", driver.findElement(By.id("fb_age")).getAttribute(value));
        List<WebElement> checkboxes = By.xpath("//Input//*[@id=\"lang_check\"]/input[1]").findElements(driver);
        for (WebElement checkbox : checkboxes)
            assertFalse(checkbox.isSelected());
        assertEquals("", driver.findElement(By.xpath("//Input//*[@id=\"fb_form\"]/form/div[4]/input[1]")).getAttribute(value));

//         "Don't know" is selected in "Genre"
        assertTrue("", driver.findElement(By.xpath("//Input//*[@id=\"fb_form\"]/form/div[4]/label[3]")).isSelected());

//         "Choose your option" in "How do you like us?"
        Select dropdown = new Select(driver.findElement(By.xpath("like_us")));
//         check that the button send is blue with white letters
        assertEquals("Choose your option", dropdown.getFirstSelectedOption().getText());
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
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
