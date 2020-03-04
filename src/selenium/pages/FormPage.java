package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class FormPage {
    //buttons
    @FindBy(how = How.ID, using = "addPersonBtn")
    private WebElement clearAllFields;
    @FindBy(how = How.XPATH, using = "//button[@onclick='addPersonToList()']")
    private WebElement addBtn;
    @FindBy(how = How.XPATH, using = "///button[@onclick='window.history.back()']")
    private WebElement cancel;
    //fields
    @FindBy(how = How.ID, using = "name")
    private WebElement nameField;
    @FindBy(how = How.ID, using = "surname")
    private WebElement surnameField;
    @FindBy(how = How.ID, using = "job")
    private WebElement jobField;
    @FindBy(how = How.ID, using = "dob")
    private WebElement dateOfBirthField;
    //radio buttons
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


    public void enterName(String name){
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void enterSurname(String surname){
        surnameField.clear();
        surnameField.sendKeys(surname);
    }

    public void enterJob(String job){
        jobField.clear();
        jobField.sendKeys(job);
    }

    public void enterDateOfBirth(String dateOfBirth){
        dateOfBirthField.clear();
        dateOfBirthField.sendKeys(dateOfBirth);
    }

    public void selectEnglish(){
       englishLang.click();
    }

    public void selectFrench(){
        frenchLang.click();
    }

    public void selectSpanish(){
        spanishLang.click();
    }

   public void selectMale(){
        maleGender.click();
   }

   public void selectFemale(){
        femaleGender.click();
   }

   public void selectStatus(String value){
    WebElement empDropdown = empStatus;
       Select dropdown = new Select(empDropdown);
       dropdown.selectByVisibleText(value);
   }

   public void clearFields(){
        clearAllFields.click();
   }

   public void addPerson(){
        addBtn.click();
   }

   public void cancel(){
        cancel.click();
   }



}
