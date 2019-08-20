
package SalesforceSystemTest.navigation;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class NavigateTo {

    @Step("Open the Salesforce home page")
    public void LogintoSalesforce(WebDriver driver) {
        String salesforceURL = getConfigurationDetails("webdriver.base.url");
        String userName = getConfigurationDetails("Salesforce.username");
        String passWord = getConfigurationDetails("Salesforce.password");
        driver.get(salesforceURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(passWord);
        driver.findElement(By.xpath("//input[@id='Login']")).click();
    }

    public String getConfigurationDetails(String nameURL) {
        EnvironmentVariables props = Injectors.getInjector().getInstance(EnvironmentVariables.class);
        String configDetails = EnvironmentSpecificConfiguration.from(props).getProperty(nameURL);
        return configDetails;
    }


    public void waitfortheelement() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickContacts(WebDriver driver, String tagname) {
        waitfortheelement();
        // String e=driver.findElement(By.xpath("//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none'][a[span[@class='slds-truncate'][text()='"+ tagname +"']]]")).getText();


        driver.findElement(By.xpath(".//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none'][a[span[@class='slds-truncate'][text()='" + tagname + "']]]")).click();
//       // driver.findElement(By.xpath(".//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none'][a[@title='Once Off']]//span")).click();
//        driver.findElement(By.xpath("//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none']//a[@class='slds-context-bar__label-action dndItem']//span[text()='Once Off']")).click();
        // driver.findElement(By.xpath(".//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none']//a//span[@class='slds-truncate'][text()='"+ tagname +"']")).click();
        waitfortheelement();
    }

    public void clickNewContact(WebDriver driver) {
        waitfortheelement();
        WebElement element1 = driver.findElement(By.xpath("//div[contains(@class,'menuItemsWrapper')]//span//span[contains(text(),'New Contact')]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element1);


    }

    public void clickOnDropdown(WebDriver driver) {
        waitfortheelement();
        driver.findElement(By.xpath("(//lightning-icon[@class='slds-icon-utility-chevrondown slds-icon_container'])[2]")).click();
        waitfortheelement();
    }

    public void clickNewOpportunity(WebDriver driver) {
        waitfortheelement();
        WebElement element1 = driver.findElement(By.xpath("//div[contains(@class,'menuItemsWrapper')]//span//span[contains(text(),'New Opportunity')]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element1);
        waitfortheelement();
//        Actions act1 = new Actions(driver);
//        act1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//        waitfortheelement();

    }

    public void clickOpportunitydropdown(WebDriver driver) {
        waitfortheelement();
        driver.findElement(By.xpath("(//lightning-icon[@class='slds-icon-utility-chevrondown slds-icon_container'])[5]")).click();
        waitfortheelement();
    }

    public void enterAllDetails(WebDriver driver, String fieldName, String fieldValue) {
        driver.findElement(By.xpath("//div[contains(@class,'uiInput')]//span[contains(text(),'" + fieldName + "')]/../..//input")).sendKeys(fieldValue);
    }


    public void scrollDown(WebDriver driver) {
        waitfortheelement();

    //    WebElement elem = driver.findElement(By.xpath("//span[@class='test-id__section-header-title slds-truncate'][text()='Chargeback Information']"));

    //    JavascriptExecutor jse = (JavascriptExecutor)driver;
   //     jse.executeScript("arguments[0].scrollIntoView(true);",elem);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,1250)");
       //driver.findElement(By.xpath("//span[@class='test-id__section-header-title slds-truncate'][text()='Chargeback Information']"));
       Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        waitfortheelement();

    }

    public void scrollUP(WebDriver driver) {
        waitfortheelement();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_UP).build().perform();
        waitfortheelement();

    }

    public void insertRecords(WebDriver driver, String fieldSalutation, String fieldFirstName, String fieldLastName, String fieldPhone, String firstName, String lastName, String Salutation, String Phone) {
        waitfortheelement();
        driver.findElement(By.xpath("//div[contains(@class,'uiInputSelect')]//span[contains(text(),'" + fieldSalutation + "')]/../..//div[contains(@class,'salutation')]//a")).click();
        waitfortheelement();
        driver.findElement(By.xpath("//div[contains(@class,'select-options')]//a[contains(@title,'" + Salutation + "')]")).click();
        waitfortheelement();
        enterAllDetails(driver, fieldFirstName, firstName);
        enterAllDetails(driver, fieldLastName, lastName);
        enterAllDetails(driver, fieldPhone, Phone);


    }

    public void clickSave(WebDriver driver, String buttonName) {
        //waitfortheelement();

        driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton'][@title='"+buttonName+"']")).click();

//        driver.findElement(By.xpath("//button[@title='" + buttonName + "']//span[@class=' label bBody']")).click();
//
//        try {
//            String duplicateMessage = driver.findElement(By.xpath("//div[@class ='slds-col slds-align-middle']")).getText();
//
//            if (duplicateMessage != null && duplicateMessage.contains("duplicate")) {
//                driver.findElement(By.xpath("//button[@title='" + buttonName + "']//span[@class=' label bBody']")).click();
//            }
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//            System.out.println("Second Save Button Doesn't Exist");
//        }
    }

    public void clickNext(WebDriver driver) {
        waitfortheelement();
        driver.findElement(By.xpath("//span[@class=' label bBody'][text()='Next']")).click();
        waitfortheelement();
    }


    public void recentlyViewedDropdown(WebDriver driver, String dropdown) {
        waitfortheelement();
        driver.findElement(By.xpath("//a[contains(@class,'slds-button slds-button--reset d')][contains(@title,'" + dropdown + "')]")).click();
        waitfortheelement();
//        Actions act1 = new Actions(driver);
//        waitfortheelement();
//        act1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//        waitfortheelement();
    }

    public void allContacts(WebDriver driver, String contact) {
        waitfortheelement();
        driver.findElement(By.xpath("//span[@class= ' virtualAutocompleteOptionText'][contains(text(),'" + contact + "')]")).click();
        waitfortheelement();
        Actions act1 = new Actions(driver);
        waitfortheelement();
        act1.sendKeys(Keys.ENTER).build().perform();
        waitfortheelement();
    }

    public void contactNameInSearch(WebDriver driver, String name) {
        waitfortheelement();
//        String contactName = getConfigurationDetails("Salesforce.contactName");
        String contactName = name;
        driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys(contactName);
        waitfortheelement();
        Actions act1 = new Actions(driver);
        waitfortheelement();
        act1.sendKeys(Keys.ENTER).build().perform();
        waitfortheelement();
    }

    public void searchContactName(WebDriver driver) {
        waitfortheelement();
        waitfortheelement();
        waitfortheelement();
        WebElement e = driver.findElement(By.xpath("//table[contains(@class,'uiVirtualDataTable')]//tbody"));

        waitfortheelement();

        List<WebElement> rows = e.findElements(By.tagName("tr"));
        WebElement firstRecordFound = rows.get(0);

        firstRecordFound.findElement(By.tagName("th")).findElement(By.tagName("a")).click();
        waitfortheelement();
        waitfortheelement();
        waitfortheelement();
    }
//    public void enterTagName(WebDriver driver, String TagName, String TagValue) {
//        driver.findElement(By.xpath("//li[@class ='tabs__item uiTabItem']//a[@title='"+  TagName +" ']")).sendKeys(TagValue);

    public void clickTabName(WebDriver driver, String tagName) {
        waitfortheelement();
        //String filedTagName =TagName;
        WebElement elem = driver.findElement(By.xpath("(//a[@class='tabHeader'][@title='"+tagName+"']//span[@class='title'][text()='" + tagName + "'])[2]"));
      //  WebElement elem = driver.findElement(By.xpath("//a[@class='tabHeader'][@title='"+tagName+"']//span[@class='title'][text()='"+tagName+"']"));
        elem.click();
        waitfortheelement();
        waitfortheelement();
    }

    public void clickNewEngagementPlans(WebDriver driver, String buttonName) {
        waitfortheelement();
        waitfortheelement();
        driver.findElement(By.xpath("(//li[@class='slds-button slds-button--neutral slds-truncate']//a[contains(@title,'" + buttonName + "')])[4]")).click();
        waitfortheelement();
    }

    public void clickNewEngagementPlansTemplet(WebDriver driver) {
        waitfortheelement();
        waitfortheelement();
        driver.findElement(By.xpath("(//li[@class='slds-button slds-button--neutral slds-truncate']//a[contains(@title,'New')])[10]")).click();
        waitfortheelement();
//    (//li[@class='slds-button slds-button--neutral slds-truncate']//a[contains(@title,'New')])[10]
    }

    public void clickTextboxOfEngagementPlan(WebDriver driver) {
        waitfortheelement();
        driver.findElement(By.xpath("//div[contains(@class,'createNew itemContainer')]")).click();
        waitfortheelement();
        waitfortheelement();

    }

    public void verifyDetails(WebDriver driver, String ept, String contactName) {
        waitfortheelement();
        waitfortheelement();
        String eptNum = driver.findElement(By.xpath("//div//span[text()='Engagement Plan Template']/../..//div//a")).getText();
        String cName = driver.findElement(By.xpath("//div//span[text()='Contact']/../..//div//a")).getText();


//        System.out.println("-----------------------------------------------------");
//        System.out.println(eptNum);
//        System.out.println(eptNum.getText());
//        System.out.println("-----------------------------------------------------");

//        System.out.println(cName);
//        System.out.println(cName.getText());
//        System.out.println("-----------------------------------------------------");

        Assert.assertEquals(eptNum, ept);
        Assert.assertEquals(contactName, cName);
    }

    public void clickOnEpn(WebDriver driver, String filedEPN) {
        waitfortheelement();
        waitfortheelement();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("scrollBy(0,50)");
//        driver.findElement(By.tagName("table"));
//        String el =driver.findElement(By.xpath("//th[@class='initialSortAsc '][text()='"+ filedEPN +"']/../../..//div[@class='outputLookupContainer forceOutputLookupWithPreview']//a")).getText();
//        WebElement e= driver.findElement(By.xpath("//th[@class='initialSortAsc '][text()='"+ filedEPN +"']/../../..//div[@class='outputLookupContainer forceOutputLookupWithPreview']//a"));
//        System.out.println("----------------------------------------------");
//        System.out.println(el);
//        System.out.println("-----------------------------------------------");
//        List<WebElement> rows = e.findElements(By.tagName("tr"));
//        WebElement firstRecordFound = rows.get(0);
//
//        firstRecordFound.findElement(By.tagName("th")).findElement(By.tagName("a")).click();
//        //driver.findElement(By.xpath("//th[@class='initialSortAsc '][text()='"+ filedEPN +"']/../../..//div[@class='outputLookupContainer forceOutputLookupWithPreview']//a[text()='"+ filedNumer +"']")).click();
//        String e =driver.findElement(By.xpath("(//table[contains(@class,'forceRecordLayout slds-table')])[1]")).getText();
//        System.out.println("----------------------------------------------");
//        System.out.println(e);
//        System.out.println("----------------------------------------------");
//        System.out.println(driver.findElement(By.xpath("(//table[contains(@class,'forceRecordLayout slds-table')])[1]")).findElements(By.tagName("tr")));
//
//        System.out.println("-----------------------------------------------");
        driver.findElement(By.xpath("(//tr//th[@class='initialSortAsc ']/../../..//div[@class='outputLookupContainer forceOutputLookupWithPreview']//a)[1]")).click();
        waitfortheelement();
    }

    public void clickOnEditButton(WebDriver driver, String ERMButton) {
        waitfortheelement();
        waitfortheelement();
        driver.findElement(By.xpath("//button[@title='" + ERMButton + "']")).click();
        waitfortheelement();
    }

    public void clickOnRelationshipManager(WebDriver driver, String Name) {
        waitfortheelement();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,50)");
        driver.findElement(By.xpath(".//span[@class='pillText'][text()='" + Name + "']")).click();
        waitfortheelement();
    }

    public void verifyURM(WebDriver driver, String ManagerName, String RnManager) {
        waitfortheelement();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,-250)");
        String Name = driver.findElement(By.xpath("//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']//span[text()='" + RnManager + "']/../..//span[@class='pillText']")).getText();
        waitfortheelement();
        System.out.println("-----------------------------------------------------");
        System.out.println(Name);
        System.out.println("-----------------------------------------------------");

        Assert.assertEquals(Name, ManagerName);
    }

    //    public void enterRelationshipManager(WebDriver driver,String FirstName,String LastName){
//        waitfortheelement();
//        WebElement Name = driver.findElement(By.xpath("//span[text()='"+ ManagerName +"']"));
//        waitfortheelement();
//
//    }
    public void crossMark(WebDriver driver, String RnManager) {
        waitfortheelement();
        driver.findElement(By.xpath("//span[text()='" + RnManager + "']/../..//a[@class='deleteAction']//span[@class='deleteIcon']")).click();
        waitfortheelement();
        waitfortheelement();
    }

    public void ClosePopUp(WebDriver driver, String close) {
        waitfortheelement();
        waitfortheelement();
        driver.findElement(By.xpath("//div[@class='container']//div//button[@title='" + close + "']")).click();
        waitfortheelement();
    }


    public WebElement getVisibility(WebDriver driver, By locator, int timeout) {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public void clickElementWhenClickable(WebDriver driver, By locator, int timeout) {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }


    public void verifyPRM(WebDriver driver, String previousManager) {
        waitfortheelement();
        waitfortheelement();
        String xPath = "//span[text()='Previous Relationship Manager']/../..//a[@class=' textUnderline outputLookupLink slds-truncate forceOutputLookup']";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,-250)");
        String testname = driver.findElement(By.xpath(xPath)).getText();

        Assert.assertEquals(previousManager, testname);

    }

    public void clickOnURM(WebDriver driver, String UndoRM) {
        waitfortheelement();
        waitfortheelement();
        String OldManager = driver.findElement(By.xpath("//span[text()='" + UndoRM + "']/../..//a[@class=' textUnderline outputLookupLink slds-truncate forceOutputLookup']")).getText();
        System.out.println("Old Manager=" + OldManager);
        waitfortheelement();
    }

    public void verifyDetailsUnderContact(WebDriver driver, String fullName, String filedPhone) {
        waitfortheelement();
        waitfortheelement();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,-250)");
        String fullName1 = driver.findElement(By.xpath("//span[text()='Name']/../..//span[@class='uiOutputText']")).getText();
        String PhoneNo = driver.findElement(By.xpath("//span[text()='Phone']/../..//span[@class='uiOutputPhone']")).getText();
        System.out.println("-------------------Name-----------------------");
        System.out.println(fullName);
        System.out.println("--------------------Phone----------------------");
        System.out.println(PhoneNo);
        waitfortheelement();
        Assert.assertEquals(fullName1, fullName);
        Assert.assertEquals(PhoneNo, filedPhone);
    }

    public void verifyCorrectErrorMessage(WebDriver driver, String message) {
        waitfortheelement();
        waitfortheelement();
        String msg = driver.findElement(By.xpath("//li[text()='" + message + "']")).getText();
        waitfortheelement();

        Assert.assertEquals(msg, message);
    }

    public void verifyErrorMessage(WebDriver driver, String message) {
        waitfortheelement();
        waitfortheelement();
        String msg = driver.findElement(By.xpath("//li[@class='form-element__help']")).getText();
//        System.out.println("=--------------------------------------------");
//        System.out.println(msg);
//        System.out.println("----------------------------------------------");
        waitfortheelement();

        Assert.assertEquals(msg, message);
    }

    public void clickCheckBox(WebDriver driver, String checkbox) {
        waitfortheelement();
        waitfortheelement();
        driver.findElement(By.xpath("//label//span[text()='" + checkbox + "']/../..//input[@type='checkbox']")).click();
        waitfortheelement();
    }

    public void selectDonation(WebDriver driver) {
        waitfortheelement();
        driver.findElement(By.xpath(".//span[@class='slds-radio--faux']/../..//div[@class='changeRecordTypeOptionRightColumn']//span[contains(text(),'Donation')]")).click();
        waitfortheelement();
    }

    public void insertdetails(WebDriver driver, String fieldOpportunityName, String fieldPrimaryCampaignSource, String filedCloseDate, String filedStage, String opportunityName, String primaryCampaignSource, String closeDate, String stage) {
        waitfortheelement();
        enterAllDetails(driver, fieldOpportunityName, opportunityName);
        driver.findElement(By.xpath("//label[contains(@class,'label inputLabel uiLabel-left form-element__label uiLabel')]//span[text()='Primary Campaign Source']")).click();

        //driver.findElement(By.xpath("//span[text()='Primary Campaign Source']/../..//div[contains(@class,'primaryLabel slds')]")).sendKeys(fieldPrimaryCampaignSource);
        driver.findElement(By.xpath("//span[text()='Primary Campaign Source']/../..//div[contains(@class,'primaryLabel slds')][@title='" + primaryCampaignSource + "']")).click();
        waitfortheelement();
        WebElement element = driver.findElement(By.xpath("//label[contains(@class,'label inputLabel')]//span[text()='Close Date']/../..//a[contains(@class, 'datePicker-openIcon')]//span[@class='assistiveText']"));
        waitfortheelement();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        waitfortheelement();
        driver.findElement(By.xpath("//td[@class='uiDayInMonthCell'][@data-datevalue='" + closeDate + "']")).click();
        // driver.findElement(By.xpath("//td[@class='uiDayInMonthCell']//span[text()='"+ closeDate +"']")).click();
        waitfortheelement();
        String e = driver.findElement(By.xpath("//span[contains(@class,'label inputLabel')]//span[text()='Stage']")).getText();
        System.out.println(e);

        driver.findElement(By.xpath("//span[contains(@class,'label inputLabel')]//span[text()='Stage']/../..//a[@class='select']")).click();
        driver.findElement(By.xpath(".//li[@class='uiMenuItem uiRadioMenuItem']//a[@title='Posted']")).click();
    }

    public void provideEngagementPlanName(WebDriver driver) {
        waitfortheelement();
        waitfortheelement();
        waitfortheelement();
//        int size =driver.findElements(By.tagName("iframe")).size();
//        System.out.println("------------------------------");
//        System.out.println(size);
//        System.out.println("=======------------------------");
//        for(int i=0; i<=size; i++){
//            driver.switchTo().frame(i);
//            int total=driver.findElements(By.xpath("html/body/a/img")).size();
//            System.out.println(total);
//            driver.switchTo().defaultContent();}
        driver.switchTo().frame(0);
        waitfortheelement();
        driver.findElement(By.xpath("//label[@class='slds-form-element__label']//abbr/../..//input[@class='slds-input']")).sendKeys("High Value Prospect Journey");

    }

    public void MEPTSave(WebDriver driver) {
        waitfortheelement();
        driver.findElement(By.xpath("//input[@class='btn slds-button slds-button_brand']")).click();
        driver.switchTo().defaultContent();
    }

    public void selectRelated(WebDriver driver) {
        driver.findElement(By.xpath("(//a[@class='tabHeader'][@title='Related']//span[@class ='title'][text()='Related'])[2]")).click();
    }

    public void selectAccount(WebDriver driver, String filedAccount) {
        waitfortheelement();
        driver.findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']//input[@title='Search Accounts']")).click();
        driver.findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']//input[@title='Search Accounts']/..//div//div[@title='" + filedAccount + "']")).click();
    }

    public void selectEngagementPlan(WebDriver driver) {
        waitfortheelement();
        driver.findElement(By.xpath("//div[@class='primaryLabel slds-truncate slds-lookup__result-text']")).click();
        waitfortheelement();
    }

    public void verfyopportunitydetails(WebDriver driver, String filedOpportunityName, String filedPrimaryCampaignSource, String filedCloseDate, String filedStage) {
        waitfortheelement();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,250)");
        String Opprtunity = driver.findElement(By.xpath("//div//span//span[@class='uiOutputText']")).getText();
        waitfortheelement();
        System.out.println("----------------------------------------");
        System.out.println(Opprtunity);
        System.out.println("-----------------------------------------");
        String PrimaryCampaignSource = driver.findElement(By.xpath("//div[contains(@class,'test-id__field-label')]//span[text()='Primary Campaign Source']/../..//div//a[contains(@class,'textUnderline outputLookup')]")).getText();
        System.out.println("----------------------------------------");
        System.out.println(PrimaryCampaignSource);
        System.out.println("----------------------------------------");
        String Date = driver.findElement(By.xpath("//div//span//span[@class='uiOutputDate']")).getText();
        System.out.println("----------------------------------------");
        System.out.println(filedCloseDate);
        System.out.println("----------------------------------------");
        String Stage = driver.findElement(By.xpath("//div//span[@class='test-id__field-label'][text()='Stage']/../..//span[contains(@class,'test-id__field-value slds-form-element__static slds-grow')]//span")).getText();

//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        String strDate= formatter.format(filedCloseDate);
//        System.out.println("-------------------------------");
//        System.out.println(strDate);
//        System.out.println("--------------------------------");


        Assert.assertEquals(Opprtunity, filedOpportunityName);
        Assert.assertEquals(PrimaryCampaignSource, filedPrimaryCampaignSource);
        Assert.assertEquals(filedCloseDate, Date);
        Assert.assertEquals(Stage, filedStage);
    }

    public void verifyAnonymousSupporter(WebDriver driver, String filedPhone, String fullName) {
        waitfortheelement();
        waitfortheelement();
        String fullName1 = driver.findElement(By.xpath("//span[text()='Name']/../..//span[@class='uiOutputText']")).getText();
        String PhoneNo = driver.findElement(By.xpath("//span[text()='Phone']/../..//span[@class='uiOutputPhone']")).getText();
//        List list = driver.findElements(By.name("radioButton"));
//
//        // Create a boolean variable to store true/false.
//        Boolean is_selected = list.get(0).isSelected();
        Assert.assertEquals(fullName1, fullName);
        Assert.assertEquals(PhoneNo, filedPhone);

    }

    public void clickNewTask(WebDriver driver, String task) {
        waitfortheelement();
        driver.findElement(By.xpath("//a//div[@title='" + task + "']")).click();
        waitfortheelement();
    }

    public void newTaskDetails(WebDriver driver, String Assignedto, String Subject, String Status, String Priorty) {
        waitfortheelement();
//        driver.findElement(By.xpath("//lightning-icon[contains(@class,'lightning-primitive-icon')]")).click();
        driver.findElement(By.xpath("//li[@class='pillContainerListItem']//a//span[@class='pillText']")).click();
        waitfortheelement();
        driver.findElement(By.xpath("//label[text()='Subject']/..//div//input[@class='slds-input slds-combobox__input']")).click();
        //WebElement element =
        driver.findElement(By.xpath("//label[text()='Subject']/..//div//input[@class='slds-input slds-combobox__input']/../..//span[@title='" + Subject + "']")).click();
        waitfortheelement();
        WebElement element = driver.findElement(By.xpath("//span[contains(@class,'label inputLabel')]//span[text()='Status']/../..//div[@class='uiMenu']//div[@class='uiPopupTrigger']"));
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        element.click();
        waitfortheelement();
        driver.findElement(By.xpath("//span[contains(@class,'label inputLabel')]//span[text()='Status']/../..//div[@class='uiMenu']//a")).click();
//        driver.findElement(By.xpath("//span[contains(@class,'label inputLabel')]//span[text()='Status']/../..//div[@class='uiMenu']//div[@class='uiPopupTrigger']")).click();
        waitfortheelement();

        driver.findElement(By.xpath("//div[@class='select-options']//ul[@class='scrollable']//li//a[text()='" + Status + "']")).click();
        ////div//ul[@class='scrollable']//li//a[@title='In Progress']
        driver.findElement(By.xpath("//span[contains(@class,'label inputLabel')]//span[text()='Priority']/../..//div[@class='uiMenu']//div[@class='uiPopupTrigger']")).click();
        waitfortheelement();
        driver.findElement(By.xpath("//div[@class='select-options']//ul[@class='scrollable']//li//a[text()='" + Priorty + "']")).click();
    }

    public void clickActivityHistory(WebDriver driver) {
        waitfortheelement();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,150)");
        // driver.findElement(By.xpath("//table[contains(@class,'forceRecordLayout slds-table')]//tr//th//div//a[@class='textUnderline outputLookupLink slds-truncate forceOutputLookup']")).click();
        driver.findElement(By.xpath("(//tr//th//div[@class='outputLookupContainer forceOutputLookupWithPreview']//a)[1]")).click();

    }

    public void verifywarningMessage(WebDriver driver, String filedMessage) {
        String msg = driver.findElement(By.xpath("//div//div[@class ='slds-col slds-align-middle']")).getText();

        System.out.println("----------------------------------");
        System.out.println(msg);
        System.out.println("----------------------------------");
        Assert.assertEquals(msg, filedMessage);
    }

    public void enterphone(WebDriver driver, String filedPhone) {
        waitfortheelement();
        waitfortheelement();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,150)");
        driver.findElement(By.xpath("//label//span[text()='Phone']/../..//input[contains(@class,'input')]")).clear();
        waitfortheelement();
        driver.findElement(By.xpath("//label//span[text()='Phone']/../..//input[contains(@class,'input')]")).sendKeys(filedPhone);

    }

    public void verifyDetailsContactPage(WebDriver driver, String name, String phoneNo) {
        waitfortheelement();
        waitfortheelement();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,-250)");
        String fullName1 = driver.findElement(By.xpath("//span[text()='Name']/../..//span[@class='uiOutputText']")).getText();
        String PhoneNo = driver.findElement(By.xpath("//span[text()='Phone']/../..//span[@class='uiOutputPhone']")).getText();

        waitfortheelement();
        Assert.assertEquals(fullName1, name);
        Assert.assertEquals(PhoneNo, phoneNo);
    }

    public void verifyBequestorStatusDropdown(WebDriver driver, String Status) {
        waitfortheelement();
        driver.findElement(By.xpath("//span[text()='Bequestor Status']/../..//div[@class='uiMenu']//div[@class='uiPopupTrigger']")).click();
        waitfortheelement();
        driver.findElement(By.xpath("//div[@class='select-options']//ul[@class='scrollable']//li//a[@title='" + Status + "']")).click();
        waitfortheelement();
    }

    public void verifyBequestorStatus(WebDriver driver, String filedStatus) {
        waitfortheelement();
        waitfortheelement();
//        String status = driver.findElement(By.xpath("//div[@class='select-options']//ul[@class='scrollable']//li//a[@title='"+ filedStatus +"']")).getText();
        String status = driver.findElement(By.xpath("//div//span//span[text()='" + filedStatus + "']")).getText();
        waitfortheelement();
        System.out.println("*********************");
        System.out.println(status);
        System.out.println("**********************");

        Assert.assertEquals(filedStatus, status);
    }

    public void selectBequestManager(WebDriver driver, String filedManager) {
        waitfortheelement();
        driver.findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']//input[contains(@class,' default input uiInpu')][@title='Search Accounts']")).click();
        waitfortheelement();
        String e = driver.findElement(By.xpath("//div[contains(@class,'undefined lookup__menu uiAbstractList')]//div//div[contains(@class,'primaryLabel slds')][text()='Suma Srinivasaiah']")).getText();

        System.out.println("----------------------------");
        System.out.println(e);
        System.out.println("----------------------------");
        driver.findElement(By.xpath("//div[contains(@class,'undefined lookup__menu uiAbstractList')]//div//div[contains(@class,'primaryLabel slds')][text()='Suma Srinivasaiah']")).click();
    }

    public void clickOpportunitybutton(WebDriver driver) {
        waitfortheelement();
        driver.findElement(By.xpath("//div//a[@class='rlql-relatedListLink']//span[@title='Opportunities']")).click();
        waitfortheelement();
    }

    public void clickopportunityname(WebDriver driver, String OppName) {
        waitfortheelement();
        driver.findElement(By.xpath("//th//span[@class='slds-grid slds-grid--align-spread']//a[@title='" + OppName + "']")).click();
        waitfortheelement();
    }

    public void clickOnPayment(WebDriver driver) {
        waitfortheelement();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,50)");
        driver.findElement(By.xpath("//th//div//a[@class='textUnderline outputLookupLink slds-truncate forceOutputLookup']")).click();
        waitfortheelement();
    }

    public void verifyPSandRT(WebDriver driver, String filedPS, String filedRT) {
        waitfortheelement();
        String PaymentStatus = driver.findElement(By.xpath("//div//span//span[@class='uiOutputTextArea'][text()='" + filedPS + "']")).getText();
        String RecordType = driver.findElement(By.xpath("//span[text()='Record Type']/../..//div[@class='recordTypeName slds-grow slds-truncate']//span")).getText();
        waitfortheelement();
        System.out.println("*************************");
        System.out.println(PaymentStatus);
        System.out.println("**************************");
        System.out.println(RecordType);
        System.out.println("*********");

        Assert.assertEquals(filedPS, PaymentStatus);
        Assert.assertEquals(filedRT, RecordType);
    }

    public void searchPaymentId(WebDriver driver, String filedPUID) {
        waitfortheelement();
        driver.findElement(By.xpath("//div[@class='uiInput uiAutocomplete uiInput--default']//input")).sendKeys(filedPUID);
        waitfortheelement();
        Actions act1 = new Actions(driver);
        waitfortheelement();
        act1.sendKeys(Keys.ENTER).build().perform();
    }

    public void searchSalesforceTextbox(WebDriver driver) {
        driver.findElement(By.xpath("//div[@class='uiInput uiAutocomplete uiInput--default']//input")).click();
        waitfortheelement();
    }

    public void clickPaymentNumber(WebDriver driver) {
        waitfortheelement();
        driver.findElement(By.xpath("//th//span//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']")).click();
        waitfortheelement();
    }

    public void verifyPaymentRecord(WebDriver driver, String filedPaymentID, String filedrecordType) {
        waitfortheelement();
        String PaymentId = driver.findElement(By.xpath("//span[text()='Payment Unique Id']/../..//span[@class='uiOutputText']")).getText();
        String RecordType = driver.findElement(By.xpath("//span[text()='Record Type']/../..//div[@class='recordTypeName slds-grow slds-truncate']//span")).getText();
        waitfortheelement();
        System.out.println("*************************");
        System.out.println(PaymentId);
        System.out.println("**************************");
        System.out.println(RecordType);
        System.out.println("*********");

        Assert.assertEquals(filedPaymentID, PaymentId);
        Assert.assertEquals(filedrecordType, RecordType);
    }

    public void provideDetails(WebDriver driver, String fieldOpportunityName, String fieldPrimaryCampaignSource, String filedCloseDate, String filedStage, String filedPrimaryContact, String filedAmount, String opportunityName, String primaryCampaignSource, String closeDate, String stage, String primaryContact, String amount) {
        waitfortheelement();
        enterAllDetails(driver, fieldOpportunityName, opportunityName);
        driver.findElement(By.xpath("//label[contains(@class,'label inputLabel uiLabel-left form-element__label uiLabel')]//span[text()='Primary Campaign Source']")).click();

        driver.findElement(By.xpath("//span[text()='Primary Campaign Source']/../..//div[contains(@class,'primaryLabel slds')][@title='" + primaryCampaignSource + "']")).click();
        waitfortheelement();
        WebElement element = driver.findElement(By.xpath("//label[contains(@class,'label inputLabel')]//span[text()='" + filedCloseDate + "']/../..//a[contains(@class, 'datePicker-openIcon')]//span[@class='assistiveText']"));
        waitfortheelement();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        waitfortheelement();
        driver.findElement(By.xpath("//td[@class='uiDayInMonthCell'][@data-datevalue='" + closeDate + "']")).click();
        waitfortheelement();
        String e = driver.findElement(By.xpath("//span[contains(@class,'label inputLabel')]//span[text()='" + filedStage + "']")).getText();
        System.out.println(e);

        driver.findElement(By.xpath("//span[contains(@class,'label inputLabel')]//span[text()='" + filedStage + "']/../..//a[@class='select']")).click();
        driver.findElement(By.xpath(".//li[@class='uiMenuItem uiRadioMenuItem']//a[@title='" + stage + "']")).click();
        driver.findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']//input[@title='Search Contacts']")).click();
        driver.findElement(By.xpath("//div[@class='slds-m-left--smalllabels slds-truncate slds-media__body']//div[@title='" + primaryContact + "']")).click();
        driver.findElement(By.xpath("//div//input[@class='input uiInput uiInput--default uiInput--input']")).sendKeys(amount);
    }

    public void selectCheckbox(WebDriver driver) {
        waitfortheelement();
        driver.findElement(By.xpath("//label//span[text()='Do Not Automatically Create Payment']/../..//input")).click();
    }

    public void provideContactName(WebDriver driver, String filedName) {
        waitfortheelement();
        driver.findElement(By.xpath("//label[text()='Contact Name']/..//input[contains(@class,'slds-lookup__search-input')]")).click();
        driver.findElement(By.xpath("//label[text()='Contact Name']/..//input[contains(@class,'slds-lookup__search-input')]")).sendKeys(filedName);
//        driver.findElement(By.xpath("//span[@class='slds-media__body']//span[@class='slds-listbox__option-text slds-listbox__option-text_entity'][text()='"+ filedName +"']")).click();
//        waitfortheelement();
    }

    public void provideDetailsOnce(WebDriver driver, String fieldCampaignAppealName, String fieldBatchId, String filedChannel, String filedReceipting, String filedDonationAmount, String filedPayment, String campaignAppealName, String batchId, String channel, String receipting, String donationAmount, String payment) {

        driver.findElement(By.xpath("//label[text()='Campaign/Appeal Name']/..//input[contains(@class,'slds-lookup__search-input slds')]")).click();
        driver.findElement(By.xpath("//li//span[@class='slds-media__body']//span[text()='" + campaignAppealName + "']")).click();

        driver.findElement(By.xpath("//label[text()='Batch Id']/..//input[contains(@class,'slds-lookup__search-input slds')]")).click();
        driver.findElement(By.xpath("//span[@class='slds-media__body']//span[text()='" + batchId + "']")).click();

        driver.findElement(By.xpath("//label//span[text()='Channel']/../..//div[@class='slds-select_container']")).click();
        WebElement testDropDown = driver.findElement(By.xpath("//label//span[text()='Channel']/../..//select[@class='slds-select']"));
        Select dropdown = new Select(testDropDown);
        dropdown.selectByVisibleText(channel);

        driver.findElement(By.xpath("//label//span[text()='Receipting']/../..//div[@class='slds-select_container']")).click();
        WebElement testDropDown2 = driver.findElement(By.xpath("//label//span[text()='Receipting']/../..//select[@class='slds-select']"));
        Select dropdown2 = new Select(testDropDown2);
        dropdown2.selectByVisibleText(receipting);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,150)");
        driver.findElement(By.xpath("//label[text()='Donation Amount']/..//input[@name='expenseclient']")).click();
        driver.findElement(By.xpath("//label[text()='Donation Amount']/..//input[@name='expenseclient']")).sendKeys(donationAmount);

        driver.findElement(By.xpath("//label//span[text()='Payment Method']/../..//div[@class='slds-select_container']")).click();
        WebElement testDropDown3 = driver.findElement(By.xpath("//label//span[text()='Payment Method']/../..//select[@class='slds-select']"));
        Select dropdown3 = new Select(testDropDown3);
        dropdown3.selectByVisibleText(payment);
        waitfortheelement();
    }

    public void clickCreatePayment(WebDriver driver) {
        waitfortheelement();
        driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand slds-m-top--medium']")).click();
    }

    public void selectRadioButton(WebDriver driver) {
        waitfortheelement();
        driver.findElement(By.xpath("//label[@class='slds-radio__label']//span[contains(text(),'Stark opp - 50.00')]")).click();
        waitfortheelement();
        driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand'][@title='Donation Selected']")).click();
    }

    public void clickDonationLink(WebDriver driver) {
        waitfortheelement();
        driver.findElement(By.xpath("//div[@class='slds-modal__content slds-p-around_medium']//a")).click();
    }

    public void clickOnCheckbox(WebDriver driver, String filedCheckbox) {
        waitfortheelement();
        driver.findElement(By.xpath("//button[contains(@class,'slds-button test-id')][@title='Edit Paid']")).click();
        driver.findElement(By.xpath("//label//span[text()='" + filedCheckbox + "']/../..//input[@type='checkbox']")).click();
    }

    public void selectPaymentDate(WebDriver driver, String fieldPaymentDate,String fieldDate) {
       // driver.findElement(By.xpath("//label[contains(@class,'label inputLabel')]//span[text()='" + filedPaymentDate + "']/../..//a[contains(@class, 'datePicker-openIcon')]")).click();
        driver.findElement(By.xpath("//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']//span[text()='"+fieldPaymentDate+"']/..//..//a[@class='datePicker-openIcon display']")).click();
        waitfortheelement();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String strDate = dateFormat.format(date);

        driver.findElement(By.xpath("//td[@class='uiDayInMonthCell'][@data-datevalue='"+fieldDate+"']")).click();

    }

    public void clickRadioButton(WebDriver driver, String filedName) {
        waitfortheelement();
        driver.findElement(By.xpath("//div//span[@class='slds-radio']//input[@value='"+filedName+"']/..//label[@class='slds-radio__label']")).click();
    }

      public void chargebackValue(WebDriver driver, String fieldChargebackBankAction, String fieldChargebackReceivedOn, String filedChargebackReferenceNumber, String chargebackBankAction, String chargebackReceivedOn, String chargebackReferenceNumber) {
          waitfortheelement();
          driver.findElement(By.xpath("//label[text()='" + fieldChargebackBankAction + "']")).click();
          driver.findElement(By.xpath("//label[text()='" + fieldChargebackBankAction + "']/..//span[@title='" + chargebackBankAction + "']")).click();

          driver.findElement(By.xpath("//label[text()='"+fieldChargebackReceivedOn+"']/..//input")).click();
//          DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//          Date date = new Date();
//          String strDate = dateFormat.format(date);

          driver.findElement(By.xpath("//td[@data-value='" + chargebackReceivedOn + "']")).click();

          driver.findElement(By.xpath("//label[text()='" + filedChargebackReferenceNumber + "']/..//input")).clear();
          driver.findElement(By.xpath("//label[text()='" + filedChargebackReferenceNumber + "']/..//input")).sendKeys(chargebackReferenceNumber);
          JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("scrollBy(0,50)");
      }

    public void chargebackValues(WebDriver driver, String fieldChargebackBankAction,String fieldChargebackResponseBy, String fieldChargebackActualResponseDate, String fieldChargebackSSTResponse, String fieldChargebackBankFinalNotificationDate, String chargebackBankAction, String chargebackChargebackResponseBy,String chargebackChargebackActualResponseDate, String chargebackChargebackSSTResponse, String chargebackChargebackBankFinalNotificationDate) {
        waitfortheelement();

        driver.findElement(By.xpath("//label[text()='" + fieldChargebackBankAction + "']")).click();
        driver.findElement(By.xpath("//label[text()='" + fieldChargebackBankAction + "']/..//span[@title='" + chargebackBankAction + "']")).click();

        driver.findElement(By.xpath("//label[text()='"+fieldChargebackResponseBy+"']/..//input")).click();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date();
//        String strDate = dateFormat.format(date);
        driver.findElement(By.xpath("//td[@data-value='" + chargebackChargebackResponseBy + "']")).click();
        waitfortheelement();

        driver.findElement(By.xpath("//label[text()='"+fieldChargebackActualResponseDate+"']/..//input")).click();
        driver.findElement(By.xpath("//td[@data-value='" + chargebackChargebackActualResponseDate + "']")).click();

        waitfortheelement();
        driver.findElement(By.xpath("//label[text()='" + fieldChargebackSSTResponse + "']")).click();
        driver.findElement(By.xpath("//label[text()='" + fieldChargebackSSTResponse + "']/..//span[@title='" + chargebackChargebackSSTResponse + "']")).click();
        waitfortheelement();

        driver.findElement(By.xpath("//label[text()='"+fieldChargebackBankFinalNotificationDate+"']/..//input")).click();
        driver.findElement(By.xpath("//td[@data-value='" + chargebackChargebackBankFinalNotificationDate + "']")).click();

        waitfortheelement();
    }

    public void verifySuccessMessage(WebDriver driver, String message) {
        waitfortheelement();
        String msg = driver.findElement(By.xpath("//div[@class='confirm uiMessage']//div[@class='bBody'][text()='Chargeback has been initiated and is in progress.']")).getText();
        waitfortheelement();

        Assert.assertEquals(message, msg);
    }

    public void verifyRecord(WebDriver driver) {
        String record = driver.findElement(By.xpath("//span[@class='test-id__field-label'][text()='Related Payment Record']/../..//a")).getText();

        System.out.println(record);
    }

    public void verifyTaskDetails(WebDriver driver, String assignedto, String subject, String status, String priority) {
        waitfortheelement();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,150)");
        String Assigned_To = driver.findElement(By.xpath("//div//span[text()='Assigned To']/../..//div[@class='ownerName']//a")).getText();
        String Sub = driver.findElement(By.xpath("//div//span[text()='Subject']/../..//span[@class='uiOutputText']")).getText();
        String Stat = driver.findElement(By.xpath("//div//span[text()='Status']/../..//span[text()='" + status + "']")).getText();
        String Prio = driver.findElement(By.xpath("//div//span[text()='Priority']/../..//span[text()='" + priority + "']")).getText();

        Assert.assertEquals(assignedto, Assigned_To);
        Assert.assertEquals(subject, Sub);
        Assert.assertEquals(status, Stat);
        Assert.assertEquals(priority, Prio);
    }

    public void clickOpportunity(WebDriver driver, String oppoName) {

        waitfortheelement();
        driver.findElement(By.xpath("//a[@class=' textUnderline outputLookupLink slds-truncate forceOutputLookup'] [text()='" + oppoName + "'] ")).click();
        waitfortheelement();
    }

    public void clickPayments(WebDriver driver, String Payclick) {
        waitfortheelement();
        driver.findElement(By.xpath("//div//a//span[@class='rlql-label'][text()='" + Payclick + "']")).click();
        waitfortheelement();
    }

    public void verifyPaymentsRecord(WebDriver driver,String fieldChargebackBankAction,String fieldChargebackReceivedOn, String fieldChargebackReferenceNumber,String chargebackBankAction,String chargebackReceivedOn,String chargebackReferenceNumber) throws ParseException {

        waitfortheelement();
        System.out.println("-------------------------------");
        System.out.println(chargebackBankAction);
        System.out.println("--------------------------------");
        System.out.println(chargebackReceivedOn);
        System.out.println("--------------------------------");
        System.out.println(chargebackReferenceNumber);
        System.out.println("----------------------------");
//        String act = driver.findElement(By.xpath("//span[@class='test-id__field-label'][text()='Chargeback Bank Action']/../..//span[@class='test-id__field-value slds-form-element__static slds-grow ']//span")).getText();
//        String date = driver.findElement(By.xpath("//span[text()='Chargeback Received On']/../..//span[@class='uiOutputDate']")).getText();
//        String num = driver.findElement(By.xpath("//span[@class='test-id__field-label'][text()='Chargeback Reference Number']/../..//span[@class='uiOutputText']")).getText();

        String act = driver.findElement(By.xpath(".//span[@class='test-id__field-label'][text()='"+fieldChargebackBankAction+"']/../..//span[@class='test-id__field-value slds-form-element__static slds-grow ']//span")).getText();
        String date = driver.findElement(By.xpath("//span[text()='"+fieldChargebackReceivedOn+"']/../..//span[@class='uiOutputDate']")).getText();
        String num = driver.findElement(By.xpath("//span[@class='test-id__field-label'][text()='"+fieldChargebackReferenceNumber+"']/../..//span[@class='uiOutputText']")).getText();
//       String str = "Chargeback initiated";
      //  String str1= "2019-08-27";
//        String str2= "CN100102";



       SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
       Date data= sdf.parse(chargebackReceivedOn);
      // String strDate= sdf.format(data);
       String formattedTime = sdf.format(data);

     //  Date date1= sdf.parse(fieldChargebackReceivedOn);
       // Date date2= sdf.parse(chargebackReceivedOn);
//            if(date1.compareTo(date2)==0)
//            {
//                System.out.println("Both dates are same!");
//            }
//            else
//            {
//                System.out.println("Not same");
//            }


        System.out.println("-------------------------------");
        System.out.println(act);
        System.out.println("--------------------------------");
        System.out.println(formattedTime);
        System.out.println("--------------------------------");
        System.out.println(num);
        System.out.println("--------------------------------");

        Assert.assertEquals(chargebackBankAction, act);
        Assert.assertEquals(chargebackReceivedOn, formattedTime);
        Assert.assertEquals(chargebackReferenceNumber, num);
    }

    public void verifyPaymentRecords(WebDriver driver,String fieldChargebackBankAction,String fieldChargebackResponseBy,String fieldChargebackActualResponseDate,String fieldChargebackSSTResponse,String fieldChargebackBankFinalNotificationDate,String chargebackBankAction,String chargebackChargebackResponseBy,String chargebackChargebackActualResponseDate,String chargebackChargebackSSTResponse,String chargebackChargebackBankFinalNotificationDate) throws ParseException {

        waitfortheelement();
        waitfortheelement();
        System.out.println("------------------------------------");
        System.out.println(chargebackBankAction);
        System.out.println("--------------------------------");
        System.out.println(chargebackChargebackResponseBy);
        System.out.println("--------------------------------");
        System.out.println(chargebackChargebackActualResponseDate);
        System.out.println("----------------------------");
        System.out.println(chargebackChargebackSSTResponse);
        System.out.println("----------------------------");
        System.out.println(chargebackChargebackBankFinalNotificationDate);
        System.out.println("----------------------------");

//        String act = driver.findElement(By.xpath(".//span[@class='test-id__field-label'][text()='Chargeback Bank Action']/../..//span[@class='test-id__field-value slds-form-element__static slds-grow ']//span")).getText();
//        String response = driver.findElement(By.xpath("//span[text()='Chargeback Response By']/../..//span[@class='uiOutputDate']")).getText();
//        String actual = driver.findElement(By.xpath("//span[text()='Chargeback Actual Response Date']/../..//span[@class='uiOutputDate']")).getText();
//        String sst = driver.findElement(By.xpath(".//span[@class='test-id__field-label'][text()='Chargeback SST Response']/../..//span[@class='test-id__field-value slds-form-element__static slds-grow ']//span")).getText();
//        String finalbank = driver.findElement(By.xpath("//span[text()='Chargeback Bank Final Notification Date']/../..//span[@class='uiOutputDate']")).getText();

        String act = driver.findElement(By.xpath(".//span[@class='test-id__field-label'][text()='"+fieldChargebackBankAction+"']/../..//span[@class='test-id__field-value slds-form-element__static slds-grow ']//span")).getText();
        String response = driver.findElement(By.xpath("//span[text()='"+fieldChargebackResponseBy+"']/../..//span[@class='uiOutputDate']")).getText();
        String actual = driver.findElement(By.xpath("//span[text()='"+fieldChargebackActualResponseDate+"']/../..//span[@class='uiOutputDate']")).getText();
        String sst = driver.findElement(By.xpath(".//span[@class='test-id__field-label'][text()='"+fieldChargebackSSTResponse+"']/../..//span[@class='test-id__field-value slds-form-element__static slds-grow ']//span")).getText();
        String finalbank = driver.findElement(By.xpath("//span[text()='"+fieldChargebackBankFinalNotificationDate+"']/../..//span[@class='uiOutputDate']")).getText();


        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
         Date d= sdf.parse(chargebackChargebackResponseBy);
         String formattedResponseTime = sdf.format(d);

        SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-mm-dd");
        Date date1= sdf1.parse(chargebackChargebackActualResponseDate);
        String formattedActualResponseTime = sdf1.format(date1);

        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-mm-dd");
        Date date2= sdf2.parse(chargebackChargebackBankFinalNotificationDate);
        String formattedFinalBankTime = sdf2.format(date2);


        System.out.println("--------------------000000---------------------------");
        System.out.println(act);
        System.out.println("--------------------------------");
        System.out.println(formattedResponseTime);
        System.out.println("--------------------------------");
        System.out.println(formattedActualResponseTime);
        System.out.println("--------------------------------");
        System.out.println(sst);
        System.out.println("--------------------------------");
        System.out.println(formattedFinalBankTime);
        System.out.println("--------------------------------------------");

        Assert.assertEquals(chargebackBankAction,act);
        Assert.assertEquals(chargebackChargebackResponseBy,formattedResponseTime);
        Assert.assertEquals(chargebackChargebackActualResponseDate,formattedActualResponseTime);
        Assert.assertEquals(chargebackChargebackSSTResponse,sst);
        Assert.assertEquals(chargebackChargebackBankFinalNotificationDate,formattedFinalBankTime);

    }

    public void verifyPayRecord(WebDriver driver,String fieldChargebackBankAction,String fieldChargebackReceivedOn, String fieldChargebackReferenceNumber, String chargebackBankAction, String chargebackReceivedOn, String chargebackReferenceNumber) throws ParseException {

        waitfortheelement();
        waitfortheelement();
        System.out.println("-------------------------------");
        System.out.println(chargebackBankAction);
        System.out.println("--------------------------------");
        System.out.println(chargebackReceivedOn);
        System.out.println("--------------------------------");
        System.out.println(chargebackReferenceNumber);
        System.out.println("----------------------------");
        String act = driver.findElement(By.xpath(".//span[@class='test-id__field-label'][text()='"+fieldChargebackBankAction+"']/../..//span[@class='test-id__field-value slds-form-element__static slds-grow ']//span")).getText();
        String date = driver.findElement(By.xpath("//span[text()='"+fieldChargebackReceivedOn+"']/../..//span[@class='uiOutputDate']")).getText();
        String num = driver.findElement(By.xpath("//span[@class='test-id__field-label'][text()='"+fieldChargebackReferenceNumber+"']/../..//span[@class='uiOutputText']")).getText();

//        String act = driver.findElement(By.xpath(".//span[@class='test-id__field-label'][text()='"+chargebackBankAction+"']/../..//span[@class='test-id__field-value slds-form-element__static slds-grow ']//span")).getText();
//        String date = driver.findElement(By.xpath("//span[text()='"+chargebackReceivedOn+"']/../..//span[@class='uiOutputDate']")).getText();
//       String num = driver.findElement(By.xpath("//span[@class='test-id__field-label'][text()='"+chargebackReferenceNumber+"']/../..//span[@class='uiOutputText']")).getText();
//       String str = "Chargeback initiated";
//        String str1= "2019-08-27";
//        String str2= "CN100102";
        SimpleDateFormat sdfd= new SimpleDateFormat("yyyy-mm-dd");
        Date data= sdfd.parse(chargebackReceivedOn);
        // String strDate= sdf.format(data);
        String formattedTime = sdfd.format(data);


        System.out.println("-------------------------------");
        System.out.println(act);
        System.out.println("--------------------------------");
        System.out.println(formattedTime);
        System.out.println("--------------------------------");
        System.out.println(num);
        System.out.println("--------------------------------");

        Assert.assertEquals(chargebackBankAction, act);
        Assert.assertEquals(chargebackReceivedOn, formattedTime);
        Assert.assertEquals(chargebackReferenceNumber, num);

    }

    public void clickOnPaymentNumber(WebDriver driver) {

        waitfortheelement();
        waitfortheelement();
        waitfortheelement();
        WebElement e= driver.findElement(By.xpath("//h1[@title='Payments']/../../../../../..//table[contains(@class,'slds-table forceRecord')]//tbody"));
       // WebElement e= driver.findElement(By.xpath("//th[@class='slds-cell-edit cellContainer']//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
        e.click();

        waitfortheelement();

        List<WebElement> rows = e.findElements(By.tagName("tr"));
        WebElement SecRecordFound = rows.get(1);

        SecRecordFound.findElement(By.tagName("th")).findElement(By.tagName("a")).click();
        waitfortheelement();
        waitfortheelement();

    }


    public void verifyEmptyField(WebDriver driver,String empty) {

        waitfortheelement();
        waitfortheelement();

        System.out.println("----------------------------------------");
        System.out.println(empty);
        System.out.println("----------------------------------");

        String str= driver.findElement(By.xpath("//div[@class='error uiMessage']//div[@class='uiBlock']//div[@class='bBody']")).getText();

        String[] tokens= empty.split("/n");
        int i;
        try {
            for (i = 0; i < tokens.length; i++)
//            System.out.println(tokens[i]);

//        System.out.println("----------------------");
                System.out.println(tokens[i]);
            System.out.println("----------------------");
            System.out.println(tokens[i]);
            System.out.println("----------------------");
            System.out.println(str);
            System.out.println("-----------------------");
            Assert.assertEquals(tokens[i],str);
        }
        catch (ArrayIndexOutOfBoundsException exp)
        {
            System.out.println(str);
        }


//        System.out.println("----------------------------------------");
//        //String actual= str.substring(0,50);
//        System.out.println(str);
//        System.out.println("----------------------------------");
//        waitfortheelement();
//        waitfortheelement();

//        String data= "Error\n".concat(empty);
//
//        Assert.assertEquals(empty,data);
       // Assert.assertTrue(Boolean.parseBoolean(actual.concat("Error For chargeback processing all fields are mandatory")));
//        if(empty==str)
//        {
//            System.out.println("----------------------------------------");
//            System.out.println(str);
//        }
//        else
//        {
//            System.out.println("----------------------------------");
//        }
       //Assert.assertTrue(str.contains(str1));
    }

    public void chargeback(WebDriver driver, String fieldChargebackBankAction, String fieldChargebackResponseBy, String fieldChargebackActualResponseDate, String fieldChargebackSSTResponse, String fieldChargebackBankFinalNotificationDate, String chargebackBankAction, String chargebackChargebackResponseBy, String chargebackChargebackActualResponseDate, String chargebackChargebackSSTResponse, String chargebackChargebackBankFinalNotificationDate) {


        waitfortheelement();

        driver.findElement(By.xpath("//label[text()='" + fieldChargebackBankAction + "']")).click();
        driver.findElement(By.xpath("//label[text()='" + fieldChargebackBankAction + "']/..//span[@title='" + chargebackBankAction + "']")).click();

        driver.findElement(By.xpath("//label[text()='"+fieldChargebackResponseBy+"']/..//input")).click();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date();
//        String strDate = dateFormat.format(date);
        driver.findElement(By.xpath("//td[@data-value='" + chargebackChargebackResponseBy + "']")).click();
        waitfortheelement();

        driver.findElement(By.xpath("//label[text()='"+fieldChargebackActualResponseDate+"']/..//input")).click();
        driver.findElement(By.xpath("//td[@data-value='" + chargebackChargebackActualResponseDate + "']")).click();

        waitfortheelement();
        //driver.findElement(By.xpath("//label[text()='" + fieldChargebackSSTResponse + "']"));
       // driver.findElement(By.xpath("//label[text()='" + fieldChargebackSSTResponse + "']/..//span[@title='" + chargebackChargebackSSTResponse + "']"));
        waitfortheelement();

        driver.findElement(By.xpath("//label[text()='"+fieldChargebackBankFinalNotificationDate+"']/..//input")).click();
        driver.findElement(By.xpath("//td[@data-value='" + chargebackChargebackBankFinalNotificationDate + "']")).click();

        waitfortheelement();


    }

    public void givedetails(WebDriver driver, String fieldChargebackBankAction,String fieldChargebackReceivedOn, String filedChargebackReferenceNumber,String fieldChargebackResponseBy,String fieldChargebackActualResponseDate,String fieldChargebackSSTResponse,String fieldChargebackBankFinalNotificationDate ,String chargebackBankAction,String chargebackReceivedOn,String chargebackReferenceNumber, String chargebackChargebackResponseBy, String chargebackChargebackActualResponseDate, String chargebackChargebackSSTResponse, String chargebackChargebackBankFinalNotificationDate) {

        waitfortheelement();

        driver.findElement(By.xpath("//label[text()='" + fieldChargebackBankAction + "']")).click();
        driver.findElement(By.xpath("//label[text()='" + fieldChargebackBankAction + "']/..//span[@title='" + chargebackBankAction + "']")).click();

        driver.findElement(By.xpath("//label[text()='"+fieldChargebackReceivedOn+"']/..//input")).click();
//          DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//          Date date = new Date();
//          String strDate = dateFormat.format(date);

        driver.findElement(By.xpath("//td[@data-value='" + chargebackReceivedOn + "']")).click();
        driver.findElement(By.xpath("//label[text()='" + filedChargebackReferenceNumber + "']/..//input")).clear();
        driver.findElement(By.xpath("//label[text()='" + filedChargebackReferenceNumber + "']/..//input")).sendKeys(chargebackReferenceNumber);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,50)");

        driver.findElement(By.xpath("//label[text()='"+fieldChargebackResponseBy+"']/..//input")).click();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date();
//        String strDate = dateFormat.format(date);
        driver.findElement(By.xpath("//td[@data-value='" + chargebackChargebackResponseBy + "']")).click();
        waitfortheelement();

        driver.findElement(By.xpath("//label[text()='"+fieldChargebackActualResponseDate+"']/..//input")).click();
        driver.findElement(By.xpath("//td[@data-value='" + chargebackChargebackActualResponseDate + "']")).click();

        waitfortheelement();
        driver.findElement(By.xpath("//label[text()='" + fieldChargebackSSTResponse + "']")).click();
        driver.findElement(By.xpath("//label[text()='" + fieldChargebackSSTResponse + "']/..//span[@title='" + chargebackChargebackSSTResponse + "']")).click();
        waitfortheelement();

        driver.findElement(By.xpath("//label[text()='"+fieldChargebackBankFinalNotificationDate+"']/..//input")).click();
        driver.findElement(By.xpath("//td[@data-value='" + chargebackChargebackBankFinalNotificationDate + "']")).click();

        waitfortheelement();

    }

    public void recordType(WebDriver driver,String fieldType,String record) {

        waitfortheelement();
        waitfortheelement();

        System.out.println("\n"+record);
        String rc = driver.findElement(By.xpath("//span[@class='test-id__field-label'][text()='"+ fieldType +"']//..//..//div[@class='recordTypeName slds-grow slds-truncate']//span[text()='"+ record +"']")).getText();
       // String rc=driver.findElement(By.xpath("//span[@class='test-id__field-label'][text()='"+chargebackRecordType+"']//..//..//div[@class='recordTypeName slds-grow slds-truncate']//span[text()='"+record+"']")).getText();
        waitfortheelement();
        System.out.println("-------------------------------");
        System.out.println(rc);
        System.out.println("--------------------------------");

        Assert.assertEquals(record,rc);
    }

    public void opportunityClick(WebDriver driver, String clickOpportunity) {

        waitfortheelement();
        waitfortheelement();

        driver.findElement(By.xpath("//span[@class='slds-card__header-title slds-truncate slds-m-right--xx-small'] [@title='"+ clickOpportunity +"']")).click();

    }

    public void relatedClick(WebDriver driver, String relatedClick) {

        waitfortheelement();
        WebElement elem = driver.findElement(By.xpath("//a[@class='tabHeader'][@title='"+relatedClick+"']//span[@class='title'][text()='"+relatedClick+"']"));
        elem.click();
        waitfortheelement();
        waitfortheelement();

    }

    public void validOpportunities(WebDriver driver, String OpportunityName,String AccountName) {

        waitfortheelement();
        waitfortheelement();

        waitfortheelement();
        System.out.println("-------------------------------------------");
        System.out.println(OpportunityName);
        System.out.println("----------------------------------");
        System.out.println(AccountName);
        System.out.println("--------------------------------------------");
      //  JavascriptExecutor js = (JavascriptExecutor) driver;
      //  js.executeScript("scrollBy(0,-250)");
        String OppoName = driver.findElement(By.xpath("//th//span[@class='slds-grid slds-grid--align-spread']//a[@title='"+OpportunityName+"']")).getText();
        String AccName = driver.findElement(By.xpath("//td//span[@class='slds-grid slds-grid--align-spread']//a[@title='"+AccountName+"']")).getText();
    //    String act = driver.findElement(By.xpath(".//span[@class='test-id__field-label'][text()='"+fieldChargebackBankAction+"']/../..//span[@class='test-id__field-value slds-form-element__static slds-grow ']//span")).getText();

        waitfortheelement();
        System.out.println("-------------------------------------------");
        System.out.println(OppoName);
        System.out.println("----------------------------------");
        System.out.println(AccountName);
        System.out.println("--------------------------------------------");


        waitfortheelement();
        Assert.assertEquals(OpportunityName, OppoName);
        Assert.assertEquals(AccountName, AccName);


//        waitfortheelement();
//        System.out.println("-------------------------------------------");
//        System.out.println(fieldOpportunityName);
//        System.out.println("----------------------------------");
//        System.out.println(fieldAccountName);
//        System.out.println("--------------------------------------------");
//
////         String valid= driver.findElement(By.xpath("//div[@class='hideSelection forceListViewManagerGrid']")).getText();
////         waitfortheelement();
//
//          System.out.println("-----------------------------------------");
//          System.out.println(valid);
//          System.out.println("----------------------------------");

        //Assert.assertEquals(validOpportunity,valid);
    }


    public void Recordclick(WebDriver driver,String recordType) {

        waitfortheelement();

        System.out.println("----------------------------------");
        System.out.println(recordType);
        System.out.println("----------------------------------");
       String type= driver.findElement(By.xpath("//span[@class='slds-truncate uiOutputText'][@title='"+ recordType +"']")).getText();
        System.out.println("----------------------------------");
        System.out.println(type);
        System.out.println("----------------------------------");
        waitfortheelement();

        Assert.assertEquals(recordType,type);


    }

    public void clickReund(WebDriver driver, String fieldCaseOrigin, String fieldRefundType, String fieldRefundInstrument, String fieldBankAccountNo, String fieldBankBSB, String refundCaseOrigin, String refundRefundType, String refundRefundInstrument, String refundBankAccountNo, String refundBankBSB) {

        waitfortheelement();

        driver.findElement(By.xpath("//label[text()='" + fieldCaseOrigin + "']")).click();
        driver.findElement(By.xpath("//label[text()='" + fieldCaseOrigin + "']/..//span[@title='" + refundCaseOrigin + "']")).click();
        waitfortheelement();

        driver.findElement(By.xpath("//label[text()='" + fieldRefundType + "']")).click();
        driver.findElement(By.xpath("//label[text()='" + fieldRefundType + "']/..//span[@title='" + refundRefundType + "']")).click();
//        driver.findElement(By.xpath("//label[text()='"+fieldChargebackResponseBy+"']/..//input")).click();
////        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////        Date date = new Date();
////        String strDate = dateFormat.format(date);
//        driver.findElement(By.xpath("//td[@data-value='" + chargebackChargebackResponseBy + "']")).click();
        waitfortheelement();
        waitfortheelement();
        driver.findElement(By.xpath("//label[text()='" + fieldRefundInstrument + "']")).click();
        driver.findElement(By.xpath("//label[text()='" + fieldRefundInstrument + "']/..//span[@title='" + refundRefundInstrument + "']")).click();

        waitfortheelement();
        waitfortheelement();
        driver.findElement(By.xpath("//label[text()='" + fieldBankAccountNo + "']/..//input")).sendKeys(refundBankAccountNo);
//        driver.findElement(By.xpath("//label[text()='" + fieldChargebackSSTResponse + "']")).click();
//        driver.findElement(By.xpath("//label[text()='" + fieldChargebackSSTResponse + "']/..//span[@title='" + chargebackChargebackSSTResponse + "']")).click();
        waitfortheelement();
        waitfortheelement();
        driver.findElement(By.xpath("//label[text()='" + fieldBankBSB + "']/..//input")).sendKeys(refundBankBSB);
//        driver.findElement(By.xpath("//label[text()='"+fieldChargebackBankFinalNotificationDate+"']/..//input")).click();
//        driver.findElement(By.xpath("//td[@data-value='" + chargebackChargebackBankFinalNotificationDate + "']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,50)");
        waitfortheelement();
        waitfortheelement();


    }

    public void validSuccessMessage(WebDriver driver, String message) {

        waitfortheelement();
        waitfortheelement();

        System.out.println("----------------------------------------");
        System.out.println(message);
        System.out.println("----------------------------------");

        String str= driver.findElement(By.xpath("//div[@class='confirm uiMessage']//div[@class='uiBlock']//div[@class='bBody']")).getText();

        String[] tokens= message.split("/n");
        int i;
        try {
            for (i = 0; i < tokens.length; i++)
//            System.out.println(tokens[i]);

//        System.out.println("----------------------");
                System.out.println(tokens[i]);
            System.out.println("----------------------");
            System.out.println(tokens[i]);
            System.out.println("----------------------");
            System.out.println(str);
            System.out.println("-----------------------");
            Assert.assertEquals(tokens[i],str);
        }
        catch (ArrayIndexOutOfBoundsException exp)
        {
            System.out.println(str);
        }

    }

      public void resave(WebDriver driver, String btn) {

        waitfortheelement();
        driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand'][text()='"+btn+"']")).click();
        waitfortheelement();
        waitfortheelement();
    }
}