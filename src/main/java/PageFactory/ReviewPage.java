package PageFactory;

import BaseClass.BaseClassCreate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageXpaths.FlightXpath;
import pageXpaths.ReviewXpath;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReviewPage implements ReviewXpath {

        private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
        public BaseClassCreate baseSession = null;
        public WebDriver driver = null;

        public ReviewPage(BaseClassCreate session) {
            this.baseSession = session;
            this.driver = session.driver;
        }



    public void perfromValidation(Map<String,String> flightDetails) {
        Map<String,String> reviewflightDetails = new HashMap<>();
        String stravelClass = driver.findElement(travelClass).getText();
        String sflightName = driver.findElement(flightName).getText();
        String sflightNumberCheck = driver.findElement(flightNumberCheck).getText();
        String stimeDep = driver.findElement(timeDep).getText();
        String stimeArr = driver.findElement(timeArr).getText();
        String stimeDur = driver.findElement(timeDur).getText();
        String ssrcDest = driver.findElement(srcDest).getText();

        reviewflightDetails.put("rTravelClass",stravelClass);
        sflightNumberCheck = sflightNumberCheck.replace("(","").replace(")","").replace("-","");
        reviewflightDetails.put("rFnum",sflightNumberCheck);
        reviewflightDetails.put("rTimeDep",stimeDep);
        reviewflightDetails.put("rTimeArr",stimeArr);
        reviewflightDetails.put("rTimeDurr",stimeDur);
        String[] data = ssrcDest.split("-");
        String src = data[0].trim();
        String[] destData = data[1].split(" ");
        String dest = destData[1].trim();
        reviewflightDetails.put("rSrc",src);
        reviewflightDetails.put("rDest",dest);
        reviewflightDetails.put("rFname",sflightName);

        System.out.println(flightDetails);
        System.out.println(reviewflightDetails);



        Assert.assertEquals((flightDetails.get("src")).toLowerCase(),
               (reviewflightDetails.get("rSrc")).toLowerCase(),"Source is Different");
        Assert.assertEquals((flightDetails.get("dest")).toLowerCase(),
                (reviewflightDetails.get("rDest")).toLowerCase(),"Destination is Different");
        Assert.assertEquals((flightDetails.get("travelClass")).toLowerCase(),
                (reviewflightDetails.get("rTravelClass")).toLowerCase(), "Travel Class is Different");
        Assert.assertEquals((flightDetails.get("FlightName")).toLowerCase(),
                (reviewflightDetails.get("rFname")).toLowerCase(),"Flight Name is Different");
        Assert.assertEquals((flightDetails.get("FlightNumber")).toLowerCase(),
                (reviewflightDetails.get("rFnum")).toLowerCase(),"Flight Number is Different");
        Assert.assertEquals((flightDetails.get("DepartTime")).toLowerCase(),
                (reviewflightDetails.get("rTimeDep")).toLowerCase(),"Departure Time is Different");
        Assert.assertEquals((flightDetails.get("rTimeArr")).toLowerCase(),
                (reviewflightDetails.get("rFnum")).toLowerCase(),"Arrival Time is Different");
        Assert.assertEquals((flightDetails.get("TotalTravel")).toLowerCase(),
                (reviewflightDetails.get("rTimeDurr")).toLowerCase(),"Total Travel Time is Different");

        LOGGER.log(Level.INFO,"TicketPrice=" + flightDetails.get("TicketPrice"));

    }

    public void goToReviewPage() {

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> I1 = windowHandles.iterator();

        String firstWindow = I1.next();
        String secondWindow = I1.next();

        driver.switchTo().window(secondWindow);
    }

    public void perfromValidationRoundTrip(Map<String, String> flightData) {
            //Round Trip
    }
}

