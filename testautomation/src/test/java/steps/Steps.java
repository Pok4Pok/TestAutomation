package steps;

import driver.DriverWorker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.*;


public class Steps {
    private WebDriver driver;
    String Rate;
    private final Logger logger = LogManager.getRootLogger();

    public void initBrowser()
    {   driver = DriverWorker.getDriver(); }

    public void closeDriver()
    {
        DriverWorker.closeDriver();
    }

    public void LoginInSite(String email, String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(email, password);
    }

    public boolean isLoggedIn(String username)
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.getLoggedInUserName().trim().toLowerCase().equals(username));
    }

    public void FindShow (String name){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.find(name);
    }

    public boolean isFindIn(String name){
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.getFindingInSite().equals(name));
    }

    public void AddComment(String comment){
        ShowPage showPage = new ShowPage(driver);
        showPage.openPage();
        showPage.addComment(comment);
    }

    public boolean isCommentAdd(String username)
    {
        ShowPage showPage = new ShowPage(driver);
        return (showPage.getLoggedInUserName().trim().toLowerCase().equals(username));
    }

    public void ChatMessage(String username){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.chat(username);
    }

    public boolean isChat(String username){
        ChatPage chatPage = new ChatPage(driver);
        return (chatPage.isUserInChat().trim().toLowerCase().equals(username));
    }

    public String  AddRateToPicture(){
        PicturePage picturePage = new PicturePage(driver);
        picturePage.openPage();
        return Rate = picturePage.addRateToPicture();
    }

    public boolean isRateAdded(){
        PicturePage picturePage = new PicturePage(driver);
        return (!(picturePage.isRateAdd().trim().toLowerCase()).equals(Rate));
    }

    public void GoToDiscussion(String nik, String emal, String text, String password){
        DiscussionPage discussionPage = new DiscussionPage(driver);
        discussionPage.openPage();
        discussionPage.goToDiscussion(nik,emal,text,password);
    }
}
