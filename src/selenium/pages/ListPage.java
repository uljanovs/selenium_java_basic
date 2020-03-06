package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListPage extends BasePage {
    //Buttons
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/button[1]")
    private WebElement AddPersonButton;
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/button[2]")
    private WebElement ResetListButton;
    //PeopleList
    @FindBy(how = How.ID, using = "listOfPeople")
    private WebElement PeopleList;
    @FindBy(how = How.CSS, using = "#person0 > span.w3-closebtn.editbtn.w3-padding.w3-margin-right.w3-medium")
    private WebElement EditButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/span[1]")
    private WebElement DeleteButton1;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person1\"]/span[1]")
    private WebElement DeleteButton2;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person2\"]/span[1]")
    private WebElement DeleteButton3;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/div/span[1]")
    private WebElement Person1;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person1\"]/div/span[1]")
    private WebElement Person2;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person2\"]/div/span[1]")
    private WebElement Person3;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person3\"]/div/span[1]")
    private WebElement Person4;


    public void clickAddPersonButton() {
        AddPersonButton.click();
    }

    public String getPeopleListSize() {
        String size = PeopleList.getSize().toString();
        return size;
    }

    public void MikeIsPresentCheck() {
        assertTrue(Person1.isDisplayed());
        assertEquals("Mike", Person1.getText());
    }

    public void JillIsPresentCheck() {
        assertTrue(Person2.isDisplayed());
        assertEquals("Jill", Person2.getText());
    }

    public void JaneIsPresentCheck() {
        assertTrue(Person3.isDisplayed());
        assertEquals("Jane", Person3.getText());
    }

    public void WilliamIsPresentCheck() {
        assertTrue(Person4.isDisplayed());
        assertEquals("William", Person4.getText());
    }

    public void MikeIsChangedCheck() {
        assertTrue(Person1.isDisplayed());
        assertEquals("MikeWilliam", Person1.getText());
    }

    public void MikeDeletedCheck() {
        assertTrue(Person2.isDisplayed());
        assertEquals("Jill", Person2.getText());
        assertTrue(Person3.isDisplayed());
       assertEquals("Jane", Person3.getText());
    }


    public void clickEdit() {
        EditButton.click();
    }

    public void clickDelete1() {
        DeleteButton1.click();
    }
    public void clickDelete2() {
        DeleteButton2.click();
    }
    public void clickDelete3() {
        DeleteButton3.click();
    }
    public void PeopleListNotDisplayedCheck() {
        assertTrue(PeopleList.getCssValue("height").equals("0px"));
    }

    public void AddIsDisplayedCheck() {
        assertTrue(AddPersonButton.isDisplayed());
    }

    public void ResetIsDisplayedCheck() {
        assertTrue(ResetListButton.isDisplayed());
    }

    public void ResetButtonClick() {
        ResetListButton.click();
    }

}