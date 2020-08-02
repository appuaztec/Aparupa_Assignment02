package pageXpaths;

import org.openqa.selenium.By;

public interface HomePageXpath {

    public By travelOneWay = By.xpath("//span[text()='One way']");
    public By multiWay = By.xpath("//span[text()='Multicity']");
    public By roundTrip = By.xpath("//span[text()='Round trip']");
    // public By multiWay = By.xpath("//span[text()='Multicity']");
    public By sourceX = By.xpath("//input[@type='text' and contains(@placeholder,'From')]");
    public By destinationX = By.xpath("//input[@type='text' and contains(@placeholder,'Destination')]");
    public By departure = By.xpath("//input[@type='text' and contains(@placeholder,'Departure')]");
    public By departCal = By.xpath("//div[@class='DayPicker-Caption' and @role='heading']");
    public By calenderMonth = By.xpath("//div[@class='DayPicker-Month']");
    public By calenderDay = By.xpath("//div[@class='DayPicker-Body']");
    public By calenderWeek = By.xpath("//div[@class='DayPicker-Week']");
    public By travelers = By.xpath("//span[@id='pax_label']");
    public By adultX = By.xpath("//input[@id='adultPaxBox']");
    public By childrenX = By.xpath("//input[@id='childPaxBox']");
    public By infantX = By.xpath("//input[@id='infantPaxBox']");
    public By searchButton = By.xpath("//button[text()='SEARCH']");
    public By classEconomy = By.xpath("//select[@id='gi_class']/option[1]");
    public By classBusiness = By.xpath("//select[@id='gi_class']/option[2]");





}
