package csc.learning.project.shared;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by cchandragiri on 9/14/2017.
 */
public class HanuSir {


    public static WebDriver driver = null;
    static Logger log = Logger.getLogger(HanuSir.class);
    static String homePageUrl = "https://mytakeda.sharepoint.com/teams/Nyc/";

    public static void main(String Args[]) throws InterruptedException {
        HanuSir hs = new HanuSir();
        BasicConfigurator.configure();
        hs.printLine();
        hs.initializeDriver("chrome", homePageUrl);
        hs.login();
        hs.verifyLinksOnPage();

    }

    public void waitForPageReady() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

//    public void openInNewWindow(WebElement link) {
//        link.sendKeys(Keys.CONTROL + "t");
//    }


    public void printLine() {
        log.info("Hello");
    }

    public void initializeDriver(String browser, String homeUrl) {
        log.info("User Opted for " + browser);
        switch (browser) {
            case "ff":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "E:\\Transformation\\Softwares\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "E:\\Transformation\\Softwares\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
        }
        driver.get(homeUrl);
        log.info("Navigate to " + homeUrl + " using " + browser + " browser.");
    }
//
//    public boolean validateCurrentUrl(String url) {
//
//        if (url.startsWith("(https?):://")) {
//            return true;
//        }
//        return false;
//    }


    public WebDriver getTopWindow() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        return driver;
    }

    public void closeWindow() {
        getTopWindow().close();
    }


    private int getWindowCount() {
        return driver.getWindowHandles().size();
    }

    private void verifyLinksOnPage() throws InterruptedException {
        driver.manage().window().maximize();
        List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
        ArrayList<HashMap> linksDetails = new ArrayList<HashMap>();
        log.info("Total links available on page " + totalLinks.size());
        String primaryWindow = driver.getWindowHandle();//Return a string of alphanumeric window handleString  secondWindow= driver.getWindowHandle();
        log.info("Links size after fliter " + totalLinks.size());
        log.info("Links to be validated " + totalLinks);
        HashMap hm = new HashMap();
        for (int i = 0; i < totalLinks.size(); i++) {
            if (totalLinks.get(i).getAttribute("href").startsWith("http")) {
                clickInNewTab(totalLinks.get(i));
            } else {
                continue;
            }
            hm.put(driver.getCurrentUrl(), driver.getTitle());
            if (getWindowCount() > 1) {
                closeWindow();
            }
            driver.get(homePageUrl);
            log.info("Navigated to Home Page again....");
            linksDetails.add(hm);
        }
        log.info(linksDetails);
    }

    public void clickInNewTab(WebElement element) throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL);
        actions.click(element);
        actions.keyUp(Keys.CONTROL);
        actions.perform();
        getTopWindow();
    }


    public void click(WebElement element) {
        try {
            element.click();
        } catch (StaleElementReferenceException sle) {
            log.info("Got NSE error, going");
        } catch (NoSuchElementException nse) {
            log.info("GOT SLE error, going");
        } catch (NoSuchSessionException nsse) {
            log.info("executing Java script");
        } catch (Exception ex) {
            log.info("LAST");
        }
        waitForPageReady();
    }

//    public void executeJavaScriptforClick(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", element);
//    }


    public void login() throws InterruptedException {
        driver.findElement(By.id("cred_userid_inputtext")).sendKeys("Techmspo2@mytakeda.com");
        driver.findElement(By.id("cred_password_inputtext")).sendKeys("Takeda$1234");
        WebElement ele = driver.findElement(By.id("cred_sign_in_button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    js.executeScript("document.getElementById(\"cred_sign_in_button\").click();");
                    break;
                case 1:
                    ele.click();
                    break;
                case 2:
                    Actions act = new Actions(driver);
                    act.moveToElement(ele);
                    act.clickAndHold();
                    act.release();
                    act.build().perform();
                    break;
            }
            waitForElementToNotVisible();
            if(isElementVisible(ele)){
            } else {
                break;
            }
        }

    }

    public void waitForElementToNotVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("cred_sign_in_button")));
        } catch (Exception e) {

        }
    }

    public boolean isElementVisible(WebElement e){
       try {
           return e.isDisplayed();
       }catch (Exception exe)
       {
           log.info("Element is not visible");
           return false;
       }
    }


}