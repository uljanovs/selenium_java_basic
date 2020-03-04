package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListPage {
    WebDriver driver;
    @FindBy(how = How.XPATH, using = "//*[@id='listOfPeople']")
    private WebElement listOfPeople;
    //buttons
    @FindBy(how = How.XPATH, using = "(//*[@id='addPersonBtn'])[1]")
    private WebElement addButton;
    @FindBy(how = How.XPATH, using = "(//*[@id='addPersonBtn'])[2]")
    private WebElement resetButton;
    @FindBy(how = How.XPATH, using = "//*[@id='person0']//i/..")
    private WebElement editBttn0;
    @FindBy(how = How.XPATH, using = "//span[@onclick='openModalForEditPerson(1)']")
    private WebElement editBttn1;
    @FindBy(how = How.XPATH, using = "//span[@onclick='openModalForEditPerson(2)']")
    private WebElement editBttn2;
    @FindBy(how = How.XPATH, using = "//button[@onclick='editPerson(0)']")
    private WebElement edit0;
    @FindBy(how = How.XPATH, using = "//button[@onclick='editPerson(1)']")
    private WebElement edit1;
    @FindBy(how = How.XPATH, using = "//button[@onclick='editPerson(2)']")
    private WebElement edit2;
    @FindBy(how = How.XPATH, using = "//span[@onclick='deletePerson(0)']")
    private WebElement delete0;
    @FindBy(how = How.XPATH, using = "//span[@onclick='deletePerson(1)']")
    private WebElement delete1;
    @FindBy(how = How.XPATH, using = "//span[@onclick='deletePerson(2)']")
    private WebElement delete2;
    //Person fields
    @FindBy(how = How.XPATH, using = "//*[@id='person0']/div/span[1]")
    private WebElement name0;
    @FindBy(how = How.XPATH, using = "//*[@id='person0']/div/span[2]")
    private WebElement surname0;
    @FindBy(how = How.XPATH, using = "//*[@id='person0']/span[3]")
    private WebElement job0;
    @FindBy(how = How.XPATH, using = "//*[@id='person0']/span[4])")
    private WebElement dateOfBirth0;
    @FindBy(how = How.XPATH, using = "//*[@id='person0']/span[5]")
    private WebElement language0;
    @FindBy(how = How.XPATH, using = "//*[@id='person0']/span[6]")
    private WebElement gender0;
    @FindBy(how = How.XPATH, using = "//*[@id='person0']/span[7]")
    private WebElement status0;

    @FindBy(how = How.XPATH, using = "//*[@id='person1']/div/span[1]")
    private WebElement name1;
    @FindBy(how = How.XPATH, using = "//*[@id='person1']/div/span[2]']")
    private WebElement surname1;
    @FindBy(how = How.XPATH, using = "//*[@id='person1']/span[3]")
    private WebElement job1;
    @FindBy(how = How.XPATH, using = "//*[@id='person1']/span[4])")
    private WebElement dateOfBirth1;
    @FindBy(how = How.XPATH, using = "//*[@id='person1']/span[5]")
    private WebElement language1;
    @FindBy(how = How.XPATH, using = "//*[@id='person1']/span[6]")
    private WebElement gender1;
    @FindBy(how = How.XPATH, using = "//*[@id='person1']/span[7]")
    private WebElement status1;

    @FindBy(how = How.XPATH, using = "//*[@id='person2']/div/span[1]")
    private WebElement name2;
    @FindBy(how = How.XPATH, using = "//*[@id='person2']/div/span[2]")
    private WebElement surname2;
    @FindBy(how = How.XPATH, using = "//*[@id='person2']/span[3]")
    private WebElement job2;
    @FindBy(how = How.XPATH, using = "//*[@id='person2']/span[4])")
    private WebElement dateOfBirth2;
    @FindBy(how = How.XPATH, using = "//*[@id='person2']/span[5]")
    private WebElement language2;
    @FindBy(how = How.XPATH, using = "//*[@id='person2']/span[6]")
    private WebElement gender2;
    @FindBy(how = How.XPATH, using = "//*[@id='person2']/span[7]")
    private WebElement status2;


    public void addToList(){
        addButton.click();
    }

    public void editPerson0(){
        editBttn0.click();
    }
    public void editPerson1(){
        editBttn1.click();
    }
    public void editPerson2(){
        editBttn2.click();
    }

    public void submitEditing(){
        edit0.click();
    }

    public void deletePerson0(){
        delete0.click();
    }

    public void deletePerson1(){
        delete1.click();
    }

    public void deletePerson2(){
        delete2.click();
    }

    public String name0 () {
        return name0.getText();
    }
    public String name1 () {
        return name1.getText();
    }
    public String name2 () {
        return name2.getText();
    }

    public String surname0 () {
        return surname0.getText();
    }
    public String surname1 () {
        return surname0.getText();
    }
    public String surname2 () {
        return surname0.getText();
    }
    public String job0 () {
        return job0.getText();
    }
    public String job1 () {
        return job1.getText();
    }
    public String job2 () {
        return job2.getText();
    }
    public String dateOfBirth0 () {
        return dateOfBirth0.getAttribute("value");
    }
    public String dateOfBirth1 () {
        return dateOfBirth1.getText();
    }
    public String dateOfBirth2 () {
        return dateOfBirth2.getText();
    }

    public String gender0 () {
        return gender0.getText();
    }
    public String gender1 () {
        return gender1.getText();
    }
    public String gender2 () {
        return gender2.getText();
    }

    public String language0 () {
        return language0.getText();
    }
    public String language1 () {
        return language1.getText();
    }
    public String language2 () {
        return language2.getText();
    }

    public String status0 () {
        return status0.getText();
    }
    public String status1 () {
        return status1.getText();
    }
    public String status2 () {
        return status2.getText();
    }




}
