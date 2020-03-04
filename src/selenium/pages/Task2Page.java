package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;

public class Task2Page {
    @FindBy(how = How.ID, using = "fb_name")
    private WebElement Name;
    @FindBy(how = How.ID, using = "fb_age")
    private WebElement Age;
    @FindBy(how = How.CSS, using = "#lang_check > input:nth-child(2)")
    private WebElement English;
    @FindBy(how = How.CSS, using = "#lang_check > input:nth-child(4)")
    private WebElement French;
    @FindBy(how = How.CSS, using = "#lang_check > input:nth-child(6)")
    private WebElement Spanish;
    @FindBy(how = How.CSS, using = "#lang_check > input:nth-child(8)")
    private WebElement Chinese;
    @FindBy(how = How.CSS, using = "#fb_form > form > div:nth-child(4) > input:nth-child(2)")
    private WebElement Male;
    @FindBy(how = How.CSS, using = "#fb_form > form > div:nth-child(4) > input:nth-child(4)")
    private WebElement Female;
    @FindBy(how = How.CSS, using = "#fb_form > form > div:nth-child(4) > input:nth-child(6)")
    private WebElement DoNotKnowGender;
    @FindBy(how = How.ID, using = "like_us")
    private WebElement HowDoYouLikeUs;

}
