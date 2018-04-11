//package com.automation.crm.ag.inte;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.logging.LogEntries;
//import org.openqa.selenium.logging.LogEntry;
//import org.openqa.selenium.logging.LogType;
//import org.openqa.selenium.logging.LoggingPreferences;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.util.Iterator;
//import java.util.logging.Level;
//
//public class HttpResponseCode {
//    private static void DownloadPage(String url){
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        ChromeDriver driver = null;
//        try{
//            ChromeOptions options = new ChromeOptions();                          // standard grammar
//            DesiredCapabilities cap = DesiredCapabilities.chrome();
//            cap.setCapability(ChromeOptions.CAPABILITY, options);
//
//            LoggingPreferences logPrefs = new LoggingPreferences();
//            logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
//            cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
//            driver = new ChromeDriver(cap);
//
//            System.out.println("Navigate to " + url);
//            driver.navigate().to(url);
//
////            String currentURL = driver.getCurrentUrl();
//            String currentURL = "https://www.baidu.com/his?wd=&from=pc_web&rf=3&hisdata=&json=1&p=3&sid=";
//            LogEntries logs = driver.manage().logs().get("performance");
//            int status = -1;
//            System.out.println("\nList of log entries:\n");
//
//            for(Iterator<LogEntry> it = logs.iterator(); it.hasNext();){
//                LogEntry entry = it.next();
//                try{
//                    JSONObject json = new JSONObject(entry.getMessage());
//                    System.out.println(json.getString("message"));
//
//                    JSONObject message = json.getJSONObject("message");
//                    String method = message.getString("method");
//
//                    if(method!=null&&"Network.responseReceived".equals(method)){
//                        JSONObject params = message.getJSONObject("params");
//                        JSONObject response = params.getJSONObject("response");
//                        String messageUrl = response.getString("url");
//                        if(currentURL.contains(messageUrl)){
//                            status = response.getInt("status");
//                            System.out.println("-------returned" + messageUrl + ":" + status);
//                            System.out.println("-------headers" + response.get("headers"));
//                        }
//                    }
//                }catch (JSONException e){
//                    e.printStackTrace();
//                }
//            }
//            System.out.println("\n status code:" + status);
//        }finally {
//            if(driver!=null){
//                driver.quit();
//            }
//        }
//    }
//
//    public static void main(String[] args){
//        String url = "https://www.baidu.com";
//        DownloadPage(url);
//    }
//}
