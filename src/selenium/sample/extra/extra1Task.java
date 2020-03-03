package selenium.sample.extra;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class extra1Task {
    WebDriver driver;
    String base_url = "https://uljanovs.github.io/site/examples/act";
    String new_url = "https://uljanovs.github.io/site/examples/link1";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void navigateBack() throws Exception {
//        TODO
//        open page with url "https://uljanovs.github.io/site/examples/po"
        driver.get("https://uljanovs.github.io/site/examples/po");
//        click "More > " for the top left element
        driver.findElement(By.xpath("//a[@href='po1']")).click();
//        check that the url now "https://uljanovs.github.io/site/examples/po1"
        assertEquals("https://uljanovs.github.io/site/examples/po1", driver.getCurrentUrl());
//        using driver navigation go back to "https://uljanovs.github.io/site/examples/po"
        driver.navigate().back();
        //        check that the page now is "https://uljanovs.github.io/site/examples/po"
        assertEquals("https://uljanovs.github.io/site/examples/po", driver.getCurrentUrl());
    }

    @Test
    public void navigateForward() throws Exception {
//        TODO
//        open page with url "https://uljanovs.github.io/site/examples/po"
        driver.get("https://uljanovs.github.io/site/examples/po");
//        click "More > " for the top left element
        driver.findElement(By.xpath("//a[@href='po1']")).click();
//        using driver navigation go back to "https://uljanovs.github.io/site/examples/po"
        driver.navigate().back();
//        using driver navigation go forward to "https://uljanovs.github.io/site/examples/po1"
        driver.navigate().forward();
//        check that the page now is "https://uljanovs.github.io/site/examples/po1"
        assertEquals("https://uljanovs.github.io/site/examples/po1", driver.getCurrentUrl());
    }

    @Test
    public void refresh() throws Exception {
//        TODO
//        open page "https://uljanovs.github.io/site/examples/act"
        driver.get("https://uljanovs.github.io/site/examples/act");
//        click on "Show" button in 'Button' section
        driver.findElement(By.id("show_text")).click();
//        check that text "I am here!" is seen
        assertEquals("I'm here!", driver.findElement(By.id("show_me")).getText();
//        refresh page
        driver.navigate().refresh();
//        check that text "I am here!" is not seen
       // assertEquals(driver.findElement(By.id("show_me")).getText(),"");
         assertFalse(driver.findElement(By.id("show_me")).isDisplayed());

    }
}
