package AdminPages.RuleEngine.FareRules;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.RuleEngine.TermsAndConditions.TermsAndConditions_Page;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class ActionFareRuleMaster_TC extends TestBase_TC {
    private FareRuleMaster_Page FareRule;
    String Remarks = "Ok";
    private LogIn_Page logIn;

    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }

    @BeforeTest
    public void sign() throws InterruptedException {
        logIn = new LogIn_Page(driver);
        logIn.ClickSuperAdmin();
        logIn.ClickOnLoginButton();
        Thread.sleep(2000);

    }


    @Test(priority =1)
    public void VerifyThumbsUp() throws InterruptedException {
        FareRule = new FareRuleMaster_Page(driver);
        FareRule.NavigateToFareRuleMAster();
        FareRule.ClickOnActiveAndInactive();
        FareRule.ClickOnSearch();
        FareRule.ActiveFare(Remarks);
        FareRule.ClickOnSearch();
        String Expected= "wwe1";
        Thread.sleep(5000);
        assertEquals(FareRule.FareName(), Expected);

    }
    @Test(priority =2)
    public void VerifyThumbsDown() throws InterruptedException {
        FareRule = new FareRuleMaster_Page(driver);
        FareRule.NavigationURLRule();
        FareRule.ClickOnSearch();
        FareRule.RejectFare(Remarks);
        FareRule.ClickOnActiveAndInactive();
        FareRule.ClickOnSearch();
        Thread.sleep(5000);
        String Expected= "wwe1";
        assertEquals(FareRule.FareName(), Expected);
        Thread.sleep(5000);
        FareRule.ActiveFare(Remarks);

    }


    @Test(priority = 3)
    public void ActiveFare() throws InterruptedException {
        FareRule = new FareRuleMaster_Page(driver);
        FareRule.NavigationURLRule();
        FareRule.ClickOnActiveAndInactive();
        FareRule.ClickOnSearch();
        Thread.sleep(5000);
        FareRule.ActiveFare(Remarks);
        String Expected= "wwe1";
        assertEquals(FareRule.FareName(), Expected);


    }
    @Test(priority = 4)
    public void InactiveTerm() throws InterruptedException {
        FareRule = new FareRuleMaster_Page(driver);
        FareRule.NavigationURLRule();
        FareRule.ClickOnSearch();
        FareRule.ClickOnInactiveCircle();
        FareRule.ClickOnActiveAndInactive();
        FareRule.ClickOnSearch();
        Thread.sleep(5000);
        String Expected= "wwe1";
        assertEquals(FareRule.FareName(), Expected);
        FareRule.ClickOnEdit();
        FareRule.ClickOnSendForApprovalEdit();
        Thread.sleep(5000);
        String Expected3 = "http://192.168.1.95/rule-engine/rule-master";
        String Actual = driver.browser().getCurrentURL();
        Assert.assertEquals(Actual, Expected3);
    }

}