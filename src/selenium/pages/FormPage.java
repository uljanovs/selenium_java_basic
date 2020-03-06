package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FormPage extends BasePage {
    //Locators
    //Clear All Fields
    @FindBy(how = How.ID, using = "addPersonBtn")
    private WebElement ClearAllFieldsButton;

    //Form
    //Name
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[1]")
    private WebElement NameBlock;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[1]/label")
    private WebElement NameLabel;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[1]/input")
    private WebElement NameInput;

    //Surname
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[2]")
    private WebElement SurnameBlock;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[2]/label")
    private WebElement SurnameLabel;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[2]/input")
    private WebElement SurnameInput;

    //Job
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[3]")
    private WebElement JobBlock;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[3]/label")
    private WebElement JobLabel;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[3]/input")
    private WebElement JobInput;

    //Date of Birth
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[4]")
    private WebElement DateOfBirthBlock;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[4]/label")
    private WebElement DateOfBirthLabel;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[4]/input")
    private WebElement DateOfBirthInput;

    //Languages
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[5]")
    private WebElement KnowsLanguageBlock;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[5]/label")
    private WebElement KnowsLanguageLabel;
    @FindBy(how = How.ID, using = "english")
    private WebElement EnglishCheckbox;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[5]/label[2]")
    private WebElement EnglishLabel;
    @FindBy(how = How.ID, using = "french")
    private WebElement FrenchCheckbox;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[5]/label[3]")
    private WebElement FrenchLabel;
    @FindBy(how = How.ID, using = "spanish")
    private WebElement SpanishCheckbox;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[5]/label[4]")
    private WebElement SpanishLabel;

    //Gender
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[6]")
    private WebElement GenderBlock;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[6]/label")
    private WebElement GenderLabel;
    @FindBy(how = How.ID, using = "male")
    private WebElement MaleRadioButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[6]/label[2]")
    private WebElement MaleLabel;
    @FindBy(how = How.ID, using = "female")
    private WebElement FemaleRadioButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[6]/label[3]")
    private WebElement FemaleLabel;

    //Employee Status
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[7]")
    private WebElement EmployeeStatusBlock;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/p[7]/label")
    private WebElement EmployeeStatusLabel;
    @FindBy(how = How.ID, using = "status")
    private WebElement EmployeeStatusSelect;
    @FindBy(how = How.XPATH, using = "//*[@id=\"status\"]/option[1]")
    private WebElement EmployeeStatus;
    @FindBy(how = How.XPATH, using = "//*[@id=\"status\"]/option[2]")
    private WebElement InternStatus;
    @FindBy(how = How.XPATH, using = "//*[@id=\"status\"]/option[3]")
    private WebElement ContractorStatus;

    //Add/Cancel Buttons
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/div")
    private WebElement AddCancelButtonsSection;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/div/button[1]")
    private WebElement AddButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addEditPerson\"]/div/button[2]")
    private WebElement CancelButton;
//Edit
    @FindBy(how = How.CSS, using = ".w3-btn-group > button")
    private WebElement EditButton;


    public void clickNameField() {
        NameInput.click();

    }

    public void enterName() {
        NameInput.sendKeys("William");
    //    assertEquals("William", NameInput.getText());
    }

    public void clickSurnameField() {
        SurnameInput.click();
    }

    public void enterSurname() {
        SurnameInput.sendKeys("Rolf");
        assertEquals("Rolf", SurnameInput.getAttribute("value"));
    }


    public void clickJobField() {
        JobInput.click();
    }

    public void enterJob() {
        JobInput.sendKeys("SMM Manager");
        assertEquals("SMM Manager", JobInput.getAttribute("value"));
    }

    public void clickDateOfBirthField() {
        DateOfBirthInput.click();
    }

    public void enterDateOfBirth() {
        DateOfBirthInput.sendKeys("03/04/1987");
        assertEquals("03/04/1987", DateOfBirthInput.getAttribute("value"));
    }

    public void chooseAllLanguages() {
        FrenchCheckbox.click();
        SpanishCheckbox.click();
        assertTrue(EnglishCheckbox.isSelected());
        assertTrue(FrenchCheckbox.isSelected());
        assertTrue(SpanishCheckbox.isSelected());
    }

    public void chooseMaleGender() {
        MaleRadioButton.click();
        assertTrue(MaleRadioButton.isSelected());
    }

    public void chooseInternStatus() {
        EmployeeStatusSelect.click();
        InternStatus.click();
        assertTrue(InternStatus.isSelected());

    }

    public void addButtonClick() {
        AddButton.click();
    }

    public void editButtonClick() {
        EditButton.click();
    }

    public void cancelButtonClick() {
        CancelButton.click();
    }
}