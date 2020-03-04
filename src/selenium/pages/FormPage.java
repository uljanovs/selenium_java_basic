package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;

public class FormPage extends GenericSamplePage {
    WebDriver driver;
    @FindBy(how = How.CLASS_NAME, using = "w3-btn w3-white w3-border w3-left")
    private WebElement clearAllFields;
    @FindBy(how = How.CSS, using = "#name")
    private WebElement Name;
    @FindBy(how = How.CSS, using = "#surname")
    private WebElement Surname;
    @FindBy(how = How.CSS, using = "#job")
    private WebElement Job;

}
