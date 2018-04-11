package com.automation.crm.web.exa;

import com.automation.crm.web.inte.integrationMethod;
import com.automation.crm.web.inte.parameter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Set;

public class testCase extends integrationMethod{

    parameter pr = new parameter();

    @Test(description = "test_step1")
    public void test_step1() throws Exception{      //create OppID
        driver();
        WebDriver driver = this.getDriver();
        this.driverWait();
        login();
        chooseRoleAndOpp();
        String currentWindow = driver.getWindowHandle();

        waitElementToExecute(pr.by()[8]);         //new and select ZPEM
        forWait(currentWindow);
        driver.switchTo().frame("WorkAreaFrame1popup");
        findAndExecute(pr.by()[9]);
//        Thread.sleep(5000);

        //Opportunity details
        Set<String> window = driver.getWindowHandles();
        String newWindow = window.toArray()[0].toString();
        driver.switchTo().window(newWindow);
        waitFrame();
//        driver.switchTo().frame("CRMApplicationFrame").switchTo().frame("WorkAreaFrame1");
        waitElementTosend(pr.by()[10],"Test for BR_05_GTN");
//        findAndSend(pr.by()[10], "Test for BR_05_GTN");
        findAndSend(pr.by()[11], "03.04.2018");
        findAndSend(pr.by()[12], "1214344505");
        findAndSend(pr.by()[13], "1213903136");
        findAndSend(pr.by()[14], "1214344505");
        findAndExecute(pr.by()[15]);   //select
        findAndExecute(pr.by()[16]);

//        Thread.sleep(2000);
        forWait(newWindow);                          //select organizational data
        driver.switchTo().frame("WorkAreaFrame1popup");
        findAndExecute(pr.by()[17]);

        Thread.sleep(3000);                  //select organizational attribute
        forWait(newWindow);
        driver.switchTo().frame("WorkAreaFrame1popup");
        waitElementToExecute(pr.by()[18]);
//        findAndExecute(pr.by()[18]);

        driver.switchTo().window(newWindow);        //opportunity group
//        Thread.sleep(5000);
        waitFrame();
//        driver.switchTo().frame("CRMApplicationFrame").switchTo().frame("WorkAreaFrame1");
        waitElementToExecute(pr.by()[19]);
//        findAndExecute(pr.by()[19]);   // select menu
        findAndExecute(pr.by()[20]);

//        Thread.sleep(3000);
        waitElementToExecute(pr.by()[21]);            //save
//        findAndExecute(pr.by()[21]);
//        Thread.sleep(9000);
//        oppid = element(pr.by()[23]).getText();
        waitGetElement(pr.by()[23]);
    }


    @Test(dependsOnMethods = {"test_step1"}, description="test_step2")
    public void test_step2() throws Exception {     // create QuotaID
//        driver();
        WebDriver driver = this.getDriver();
        this.driverWait();
//        login();
//        chooseRoleAndOpp();
        Thread.sleep(2000);
        nextStep(driver);
        findAndExecute(pr.by()[6]);
        findAndExecute(pr.by()[7]);
//        Thread.sleep(5000);
        waitElementTosend(pr.by()[24],oppid);
//        findAndSend(pr.by()[24], oppid);

        //input oppID and search
//        findAndSend(pr.by()[24], "2199872");
        findAndExecute(pr.by()[25]);
        waitElementToExecute(pr.by()[26]);        // get the opportunity detail
        String currentWindow = driver.getWindowHandle();

        //create follow up
        waitElementToExecute(pr.by()[27]);
        Thread.sleep(3000);
        forWait(currentWindow);
        driver.switchTo().frame("WorkAreaFrame1popup");
        findAndExecute(pr.by()[28]);
        Thread.sleep(5000);
        forWait(currentWindow);
        Thread.sleep(2000);
        driver.switchTo().frame("WorkAreaFrame1popup");
        findAndExecute(pr.by()[29]);

        //input and select
        driver.switchTo().window(currentWindow);
        waitFrame();
//        Thread.sleep(30000);
//        driver.switchTo().frame("CRMApplicationFrame").switchTo().frame("WorkAreaFrame1");
        Thread.sleep(3000);
        findAndExecute(pr.by()[30]);
        findAndExecute(pr.by()[31]);
        Thread.sleep(1000);
        findAndExecute(pr.by()[32]);   //pop up
        forWait(currentWindow);
        driver.switchTo().frame("WorkAreaFrame1popup");
        findAndExecute(pr.by()[33]);
        Thread.sleep(3000);
        driver.switchTo().window(currentWindow);
        driver.switchTo().frame("CRMApplicationFrame").switchTo().frame("WorkAreaFrame1");
        findAndExecute(pr.by()[34]);
        findAndExecute(pr.by()[35]);
        Thread.sleep(2000);
        findAndExecute(pr.by()[21]);
        Thread.sleep(5000);
        readId();
        Thread.sleep(1000);
        driver.close();
    }

    //because the step2 writing into database is affected by many factors, it may not synchronize when the step3 begins, so there is a time period here
    @Test(dependsOnMethods = {"test_step2"}, description="test_step3")
    public void test_step3() throws Exception{        // price approve   synchronize with QuotaId slowly
        driver();
        WebDriver driver = this.getDriver();
        this.driverWait();
        priceLogin();
        choosePricerAndWorklist();
        Thread.sleep(8000);
        findAndExecute(getSubject());
        Thread.sleep(1000);
        waitElementToExecute(pr.by()[42]);
        Thread.sleep(3000);
        driver.switchTo().frame("ZGSWIDET");
        waitElementToExecute(pr.by()[43]);
        findAndSend(pr.by()[44], "pass");
        findAndExecute(pr.by()[48]);
        Thread.sleep(2000);
        findAndExecute(pr.by()[45]);
        Thread.sleep(5000);
        driver.close();
    }

    @Test(dependsOnMethods = {"test_step3"}, description = "test_step4")
    public void test_step4() throws Exception{           //Quota consumer accepted
        driver();
        WebDriver driver = this.getDriver();
        this.driverWait();
        login();
        chooseRoleAndQuo();
        Thread.sleep(4000);
        findAndSend(pr.by()[47], Quota);
        findAndExecute(pr.by()[51]);   //search
        Thread.sleep(1000);
        waitElementToExecute(getQuotaDetail());
        waitElementToExecute(pr.by()[49]);
        waitElementToExecute(pr.by()[34]);
        waitElementToExecute(pr.by()[50]);
        Thread.sleep(2000);
        findAndExecute(pr.by()[21]);
        Thread.sleep(15000);
        readSalesConId();
        Thread.sleep(1000);
        driver.close();
    }

    @Test(dependsOnMethods= {"test_step4"}, description= "test_step5")
    public void test_step5() throws Exception{           //follow up sales order
        driver();
        WebDriver driver = this.getDriver();
        this.driverWait();
        orderLogin();
        chooseOrderAndFind();
        Thread.sleep(10000);
        findAndSend(pr.by()[55],SalesContract);
        findAndExecute(pr.by()[25]);     //search
        Thread.sleep(1000);
        String currentWindow = driver.getWindowHandle();
        waitElementToExecute(getSalesConDetail());
        waitElementToExecute(pr.by()[27]);
        Thread.sleep(3000);
        forWait(currentWindow);
        driver.switchTo().frame("WorkAreaFrame1popup");
        findAndExecute(pr.by()[56]);
        Thread.sleep(3000);
        driver.switchTo().window(currentWindow);
        Thread.sleep(3000);
        driver.switchTo().frame("CRMApplicationFrame").switchTo().frame("WorkAreaFrame1");
        findAndSend(pr.by()[57],"TESTFOR FR");
        findAndSend(pr.by()[58],"04.05.2018");
        findAndExecute(pr.by()[59]);
        findAndExecute(pr.by()[60]);
        findAndExecute(pr.by()[61]);
        Thread.sleep(2000);
        findAndExecute(pr.by()[62]);
        Thread.sleep(2000);
        Select st = new Select(element(pr.by()[63]));
        st.selectByValue("YB11");
        Thread.sleep(1000);
        findAndSend(pr.by()[64],"susm2@lenovo.com");
        Thread.sleep(1000);
        findAndExecute(pr.by()[65]);
        Thread.sleep(2000);
        waitElementToExecute(pr.by()[21]);
        Thread.sleep(2000);
        driver.close();
    }
}
