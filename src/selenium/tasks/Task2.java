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

import static org.junit.Assert.assertEquals;

public class Task2 {
    WebDriver driver;

    @FindBy(how = How.CLASS_NAME, using = "w3-btn-block")
    private WebElement sendButton;

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
        @FindBy(how = How.XPATH, using = "//*[@id=\"fb_form\"]/form/div[4]/input[3]")
        private WebElement genderDisabled;
//         "Choose your option" in "How do you like us?"

        @FindBy(how = How.XPATH, using = "//*[@id=\"like_us\"]/option[1]")
        private WebElement genderDisabled;
//         check that the button send is blue with white letters

        public void styleChecks() throws Exception {
            assertEquals("rgba(33, 150, 243, 1)",
                    driver.findElement(By.cssSelector(".w3-blue")).getCssValue("background-color"));
        }
        assertEquals("rgba(255, 255, 255, 1)",
                driver.findElement(By.cssSelector(".w3-blue")).getCssValue("color"));
        }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data

        public void clickSend() { sendButton.click(); }

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
