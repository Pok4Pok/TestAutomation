package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DiscussionPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "http://kinoexpert.ru/topics.asp?topID=4&sort=1&page=1";

    public DiscussionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Picture page opened");
    }

    @FindBy(xpath = "/html/body/table[2]/tbody/tr[19]/td[2]/a")
    private WebElement linkDiscussion;

    @FindBy(name="name")
    private WebElement disName;

    @FindBy(name="email")
    private WebElement disEmail;

    @FindBy(name="message")
    private WebElement disText;

    @FindBy(name="pasword")
    private WebElement disPassword;

    @FindBy(name="Submit2")
    private WebElement buttonSubmit;


    public void goToDiscussion(String nik, String email, String text, String password) {

        linkDiscussion.click();
        disName.sendKeys(nik);
        disEmail.sendKeys(email);
        disText.sendKeys(text);
        disPassword.sendKeys(password);
        buttonSubmit.click();

    }

}
