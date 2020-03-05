package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Sample8Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://uljanovs.github.io/site/examples/po");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void styleChecks() throws Exception {
        assertEquals("rgba(255, 221, 221, 1)",
                driver.findElement(By.cssSelector(".w3-pale-red")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 204, 1)",
                driver.findElement(By.cssSelector(".w3-pale-yellow")).getCssValue("background-color"));
        assertEquals("rgba(221, 255, 255, 1)",
                driver.findElement(By.cssSelector(".w3-pale-blue")).getCssValue("background-color"));
        assertEquals("64px",
                driver.findElement(By.cssSelector("h1")).getCssValue("font-size"));
        assertEquals("rgba(221, 255, 221, 1)",
                driver.findElement(By.cssSelector(".w3-pale-green")).getCssValue("background-color"));
        assertEquals("Verdana, sans-serif",
                driver.findElement(By.cssSelector(".w3-pale-green")).getCssValue("font-family"));
    }
}
