package selenium.sample.extra;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class extra1Task {
    WebDriver driver;
    String base_url = "https://uljanovs.github.io/site/examples/act";
    String new_url = "https://uljanovs.github.io/site/examples/link1";
    private static WebDriverWait wait;

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
        wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);

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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li[2]")));
        driver.findElement(By.xpath("//ul/li[2]")).click();
        driver.findElement(By.linkText("Page with Links")).click();

//        click "More > " for the top left element
        driver.findElement(By.xpath("//div[contains(@class, w3-pale-red)]//a[.='More >> ']")).click();
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

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li[2]")));
        driver.findElement(By.xpath("//ul/li[2]")).click();
        driver.findElement(By.linkText("Page with Links")).click();

//        click "More > " for the top left element
        driver.findElement(By.xpath("//div[contains(@class, w3-pale-red)]//a[.='More >> ']")).click();
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
        driver.findElement(By.id("show_text")).click();
//        click on "Show" button in 'Button' section
//        check that text "I am here!" is seen
        assertEquals("I am here!", driver.findElement(By.id("show_me")).getText());
//        refresh page
        driver.navigate().refresh();
//        check that text "I am here!" is not seen
        assertFalse(driver.findElement(By.id("show_me")).isDisplayed());
    }
}
