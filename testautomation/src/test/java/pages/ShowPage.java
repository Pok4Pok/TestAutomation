package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShowPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "http://kinoexpert.ru/index.asp?comm=26&id={D5EB6CB9-63C8-4C2A-8D32-42400AD94E72}";
    public ShowPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Show page opened");
    }

    @FindBy(name="obzbody")
    private WebElement commentArea;

    @FindBy(xpath = "/html/body/table[3]/tbody/tr/td[3]/table[5]/tbody/tr[2]/td/input[3]")
    private WebElement buttonAddComment;

    @FindBy(xpath = "/html/body/table[3]/tbody/tr/td[3]/table[4]/tbody/tr[2]/td/div[2]/a[1]")
    private WebElement linkCommentAdd;

    public void addComment(String comment){
        commentArea.sendKeys(comment);
        buttonAddComment.click();
    }

    public String getLoggedInUserName() {

        return linkCommentAdd.getText();
    }
    }
