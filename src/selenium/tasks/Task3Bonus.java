package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import pages.FormPage;
//import pages.ListPage;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pages.FormPage;
import selenium.pages.ListPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Task3Bonus {
    WebDriver driver;
    //	ListPage listPage = PageFactory.initElements(driver, ListPage.class);
    ListPage listPage = PageFactory.initElements(driver, ListPage.class);
    //     should contain what you see when you just open the page (the table with names/jobs)

    //	FormPage formPage = PageFactory.initElements(driver, FormPage.class);
    FormPage formPage = PageFactory.initElements(driver, FormPage.class);
//     should be what you see if you click "Add" or "Edit" (2 input field and a button (Add/Edit) and (Cancel)

//    Bonus:
//    try storing people via an Object/separate class

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://uljanovs.github.io/site/tasks/list_of_people");
        listPage = PageFactory.initElements(driver, ListPage.class);
        formPage = PageFactory.initElements(driver, FormPage.class);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void addPerson() {
        /* TODO:
         * implement adding new person using page object
         *
         * in order: store the list of people and jobs currently on page
         * add a person via "Add person button"
         * check the list again, that non of the people where changes, but an additional one with correct name/job was added
         */
        //Adding person - start
        listPage.ResetButtonClick();
        listPage.clickAddPersonButton();
        //on Form Page
        assertEquals("https://uljanovs.github.io/site/tasks/enter_a_new_person.html", driver.getCurrentUrl());
        //Filling Form
        formPage.clickNameField();
        formPage.enterName();
        formPage.clickSurnameField();
        formPage.enterSurname();
        formPage.clickJobField();
        formPage.enterJob();
        formPage.clickDateOfBirthField();
        formPage.enterDateOfBirth();
        formPage.chooseAllLanguages();
        formPage.chooseMaleGender();
        formPage.chooseInternStatus();
        //Adding Person
        formPage.addButtonClick();
        //Back on list of People Page
        assertEquals("https://uljanovs.github.io/site/tasks/list_of_people.html", driver.getCurrentUrl());
        listPage.MikeIsPresentCheck();
        listPage.JillIsPresentCheck();
        listPage.JaneIsPresentCheck();
        listPage.WilliamIsPresentCheck();

    }

    @Test
    public void editPerson() {
        /* TODO:
         * implement editing a person using page object
         *
         * in order: store the list of people and jobs currently on page
         * edit one of existing persons via the edit link
         * check the list again and that 2 people stayed the same and the one used was changed
         */
        //Click Edit
        listPage.ResetButtonClick();
        listPage.clickEdit();
        //Editing Person
        assertEquals("https://uljanovs.github.io/site/tasks/enter_a_new_person.html?id=0", driver.getCurrentUrl());
        formPage.clickNameField();
        formPage.enterName();
        formPage.editButtonClick();
        //Back on List
        assertEquals("https://uljanovs.github.io/site/tasks/list_of_people.html", driver.getCurrentUrl());
        listPage.MikeIsChangedCheck();
        listPage.JillIsPresentCheck();
        listPage.JaneIsPresentCheck();

    }

    @Test
    public void editPersonCancel() {
        /* TODO:
         * implement editing a person using page object
         *
         * in order: store the list of people and jobs currently on page
         * edit one of existing persons via the edit link then click "Cancel" on edit form instead of "Edit"
         * check the list again and that no changes where made
         */
        //Click Edit
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        listPage.ResetButtonClick();
        listPage.clickEdit();
        //Edit Page
        assertEquals("https://uljanovs.github.io/site/tasks/enter_a_new_person.html?id=0", driver.getCurrentUrl());
        formPage.clickNameField();
        formPage.enterName();
        formPage.cancelButtonClick();
        //Back on List Page
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".w3-ul")));
        assertEquals("https://uljanovs.github.io/site/tasks/list_of_people", driver.getCurrentUrl());
        listPage.MikeIsPresentCheck();
        listPage.JillIsPresentCheck();
        listPage.JaneIsPresentCheck();

    }


    @Test
    public void deletePerson() {
        /* TODO:
         * implement deleting a person using page object
         *
         * in order: store the list of people and jobs currently on page
         * delete 1 person see that there are now 2 people in the table with correct data
         */
        //Reset Button Click
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        listPage.ResetButtonClick();
        listPage.clickDelete1();
        //Check Delete
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".w3-ul")));
        assertEquals("https://uljanovs.github.io/site/tasks/list_of_people", driver.getCurrentUrl());
        listPage.MikeDeletedCheck();

    }


    @Test
    public void deletePersonAll() {
        /* TODO:
         * implement deleting a person using page object
         *
         * in order: store the list of people and jobs currently on page
         * delete all people and check that there is no no table on page, but the button Add is still present and working
         */
        //Delete All
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        listPage.ResetButtonClick();
        listPage.clickDelete1();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".w3-ul")));
        listPage.clickDelete2();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".w3-ul")));
        listPage.clickDelete3();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/button[1]")));
        listPage.PeopleListNotDisplayedCheck();
        //Check Delete
        listPage.AddIsDisplayedCheck();
        listPage.ResetIsDisplayedCheck();
        //Reset list
        listPage.ResetButtonClick();
        listPage.MikeIsPresentCheck();
        listPage.JillIsPresentCheck();
        listPage.JaneIsPresentCheck();
    }
}