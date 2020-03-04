package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.pages.ProvideFeedbackPage;

import static org.junit.Assert.assertEquals;

public class Task2 {
    WebDriver driver;
    ProvideFeedbackPage feedbackPage = PageFactory.initElements(driver, ProvideFeedbackPage.class);

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://uljanovs.github.io/site/tasks/provide_feedback");
        feedbackPage = PageFactory.initElements(driver, ProvideFeedbackPage.class);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void initialFeedbackPage() throws Exception {
//         TODO:
//         check that all field are empty and no tick are clicked
//         "Don't know" is selected in "Genre"
//         "Choose your option" in "How do you like us?"
//         check that the button send is blue with white letters
        feedbackPage.nameIsEmptyCheck();
        feedbackPage.ageIsEmptyCheck();
        feedbackPage.EnglishNotSelected();
        feedbackPage.FrenchNotSelected();
        feedbackPage.SpanishNotSelected();
        feedbackPage.ChineseNotSelected();
        feedbackPage.GenderNotSelected();
        feedbackPage.HowDoYouLikeUsNotSelected();
        feedbackPage.commentIsEmptyCheck();
        feedbackPage.sendButtonVisualCheck();
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)
        feedbackPage.sendButtonClick();
        feedbackPage.nameNull();
        feedbackPage.ageNull();
        feedbackPage.languageNull();
        feedbackPage.genderNull();
        feedbackPage.optionOfUsNull();
        feedbackPage.commentNull();
        feedbackPage.YesButtonVisualCheck();
        feedbackPage.NoButtonVisualCheck();
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)

        //Fill
        feedbackPage.NameFieldFill();
        feedbackPage.AgeFieldFill();
        feedbackPage.LanguageFieldFill();
        feedbackPage.GenderSelection();
        feedbackPage.HowDoYouLikeUsSelection();
        feedbackPage.CommentFieldFill();
        //Send
        feedbackPage.sendButtonClick();
        //Check
        //Fields
        feedbackPage.NameFieldResultCheck();
        feedbackPage.AgeFieldResultCheck();
        feedbackPage.LanguageFieldResultCheck();
        feedbackPage.GenderFieldResultCheck();
        feedbackPage.OptionFieldResultCheck();
        feedbackPage.CommentFieldResultCheck();
        //Buttons
        feedbackPage.YesButtonVisualCheck();
        feedbackPage.NoButtonVisualCheck();

    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
//         click "Send"
//         click "Yes"
//         check message text: "Thank you, NAME, for your feedback!"
//         color of text is white with green on the background
        feedbackPage.NameFieldFill();
        feedbackPage.sendButtonClick();
        feedbackPage.YesButtonClick();
        feedbackPage.MessageWithNameYesClickedCheck();
        feedbackPage.MessageYesClickedVisualCheck();
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
//         click "Yes"
//         check message text: "Thank you for your feedback!"
//         color of text is white with green on the background
        feedbackPage.sendButtonClick();
        feedbackPage.YesButtonClick();
        feedbackPage.MessageWithouthNameYesClickedCheck();
        feedbackPage.MessageYesClickedVisualCheck();
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
//         click "Send"
//         click "No"
//         check fields are filled correctly
        feedbackPage.NameFieldFill();
        feedbackPage.AgeFieldFill();
        feedbackPage.LanguageFieldFill();
        feedbackPage.GenderSelection();
        feedbackPage.HowDoYouLikeUsSelection();
        feedbackPage.CommentFieldFill();
        //Send
        feedbackPage.sendButtonClick();
        feedbackPage.NoButtonClick();
        //Checking inputs
        feedbackPage.sendButtonClick();
        feedbackPage.NameFieldResultCheck();
        feedbackPage.AgeFieldResultCheck();
        feedbackPage.LanguageFieldResultCheck();
        feedbackPage.GenderFieldResultCheck();
        feedbackPage.OptionFieldResultCheck();
        feedbackPage.CommentFieldResultCheck();

    }
}

