package StepDefinitions;

import BaseClass.BaseClassCreate;
import PageFactory.FlightDetails;
import PageFactory.HomePage;
import PageFactory.ReviewPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;


import java.util.HashMap;
import java.util.Map;

public class StepInit {

    public static BaseClassCreate baseClassCreate = null;
    public static HomePage homePage= null;
    public static FlightDetails flightDetails = null ;
    public  static ReviewPage reviewPage = null;


    @Before
    public void cBefore() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("browser","chrome");
        map.put("url","https://www.goibibo.com/");
        baseClassCreate = new BaseClassCreate(map);
        homePage = new HomePage(baseClassCreate);
        flightDetails = new FlightDetails(baseClassCreate);
        reviewPage = new ReviewPage(baseClassCreate);
    }



    @After
    public void cAfter(){

        //baseClassCreate.quitBrowser();
    }
}
