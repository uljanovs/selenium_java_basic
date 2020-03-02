package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task1 {
    WebDriver driver;

    @Before
    public void openPage() {

        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://uljanovs.github.io/site/tasks/enter_a_number");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void errorOnText()  throws Exception{

//        enter a text instead of a number, check that correct error is seen
        driver.findElement(By.id("numb")).sendKeys("abc");
        driver.findElement(By.className("w3-btn w3-orange w3-margin")).click();
        assertEquals("Please enter a number", driver.findElement(By.id("numb")).getText());
    }

    @Test
    public void errorOnNumberTooSmall()  throws Exception{
//
//        enter number which is too small (below 50), check that correct error is seen
        driver.findElement(By.id("numb")).sendKeys("25");
        driver.findElement(By.className("w3-btn w3-orange w3-margin")).click();
        assertEquals("Number is too small", driver.findElement(By.id("numb")).getText());
    }

    @Test
    public void errorOnNumberTooBig() throws Exception{

//        BUG: if I enter number 666 no errors where seen
//
//        enter number which is too big (above 100), check that correct error is seen
        driver.findElement(By.id("numb")).sendKeys("177");
        driver.findElement(By.className("w3-btn w3-orange w3-margin")).click();
        assertEquals("Number is too big", driver.findElement(By.id("numb")).getText());

    }

    @Test
    public void correctSquareRootWithoutRemainder() throws Exception{

//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        driver.findElement(By.id("numb")).sendKeys("100");
        driver.findElement(By.className("w3-btn w3-orange w3-margin")).click();
        Alert alert = driver.switchTo().alert();
            assertEquals("Square root of 100 is 10.00",alert.getText());

        alert.accept();
            assertEquals("Square root of 100 is 10.00",alert.getText());
    }

    @Test
    public void correctSquareRootWithRemainder() throws Exception {

//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        driver.findElement(By.id("numb")).sendKeys("99");
        driver.findElement(By.className("w3-btn w3-orange w3-margin")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 99 is 9.95",alert.getText());

        alert.accept();
        assertEquals("Square root of 99 is 9.95",alert.getText());
    }
}
