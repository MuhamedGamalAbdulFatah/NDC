package AdminPages.RuleEngine.FareRules;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class UpdateFareRuleMaster_TC extends TestBase_TC {

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



    @Test(priority = 1, dataProvider = "JsonProvider")
    public void UpdateFareRuleMaster(Map<String,String> Create) throws InterruptedException {
        FareRule = new FareRuleMaster_Page(driver);
        FareRule.NavigationURLRule();
        FareRule.ClickOnActiveAndInactive();
        FareRule.ClickOnSearch();
        FareRule.ClickOnEdit();
        driver.element().click(FareRule.Lst_CountryEdit);
        FareRule.DeselectAll();
        driver.element().click(FareRule.Lst_CountryToEdit);
        FareRule.DeselectAll();
        FareRule.ClickOnSendForApprovalEdit();
        String Expected3 = "";
        Assert.assertEquals(FareRule.ActualResult2(), Expected3);
        String Remarks = Create.get("Remarks");
//        FareRule.RemarksSendForApprovalEdit(Remarks);
        FareRule.ChooseAllCountryFrom();
        FareRule.ChooseAllCountryTo();
        String FareName = Create.get("FareName");
        FareRule.FillFareName(FareName);
        FareRule.ClickOnSendForApprovalEdit();
        Thread.sleep(2000);
        String Expected = "http://192.168.1.95/rule-engine/rule-master";
        String Actual = driver.browser().getCurrentURL();
        Assert.assertEquals(Actual,Expected);
    }
    @AfterMethod
    public void Reload(){
        driver.browser().navigateToURL("http://192.168.1.95");
    }
}
