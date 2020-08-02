package StepDefinitions;

import CommonLib.DateUtils;
import PageFactory.FlightDetails;
import PageFactory.HomePage;
import PageFactory.ReviewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

public class MyStepdefs {

    WebDriver driver = StepInit.baseClassCreate.driver;
    HomePage homePage = StepInit.homePage;
    FlightDetails flightDetails = StepInit.flightDetails;
    ReviewPage reviewPage = StepInit.reviewPage;

    Map<String,String> flightData = null;
    String src = null;
    String dest = null;
    String travClass = null;

    @Given("User in GoIbibo page")
    public void userInGoIbiboPage() {
        homePage.verfiyIfUserinHomePage();
    }

    @And("choose type of travel {string}")
    public void chooseTypeOfTravel(String arg0) {
        homePage.selectTravelType(arg0);
    }

    @And("Select source {string}, {string} and {string}")
    public void selectwayType(String arg0, String arg1, String arg2) throws Exception {
        this.src = arg0;
        this.dest = arg1;
        homePage.source(arg0);
        homePage.destination(arg1);
        homePage.departDate(arg2);

    }

    @And("Select the traveller details {string}, {string} and {string}")
    public void selectTheTravellerDetailsAnd(String arg0, String arg1, String arg2) throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='pax_link_common']")).click();
        Thread.sleep(3000);
       // homePage.travellerDetails();
    }

    @And("Select travel classtype {string}")
    public void selectTravelClasstype(String arg0) {
        this.travClass = arg0;
       // homePage.travelClassType(arg0);
    }

    @And("Click on Search")
    public void clickOnSearch() {
        homePage.clickSearch();
    }

    @And("find the cheapest price and click on Book now button")
    public void findTheCheapestPriceandClickOnBookNowButton() throws Exception {
        this.flightData = flightDetails.flightInfo();
        this.flightData.put("travelClass",this.travClass);
        this.flightData.put("src",this.src);
        this.flightData.put("dest",this.dest);
    }

    @Then("Verify the details on Review page")
    public void verifyTheDetailsOnReviewPage() {
        reviewPage.goToReviewPage();
        reviewPage.perfromValidation(this.flightData);
    }

    @And("Select source, destinations and departure date")
    public void selectSourceDestinationsAndDepartureDate() {

    }


    @And("Select source {string}, {string} and {string} , {string}")
    public void selectSourceAnd(String arg0, String arg1, String arg2, String arg3)  throws Exception{
        this.src = arg0;
        this.dest = arg1;
        homePage.source(arg0);
        homePage.destination(arg1);
        homePage.departDate(arg2);

        int val = DateUtils.monthDiff(arg2,"dd/MMM/yyyy"
                ,arg3,"dd/MMM/yyyy");

        String dd1 = DateUtils.getDate(arg2,"dd/MMM/yyyy","dd");
        String dd2 = DateUtils.getDate(arg3,"dd/MMM/yyyy","dd");

        Assert.assertTrue((val>=0) && (Integer.parseInt(dd2)>=Integer.parseInt(dd1)),
                "Arrival Date should be equal/greater than departure date");


        homePage.arrivalTime(arg3);
    }

    @And("find the cheapest price for both flights and click on Book now button")
    public void findTheCheapestPriceForBothFlightsAndClickOnBookNowButton() throws Exception {
        this.flightData = flightDetails.flightInfoRoundTrip();
        this.flightData.put("travelClass",this.travClass);
        this.flightData.put("src",this.src);
        this.flightData.put("dest",this.dest);

    }

    @Then("Verify the details for both flights on Review page")
    public void verifyTheDetailsForBothFlightsOnReviewPage() {
        reviewPage.goToReviewPage();
        reviewPage.perfromValidationRoundTrip(this.flightData);
    }
}
