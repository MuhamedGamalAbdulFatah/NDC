package AdminPages.RuleEngine.FareRules;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.RuleEngine.TermsAndConditions.TermsAndConditions_Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class CreateFareRuleMaster_TC extends TestBase_TC {

    private FareRuleMaster_Page FareRule;
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


    @Test(priority = 1)
    public void VerifyErrorMessages() throws InterruptedException {
        FareRule = new FareRuleMaster_Page(driver);
        FareRule.NavigateToFareRuleMAster();
        FareRule.ClickOnAdd();
        FareRule.ClickOnSendForApprovalAdd();
        String Expected ="Required";
        String Expected2 ="required";
        String Expected3 ="required";
        String Expected4 ="required";
        Assert.assertEquals(FareRule.ActualResult(),Expected);
        Assert.assertEquals(FareRule.ActualResult2(),Expected2);
        Assert.assertEquals(FareRule.ActualResult3(),Expected3);
        Assert.assertEquals(FareRule.ActualResult4(),Expected4);
        Thread.sleep(2000);

    }

    @Test(priority = 2, dataProvider = "JsonProvider")
    public void CreateFareRuleMaster(Map<String,String> Create) throws InterruptedException {
        FareRule = new FareRuleMaster_Page(driver);
        FareRule.NavigationURLRule();
        FareRule.ClickOnAdd();
        String SelectSupplier = Create.get("SelectSupplier");
        FareRule.ChooseSupplier(SelectSupplier);
        FareRule.ChooseAllCountryFrom();
        FareRule.ChooseAllCountryFrom();
        String ValidityFrom = Create.get("ValidityFrom");
        String ValidityTo = Create.get("ValidityTo");
        FareRule.FillDataPickerValidityFrom(ValidityFrom);
        FareRule.FillDataPickerValidityTo(ValidityTo);
        String FareName = Create.get("FareName");
        FareRule.FillFareName(FareName);
        FareRule.ClickOnSendForApprovalAdd();
        String Description = Create.get("Description");
        FareRule.FillDescription(Description);
        FareRule.ClickOnSendForApprovalAdd();
        Thread.sleep(3000);
        String Expected = "http://192.168.1.95/rule-engine/rule-master";
        String Actual = driver.browser().getCurrentURL();
        Assert.assertEquals(Actual,Expected);
    }
    @AfterMethod
    public void Reload(){
        driver.browser().navigateToURL("http://192.168.1.95");
    }
}
