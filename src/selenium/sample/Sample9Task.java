package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Sample9Task {
    WebDriver driver;
    private static WebDriverWait wait;
    long endTime;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://uljanovs.github.io/site/examples/loading_color");
        wait = (WebDriverWait) new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void loadGreenSleep() throws Exception {
        //TODO:
//         * 1) click on start loading green button
        WebElement startGreen = driver.findElement(By.cssSelector("#start_green"));
        startGreen.click();

 //       TimeUnit.MILLISECONDS.sleep();
        TimeUnit.MILLISECONDS.sleep(500);

//         * 2) check that button does not appear,
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());

//         * but loading text is seen instead   "Loading green..."
        WebElement loadingGreen = driver.findElement(By.cssSelector("#loading_green"));
        assertTrue(loadingGreen.isDisplayed());

//         * 3) check that both button
//         * and loading text is not seen,
 //       TimeUnit.MILLISECONDS.sleep(7 * );
        TimeUnit.MILLISECONDS.sleep(7 * 1000 );
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertFalse(driver.findElement(By.cssSelector("#loading_green")).isDisplayed());
//         * success is seen instead "Green Loaded"
        WebElement finishGreen = driver.findElement(By.cssSelector("#finish_green"));
        assertTrue(finishGreen.isDisplayed());
    }

    @Test
    public void loadGreenImplicit() throws Exception {
//        driver.manage().timeouts().implicitlyWait(, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//         * 1) click on start loading green button
        WebElement startGreen = driver.findElement(By.cssSelector("#start_green"));
        startGreen.click();
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
        WebElement loadingGreen = driver.findElement(By.cssSelector("#loading_green"));
        assertTrue(loadingGreen.isDisplayed());
        assertFalse(startGreen.isDisplayed());
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        WebElement finishGreen = driver.findElement(By.cssSelector("#finish_green"));
        assertTrue(finishGreen.isDisplayed());
        assertFalse(startGreen.isDisplayed());
        assertFalse(loadingGreen.isDisplayed());
    }

    @Test
    public void loadGreenExplicitWait() throws Exception {
     //   WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, )
        //WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 3 )
               // .ignoring(StaleElementReferenceException.class);
     //           .ignoring(StaleElementReferenceException.class);
//         * 1) click on start loading green button
  //      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#start_green")));
        WebElement startGreen = driver.findElement(By.cssSelector("#start_green"));
        wait.until(ExpectedConditions.elementToBeClickable(startGreen));
        startGreen.click();
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#loading_green")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#loading_green")));

        WebElement loadingGreen = driver.findElement(By.cssSelector("#loading_green"));
        assertTrue(loadingGreen.isDisplayed());
        assertFalse(startGreen.isDisplayed());
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#finish_green")));
        WebElement finishGreen = driver.findElement(By.cssSelector("#finish_green"));
        assertTrue(finishGreen.isDisplayed());
        assertFalse(startGreen.isDisplayed());
        assertFalse(loadingGreen.isDisplayed());
    }

    @Test
    public void loadGreenAndBlueBonus() {
        // TODO:
         // wait until button to load green and blue appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start_green_and_blue")));
        assertTrue(driver.findElement(By.id("start_green_and_blue")).isDisplayed());
         // 1) click on start loading green and blue button
        WebElement startGreenAndBlue = driver.findElement(By.id("start_green_and_blue"));
        startGreenAndBlue.click();

        //2) check that button does not appear, but loading text is seen instead for green
        assertFalse(startGreenAndBlue.isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("#loading_green_without_blue")).isDisplayed());


         // 3) check that button does not appear, but loading text is seen instead for green and blue
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#loading_green_with_blue")));
        assertTrue(driver.findElement(By.id("loading_green_without_blue")).isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green_with_blue")).isDisplayed());


        //4) check that button and loading green does not appear,
         //		but loading text is seen instead for blue and success for green is seen
        //check that both button and loading text is not seen, success is seen instead
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loading_blue_without_green")));
        assertFalse(startGreenAndBlue.isDisplayed());
        assertFalse(driver.findElement(By.cssSelector("#loading_green_without_blue")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("#loading_green_with_blue")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("#loading_blue_without_green")).isDisplayed());

//5 check that both button and loading text is not seen, success is seen instead
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#finish_green_and_blue")));
        assertFalse(driver.findElement(By.cssSelector("#loading_green_with_blue")).isDisplayed());
        assertFalse(driver.findElement(By.cssSelector("#loading_blue_without_green")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("#finish_green_and_blue")).isDisplayed());
    }

}
