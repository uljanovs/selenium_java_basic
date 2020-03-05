package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListPage extends BasePage {
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/button[1]")
    private WebElement AddPersonButton;
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/button[2]")
    private WebElement ResetListButton;
    @FindBy(how = How.CLASS_NAME, using = "w3-ul")
    private WebElement PeopleList;
    @FindBy(how = How.XPATH, using ="//*[@id=\"person0\"]/span[2]/i")
    private WebElement EditButton;


    public void clickAddPersonButton() {
        AddPersonButton.click();
    }

    public String getPeopleListSize() {
        String size = PeopleList.getSize().toString();
        return size;
    }
    public void PList(){
        List PList = new ArrayList();
        PList.add(1);
        PList.add(b);
        PList.add(c);
        PList.add(d);
        PList.add(e);
        PList.add(f);}

    public void clickEdit() {
        EditButton.click();
    }

}
