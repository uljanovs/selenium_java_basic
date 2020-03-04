package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FormPage {
    @FindBy(how = How.ID, using = "addPersonBtn")
    private WebElement clearAllFields;

    @FindBy(how = How.XPATH, using = "//button[@onclick='addPersonToList()']")
    private WebElement addBtn;

    @FindBy(how = How.XPATH, using = "///button[@onclick='window.history.back()']")
    private WebElement cancel;

    @FindBy(how = How.ID, using = "name")
    private WebElement nameField;

    @FindBy(how = How.ID, using = "surname")
    private WebElement surnameField;

    @FindBy(how = How.ID, using = "job")
    private WebElement jobField;

    @FindBy(how = How.ID, using = "dob")
    private WebElement dateOfBirthField;

    @FindBy(how = How.ID, using = "english")
    private WebElement englishLang;

    @FindBy(how = How.ID, using = "french")
    private WebElement frenchLang;

    @FindBy(how = How.ID, using = "spanish")
    private WebElement spanishLang;

    @FindBy(how = How.ID, using = "status")
    private WebElement empStatus;

    @FindBy(how = How.ID, using = "male")
    private WebElement maleGender;

    @FindBy(how = How.ID, using = "female")
    private WebElement femaleGender;

    @FindBy(how = How.CLASS_NAME, using = "copyrights")
    private WebElement copyright;





}
