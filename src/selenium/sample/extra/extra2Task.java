package selenium.sample.extra;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class extra2Task {
    WebDriver driver;
    String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    private String color;


    public void checkFontWeight() {
        assertEquals("400",
                driver.findElement(By.className("w3-jumbo")).getCssValue("font-weight"));
    }
    public void checkColor(String color) {
        assertEquals(color,
                driver.findElement(By.className("w3-jumbo")).getCssValue("color"));
        }
    public void checkBGColor(String bgc) {
        assertEquals(bgc,
                driver.findElement(By.className("w3-jumbo")).getCssValue("background-color"));
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
        driver.get("https://uljanovs.github.io/site/examples/po");
//        check the background color of h1 element
        checkFontWeight();

        checkColor("rgb(0, 0, 0)");
        checkBGColor("rgba(0, 0, 0, 0)");
    }

    @Test
    public void runningOnChrome() throws Exception {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
//        TODO
//        go to page https://uljanovs.github.io/site/examples/po
        driver.get("https://uljanovs.github.io/site/examples/po");
//        check the background color of h1 element
        checkFontWeight();
        checkColor("rgba(0, 0, 0, 1)");
        checkBGColor("rgba(0, 0, 0, 0)");

    }

    @Test
    public void runningOnIE() throws Exception {
        System.setProperty("webdriver.ie.driver", libWithDriversLocation + "IEDriverServer.exe");
        driver = new InternetExplorerDriver();
//        TODO
//        go to page https://uljanovs.github.io/site/examples/po
        driver.get("https://uljanovs.github.io/site/examples/po");
//        check the background color of h1 element
        checkFontWeight();
        checkColor("rgba(0, 0, 0, 1)");
        checkBGColor("transparent");
    }
}
