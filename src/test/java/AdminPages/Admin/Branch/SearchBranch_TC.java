package AdminPages.Admin.Branch;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class SearchBranch_TC extends TestBase_TC {
    private SearchBranch_Page searchBranch;
    private LogIn_Page logIn;

    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }

    @BeforeTest
    public void sign(){
        logIn = new LogIn_Page(driver);
        logIn.EnterUserName("E.saady");
        logIn.EnterPassword("qqE6)Cxp6>B8");
        logIn.ClickOnLoginButton();


    }
    @Test(dataProvider = "SearchBranchData")
    public void setSearchBranchActive(Map<String,String>branch){
        searchBranch = new SearchBranch_Page(driver);
        String Branchcode = branch.get("Branchcode");
        String Branchname = branch.get("Branchname");
        String Selectcountry = branch.get("Selectcountry");
        String Selectstate = branch.get("Selectstate");
        String Selectcity = branch.get("Selectcity");
        searchBranch.setsearchbranch(Branchcode,Branchname,Selectcountry,Selectstate,Selectcity);
        searchBranch.setActive();
    }

    @Test(dataProvider = "SearchBranchData")
    public void setSearchBranchInactive(Map<String,String>branch){
        searchBranch = new SearchBranch_Page(driver);
        String Branchcode = branch.get("Branchcode");
        String Branchname = branch.get("Branchname");
        String Selectcountry = branch.get("Selectcountry");
        String Selectstate = branch.get("Selectstate");
        String Selectcity = branch.get("Selectcity");
        searchBranch.setsearchbranch(Branchcode,Branchname,Selectcountry,Selectstate,Selectcity);
        searchBranch.setInactive();
    }

    @Test(dataProvider = "SearchBranchData")
    public void setSearchBranchBoth(Map<String,String>branch){
        searchBranch = new SearchBranch_Page(driver);
        String Branchcode = branch.get("Branchcode");
        String Branchname = branch.get("Branchname");
        String Selectcountry = branch.get("Selectcountry");
        String Selectstate = branch.get("Selectstate");
        String Selectcity = branch.get("Selectcity");
        searchBranch.setsearchbranch(Branchcode,Branchname,Selectcountry,Selectstate,Selectcity);
        searchBranch.setBoth();
    }
}
