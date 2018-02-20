package csc.learning.project.stepDefinitions;

import csc.learning.project.shared.Interactions;
import csc.learning.project.shared.MainRunner;
import csc.learning.project.shared.WebDriverHandling;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by cchandragiri on 4/18/2017.
 */
public class stepDefinition {
    WebDriverHandling wh = new WebDriverHandling();
    WebDriver driver = wh.getDriverInstance("firefox");
    static Logger log = Logger.getLogger(MainRunner.class.getName());
    private ArrayList<HashMap> flights_from_to;
    private ArrayList<HashMap> flights_to_from;
    private List<WebElement> listViewElements;

    // BSNL CODE

    @Then("^I should see page title as below$")
    public void i_should_see_page_title_as_below(DataTable title) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        driver.findElement(By.xpath(".//p[text()='AndhraPradesh']")).click();
        log.info("Passed Argument from Feature: " + title.raw().get(0).get(1));
        throw new PendingException();
    }

    @Then("^I should see slider$")
    public void i_should_see_slider() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I move slider$")
    public void i_move_slider() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    // BSNL

    @Given("^I select \"([^\"]*)\" movie and date \"([^\"]*)\" to watch$")
    public void i_select_movie_to_watch(String movie_watch, String date_to_watch) throws Throwable {
        log.info("Movie to watch :-" + movie_watch);
        log.info("Date of to watch :-" + date_to_watch);
        WebElement all_drop_downs = driver.findElement(By.xpath(".//*[@id='btn-dd-search']"));
        waitinstance().until(ExpectedConditions.visibilityOf(driver.findElement(By.className("icon-type"))));
        Actions act = new Actions(driver);
        act.moveToElement(all_drop_downs);
        WebElement movies = driver.findElement(By.linkText("Movies"));
        act.moveToElement(movies);
        act.click(movies);
        act.build();
        act.perform();
    }

    @Then("^I should see list of theatres showing movie$")
    public void i_should_see_list_of_theatres_showing_movie() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I select \"([^\"]*)\" to watch$")
    public void i_select_to_watch(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I select \"([^\"]*)\" to watch from available shows$")
    public void i_select_to_watch_from_available_shows(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should see availability of tickets$")
    public void i_should_see_availability_of_tickets() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^select adult \"([^\"]*)\" children \"([^\"]*)\" tickets$")
    public void select_adult_children_tickets(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I navigated to home page$")
    public void i_navigated_to_home_page() throws Throwable {
        wh.navigate();
        log.info("Navigate to Site " + System.getProperty("website"));
    }

    @When("^I select round trip on home page$")
    public void i_select_round_trip_on_home_page() throws Throwable {
        driver.findElement(By.id("RoundTrip")).click();
    }

    @When("^I select from \"([^\"]*)\" location$")
    public void i_select_from_location(String from_location) throws Throwable {
        driver.findElement(By.id("FromTag")).sendKeys(from_location);
    }

    @When("^I select to \"([^\"]*)\" location$")
    public void i_select_to_location(String to_location) throws Throwable {
        driver.findElement(By.id("ToTag")).sendKeys(to_location);
    }

    @When("^I select depart \"([^\"]*)\" date$")
    public void i_select_depart_date(String dapart_date) throws Throwable {
        driver.findElement(By.id("DepartDate")).sendKeys(dapart_date);
    }

    public void select_date(String date) {
        String[] parts = date.split("/");
        String day = parts[1];
        String month = parts[0];
        String year = parts[2];

    }

    @When("^I select return \"([^\"]*)\" date$")
    public void i_select_return_date(String return_date) throws Throwable {
        driver.findElement(By.id("ReturnDate")).sendKeys(return_date);
    }

    @When("^I select adult \"([^\"]*)\" count$")
    public void i_select_adult_count(String adult_count) throws Throwable {
        selectElement(adult_count, "Adults");
    }

    public void selectElement(String value_to_select, String id) {
        Select dropDown = new Select(driver.findElement(By.id(id)));
        dropDown.

                selectByVisibleText(value_to_select);
    }


    @When("^I select children \"([^\"]*)\" count$")
    public void i_select_children_count(String children_count) throws Throwable {
        selectElement(children_count, "Childrens");
    }

    @When("^I select infant \"([^\"]*)\" count$")
    public void i_select_infant_count(String infant_count) throws Throwable {
        selectElement(infant_count, "Infants");
    }


    @When("^I select search flights button$")
    public void i_select_search_flights_button() throws Throwable {
        driver.findElement(By.id("SearchBtn")).click();
        waitinstance().until(ExpectedConditions.titleContains("Cleartrip | "));
        System.out.println("Title of Page :-" + driver.getTitle());
        System.out.println("Current URL :-" + driver.getCurrentUrl());
    }

    public WebDriverWait waitinstance() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait;
    }


    @Then("^I should see list of planes available$")
    public void i_should_see_list_of_planes_available() throws Throwable {
        Thread.sleep(20000);
        waitinstance().until(ExpectedConditions.invisibilityOfElementLocated(By.className("updatingModal")));
        waitinstance().until(ExpectedConditions.presenceOfElementLocated(By.className("comboFares")));
        List<WebElement> elements = driver.findElements(By.className("resultsContainer"));
        listViewElements = elements.get(1).findElements(By.className("listViewNav"));
        System.out.println(listViewElements.size());
        System.out.println("Started");
        flights_from_to = getFlightDetails(listViewElements.get(0));
        flights_to_from = getFlightDetails(listViewElements.get(1));
        System.out.println("From To List " + flights_from_to);
        System.out.println("To From List " + flights_to_from);
    }

    public ArrayList<HashMap> getFlightDetails(WebElement element) {
        ArrayList<HashMap> values = new ArrayList<HashMap>();
        List<WebElement> table_count = element.findElements(By.className("listItem"));
        System.out.println("List Items count " + table_count);
        for (int row = 1; row <= table_count.size(); row++) {
            HashMap hm = new HashMap();
            String airline = table_count.get(row - 1).findElement(By.className("truncate")).getText();
            String depart_time = table_count.get(row - 1).findElement(By.className("depart")).getText();
            String arrival_time = table_count.get(row - 1).findElement(By.className("arrive")).getText();
            String duration = table_count.get(row - 1).findElement(By.className("duration")).getText();
            String price = table_count.get(row - 1).getAttribute("data-price");
            hm.put("airline", airline);
            hm.put("depart_time", depart_time);
            hm.put("arrival_time", arrival_time);
            hm.put("duration", duration);
            hm.put("price", price);
            values.add(hm);
        }
        return values;
    }

//    String airline = table_count.get(row-1).findElement(By.xpath("//div/label/table/tbody/tr[2]/td[1]/span")).getText();
//    String depart_time = table_count.get(row-1).findElement(By.xpath("//div/label/table/tbody/tr[1]/th[3]")).getText();
//    String arrival_time = table_count.get(row-1).findElement(By.xpath("//div/label/table/tbody/tr[1]/th[4]")).getText();
//    String duration = table_count.get(row-1).findElement(By.xpath("//div/label/table/tbody/tr[1]/th[5]")).getText();


    @When("^I select second highest fares for both from and to$")
    public void i_select_second_highest_fares_for_both_from_and_to() throws Throwable {
        // int index = flightIndexToSelect("from_to", "SpiceJet SG-126", "21:25", "Rs.14,436");
        int from_index = flightIndexToSelect("from_to");
        System.out.println("Index from select: " + from_index);
        WebElement flight_to_select = listViewElements.get(0).findElements(By.className("listItem")).get(from_index);
        flight_to_select.findElement(By.className("action")).click();
        int to_index = flightIndexToSelect("to_from");
        System.out.println("Index to select: " + to_index);
        flight_to_select = listViewElements.get(1).findElements(By.className("listItem")).get(to_index);
        flight_to_select.findElement(By.className("action")).click();
        Thread.sleep(5000);
        Actions act = new Actions(driver).sendKeys(Keys.ENTER);
        act.perform();
    }

    public int flightIndexToSelect(String trip, String airline, String depart_time, String price) {
        ArrayList<HashMap> use;
        Integer index = 0;
        if (trip.equals("from_to")) {
            use = flights_from_to;
        } else {
            use = flights_to_from;
        }
        for (HashMap<String, String> map : use) {
            for (Map.Entry<String, String> mapEntry : map.entrySet()) {
                String key = mapEntry.getKey();
                String value = mapEntry.getValue();
                if (map.get("airline").equals(airline) && map.get("depart_time").equals(depart_time) && map.get("price").equals(price)) {
                    index = use.indexOf(map);
                }
            }
        }
        return index;
    }


    public int flightIndexToSelect(String trip) {
        ArrayList<HashMap> use;
        int v = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (trip.equals("from_to")) {
            use = flights_from_to;
        } else {
            use = flights_to_from;
        }
        for (int i = 0; i < use.size(); i++) {
            v = Integer.parseInt(use.get(i).get("price").toString());
            list.add(v);
        }
        list = sort_array(list);
        v = list.indexOf(getNthBestPrice(list, "max"));
        return v;
    }


    public Integer getNthBestPrice(ArrayList<Integer> list, String type) {

        int min = list.get(0);
        if (type.equals("min")) {
            return min;
        }

        int price = min;
        int max = list.get(list.size() - 1);
        if (type.equals("max")) {
            return max;
        }

        for (int i = 0; i < list.size(); i++) {
            if (price < list.get(i)) {
                price = list.get(i);
                break;
            }

        }
        return price;
    }


//    public Integer getValueFromHashset(ArrayList<Integer> ae, Integer xbestPrice)
//    {
//      HashSet<Integer> hs =  new HashSet<>();
//      int value = 0;
//      for(int i=0; i > ae.size(); i++)
//      {
//          hs.add(ae.get(i));
//      }
//
//      value = hs.size()-xbestPrice;
//      return xbestPrice;
//    }

    public ArrayList<Integer> sort_array(ArrayList<Integer> inte) {
        ArrayList<Integer> ae = new ArrayList<>();
        Integer min = inte.get(0);
        Integer temp = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < inte.size(); i++) {
            a = inte.get(i);
            for (int j = i + 1; j < inte.size(); j++) {
                b = inte.get(j);
                if (a > b) {
                    temp = a;
                    a = b;
                    b = temp;
                }
            }
            ae.add(a);
        }
        System.out.println(ae);
        return ae;
    }


    @Then("^I should be navigate to itinerary page with selected flight details$")
    public void i_should_be_navigate_to_itinerary_page_with_selected_flight_details() throws Throwable {
        Thread.sleep(10000);
        String title = driver.getTitle();
        Assert.assertEquals(title, "Cleartrip | Book your flight securely in simple steps");
    }


    // ERAIL APPLICATION

    @When("^I search \"([^\"]*)\" to \"([^\"]*)\" trains list$")
    public void i_search_to_trains_list(String from_location, String to_location) throws Throwable {
        WebElement from = driver.findElement(By.id("txtStationFrom"));
        Interactions inte = new Interactions();
        inte.doubleClick(from);
        from.sendKeys(from_location);
        WebElement to = driver.findElement(By.id("txtStationTo"));
        inte.doubleClick(to);
        driver.findElement(By.id("buttonFromTo")).click();
    }

    @Then("^I should see list of trains available$")
    public void i_should_see_list_of_trains_available() throws Throwable {
        log.info("Next time");
    }

    @When("^I select \"([^\"]*)\" of travel with \"([^\"]*)\" type$")
    public void i_select_of_travel_with_type(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        log.info("Next time");
    }


    // Hanu

    @Given("^I navigate to home page$")
    public void iNavigateToHomePage() throws Throwable {
        wh.navigate();
        log.info("Navigate to home page of URL " + driver.getCurrentUrl());
    }

    @When("^I select \"([^\"]*)\" on page$")
    public void iSelectOnPage(String arg0) throws Throwable {
        List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
        log.info("Total links available on page " + totalLinks.size());
        String primaryWindow = driver.getWindowHandle();//Return a string of alphanumeric window handleString  secondWindow= driver.getWindowHandle();
        String url = driver.getCurrentUrl();
        String linkHrefValue = "";
        String secondwindowTitle = "";
        String secondwindowURL = "";
        for (WebElement e : totalLinks) {
            log.info("Switched to primary window....");
                int windowsCount = 0;
                try {
                    try {
                        linkHrefValue = e.getAttribute("href");
                    }catch (StaleElementReferenceException ste) {
                        log.info("Trying one more time");
                        e.getAttribute("href");
                    }String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
                    e.sendKeys(selectLinkOpeninNewTab);
                    windowsCount = driver.getWindowHandles().size();
                    log.info(driver.getWindowHandles().size());
                    for (String winHandle : driver.getWindowHandles()) {
                        driver.switchTo().window(winHandle);
                    }
                secondwindowTitle = driver.getTitle();
                secondwindowURL = driver.getCurrentUrl();
                if (windowsCount == 2) {
                    driver.close();
                    Thread.sleep(2000);
                    driver.switchTo().window(primaryWindow);
                } else {
                    driver.navigate().back();
                    Thread.sleep(1000);
                }
                log.info("Second window Title " + secondwindowTitle);
                log.info("Second window URL " + secondwindowURL);
                log.info("Click action performed on link");
            }catch (Exception exe){

            }
        }

    }

    @Then("^I should navigate to page$")
    public void iShouldNavigateToPage() throws Throwable {
        log.info("will do");
    }
}
