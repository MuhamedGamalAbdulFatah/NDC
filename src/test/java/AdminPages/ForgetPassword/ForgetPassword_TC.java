package AdminPages.ForgetPassword;

import AdminPages.Login.TestBase_TC;
import com.shaft.validation.Validations;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class ForgetPassword_TC extends TestBase_TC {
String URL;
    ForgetPassword_Page forgetPassword;


    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }

    @Test (dataProvider = "JsonProvider",priority = 1)
    public void VerifyThatForgetPasswordIsClickable(Map<String,String> Edit) throws InterruptedException {
        forgetPassword = new ForgetPassword_Page(driver);
        forgetPassword.ClickOnForgetPassword();
        String ActualResult = driver.getDriver().getCurrentUrl();
        String CurrentUrl = Edit.get("CurrentUrl");
        Assert.assertEquals(ActualResult, CurrentUrl);

    }
    @Test (dataProvider = "JsonProvider",priority = 2)
    public void VerifyThatUserNameIsRequired(Map<String,String> Edit) throws InterruptedException {
        forgetPassword.Reload();
        forgetPassword = new ForgetPassword_Page(driver);
        forgetPassword.ClickOnForgetPassword();
        String InvalidWriter = Edit.get("InvalidWriter");
        forgetPassword.ClickAndTypeUserName(InvalidWriter);
        forgetPassword.ClickOnConfirm();
        Validations.verifyThat().element(driver.getDriver(), forgetPassword.Txt_MessageRequired).isVisible().perform();

    }
    @Test (dataProvider = "JsonProvider",priority = 3)
    public void VerifyThatGetErrorWhenUserNameIsNotExist(Map<String,String> Edit) throws InterruptedException {
        forgetPassword.Reload();
        forgetPassword = new ForgetPassword_Page(driver);
        forgetPassword.ClickOnForgetPassword();
        String userNotExist = Edit.get("userNotExist");
        forgetPassword.ClickAndTypeUserName(userNotExist);
        forgetPassword.ClickOnConfirm();
        Thread.sleep(200);
        Validations.verifyThat().element(driver.getDriver(), forgetPassword.Txt_ErrorMessage).isVisible().perform();

    }
    @Test (dataProvider = "JsonProvider",priority = 4)
    public void VerifyThatGetErrorWhenUserNameIsExist(Map<String,String> Edit) throws InterruptedException {
        forgetPassword.Reload();
        forgetPassword = new ForgetPassword_Page(driver);
        forgetPassword.ClickOnForgetPassword();
        String userExist = Edit.get("userExist");
        forgetPassword.ClickAndTypeUserName(userExist);
        forgetPassword.ClickOnConfirm();
        Thread.sleep(20000);

    }
    @Test (dataProvider = "JsonProvider",priority = 5)
    public void VerifyThatNewPasswordIsRequired(Map<String,String> Edit) throws InterruptedException {

        forgetPassword = new ForgetPassword_Page(driver);
        Thread.sleep(30000);
        URL=driver.getDriver().getCurrentUrl();
        String NewPassword = Edit.get("NewPassword");
        String ConfirmPassword1 = Edit.get("ConfirmPassword1");
        String ConfirmPassword2 = Edit.get("ConfirmPassword2");
        String InvalidWriter = Edit.get("InvalidWriter");
        forgetPassword.ClickOnNewPassword(InvalidWriter);
//        ForgetPassword.ClickOnConfirmPassword(ConfirmPassword1);
        forgetPassword.ClickOnConfirmButton();
        Validations.verifyThat().element(driver.getDriver(), forgetPassword.Txt_Required1).isVisible().perform();

    }
    @Test (dataProvider = "JsonProvider",priority = 6)
    public void VerifyThatConfirmPasswordIsRequired(Map<String,String> Edit) throws InterruptedException {
        forgetPassword.ReloadConfirmPage(URL);

        forgetPassword = new ForgetPassword_Page(driver);

        String NewPassword = Edit.get("NewPassword");
        String ConfirmPassword1 = Edit.get("ConfirmPassword1");
        String ConfirmPassword2 = Edit.get("ConfirmPassword2");
        String InvalidWriter = Edit.get("InvalidWriter");
        forgetPassword.ClickOnConfirmPassword(NewPassword);
//        ForgetPassword.ClickOnNewPassword(InvalidWriter);
        forgetPassword.ClickOnConfirmButton();
        Validations.verifyThat().element(driver.getDriver(), forgetPassword.Txt_Required2).isVisible().perform();

    }
    @Test (dataProvider = "JsonProvider",priority = 7)
    public void VerifyThatNewPasswordNotEqualConfirmPassword(Map<String,String> Edit) throws InterruptedException {
        forgetPassword.ReloadConfirmPage(URL);
        forgetPassword = new ForgetPassword_Page(driver);
        String NewPassword = Edit.get("NewPassword");
        String ConfirmPassword1 = Edit.get("ConfirmPassword1");
        String ConfirmPassword2 = Edit.get("ConfirmPassword2");
        String InvalidWriter = Edit.get("InvalidWriter");
        forgetPassword.ClickOnNewPassword(NewPassword);
        forgetPassword.ClickOnConfirmPassword(ConfirmPassword1);
        forgetPassword.ClickOnConfirmButton();
        Validations.verifyThat().element(driver.getDriver(), forgetPassword.Txt_Required2).isVisible().perform();

    }
    @Test (dataProvider = "JsonProvider",priority = 8)
    public void VerifyThatNewPasswordEqualConfirmPassword(Map<String,String> Edit) throws InterruptedException {
        forgetPassword.ReloadConfirmPage(URL);

        forgetPassword = new ForgetPassword_Page(driver);
        String NewPassword = Edit.get("NewPassword");
        String ConfirmPassword1 = Edit.get("ConfirmPassword1");
        String ConfirmPassword2 = Edit.get("ConfirmPassword2");
        String InvalidWriter = Edit.get("InvalidWriter");
        forgetPassword.ClickOnNewPassword(NewPassword);
        forgetPassword.ClickOnConfirmPassword(ConfirmPassword2);
        forgetPassword.ClickOnConfirmButton();
        Thread.sleep(10000);
        String ActualResult = driver.getDriver().getCurrentUrl();
        String LoginUrl = Edit.get("LoginUrl");
        Assert.assertEquals(ActualResult, LoginUrl);

    }


}
