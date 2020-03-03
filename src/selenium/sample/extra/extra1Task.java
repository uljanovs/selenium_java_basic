package selenium.sample.extra;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

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
//        click "More > " for the top left element
//        check that the url now "https://uljanovs.github.io/site/examples/po1"
//        using driver navigation go back to "https://uljanovs.github.io/site/examples/po"
//        check that the page now is "https://uljanovs.github.io/site/examples/po"

        driver.get("https://uljanovs.github.io/site/examples/po");
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/p[2]/a")).click();
        assertEquals("https://uljanovs.github.io/site/examples/po1", driver.getCurrentUrl());
        driver.navigate().back();
        assertEquals("https://uljanovs.github.io/site/examples/po", driver.getCurrentUrl());


    }

    @Test
    public void navigateForward() throws Exception {
//        TODO
//        open page with url "https://uljanovs.github.io/site/examples/po"
//        click "More > " for the top left element
//        using driver navigation go back to "https://uljanovs.github.io/site/examples/po"
//        using driver navigation go forward to "https://uljanovs.github.io/site/examples/po1"
//        check that the page now is "https://uljanovs.github.io/site/examples/po1"

        driver.get("https://uljanovs.github.io/site/examples/po");
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/p[2]/a")).click();
        driver.navigate().back();
        driver.navigate().forward();
        assertEquals("https://uljanovs.github.io/site/examples/po1", driver.getCurrentUrl());


    }

    @Test
    public void refresh() throws Exception {
//        TODO
//        open page "https://uljanovs.github.io/site/examples/act"
//        click on "Show" button in 'Button' section
//        check that text "I am here!" is seen
//        refresh page
//        check that text "I am here!" is not seen
        driver.get("https://uljanovs.github.io/site/examples/act");
        driver.findElement(By.id("show_text")).click();
        assertEquals("I am here!", driver.findElement(By.id("show_me")).getText());
        driver.navigate().refresh();
        assertFalse(driver.findElement(By.id("show_me")).isDisplayed());


    }
}
