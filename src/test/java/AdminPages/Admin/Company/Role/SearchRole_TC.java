package AdminPages.Admin.Company.Role;


import AdminPages.Admin.Staff_Page;
import AdminPages.Login.TestBase_TC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;

public class SearchRole_TC extends TestBase_TC {
    private Staff_Page staff;
    private SearchRolePage searchRole;

    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }

    @Test
    public void setSearchRoleActive() throws InterruptedException {
        staff = new Staff_Page(driver);
        searchRole = new SearchRolePage(driver);
        staff.Clickonadmin();
        searchRole.setRole("Amed");
        searchRole.setActive();
        searchRole.setSearchGrid();
    }

    @Test
    public void setSearchRoleInactive() throws InterruptedException {
        staff = new Staff_Page(driver);
        searchRole = new SearchRolePage(driver);
        staff.Clickonadmin();
        searchRole.setRole("Amed");
        searchRole.setInactive();
        searchRole.setSearchGrid();
    }


    @Test
    public void setSearchRoleBoth() throws InterruptedException {
        staff = new Staff_Page(driver);
        searchRole = new SearchRolePage(driver);
        staff.Clickonadmin();
        searchRole.setRole("Amed");
        searchRole.setBoth();
        searchRole.setSearchGrid();
    }

    @AfterMethod
    public void navigateBackToURL() {
        driver.browser().navigateToURL("http://192.168.1.94/master/flight/preferAirline/add");
    }
}