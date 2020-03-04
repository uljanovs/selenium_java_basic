package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;
//import static org.openqa.selenium.support.ui.Select.*;

public class ProvideFeedbackPage /*extends BasePage*/ {
    //Name
    @FindBy(how = How.ID, using = "fb_name")
    private WebElement NameField;

    //Age
    @FindBy(how = How.ID, using = "fb_age")
    private WebElement AgeField;

    //Languages
    @FindBy(how = How.XPATH, using = "//*[@id=\"lang_check\"]/input[1]")
    private WebElement EnglishCheckbox;
    @FindBy(how = How.XPATH, using = "//*[@id=\"lang_check\"]/input[2]")
    private WebElement FrenchCheckbox;
    @FindBy(how = How.XPATH, using = "//*[@id=\"lang_check\"]/input[3]")
    private WebElement SpanishCheckbox;
    @FindBy(how = How.XPATH, using = "//*[@id=\"lang_check\"]/input[4]")
    private WebElement ChineseCheckbox;

    //Gender
    @FindBy(how = How.XPATH, using = "//*[@id=\"fb_form\"]/form/div[4]/input[1]")
    private WebElement MaleRadiobutton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"fb_form\"]/form/div[4]/input[2]")
    private WebElement FemaleRadiobutton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"fb_form\"]/form/div[4]/input[3]")
    private WebElement DontKnowRadiobutton;

    //How do You like us
    @FindBy(how = How.XPATH, using = "//*[@id=\"like_us\"]/option[1]")
    private WebElement ChooseYourOptionSelect;
    @FindBy(how = How.XPATH, using = "//*[@id=\"like_us\"]/option[2]")
    private WebElement GoodSelect;
    @FindBy(how = How.XPATH, using = "//*[@id=\"like_us\"]/option[3]")
    private WebElement OKSelect;
    @FindBy(how = How.XPATH, using = "//*[@id=\"like_us\"]/option[4]")
    private WebElement BadSelect;
    @FindBy(how = How.XPATH, using = "//*[@id=\"like_us\"]/option[5]")
    private WebElement WhyMeSelect;

    //Comment
    @FindBy(how = How.TAG_NAME, using = "textarea")
    private WebElement CommentField;

    //Button
    @FindBy(how = How.CLASS_NAME, using = "w3-blue")
    private WebElement SendButton;
    @FindBy(how = How.CLASS_NAME, using = "w3-green")
    private WebElement YesButton;
    @FindBy(how = How.CLASS_NAME, using = "w3-red")
    private WebElement NoButton;

    //Form filled - result
    @FindBy(how = How.ID, using = "name")
    private WebElement NameFieldResult;
    @FindBy(how = How.ID, using = "age")
    private WebElement AgeFieldResult;
    @FindBy(how = How.ID, using = "language")
    private WebElement LanguageFieldResult;
    @FindBy(how = How.ID, using = "gender")
    private WebElement GenderFieldResult;
    @FindBy(how = How.ID, using = "option")
    private WebElement OptionFieldResult;
    @FindBy(how = How.ID, using = "comment")
    private WebElement CommentFieldResult;

    //Yes Clicked
    @FindBy(how = How.CLASS_NAME, using = "w3-green")
    private WebElement MessageYesClicked;

    //Empty/Not selected Fields Check
    public void nameIsEmptyCheck() {
        assertTrue(NameField.getText().equals(""));

    }

    public void ageIsEmptyCheck() {
        assertTrue(AgeField.getText().equals(""));

    }

    public void FrenchNotSelected() {
        assertFalse(FrenchCheckbox.isSelected());

    }

    public void SpanishNotSelected() {
        assertFalse(SpanishCheckbox.isSelected());

    }

    public void ChineseNotSelected() {
        assertFalse(ChineseCheckbox.isSelected());

    }

    public void EnglishNotSelected() {
        assertFalse(EnglishCheckbox.isSelected());

    }

    public void GenderNotSelected() {
        assertTrue(DontKnowRadiobutton.isSelected());

    }

    public void HowDoYouLikeUsNotSelected() {
        assertTrue(ChooseYourOptionSelect.isSelected());

    }

    public void commentIsEmptyCheck() {
        assertTrue(CommentField.getText().equals(""));

    }

    //Filling fields
    public void NameFieldFill() {
  //      NameField.click();
        NameField.click();
        NameField.sendKeys("Julie");


    }

    public void AgeFieldFill() {
        AgeField.click();
        AgeField.sendKeys("56");

    }

    public void LanguageFieldFill() {
        FrenchCheckbox.click();
        EnglishCheckbox.click();
        assertTrue(FrenchCheckbox.isSelected());
        assertTrue(EnglishCheckbox.isSelected());
    }

    public void GenderSelection() {
        FemaleRadiobutton.click();
        assertTrue(FemaleRadiobutton.isSelected());
    }

    public void HowDoYouLikeUsSelection() {
        ChooseYourOptionSelect.click();
        BadSelect.click();
        assertTrue(BadSelect.isSelected());
    }

    public void CommentFieldFill() {
        CommentField.click();
        CommentField.sendKeys(">:(");
    }

    //Buttons
    //Send
    public void sendButtonVisualCheck() {
        assertTrue(SendButton.getCssValue("background-color").equals("rgba(33, 150, 243, 1)"));
        assertTrue(SendButton.getCssValue("color").equals("rgba(255, 255, 255, 1)"));
    }

    public void sendButtonClick() {
        SendButton.click();
    }

    //Yes
    public void YesButtonVisualCheck() {
        assertTrue(YesButton.getCssValue("background-color").equals("rgba(76, 175, 80, 1)"));
        assertTrue(YesButton.getCssValue("color").equals("rgba(255, 255, 255, 1)"));
    }

    public void YesButtonClick() {
        YesButton.click();
    }

    //No
    public void NoButtonVisualCheck() {
        assertTrue(NoButton.getCssValue("background-color").equals("rgba(244, 67, 54, 1)"));
        assertTrue(NoButton.getCssValue("color").equals("rgba(255, 255, 255, 1)"));
    }

    public void NoButtonClick() {
        NoButton.click();
    }

    //Empty fields request sent
    public void nameNull() {
        System.out.println(NameFieldResult.getText());
        assertTrue(NameFieldResult.getText().equals(""));
    }

    public void ageNull() {
        assertTrue(AgeFieldResult.getText().equals(""));
    }

    public void languageNull() {
        assertTrue(LanguageFieldResult.getText().equals(""));
    }

    public void genderNull() {
        assertTrue(GenderFieldResult.getText().equals("null"));
    }

    public void optionOfUsNull() {
        assertTrue(OptionFieldResult.getText().equals("null"));
    }

    public void commentNull() {
        assertTrue(CommentFieldResult.getText().equals(""));
    }

    //Check fields after clicking Send Button
    public void NameFieldResultCheck() {
        assertTrue(NameFieldResult.getText().equals("Julie"));
    }

    public void AgeFieldResultCheck() {
        assertTrue(AgeFieldResult.getText().equals("56"));
    }

    public void LanguageFieldResultCheck() {
        assertTrue(LanguageFieldResult.getText().equals("English,French"));
    }

    public void GenderFieldResultCheck() {
        assertTrue(GenderFieldResult.getText().equals("female"));
    }

    public void OptionFieldResultCheck() {
        assertTrue(OptionFieldResult.getText().equals("Bad"));
    }

    public void CommentFieldResultCheck() {
        assertTrue(CommentFieldResult.getText().equals(">:("));
    }

    //After clicking Yes Button
    public void MessageWithNameYesClickedCheck() {
        assertTrue(MessageYesClicked.getText().equals("Thank you, Julie, for your feedback!"));
    }
    public void MessageWithouthNameYesClickedCheck() {
        assertTrue(MessageYesClicked.getText().equals("Thank you for your feedback!"));
    }
    public void MessageYesClickedVisualCheck() {
        assertTrue(MessageYesClicked.getCssValue("background-color").equals("rgba(76, 175, 80, 1)"));
        assertTrue(MessageYesClicked.getCssValue("color").equals("rgba(255, 255, 255, 1)"));
    }
}



