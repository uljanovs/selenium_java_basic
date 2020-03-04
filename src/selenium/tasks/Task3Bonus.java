package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import selenium.pages.FormPage;
import selenium.pages.ListPage;

import javax.xml.namespace.QName;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

//import pages.FormPage;
//import pages.ListPage;

public class Task3Bonus {
    WebDriver driver;
    static ListPage listPage;
    static FormPage formPage;
    //ListPage listPage = PageFactory.initElements(driver, ListPage.class);
//     should contain what you see when you just open the page (the table with names/jobs)
    //FormPage formPage = PageFactory.initElements(driver, FormPage.class);
//     should be what you see if you click "Add" or "Edit" (2 input field and a button (Add/Edit) and (Cancel)

//    Bonus:
//    try storing people via an Object/separate class

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://uljanovs.github.io/site/tasks/list_of_people");
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
        listPage.clickAdd();
        assertTrue(driver.getCurrentUrl().equals("https://uljanovs.github.io/site/tasks/enter_a_new_person.html"));
        formPage.updateName("Liina");
        formPage.updateSurname("Madeira");
        formPage.updateJob("dancer");

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
        listPage.clickEdit();
        assertTrue(driver.findElement(By.xpath("//*[@id=\"person0\"]/div/span[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//*[@id=\"person1\"]/div/span[1]")).isDisplayed());
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
        listPage.clickEdit();
        formPage.clickCancel();
        assertEquals(driver.findElement(By.linkText("https://uljanovs.github.io/site/tasks/list_of_people")),driver.getCurrentUrl());

    }


    @Test
    public void deletePerson() {
        /* TODO:
         * implement deleting a person using page object
         *
         * in order: store the list of people and jobs currently on page
         * delete 1 person see that there are now 2 people in the table with correct data
         */
        listPage.clickDelete();
        assertTrue(driver.findElement(By.xpath("//*[@id=\"person0\"]/div/span[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//*[@id=\"person1\"]/div/span[1]")).isDisplayed());
    }


    @Test
    public void deletePersonAll() {
        /* TODO:
         * implement deleting a person using page object
         *
         * in order: store the list of people and jobs currently on page
         * delete all people and check that there is no no table on page, but the button Add is still present and working
         */
        listPage.clickDelete();
        listPage.clickdeleete2();
        listPage.clickDelete3();
        assertFalse(driver.findElement(By.xpath("//*[@id=\"listOfPeople\"]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//button[contains(.,'Add')]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//button[contains(.,'Add')]")).isEnabled());
    }
}
