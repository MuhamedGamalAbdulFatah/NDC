package AdminPages.RuleEngine.FareRules;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class FareRuleMaster_Page {
    //constant
    private final SoftAssert softAssert;

    public FareRuleMaster_Page(SHAFT.GUI.WebDriver driver) {

        this.softAssert = new SoftAssert();

        this.driver = driver;
    }
    static SHAFT.GUI.WebDriver driver;
    By Btn_RuleEngine = By.xpath("//a[@href=\"/rule-engine\"]");
    By Btn_FareRule = By.xpath("(//img[@src=\"../static/img/Cancellation_icon.png\"])[2]");
    By Btn_Search = By.xpath("//button[@type=\"submit\"]");
    By Btn_ADD = By.xpath("//span[@style=\"margin-inline-end: 10px;\"]");
    By Rbtn_ActiveAndInactive = By.xpath("(//div[@class=\"p-radiobutton-box\"])[1]");
    By Rbtn_Both = By.xpath("(//div[@class=\"p-radiobutton-box\"])[2]");
    By Lst_SupplierName = By.xpath("//span[@class=\"p-dropdown-label p-inputtext p-placeholder ng-star-inserted\"]");
    By Dpick_ValidityTo = By.xpath("//input[@class=\"ng-tns-c51-7 p-inputtext p-component ng-star-inserted\"]");
    By Dpick_ValidityFrom = By.xpath("//input[@class=\"ng-tns-c51-6 p-inputtext p-component ng-star-inserted\"]");
    By Lst_CountryTo = By.xpath("(//i[@class=\"pi pi-angle-down\"])[2]");
    By Lst_CountryFrom = By.xpath("(//i[@class=\"pi pi-angle-down\"])[2]");
    By Cbox_AllSelect = By.xpath("(//input[@type=\"checkbox\"])[1]");
    By Txt_FareRuleName = By.xpath("(//input[@type=\"text\"])[5]");
    By Btn_Edit = By.xpath("(//i[@class=\"pi pi-pencil\"])[1]");
    By Btn_Trach = By.xpath("(//i[@class=\"pi pi-trash ng-star-inserted\"])[1]");
    By Btn_ActiveCircle = By.xpath("(//i[@class=\"pi pi-circle-fill\"])[1]");
    By Btn_InactiveCircle = By.xpath("(//i[@class=\"pi pi-circle-fill\"])[1]");
    By Btn_ThumbsDown = By.xpath("(//i[@class=\"pi pi-thumbs-down\"])[1]");
    By Btn_ThumbsUp = By.xpath("(//i[@class=\"pi pi-thumbs-up\"])[1]");
    By Txt_Remarks = By.xpath("//textarea[@class=\"p-inputtextarea p-inputtext p-component p-element " +
            "ng-untouched ng-pristine ng-invalid\"]");
    By Btn_CancelRemarks = By.xpath("//button[@type=\"reset\"]");
    By Btn_Submit = By.xpath("(//button[@type=\"submit\"])[2]");
    By Btn_Delete = By.xpath("(//button[@type=\"submit\"])[2]");
    By Txt_Description = By.xpath("//div[@class=\"ql-editor ql-blank\"]");
    By Btn_SendForApprovalADD = By.xpath("//button[@type=\"submit\"]");
    By Btn_Cancel = By.xpath("//button[@class=\"col-sm-12 col-md-6 col-lg-2 p-element " +
            "p-ripple p-button-outlined p-button p-component justify-content-center\"]");
    By Btn_Reject = By.xpath("(//button[@class=\"col-sm-12 col-md-6 col-lg-2 p-element " +
            "p-ripple p-button p-component justify-content-center ng-star-inserted\"])[1]");
    By Btn_Approve = By.xpath("(//button[@class=\"col-sm-12 col-md-6 col-lg-2 p-element " +
            "p-ripple p-button p-component justify-content-center ng-star-inserted\"])[2]");
    By Btn_SendForApprovalEdit = By.xpath("(//button[@type=\"submit\"])[3]");
    By Msg_Required1 = By.xpath("(//span[@class=\"fg-error\"])[1]");
    By Msg_Required2 = By.xpath("(//span[@class=\"fg-error\"])[2]");
    By Msg_Required3 = By.xpath("(//span[@class=\"fg-error\"])[3]");
    By Msg_Required4 = By.xpath("(//span[@class=\"fg-error\"])[4]");
    By Msg_Required5 = By.xpath("(//span[@class=\"fg-error\"])[5]");

    By Txt_RemarksEdit = By.xpath("//textarea[@class=\"p-inputtextarea p-inputtext p-component p-element ng-untouched ng-pristine ng-valid p-filled\"]");

    By Lst_CountryEdit = By.xpath("(//div[@class=\"dropdown-wrapper\"])[2]");
    By Lst_CountryToEdit = By.xpath("(//div[@class=\"dropdown-wrapper\"])[1]");

    By Cbox_SelectedAll = By.xpath("//input[@class=\"ng-star-inserted\"]");
    By Cbox_CheckedETicket = By.xpath("(//span[@class=\"p-checkbox-icon pi pi-check\"])[1]");
    By Cbox_CheckedReviewPage = By.xpath("(//span[@class=\"p-checkbox-icon pi pi-check\"])[2]");
    public FareRuleMaster_Page SelectSupplierOrCountryOrBranch (String S){
        By Selection = By.xpath("//li[@aria-label=\""+S+"\"]");
        return this;
    }
    By Lst_SupplierName1 = By.xpath("(//span[@class=\"p-dropdown-label p-inputtext p-placeholder ng-star-inserted\"])[1]");
    public FareRuleMaster_Page NavigateToFareRuleMAster(){

        driver.element().click(Btn_RuleEngine);
        driver.element().click(Btn_FareRule);

        return this;
    }

    public FareRuleMaster_Page ClickOnSearch()
    {
        driver.element().click(Btn_Search);
        return this;
    }

    public FareRuleMaster_Page ClickOnAdd()
    {
        driver.element().click(Btn_ADD);
        return this;
    }

    public FareRuleMaster_Page ClickOnActiveAndInactive()
    {
        driver.element().click(Rbtn_ActiveAndInactive);
        return this;
    }
    public FareRuleMaster_Page FillFareName(String S)

    {
        driver.element().type(Txt_FareRuleName,S);
        return this;
    }
    public FareRuleMaster_Page ClickOnBoth()
    {
        driver.element().click(Rbtn_Both);
        return this;
    }

    public FareRuleMaster_Page ChooseSupplier(String S){
        driver.element().click(Lst_SupplierName);
        By Selection = By.xpath("//li[@aria-label=\""+S+"\"]");
        driver.element().click(Selection);
        return this;
    }
    public FareRuleMaster_Page ChooseSupplier1(String S){
        driver.element().click(Lst_SupplierName1);
        By Selection = By.xpath("//li[@aria-label=\""+S+"\"]");
        driver.element().click(Selection);
        return this;
    }
    public FareRuleMaster_Page ChooseAirline(){
        driver.element().click(Lst_SupplierName1);
        By Selection = By.xpath("//li[@aria-label=\"Saudi Arabian\"]");
        driver.element().click(Selection);
        return this;
    }
    public FareRuleMaster_Page FillDataPickerValidityTo(String S){
        driver.element().type(Dpick_ValidityTo,S);
        return this;
    }
    public FareRuleMaster_Page ChooseAllCountryTo(){
        driver.element().click(Lst_CountryTo);
        driver.element().click(Cbox_AllSelect);
        return this;
    }
    public FareRuleMaster_Page FillDataPickerValidityFrom(String S){
        driver.element().type(Dpick_ValidityFrom,S);
        return this;
    }
    public FareRuleMaster_Page FillDescription(String S){
        driver.element().type(Txt_Description,S);
        return this;
    }
    public FareRuleMaster_Page ChooseAllCountryFrom(){
        driver.element().click(Lst_CountryFrom);
        driver.element().click(Cbox_AllSelect);
        return this;
    }

    public FareRuleMaster_Page ClickOnSendForApprovalAdd()
    {
        driver.element().click(Btn_SendForApprovalADD);
        return this;
    }
    public FareRuleMaster_Page ClickOnSendForApprovalEdit()
    {
        driver.element().click(Btn_SendForApprovalEdit);
        return this;
    }
    public FareRuleMaster_Page ClickOnCancel()
    {
        driver.element().click(Btn_Cancel);
        return this;
    }
    public FareRuleMaster_Page ClickOnReject()
    {
        driver.element().click(Btn_Reject);
        return this;
    }
    public FareRuleMaster_Page ClickOnApprove()
    {
        driver.element().click(Btn_Approve);
        return this;
    }
    public FareRuleMaster_Page ClickOnEdit()
    {
        driver.element().click(Btn_Edit);
        return this;
    }

    public FareRuleMaster_Page ClickOnActiveCircle()
    {
        driver.element().click(Btn_ActiveCircle);
        return this;
    }
    public FareRuleMaster_Page ClickOnInactiveCircle()
    {
        driver.element().click(Btn_InactiveCircle);
        return this;
    }
    public FareRuleMaster_Page ActiveFare(String Remarks)
    {
        driver.element().click(Btn_ThumbsUp);
        driver.element().type(Txt_Remarks,Remarks);
        driver.element().click(Btn_Submit);

        return this;
    }
    public FareRuleMaster_Page RejectFare(String Remarks)
    {
        driver.element().click(Btn_ThumbsDown);
        driver.element().type(Txt_Remarks,Remarks);
        driver.element().click(Btn_Submit);

        return this;
    }
    String URL = "http://192.168.1.95/rule-engine/rule-master";
    public FareRuleMaster_Page NavigationURLRule(){
        driver.browser().navigateToURL(URL);
        return this;
    }
    public String ActualResult(){
        String S = ElementActions.getInstance().getText(Msg_Required1);
        return S;
    }
    public String ActualResult2(){
        String S = ElementActions.getInstance().getText(Msg_Required2);
        return S;
    }
    public String ActualResult3(){
        String S = ElementActions.getInstance().getText(Msg_Required4);
        return S;
    }
    public String ActualResult4(){
        String S = ElementActions.getInstance().getText(Msg_Required5);
        return S;
    }
    public FareRuleMaster_Page DeselectAll(){
        driver.element().click(Cbox_SelectedAll);
        return this;
    }
    public FareRuleMaster_Page ClickOnCheckedETicket()
    {
        driver.element().click(Cbox_CheckedETicket);
        return this;
    }

    public FareRuleMaster_Page ClickOnCheckedReviewPage()
    {
        driver.element().click(Cbox_CheckedReviewPage);
        return this;
    }
    public FareRuleMaster_Page ChooseAllCountryEdit(){
        driver.element().click(Lst_CountryEdit);
        driver.element().click(Cbox_AllSelect);
        return this;
    }
    public FareRuleMaster_Page RemarksSendForApprovalEdit(String Remarks)
    {
        driver.element().type(Txt_RemarksEdit,Remarks);
        return this;
    }
    public String FareName (){
        By SupplierInTable = By.xpath("(//td[@class=\"ng-star-inserted\"])[1]");
        String S = ElementActions.getInstance().getText(SupplierInTable);
        return S;
    }


}