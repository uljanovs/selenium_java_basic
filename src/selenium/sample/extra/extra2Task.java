package selenium.sample.extra;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.Color;

import static junit.framework.TestCase.assertEquals;


public class extra2Task {
    WebDriver driver;
    String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";


    public void pageCheck() throws Exception {
        driver.get("https://uljanovs.github.io/site/examples/po");
        WebElement h1 = driver.findElement(By.xpath("//h1"));
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        System.out.println(browserName);
        if (browserName.contains("internet explorer")){
            assertEquals("\"segoe ui\",arial,sans-serif", h1.getCssValue("font-family"));
            System.out.println("1");
        }
        else {
            assertEquals("\"Segoe UI\", Arial, sans-serif", h1.getCssValue("font-family"));
            System.out.println("2");
        }
        //assertEquals(Color.fromString("rgba(0, 0, 0, 1)"), Color.fromString(h1.getCssValue("color")));
        //assertEquals(driver.findElement(By.tagName("h1")).getText(), "Lorem ipsum");
      //  System.out.println(driver.findElement(By.tagName("h1")).getCssValue("color"));
        //System.out.println(driver.findElement(By.tagName("h1")).getCssValue("background-color"));
    }

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
//        check the background color of h1 element
        pageCheck();
    }

    @Test
    public void runningOnChrome() throws Exception {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
//        TODO
//        go to page https://uljanovs.github.io/site/examples/po
//        check the background color of h1 element
        pageCheck();
    }

    @Test
    public void runningOnIE() throws Exception {
        System.setProperty("webdriver.ie.driver", libWithDriversLocation + "IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        //maximize browser window
        driver.manage().window().maximize();

//        TODO
//        go to page https://uljanovs.github.io/site/examples/po
//        check the background color of h1 element
        pageCheck();
    }
}
