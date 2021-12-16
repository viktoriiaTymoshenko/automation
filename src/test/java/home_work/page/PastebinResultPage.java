package home_work.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinResultPage {
    public WebDriver driver;

    @FindBy (xpath = "//*[@class='highlighted-code']//*[@class='left']/a")
    private WebElement syntax;

    @FindBy (className = "textarea")
    private WebElement code;


    public PastebinResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getSyntax() {
        return syntax.getText();
    }

    public String  getCode() {
       return code.getText();
    }
}
