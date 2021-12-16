package home_work.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudPricingCalculatorPage {
    public WebDriver driver;

    @FindBy (xpath = "//*[@track-name='compute engine']")
    private WebElement computeEngine;

    @FindBy (xpath = "(//md-input-container/input)[1]")
    private WebElement numberInstance;



    @FindBy (id="input_1294")
    private WebElement forInstanceField;

    public GoogleCloudPricingCalculatorPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void activateComputerEngine(){
        computeEngine.click();
    }

    public void fillForm(int number, String operatingSystem, String vmClass, MachineType machineType,
                         String gpuType, int gpuNumber, LocalSSD localSSD, String dcLocation, CommitedUsage commitedUsage) {
        setNumberInstance(number);
        setOperatingSystem(operatingSystem);
        setVmClass(vmClass);
        setMachineType(machineType);
        setGPU(gpuType, gpuNumber);
        setLocalSSD(localSSD);
        setDataCenterLocation(dcLocation);
        setCommitedUsage(commitedUsage);
    }

    private void setCommitedUsage(CommitedUsage commitedUsage) {
    }

    private void setDataCenterLocation(String dcLocation) {
    }

    private void setLocalSSD(LocalSSD localSSD) {

    }

    private void setGPU(String gpuType, int gpuNumber) {

    }

    private void setMachineType(MachineType machineType) {

    }

    private void setVmClass(String vmClass) {
    }

    private void setOperatingSystem(String operatingSystem) {
    }

    public void setNumberInstance (int number){
        await(5000);
        numberInstance.click();
        numberInstance.sendKeys(Integer.toString(number));
    }

    public static enum MachineType {
        N1_STANDARD_8("N1", "n1-standard-8 (vCPUs: 8, RAM: 30GB)"),
        N1_STANDARD_16("N1", "n1-standard-16 (vCPUs: 16, RAM: 60GB)");
        public String series;
        public String type;

        MachineType(String series, String type){
            this.series = series;
            this.type = type;
        }
    }

    public static enum LocalSSD {
        L_SSD_1("1x375 GB"),
        L_SSD_2("2x375 GB");
        public String value;

        LocalSSD(String value){
            this.value = value;
        }
    }

    public static enum CommitedUsage {
        NONE("None"),
        YEAR_1("1 Year"),
        YEAR_3("3 Years");
        public String value;

        CommitedUsage(String value){
            this.value = value;
        }
    }

    private void await(long timeInMilles) {
        try {
            Thread.sleep(timeInMilles);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
