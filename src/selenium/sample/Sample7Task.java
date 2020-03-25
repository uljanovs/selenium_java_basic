package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Sample7Task {
    private WebDriver driver;
    private String base_url = "https://kristinek.github.io/site/examples/actions";

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
    public void selectCheckBox() throws Exception {
//        check that none of the checkboxes are ticked
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected());
        }
//        tick  "Option 2"
        checkBoxes.get(1).click();
//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
        assertFalse(checkBoxes.get(0).isSelected());
        assertTrue(checkBoxes.get(1).isSelected());
        assertFalse(checkBoxes.get(2).isSelected());
//        tick  "Option 3"
        checkBoxes.get(2).click();
//        click result
        driver.findElement(By.id("result_button_checkbox")).click();
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
        assertEquals("You selected value(s): Option 2, Option 3", driver.findElement(By.id("result_checkbox")).getText());
    }


    @Test
    public void selectRadioButton() throws Exception {
//        check that none of the radio are selected
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));
        for (WebElement radio : radioButtons) {
            assertFalse(radio.isSelected());
        }
//        select  "Option 3"
        radioButtons.get(2).click();
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
        assertFalse(radioButtons.get(0).isSelected());
        assertFalse(radioButtons.get(1).isSelected());
        assertTrue(radioButtons.get(2).isSelected());
//        select  "Option 1"
        radioButtons.get(0).click();
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
        assertTrue(radioButtons.get(0).isSelected());
        assertFalse(radioButtons.get(1).isSelected());
        assertFalse(radioButtons.get(2).isSelected());
//        click result
        driver.findElement(By.id("result_button_ratio")).click();
//        check that 'You selected option: Option 1' text is being displayed
        assertEquals("You selected option: Option 1", driver.findElement(By.id("result_radio")).getText());
    }

    @Test
    public void selectOption() throws Exception {
//        select "Option 3" in Select
        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
        dropdown.selectByVisibleText("Option 3");
//        check that selected option is "Option 3"
        assertEquals("Option 3", dropdown.getFirstSelectedOption().getText());
//        select "Option 2" in Select
        dropdown.selectByVisibleText("Option 2");
//        check that selected option is "Option 2"
        assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());
//        click result
        driver.findElement(By.id("result_button_select")).click();
//        check that 'You selected option: Option 2' text is being displayed
        assertEquals("You selected option: Option 2", driver.findElement(By.id("result_select")).getText());
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//        enter date '4 of July 2007' using calendar widget
        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        dateBox.click();
        Calendar cal = Calendar.getInstance();
        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
        int timesToClick = (cal.get(Calendar.YEAR) - 2007) * 12 + (cal.get(Calendar.MONTH) - 6);
        for (int i = 0; i < timesToClick; i++) {
            dateWidget.findElement(By.className("ui-datepicker-prev")).click();
        }
        dateWidget.findElement(By.xpath("//a[text()='4']")).click();
//        check that correct date is added
        assertEquals("07/04/2007", dateBox.getAttribute("value"));
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("result_button_date")).click();
        assertEquals("You entered date: 07/04/2007", driver.findElement(By.id("result_date")).getText());
    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//        enter date '2 of May 1959' using text
        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        dateBox.clear();
        dateBox.sendKeys("05/02/1959" + Keys.ENTER);
//        check that correct date is added
        assertEquals("05/02/1959", dateBox.getAttribute("value"));
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("result_button_date")).click();
        assertEquals("You entered date: 05/02/1959", driver.findElement(By.id("result_date")).getText());
    }
}
