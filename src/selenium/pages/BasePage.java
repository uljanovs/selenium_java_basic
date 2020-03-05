package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;

public class BasePage {
    //header
    @FindBy(how = How.ID, using = "header")
    private WebElement header;

    //navbar
    @FindBy(how = How.CLASS_NAME, using = "w3-navbar")
    private WebElement navigationMenu;

    //navbar - 1 level
    @FindBy(how = How.CSS, using = "ul.w3-navbar > li:nth-child(1) > a")
    private WebElement HomeLink;
    @FindBy(how = How.CSS, using = "ul.w3-navbar > li:nth-child(2) > a")
    private WebElement PageExampleLink;
    @FindBy(how = How.CSS, using = "ul.w3-navbar > li:nth-child(3) > a")
    private WebElement TasksLink;

    //navbar - 2 level - Page Examples
    @FindBy(how = How.CSS, using = "div#base_menu a:nth-child(1)")
    private WebElement LocatorsLink;
    @FindBy(how = How.CSS, using = "div#base_menu a:nth-child(2)")
    private WebElement ActionsLink;
    @FindBy(how = How.CSS, using = "div#base_menu a:nth-child(3)")
    private WebElement AlertedPageLink;
    @FindBy(how = How.CSS, using = "div#base_menu a:nth-child(4)")
    private WebElement AlertAndPopUpsLink;
    @FindBy(how = How.CSS, using = "div#base_menu a:nth-child(5)")
    private WebElement StylesLink;
    @FindBy(how = How.CSS, using = "div#base_menu a:nth-child(6)")
    private WebElement SynchronizationLink;
    @FindBy(how = How.CSS, using = "div#base_menu a:nth-child(7)")
    private WebElement PageWithLinksLink;
    @FindBy(how = How.CSS, using = "div#base_menu a:nth-child(8)")
    private WebElement AgeLink;
    @FindBy(how = How.CSS, using = "div#base_menu a:nth-child(9)")
    private WebElement ColorLoadingLink;

    //navbar - 2 level - Tasks
    @FindBy(how = How.CSS, using = "div#sync_menu a:nth-child(1)")
    private WebElement EnterANumberLink;
    @FindBy(how = How.CSS, using = "div#sync_menu a:nth-child(2)")
    private WebElement DifferentLoccatorsLink;
    @FindBy(how = How.CSS, using = "div#sync_menu a:nth-child(3)")
    private WebElement PeopleWithJobsListLink;
    @FindBy(how = How.CSS, using = "div#sync_menu a:nth-child(4)")
    private WebElement PeopleListLink;
    @FindBy(how = How.CSS, using = "div#sync_menu a:nth-child(5)")
    private WebElement FeedbackFormPageLink;

    //copyright
    @FindBy(how = How.CLASS_NAME, using = "copyrights")
    private WebElement Copyright;

    public String getPageHeader() {
        return header.getText();
    }

    public void checkPageHeaderText(String aHeaderText) {
        assertEquals(getPageHeader(), aHeaderText);
    }


}
