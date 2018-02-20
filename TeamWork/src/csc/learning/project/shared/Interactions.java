package csc.learning.project.shared;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static csc.learning.project.shared.WebDriverHandling.driver;

/**
 * Created by cchandragiri on 4/12/2017.
 */
public class Interactions {



    Actions actions = new Actions(MainRunner.driver);

    public void doubleClick(WebElement element)
    {
        actions.doubleClick(element);
        actions.build().perform();
    }

    public void openinNewTab(String url)
    {


    }


}
