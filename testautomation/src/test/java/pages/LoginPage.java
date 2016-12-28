package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "http://kinoexpert.ru/";


    @FindBy(xpath = "/html/body/div[3]/header/div[2]/ul/li[1]/noindex/a")
    private WebElement buttonLogin;


    @FindBy(name = "email")
    private WebElement inputLogin;

    @FindBy(name = "password")
    private WebElement inputPassword;

    @FindBy(xpath = "/html/body/table[3]/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/input[3]")
    private WebElement buttonSubmit;

    @FindBy(xpath = "/html/body/table[3]/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/b/i")
    private WebElement linkLoggedInUser;

    @FindBy(name = "film")
    private WebElement findingString;

    @FindBy(xpath = "/html/body/table[3]/tbody/tr/td[3]/table[1]/tbody/tr[1]/td[1]/table/tbody/tr/td/div/table/tbody/tr[1]/td[1]/img")
    private WebElement buttonFind;

    @FindBy(xpath = "/html/body/table[3]/tbody/tr/td[3]/a[58]/table/tbody/tr/td/p[1]/table/tbody/tr[2]/td[1]/a")
    private WebElement chooseShow;

    @FindBy(xpath = "/html/body/table[3]/tbody/tr/td[3]/table[3]/tbody/tr[2]/td[1]/form/div/b/i")
    private WebElement linkFindingInSite;

    @FindBy(xpath = "/html/body/table[2]/tbody/tr[4]/td[4]/a[4]")
    private WebElement linkChat;

    @FindBy(name = "username")
    private WebElement chatUserName;

    @FindBy(name="login")
    private WebElement buttonLoginChat;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/input")
    private WebElement chatMessage;

    @FindBy(name="submit")
    private WebElement chatSubmit;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }

    public void login(String email, String password) {
        inputLogin.sendKeys(email);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        logger.info("Login performed");
    }

    public String getLoggedInUserName() {

        return linkLoggedInUser.getText();
    }


    public void find(String name) {
        findingString.sendKeys(name);
        buttonFind.click();
        chooseShow.click();
        chooseShow.click();
        logger.info("Show performed");
    }

    public String getFindingInSite() {

        return linkFindingInSite.getText();
    }

    public void chat(String username) {
        linkChat.click();
        chatUserName.sendKeys(username);
        buttonLoginChat.click();
    }
}
