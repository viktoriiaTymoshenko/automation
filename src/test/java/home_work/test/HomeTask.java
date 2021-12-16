package home_work.test;

import home_work.page.CloudGoogleMainPage;
import home_work.page.GoogleCloudPricingCalculatorPage;
import home_work.page.PastebinResultPage;
import home_work.page.StartPagePastebin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeTask {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().window().getPosition();
    }


    @Test
    public void iCanWin () {
        StartPagePastebin startPagePastebin = new StartPagePastebin(driver);
        startPagePastebin.openHomePage();
        startPagePastebin.createNewPaste("Hello from WebDriver", "10 Minutes", "helloweb");
    }

    @Test
    public void bringItOn() {
        String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String expiration = "10 Minutes";
        String title = "how to gain dominance among developers";
        String highlighting = "Bash";


        StartPagePastebin startPagePastebin = new StartPagePastebin(driver);
        startPagePastebin.openHomePage();
        startPagePastebin.createNewPaste(code, expiration, title, highlighting);
        PastebinResultPage resultPage = new PastebinResultPage(driver);

      //  Assert.assertTrue(resultPage.getTitle().startsWith(title));
        Assert.assertEquals(resultPage.getTitle().startsWith(title),title);
        Assert.assertEquals(resultPage.getSyntax(), highlighting);
        Assert.assertEquals(resultPage.getCode(), code);
    }

    @Test
    public void hurtMePlently() {
        CloudGoogleMainPage cloudGoogleMainPage = new CloudGoogleMainPage(driver);
        cloudGoogleMainPage.openHomePage();
        cloudGoogleMainPage.search("Google Cloud Platform Pricing Calculator");
        cloudGoogleMainPage.openLinkInSearchResult();
        GoogleCloudPricingCalculatorPage googleCloudPricingCalculatorPage = new GoogleCloudPricingCalculatorPage(driver);
        googleCloudPricingCalculatorPage.activateComputerEngine();
        googleCloudPricingCalculatorPage.fillForm('4', null, null, null, null, 4, null, null, null);

        holdFor(5000);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver=null;
    }

    private void holdFor(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
