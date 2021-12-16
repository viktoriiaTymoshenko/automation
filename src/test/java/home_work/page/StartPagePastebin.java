package home_work.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class StartPagePastebin {
    public WebDriver driver;

    private String url = "https://pastebin.com/";

    @FindBy (id = "postform-text")
    private WebElement codeField;

    @FindBy (id = "select2-postform-format-container")
    private WebElement syntaxHighlightingField;

    @FindBy (id= "select2-postform-expiration-container")
    private WebElement pasteExpirationField;

    @FindBy (id = "postform-name")
    private WebElement pasteNameField;

    @FindBy (xpath = "//button[text()='Create New Paste']")
    private WebElement btnCreateNewPaste;


    public StartPagePastebin(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void createNewPaste(String code, String expiration, String title, String highlighting) {
        setCode(code);
        if (highlighting != null && !highlighting.isEmpty()) {
            setSyntaxHighlighting(highlighting);
        }
        setPasteExpiration(expiration);
        setPasteName(title);
        createNewPaste();
    }

    public void createNewPaste(String code, String expiration, String title) {
        createNewPaste(code, expiration, title, null);
    }

    public void setCode(String code) {

        codeField.sendKeys(code);
    }

    public void setSyntaxHighlighting(String highlighting) {
        awaitToBeClickable(syntaxHighlightingField);
        String xpathValue = String.format("//*[@class=\"select2-results__option\" and text()='%s']", highlighting);
        syntaxHighlightingField.click();
        WebElement dropDownValue = driver.findElement(By.xpath(xpathValue));
        await(3000);
        dropDownValue.click();
    }

    public void setPasteExpiration(String expiration){
        awaitToBeClickable(pasteExpirationField);
        String xpathValue = String.format("//*[@class=\"select2-results__option\" and text()='%s']", expiration);
        pasteExpirationField.click();
        WebElement dropDownValue = driver.findElement(By.xpath(xpathValue));
        await(3000);
        dropDownValue.click();

    }

    public void setPasteName(String title){
        pasteNameField.sendKeys(title);
    }

    public void createNewPaste(){
        awaitToBeClickable(btnCreateNewPaste);
        btnCreateNewPaste.click();
    }

    private void awaitToBeClickable(WebElement webElement) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    private void await(long timeInMilles) {
        try {
            Thread.sleep(timeInMilles);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
