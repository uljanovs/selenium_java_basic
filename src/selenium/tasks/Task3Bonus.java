package selenium.tasks;

import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.PageFactory;
import selenium.pages.AgeSamplePage;
import selenium.pages.AgeSubmittedSamplePage;
import selenium.pages.FormPage;
import selenium.pages.ListPage;

public class Task3Bonus {
    static WebDriver driver;

    static ListPage listPage;
    static FormPage formPage;
    //	ListPage
//     should contain what you see when you just open the page (the table with names/jobs)
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

        //implement adding new person using page object
        //store the list of people and jobs currently on page
        Assert.assertEquals("Mike", listPage.name0());
        Assert.assertEquals("Kid", listPage.surname0());
        Assert.assertEquals("Web Designer", listPage.job0());
        Assert.assertEquals("English", listPage.language0());
        Assert.assertEquals("male", listPage.gender0());
        Assert.assertEquals("contractor", listPage.status0());

        Assert.assertEquals("Jill", listPage.name1());
        Assert.assertEquals("Watson", listPage.surname1());
        Assert.assertEquals("Support", listPage.job1());
        Assert.assertEquals("Spanish", listPage.language1());
        Assert.assertEquals("female", listPage.gender1());
        Assert.assertEquals("intern", listPage.status1());

        Assert.assertEquals("Jane", listPage.name2());
        Assert.assertEquals("Doe", listPage.surname2());
        Assert.assertEquals("Accountant", listPage.job2());
        Assert.assertEquals("English, French", listPage.language2());
        Assert.assertEquals("female", listPage.gender2());
        Assert.assertEquals("employee", listPage.status2());

        //add a person via "Add person button"
        listPage.addToList();
        formPage.enterName("Test");
        formPage.enterSurname("Test");
        formPage.enterDateOfBirth("10/10/2010");
        formPage.enterJob("Developer");
        formPage.selectEnglish();
        formPage.selectFrench();
        formPage.selectFemale();
        formPage.selectStatus("Contractor");
        formPage.addPerson();

        //  check the list again, that non of the people where changes, but an additional one with correct name/job was added
        Assert.assertEquals("Mike", listPage.name0());
        Assert.assertEquals("Kid", listPage.surname0());
        Assert.assertEquals("Web Designer", listPage.job0());
        Assert.assertEquals("English", listPage.language0());
        Assert.assertEquals("male", listPage.gender0());
        Assert.assertEquals("contractor", listPage.status0());

        Assert.assertEquals("Jill", listPage.name1());
        Assert.assertEquals("Watson", listPage.surname1());
        Assert.assertEquals("Support", listPage.job1());
        Assert.assertEquals("Spanish", listPage.language1());
        Assert.assertEquals("female", listPage.gender1());
        Assert.assertEquals("intern", listPage.status1());

        Assert.assertEquals("Jane", listPage.name2());
        Assert.assertEquals("Doe", listPage.surname2());
        Assert.assertEquals("Accountant", listPage.job2());
        Assert.assertEquals("English, French", listPage.language2());
        Assert.assertEquals("female", listPage.gender2());
        Assert.assertEquals("employee", listPage.status2());

        Assert.assertEquals("Test",
                driver.findElement(By.xpath("//*[@id=\"person3\"]/div/span[1]")).getAttribute("value"));
        Assert.assertEquals("Test",
                driver.findElement(By.xpath("//*[@id=\"person3\"]/div/span[2]")).getAttribute("value"));
        // etc
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
//      store the list of people and jobs currently on page
            Assert.assertEquals("Mike", listPage.name0());
            Assert.assertEquals("Kid", listPage.surname0());
            Assert.assertEquals("Web Designer", listPage.job0());
            Assert.assertEquals("English", listPage.language0());
            Assert.assertEquals("male", listPage.gender0());
            Assert.assertEquals("contractor", listPage.status0());

            Assert.assertEquals("Jill", listPage.name1());
            Assert.assertEquals("Watson", listPage.surname1());
            Assert.assertEquals("Support", listPage.job1());
            Assert.assertEquals("Spanish", listPage.language1());
            Assert.assertEquals("female", listPage.gender1());
            Assert.assertEquals("intern", listPage.status1());

            Assert.assertEquals("Jane", listPage.name2());
            Assert.assertEquals("Doe", listPage.surname2());
            Assert.assertEquals("Accountant", listPage.job2());
            Assert.assertEquals("English, French", listPage.language2());
            Assert.assertEquals("female", listPage.gender2());
            Assert.assertEquals("employee", listPage.status2());

            //edit one of existing persons via the edit link
        listPage.editPerson0();
        formPage.enterName("John");
        formPage.enterSurname("Doe");
        listPage.submitEditing();
        //check the list again and that 2 people stayed the same and the one used was changed
            Assert.assertEquals("John", listPage.name0());
            Assert.assertEquals("Doe", listPage.surname0());
            Assert.assertEquals("Web Designer", listPage.job0());
            Assert.assertEquals("English", listPage.language0());
            Assert.assertEquals("male", listPage.gender0());
            Assert.assertEquals("contractor", listPage.status0());

            Assert.assertEquals("Jill", listPage.name1());
            Assert.assertEquals("Watson", listPage.surname1());
            Assert.assertEquals("Support", listPage.job1());
            Assert.assertEquals("Spanish", listPage.language1());
            Assert.assertEquals("female", listPage.gender1());
            Assert.assertEquals("intern", listPage.status1());

            Assert.assertEquals("Jane", listPage.name2());
            Assert.assertEquals("Doe", listPage.surname2());
            Assert.assertEquals("Accountant", listPage.job2());
            Assert.assertEquals("English, French", listPage.language2());
            Assert.assertEquals("female", listPage.gender2());
            Assert.assertEquals("employee", listPage.status2());
    }

    @Test
    public void editPersonCancel() throws InterruptedException {
        /* TODO:
         * implement editing a person using page object
         *
         * in order: store the list of people and jobs currently on page
         * edit one of existing persons via the edit link then click "Cancel" on edit form instead of "Edit"
         * check the list again and that no changes where made
         */

       // store the list of people and jobs currently on page
        Assert.assertEquals("Mike", listPage.name0());
        Assert.assertEquals("Kid", listPage.surname0());
        Assert.assertEquals("Web Designer", listPage.job0());
        Assert.assertEquals("English", listPage.language0());
        Assert.assertEquals("male", listPage.gender0());
        Assert.assertEquals("contractor", listPage.status0());

        Assert.assertEquals("Jill", listPage.name1());
        Assert.assertEquals("Watson", listPage.surname1());
        Assert.assertEquals("Support", listPage.job1());
        Assert.assertEquals("Spanish", listPage.language1());
        Assert.assertEquals("female", listPage.gender1());
        Assert.assertEquals("intern", listPage.status1());

        Assert.assertEquals("Jane", listPage.name2());
        Assert.assertEquals("Doe", listPage.surname2());
        Assert.assertEquals("Accountant", listPage.job2());
        Assert.assertEquals("English, French", listPage.language2());
        Assert.assertEquals("female", listPage.gender2());
        Assert.assertEquals("employee", listPage.status2());


        //edit one of existing persons via the edit link then click "Cancel" on edit form instead of "Edit"
        Thread.sleep(7000);
        listPage.editPerson0();
        formPage.enterName("John");
        formPage.enterSurname("Doe");
        formPage.cancel();

        //check the list again and that no changes where made
        Assert.assertEquals("Mike", listPage.name0());
        Assert.assertEquals("Kid", listPage.surname0());
        Assert.assertEquals("Web Designer", listPage.job0());
        Assert.assertEquals("English", listPage.language0());
        Assert.assertEquals("male", listPage.gender0());
        Assert.assertEquals("contractor", listPage.status0());

        Assert.assertEquals("Jill", listPage.name1());
        Assert.assertEquals("Watson", listPage.surname1());
        Assert.assertEquals("Support", listPage.job1());
        Assert.assertEquals("Spanish", listPage.language1());
        Assert.assertEquals("female", listPage.gender1());
        Assert.assertEquals("intern", listPage.status1());

        Assert.assertEquals("Jane", listPage.name2());
        Assert.assertEquals("Doe", listPage.surname2());
        Assert.assertEquals("Accountant", listPage.job2());
        Assert.assertEquals("English, French", listPage.language2());
        Assert.assertEquals("female", listPage.gender2());
        Assert.assertEquals("employee", listPage.status2());


    }


    @Test
    public void deletePerson() {
        /* TODO:
         * implement deleting a person using page object
         *
         * in order: store the list of people and jobs currently on page
         * delete 1 person see that there are now 2 people in the table with correct data
         */
        //store the list of people and jobs currently on page
        Assert.assertEquals("Mike", listPage.name0());
        Assert.assertEquals("Kid", listPage.surname0());
        Assert.assertEquals("Web Designer", listPage.job0());
        Assert.assertEquals("English", listPage.language0());
        Assert.assertEquals("male", listPage.gender0());
        Assert.assertEquals("contractor", listPage.status0());

        Assert.assertEquals("Jill", listPage.name1());
        Assert.assertEquals("Watson", listPage.surname1());
        Assert.assertEquals("Support", listPage.job1());
        Assert.assertEquals("Spanish", listPage.language1());
        Assert.assertEquals("female", listPage.gender1());
        Assert.assertEquals("intern", listPage.status1());

       // Assert.assertFalse(listPage.name2().is);
        Assert.assertEquals("Doe", listPage.surname2());
        Assert.assertEquals("Accountant", listPage.job2());
        Assert.assertEquals("English, French", listPage.language2());
        Assert.assertEquals("female", listPage.gender2());
        Assert.assertEquals("employee", listPage.status2());

        //implement deleting a person using page object
        listPage.deletePerson0();
    }


    @Test
    public void deletePersonAll() {
        /* TODO:
         * implement deleting a person using page object
         *
         * in order: store the list of people and jobs currently on page
         * delete all people and check that there is no no table on page, but the button Add is still present and working
         */
//      store the list of people and jobs currently on page
        Assert.assertEquals("Mike", listPage.name0());
        Assert.assertEquals("Kid", listPage.surname0());
        Assert.assertEquals("Web Designer", listPage.job0());
        Assert.assertEquals("English", listPage.language0());
        Assert.assertEquals("male", listPage.gender0());
        Assert.assertEquals("contractor", listPage.status0());

        Assert.assertEquals("Jill", listPage.name1());
        Assert.assertEquals("Watson", listPage.surname1());
        Assert.assertEquals("Support", listPage.job1());
        Assert.assertEquals("Spanish", listPage.language1());
        Assert.assertEquals("female", listPage.gender1());
        Assert.assertEquals("intern", listPage.status1());

        Assert.assertEquals("Jane", listPage.name2());
        Assert.assertEquals("Doe", listPage.surname2());
        Assert.assertEquals("Accountant", listPage.job2());
        Assert.assertEquals("English, French", listPage.language2());
        Assert.assertEquals("female", listPage.gender2());
        Assert.assertEquals("employee", listPage.status2());

        //implement deleting a person using page object
        listPage.deletePerson0();
        listPage.deletePerson1();
        listPage.deletePerson2();
    }
}
