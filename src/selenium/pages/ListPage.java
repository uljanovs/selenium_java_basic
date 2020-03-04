package selenium.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;

public class ListPage {

   // ListPage = PageFactory.initElements(driver,ListPage.class);
//     should contain what you see when you just open the page (the table with names/jobs)


    @FindBy(how = How.XPATH, using = "//body/div[2]/button[2]")
    private WebElement resetList;
    @FindBy(how = How.XPATH, using = "//body/div[2]/button[1]")
    private WebElement addPersonButton;
    @FindBy(how = How.ID, using = "listOfPeople")
    private WebElement listOfPeople;


    public void addPeronButton() {
        addPersonButton.click();
    }

    public void resetList() {
        resetList.click();
    }

    public void listOfPeople() {
        listOfPeople.click();
    }

}


