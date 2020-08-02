package PageFactory;

import BaseClass.BaseClassCreate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageXpaths.FlightXpath;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlightDetails implements FlightXpath {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    public BaseClassCreate baseSession = null;
    public WebDriver driver = null;

    public FlightDetails(BaseClassCreate session) {
        this.baseSession = session;
        this.driver = session.driver;
    }

    public Map<String, String> flightInfo() throws Exception {

        Map<String,String> details = new HashMap<>();

        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='PRICE']/span/i")));

     baseSession.scrollToElement(By.xpath("//li[@id='PRICE']"));

        String s = element.getAttribute("class");
        if(!s.contains("up")){
            driver.findElement(By.xpath("//li[@id='PRICE']")).click();
        }

        baseSession.scrollToElement(flightName);;

        Thread.sleep(2000);

        String fName = driver.findElement(flightName).getText();
        String fNum = driver.findElement(flightNumber).getAttribute("data-cy");
        String data[] = fNum.split(":");
        fNum = data[1];
        String fdepartureTime = driver.findElement(departureTime).getText();
        String ftotalTravelTime = driver.findElement(totalTravelTime).getText();
        String farrivalTime = driver.findElement(arrivalTime).getText();
        String flayOverDetails= driver.findElement(layOverDetails).getText();
        String fticketPrice = driver.findElement(ticketPrice).getText();


        details.put("FlightName",fName);
        details.put("FlightNumber",fNum);
        details.put("DepartTime",fdepartureTime);
        details.put("TotalTravel",ftotalTravelTime);
        details.put("ArrTime",farrivalTime);
        details.put("Layover",flayOverDetails);
        details.put("TicketPrice",fticketPrice);

        baseSession.scrollToElement(bookTicket);;

        driver.findElement(bookTicket).click();



        LOGGER.log(Level.INFO, " The Book button is clicked in the flight details page ");
        return details;
    }


    public Map<String, String> flightInfoRoundTrip() throws Exception{

        Map<String,String> details = new HashMap<>();

        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='PRICE']/span/i")));

        baseSession.scrollToElement(By.xpath("//li[@id='PRICE']"));

        String s = element.getAttribute("class");
        if(!s.contains("up")){
            driver.findElement(By.xpath("//li[@id='PRICE']")).click();
        }

        baseSession.scrollToElement(flightName);;

        Thread.sleep(2000);
        //Flight 1

        String fName = driver.findElement(flightName).getText();
        String fNum = driver.findElement(flightNumber).getAttribute("data-cy");
        String data[] = fNum.split(":");
        fNum = data[1];
        String fdepartureTime = driver.findElement(departureTime).getText();
        String ftotalTravelTime = driver.findElement(totalTravelTime).getText();
        String farrivalTime = driver.findElement(arrivalTime).getText();
        String flayOverDetails= driver.findElement(layOverDetails).getText();
        String fticketPrice = driver.findElement(ticketPrice).getText();


        details.put("FlightName",fName);
        details.put("FlightNumber",fNum);
        details.put("DepartTime",fdepartureTime);
        details.put("TotalTravel",ftotalTravelTime);
        details.put("ArrTime",farrivalTime);
        details.put("Layover",flayOverDetails);
        details.put("TicketPrice",fticketPrice);

        baseSession.scrollToElement(bookTicket);;

        driver.findElement(bookTicket).click();



        LOGGER.log(Level.INFO, " The Book button is clicked in the flight details page ");
        return details;
    }
}
