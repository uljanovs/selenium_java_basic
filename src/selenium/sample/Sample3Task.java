package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.*;

public class Sample3Task {
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
        driver.get("https://uljanovs.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void assertEqualsTask() throws Exception {

        assertEquals(5, driver.findElements(By.className("test")).size());
//         check that value of second button is "This is also a button"
        assertEquals("This is also a button", driver.findElement(By.id("buttonId")).getAttribute("value"));
    }

    @Test
    public void assertTrueTask() throws Exception {

        assertTrue("Custom message", driver.findElement(By.name("randomButton2")).getAttribute("value").equalsIgnoreCase("this is Also a Button"));
    }

    @Test
    public void assertFalseTask() throws Exception {

        assertFalse(driver.findElement(By.name("randomButton2")).getAttribute("value").equals("This is a button"));
    }

    @Test
    public void failTask() throws Exception {

        List<WebElement> elements = driver.findElements(By.className("test"));
        for (WebElement element : elements) {
            assertFalse(element.getText().contains("190"));
        }
    }
}
