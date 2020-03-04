package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListPage {
    WebDriver driver;
    @FindBy(how = How.XPATH, using = "//*[@id='listOfPeople']")
    private WebElement listOfPeople;

    @FindBy(how = How.XPATH, using = "//*[@id='listOfPeople']")
    private WebElement addButton;

    @FindBy(how = How.XPATH, using = "//button[@onclick='resetListOfPeople()']")
    private WebElement resetButton;


}
