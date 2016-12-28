import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.Steps;


public class TestAutomation {
    private Steps steps;
    private final String EMAIL = "pokinutii@gmail.com";
    private final String USERNAME = "testerok";
    private final String PASSWORD = "qwerty123";
    private final String NAME = "День сурка";
    private final String COMMENT = "Ужас";
    private final String CHATNIK = "Drug";
    private final String TEXT = "Добрейший вечерочек";


    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "Login to Site")
    public void LoginToSite(){
        steps.LoginInSite(EMAIL, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }

    @Test(description = "Finding День сурка")
    public void FindInSite(){
        steps.LoginInSite(EMAIL, PASSWORD);
        steps.FindShow(NAME);
        Assert.assertTrue(steps.isFindIn(NAME));
    }

    @Test (description = "Add comment")
    public void AddCommentToSite(){
        steps.LoginInSite(EMAIL, PASSWORD);
        steps.AddComment(COMMENT);
        Assert.assertTrue(steps.isCommentAdd(USERNAME));
    }

    @Test (description = "Going to Chat")
    public void GoToChat(){
        steps.LoginInSite(EMAIL, PASSWORD);
        steps.ChatMessage(CHATNIK);
        steps.isChat(CHATNIK);
    }

    @Test (description = "Add rate to picture")
    public void AddRateToPicture(){
        steps.LoginInSite(EMAIL, PASSWORD);
        steps.AddRateToPicture();
        }
    @Test (description = "Check our Rate")
    public void CheckRatePicture(){
        steps.LoginInSite(EMAIL, PASSWORD);
        steps.AddRateToPicture();
        Assert.assertTrue(steps.isRateAdded());
    }

    @Test (description = "Discussion in the Site")
    public void Discussion(){
        steps.GoToDiscussion(USERNAME,EMAIL,TEXT,PASSWORD);
        steps.LoginInSite(EMAIL, PASSWORD);
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
