package AdminPages.Admin.Branch;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class CreateBranch_TC extends TestBase_TC {
    private AddNewBranch_Page addNewBranch;
    private LogIn_Page logIn;
    private SearchBranch_Page searchBranch;
    String Branchcode = "";
    String Branchname = "";
    String Selectcountry = "";
    String Selectstate = "";
    String Selectcity = "";

    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }

    @BeforeTest
    public void sign(){
        logIn = new LogIn_Page(driver);
        logIn.EnterUserName("odeysysadmin");
        logIn.EnterPassword("qqE6)Cxp6>B8");
        logIn.ClickOnLoginButton();


    }

    @Test(dataProvider = "JsonProvider")
    public void CreateBranch(Map<String, String> Branch) throws InterruptedException {
        addNewBranch = new AddNewBranch_Page(driver);
        searchBranch = new SearchBranch_Page(driver);
        String Brand = Branch.get("Brand");
        Selectcountry =Branch.get("Country");
        String OperatingCountry = Branch.get("OperatingCountry");
        Branchname = Branch.get("BranchName");
        String state = Branch.get("State");
        String City = Branch.get("City");
        String Address = Branch.get("Address");
        String PostOffice = Branch.get("PostOffice");
        String PhoneNo = Branch.get("PhoneNo");
        String EmailID = Branch.get("EmailID");
        String Password = Branch.get("Password");
        String Name = Branch.get("Name");
        String Email = Branch.get("Email");
        String Phone = Branch.get("Phone");
        String Department = Branch.get("Department");
        String Creditlimit = Branch.get("Creditlimit");
        String Topup = Branch.get("Topup");
        String Creditterm = Branch.get("Creditterm");
        String Description = Branch.get("Description");
        //String Managername = Branch.get("Managername");
        String Supplierdescription = Branch.get("Supplierdescription");
        addNewBranch.BranchDetails(Brand,Selectcountry,OperatingCountry,Branchname,state,City,Address,PostOffice,PhoneNo,EmailID,Password
                ,Name,Email,Phone,Creditlimit,Topup,Creditterm,Description,Supplierdescription);
        Thread.sleep(1000);
        addNewBranch.Alert();
        Thread.sleep(Long.parseLong("1000"));
        searchBranch.setsearchbranch(Branchcode,Branchname,Selectcountry,Selectstate,Selectcity);

        searchBranch.setInactive();
        searchBranch.search();
        searchBranch.setThumpUp("Approved");




    }
    //    @Test(priority = 2)
//    public void setSearchBranchInactive(){
//        searchBranch = new SearchBranch_Page(driver);
////        String Branchcode = branch.get("Branchcode");
////        String Branchname = branch.get("Branchname");
////        String Selectcountry = branch.get("Selectcountry");
////        String Selectstate = branch.get("Selectstate");
////        String Selectcity = branch.get("Selectcity");
//        searchBranch.setsearchbranch(Branchcode,Branchname,Selectcountry,Selectstate,Selectcity);
//
//        searchBranch.setInactive();
//        searchBranch.search();
//        searchBranch.setThumpUp("Approved");
//
//    }
//
//    @Test(priority = 3)
//    public void setSearchBranchactive(){
//        addNewBranch = new AddNewBranch_Page(driver);
//
//        searchBranch = new SearchBranch_Page(driver);
//        searchBranch.setsearchbranch(Branchcode,Branchname,Selectcountry,Selectstate,Selectcity);
//       // searchBranch.setActive();
//        searchBranch.search();
//      //  Validations.verifyThat().element(By.xpath("//*[@id=\"air_tb\"]")).isVisible().perform();
//        addNewBranch.performAssertions();
//    }
    @AfterMethod
    public void navigateBackToURL() {
        driver.browser().navigateToURL("http://192.168.1.70");
    }
}