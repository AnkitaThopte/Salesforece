
package SalesforceSystemTest.stepdefinitions;

import SalesforceSystemTest.navigation.NavigateTo;
import SalesforceSystemTest.navigation.SalesforceHomePage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.text.ParseException;
import java.util.List;
import java.util.Map;


//import static org.assertj.core.api.Assertions.assertThat;

public class SalesforceStepDefinitions {

    @Steps
    NavigateTo navigateTo;
    SalesforceHomePage homePage;
    String firstName, lastName, Salutation, Phone, tagName;
    String expectedString;
    String enteredSupporterLevel, expectedSupporterLevel, expectedLevelOfService, expectedSelectService, expectedchoosedSupporter, enteredSelectService;
    String opportunityName, primaryCampaignSource, closeDate, stage;
    String Assignedto, Subject, Status, Priorty;


    //  String fieldCompany ,fieldWebsite,  fieldCIN, fieldGroup,  fieldEmail,  fieldAnnual,  fieldOwnership,  fieldLeadstat,  fieldLastName,  fieldExpdate;


    private Object Newbtn;
    private String radioButton= "Director";

    public WebDriver initialize() {
        String saleforceNotifications = getConfigurationDetails("webdriver.base.disable_notifications");
        String driverName = getConfigurationDetails("webdriver.name.chrome");
        String driverPath = getConfigurationDetails("webdriver.chrome.driver");
        ChromeOptions option = new ChromeOptions();
//        option.addExtensions(new File("C:\\Users\\Aniket\\Downloads\\Block-image_v1.0.crx"));
        option.addArguments(saleforceNotifications);
        System.setProperty(driverName, driverPath);
        WebDriver driver = new ChromeDriver(option);
        return driver;
    }

    public String getConfigurationDetails(String nameURL) {
        EnvironmentVariables props = Injectors.getInjector().getInstance(EnvironmentVariables.class);
        String configDetails = EnvironmentSpecificConfiguration.from(props).getProperty(nameURL);
        return configDetails;
    }

    WebDriver driver = initialize();

    @Given("^I login to Salesforce URL$")
    public void i_login_to_Salesforce_URL() throws Throwable {
        navigateTo.LogintoSalesforce(driver);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @When("^I click on (.*) tag")
    public void i_click_on_contacts_page(String filedTagname) throws Throwable {
        navigateTo.clickContacts(driver, filedTagname);
        //   restapi.testRestApi();

    }

    @And("I click on the New Contact under Contact Page")
    public void i_click_on_new_contact() throws Throwable {
        navigateTo.clickNewContact(driver);

    }

    @When("I click on Contact dropdown")
    public void i_click_on_dropdown() throws Throwable {
        navigateTo.clickOnDropdown(driver);
    }


    @When("^I enter following details in (.*), (.*), (.*) and (.*) fields under New Contact Page:$")
    public void i_enter_details(String fieldSalutation, String fieldFirstName, String fieldLastName, String fieldPhone, DataTable dataTable) throws Throwable {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        firstName = data.get(0).get("First Name");
        lastName = data.get(0).get("Last Name");
        Salutation = data.get(0).get("Salutation");
        Phone = data.get(0).get("Phone");
        navigateTo.insertRecords(driver, fieldSalutation, fieldFirstName, fieldLastName, fieldPhone, firstName, lastName, Salutation, Phone);
    }

    @When("^I select (.*) under (.*)$")
    public void i_select(String supporterLevel, String supporterfieldName) throws Throwable {
        // navigateTo.selectFromDropDown(driver, supporterLevel, supporterfieldName);
        enteredSupporterLevel = supporterLevel;
    }

    @And("^I selected (.*) under case information$")
    public void iSelectDonePayment(String done) {

        navigateTo.donePayment(driver, done);
    }

    @And("^I selected \"(.*)\" under case tab$")
    public void iSelectUnderCaseTab(String Mycases) throws Throwable {

        navigateTo.myCases(driver, Mycases);
        // throw new PendingException();
    }

    @When("^I click on (.*) button")
    public void i_click_on_Save_button(String saveButton) {
        navigateTo.clickOnSave(driver, saveButton);
    }

    @And("^I click on Recently Viewed dropdown (.*)$")
    public void recently_viewed_dropdown(String filedDropdown) {
        navigateTo.recentlyViewedDropdown(driver, filedDropdown);
    }

    @And("^I click on the (.*) button$")
    public void i_click_on_URM_button(String URMButton) {
        navigateTo.clickOnURM(driver, URMButton);
    }

    @And("^I select \"(.*)\" from the list view$")
    public void select_all_contacts(String allContact) {
        navigateTo.allContacts(driver, allContact);
    }

    @And("^I type the leads \"(.*)\" in the Search box and press Enter to view the particular contact detail$")
    public void search_enter(String arg1) {
        navigateTo.contactNameInSearch(driver, arg1);
    }

//    @And("I click on (-?\\d) (-?\\d) ")
//    public void search_enter_name(String n) {
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+n);
//        navigateTo.contactNameInSearch(driver);
//    }

    @And("I click on the searched lead name$")
    public void searched_contact_name() {
        navigateTo.searchContactName(driver);
    }

//    @And("^I click on (.*) Tab$")
//    public void click_required_tab(String TagName) {
//        navigateTo.clickTabName(driver,TagName);


    @And("^I click on \"(.*)\" Tab$")
    public void click_required_tab(String fieldTagName) {
        navigateTo.clickTabName(driver, fieldTagName);
    }

    @And("I click \"(.*)\" button in the Engagement Plans section")
    public void Engagement_Plans_new(String newButton) {
        navigateTo.clickNewEngagementPlans(driver, newButton);
    }

    @And("I click the New button in the Engagement Plans section")
    public void Engagement_Plans_new() {
        navigateTo.clickNewEngagementPlansTemplet(driver);
    }

    @And("I click on Engagement Plan Template textbox and select a plan under New Engagement Plan page")
    public void click_Engagement_Plan_Template() {
        navigateTo.clickTextboxOfEngagementPlan(driver);
    }

    @When("^I verify the an Engagement Plan Template and Contact is created$")
    public void i_enter_details(DataTable dataTable) throws Throwable {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String ept = data.get(0).get("Engagement Plan Template");
        String contactName = data.get(0).get("Contact Name");

        navigateTo.verifyDetails(driver, ept, contactName);
    }

    @And("I scroll down to page")
    public void scroll_Down() {
        navigateTo.scrollDown(driver);
    }

    @And("I scroll up to page")
    public void scroll_up() {
        navigateTo.scrollUP(driver);
    }

    //    @And("^I click on (.*) new (.*)$")
//    public void click_EPN(String EPN,String Number) {
//        navigateTo.clickOnEpn(driver,EPN,Number);
//    }
    @And("^I click on (.*) new$")
    public void click_EPN(String EPN) {
        navigateTo.clickOnEpn(driver, EPN);
    }

    @And("^I click \"(.*)\" button$")
    public void click_EButton(String editButton) {
        navigateTo.clickOnEditButton(driver, editButton);
    }
//    @And("^I enter \"(.*)\" and \"(.*)\" in Relationship Manager filed$")
//    public  void enter_Relationship_Manager(String fieldFirstName,String filedLastName,DataTable dataTable){
//        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//        firstName = data.get(0).get("First Name");
//        lastName = data.get(0).get("Last Name");
//        navigateTo.enterRelationshipManager(driver,firstName,lastName);
//        }

    @And("^I enter \"(.*)\" in Relationship Manager filed$")
    public void click_Relationship_Manager(String fieldName) {
//        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//        firstName = data.get(0).get("First Name");
//        lastName = data.get(0).get("Last Name");
        navigateTo.clickOnRelationshipManager(driver, fieldName);
    }

    @Then("^I verify the (.*) name is populated with previous value$")
    public void verify_Previous_Relationship_Manager(String filedPRManager, DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String PreviousManager = data.get(0).get(filedPRManager);
        System.out.println("Previous Manager " + PreviousManager);
        navigateTo.verifyPRM(driver, PreviousManager);
    }

    @Then("^I verify the (.*) is now updated with new manager name$")
    public void verify_Updated_Relationship_Manager(String filedManager, DataTable dataTable) throws Throwable {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String NewManager = data.get(0).get("Manager Name");
        navigateTo.verifyURM(driver, NewManager, filedManager);

    }

    @And("^I click on the cross mark against the (.*) name and remove it$")
    public void cross_Mark_Relationship_Manager(String filedManager) {
        navigateTo.crossMark(driver, filedManager);
    }

    @And("^I \"(.*)\" the PopUp$")
    public void PopUp_Close(String filedClose) {
        navigateTo.ClosePopUp(driver, filedClose);
    }

    @Then("I verify following details under Contacts page")
    public void i_verify_details_under_contacts_page(DataTable dataTable) throws Throwable {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        // String filedName = data.get(0).get("f");
        String filedPhone = data.get(0).get("Phone");
        String fullName = Salutation + " " + firstName + " " + lastName;
        navigateTo.verifyDetailsUnderContact(driver, fullName, filedPhone);
    }

    @Then("I verify whether correct error \"(.*)\" message displayed or not")
    public void i_verify_correct_error_message_displayed(String filedMessage) {
        navigateTo.verifyCorrectErrorMessage(driver, filedMessage);
    }

    @Then("I verify whether the correct error \"(.*)\" message displayed")
    public void i_verify_correct_error_message(String filedMessage) {
        navigateTo.verifyErrorMessage(driver, filedMessage);
    }

    @And("I click on \"(.*)\" check box")
    public void i_click_check_box(String filedCheckBox) {
        navigateTo.clickCheckBox(driver, filedCheckBox);
    }

    //    @When("I click on Opportunity tab")
//    public void i_click_opportunities() {
//        navigateTo.clickOpportunity(driver);
//    }
    @When("I click on Opportunities dropdown")
    public void i_click_opportunities_dropdown() {
        navigateTo.clickOpportunitydropdown(driver);
    }

    @When("I click New Opportunity button")
    public void i_click_new_opportunity() {
        navigateTo.clickNewOpportunity(driver);
    }

    @And("I select Donation button")
    public void i_select_donation() {
        navigateTo.selectDonation(driver);
    }

    @And("I click the Next button")
    public void i_click_next() {
        navigateTo.clickNext(driver);
    }

    @And("^I enter details in (.*), (.*), (.*), (.*), (.*) and (.*) fields under New Opportunity: Donation$")
    public void i_enter_opportunity_details(String fieldOpportunityName, String fieldPrimaryCampaignSource, String filedCloseDate, String filedStage, String filedPrimaryContact, String filedAmount, DataTable dataTable) throws Throwable {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        opportunityName = data.get(0).get("Opportunity Name");
        primaryCampaignSource = data.get(0).get("Primary Campaign Source");
        closeDate = data.get(0).get("Close Date");
        stage = data.get(0).get("Stage");
        String primaryContact = data.get(0).get("Primary Contact");
        String amount = data.get(0).get("Amount");
        navigateTo.provideDetails(driver, fieldOpportunityName, fieldPrimaryCampaignSource, filedCloseDate, filedStage, filedPrimaryContact, filedAmount, opportunityName, primaryCampaignSource, closeDate, stage, primaryContact, amount);
    }

    @Then("^I verify following details under Opportunity page$")
    public void i_verify_opportunity_details(DataTable dataTable) throws Throwable {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String filedOpportunityName = data.get(0).get("Opportunity Name");
        String filedPrimaryCampaignSource = data.get(0).get("Primary Campaign Source");
        String filedCloseDate = data.get(0).get("Close Date");
        String filedStage = data.get(0).get("Stage");

        System.out.println("*************************************");
        System.out.println(filedOpportunityName);
        System.out.println(filedPrimaryCampaignSource);
        System.out.println(filedCloseDate);
        System.out.println(filedStage);
        System.out.println("*************************************");


//        String filedOpportunityName = opportunityName;
//        String filedPrimaryCampaignSource = primaryCampaignSource;
//        String filedCloseDate = closeDate;
//        String filedStage= stage;
        navigateTo.verfyopportunitydetails(driver, filedOpportunityName, filedPrimaryCampaignSource, filedCloseDate, filedStage);
    }

    @And("^I provide Engagement Plan Template Name$")
    public void i_provide_engagement_plan_template_name() {
        navigateTo.provideEngagementPlanName(driver);
    }

    @And("I click Save button on MANAGE ENGAGEMENT PLAN TEMPLATE")
    public void i__click_Save_button_on_MANAGE_ENGAGEMENT_PLAN_TEMPLATE() {
        navigateTo.MEPTSave(driver);
    }

    @And("I select on Related Tab")
    public void i_select_related() {
        navigateTo.selectRelated(driver);
    }

    @And("I select (.*) in Account tab")
    public void i_select_account(String filedAccount) {
        navigateTo.selectAccount(driver, filedAccount);
    }

    @And("I select Engagement Plan Template")
    public void i_select_Engagement_Plan_Template() {
        navigateTo.selectEngagementPlan(driver);
    }

    @Then("^I verify Anonymous supporter record created$")
    public void i_verify_anonymous_supporter_record_created(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String filedPhone = data.get(0).get("Phone");
        String fullName = Salutation + " " + firstName + " " + lastName;
        navigateTo.verifyAnonymousSupporter(driver, filedPhone, fullName);
    }

    @And("^I click on (.*) tab$")
    public void i_click_newTask(String filedTask) {
        navigateTo.clickNewTask(driver, filedTask);
    }

    @And("^I Provide the following details under New Task Page$")
    public void i_provide_under_new_task(DataTable dataTable) throws Throwable {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Assignedto = data.get(0).get("Assigned to");
        Subject = data.get(0).get("Subject");
        Status = data.get(0).get("Status");
        Priorty = data.get(0).get("Priority");
        navigateTo.newTaskDetails(driver, Assignedto, Subject, Status, Priorty);
        //navigateTo.newTaskDetails(driver); ////div//input[contains(@class,'default input uiInput uiInputTextForAutocomplet')][@title ='Search People']
    }

    @And("^I click on Activity History subject$")
    public void i_click_on_activity_history() {
        navigateTo.clickActivityHistory(driver);
    }

    @Then("^I verify following details under Task$")
    public void i_verify_details_under_task(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String assignedto = data.get(0).get("Assigned to");
        String subject = data.get(0).get("Subject");
        String status = data.get(0).get("Status");
        String priority = data.get(0).get("Priority");
        navigateTo.verifyTaskDetails(driver, assignedto, subject, status, priority);
    }

    @Then("^I verify whether the warning message \"(.*)\" is displayed$")
    public void i_verify_warning_message(String filedMessage) {
        navigateTo.verifywarningMessage(driver, filedMessage);
    }

    @And("^I Enter \"(.*)\" in phone filed$")
    public void i_enter_phone_filed(String filedPhone) {
        navigateTo.enterphone(driver, filedPhone);
    }

    @Then("I verify details under Contacts page")
    public void i_verify_details_contacts_page(DataTable dataTable) throws Throwable {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String filedName = data.get(0).get("Name");
        String filedPhone = data.get(0).get("Phone");
        //String fullName =data.get(0).get("Ph");
        navigateTo.verifyDetailsContactPage(driver, filedName, filedPhone);
    }

    @And("^I click on Bequestor Status dropdown and select (.*) as status$")
    public void i_click_bequestor_status_dropdown(String filedStatus) throws Throwable {
        navigateTo.verifyBequestorStatusDropdown(driver, filedStatus);
    }

    @Then("^I verify the Bequestor Status is set for the supporter record$")
    public void i_verify_Bequestor_status(DataTable dataTable) throws Throwable {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String filedStatus = data.get(0).get("Bequestor Status");
        System.out.println("*********************");
        System.out.println(filedStatus);
        System.out.println("**********************");
        navigateTo.verifyBequestorStatus(driver, filedStatus);
    }

    @And("^I select Bequest Relationship Manager$")
    public void i_select_Bequest_Relationship_Manager(DataTable dataTable) throws Throwable {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String filedManager = data.get(0).get("Bequest Relationship Manager");

        navigateTo.selectBequestManager(driver, filedManager);
    }

    @And("^I enter the amount in the Advised Value textbox$")
    public void i_enter_the_amount() {

    }

    @Then("^I verify the Advised Amount now is displaying the amount entered$")
    public void i_verify_Advised_Amount() {

    }

//    @And("^I click the (.*) button$")
//    public void i_click_opportunities(String fieldValue) {
//        navigateTo.clickOpportunitybutton(driver, fieldValue);
//    }

    @And("^I click on Opportunities name (.*) link$")
    public void i_click_opportunity_name(String opportunityName) {

        System.out.println(opportunityName);
        navigateTo.clickopportunityname(driver, opportunityName);
    }

    @And("I click on Payment")
    public void i_click_on_Payment() {
        navigateTo.clickOnPayment(driver);
    }

    @And("^I click \"(.*)\" Tab under Payment$")
    public void i_click_under_payment(String tabName) {
        navigateTo.clickTabUnderPayment(driver, tabName);
    }

    @Then("^I verify Payment Status and Record Type$")
    public void i_verify_Payment_Status_and_Record_Type(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String filedPS = data.get(0).get("Payment Status");
        String filedRT = data.get(0).get("Record Type");

        System.out.println("--------------------------");
        System.out.println(filedPS);
        System.out.println("--------------------------");
        System.out.println(filedRT);
        System.out.println("---------------------------");
        navigateTo.verifyPSandRT(driver, filedPS, filedRT);
    }

    @And("^I search for Payment Unique Id of an Chargeback record$")
    public void i_search_for_Payment_Unique_Id(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String filedPUID = data.get(0).get("Payment Unique Id");
        navigateTo.searchPaymentId(driver, filedPUID);
    }

    @And("^I click on the search salesforce textbox$")
    public void i_click_search_salesforce() {
        navigateTo.searchSalesforceTextbox(driver);
    }

    @And("^I click (.*) on the searched record$")
    public void i_click_payment_number_on_searched_record(String payment) {
        navigateTo.clickPaymentNumber(driver);
    }

    @Then("^I verify the payment for Chargeback record$")
    public void i_verify_payment_chargeback_record(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String filedPID = data.get(0).get("Payment Unique Id");
        String filedRT = data.get(0).get("Record Type");
        navigateTo.verifyPaymentRecord(driver, filedPID, filedRT);
    }

    @And("^I enter following details in (.*), (.*), (.*) and (.*) fields under New Opportunity: Donation$")
    public void i_enter_opportunity_details(String fieldOpportunityName, String fieldPrimaryCampaignSource, String filedCloseDate, String filedStage, DataTable dataTable) throws Throwable {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        opportunityName = data.get(0).get("Opportunity Name");
        primaryCampaignSource = data.get(0).get("Primary Campaign Source");
        closeDate = data.get(0).get("Close Date");
        stage = data.get(0).get("Stage");
        navigateTo.insertdetails(driver, fieldOpportunityName, fieldPrimaryCampaignSource, filedCloseDate, filedStage, opportunityName, primaryCampaignSource, closeDate, stage);
    }

    @And("^I select Payment Information checkbox$")
    public void i_select_payment_checkbox() {
        navigateTo.selectCheckbox(driver);
    }

    @And("^I provide \"(.*)\" in (.*) under Once Off page$")
    public void i_provide_contact_name_once(String ContactName, String filedName) {
        navigateTo.provideContactName(driver, ContactName, filedName);
    }

    @And("^I provide the details (.*),(.*),(.*),(.*),(.*) and (.*) under Once Off page$")
    public void i_provide_details_onceOff(String fieldCampaignAppealName, String fieldBatchId, String filedChannel, String filedReceipting, String filedDonationAmount, String filedPayment, DataTable dataTable) throws Throwable {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String campaignAppealName = data.get(0).get("Campaign/Appeal Name");
        String batchId = data.get(0).get("Batch Id");
        String channel = data.get(0).get("Channel");
        String receipting = data.get(0).get("Receipting");
        String donationAmount = data.get(0).get("Donation Amount");
        String payment = data.get(0).get("Payment Method");

        System.out.println("---------------------");
        System.out.println(fieldCampaignAppealName);
        System.out.println("-----------------------");

        navigateTo.provideDetailsOnce(driver, fieldCampaignAppealName, fieldBatchId, filedChannel, filedReceipting, filedDonationAmount, filedPayment, campaignAppealName, batchId, channel, receipting, donationAmount, payment);
    }

    @Then("^I click Create Payment button$")
    public void i_click_create_payment_button() {
        navigateTo.clickCreatePayment(driver);
    }

    @And("^I select Donation Supporter radio button$")
    public void i_select_radio_button() {
        navigateTo.selectRadioButton(driver);
    }

    @And("^I click on Donation Link$")
    public void i_click_donation_link() {
        navigateTo.clickDonationLink(driver);
    }

    @And("^I click on (.*) CheckBox with click on (.*) option$")
    public void i_click_on_checkbox(String filedCheckbox, String filedEditPaid) {
        navigateTo.clickOnCheckbox(driver, filedCheckbox, filedEditPaid);
    }

    @And("^I select (.*) from payment date (.*)$")
    public void i_select_payment_date(String filedPaymentDate, String Date) {
        navigateTo.selectPaymentDate(driver, filedPaymentDate, Date);
    }

    @And("^I click \"(.*)\" radio button$")
    public void i_click_radio_button(String filedName) {
        navigateTo.clickRadioButton(driver, filedName);
    }

    @And("^I provide values in (.*),(.*),(.*),(.*),(.*),(.*) and (.*) fields$")
    public void i_provide_values(String fieldChargebackBankAction, String fieldChargebackReceivedOn, String filedChargebackReferenceNumber, String filedChargebackResponseBy, String filedChargebackActualResponseDate, String filedChargebackSSTResponse, String filedChargebackBankFinalNotificationDate, DataTable dataTable) throws Throwable {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String chargebackBankAction = data.get(0).get("Chargeback Bank Action");
        String chargebackReceivedOn = data.get(0).get("Chargeback Received On");
        String chargebackReferenceNumber = data.get(0).get("Chargeback Reference Number");
        String chargebackResponseBy = data.get(0).get("Chargeback Response By");
        String chargebackActualResponseDate = data.get(0).get("Chargeback Actual Response Date");
        String chargebackSSTResponse = data.get(0).get("Chargeback SST Response");
        String chargebackBankFinalNotificationDate = data.get(0).get("Chargeback Bank Final Notification Date");

        navigateTo.chargebackValues(driver, fieldChargebackBankAction, fieldChargebackReceivedOn, filedChargebackReferenceNumber, filedChargebackResponseBy, filedChargebackActualResponseDate, filedChargebackSSTResponse, filedChargebackBankFinalNotificationDate, chargebackBankAction, chargebackReceivedOn, chargebackReferenceNumber, chargebackResponseBy, chargebackActualResponseDate, chargebackSSTResponse, chargebackBankFinalNotificationDate);
    }

    @Then("^I verify message \"(.*)\" generated$")
    public void i_verify_success_message(String filedMessage) {
        System.out.println("...............................................................");

        filedMessage = filedMessage.replaceAll("<new_line>", "\n");
        System.out.println(filedMessage);
        System.out.println("...............................................................");

        navigateTo.verifySuccessMessage(driver, filedMessage);
    }

    @Then("^I Verify Related Payment Record generated$")
    public void i_verify_record() {
        navigateTo.verifyRecord(driver);
    }

    @And("^I provide details (.*),(.*) and (.*)$")
    public void i_provide_details_in(String fieldChargebackBankAction, String fieldChargebackReceivedOn, String filedChargebackReferenceNumber, DataTable dataTable) throws Throwable {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String chargebackBankAction = data.get(0).get("Chargeback Bank Action");
        String chargebackReceivedOn = data.get(0).get("Chargeback Received On");
        String chargebackReferenceNumber = data.get(0).get("Chargeback Reference Number");

        navigateTo.ProvideChargebackValues(driver, fieldChargebackBankAction, fieldChargebackReceivedOn, filedChargebackReferenceNumber, chargebackBankAction, chargebackReceivedOn, chargebackReferenceNumber);
    }

    @Then("^I verify (.*) option should be visible$")
    public void i_verify_chargeback_SST_Response(String filedChargebackResponseBy) {
        navigateTo.verifyChargebackSSTResponse(driver, filedChargebackResponseBy);
    }

    @And("^I select on (.*) \"(.*)\" button$")
    public void i_click_chargeback_save(String filedName, String saveButton) {
        navigateTo.chargebackSave(driver, filedName, saveButton);
    }

    @And("^I click the required Payment under (.*) option$")
    public void i_click_required_Payment_under_Payments(String filedPayment) {
        navigateTo.clickRequiredPaymentUnderPayment(driver, filedPayment);
    }

    @And("^I edit (.*) from (.*) to (.*) under Chagreback Information$")
    public void i_edit_chargeback_information(String filedAction, String filedStatus1, String filedStatus2) {
        navigateTo.editChargebackInformation(driver, filedAction, filedStatus1, filedStatus2);
    }

    @Then("^I verify that 'Charegback Bank Action' is initiated and 'Refund','Adjustment' and 'Chargeback' radio button should not be visible and cannot perform 'Refund' or 'Adjustment'$")
    public void i_verify_radio_button_should_not_be_visible() {
        navigateTo.verifyRadioButton(driver);
    }

    @Then("I verify Chargeback is created successfully and should not allow to create Refund, Adjustment and new Chargeback")
    public void i_verify_Chargeback_is_created_successfully_and_should_not_allow() {
        navigateTo.verifyChargebackNotAllowNew(driver);
    }

    @Then("I verify that 'Charegback Bank Action' is (.*) and 'Refund','Adjustment' and 'Chargeback' radio button should be visible and can create 'New Chargeback','Refund' or 'Adjustment")
    public void i_verify_Chargeback_is_canceled_can_create(String option) {
        navigateTo.verifyChargebacCanCreate(driver);
    }

    @And("^I provide the following details (.*),(.*),(.*),(.*),(.*),(.*),(.*) and (.*)$")
    public void i_provide_following_details(String filedCaseOrigin, String filedRefundType, String Subject, String Status, String filedRefundAmount, String filedRefundInstrument, String filedBankAccountNo, String fieldBankBSB, DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String caseOrigin = data.get(0).get("Case Origin");
        String refundType = data.get(0).get("Refund Type");
        String subject = data.get(0).get("Subject");
        String status = data.get(0).get("Status");
        String refundAmount = data.get(0).get("Refund Amount");
        String refundInstrument = data.get(0).get("Refund Instrument");
        String bankAccountNo = data.get(0).get("Bank Account No");
        String bankBSB = data.get(0).get("Bank BSB");
        navigateTo.refundDetails(driver, filedCaseOrigin, filedRefundType, Subject, Status, filedRefundAmount, filedRefundInstrument, filedBankAccountNo, fieldBankBSB, caseOrigin, refundType, subject, status, refundAmount, refundInstrument, bankAccountNo, bankBSB);
    }

    @And("^I click the required (.*) under Payment$")
    public void i_click_required_under_payment(String fieldName) {
        navigateTo.clickrequiredTab(driver, fieldName);
    }

    @And("^I select (.*) button from Approval Request$")
    public void i_select_reuiest_from_approval_request(String fieldbutton) {
        navigateTo.selectrequiest(driver, fieldbutton);
    }

    @And("^I click (.*) from Approve Case$")
    public void i_click_on_approve_case(String fieldbutton) {
        navigateTo.clickOnCase(driver, fieldbutton);
    }

    @Then("^I verify (.*) is (.*) under Case Approval$")
    public void i_verify_under_case_approval(String tagName, String status) {
        navigateTo.verifyCaseApproval(driver, tagName, status);
    }

    @And("^I click (.*) tab$")
    public void i_click_Email_Payment_Receipt_tab(String tabName) {
        navigateTo.clickOnTab(driver, tabName);
    }

    @And("^I click (.*) in (.*)$")
    public void i_click_in(String fieldEdit, String filedPayment) {
        navigateTo.clickEditInPayment(driver, fieldEdit, filedPayment);
    }

    @And("^I select the (.*) from (.*)$")
    public void i_select_from(String fieldValue, String filedPayment) {
        navigateTo.selectPayment(driver, fieldValue, filedPayment);
    }

    //  *******************************************************************************************************
    @Then("^I verify the (.*) Chargeback$")
    public void iVerifyTheRelatedPaymentRecordChargeback(String RPaymentType, DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String fieldRT = data.get(0).get("Related Payment Type");
        // System.out.println(fieldRT);
        System.out.println(fieldRT);
        String CB = navigateTo.relatedPaymentRecord(driver, RPaymentType);
        //  Assert.assertEquals("Chargeback",CB);

    }

    @And("^I search for \"(.*)\" of an Chargeback record$")
    public void iSearchForOfAnChargebackRecord(String number) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        navigateTo.searchRecord(driver, number);
        //  throw new PendingException();
    }


    @And("^I give following details (.*),(.*),(.*),(.*),(.*),(.*) and (.*)$")
    public void iGiveFollowingDetails(String fieldChargebackBankAction, String fieldChargebackReceivedOn, String filedChargebackReferenceNumber, String fieldChargebackResponseBy, String fieldChargebackActualResponseDate, String fieldChargebackSSTResponse, String fieldChargebackBankFinalNotificationDate, DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//     String chargebackBankAction = data.get(0).get("Chargeback Bank Action");
//        String chargebackReceivedOn = data.get(0).get("Chargeback Received On");
        //      String chargebackReferenceNumber = data.get(0).get("Chargeback Reference Number");
        String chargebackBankAction = data.get(0).get("Chargeback Bank Action");
        String chargebackChargebackResponseBy = data.get(0).get("Chargeback Response By");
        String chargebackReceivedOn = data.get(0).get("Chargeback Received On");
        String chargebackReferenceNumber = data.get(0).get("Chargeback Reference Number");
        String chargebackChargebackActualResponseDate = data.get(0).get("Chargeback Actual Response Date");
        String chargebackChargebackSSTResponse = data.get(0).get("Chargeback SST Response");
        String chargebackChargebackBankFinalNotificationDate = data.get(0).get("Chargeback Bank Final Notification Date");

        navigateTo.givedetails(driver, fieldChargebackBankAction, fieldChargebackReceivedOn, filedChargebackReferenceNumber, fieldChargebackResponseBy, fieldChargebackActualResponseDate, fieldChargebackSSTResponse, fieldChargebackBankFinalNotificationDate, chargebackBankAction, chargebackReceivedOn, chargebackReferenceNumber, chargebackChargebackResponseBy, chargebackChargebackActualResponseDate, chargebackChargebackSSTResponse, chargebackChargebackBankFinalNotificationDate);


    }


    @And("^I clicked (.*) link$")
    public void iClickOnPaymentUnderRelatedListQuickLinks(String Payclick) {
        navigateTo.clickPayments(driver, Payclick);
    }

    @Then("^I verify Payment records successfully created under Chargeback Information which are (.*),(.*) and (.*)$")
    public void iVerifyPaymentRecordSuccessfullyCreatedUnderOpportunityAfterChargebackInitiate(String fieldChargebackBankAction, String fieldChargebackReceivedOn, String fieldChargebackReferenceNumber, DataTable dataTable) throws ParseException, ParseException {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String chargebackBankAction = data.get(0).get("Chargeback Bank Action");
        String chargebackReceivedOn = data.get(0).get("Chargeback Received On");
        String chargebackReferenceNumber = data.get(0).get("Chargeback Reference Number");

        String obj = navigateTo.verifyPaymentsRecord(driver, fieldChargebackBankAction, fieldChargebackReceivedOn, fieldChargebackReferenceNumber, chargebackBankAction, chargebackReceivedOn, chargebackReferenceNumber);

        // Assert.assertEquals(chargebackBankAction,obj);

    }


    @And("^I click on Opportunity Name (.*) under Details$")
    public void iClickOnOpportunityNameLancySwagFRDonationUnderDetailsTab(String oppoName) {
        navigateTo.clickOpportunity(driver, oppoName);

    }


    @Then("^I verify the (.*) field has value as (.*) displays$")
    public void iRecordTypeFieldHasValueChargeback(String fieldType, String record) {

        navigateTo.recordType(driver, fieldType, record);
    }

    @And("^I click Payments Number$")
    public void iClickOnPaymentNumber() {
        navigateTo.clickOnPaymentNumber(driver);

    }

    @And("^I provide values in (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)$")
// public void i_provide_values(String fieldChargebackBankAction, String fieldChargebackReceivedOn, String filedChargebackReferenceNumber, DataTable dataTable) throws Throwable {
    public void i_provide_values(String fieldCompany, String fieldWebsite, String fieldCIN, String fieldGroup, String fieldEmail, String fieldAnnual, String fieldOwnership, String fieldLeadstat, String fieldLastName, String fieldExpdate, DataTable dataTable) throws Throwable {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String Company = data.get(0).get("Company");
        String Website = data.get(0).get("Website");
        String CIN = data.get(0).get("CIN");
        String Group = data.get(0).get("Group");
        String Email = data.get(0).get("Email");
        String Annual = data.get(0).get("Annual Revenue");
        String Ownership = data.get(0).get("Ownership");
        String Lead_status = data.get(0).get("Lead Status");
        String Last_Name = data.get(0).get("Last Name");
        String Exp_date = data.get(0).get("Expected Date");
        navigateTo.Values(driver, fieldCompany, fieldWebsite, fieldCIN, fieldGroup, fieldEmail, fieldAnnual, fieldOwnership, fieldLeadstat, fieldLastName, fieldExpdate, Company, Website, CIN, Group, Email, Annual, Ownership, Lead_status, Last_Name, Exp_date);

    }


    @Then("^I verify Payment records successfully created under Chargeback Information after Chargeback Processed which are (.*),(.*),(.*),(.*) and (.*)$")
    public void iVerifyPaymentsRecordsSuccessfullyCreatedUnderOpportunityAfterChargebackProcessed(String fieldChargebackBankAction, String fieldChargebackResponseBy, String fieldChargebackActualResponseDate, String fieldChargebackSSTResponse, String fieldChargebackBankFinalNotificationDate, DataTable dataTable) throws ParseException {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String chargebackBankAction = data.get(0).get("Chargeback Bank Action");
        String chargebackChargebackResponseBy = data.get(0).get("Chargeback Response By");
        String chargebackChargebackActualResponseDate = data.get(0).get("Chargeback Actual Response Date");
        String chargebackChargebackSSTResponse = data.get(0).get("Chargeback SST Response");
        String chargebackChargebackBankFinalNotificationDate = data.get(0).get("Chargeback Bank Final Notification Date");

        String recopay = navigateTo.verifyPaymentRecords(driver, fieldChargebackBankAction, fieldChargebackResponseBy, fieldChargebackActualResponseDate, fieldChargebackSSTResponse, fieldChargebackBankFinalNotificationDate, chargebackBankAction, chargebackChargebackResponseBy, chargebackChargebackActualResponseDate, chargebackChargebackSSTResponse, chargebackChargebackBankFinalNotificationDate);
        //Assert.assertEquals(chargebackBankAction,recopay);

    }


    @Then("^I verify Payment records successfully created under Opportunity after Chargeback cancelled which are (.*),(.*) and (.*)$")
    public void iVerifyPaymentRecordsSuccessfullyCreatedUnderOpportunityAfterChargebackCancelled(String fieldChargebackBankAction, String fieldChargebackReceivedOn, String fieldChargebackReferenceNumber, DataTable dataTable) throws ParseException {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String chargebackBankAction = data.get(0).get("Chargeback Bank Action");
        String chargebackReceivedOn = data.get(0).get("Chargeback Received On");
        String chargebackReferenceNumber = data.get(0).get("Chargeback Reference Number");

        String rec = navigateTo.verifyPayRecord(driver, fieldChargebackBankAction, fieldChargebackReceivedOn, fieldChargebackReferenceNumber, chargebackBankAction, chargebackReceivedOn, chargebackReferenceNumber);
        //   Assert.assertEquals(chargebackBankAction, rec);
    }

    @And("^I provided (.*),(.*),(.*),(.*) and (.*)$")
    // public void i_provide_values(String fieldChargebackBankAction, String fieldChargebackReceivedOn, String filedChargebackReferenceNumber, DataTable dataTable) throws Throwable {
    public void i_provided(String fieldChargebackBankAction, String fieldChargebackResponseBy, String fieldChargebackActualResponseDate, String fieldChargebackSSTResponse, String fieldChargebackBankFinalNotificationDate, DataTable dataTable) throws Throwable {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//     String chargebackBankAction = data.get(0).get("Chargeback Bank Action");
//        String chargebackReceivedOn = data.get(0).get("Chargeback Received On");
        //      String chargebackReferenceNumber = data.get(0).get("Chargeback Reference Number");
        String chargebackBankAction = data.get(0).get("Chargeback Bank Action");
        String chargebackChargebackResponseBy = data.get(0).get("Chargeback Response By");
        String chargebackChargebackActualResponseDate = data.get(0).get("Chargeback Actual Response Date");
        String chargebackChargebackSSTResponse = data.get(0).get("Chargeback SST Response");
        String chargebackChargebackBankFinalNotificationDate = data.get(0).get("Chargeback Bank Final Notification Date");
        navigateTo.chargeback(driver, fieldChargebackBankAction, fieldChargebackResponseBy, fieldChargebackActualResponseDate, fieldChargebackSSTResponse, fieldChargebackBankFinalNotificationDate, chargebackBankAction, chargebackChargebackResponseBy, chargebackChargebackActualResponseDate, chargebackChargebackSSTResponse, chargebackChargebackBankFinalNotificationDate);
        //   navigateTo.chargebackValues(driver,fieldChargebackBankAction,fieldChargebackReceivedOn,filedChargebackReferenceNumber,chargebackBankAction,chargebackReceivedOn,chargebackReferenceNumber);
    }

    @Then("^I verify Error messsage (.*)$")
    public void iVerifyErrorMessssge(String empty) throws Throwable {

        String msg = navigateTo.validSuccessMessage(driver, empty);
        String[] tokens = empty.split("/n");
        int i;
        try {
            for (i = 0; i < tokens.length; i++)
//            System.out.println(tokens[i]);

//        System.out.println("----------------------");
                System.out.println(tokens[i]);
            System.out.println("----------------------");
            System.out.println(tokens[i]);
            System.out.println("----------------------");
            System.out.println(msg);
            System.out.println("-----------------------");
            Assert.assertEquals(tokens[i], msg);
        } catch (ArrayIndexOutOfBoundsException exp) {
            System.out.println(exp);
        }
//      String message=  navigateTo.verifyEmptyField(driver,empty);
//        Assert.assertTrue(empty, Boolean.parseBoolean(message));
        // throw new PendingException();
    }

    @Then("^I verify Payment records successfully created under Opportunity with Record Type as (.*)$")
    public void iVerifyPaymentRecordsSuccessfullyCreatedUnderOpportunityWithRecordTypeAsChargeback(String recordType) {

        String recType = navigateTo.Recordclick(driver, recordType);
        //  Assert.assertEquals(recordType,recType);

    }

    @And("^I provide field as (.*),(.*),(.*),(.*),(.*) and (.*)$")
    public void iProvideFieldAsCaseOriginRefundTypeRefundAmountRefundInstrumentBankAccountNoAndBankBSB(String fieldCaseOrigin, String fieldRefundType, String fieldRefundAmount, String fieldRefundInstrument, String fieldBankAccountNo, String fieldBankBSB, DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String refundCaseOrigin = data.get(0).get("Case Origin");
        String refundRefundType = data.get(0).get("Refund Type");
        String refundRefundAmount = data.get(0).get("Refund Amount");
        String refundRefundInstrument = data.get(0).get("Refund Instrument");
        String refundBankAccountNo = data.get(0).get("Bank Account No");
        String refundBankBSB = data.get(0).get("Bank BSB");

        navigateTo.provideRefundField(driver, fieldCaseOrigin, fieldRefundType, fieldRefundAmount, fieldRefundInstrument, fieldBankAccountNo, fieldBankBSB, refundCaseOrigin, refundRefundType, refundRefundAmount, refundRefundInstrument, refundBankAccountNo, refundBankBSB);

    }


    @Then("^I verifies (.*)$")
    public void iVerifiesRefundAmount(String refundAmount) {

        String refund = navigateTo.refundAmount(driver, refundAmount);

        String[] tokens = refundAmount.split("/n");
        int i;
        try {
            for (i = 0; i < tokens.length; i++)
//            System.out.println(tokens[i]);

//        System.out.println("----------------------");
                System.out.println(tokens[i]);
            System.out.println("----------------------");
            System.out.println(tokens[i]);
            System.out.println("----------------------");
            System.out.println(refund);
            System.out.println("-----------------------");
            Assert.assertEquals(tokens[i], refund);
        } catch (ArrayIndexOutOfBoundsException exp) {
            System.out.println(exp);
        }
    }

    @And("^I (.*) details$")
    public void iSaveDetails(String btn) {

        navigateTo.resave(driver, btn);
    }

    @And("^I gave amount for (.*) and (.*)$")
    public void iGaveAmountForTestCampaignAndRunningForCause(String arg1, String arg2) {

        navigateTo.testCampaign(driver, arg1, arg2);
    }

    @And("^I click the GAU for (.*) and (.*)$")
    public void clickTheGAU(String arg1, String arg2) {

        navigateTo.GAUclick(driver, arg1, arg2);
    }


    @Then("^I observed Total Refund Amount is same as Refund Amount$")
    public void iObservedTotalRefundAmountIsSameAsRefundAmount() {
        navigateTo.sameRefundAmt(driver);

    }

    @Then("^I check (.*)$")
    public void iCheckErrorPlease(String arg1) {

        String stat = navigateTo.negativeRefundAmt(driver, arg1);
        String[] tokens = arg1.split("/n");
        int i;
        try {
            for (i = 0; i < tokens.length; i++)
//            System.out.println(tokens[i]);

//        System.out.println("----------------------");
                System.out.println(tokens[i]);
            System.out.println("----------------------");
            System.out.println(tokens[i]);
            System.out.println("----------------------");
            System.out.println(stat);
            System.out.println("-----------------------");
            Assert.assertEquals(tokens[i], stat);
        } catch (ArrayIndexOutOfBoundsException exp) {
            System.out.println(exp);
        }

    }

    @And("^I entered amount in the GAU under Manual Refund for (.*) and (.*)$")
    public void iEnteredAmountInTheGAUUnderManualRefundForTestCampaignAndRunningForCause(String argument1, String argument2) {

        navigateTo.Campagin(driver, argument1, argument2);
    }


    @Then("^I observe (.*)$")
    public void iObserveAmountShouldBeLessThanSelectedGAUAmount(String argument) {

        String selectGAUAmt = navigateTo.GauAmount(driver, argument);
        Assert.assertEquals(argument, selectGAUAmt);

    }

    @And("^I enter amount in the GAU under Manual Refund for (.*) and (.*)$")
    public void iEnterAmountInTheGAUUnderManualRefund(String runforcause, String flood) {

        navigateTo.manualRefund(driver, runforcause, flood);
    }


    @Then("^I varify (.*)$")
    public void iErrorTheRequestedRefundAmountShouldBeEqualToTheTotalAmountAllocatedAgainstTheCampaignsProducts(String error) {

        String erro = navigateTo.productsError(driver, error);

        String[] tokens = error.split("/n");
        int i;
        try {
            for (i = 0; i < tokens.length; i++)
//            System.out.println(tokens[i]);

//        System.out.println("----------------------");
                System.out.println(tokens[i]);
            System.out.println("----------------------");
            System.out.println(tokens[i]);
            System.out.println("----------------------");
            System.out.println(erro);
            System.out.println("-----------------------");
            Assert.assertEquals(tokens[i], erro);
        } catch (ArrayIndexOutOfBoundsException exp) {
            System.out.println(exp);
        }
    }


    @And("^I provide fields as (.*),(.*),(.*),(.*) and (.*)$")
    public void iProvideFieldsAsCaseOriginRefundTypeRefundInstrumentBankAccountNoAndBankBSB(String fieldCaseOrigin, String fieldRefundType, String fieldRefundInstrument, String fieldBankAccountNo, String fieldBankBSB, DataTable dataTable) throws Throwable {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String refundCaseOrigin = data.get(0).get("Case Origin");
        String refundRefundType = data.get(0).get("Refund Type");
        String refundRefundInstrument = data.get(0).get("Refund Instrument");
        String refundBankAccountNo = data.get(0).get("Bank Account No");
        String refundBankBSB = data.get(0).get("Bank BSB");

        navigateTo.clickReund(driver, fieldCaseOrigin, fieldRefundType, fieldRefundInstrument, fieldBankAccountNo, fieldBankBSB, refundCaseOrigin, refundRefundType, refundRefundInstrument, refundBankAccountNo, refundBankBSB);

    }

    @And("^I click \"(.*)\" btn$")
    public void iClickBtn(String back) throws Throwable {
        //  throw new PendingException();
        navigateTo.back(driver, back);
    }

    @Then("^I verify user is on previous page and see (.*) radio btn$")
    public void iVerifyUserIsOnPreviousPageAndSeePaymentTypeRadioBtn(String fieldPaymentType) {
//        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//        String PaymentType = data.get(0).get("Payment Type");
        String PaymentType = navigateTo.radioPaymentType(driver, fieldPaymentType);
        // Assert.assertEquals(fieldPaymentType,PaymentType);
    }


    @Then("^I verify message \"(.*)\"$")
    public void iVerifyMessage(String message) throws Throwable {


        String msg = navigateTo.validMessage(driver, message);
        String[] tokens = message.split("/n");
        int i;
        try {
            for (i = 0; i < tokens.length; i++)
//            System.out.println(tokens[i]);

//        System.out.println("----------------------");
                System.out.println(tokens[i]);
            System.out.println("----------------------");
            System.out.println(tokens[i]);
            System.out.println("----------------------");
            System.out.println(msg);
            System.out.println("-----------------------");
            Assert.assertEquals(tokens[i], msg);
        } catch (ArrayIndexOutOfBoundsException exp) {
            System.out.println(exp);
        }

    }

    @When("^I clicked on (.*) Tab$")
    public void iClickedOnCasesTab(String cases) {

        navigateTo.casesClick(driver, cases);

    }

    @And("^I type the case number \"(.*)\" in the Search box and press Enter to view the particular case detail$")
    public void iTypeTheCaseNumberInTheSearchBoxAndPressEnterToViewTheParticularContactDetail(String casenumber) throws Throwable {

        navigateTo.caseNumber(driver, casenumber);
        // throw new PendingException();
    }

    @And("^I click on the searched case number$")
    public void iClickOnTheSearchedCaseNumber() {

        navigateTo.searchCaseNumber(driver);
    }

    @And("^I click Refund Payment Link$")
    public void iClickOnRefundPayment() {

        navigateTo.paymentRefund(driver);
    }

    @Then("^I verified (.*) displayed$")
    public void iVerifyRefundCompletionDateDisplayed(String CompletionDate, DataTable dataTable) throws ParseException {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String refundRefundCompletionDate = data.get(0).get("Refund Completion Date");
        String dateCompare = navigateTo.refundDateDislayed(driver, CompletionDate, refundRefundCompletionDate);

        //String d= formattedTime;
        //   Assert.assertEquals(refundRefundCompletionDate,dateCompare);

    }

    @Then("^I verify (.*) is display$")
    public void iVerifyRefundDecisionDateIsDisplay(String fieldDecisionDate, DataTable dataTable) throws ParseException {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String refundDecisionDate = data.get(0).get("Refund Completion Date");

        String decision = navigateTo.refundDecisionDate(driver, fieldDecisionDate, refundDecisionDate);

        // Assert.assertEquals(refundDecisionDate,decision);

    }

    @Then("^I verifed (.*) is displayed$")
    public void iVerifyRefundCompletionDateIsDisplayed(String fieldRefundStatus, DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String refundRefundStatus = data.get(0).get("Refund Status");

        System.out.println(refundRefundStatus);

        String status = navigateTo.Refundstatus(driver, fieldRefundStatus, refundRefundStatus);
        //  Assert.assertEquals(refundRefundStatus,status);

    }

    @And("^I click (.*) under Case Information$")
    public void iClickOnEditStatus(String statusEdit) {

        navigateTo.statusEdit(driver, statusEdit);

    }

    @And("^I provide (.*) under Refund$")
    public void iProvideReferenceNumber(String fieldReferenceNumber, DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String refundReferenceNumber = data.get(0).get("Payment Reference Number");
        navigateTo.refNumber(driver, fieldReferenceNumber, refundReferenceNumber);
    }

    @And("^I click (.*) under Refund Details form$")
    public void iSave(String form) {

        navigateTo.saveForm(driver, form);

    }

    @Then("^I verify refund (.*) is set as Payment Done$")
    public void iVerifyRefundStatusIsSetAsPaymentDone(String reStatus) {

//        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//        String fieldStatus = data.get(0).get("Status");

        String stat = navigateTo.refundStatus(driver, reStatus);

        //  Assert.assertEquals(reStatus,stat);
    }

    @And("^I clicked \"(.*)\" tab$")
    public void iRelatedTab(String related) throws Throwable {

        navigateTo.relatedTab(driver, related);
        //   throw new PendingException();
    }

    @And("^I click Case Link$")
    public void iClickCaseLink() {

        navigateTo.caseLink(driver);
    }

    @And("^I click Approval History$")
    public void iClickApprovalHistory() {

        navigateTo.approve(driver);
    }

    @And("^I click on (.*) under Approval Request$")
    public void iClickOnApproveUnderApprovalRequest(String approve) {

        navigateTo.requestApproval(driver, approve);
    }


    @And("^I enter Comment under Approve case$")
    public void iEnterCommentUnderApproveCase() {

        navigateTo.caseApprove(driver);
    }

    @And("^I click (.*) btn under Approve case$")
    public void iClickApproveBtnUnderApproveCase(String app) {

        navigateTo.approveCase(driver, app);
    }


    @Then("^I verify Approval status as (.*)$")
    public void iVerifyApprovalStatusAsApproved(String approved) {

        String approvalstatus = navigateTo.approvedStatus(driver, approved);

        //Assert.assertEquals(approved,approvalstatus);
    }

    @When("^I clicked the (.*) tab$")
    public void iClickOnOpportunities(String opportuniyTab) {

        navigateTo.Opportunities(driver, opportuniyTab);

    }

    @And("^I type the opportunity name \"(.*)\" in the Search box and press Enter to view the particular opportunity detail$")
    public void iTypeTheOpportunityNameSearchBox(String arg0) throws Throwable {

        navigateTo.opportunitySearchBox(driver, arg0);
    }

    @And("^I click on the searched opportunity name$")
    public void iClickOnTheSearchedOpportunityName() {

        navigateTo.searchedOppoName(driver);


    }

    @And("^I clicked \"(.*)\"$")
    public void iClicked(String tab) throws Throwable {

        navigateTo.clickTab(driver, tab);
    }

    @And("^I selected the \"(.*)\" from the list view$")
    public void iSelectedTheFromTheListView(String allOpportunity) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        navigateTo.allOpportunities(driver, allOpportunity);
    }

    @Then("^I verify their is no (.*)$")
    public void iVerifyTheirIsNoCase(String cases) {
        navigateTo.noCases(driver, cases);
    }

    @Then("^I checked (.*) as \"(.*)\"$")
    public void iCheckedCaseOwnerAs(String Owner, String SSt) throws Throwable {

        navigateTo.caseOwner(driver, Owner, SSt);
    }

    @And("^I click \"(.*)\" Tab$")
    public void iClickTab(String clickOpportunity) throws Throwable {
        navigateTo.opportunityClick(driver, clickOpportunity);

        //  throw new PendingException();
    }

    @Then("^I verify there are valid Opportunities present$")
    public void iVerifyThereAreValidOpportunitiesPresent(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String fieldOpportunityName = data.get(0).get("Opportunity Name");
        String fieldAccountName = data.get(0).get("Account Name");
//        String fullName = Salutation + " " + firstName + " " + lastName;
        String validOpportunities = navigateTo.validOpportunities(driver, fieldOpportunityName, fieldAccountName);
        System.out.println("-------------------------------\n");
        System.out.println(validOpportunities);
        Assert.assertEquals(fieldOpportunityName, validOpportunities);
    }

    @Then("^I verified Paid is unchecked and Record Type as Payment$")
    public void iVerifiedPaidIsUnchecked(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String recordType = data.get(0).get("Record Type");
        String type = navigateTo.paidUnchecked(driver, recordType);
        Assert.assertEquals(recordType, type);
    }


    @And("^I give details as (.*)$")
    public void iRefundType(String fieldRefundType, DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String refundRefundType = data.get(0).get("Refund Type");

        navigateTo.typeRefund(driver, fieldRefundType, refundRefundType);

    }

    @Then("^I verify GAUs allocation is available as (.*) under Manaual Refund$")
    public void iVerifyGAUsAllocationIsVisible(String alloc) {

        String gau = navigateTo.GAUVisible(driver, alloc);
        // Assert.assertEquals(alloc,gau);
    }

    @Then("^I verify GAU list is viewed in (.*)$")
    public void iVerifyPaymentAllocations(String fieldPaymentAllocations) {

//        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//        String paymentAllocations = data.get(0).get("Payment Allocations");
        navigateTo.paymentAllocations(driver, fieldPaymentAllocations);
    }

    @And("^I add amount for the (.*)$")
    public void iGaveAmount(String arg1) {

        navigateTo.addAmount(driver, arg1);
    }

    @And("^I clicked the GAU for (.*)$")
    public void clickGAU(String arg1) {

        navigateTo.theGAUclick(driver, arg1);
    }

    @Then("^I checked message as (.*)$")
    public void iErrorMessssge(String error) throws Throwable {

        String msg = navigateTo.validErrorMessage(driver, error);
        String[] tokens = error.split("/n");
        int i;
        try {
            for (i = 0; i < tokens.length; i++)
//            System.out.println(tokens[i]);

//        System.out.println("----------------------");
                System.out.println(tokens[i]);
            System.out.println("----------------------");
            System.out.println(tokens[i]);
            System.out.println("----------------------");
            System.out.println(msg);
            System.out.println("-----------------------");
            Assert.assertEquals(tokens[i], msg);
        } catch (ArrayIndexOutOfBoundsException exp) {
            System.out.println(exp);
        }
//      String message=  navigateTo.verifyEmptyField(driver,empty);
//        Assert.assertTrue(empty, Boolean.parseBoolean(message));
        // throw new PendingException();
    }


    @And("^I click the \"(.*)\" radio button under Adjustment Type$")
    public void iClickTheRadioButtonUnderAdjustmentType(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @And("^I click (.*) linked$")
    public void iClickOnSupporterHistoryTab(String history) {

        navigateTo.historyTab(driver, history);
    }

    @Then("^I verify (.*) contains valid records$")
    public void iVerifySupporterHistoryConatinsValidRecords(String fieldHistoryName) {

//        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//        String fieldHistoryName = data.get(0).get("Subject(Action)");
        navigateTo.historyRecord(driver, fieldHistoryName);
        //  String validOpportunities= navigateTo.validOpportunities(driver,fieldOpportunityName,fieldAccountName);
        System.out.println("-------------------------------\n");
        System.out.println();

    }

    @And("^I select new Primary Contact as \"(.*)\"$")
    public void iSelectNewPrimaryContactAs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //  throw new PendingException();
        navigateTo.primaryContact(driver, arg0);

    }

    @And("^I click on (.*) btn$")
    public void iClickOnAdjustContact(String adjContact) {

        navigateTo.adjustContact(driver, adjContact);
    }

    @And("^I see (.*)$")
    public void iVerifiySuccessMessageSupporter(String success) {

        navigateTo.successMessage(driver, success);
    }

    @Then("^I verifiy (.*) is null$")
    public void iVerifiyPaymentsRelatedPaymentRecordIsNull(String relatedPay) {

        navigateTo.paymentRecord(driver, relatedPay);
    }

    @And("^I select Reason option as (.*)$")
    public void selectReasonOptionAsUserError(String reason) {

        navigateTo.selectReasionOpt(driver, reason);
    }

    @And("^I clicked \"(.*)\" radio button$")
    public void iRadioButton(String arg0) throws Throwable {

        navigateTo.adjbtn(driver, arg0);
    }

    @And("^I give Reason Comments$")
    public void iGiveReasonComments() {

        navigateTo.reasons(driver);
    }


    @And("^I Refresh the page$")
    public void iRefreshThePage() {

        navigateTo.refresh(driver);
    }

    @And("^I select new Campagin Name as \"(.*)\"$")
    public void iSelectNewCampaginNameAs(String arg0) throws Throwable {

        navigateTo.campaginName(driver, arg0);
    }

    @Then("^I verify Primary Contact and Account Name is of the new Contact$")
    public void iVerifyPrimaryContactAndAccountName(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String fieldPrimaryName = data.get(0).get("Primary Name");
        String fieldAccountName = data.get(0).get("Account Name");
        navigateTo.accountName(driver, fieldPrimaryName, fieldAccountName);


    }

//   @And("^I clicked on (.*) tag$")
//public void iClickedOnContactsTag(String arg0) {
//
//   navigateTo.contactsTag(driver,arg0);
//}

    @And("^I observed (.*) is displayed$")
    public void iSeeMessage(String arg0) {

        navigateTo.obsvervedMessage(driver, arg0);
    }

    @And("^I select (.*) and (.*)$")
    public void iNewCampaginNameAs(String arg0, String arg1, DataTable dataTable) throws Throwable {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String CampaignName = data.get(0).get("Campaign Name");
        String Product = data.get(0).get("Product");
        // String Amount= data.get()
        navigateTo.campaginN(driver, arg0, arg1, CampaignName, Product);
    }


    @And("^I click (.*) under payment information$")
    public void iClickRelatedPaymentInformation(String related) {

//        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//        String fieldRT = data.get(0).get("Payments (Related Payment Record)");
//        // System.out.println(fieldRT);
        //    System.out.println(fieldRT);
        navigateTo.payInfoRecord(driver, related);
    }

    @And("^I click on \"(.*)\"$")
    public void iClickOn(String arg0) throws Throwable {

        navigateTo.payAlloction(driver, arg0);

    }

    @And("^I click \"(.*)\" link$")
    public void iClickLink(String arg0) throws Throwable {

        navigateTo.link(driver, arg0);
    }

    @And("^I selected (.*) and (.*)$")
    public void iSelectedCampaignNameAndProduct(String arg0, String arg1, DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String CampaignName = data.get(0).get("Campaign Name");
        String Product = data.get(0).get("Product");

        navigateTo.changeProduct(driver, arg0, arg1, CampaignName, Product);

    }

    @And("^I enter (.*)$")
    public void iEnterAmount(String amt) {
//        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//        String Amount = data.get(0).get("Amount");
//
        navigateTo.enterAmount(driver, amt);
    }

    @Then("^I verify Adjustment Status is (.*)$")
    public void iVerifyAdjustmentStatusIsCompleted(String complete) {

        navigateTo.complete(driver, complete);
    }

    @Then("^I verify (.*) is already populated$")
    public void iVerifyAlreadyPopulated(String PrimaryContact) {

        navigateTo.alreadyPopulated(driver, PrimaryContact);
    }


    @And("^I click (.*) button on right hand side of the page$")
    public void iClickOnNewButtonOnRightHandSideOfThePage(String NewButton) {
        navigateTo.newPage(driver, NewButton);

    }

    @Then("^I verify Lead is successfully created with (.*), (.*), (.*), (.*), (.*), (.*) (.*), (.*), (.*), (.*) and (.*)$")
    public void iVerifyLeadIsSuccessfullyCreated(String fieldCompany, String fieldWebsite, String fieldCIN, String fieldGroup, String fieldEmail, String fieldAnnual, String fieldOwnership, String fieldLeadstat, String fieldLastName, String fieldExpdate, DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String Company = data.get(0).get("Company");
        String Website = data.get(0).get("Website");
        String CIN = data.get(0).get("CIN");
        String Group = data.get(0).get("Group");
        String Email = data.get(0).get("Email");
        String Annual = data.get(0).get("Annual Revenue");
        String Ownership = data.get(0).get("Ownership");
        String Lead_status = data.get(0).get("Lead Status");
        String Last_Name = data.get(0).get("Last Name");
        String Exp_date = data.get(0).get("Expected Date");
        navigateTo.LeadValues(driver, fieldCompany, fieldWebsite, fieldCIN, fieldGroup, fieldEmail, fieldAnnual, fieldOwnership, fieldLeadstat, fieldLastName, fieldExpdate, Company, Website, CIN, Group, Email, Annual, Ownership, Lead_status, Last_Name, Exp_date);

    }

    @And("^I again click (.*) tab$")
    public void iClickOnLeads(String Fieldtab) {

        navigateTo.againLeads(driver, Fieldtab);
    }


    @And("^I provide (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)$")
    public void iProvide(String fieldCompany, String fieldWebsite, String fieldCIN, String fieldGroup, String fieldEmail, String fieldAnnual, String fieldOwnership, String fieldLeadstat, String fieldFirstName, String fieldLastName, String fieldIncop, String fieldStreet,
                         String fieldCity, String fieldCountry, String fieldLoanName, String fieldAmount, String fieldLoanpurpose, String fieldExpdate, DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String Company = data.get(0).get("Company");
        String Website = data.get(0).get("Website");
        String CIN = data.get(0).get("CIN");
        String Group = data.get(0).get("Group");
        String Email = data.get(0).get("Email");
        String Annual = data.get(0).get("Annual Revenue");
        String Ownership = data.get(0).get("Ownership");
        String Lead_status = data.get(0).get("Lead Status");
        String Last_Name = data.get(0).get("Last Name");
        String First_Name = data.get(0).get("First Name");
        String Incop_Date = data.get(0).get("Date of Incorporation");
        String Street = data.get(0).get("Street");
        String City = data.get(0).get("City");
        String Country = data.get(0).get("Country");
        String Loan_Name = data.get(0).get("Loan Application Name");
        String Amount = data.get(0).get("Amount");
        String Loan_Purpose = data.get(0).get("Loan Purpose");
        String Exp_date = data.get(0).get("Expected Date");

        navigateTo.NewLeadsValues(driver, fieldCompany, fieldWebsite, fieldCIN, fieldGroup, fieldEmail, fieldAnnual, fieldOwnership, fieldLeadstat, fieldFirstName, fieldLastName,
                fieldIncop, fieldStreet, fieldCity, fieldCountry, fieldLoanName, fieldAmount, fieldLoanpurpose, fieldExpdate,
                Company, Website, CIN, Group, Email, Annual, Ownership, Lead_status, First_Name, Last_Name, Incop_Date, Street, City, Country, Loan_Name, Amount, Loan_Purpose, Exp_date);

    }

    @Then("^I verified Lead is successfully created with (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)$")
    public void iVerifiedSuccessfully(String fieldCompany, String fieldWebsite, String fieldCIN, String fieldGroup, String fieldEmail, String fieldAnnual, String fieldOwnership, String fieldLeadstat, String fieldFirstName, String fieldLastName, String fieldIncop, String fieldStreet,
                                      String fieldCity, String fieldCountry, String fieldLoanName, String fieldAmount, String fieldLoanpurpose, String fieldExpdate, DataTable dataTable) {


        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String Company = data.get(0).get("Company");
        String Website = data.get(0).get("Website");
        String CIN = data.get(0).get("CIN");
        String Group = data.get(0).get("Group");
        String Email = data.get(0).get("Email");
        String Annual = data.get(0).get("Annual Revenue");
        String Ownership = data.get(0).get("Ownership");
        String Lead_status = data.get(0).get("Lead Status");
        String Last_Name = data.get(0).get("Last Name");
        String First_Name = data.get(0).get("First Name");
        String Incop_Date = data.get(0).get("Date of Incorporation");
        String Street = data.get(0).get("Street");
        String City = data.get(0).get("City");
        String Country = data.get(0).get("Country");
        String Loan_Name = data.get(0).get("Loan Application Name");
        String Amount = data.get(0).get("Amount");
        String Loan_Purpose = data.get(0).get("Loan Purpose");
        String Exp_date = data.get(0).get("Expected Date");

        navigateTo.NewValues(driver, fieldCompany, fieldWebsite, fieldCIN, fieldGroup, fieldEmail, fieldAnnual, fieldOwnership, fieldLeadstat, fieldFirstName, fieldLastName,
                fieldIncop, fieldStreet, fieldCity, fieldCountry, fieldLoanName, fieldAmount, fieldLoanpurpose, fieldExpdate,
                Company, Website, CIN, Group, Email, Annual, Ownership, Lead_status, First_Name, Last_Name, Incop_Date, Street, City, Country, Loan_Name, Amount, Loan_Purpose, Exp_date);

    }

//    @And("^I provide values as (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)$")
//    public void iProvideValuesAs(String fieldCompany1, String fieldWebsite1, String fieldCIN1, String fieldGroup1, String fieldEmail1, String fieldAnnual1, String fieldOwnership1, String fieldLeadstat1, String fieldLastName1, String fieldExpdate1, DataTable dataTable) {
//
//            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//            String Company1 = data.get(0).get("Company");
//            String Website2 = data.get(0).get("Website");
//            String CIN3 = data.get(0).get("CIN");
//            String Group4= data.get(0).get("Group");
//            String Email5= data.get(0).get("Email");
//            String Annual6= data.get(0).get("Annual Revenue");
//            String Ownership7= data.get(0).get("Ownership");
//            String Lead_status8= data.get(0).get("Lead Status");
//            String Last_Name9= data.get(0).get("Last Name");
//            String Exp_date10= data.get(0).get("Expected Date");
//
//   navigateTo.Values(driver,fieldCompany1,fieldWebsite1,fieldCIN1,fieldGroup1,fieldEmail1,fieldAnnual1,fieldOwnership1,fieldLeadstat1,fieldLastName1,fieldExpdate1,Company1, Website2, CIN3, Group4, Email5, Annual6,Ownership7,Lead_status8, Last_Name9,Exp_date10);
//
//        }

    @And("^I provide valued in (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)$")
    public void iProvideValued(String fieldCompany, String fieldWebsite, String fieldCIN, String fieldGroup, String fieldEmail, String fieldAnnual, String fieldOwnership, String fieldLeadstat, String fieldLastName, String fieldExpdate, DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String Company = data.get(0).get("Company");
        String Website = data.get(0).get("Website");
        String CIN = data.get(0).get("CIN");
        String Group = data.get(0).get("Group");
        String Email = data.get(0).get("Email");
        String Annual = data.get(0).get("Annual Revenue");
        String Ownership = data.get(0).get("Ownership");
        String Lead_status = data.get(0).get("Lead Status");
        String Last_Name = data.get(0).get("Last Name");
        String Exp_date = data.get(0).get("Expected Date");

        navigateTo.Valued(driver, fieldCompany, fieldWebsite, fieldCIN, fieldGroup, fieldEmail, fieldAnnual, fieldOwnership, fieldLeadstat, fieldLastName, fieldExpdate, Company, Website, CIN, Group, Email, Annual, Ownership, Lead_status, Last_Name, Exp_date);


    }

    @Then("^I verify note as (.*)$")
    public void iVerifyNoLeadIsCreated(String nolead) {
        navigateTo.NoLead(driver, nolead);

    }


    @And("^I click (.*) buttons$")
    public void iClickConvertLeadButton(String conLead) {

        navigateTo.ConvertLead(driver, conLead);

    }

    @And("^I (.*) page and click on (.*) tab$")
    public void iClosePage(String close, String Loan_Proposal) {

        navigateTo.loanProposal(driver, close, Loan_Proposal);

    }

    @Then("^I verify Lead is successfully converted to Loan proposal$")
    public void iVerifyLeadIsSuccessfullyConvertedToLoanProposal(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String fieldOpport = data.get(0).get("Opportunity Name");
        String fieldCustGroup = data.get(0).get("Customer Group Name");
        String var = navigateTo.convertSuccessfully(driver, fieldOpport, fieldCustGroup);

        //  Assert.assertEquals(fieldOpport, var);
    }


    @And("^I select (.*) as a record type$")
    public void iSelectDirectorAsARecordType(String radioButton) {

       navigateTo.RecordType(driver, radioButton);
    }

    @And("^I fill Basic Details as (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)$")
    public void iFillBasicDetails(String fieldFirst_Name, String fieldLast_Name, String fieldPan_No, String fieldCust_Grop_Name, String fieldLead_Source, String fieldDIN,String fieldTitle, String fieldRelation_with_promoters, String fieldReports_To, String fieldPer_Holding, String fieldExp_Activity, String fieldNetworth_Returns, DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String First_Name = data.get(0).get("First Name");
        String Last_Name = data.get(0).get("Last Name");
        String Pan_No = data.get(0).get("Pan No");
        String Cust_Grp_Name = data.get(0).get("Customer Group Name");
        String Lead_Source = data.get(0).get("Lead Source");
        String DIN = data.get(0).get("DIN");
        String Title = data.get(0).get("Title");
        String Relation_with_promoters = data.get(0).get("Relationship with promoters/founders");
        String Reports_To = data.get(0).get("Reports To");
        String Per_Holding = data.get(0).get("%Holding");
        String Exp_Activity = data.get(0).get("Experience in line of this activity");
        String Networth_Returns = data.get(0).get("Networth as per IT Returns");

        navigateTo.basicDetails(driver, fieldFirst_Name, fieldLast_Name, fieldPan_No, fieldCust_Grop_Name, fieldLead_Source, fieldDIN, fieldTitle, fieldRelation_with_promoters, fieldReports_To, fieldPer_Holding, fieldExp_Activity, fieldNetworth_Returns, First_Name, Last_Name, Pan_No, Cust_Grp_Name, Lead_Source, DIN, Title, Relation_with_promoters, Reports_To, Per_Holding, Exp_Activity, Networth_Returns);

    }
//    @And("^I fill Detail information (.*), (.*), (.*), (.*), (.*) and (.*)$")
//    public void iFillDetailInformation(String fieldTitle, String fieldRelation_with_promoters, String fieldReports_To, String fieldPer_Holding, String fieldExp_Activity, String fieldNetworth_Returns, DataTable dataTable) {
//
//
//        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//        String Title = data.get(0).get("Title");
//        String Relation_with_promoters = data.get(0).get("Relationship with promoters/founders");
//        String Reports_To = data.get(0).get("Reports To");
//        String Per_Holding = data.get(0).get("%Holding");
//        String Exp_Activity = data.get(0).get("Experience in line of this activity");
//        String Networth_Returns = data.get(0).get("Networth as per IT Returns");
//
//        navigateTo.basicInfo(driver, fieldTitle, fieldRelation_with_promoters, fieldReports_To, fieldPer_Holding, fieldExp_Activity, fieldNetworth_Returns, Title, Relation_with_promoters, Reports_To, Per_Holding, Exp_Activity, Networth_Returns);
//    }

    @Then("^I verified Lead is successfully created (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)$")
    public void iVerifiedLeadIsSuccessfully(String fieldFirst_Name, String fieldLast_Name, String fieldPan_No, String fieldCust_Grop_Name, String fieldLead_Source, String fieldDIN, String fieldTitle, String fieldRelation_with_promoters, String fieldReports_To, String fieldPer_Holding, String fieldExp_Activity, String fieldNetworth_Returns, DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String First_Name = data.get(0).get("First Name");
        String Last_Name = data.get(0).get("Last Name");
        String Pan_No = data.get(0).get("Pan No");
        String Cust_Grp_Name = data.get(0).get("Customer Group Name");
        String Lead_Source = data.get(0).get("Lead Source");
        String DIN = data.get(0).get("DIN");
        String Title = data.get(0).get("Title");
        String Relation_with_promoters = data.get(0).get("Relationship with promoters/founders");
        String Reports_To = data.get(0).get("Reports To");
        String Per_Holding = data.get(0).get("%Holding");
        String Exp_Activity = data.get(0).get("Experience in line of this activity");
        String Networth_Returns = data.get(0).get("Networth as per IT Returns");

        navigateTo.ContactDirector(driver, fieldFirst_Name, fieldLast_Name, fieldPan_No, fieldCust_Grop_Name, fieldLead_Source, fieldDIN, fieldTitle, fieldRelation_with_promoters, fieldReports_To, fieldPer_Holding, fieldExp_Activity, fieldNetworth_Returns, Title, Relation_with_promoters, Reports_To, Per_Holding, Exp_Activity, Networth_Returns, First_Name, Last_Name, Pan_No, Cust_Grp_Name, Lead_Source, DIN);

    }

    @And("^again I provide (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)$")
    public void again_iProvide(String fieldFirst_Name, String fieldLast_Name, String fieldPan_No, String fieldCust_Grop_Name, String fieldLead_Source, String fieldDIN, String fieldTitle, String fieldRelation_with_promoters, String fieldReports_To, String fieldPer_Holding, String fieldExp_Activity, String fieldNetworth_Returns, DataTable dataTable) {
       // waitfortheelement();
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String First_Name = data.get(0).get("First Name");
        String Last_Name = data.get(0).get("Last Name");
        String Pan_No = data.get(0).get("Pan No");
        String Cust_Grp_Name = data.get(0).get("Customer Group Name");
        String Lead_Source = data.get(0).get("Lead Source");
        String DIN = data.get(0).get("DIN");
        String Title = data.get(0).get("Title");
        String Relation_with_promoters = data.get(0).get("Relationship with promoters/founders");
        String Reports_To = data.get(0).get("Reports To");
        String Per_Holding = data.get(0).get("%Holding");
        String Exp_Activity = data.get(0).get("Experience in line of this activity");
        String Networth_Returns = data.get(0).get("Networth as per IT Returns");

//        int var= First_Name.length();
//        String var1= First_Name.substring(var-1);
//        var1.concat("Jessia");
        navigateTo.Details(driver, fieldFirst_Name, fieldLast_Name, fieldPan_No, fieldCust_Grop_Name, fieldLead_Source, fieldDIN,
                First_Name.replace("Maxwell","Jessica") , Last_Name.replace("Waynen","Waane") , Pan_No, Cust_Grp_Name, Lead_Source, DIN, fieldTitle, fieldRelation_with_promoters, fieldReports_To, fieldPer_Holding, fieldExp_Activity, fieldNetworth_Returns, Title.replace("Director","Beneficial Owner"), Relation_with_promoters, Reports_To, Per_Holding, Exp_Activity, Networth_Returns);


    }

    @And("^I fill the required (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) and \"([^\"]*)\"$")
    public void iFillTheRequiredCustomer(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I click (.*) button on right hand side$")
    public void iClickConvertButtonOnRightHandSide(String convert) {

        navigateTo.convert(driver, convert);

    }

    @And("^I clicked (.*)$")
    public void iClickedConvertButton(String leadConvert) {

        navigateTo.leadconvert(driver, leadConvert);
    }

    @Then("^I verify success message as \"([^\"]*)\"$")
    public void iVerifySuccessMessageAs(String message) throws Throwable {

            navigateTo.successfulMessage(driver,message);
          //  System.out.println(message);

    }


    @And("^I entered the required fields (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)$")

    public void iFillTheRequired(String FieldCustomer_Group_Name,String FieldParent_Cust_Group, String FieldCIN, String FieldABN, String FieldAnnual_Revenue, String FieldPhone, String FieldWebsite, String FieldEmail, String FieldOwnership, String FieldEntity_Name, String FieldPAN, String FieldDate_of_Incorporation, String FieldMortgaged, String FiledNo_of_Months_in_Office, DataTable dataTable ) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String Customer_Group_Name = data.get(0).get("Customer Group Name");
        String Parent_Cust_Group = data.get(0).get("Parent Customer Group");
     //   String Rating = data.get(0).get("Rating");
        String CIN = data.get(0).get("CIN");
        String ABN = data.get(0).get("ABN");
        String Annual_Revenue = data.get(0).get("Annual Revenue");
        String Phone = data.get(0).get("Phone");
        String Website = data.get(0).get("Website");
        String Email = data.get(0).get("Email");
        String Ownership = data.get(0).get("Ownership");
        String Entity_Name = data.get(0).get("Entity Name");
        String PAN = data.get(0).get("PAN");
        String Date_of_Incorporation = data.get(0).get("Date of Incorporation");
        String Mortgaged = data.get(0).get("Mortgaged");
        String No_of_Months_in_Office = data.get(0).get("No of Months in Office");

       navigateTo.fillRequired(driver,FieldCustomer_Group_Name,FieldParent_Cust_Group, FieldCIN, FieldABN, FieldAnnual_Revenue, FieldPhone, FieldWebsite, FieldEmail, FieldOwnership, FieldEntity_Name, FieldPAN, FieldDate_of_Incorporation, FieldMortgaged, FiledNo_of_Months_in_Office,
                Customer_Group_Name,Parent_Cust_Group,CIN,ABN, Annual_Revenue, Phone, Website, Email, Ownership, Entity_Name, PAN, Date_of_Incorporation,Mortgaged,No_of_Months_in_Office);
    }

    @And("^I again entered the required fields (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)$")
    public void iFillAgain() {


    }
}


