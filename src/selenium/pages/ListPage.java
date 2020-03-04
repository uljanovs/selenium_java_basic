package selenium.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;

public class ListPage extends GenericSamplePage {
    @FindBy(how = How.CSS, using = "body > div:nth-child(2) > h2+*")
    private WebElement AddPersonButton;
    @FindBy(how = How.CSS, using = "body > div:nth-child(2) > h2+*+*")
    private WebElement ResetListButton;

    public void clickAddPersonButton (){
        AddPersonButton.click();
    }

}
