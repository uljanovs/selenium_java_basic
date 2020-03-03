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
//

        WebElement div_h1 = driver.findElement(By.xpath("//div[h1]"));
        assertEquals("rgba(.w3-pale-red)", div_h1.getCssValue("background-color"));
        WebElement body = driver.findElement(By.xpath("//body"));
        assertEquals("rgba(.w3-pale-yellow)", div_h1.getCssValue("background-color"));

        //        check h1 element font-size 64px
        WebElement h1 = driver.findElement(By.xpath("//h1"));
        driver.findElement(By.id("h1")).getCssValue("font-size");
        assertEquals("64px", h1.getCssValue("font-size"));
    }
}

