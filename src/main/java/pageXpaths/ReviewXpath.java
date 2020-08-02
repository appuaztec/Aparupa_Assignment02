package pageXpaths;

import org.openqa.selenium.By;

public interface ReviewXpath {

    public By travelClass = By.xpath("(//div[@class='fl width100 padTB10']/div[2]//span)[3]");
    public By flightName = By.xpath("(//div[@class='fl width100 padTB10']/div[2]//span)[2]");
    public By flightNumberCheck= By.xpath("(//div[@class='fl width100 padTB10']/div[2]//span)[4]");
    public By timeDep = By.xpath("(//div[@class='fl width100 padTB10']/div[2]//span)[8]");
    public By timeArr = By.xpath("(//div[@class='fl width100 padTB10']/div[2]//span)[18]");
    public By timeDur = By.xpath("(//div[@class='fl width100 padTB10']/div[2]//span)[14]");
    public By srcDest = By.xpath("(//div[@class='fl width100 padTB10']//span)[1]");
}
