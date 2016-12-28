package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PicturePage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "http://kinoexpert.ru/oboirate.asp?img=f09184_3.jpg&rate=4";

    public PicturePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Picture page opened");
    }

    @FindBy(id = "r5")
    private WebElement pictureRate;

    @FindBy(xpath = "/html/body/div[2]/input[6]")
    private WebElement buttonRate;

    @FindBy(xpath = "/html/body/div[2]/font[3]")
    private WebElement numberOfRates;

    public String addRateToPicture() {

        pictureRate.click();
        buttonRate.click();
        return numberOfRates.getText();
    }

    public String isRateAdd(){
        return numberOfRates.getText();
    }
}
