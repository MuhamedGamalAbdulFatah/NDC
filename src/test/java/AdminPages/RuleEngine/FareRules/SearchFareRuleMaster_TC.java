package AdminPages.RuleEngine.FareRules;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SearchFareRuleMaster_TC extends TestBase_TC {
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


    @Test(priority = 1, dataProvider = "JsonProvider")
    public void VerifyActiveSearch(Map<String,String> Search) throws InterruptedException {
        FareRule = new FareRuleMaster_Page(driver);
        FareRule.NavigateToFareRuleMAster();
        String Supplier =Search.get("Supplier");
        FareRule.ChooseSupplier1(Supplier);
//        String Airline =Search.get("Airline");
        FareRule.ChooseAirline();
        FareRule.ClickOnSearch();
        String Expected= "wwe1";
        Thread.sleep(5000);
        assertEquals(FareRule.FareName(), Expected);

    }

}