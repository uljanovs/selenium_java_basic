package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class Task1 {
    WebDriver driver;

    @Before
    public void openPage() throws Exception {

        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://uljanovs.github.io/site/tasks/enter_a_number");
    }

    @After
    public void closeBrowser() throws Exception {
        driver.quit();
    }

    @Test
    public void errorOnText()throws Exception {
//        TODO
//        enter a text instead of a number, check that correct error is seen
driver.findElement(By.id("numb")).sendKeys("abc");
driver.findElement((By.className("w3-btn "))).click();
        assertTrue(driver.findElement(By.id("ch1_error")).isDisplayed());
        assertEquals("Please enter a number", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void errorOnNumberTooSmall()throws Exception {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        driver.findElement(By.id("numb")).sendKeys("40");
        driver.findElement((By.className("w3-btn "))).click();
        assertTrue(driver.findElement(By.id("ch1_error")).isDisplayed());
        assertEquals("Number is too small", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void errorOnNumberTooBig()throws Exception {

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        driver.findElement(By.id("numb")).sendKeys("101");
        driver.findElement((By.className("w3-btn "))).click();
        assertTrue(driver.findElement(By.id("ch1_error")).isDisplayed());
        assertEquals("Number is too big", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void correctSquareRootWithoutRemainder()throws Exception {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        driver.findElement(By.id("numb")).sendKeys("64");
        driver.findElement((By.className("w3-btn "))).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 64 is 8.00", alert.getText());
        alert.accept();
        assertFalse(driver.findElement(By.id("ch1_error")).isDisplayed());



    }

    @Test
    public void correctSquareRootWithRemainder()throws Exception {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        driver.findElement(By.id("numb")).sendKeys("60");
        driver.findElement((By.className("w3-btn "))).click();
        Alert alert2 = driver.switchTo().alert();
        assertEquals("Square root of 60 is 7.75", alert2.getText());
        alert2.accept();
        assertFalse(driver.findElement(By.id("ch1_error")).isDisplayed());
    }
}
