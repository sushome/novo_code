package com.automation.crm.ag.inte;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;

public class integrationMethod {

    public WebDriver driver1;
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public String id1;
    public String Quota;
    public String SalesContract;
    parameter pr = new parameter();

    public WebDriver driver(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, options);

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        WebDriver driver1_1 = new ChromeDriver(cap);
        driver1 = driver1_1;
        return driver1;
    }

    public int loadingFinishedCount(WebDriver driver){
        LogEntries logs = driver.manage().logs().get("performance");
//        System.out.println("\nList of log entries:\n");
        int m=0;
        for(Iterator<LogEntry> it = logs.iterator(); it.hasNext();){
            LogEntry entry = it.next();
            try{
                JSONObject json = new JSONObject(entry.getMessage());
                JSONObject message = json.getJSONObject("message");
//                System.out.println(message);
                String method = message.getString("method");
                if(method!=null&&"Network.loadingFinished".equals(method)){
                    ++m;
                }
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return m;
    }

    public void pageLoadingFinished(WebDriver driver, int loadingFinishedCount){
        loadingFinishedCount(driver);
//        System.out.println(m);
        for(double i=0; i<=1000; i=i+0.1) {
            int n = loadingFinishedCount(driver);
//            System.out.println(n);
            if (n >=loadingFinishedCount) {
                break;
            }
        }
    }

    public WebDriver getDriver(){
        driver1.get(pr.url()[0]);
        return driver1;
    }

    public WebElement element(By by){
        WebElement element1 = driver1.findElement(by);
        return element1;
    }

    public WebDriverWait driverWait(){
        wait = new WebDriverWait(driver1, 50);
        return wait;
    }

    public void findAndClick(By by){
        WebElement element2 = element(by);
        js = (JavascriptExecutor) driver1;
        js.executeScript("arguments[0].click()", element2);
    }

    public void findAndSend(By by, String str){
        WebElement element3 = element(by);
        element3.sendKeys(str);
    }

    public void selectElement(By by, String value){
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver dr){
                return dr.findElement(by);
            }
        });
        Select st = new Select(element(by));
        st.selectByValue(value);
    }

    public void webDriverWaitElementToClick(By by){
        WebElement element4 = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(by);
            }
        });
        js.executeScript("arguments[0].click()", element4);
    }

    public void tryCatchWaitElementToClick( By by){
        double loop = 0;
        while(loop<=100){
            try{
                WebElement ele = element(by);
                js.executeScript("arguments[0].click()", ele);
                loop = loop + 100;
            }catch(Exception e){
                loop = loop + 0.01;
            }
        }
    }

    public void waitElementTosend(By by, String str){
        WebElement element5 = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(by);
            }
        });
        element5.sendKeys(str);
    }

    public void waitGetElement(By by){
        WebElement element6 = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(by);
            }
        });
        id1 = element6.getText();
    }

    public void forWaitNewWindowHandles(String currentWindow){
        for(double i=0; i<=500; i=i+0.01){
            Set<String> handles = driver1.getWindowHandles();
            if(handles.size()==2){
                Iterator<String> it = handles.iterator();
                while (it.hasNext()) {
                    String handle = it.next();
                    if (currentWindow.equals(handle)) continue;
                    driver1.switchTo().window(handle);
                }
                break;
            }
        }
    }

    public void waitFrame(){
        wait.until(new ExpectedCondition<WebDriver>() {
            @Override
            public WebDriver apply(WebDriver dr){
                return dr.switchTo().frame("CRMApplicationFrame").switchTo().frame("WorkAreaFrame1");
            }
        });
    }

    public void lanSelect() throws Exception{
        findAndClick(pr.by()[2]);
        findAndClick(pr.by()[3]);
        findAndClick(pr.by()[4]);
    }

    public void login() throws Exception{
        findAndSend(pr.by()[0], pr.namePsw()[0]);         //login
        findAndSend(pr.by()[1], pr.namePsw()[1]);
        lanSelect();
    }

    public void priceLogin() throws Exception{
        findAndSend(pr.by()[0], pr.namePsw()[2]);         //login
        findAndSend(pr.by()[1], pr.namePsw()[1]);
        lanSelect();
    }

    public void orderLogin() throws Exception{
        findAndSend(pr.by()[0], pr.namePsw()[3]);         //login
        findAndSend(pr.by()[1], pr.namePsw()[1]);
        lanSelect();
    }

    public void chooseRoleAndOpp() throws Exception{
        tryCatchWaitElementToClick(pr.by()[5]);        //choose role
        wait.until(new ExpectedCondition<WebDriver>() {
            @Override
            public WebDriver apply(WebDriver dr) {
                return dr.switchTo().frame("CRMApplicationFrame").switchTo().frame("WorkAreaFrame1");
            }
        });
        //click sale cycle and opportunity
        Thread.sleep(2000);
        tryCatchWaitElementToClick(pr.by()[6]);
        webDriverWaitElementToClick(pr.by()[7]);
    }

    public void chooseRoleAndQuo() throws Exception{
        webDriverWaitElementToClick(pr.by()[5]);        //choose role
        Thread.sleep(8000);
        wait.until(new ExpectedCondition<WebDriver>() {
            @Override
            public WebDriver apply(WebDriver dr) {
                return dr.switchTo().frame("CRMApplicationFrame").switchTo().frame("WorkAreaFrame1");
            }
        });
        //click sale cycle and opportunity
        findAndClick(pr.by()[6]);
        findAndClick(pr.by()[46]);
    }

    public void choosePricerAndWorklist() throws Exception{
        webDriverWaitElementToClick(pr.by()[39]);
        Thread.sleep(12000);
        wait.until(new ExpectedCondition<WebDriver>() {
            @Override
            public WebDriver apply(WebDriver dr) {
                return dr.switchTo().frame("CRMApplicationFrame").switchTo().frame("WorkAreaFrame1");
            }
        });
        webDriverWaitElementToClick(pr.by()[36]);
//        findAndClick(pr.by()[36]);
        findAndClick(pr.by()[37]);
    }

    public void chooseOrderAndFind() throws Exception{
        webDriverWaitElementToClick(pr.by()[53]);
        Thread.sleep(5000);
        wait.until(new ExpectedCondition<WebDriver>() {
            @Override
            public WebDriver apply(WebDriver dr) {
                return dr.switchTo().frame("CRMApplicationFrame").switchTo().frame("WorkAreaFrame1");
            }
        });
        webDriverWaitElementToClick(pr.by()[6]);
        findAndClick(pr.by()[54]);
        Thread.sleep(1000);
    }

    public void nextStep(WebDriver driver) throws Exception{
        if(driver.getTitle().contains("role")){    // decide the current webPage
            chooseRoleAndOpp();
        }else{
            driver.switchTo().frame("CRMApplicationFrame").switchTo().frame("WorkAreaFrame1");
            Thread.sleep(3000);
        }
    }

    public String readId(){
        Quota = element(pr.by()[38]).getText();
        return Quota;
    }

    public String readSalesConId(){
        SalesContract = element(pr.by()[52]).getText();
        return SalesContract;
    }

    public By getId(){
        By by = By.xpath("//a[@title=\""+ Quota +"\"]");
        return by;
    }

    public By getSubject(){
        By by = By.xpath("//a[@title=\""+ Quota +"\"]/parent::td/parent::tr//a[contains(@id,'wi_text')]");
        return by;
    }

    public By getQuotaDetail(){
        By by = By.xpath("//a[@title=\"" + Quota + "\"]");

        return by;
    }

    public By getSalesConDetail(){
        By by = By.xpath("//a[@title=\"" + SalesContract + "\"]");
        return by;
    }

}

