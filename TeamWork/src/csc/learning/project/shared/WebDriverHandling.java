package csc.learning.project.shared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static csc.learning.project.shared.MainRunner.getProperties;

/**
 * Created by cchandragiri on 4/12/2017.
 */
public class WebDriverHandling {

    public static WebDriver driver = null;

    public WebDriver getDriverInstance(String driver_choosed)
    {
        System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
        driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver()
    {
        driver.close();
        driver.quit();
    }

    public String getDriverName()
    {
        if (getProperties().get(0) == null) {
            return "ff";
        }
        return getProperties().get(0).toString();
    }

    public void navigate()
    {
        String url = getProperties().get(1).toString();
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println("Navigate to " + url);
    }







}
