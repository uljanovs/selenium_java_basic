package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertEquals;



public class FormPage {
    //formPage = PageFactory.initElements(driver, FormPage.class);

//     should be what you see if you click "Add" or "Edit" (2 input field and a button (Add/Edit) and (Cancel)

    @FindBy(how = How.ID, using = "addPersonBtn")
    private WebElement clearFields;
    @FindBy(how = How.ID, using = "name")
    private WebElement name;
    @FindBy(how = How.ID, using = "surname")
    private WebElement surname;
    @FindBy(how = How.ID, using = "job")
    private WebElement job;
    @FindBy(how = How.ID, using = "dob")
    private WebElement dateBirth;
    @FindBy(how = How.ID, using = "english")
    private WebElement english;
    @FindBy(how = How.ID, using = "french")
    private WebElement french;
    @FindBy(how = How.ID, using = "spanish")
    private WebElement spanish;
    @FindBy(how = How.ID, using = "male")
    private WebElement male;
    @FindBy(how = How.ID, using = "female")
    private WebElement female;
    @FindBy(how = How.NAME, using = "option")
    private WebElement employeeStatus;
    @FindBy(how = How.ID, using = "modal_buttonn")
    private WebElement employeeAddButton;
    @FindBy(how = How.ID, using = "modal_button")
    private WebElement employeeCancel;


    public void clickBackButton() {
        backButton.click();
    }

    public void checkMessageText(String messageText) {
        checkPageHeaderText("Age page");
        assertEquals(message.getText(), messageText);
    }
}
}
