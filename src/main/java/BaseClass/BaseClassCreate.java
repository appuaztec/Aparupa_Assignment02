package BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseClassCreate {

    /*WebDriver driver;

    @BeforeMethod
    public void setupApplication() {
        Reporter.log("------------Browser session starting------");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://www.goibibo.com/");
        Reporter.log("------------Application started---------");
    }

    @AfterMethod
    public void closeApplication(){
        driver.quit();
        Reporter.log(("----------"));
    }
    */
    private final Logger Log = Logger.getLogger(this.getClass().getName());
    public WebDriver driver = null;

    public BaseClassCreate(Map<String, String> configuration) throws Exception {
        launchBrowser(configuration);
        pageLoadTimeout(this.driver);
    }

    public void pageLoadTimeout(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        long startTime = System.currentTimeMillis();
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("it took " + estimatedTime + " Time");
    }

    public WebDriver launchBrowser(Map<String, String> configuration) {
        String browser = (String) configuration.get("browser");
        if ("chrome".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//drivers//chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get((String) configuration.get("url"));

        } else if ("fireFox".equals(browser)) {
            ;
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get((String) configuration.get("url"));

        }
        return driver;

    }

    public void quitBrowser() {
        driver.quit();


    }

    public WebElement clickOnVisibleButton(String xpath){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
        //element=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(xpath)));
        driver.findElement(By.xpath(xpath)).click();
        return element;
    }

    public WebElement clickOnVisibleButton(By xpath){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(driver.findElement(xpath)));
        //element=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(xpath)));
        driver.findElement(xpath).click();
        return element;
    }

    public void scrollToElement(By prXpath) throws Exception {
        WebElement element = driver.findElement(prXpath);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }

    public void inputDate(By xpath, String value){
        WebDriverWait webDriverWait;
    }


    public String getAttribute(By xpath, String data){
        return driver.findElement(xpath).getAttribute(data);
    }
}
