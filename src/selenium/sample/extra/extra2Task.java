package selenium.sample.extra;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static org.junit.Assert.assertEquals;


public class extra2Task {
    WebDriver driver;
    String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void runningOnFirefox() throws Exception {
        System.setProperty("webdriver.gecko.driver", libWithDriversLocation + "geckodriver.exe");
        driver = new FirefoxDriver();
//        TODO
//        go to page https://uljanovs.github.io/site/examples/po
          driver.get("https://uljanovs.github.io/site/examples/po");
//        check the background color of h1 element
          assertEquals("rgb(241, 241, 241)",
                driver.findElement(By.cssSelector(".w3-light-grey")).getCssValue("background-color"));
    }

    @Test
    public void runningOnChrome() throws Exception {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
//        TODO
//        go to page https://uljanovs.github.io/site/examples/po
          driver.get("https://uljanovs.github.io/site/examples/po");
//        check the background color of h1 element
          assertEquals("rgba(241, 241, 241, 1)",
                driver.findElement(By.cssSelector(".w3-light-grey")).getCssValue("background-color"));
    }
    @Test
    public void runningOnIE() throws Exception {
        System.setProperty("webdriver.ie.driver", libWithDriversLocation + "IEDriverServer.exe");
        driver = new InternetExplorerDriver();
//        TODO
//        go to page https://uljanovs.github.io/site/examples/po
        driver.get("https://uljanovs.github.io/site/examples/po");
//        check the background color of h1 element
        assertEquals("rgba(241, 241, 241, 1)",
                driver.findElement(By.cssSelector(".w3-light-grey")).getCssValue("background-color"));
    }
}
