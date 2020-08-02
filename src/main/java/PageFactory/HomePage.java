package PageFactory;

import BaseClass.BaseClassCreate;
import CommonLib.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageXpaths.HomePageXpath;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HomePage implements HomePageXpath {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    public BaseClassCreate baseSession = null;
    public WebDriver driver = null;

    public HomePage(BaseClassCreate session) {
        this.baseSession = session;
        this.driver = session.driver;
    }

    public void verfiyIfUserinHomePage() {
        String url = driver.getCurrentUrl();
        String title = driver.getTitle();
        Assert.assertEquals(url, "https://www.goibibo.com/", "Goibibo URL is different");
        //Assert.assertEquals(title, "", "Title is different");
    }

    public void selectTravelType(String travelType) {
        switch (travelType.toLowerCase()) {
            case "one way":
                baseSession.clickOnVisibleButton(travelOneWay);
                break;
            case "round trip":
                baseSession.clickOnVisibleButton(roundTrip);
                break;
            case "multicity":
                baseSession.clickOnVisibleButton(multiWay);
                break;
        }
    }

    public void source(String arg0) throws Exception{
        driver.findElement(sourceX).sendKeys(arg0);
        String[] s = arg0.split(" ");
        driver.findElement(By.xpath("//div//ul//*[contains(text(),'"+s[0]+"')]")).click();
        LOGGER.log(Level.INFO, "Source City " + arg0);
    }
    public void destination(String arg1) {
        driver.findElement(destinationX).sendKeys(arg1);
        String[] s = arg1.split(" ");
        driver.findElement(By.xpath("//div//ul//*[contains(text(),'"+s[0]+"')]")).click();
        LOGGER.log(Level.INFO, "Destination City " + arg1);
    }

    public void departDate(String arg2) throws Exception {
        driver.findElement(departure).click();

        String monyear = driver.findElement(By.xpath("//div[@class='DayPicker-Month']/div")).getText();

        System.out.println("monyear = " + monyear);

        String currMonthYear = monyear;

        String userMonthYear = DateUtils.getTSinformat(arg2, "dd/MMM/yyyy", "MMMM yyyy");
        String userDate = DateUtils.getTSinformat(arg2, "dd/MMM/yyyy", "dd");

        int total = DateUtils.monthDiff(currMonthYear, "MMMM yyyy", userMonthYear, "MMMM yyyy");

        if(total > 0){
            for (int i = 1; i <= total ; i++) {
                driver.findElement(By.xpath("//div[@class='DayPicker-NavBar']/span[contains(@class,'next')]")).click();
            }
            driver.findElement(By.xpath("//div[@class='DayPicker-Body']//div[text()="+userDate+"]")).click();
        }else if(total == 0){
            driver.findElement(By.xpath("//div[@class='DayPicker-Body']//div[text()="+userDate+"]")).click();
        }else{
            //Err cannot choose previous months
        }



    }

    public void travelClassType(String travelType) {
        WebElement travelClass = driver.findElement(By.xpath("//select[@id='gi_class']"));
        Select select = new Select(travelClass);
        select.selectByValue("Economy");
    }

    public  void travellerDetails(){
        int stradult = 2;
        int strchild = 1;
        int strinfant = 1;

        Assert.assertTrue(((stradult+strchild+strinfant)<=9),"Total Passengers cannot be more than 9");
        Assert.assertTrue((stradult>=1),"An Adult is compulsory with child/infant");
        Assert.assertTrue((stradult>=strinfant),"Infants cannot be more thn adult");

       driver.findElement(adultX).sendKeys(stradult+"");
        driver.findElement(childrenX).sendKeys(strchild+"");
//        driver.findElement(infantX).sendKeys(strinfant+"");

        System.out.println("ADULTS " + driver.findElement(adultX).getText());


    }


    public void clickSearch() {

        baseSession.clickOnVisibleButton(searchButton);
    }


    public void arrivalTime(String arg3) throws Exception{
        driver.findElement(departure).click();

        String monyear = driver.findElement(By.xpath("//div[@class='DayPicker-Month']/div")).getText();

        System.out.println("monyear = " + monyear);

        String currMonthYear = monyear;

        String userMonthYear = DateUtils.getTSinformat(arg3, "dd/MMM/yyyy", "MMMM yyyy");
        String userDate = DateUtils.getTSinformat(arg3, "dd/MMM/yyyy", "dd");

        int total = DateUtils.monthDiff(currMonthYear, "MMMM yyyy", userMonthYear, "MMMM yyyy");

        if(total > 0){
            for (int i = 1; i <= total ; i++) {
                driver.findElement(By.xpath("//div[@class='DayPicker-NavBar']/span[contains(@class,'next')]")).click();
            }
            driver.findElement(By.xpath("//div[@class='DayPicker-Body']//div[text()="+userDate+"]")).click();
        }else if(total == 0){
            driver.findElement(By.xpath("//div[@class='DayPicker-Body']//div[text()="+userDate+"]")).click();
        }else{
            //Err cannot choose previous months
        }
    }
}
