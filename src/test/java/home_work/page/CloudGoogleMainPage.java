package home_work.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CloudGoogleMainPage {
    public WebDriver driver;

    private String url = "https://cloud.google.com/";

    @FindBy (xpath = "//*[@aria-label='Search']")
    private WebElement searchField;

    @FindBy (linkText = "Google Cloud Platform Pricing Calculator")
    private WebElement linkName;

    public CloudGoogleMainPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void search (String searchValue){
        searchField.sendKeys(searchValue);
        searchField.sendKeys(Keys.ENTER);
    }

    public void openLinkInSearchResult (){
       linkName.click();

    }

    public void openHomePage() {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


}
