package selenium.pages;

import selenium.tasks.Task3Bonus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;

public class ListPage extends Task3Bonus {

    @FindBy(how = How.XPATH, using = ".//div[@class='w3-container'][1]/child::button[1]")
    private WebElement addPersonTop;
    @FindBy(how = How.XPATH, using = ".//div[@class='w3-container'][1]/child::button[2]")
    private WebElement resetListTop;
    @FindBy(how = How.XPATH, using = ".//div[@class='w3-container'][2]/child::button[1]")
    private WebElement addPersonBottom;
    @FindBy(how = How.XPATH, using = ".//div[@class='w3-container'][2]/child::button[2]")
    private WebElement resetListBottom;


    @FindBy(how = How.XPATH, using = "/html/body/div[2]/h2")
    private WebElement peopleWithJobs;
    @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/ul/li[1]/a")
    private WebElement home;
    @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/ul/li[2]/a")
    private WebElement pageExamples;
    @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/ul/li[3]/a")
    private WebElement tasks;

    @FindBy(how = How.ID, using = "#base_menu")
    private WebElement dropdownOne;
    @FindBy(how = How.XPATH, using = ".//*[@id='base_menu']/a[1]")
    private WebElement locators;
    @FindBy(how = How.XPATH, using = ".//*[@id='base_menu']/a[2]")
    private WebElement actions;
    @FindBy(how = How.XPATH, using = ".//*[@id='base_menu']/a[3]")
    private WebElement alertedPage;
    @FindBy(how = How.XPATH, using = ".//*[@id='base_menu']/a[4]")
    private WebElement alertAndPopUps;
    @FindBy(how = How.XPATH, using = ".//*[@id='base_menu']/a[5]")
    private WebElement styles;
    @FindBy(how = How.XPATH, using = ".//*[@id='base_menu']/a[6]")
    private WebElement synchronization;
    @FindBy(how = How.XPATH, using = ".//*[@id='base_menu']/a[7]")
    private WebElement pageWithLinks;
    @FindBy(how = How.XPATH, using = ".//*[@id='base_menu']/a[8]")
    private WebElement age;
    @FindBy(how = How.XPATH, using = ".//*[@id='base_menu']/a[9]")
    private WebElement colorLoading;

    @FindBy(how = How.ID, using = "#sync_menu")
    private WebElement dropdownTwo;
    @FindBy(how = How.XPATH, using = "//*[@id=\"sync_menu\"]/a[1]")
    private WebElement enterANumber;
    @FindBy(how = How.XPATH, using = "//*[@id=\"sync_menu\"]/a[2]")
    private WebElement differentLocators;
    @FindBy(how = How.XPATH, using = "//*[@id=\"sync_menu\"]/a[3]")
    private WebElement peopleWithJobsList;
    @FindBy(how = How.XPATH, using = "//*[@id=\"sync_menu\"]/a[4]")
    private WebElement peopleList;
    @FindBy(how = How.XPATH, using = "//*[@id=\"sync_menu\"]/a[5]")
    private WebElement feedbackFormPage;

    @FindBy(how = How.CLASS_NAME, using = "copyrights")
    private WebElement copyright;

    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/div/span[1]")
    private WebElement mike;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/div/span[2]")
    private WebElement kid;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/b[1]")
    private WebElement jobOne;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/span[3]")
    private WebElement webDesigner;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/b[2]")
    private WebElement dateOfBirthOne;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/span[4]")
    private WebElement dateOne;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/b[3]")
    private WebElement knowsLanguageOne;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/span[5]")
    private WebElement languageOne;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/b[4]")
    private WebElement genderOne;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/span[3]")
    private WebElement maleOne;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/b[5]")
    private WebElement employeeStatusOne;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/span[7]")
    private WebElement contractor;

    @FindBy(how = How.XPATH, using = "//*[@id=\"person1\"]/div/span[1]")
    private WebElement jill;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person1\"]/div/span[2]")
    private WebElement watson;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person1\"]/b[1]")
    private WebElement jobTwo;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person1\"]/span[3]")
    private WebElement support;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person1\"]/b[2]")
    private WebElement dateOfBirthTwo;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person1\"]/span[4]")
    private WebElement dateTwo;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person1\"]/b[3]")
    private WebElement knowsLanguageTwo;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person1\"]/span[5]")
    private WebElement languageTwo;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person1\"]/b[4]")
    private WebElement genderTwo;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person1\"]/span[6]")
    private WebElement femaleTwo;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person1\"]/b[5]")
    private WebElement employeeStatusTwo;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person1\"]/span[7]")
    private WebElement intern;

    @FindBy(how = How.XPATH, using = "//*[@id=\"person2\"]/div/span[1]")
    private WebElement jane;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person2\"]/div/span[2]")
    private WebElement doe;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person2\"]/b[1]")
    private WebElement jobThree;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person2\"]/span[3]")
    private WebElement accountant;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person2\"]/b[2]")
    private WebElement dateOfBirthThree;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person2\"]/span[4]]")
    private WebElement dateThree;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person2\"]/b[3]")
    private WebElement knowsLanguageThree;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person2\"]/span[5]")
    private WebElement languageThree;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person2\"]/b[4]")
    private WebElement genderThree;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person2\"]/span[6]")
    private WebElement femaleThree;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person2\"]/b[5]")
    private WebElement employeeStatusThree;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person2\"]/span[7]")
    private WebElement employee;

    public void clickHome() {
        home.click();
    }
    public void clickPageExamples() {
        pageExamples.click();
    }

}
