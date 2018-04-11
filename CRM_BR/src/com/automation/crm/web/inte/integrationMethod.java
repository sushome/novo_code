package com.automation.crm.web.inte;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class integrationMethod {

    public WebDriver driver1;
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public String oppid;
    public String Quota;
    public String SalesContract;
    parameter pr = new parameter();

    public WebDriver driver(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver1_1 = new ChromeDriver();
        driver1 = driver1_1;
        return driver1;
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
        wait = new WebDriverWait(driver1, 100);
        return wait;
    }

//    public JavascriptExecutor jsExecutor(){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        return js;
//    }

    public void findAndExecute(By by){
        WebElement element2 = element(by);
        js = (JavascriptExecutor) driver1;
        js.executeScript("arguments[0].click()", element2);
    }

    public void findAndSend(By by, String str){
        WebElement element3 = element(by);
        element3.sendKeys(str);
    }

    public void waitElementToExecute(By by){
        WebElement element4 = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(by);
            }
        });
        js.executeScript("arguments[0].click()", element4);
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
        oppid = element6.getText();
    }

    public void forWait(String currentWindow){
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
        findAndExecute(pr.by()[2]);
        findAndExecute(pr.by()[3]);
        findAndExecute(pr.by()[4]);
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
        waitElementToExecute(pr.by()[5]);        //choose role
        wait.until(new ExpectedCondition<WebDriver>() {
            @Override
            public WebDriver apply(WebDriver dr) {
                return dr.switchTo().frame("CRMApplicationFrame").switchTo().frame("WorkAreaFrame1");
            }
        });
        //click sale cycle and opportunity
        Thread.sleep(3000);
        waitElementToExecute(pr.by()[6]);
        waitElementToExecute(pr.by()[7]);
        Thread.sleep(1000);
    }

    public void chooseRoleAndQuo() throws Exception{
        waitElementToExecute(pr.by()[5]);        //choose role
        Thread.sleep(8000);
        wait.until(new ExpectedCondition<WebDriver>() {
            @Override
            public WebDriver apply(WebDriver dr) {
                return dr.switchTo().frame("CRMApplicationFrame").switchTo().frame("WorkAreaFrame1");
            }
        });
        //click sale cycle and opportunity
        findAndExecute(pr.by()[6]);
        findAndExecute(pr.by()[46]);
    }

    public void choosePricerAndWorklist() throws Exception{
        waitElementToExecute(pr.by()[39]);
        Thread.sleep(12000);
        wait.until(new ExpectedCondition<WebDriver>() {
            @Override
            public WebDriver apply(WebDriver dr) {
                return dr.switchTo().frame("CRMApplicationFrame").switchTo().frame("WorkAreaFrame1");
            }
        });
        waitElementToExecute(pr.by()[36]);
//        findAndExecute(pr.by()[36]);
        findAndExecute(pr.by()[37]);
    }

    public void chooseOrderAndFind() throws Exception{
        waitElementToExecute(pr.by()[53]);
        Thread.sleep(5000);
        wait.until(new ExpectedCondition<WebDriver>() {
            @Override
            public WebDriver apply(WebDriver dr) {
                return dr.switchTo().frame("CRMApplicationFrame").switchTo().frame("WorkAreaFrame1");
            }
        });
        waitElementToExecute(pr.by()[6]);
        findAndExecute(pr.by()[54]);
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
