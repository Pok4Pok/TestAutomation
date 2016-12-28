package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ChatPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "http://kinoexpert.ru/chat/Default.asp";

    public ChatPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Episode page opened");
    }

    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td")
    private WebElement userLink;

    public String isUserInChat() {
        return userLink.getText();
    }
}

