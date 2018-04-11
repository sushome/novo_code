package com.automation.crm.ag.exa;

import com.automation.crm.ag.inte.integrationMethod;
import com.automation.crm.ag.inte.parameter;
import org.openqa.selenium.*;

import java.util.Set;

public class testCase extends integrationMethod {
    parameter pr = new parameter();

    public void step_test1() throws Exception{
        driver();
        WebDriver driver = this.getDriver();
        this.driverWait();
        login();
        chooseRoleAndOpp();
        String currentWindow = driver.getWindowHandle();

        webDriverWaitElementToClick(pr.by()[8]);         //new and select ZOGA
        forWaitNewWindowHandles(currentWindow);
        driver.switchTo().frame("WorkAreaFrame1popup");
        findAndClick(pr.by()[9]);

        Set<String> window = driver.getWindowHandles();  //Opportunity details
        String newWindow = window.toArray()[0].toString();
        driver.switchTo().window(newWindow);
        waitFrame();

        waitElementTosend(pr.by()[10],"IA-Multi-US-CA");   // send keys
        findAndSend(pr.by()[11], "03.04.2018");
        findAndSend(pr.by()[12], "1213443648");
        findAndSend(pr.by()[14], "1213443648");
        findAndClick(pr.by()[15]);   //select
        findAndClick(pr.by()[16]);
        element(pr.by()[14]).sendKeys(Keys.ENTER);
        pageLoadingFinished(driver, 1);
        findAndClick(pr.by()[21]);
        Thread.sleep(4000);
        webDriverWaitElementToClick(pr.by()[27]); //create follow up Quotation
        forWaitNewWindowHandles(newWindow);
        driver.switchTo().frame("WorkAreaFrame1popup");
        findAndClick(pr.by()[66]);
        pageLoadingFinished(driver,1);

        driver.switchTo().window(newWindow);
        waitFrame();
        Thread.sleep(1000);
        selectElement(pr.by()[63],"2900725254");
        findAndSend(pr.by()[64],"please approve");
        Thread.sleep(1000);
        webDriverWaitElementToClick(pr.by()[21]);
        forWaitNewWindowHandles(newWindow);        // after save pop up window
        driver.switchTo().frame("WorkAreaFrame1popup");
        findAndClick(pr.by()[67]);

        driver.switchTo().window(newWindow);
        waitFrame();
        webDriverWaitElementToClick(pr.by()[49]);
        webDriverWaitElementToClick(pr.by()[34]);   //change status
        findAndClick(pr.by()[35]);
        Thread.sleep(2000);
        webDriverWaitElementToClick(pr.by()[21]);
        Thread.sleep(4000);
        findAndClick(pr.by()[49]);
        Thread.sleep(3000);
        webDriverWaitElementToClick(pr.by()[34]);  // Quotation status change
        findAndClick(pr.by()[50]);
        Thread.sleep(1000);
        findAndClick(pr.by()[21]);
        waitGetElement(pr.by()[69]);
    }

    public void step_test2() throws Exception{
        driver();
        WebDriver driver = this.getDriver();
        this.driverWait();
        orderLogin();
        chooseOrderAndFind();
        String currentWindow = driver.getWindowHandle();

        webDriverWaitElementToClick(pr.by()[8]);         //new and select YBOR
        forWaitNewWindowHandles(currentWindow);
        driver.switchTo().frame("WorkAreaFrame1popup");
        findAndClick(pr.by()[70]);
        webDriverWaitElementToClick(pr.by()[71]);
    }

    public static void main(String[] args) throws Exception{
        testCase tc = new testCase();
        tc.step_test1();
    }
}
