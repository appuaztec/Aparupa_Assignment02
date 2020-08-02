package pageXpaths;

import org.openqa.selenium.By;

public interface FlightXpath {

    public By price = By.xpath("//li[@id='PRICE']");
    public By priceUp = By.xpath("//i[@class='ico13 icon-arrow2-up hpyBlueLt ']");
    //public By pricedown = By.xpath("//i[contains(@class,'ico13 icon-arrow2-down hpyBlueLt')]")
    public By BookBtn = By.xpath("//div[@class='paleGreyBg2 width100 fl']//div[1]//div[1]//div[1]//div[1]//div[2]//span[1]//span[1]//input[1]");

    public By flightName = By.xpath("(//div[@class='marginB10']/div//img[@alt='flights']/../span)[1]");
    public By flightNumber = By.xpath("(//div[@class='marginB10']/div)[1]");
    public By departureTime = By.xpath("(//div[@class='marginB10']/div//span[@data-cy='depTime'])[1]");
    public By totalTravelTime = By.xpath("(//div[@class='marginB10']/div//div[@data-cy='duration'])[1]");
    public By arrivalTime = By.xpath("(//div[@class='marginB10']/div//span[@data-cy='arrTime'])[1]");
    public By layOverDetails= By.xpath("(//div[@class='marginB10']/div//div[contains(text(),'Layover')])[1]");
    public By ticketPrice = By.xpath("(//div[@class='marginB10']/div//span[@data-cy='finalPrice'])[1]");
    public By bookTicket = By.xpath("(//div[@class='marginB10']/div//input[@data-cy='bookBtn'])[1]");

}
